package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.toolboxpages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class ToolBoxAppTest extends BaseTest{
    private ToolBoxAppPage toolBoxAppPage;
    private ToolBoxFAQShortcutsPage toolBoxFAQShortcutsPage;
    private ToolBoxBlogAndSocialPage toolBoxBlogAndSocialPage;
    private ToolBoxOtherVersionPage1 toolBoxOtherVersionPage1;
    private ToolBoxDownloadPage toolBoxDownloadPage;
    private GoogleChromeExistationPage googleChromeExistationPage;
    private ToolBoxFirefoxPage toolBoxFirefoxPage;
    private  ToolBoxPrivacyPolicyPage toolBoxPrivacyPolicyPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/toolbox-app/");
        toolBoxAppPage = new ToolBoxAppPage(getDriver());
        toolBoxFAQShortcutsPage = new ToolBoxFAQShortcutsPage(getDriver());
        toolBoxBlogAndSocialPage = new ToolBoxBlogAndSocialPage(getDriver());
        toolBoxOtherVersionPage1 = new ToolBoxOtherVersionPage1(getDriver());
        toolBoxDownloadPage = new ToolBoxDownloadPage(getDriver());
        googleChromeExistationPage = new GoogleChromeExistationPage(getDriver());
        toolBoxFirefoxPage = new ToolBoxFirefoxPage(getDriver());
        toolBoxPrivacyPolicyPage = new ToolBoxPrivacyPolicyPage(getDriver());

    }

    @Test
    @Tag("1")
    @DisplayName("Проверка активности кнопки Submit")
    public void buttonCheck(){
        assertTrue(toolBoxAppPage.checkIfSubmitButtonIsEnable(), "Кнопка Submit не активна");
    }
    @Test
    @Tag("2")
    @DisplayName("Проверка ввода неправильного email")
    public void wrongEmailSubmit(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        toolBoxAppPage.setMailText("wrong");
        toolBoxAppPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOf((ToolBoxAppPage.getValidMessage())));
        assertTrue(toolBoxAppPage.checkIfValidMessageIsDisplayed(), "Валидационное сообщение не появилось");
    }

    @Test
    @Tag("3")
    @DisplayName("Проверка, что после нажатия на кнопку, появляется дропдаун меню")
    public void dropDownMenuShowed() {
        toolBoxAppPage.clickDropDownMenuButton();
        assertTrue(toolBoxAppPage.checkIfDropDownMenuIsDisplayed(),"Меню не появилось");
    }

    @Test
    @Tag("4_ТК3")
    @DisplayName("Проверка отображения блока, часто задаваемые вопросы")
    public void faqDisplayTest(){
        toolBoxAppPage.faqRefClick();
        assertTrue(toolBoxFAQShortcutsPage.faqIsDisplayed(), "Часто задаваемые вопросы не отобразились");
    }

    @Test
    @Tag("5_ТК4")
    @DisplayName("Проверка открытиея страницы Blog and Social")
    public void blogAndSocialDisp(){
        toolBoxAppPage.blogSocialRefCLick();
        assertTrue(toolBoxBlogAndSocialPage.blogContentDisplayed(), "Проверка отображения постов");
    }

    @Test
    @Tag("6_ТК1")
    @DisplayName("Проверка что в тайтле Other Versions - Toolbox")

    public void checkOtherVersionTitle(){
        String title = "Other Versions - Toolbox";
        toolBoxAppPage.otherVersioLinkClick();
        assertEquals(title, toolBoxOtherVersionPage1.getTitleText(), "title не соответствует");
    }

    @Test
    @Tag("7_ТК5")
    @DisplayName("Проверка заголовка на странице загрузки")
    public void checkDownloadTitleText(){
        String downloadTitle ="Thank you for downloading Toolbox App!";
        toolBoxAppPage.clickDownloadButton();
        assertEquals(downloadTitle, toolBoxDownloadPage.getDownloadTitleText());
    }
    @Test
    @Tag("8_ТК2")
    @DisplayName("Проверка отображения попап окна System requirements")
    public void systemReqPopupDisplayed(){
        toolBoxAppPage.clickSystemReqFirstRef();
        assertTrue(toolBoxAppPage.checkIfSystemReqPopupDisplayed(), "Попап окно не открылось");
    }
    @Test
    @Tag("9")
    @DisplayName("Проверка ввода корректного email")
    public void correctEmailSubmit(){
        String correctEmail = "eredzhepov@mail.ru"; // необходимо ввести адрес почты ранее не оформившей подписку
        toolBoxAppPage.setMailText(correctEmail);
        toolBoxAppPage.clickSubmitButton();
        assertTrue(toolBoxAppPage.getMessageAfterSuccesfulEmailSubmit(), "Сообщение об успешной отправки сообдения не появилось");
    }
    @Test
    @Tag("10")
    @DisplayName("Отправка пустого email")
    public void sendEmptyMail(){
        toolBoxAppPage.clickSubmitButton();
        assertTrue(toolBoxAppPage.messageAboutRequiredEmailFieldIsDisplayed(), "Сообщение об обязательном поле не появилось");
    }
