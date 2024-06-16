package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static com.example.jetbrainstest.MyWait.myWait;

/**
 * URL страницы <a href="https://www.jetbrains.com/datagrip/">...</a>
 * Конструктор DataGripPage
 * Автор @markuma13
 */
public class DataGripPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy(xpath = "(//a[@href='/datagrip/download/'])[2]")
    private WebElement downloadDataGripButton;
    @FindBy(xpath = "//a[normalize-space()='Explore JetBrains AI']")
    private WebElement clickExploreJetBrainsAIButton;
    @FindBy(xpath = "//span[@title='.exe (Windows)']")
    private WebElement downloadListResult;
    @FindBy(xpath = "//div[@data-focus-lock-disabled='false']")
    private List<WebElement> resultsComboBox;
    @FindBy(xpath = "//button[normalize-space()='Watch video']")
    private WebElement watchVideoButton;
    @FindBy(xpath = "//a[normalize-space()='More features']")
    private WebElement MoreFeaturesButton;
    @FindBy(xpath = "//span[normalize-space()='.exe (Windows)']")
    private WebElement exeWindows;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement fieldEmail;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//div[@class='_errorMessage_10bo8mm_596']")
    public WebElement messageEnteringInvalidEmail;
    @FindBy(xpath = "//p[@class='rs-text-2 rs-text-2_hardness_hard rs-text-2_theme_dark wt-offset-top-24']")
    public WebElement messageEnteringValidEmail;
    @FindBy(xpath = "//span[normalize-space()='View sample newsletter']")
    private WebElement linkTextVSN;
    @FindBy(xpath = "//p[contains(text(),'For DataGrip 2023.1, we focused entirely on qualit')]")
    private WebElement getTextViewSample;
    @FindBy(css = "img[height='325']")
    private WebElement imgDataGripRelease;
    @FindBy(css = "div[id='js-menu-second'] a:nth-child(7)")
    private WebElement downloadButtonCap;
    @FindBy(xpath = "(//a[@href='/datagrip/buy/'])[2]")
    private WebElement pricingButtonCap;
    @FindBy(xpath = "//a[normalize-space()='Choose your IDE']")
    private WebElement buttonChooseYourIDE;

    public DataGripPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getComboBoxes() {
        downloadListResult.click();
        List<WebElement> comboBoxes = resultsComboBox;
        for (WebElement comboBox : comboBoxes) {
            LOG.infoWithScreenshot("ComboBox DataGrip button download: " + comboBox.getText());
        }
        return comboBoxes;
    }

    public void clickImgDataGripRelease() {
        imgDataGripRelease.click();
        LOG.info("Клик по изоброжению на странице релиза");
    }

    public void clickButtonDataGripDownload() {
        downloadDataGripButton.click();
        myWait(50);
        LOG.infoWithScreenshot("Клик кнопки загрузки DataGripPage");
    }

    public void clickButtonExploreJetBrainsAI() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");
        clickExploreJetBrainsAIButton.click();
        LOG.info("Клик кнопки TakeATour");
    }

    public boolean checkExploreJetBrainsAIButton() {
        LOG.info("Проверка активности кнопки");
        return clickExploreJetBrainsAIButton.isEnabled();
    }

    public Boolean checkIfDownloadButtonIsClickableCap() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButtonCap.isEnabled();
    }

    public Boolean checkIfPricingButtonIsClickableCap() {
        LOG.info("Проверка активности кнопки Pricing");
        return pricingButtonCap.isEnabled();
    }

    public void clickPricingButton() {
        pricingButtonCap.click();
        LOG.info("Клик на кнопку Pricing");
    }

    public void clickLinkTextVSN() {
        linkTextVSN.click();
        LOG.info("Клик по тексту View sample newsletter");
    }

    public String checkGetTextViewSampleOpen() {
        LOG.info("Проверка наличия текста");
        String value = getTextViewSample.getText();
        LOG.info("Получен текст: \"" + value + "\"");
        return value;
    }

    public boolean checkButtonExeWindowsComboBox() {
        LOG.infoWithScreenshot("Проверка активаности кнопки exe.Windows в чекбоксе");
        myWait(50);
        return exeWindows.isEnabled();
    }


    public boolean checkWatchVideoButton() {
        LOG.info("Проверка активаности кнопки WatchVideo");
        return watchVideoButton.isEnabled();
    }


    public void clickMoreFeaturesButton() {
        MoreFeaturesButton.click();
        myWait(50);
        LOG.info("Клик на кнопку Discover all features");
    }

    public void clickButtonChooseYourIDE(){
        buttonChooseYourIDE.click();
        LOG.info("Клик на кнопку Choose Your IDE");
    }

    public void enterEmail(String email) {
        LOG.info("Ввод email");
        fieldEmail.sendKeys(email);
        buttonSubmit.click();
    }

    public boolean isEmailEntered(String expectedEmail) {
        String enteredEmail = fieldEmail.getAttribute("value");
        LOG.infoWithScreenshot("Текущее значение веденного Email");
        return enteredEmail.equals(expectedEmail);
    }

    public String getTextEnteringEmail() {
        myWait(10).waitSoon(3);
        String messageValidEmail = messageEnteringValidEmail.getText();
        LOG.info("Получение названия сообщения после отправки Email: " + messageValidEmail + "\"");
        return messageValidEmail;
    }

    public String enterInvalidEmailGetText(String email) {
        enterEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе не валидного email");
        return messageEnteringInvalidEmail.getText();
    }

}