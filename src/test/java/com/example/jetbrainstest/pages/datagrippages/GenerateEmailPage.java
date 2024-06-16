package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static com.example.jetbrainstest.MyWait.myWait;

/**
 * URL страницы генерации email &lt;a href=<a href="https://tempail.com/ru/">...</a>!
 * Конструктор GenerateEmailPage
 * Автор @markuma13
 */
public class GenerateEmailPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));


    @FindBy(xpath = "//input[@type='email']")
    public WebElement copiedEmail;
    @FindBy(xpath = "//h2[contains(@class,'text-2xl font-bold')]")
    private WebElement getTextmessage;

    public GenerateEmailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

    public void copiedButtonEmail() {
        driver.get("https://mail.tm/ru/");
        LOG.info("Открытие страницы генерации Email");
        myWait(10).waitSoon(3);
        copiedEmail.click();
        LOG.info("Копирование сгенерированного Email");
    }

    public void messageCheckDataGrip() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//div[@class='truncate text-sm leading-5 text-gray-900 dark:text-gray-300']")));
            message.click();
            LOG.info("Открытие полученного письма");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String checkGetTextEmailMessage() {
        LOG.infoWithScreenshot("Получение названия сообщения Email DataGrip");
        return getTextmessage.getText();
    }

    public void openPageInNewTag() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open();");
            String originalTab = driver.getWindowHandle();
            for (String tab : driver.getWindowHandles()) {
                if (!tab.equals(originalTab)) {
                    driver.switchTo().window(tab);
                    LOG.info("Открыта новая вкладка");
                    return;
                }
            }
            throw new NoSuchElementException("Новая вкладка не была найдена");
        } catch (NoSuchElementException e) {
            LOG.error("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            LOG.error("Произошла ошибка: " + e.getMessage());
        }
    }

    public void tabBack() {
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }

    public void switchToTab(int tabIndex) {
        Set<String> tabs = driver.getWindowHandles();
        int tabCount = tabs.size();

        if (tabCount >= tabIndex) {
            String tabToSwitch = (String) tabs.toArray()[tabIndex - 1];
            driver.switchTo().window(tabToSwitch);
        } else {
            System.out.println("Запрошенной вкладки не существует");
        }
    }

    public static String getClipboardText() throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }

}
