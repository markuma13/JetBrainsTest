package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ToolBoxFAQShortcutsPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxFAQShortcutsPage.class));
    WebDriver driver;
    @FindBy(css = ".wt-accordion__container.wt-offset-top-24")
    private WebElement faq;

    public Boolean faqIsDisplayed() {
        LOG.info("Проверка отображения блока с обязательными вопросами");
        return faq.isDisplayed();
    }

    public ToolBoxFAQShortcutsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
