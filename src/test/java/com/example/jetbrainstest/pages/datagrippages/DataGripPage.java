package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/**
 * URL страницы <a href="https://www.jetbrains.com/datagrip/"/</a>
 * Конструктор DataGripPage
 * Автор @markuma13
 */
public class DataGripPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy(xpath = "(//a[@href='/datagrip/download/'])[2]")
    private WebElement downloadDataGripButton;
    @FindBy(xpath = "//button[text()='Take a tour']")
    private WebElement clickTakeATourButton;
    @FindBy(xpath = "//button[normalize-space()='.exe']")
    private WebElement downloadListResult;
    @FindBy(xpath = "//div[@data-focus-lock-disabled='false']")
    private List<WebElement> resultsComboBox;
    @FindBy(xpath = "//button[@data-test='youtube-player-button']")
    private WebElement clickVideo;
    @FindBy(xpath = "//button[@data-test='close-button']")
    private WebElement closeVideoButton;
    @FindBy(xpath = "//a[normalize-space()='Discover all features']")
    private WebElement discoverAllFeaturesButton;
    @FindBy(xpath = "//span[normalize-space()='.exe (Windows)']")
    private WebElement exeWindows;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement fieldEmail;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement buttonSubmit;
    @FindBy(css = "[data-test=\"error-message\"]")
    public WebElement messageEnteringInvalidEmail;
    @FindBy(xpath = "//p[text()='Tell me about new product features as they come out']/following-sibling::p")
    public WebElement messageEnteringValidEmail;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M15 8a7 7 ')]")
    public WebElement moveTooltipElement;
    @FindBy(xpath = "//span[normalize-space()='View sample newsletter']")
    private WebElement linkTextVSN;
    @FindBy(xpath = "//p[contains(text(),'For DataGrip 2023.1, we focused entirely on qualit')]")
    private WebElement getTextViewSample;
    @FindBy(css = "img[height='325']")
    private WebElement imgDataGripRelease;
    @FindBy(css = "div[id='js-menu-second'] a:nth-child(7)")
    private WebElement downloadButtonCap;
    @FindBy(xpath = "(//a[@href='/datagrip/buy/'])[2]")
    private WebElement pricingButtonCap;

    public DataGripPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getComboBoxes() {
        downloadListResult.click();
        List<WebElement> comboBoxes = resultsComboBox;
        for (WebElement comboBox : comboBoxes) {
            LOG.infoWithScreenshot("ComboBox DataGrip button download: " + comboBox.getText());
        }
        return comboBoxes;
    }

    public void clickImgDataGripRelease() {
        imgDataGripRelease.click();
        LOG.info("Клик по изоброжению на странице релиза");
    }

    public void clickButtonDataGripDownload() {
        downloadDataGripButton.click();
        LOG.infoWithScreenshot("Клик кнопки загрузки DataGripPage");
    }

    public void clickButtonTakeATour() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");
        clickTakeATourButton.click();
        LOG.info("Клик кнопки TakeATour");
    }

    public boolean checkTakeATourButton() {
        LOG.info("Проверка активности кнопки");
        return clickTakeATourButton.isEnabled();
    }

    public Boolean checkIfDownloadButtonIsClickableCap() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButtonCap.isEnabled();
    }

    public Boolean checkIfPricingButtonIsClickableCap() {
        LOG.info("Проверка активности кнопки Pricing");
        return pricingButtonCap.isEnabled();
    }

    public void clickPricingButton() {
        pricingButtonCap.click();
        LOG.info("Клик на кнопку Pricing");
    }

    public void clickLinkTextVSN() {
        linkTextVSN.click();
        LOG.info("Клик по тексту View sample newsletter");
    }

    public String checkGetTextViewSampleOpen() {
        LOG.info("Проверка наличия текста");
        String value = getTextViewSample.getText();
        LOG.info("Получен текст: \"" + value + "\"");
        return value;
    }

    public boolean checkButtonExeWindowsComboBox() {
        LOG.infoWithScreenshot("Проверка активаности кнопки exe.Windows в чекбоксе");
        return exeWindows.isEnabled();
    }

    public void clickPlayAndStopPlayer() {
        clickVideo.click();
        LOG.info("Воспроизведение видео");
        waitSleep();
    }

    public boolean isPlayerClosed() {
        LOG.info("Закрытие плеера");
        return !closeVideoButton.isEnabled();
    }

    public void clickDiscoverButton() {
        discoverAllFeaturesButton.click();
        LOG.info("Клик на кнопку Discover all features");
    }

    public void enterEmail(String email) {
        LOG.info("Ввод email");
        fieldEmail.sendKeys(email);
        buttonSubmit.click();
    }

    public boolean isEmailEntered(String expectedEmail) {
        String enteredEmail = fieldEmail.getAttribute("value");
        LOG.infoWithScreenshot("Текущее значение веденного Email");
        return enteredEmail.equals(expectedEmail);
    }

    public String getTextEnteringEmail() {
        LOG.info("Получение названия сообщения после отправки Email");
        return messageEnteringValidEmail.getText();
    }

    public String enterInvalidEmailGetText(String email) {
        enterEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе не валидного email");
        return messageEnteringInvalidEmail.getText();
    }

    public void clickLinkPartyServices() {
        WebElement linkPartyServices = driver.findElement(By.xpath("//a[normalize-space()='third-party services']"));
        wait.until(ExpectedConditions.visibilityOf(moveTooltipElement));
        LOG.info("Прошли ожидание элементов");
        actions.moveToElement(moveTooltipElement).moveToElement(linkPartyServices).release().build().perform();
        actions.keyDown(Keys.CONTROL).click(linkPartyServices).keyUp(Keys.CONTROL).perform();
        linkPartyServices.click();
        LOG.info("Открытие страницы third-parties через Tooltip");
    }

    public void waitSleep() {
        new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void waitSoon(int waitTimeInSeconds) {
        try {
            Thread.sleep(waitTimeInSeconds * 1000L);
        } catch (InterruptedException e) {
            LOG.info("Ошибка ожидания: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}