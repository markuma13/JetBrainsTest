package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static com.example.jetbrainstest.MyWait.myWait;

public class GoogleChromeExistationPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(GoogleChromeExistationPage.class));

    @FindBy(css = "button.UywwFc-LgbsSe")
    private WebElement installExistationButton;
    public void clickInstallExistationButton(){
        installExistationButton.click();
    }
    public Boolean installExistationButtonIsClickable(){
        return installExistationButton.isDisplayed();
    }
    public void dismiss(){
        myWait(10).alertIsPresented();
        LOG.info("Закрыть алерт окно");
        driver.switchTo().alert().dismiss();
    }
    @FindBy(css = "summary.dhB8g")
    private WebElement googleMailList;
    public void unfurlGoogleMailList(){
        LOG.info("Раскрыть почту google");
        googleMailList.click();
    }
    @FindBy(css = "div.yNyGQd")
    private WebElement supportMailBlock;
    public Boolean supportMailIsDisplayed(){
        myWait(10).visible(supportMailBlock);
        LOG.info("Отображение почты google");
        return supportMailBlock.isDisplayed();
    }
    public GoogleChromeExistationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
