package com.example.jetbrainstest.pages.qodanapages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class QodanaPricingPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(QodanaPricingPage.class));

    WebDriver driver;

    @FindBy(xpath = "//*[text()='Get custom Qodana plan']")
    private WebElement GetCustomQodanaPlanButton;

    @FindBy(xpath = "//*[text()='Submit Request']")
    private WebElement SubmitRequestButton;

    @FindBy(xpath = "(//*[@data-test='input'])[1]")
    private WebElement firstNameInput;

    @FindBy(xpath = "(//*[@data-test='input'])[2]")
    private WebElement businessEmailInput;

    @FindBy(xpath = "//*[text()='Team size']")
    private WebElement teamSizeField;

    @FindBy(css = "[data-test=\"error-message\"]")
    private WebElement messageAfterClickWithoutEntering;

    public QodanaPricingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfGetCustomQodanaPlanButtonIsClickable() {
        LOG.infoWithScreenshot("Проверка кликабельности кнопки Get custom Qodana plan");
        return GetCustomQodanaPlanButton.isEnabled();
    }

    public void GetCustomQodanaPlanButtonClick() {
        GetCustomQodanaPlanButton.click();
        LOG.infoWithScreenshot("Переход в модальное окно Get a custom Qodana plan");
    }

    public String SubmitRequestButtonClickWithoutEntering() {
        SubmitRequestButton.click();
        LOG.info("Под полями появляется текст \"This field is required.\"");
        return messageAfterClickWithoutEntering.getText();
    }

}
