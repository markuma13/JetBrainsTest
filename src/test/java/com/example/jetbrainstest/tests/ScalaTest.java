package com.example.jetbrainstest.tests;


import com.example.jetbrainstest.pages.ScalaPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScalaTest extends BaseTest {
    private ScalaPage scalaPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://plugins.jetbrains.com/plugin/1347-scala");
        scalaPage = new ScalaPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(scalaPage.checkIfGetButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка наличия кнопки Show More")
    public void scalaPagefindButtonShowMore() {
        assertTrue(scalaPage.findButtonShowMore(), "кнопка" + "Show More" + "не найдена");
    }
}
