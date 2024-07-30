package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.pages.AllProductsPage;
import com.example.jetbrainstest.pages.FleetPage;
import com.example.jetbrainstest.pages.Grazie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static java.sql.DriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrazieTest extends BaseTest {

    private Grazie Grazie;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/grazie/");
        Grazie = new Grazie(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка видео активна")
    public void checkIfPlayVideoButtonIsClickable() {
        assertTrue(Grazie.checkIfPlayVideoButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка перехода на страницу тарифа при покупке")
    public void urlBuyButtonCheck() {
        Grazie.tafifButtonClick();
        Grazie.switchToStoreTab(1);
        assertEquals("https://www.jetbrains.com/ai/#plans-and-pricing", getDriver().getCurrentUrl(), "Открылась некорректная ссылка");

    }

}
