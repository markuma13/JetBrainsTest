package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static com.example.jetbrainstest.MyWait.myWait;

//https://www.jetbrains.com/toolbox-app/
public class ToolBoxAppPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxAppPage.class));
    WebDriver driver;

    @FindBy(css = "button[data-test='submit-button']")
    private WebElement submitButton;
    public void clickSubmitButton(){
        submitButton.click();
        LOG.info("Нажали на кнопку \"Submit\"");
    }
    @FindBy(css = "input[name = 'email']")
    private WebElement inputEmail;
    public void setMailText(String emailText){
        inputEmail.sendKeys(emailText);
        LOG.info("В поле Email передано значение " + emailText);
    }
    @FindBy(css = "div[data-test='input__error-message']")
    private static WebElement validMessage;
    public static WebElement getValidMessage(){
        return validMessage;
    }
    public Boolean checkIfValidMessageIsDisplayed(){
        LOG.infoWithScreenshot("Проверка, что валидация отобразилась");
        return validMessage.isDisplayed();
    }
    public Boolean checkIfSubmitButtonIsEnable(){
        LOG.info("!Проверка активности кнопки отправки!");
        return submitButton.isEnabled();
    }
    @FindBy(css = "ul[data-test='dropdown-menu']")
    private WebElement dropDownMenu;

    @Step("!Проверка, что появилось дропдаун меню!")
    public Boolean checkIfDropDownMenuIsDisplayed(){
        LOG.infoWithScreenshot("!Проверка, что появилось дропдаун меню!");
        return dropDownMenu.isDisplayed();
    }
    @FindBy(css = ".scroll-wrapper button")
    private WebElement dropDownMenuButton;

    public void clickDropDownMenuButton(){
        dropDownMenuButton.click();
        LOG.info("Нажати на кнопку .exe");
    }
    @FindBy(css = ".toolbox-heading a[data-test = 'dropdown-button-link']")
    private WebElement downloadButton;
    public void clickDownloadButton(){
        downloadButton.click();
        LOG.info("Нажали на 1-ю кнопку download");
    }
    @FindBy(xpath = "//*[ text() = 'FAQ & Shortcuts' ]")
    private WebElement faqReference;
    public void faqRefClick(){
        faqReference.click();
        LOG.info("Нажали на ссылку FAQ & Shortcuts");
    }
    @FindBy(xpath = "//*[ text() = 'Blog & Social' ]")
    private WebElement blogSocialRef;
    public void blogSocialRefCLick(){
        blogSocialRef.click();
        LOG.info("Нажали на Blog & Social");
    }
    @FindBy(xpath = "//a[text() ='Other versions']")
    private WebElement otherVersioLink;
    public void otherVersioLinkClick() {
        LOG.info("Нажали на ссылку Other versions");
        otherVersioLink.click();
    }
    @FindBy(css = "div.toolbox-heading span[class= 'wt-link']")
    private WebElement systemReqFirstRef;

    @FindBy(css = "div[role = 'dialog']")
    private WebElement systemReqPopup;

    public void clickSystemReqFirstRef(){
        LOG.info("Нажали на ссылку System requirements");
        systemReqFirstRef.click();
    }
    public Boolean checkIfSystemReqPopupDisplayed(){
        myWait(10).visible(systemReqPopup);
        LOG.info("Проверка отображения попап окна System requirements");
        return systemReqPopup.isDisplayed();
    }
    @FindBy(css = "div.toolbox-primary-colors p.rs-text-2")
    private WebElement messageAfterSuccesfulEmailSubmit;
    public Boolean getMessageAfterSuccesfulEmailSubmit(){
        myWait(20).visible(messageAfterSuccesfulEmailSubmit);
        return messageAfterSuccesfulEmailSubmit.isDisplayed();
    }
    @FindBy(xpath = "//div[text() = 'This field is required']")
    private WebElement messageAboutRequiredEmailField;
    public Boolean messageAboutRequiredEmailFieldIsDisplayed(){
        LOG.infoWithScreenshot("Поле ввода email не должно быть пустым");
        return messageAboutRequiredEmailField.isDisplayed();
    }
    @FindBy(xpath = "//a[text() = 'Google Chrome']")
    private WebElement googleChromeExistationRef;
    public void googleChromeExistationRefClick(){
        googleChromeExistationRef.click();
        LOG.info("Была нажата ссылка GoogleChrome");
    }
    @FindBy(xpath = "//a[text() = 'Firefox']")
    private WebElement firefoxRef;
    public void firefoxRefClick(){
        firefoxRef.click();
    }
    @FindBy (xpath = "//a[text() = 'JetBrains Privacy Policy']")
    private WebElement jetBrainsPrivacyPolicyLink;
    public  void jetBrainsPrivacyPolicyLinkClick(){
        jetBrainsPrivacyPolicyLink.click();
        ArrayList tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

    }
    @FindBy(css =".wt-subtitle-2.wt-subtitle-2_theme_light.wt-offset-top-24 ~ div.wt-offset-top-48.jb-button-with-note.jb-text-md-left a")
    private WebElement secondDownloadButton;
    public void secondDownloadButtonClick(){
        secondDownloadButton.click();
    }
    @FindBy(css = ".wt-subtitle-2.wt-subtitle-2_theme_light.wt-offset-top-24 ~ div.wt-offset-top-48.jb-button-with-note.jb-text-md-left button")
    private WebElement secondExeButton;
    public void secondExeButtonClick(){
        secondExeButton.click();
    }
    @FindBy(css = ".wt-subtitle-2.wt-subtitle-2_theme_light.wt-offset-top-24 ~ div.wt-offset-top-48.jb-button-with-note.jb-text-md-left span[data-test=\"list-item\"]")
    private WebElement secondSystemReqLink;
    public void secondSystemReqLinkClick(){
        secondSystemReqLink.click();
    }
    @FindBy(css =".wt-text-2.wt-text-2_theme_light.wt-offset-top-24")
    private WebElement author;
    public String getAthorDetails(){
        return author.getText();
    }

    public ToolBoxAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
