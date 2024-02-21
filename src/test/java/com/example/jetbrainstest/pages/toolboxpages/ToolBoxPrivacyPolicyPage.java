package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolBoxPrivacyPolicyPage {
    WebDriver driver;

    AllureLogger LOG = new AllureLogger(org.slf4j.LoggerFactory.getLogger(ToolBoxPrivacyPolicyPage.class));
    @FindBy(css = "#jetbrains-privacy-policy strong")
    private WebElement privacySummary;

    public Boolean privacySummaryIsDisplayed(){
       return privacySummary.isDisplayed();
    }
    public ToolBoxPrivacyPolicyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
