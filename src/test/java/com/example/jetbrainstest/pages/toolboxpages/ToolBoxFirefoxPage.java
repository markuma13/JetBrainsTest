package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ToolBoxFirefoxPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxFirefoxPage.class));
    public String getTitleText() {
        LOG.info("В заголовке текст: " + driver.getTitle());
        return driver.getTitle();
    }

    public ToolBoxFirefoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
