package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ToolBoxDownloadPage {
    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxDownloadPage.class));
    @FindBy(css = "h1.rs-h1")
    private WebElement downloadTitle;
    public String getDownloadTitleText(){
        LOG.info("В заголовке страницы загрузки текст " + downloadTitle.getText());
        return downloadTitle.getText();
    }
    public ToolBoxDownloadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
