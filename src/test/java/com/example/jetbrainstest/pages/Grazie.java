package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureAttachmentsManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Grazie  {
    private final Logger LOG = LoggerFactory.getLogger(Grazie.class);
    WebDriver driver;

    @FindBy(css = "[aria-label='Play video']")
    private WebElement playVideoButton;

    @FindBy(css = "[href='/ai/#plans-and-pricing']")
    private WebElement tafifButton;

    public Boolean checkIfPlayVideoButtonIsClickable() {
        LOG.info("Проверка активности кнопки запуска видео");
        return playVideoButton.isEnabled();
    }

    public Grazie(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tafifButtonClick() {
        LOG.info("Перешли на страницу тарифа");
        tafifButton.click();
    }

    public void switchToStoreTab(int num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num - 1));
    }
}
