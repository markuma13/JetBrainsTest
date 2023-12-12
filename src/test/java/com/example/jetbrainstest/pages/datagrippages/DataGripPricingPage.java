package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

/**
 * URL страницы  <a href="https://www.jetbrains.com/datagrip/buy/#commercial"></a>
 * Конструктор DataGripPricingPage
 * Автор @markuma13
 */
public class DataGripPricingPage {
    private final WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[1]")
    private WebElement priceYearlyBillingDataGrip;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[2]")
    private WebElement priceYearlyBillingAllProductsPack;
    @FindBy(xpath = "(//span[@data-test='switcher']//button)[2]")
    private WebElement switchPriceTariff;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[1]")
    private WebElement priceMonthlyBillingDataGrip;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[2]")
    private WebElement priceMonthlyBillingAllProductsPack;
    @FindBy(xpath = "//a[@href='https://www.jetbrains.com/shop/buy?item=C:N:DB:Y']")
    private WebElement buyButton;
    @FindBy(xpath = "//div[text()='FAQ']")
    private WebElement faqButton;
    @FindBy(xpath = "//a[normalize-space()='Business or Individual?']")
    private WebElement linkTextBusinessOrIndividual;
    @FindBy(xpath = "//a[normalize-space()='Subscription Options']")
    private WebElement linkTextSubscriptionOptions;
    @FindBy(xpath = "//a[normalize-space()='JetBrains for Business']")
    private WebElement linkTextJetBrainsForBusiness;
    @FindBy(xpath = "//a[@data-test='buy-page-faq-purchase-terms']")
    private WebElement linkTextPurchaseTerms;
    @FindBy(xpath = "//a[@data-test='buy-page-faq-faq']")
    private WebElement linkTextFaq;
    @FindBy(xpath = "//a[contains(text(),'Contact Sales')]")
    private WebElement linkTextContactSales;

    public DataGripPricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkPriceDataGripBasesBiling() {
        LOG.info("Проверка наличия суммы тарифа");
        String value = priceYearlyBillingDataGrip.getText();
        LOG.info("Получен текст базовой годовой суммы: \"" + value + "\"");
        return value;
    }

    public String checkPriceAllProductsPack() {
        LOG.info("Проверка наличия суммы тарифа");
        String value = priceYearlyBillingAllProductsPack.getText();
        LOG.info("Получен текст полного пакета годовой суммы: \"" + value + "\"");
        return value;
    }

    public void clickSwitchTariff() {
        LOG.info("Переключение тарифа");
        switchPriceTariff.click();
    }

    public String checkPriceMonthlyBillingDataGrip() {
        LOG.info("Проверка суммы тарифа");
        String value = priceMonthlyBillingDataGrip.getText();
        LOG.info("Получен текст месячной базовой суммы: \"" + value + "\"");
        return value;
    }

    public String checkPriceMonthlyBillingAllProductsPack() {
        LOG.info("Проверка суммы тарифа");
        String value = priceMonthlyBillingAllProductsPack.getText();
        LOG.info("Получен текст месячного пакета сумма: \"" + value + "\"");
        return value;
    }

    public void clickBuyButton() {
        buyButton.click();
        LOG.info("Клик по кнопки Bay");
    }

    public void clickPricingFaq() {
        faqButton.click();
        LOG.info("Клик по кнопки Faq в разделе Subscription");
    }

    public void clickLickBusinessOrIndividual() {
        linkTextBusinessOrIndividual.click();
        LOG.info("Клик по текстовой ссылке Business Or Individual");
    }

    public void clickLinkSubscriptionOptions() {
        linkTextSubscriptionOptions.click();
        LOG.info("Клик по текстовой ссылке Subscripti on Options");
    }

    public void clickLinkJetBrainsForBusiness() {
        linkTextJetBrainsForBusiness.click();
        LOG.info("Клик по текстовой ссылке JetBrains For Business");
    }

    public void clickLinkPurchaseTerms() {
        linkTextPurchaseTerms.click();
        LOG.info("Клик по текстовой ссылке Purchase Terms");
    }

    public void clickLinkFaq() {
        linkTextFaq.click();
        LOG.info("Клик по текстовой ссылке FAQ");
    }

    public void clickLinkContactSales() {
        linkTextContactSales.click();
        LOG.info("Клик по текстовой ссылке Contact Sales");
    }

    public String checkTitlePage() {
        LOG.info("Проверка наличия title");
        String actualTitle = driver.getTitle();
        LOG.info("Получен текст title страницы: \"" + actualTitle + "\"");
        return actualTitle;
    }
}
