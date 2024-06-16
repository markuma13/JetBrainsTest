package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * URL страницы &lt;a href=<a href="https://www.jetbrains.com/datagrip/buy/#commercial">...</a>!
 * Конструктор DataGripPricingPage
 * Автор @markuma13
 */
public class DataGripPricingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[1]")
    private WebElement priceYearlyBillingDataGrip;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[2]")
    private WebElement priceYearlyBillingAllProductsPack;
    @FindBy(xpath = "(//div[text()='Monthly billing'])[2]")
    private WebElement switchPriceMonthlyBillingTariff;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[1]")
    private WebElement priceMonthlyBillingDataGrip;
    @FindBy(xpath = "(//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'])[2]")
    private WebElement priceMonthlyBillingAllProductsPack;
    @FindBy(xpath = "//a[@href='https://www.jetbrains.com/shop/buy?item=C:N:DB:Y']")
    private WebElement buyButton;
    @FindBy(xpath = "//div/div/a[text()='FAQ']")
    private WebElement faqButton;
    @FindBy(xpath = "//a[normalize-space()='For Organizations or for Individual Use?']")
    private WebElement linkTextBusinessOrIndividual;
    @FindBy(xpath = "//a[normalize-space()='Subscription Options']")
    private WebElement linkTextSubscriptionOptions;
    @FindBy(xpath = "//a[normalize-space()='JetBrains for Business']")
    private WebElement linkTextJetBrainsForBusiness;
    @FindBy(xpath = "//div/div/a[text()='Purchase Terms']")
    private WebElement linkTextPurchaseTerms;
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsButton;

    public DataGripPricingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
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

    public void clickSwitchMonthlyBillingTariff() {
        LOG.info("Переключение тарифа на Monthly billing");
        switchPriceMonthlyBillingTariff.click();
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
        faqButton.click();
        LOG.info("Клик по текстовой ссылке FAQ");
    }

    public void clickButtonContactUs() {
        contactUsButton.click();
        LOG.info("Клик по кнопке Contact Us");
    }

    public String checkTitlePage() {
        LOG.info("Проверка наличия title");
        String actualTitle = driver.getTitle();
        LOG.info("Получен текст title страницы: \"" + actualTitle + "\"");
        return actualTitle;
    }

}
