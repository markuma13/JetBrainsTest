package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.datagrippages.DataGripPage;
import com.example.jetbrainstest.pages.datagrippages.DataGripPricingPage;
import com.example.jetbrainstest.pages.datagrippages.GenerateEmailPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.example.jetbrainstest.pages.datagrippages.GenerateEmailPage.getClipboardText;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Автор @markuma13
 */

@ExtendWith(MyExtension.class)
public class DataGripTest extends BaseTest {

    private DataGripPage dataGripPage;
    private GenerateEmailPage generateEmail;
    private DataGripPricingPage dataGripPagePrice;

    @BeforeEach
    @Override
    @Step("Переход на страницу DataGrip")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/datagrip/");
        dataGripPage = new DataGripPage(getDriver());
        generateEmail = new GenerateEmailPage(getDriver());
        dataGripPagePrice = new DataGripPricingPage(getDriver());
    }

    @Test
    @DisplayName("Проверка перехода на страницу и работы чекбосов кнопки Download")
    public void checkPageDataGripAndDownloadButtonComboBox() {
        dataGripPage.clickButtonDataGripDownload();

        assertEquals("https://www.jetbrains.com/datagrip/download/#section=windows",
                getDriver().getCurrentUrl(), "Не удалось перейти на ожидаемую страницу!");
        assertFalse(dataGripPage.getComboBoxes().isEmpty(), "Список комбобоксов пустой");
    }

    @Test
    @DisplayName("Проверка активности кнопок на видео")
    public void playVideoJetBrainsAI() {
        assertTrue(dataGripPage.checkExploreJetBrainsAIButton(), "Кнопка не активна");
        dataGripPage.clickButtonExploreJetBrainsAI();
        assertTrue(dataGripPage.checkWatchVideoButton(), "Кнопка WatchVideo для воспроизведение видео не активна");
    }

    @Test
    @DisplayName("Проверка открытия страницы")
    public void activeMoreFeaturesPage() {
        dataGripPage.clickMoreFeaturesButton();
        assertEquals("https://www.jetbrains.com/datagrip/features/", getDriver().getCurrentUrl(), "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка комбобоксов и активности кнопки exe.Windows")
    public void checkPageDataGripComboBox() {
        assertFalse(dataGripPage.getComboBoxes().isEmpty(), "Список комбобоксов пустой");
        assertTrue(dataGripPage.checkButtonExeWindowsComboBox(), "Кнопка не активна");
    }

    @Test
    @DisplayName("Проверка открытие страницы через баннер и активность ComboBox")
    public void checkPageWhatSnewComboBox() {
        dataGripPage.clickLinkTextVSN();
        generateEmail.switchToTab(2);
        dataGripPage.clickImgDataGripRelease();
        generateEmail.switchToTab(3);
        assertEquals("https://www.jetbrains.com/datagrip/whatsnew/?utm_source=marketo&utm_medium=email&" +
                        "utm_campaign=datagrip_2023_1_newsletter&utm_content=newsletter&p=banner",
                getDriver().getCurrentUrl(), "Не верная ссылка");
        assertFalse(dataGripPage.getComboBoxes().isEmpty(), "Список комбобоксов пустой");
        assertTrue(dataGripPage.checkButtonExeWindowsComboBox(), "Кнопка не активна");
    }

    @Test
    @DisplayName("Проверка сообщение на почте после подписки на новости")
    public void checkMessageMailAfterSubscribingNews() throws IOException, UnsupportedFlavorException {
        generateEmail.openPageInNewTag();
        generateEmail.copiedButtonEmail();
        generateEmail.tabBack();

        String clipboardText = getClipboardText();
        dataGripPage.enterEmail(clipboardText);
        assertTrue(dataGripPage.isEmailEntered(clipboardText),
                "Ожидалось, что введенный email будет соответствовать скопированному значению из буфера обмена.");

        String getMessageEmail = "Thanks for your request!";
        assertEquals(getMessageEmail, dataGripPage.getTextEnteringEmail(), "Сообщение не отоброзилось после отправки Email");

        generateEmail.switchToTab(2);
        generateEmail.messageCheckDataGrip();

        String checkGetMessageEmail = "Your subscription confirmation for major DataGrip news and release notifications";
        assertEquals(checkGetMessageEmail, generateEmail.checkGetTextEmailMessage(), "Неверное отправленный текст письма");
    }

    @Test
    @DisplayName("Проверка ввода пустого email")
    public void invalidCheckValedateEmail() {
        String emptyEmail = dataGripPage.enterInvalidEmailGetText("");
        assertEquals(emptyEmail, "This field is required", "Неккоректный текст сообщения валидации");
    }


    @ParameterizedTest(name = "#{index} - Проверка ввода на невалидность Email {0}")
    @CsvSource({"insidi", "%%%/%%%", "pers@lmotion"})
    @DisplayName("Проверка ввода невалидного Email")
    public void checkInvalidEnterEmail(String email) {
        String entering = dataGripPage.enterInvalidEmailGetText(email);
        assertEquals(entering, "E-mail address is not correct", "Неккоректный текст сообщения валидации");
    }

    @Test
    @DisplayName("Проверка открытия страницы через кнопку Choose your IDE")
    public void checkContactUsUrlPege() {
        dataGripPage.clickButtonChooseYourIDE();
        assertEquals("https://www.jetbrains.com/ides/", getDriver().getCurrentUrl(), "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка открытие страницы релиза и ожидаемого на нем текста")
    public void checkLinkTextVSN() {
        dataGripPage.clickLinkTextVSN();
        generateEmail.switchToTab(2);
        String expectedText = "For DataGrip 2023.1, we focused entirely on quality. We’ve fixed many " +
                "bugs that had accumulated in our public issue tracker " +
                "(not the most fun part of the job, but important nonetheless).";
        assertEquals(expectedText, dataGripPage.checkGetTextViewSampleOpen(), "Ожидаемый текст не найден на странице");
    }

    @Test
    @DisplayName("Проверка активаности кнопки Download в шапке")
    public void checkActivityButtonDownloadCap() {
        assertTrue(dataGripPage.checkIfDownloadButtonIsClickableCap(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка активаности кнопки Pricing в шапке")
    public void checkActivityButtonPricingCap() {
        assertTrue(dataGripPage.checkIfPricingButtonIsClickableCap(), "Кнопка скачивания не активна");
        dataGripPage.clickPricingButton();
    }

    @Test
    @DisplayName("Проверка сумм продуктов на страницы цен Pricing")
    public void checkPricesPageDataGrip() {
        dataGripPage.clickPricingButton();
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.jetbrains.com/datagrip/buy";

        assertTrue(currentUrl.contains(expectedUrl), "Не удалось перейти на ожидаемую страницу!");

        String priceAllPackYears = "US $779.00";
        assertEquals(priceAllPackYears, dataGripPagePrice.checkPriceAllProductsPack(),
                "Не верная сумма AllPackYears");

        String priceDataGripBase = "US $229.00";
        assertEquals(priceDataGripBase, dataGripPagePrice.checkPriceDataGripBasesBiling(),
                "Не верная YearsBases сумма");

        dataGripPagePrice.clickSwitchMonthlyBillingTariff();

        String priceMonthlyDataGripBase = "US $22.90";
        assertEquals(priceMonthlyDataGripBase, dataGripPagePrice.checkPriceMonthlyBillingDataGrip(),
                "Не верная сумма MonthlyBase");

        String priceMonthlyAllProductsPack = "US $77.90";
        assertEquals(priceMonthlyAllProductsPack, dataGripPagePrice.checkPriceMonthlyBillingAllProductsPack(),
                "Не верная сумма MonthlyAllPack");
    }

    @Test
    @DisplayName("Проверка открытие страницы индентификации")
    public void checkOpenIdentificationEStore() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickBuyButton();
        assertEquals("https://www.jetbrains.com/shop/customer",
                getDriver().getCurrentUrl(), "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы For Organizations or for Individual Use? в разделе Further information")
    public void checkBusinessOrIndividualAndPricing() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickLickBusinessOrIndividual();
        generateEmail.switchToTab(2);

        String expectedTitle = "What is the difference between commercial and personal licenses? – Licensing and Purchasing FAQ";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы Subscription Options в разделе Further information")
    public void checkSubscriptionOptions() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickLinkSubscriptionOptions();
        generateEmail.switchToTab(2);

        String expectedTitle = "Compare Subscription Options - JetBrains Toolbox";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы JetBrains For Business в разделе Further information")
    public void checkJetBrainsForBusiness() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickLinkJetBrainsForBusiness();
        generateEmail.switchToTab(2);

        String expectedTitle = "JetBrains Tools For Business";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы Purchase Terms в разделе Further information")
    public void checkPurchaseTerms() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickLinkPurchaseTerms();
        generateEmail.switchToTab(2);

        String expectedTitle = "Terms and Conditions of Purchase";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы Licensing And Purchasing через FAQ в разделе Further information")
    public void checkLicensingAndPurchasing() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickLinkFaq();
        generateEmail.switchToTab(2);

        String expectedTitle = "Licensing and Purchasing FAQ";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка заголовка открытой страницы Contact Us в разделе Further information")
    public void checkContactSales() {
        dataGripPage.clickPricingButton();
        dataGripPagePrice.clickButtonContactUs();

        String expectedTitle = "Sales & Order Support - JetBrains";
        assertEquals(expectedTitle, dataGripPagePrice.checkTitlePage(),
                "Заголовок страницы не совпадает с ожидаемым");
    }

}
