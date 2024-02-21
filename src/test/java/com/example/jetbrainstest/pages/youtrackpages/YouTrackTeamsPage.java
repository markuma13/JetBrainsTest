package com.example.jetbrainstest.pages.youtrackpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

/**
 * <a href="https://www.jetbrains.com/youtrack/teams/">...</a>
 */

public class YouTrackTeamsPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(YouTrackPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/development.html\"]")
    private WebElement developersTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/marketing.html\"]")
    private WebElement marketingTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/helpdesk/\"]")
    private WebElement supportTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/management.html\"]")
    private WebElement managementTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/design.html\"]")
    private WebElement designTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/qa.html\"]")
    private WebElement qaTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/operations.html\"]")
    private WebElement operationsTeam;

    public String developersTeamsTransition() {
        LOG.info("Переход в раздел Developers");
        developersTeam.click();

        return getUrl();
    }

    public String marketingTeamsTransition() {
        LOG.info("Переход в раздел Marketing");
        marketingTeam.click();
        return getUrl();
    }

    public String supportTeamsTransition() {
        LOG.info("Переход в раздел Support");
        supportTeam.click();
        return getUrl();
    }

    public String managementTeamsTransition() {
        LOG.info("Переход в раздел Product Management");
        managementTeam.click();
        return getUrl();
    }

    public String designTeamsTransition() {
        LOG.info("Переход в раздел Designers");
        designTeam.click();
        return getUrl();
    }

    public String qaTeamsTransition() {
        LOG.info("Переход в раздел QA");
        qaTeam.click();
        return getUrl();
    }

    public String operationsTeamsTransition() {
        LOG.info("Переход в раздел Operations and Legal");
        operationsTeam.click();
        return getUrl();
    }

    public YouTrackTeamsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        String url = driver.getCurrentUrl();
        LOG.info("Текущий адрес URL: " + url);
        return url;
    }
}