package com.example.jetbrainstest.pages.youtrackpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

/**
 * <a href="https://www.jetbrains.com/youtrack/">...</a>
 */

public class YouTrackPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(YouTrackPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/youtrack/whatsnew/']")
    private WebElement whatsNewButton;

    @FindBy(xpath = "//a[@href='/youtrack/agile/']")
    private WebElement agileButton;

    @FindBy(xpath = "//a[@href='/youtrack/teams/']")
    private WebElement teamsButton;

    @FindBy(xpath = "//a[@href='/youtrack/features/']")
    private WebElement featuresButton;

    @FindBy(xpath = "//a[@href='/youtrack/helpdesk/']")
    private WebElement helpdeskUpperButton;

    @FindBy(xpath = "//a[@href='/youtrack/support/']")
    private WebElement supportButton;

    @FindBy(xpath = "//a[@href='/youtrack/buy/']")
    private WebElement pricingButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[1]")
    private WebElement projectsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[2]")
    private WebElement tasksButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[3]")
    private WebElement aiAssistantButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[4]")
    private WebElement knowledgeBaseButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[5]")
    private WebElement agileBoardsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[6]")
    private WebElement timesheetsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[7]")
    private WebElement ganttChartsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[8]")
    private WebElement reportsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[9]")
    private WebElement helpdeskLowerButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[10]")
    private WebElement workflowsButton;

    public Boolean checkIfWhatsNewButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки What's New");
        return whatsNewButton.isEnabled();
    }

    public Boolean checkIfAgileButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Agile");
        return agileButton.isEnabled();
    }

    public Boolean checkIfTeamsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Teams");
        return teamsButton.isEnabled();
    }

    public Boolean checkIfFeaturesButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Features");
        return featuresButton.isEnabled();
    }

    public Boolean checkIfHelpdeskButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Helpdesk");
        return helpdeskUpperButton.isEnabled();
    }

    public Boolean checkIfSupportButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Support");
        return supportButton.isEnabled();
    }

    public Boolean checkIfPricingButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Pricing");
        return pricingButton.isEnabled();
    }

    public Boolean checkIfYTProjectsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Projects");
        return projectsButton.isEnabled();
    }

    public Boolean checkIfYTTasksButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Tasks");
        return tasksButton.isEnabled();
    }

    public Boolean checkIfAiAssistantButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки AI Assistant");
        return aiAssistantButton.isEnabled();
    }

    public Boolean checkIfYTKnowledgeBaseButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Knowledge Base");
        return knowledgeBaseButton.isEnabled();
    }

    public Boolean checkIfYTAgileBoardsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Agile Boards");
        return agileBoardsButton.isEnabled();
    }

    public Boolean checkIfYTTimesheetsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Timesheets");
        return timesheetsButton.isEnabled();
    }

    public Boolean checkIfYTGanttChartsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Gantt Charts");
        return ganttChartsButton.isEnabled();
    }

    public Boolean checkIfYTReportsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Reports");
        return reportsButton.isEnabled();
    }

    public Boolean checkIfYTHelpdeskButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Helpdesk");
        return helpdeskLowerButton.isEnabled();
    }

    public Boolean checkIfYTWorkflowsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Workflows");
        return workflowsButton.isEnabled();
    }

    public String teamsButtonTransition() {
        LOG.info("Переход на страницу Teams");
        teamsButton.click();
        return driver.getCurrentUrl();
    }

    public YouTrackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}