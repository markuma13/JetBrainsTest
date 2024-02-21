package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.clionpages.CLionDownloadPage;
import com.example.jetbrainstest.pages.qodanapages.QodanaDocumentationPage;
import com.example.jetbrainstest.pages.qodanapages.QodanaPage;
import com.example.jetbrainstest.pages.qodanapages.QodanaPricingPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class QodanaTest extends BaseTest{
    private QodanaPage QoPage;
    private QodanaPricingPage QoPricingPage;

    private QodanaDocumentationPage QoDocPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/qodana/");
        QoPage = new QodanaPage(getDriver());
        QoPricingPage = new QodanaPricingPage(getDriver());
        QoDocPage = new QodanaDocumentationPage(getDriver());
        System.out.println("Начало проверки:");
    }
    @AfterEach
    public void tearDown(){
        super.tearDown();
        System.out.println("Проверка окончена");
    }

    @Test
    @DisplayName("Проверка активности кнопки Documentation")
    public void  DocumentationButtonTest(){
        assertTrue(QoPage.checkIfDocumentationButtonIsClickable(),"Кнопка Documentation неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Blog")
    public void  BlogButtonTest(){
        assertTrue(QoPage.checkIfBlogButtonIsClickable(),"Кнопка Blog неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Request Demo")
    public void  RequestDemoButtonTest(){
        assertTrue(QoPage.checkIfRequestDemoButtonIsClickable(),"Кнопка Request Demo неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Pricing")
    public void  PricingButtonTest(){
        assertTrue(QoPage.checkIfPricingButtonIsClickable(),"Кнопка Pricing неактивна");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Try For Free в меню")
    public void  checkIfTryForFreeButton1IsClickable(){
        assertTrue(QoPage.checkIfTryForFreeButton1IsClickable(),"Кнопка Try For Free неактивна");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Try For Free на странице")
    public void  checkIfTryForFreeButton2IsClickable(){
        assertTrue(QoPage.checkIfTryForFreeButton2IsClickable(),"Кнопка Try For Free неактивна");
    }

    @Test
    @DisplayName("Переход на страницу Request a demo")
    public void RequestDemoButtonClickTest(){
        QoPage.requestDemoButtonClick();
        assertEquals("https://www.jetbrains.com/qodana/request-a-demo/", getDriver().getCurrentUrl(), "Переход на страницу Request a demo не осуществлен");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Get custom Qodana plan на странице")
    public void  checkIfGetCustomQodanaPlanButtonIsClickable(){
        QoPage.PricingButtonClick();
        assertEquals("https://www.jetbrains.com/qodana/buy/?billing=yearly", getDriver().getCurrentUrl(), "Переход на страницу Pricing не осуществлен");
        assertTrue(QoPricingPage.checkIfGetCustomQodanaPlanButtonIsClickable(),"Кнопка Get custom Qodana plan неактивна");
    }

    @Test
    @DisplayName("Валидация полей в модальном окне Get a custom Qodana plan")
    public void  enterEmptyFieldTest(){
        QoPage.PricingButtonClick();
        assertEquals("https://www.jetbrains.com/qodana/buy/?billing=yearly", getDriver().getCurrentUrl(), "Переход на страницу Pricing не осуществлен");
        QoPricingPage.GetCustomQodanaPlanButtonClick();
        String warningResponse = QoPricingPage.SubmitRequestButtonClickWithoutEntering();
        assertEquals(warningResponse, "This field is required.", "Текст сообщения некорректен");
    }

    @Test
    @DisplayName("Переход на страницу Documentation")
    public void DocumentationClickTest(){
        QoPage.documentationButtonClick();
        assertEquals("https://www.jetbrains.com/help/qodana/getting-started.html", getDriver().getCurrentUrl(), "Переход на страницу Documentation не осуществлен");
    }

    @Test
    @DisplayName("Переход на страницу Pricing")
    public void PricingClickTest(){
        QoPage.PricingButtonClick();
        assertEquals("https://www.jetbrains.com/qodana/buy/?billing=yearly", getDriver().getCurrentUrl(), "Переход на страницу Pricing не осуществлен");
    }

    @Test
    @DisplayName("Переход на страницу Blog")
    public void BlogClickTest(){
        QoPage.blogButtonClick();
        assertEquals("https://blog.jetbrains.com/qodana/", getDriver().getCurrentUrl(), "Переход на страницу Blog не осуществлен");
    }

    @Test
    @DisplayName("Благодарственное сообщение после клика Yes")
    public void  goodFeedbackTest(){
        QoPage.documentationButtonClick();
        assertEquals("https://www.jetbrains.com/help/qodana/getting-started.html", getDriver().getCurrentUrl(), "Переход на страницу Documentation не осуществлен");
        QoDocPage.feedbackMessageAfterYesClick();
        String feedbackResponse = QoDocPage.feedbackMessageAfterYesClick();
        assertEquals(feedbackResponse, "Thanks for your feedback!", "Текст сообщения некорректен");
    }

}
