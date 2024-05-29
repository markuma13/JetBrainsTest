package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class ScalaPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ScalaPage.class));
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(text(),'Get')]")
    private WebElement getButton;
    @FindBy(xpath = "//*[contains(text(),'Versions')]")
    private WebElement versions;
    @FindBy(xpath = "//*[contains(text(),'Show More')]")
    private WebElement showMore;

    public Boolean checkIfGetButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        wait.until(ExpectedConditions.visibilityOfAllElements(getButton));
        return getButton.isEnabled();
    }

    public Boolean findButtonShowMore() {
        LOG.info("Проверка наличия кнопки 'Show More'");
        versions.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(showMore));
        return showMore.isDisplayed();
    }

    public ScalaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
}
