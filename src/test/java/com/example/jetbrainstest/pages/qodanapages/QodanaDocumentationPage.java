package com.example.jetbrainstest.pages.qodanapages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class QodanaDocumentationPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(QodanaDocumentationPage.class));

    WebDriver driver;

    @FindBy(xpath = "//*[text()='Yes']")
    private WebElement YesButton;

    @FindBy(xpath = "//*[text()='No']")
    private WebElement NoButton;

    @FindBy(xpath = "//*[text()='Send feedback']")
    private WebElement SendFeedbackButton;

    @FindBy(xpath = "//*[@class='feedback__text']")
    private WebElement messageAfterClickYes;

    @FindBy(xpath = "//textarea[@name='content']")
    private WebElement contentTextArea;

    public QodanaDocumentationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String feedbackMessageAfterYesClick() {
        driver.navigate().refresh();
        YesButton.click();
        LOG.info("Появляется текст \"Thanks for your feedback!\"");
        return messageAfterClickYes.getText();
    }






}
