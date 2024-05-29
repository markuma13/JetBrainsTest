package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://www.jetbrains.com/rust/
public class RustRoverPage
{
    private final Logger LOG = LoggerFactory.getLogger(RustRoverPage.class);
    WebDriver driver;
    @FindBy(css = "a[href='/rust/download/']")
    private WebElement downloadRustPreview;

    @Step ("Checking if URL changed after button has been clicked")
    public String clickRustDownloadAndCheckUrl(){
        LOG.info("Checking if URL changed after button has been clicked");
        driver.get("https://www.jetbrains.com/rust/");
        downloadRustPreview.click();
        return driver.getCurrentUrl();
    }
    public RustRoverPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
