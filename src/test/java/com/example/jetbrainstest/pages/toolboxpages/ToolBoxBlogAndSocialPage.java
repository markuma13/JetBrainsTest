package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;


//https://www.jetbrains.com/toolbox-app/social/
public class ToolBoxBlogAndSocialPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxBlogAndSocialPage.class));
    WebDriver driver;

    @FindBy(css = ".js-posts-list")
    private WebElement blogContent;
    public Boolean blogContentDisplayed(){
        LOG.info("Проверка отображения постов");
        return blogContent.isDisplayed();
    }
    public ToolBoxBlogAndSocialPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