//    @Test
//    @Tag("11")
//    @DisplayName("Закрытие всплывающего попап окна с установкой расширения")
//    public void installGoogleChromeExistation(){
//        toolBoxAppPage.googleChromeExistationRefClick();
//        googleChromeExistationPage.clickInstallExistationButton();
//        googleChromeExistationPage.dismiss();
//        assertTrue(googleChromeExistationPage.installExistationButtonIsClickable(), "Кнопка установить не появилась");
//    }
    @Test
    @Tag("12")
    @DisplayName("Показать почту гугл")
    public void installGoogleChromeExistation(){
        toolBoxAppPage.googleChromeExistationRefClick();
        googleChromeExistationPage.unfurlGoogleMailList();
        assertTrue(googleChromeExistationPage.supportMailIsDisplayed(), "Почта google не появилась");
    }
    @Test
    @Tag("13")
    @DisplayName("Проверка что на cтранице Firfox в тайтле JetBrains Toolbox Extension – Get this Extension for \uD83E\uDD8A Firefox (en-US)")

    public void firefoxPageTitle(){
        String title = "JetBrains Toolbox Extension – Get this Extension for \uD83E\uDD8A Firefox (en-US)";
        toolBoxAppPage.firefoxRefClick();
        assertEquals(title, toolBoxFirefoxPage.getTitleText(), "title не соответствует");
    }
    @Test
    @Tag("14")
    @DisplayName("Выбранная версия соответствует версии Windows")
    public void checkedVersionAgreeWithWindowsVersion(){
        toolBoxAppPage.otherVersioLinkClick();
        toolBoxOtherVersionPage1.versionListClick();
        toolBoxOtherVersionPage1.versionCheck();
        String actualWindowsVersion = toolBoxOtherVersionPage1.getCheckedVersion() + " - Windows (exe)";
        assertEquals(actualWindowsVersion, toolBoxOtherVersionPage1.getWindowsVersion());
    }
    @Test
    @Tag("15")
    @DisplayName("Отображение загаловка на странице JetBrainc Policy")
    public void jetBrainPrivacyPolicySummaryIsShowed(){
        toolBoxAppPage.jetBrainsPrivacyPolicyLinkClick();
        assertTrue(toolBoxPrivacyPolicyPage.privacySummaryIsDisplayed(), "Заголовок на странице конфидециальности не появился");
    }
    @Test
    @Tag("16")
    @DisplayName("Проверка заголовка на странице загрузки, после тоо как нажали на 2-ю кнопку загрузки")
    public void checkSecondDownloadTitleText(){
        String downloadTitle ="Thank you for downloading Toolbox App!";
        toolBoxAppPage.secondDownloadButtonClick();
        assertEquals(downloadTitle, toolBoxDownloadPage.getDownloadTitleText());
    }
    @Test
    @Tag("17")
    @DisplayName("Проверка, что после нажатия на кнопку 2-ю кнопку exe, появляется дропдаун меню")
    public void secondDropDownMenuShowed() {
        toolBoxAppPage.clickDropDownMenuButton();
        assertTrue(toolBoxAppPage.checkIfDropDownMenuIsDisplayed(),"Меню не появилось");
    }
    @Test
    @Tag("18")
    @DisplayName("Проверка отображения попап окна System requirements после нажатия на 2-ю ссылку System requirements")
    public void secondSystemReqPopupDisplayed(){
        toolBoxAppPage.secondSystemReqLinkClick();
        assertTrue(toolBoxAppPage.checkIfSystemReqPopupDisplayed(), "Попап окно не открылось");
    }
    @Test
    @Tag("19")
    @DisplayName("Проверка отображения фамилии и имени автора")
    public void checkAuthorNameAndSername(){
        String[] authorDetails = toolBoxAppPage.getAthorDetails().split(" ");
        String authorNameAndSername = authorDetails[0] + " " + authorDetails[1];
        String actualAutherNameAndSername = "Vedran Pavic";
        assertEquals(actualAutherNameAndSername,authorNameAndSername, "Имя и фамилия автора не соответствпадают");
    }
    @Test
    @Tag("20")
    @DisplayName("Проверка отображения электронного адреса автора")
    public void checkAuthorMail(){
        String[] authorDetails = toolBoxAppPage.getAthorDetails().split(" ");
        String authorMail = authorDetails[2];
        String actualAutherMail = "@vedran_pavic";
        assertEquals(actualAutherMail,authorMail, "Почта автора не соответветствует указанной");
    }

}

