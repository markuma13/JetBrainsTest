package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.youtrackpages.YouTrackPage;
import com.example.jetbrainstest.pages.youtrackpages.YouTrackTeamsPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class YouTrackTest extends BaseTest {

    private YouTrackPage YTPage;
    private YouTrackTeamsPage YTTeamsPage;

    @BeforeEach
    @Override
    @Step("Переход на страницу YouTrack")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/youtrack/");
        YTPage = new YouTrackPage(getDriver());
        YTTeamsPage = new YouTrackTeamsPage(getDriver());
        LOG.info("Начало проверки:");
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
        LOG.info("Проверка окончена");
    }

    @Test
    @DisplayName("Проверка активности кнопки What's new")
    public void whatsNewButtonTest() {
        assertTrue(YTPage.checkIfWhatsNewButtonIsClickable(), "Кнопка What's New неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Agile")
    public void agileButtonTest() {
        assertTrue(YTPage.checkIfAgileButtonIsClickable(), "Кнопка Agile неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Teams")
    public void teamsButtonTest() {
        assertTrue(YTPage.checkIfTeamsButtonIsClickable(), "Кнопка Teams неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Features")
    public void featuresButtonTest() {
        assertTrue(YTPage.checkIfFeaturesButtonIsClickable(), "Кнопка Features неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Helpdesk")
    public void helpdeskUpperButtonTest() {
        assertTrue(YTPage.checkIfHelpdeskButtonIsClickable(), "Кнопка Helpdesk неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Support")
    public void supportButtonTest() {
        assertTrue(YTPage.checkIfSupportButtonIsClickable(), "Кнопка Support неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Pricing")
    public void pricingButtonTest() {
        assertTrue(YTPage.checkIfPricingButtonIsClickable(), "Кнопка Pricing неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Projects")
    public void projectsButtonTest() {
        assertTrue(YTPage.checkIfYTProjectsButtonIsClickable(), "Кнопка Projects неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Tasks")
    public void tasksButtonTest() {
        assertTrue(YTPage.checkIfYTTasksButtonIsClickable(), "Кнопка Tasks неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки AI Assistant")
    public void aiAssistantButtonTest() {
        assertTrue(YTPage.checkIfAiAssistantButtonIsClickable(), "Кнопка AI Assistant неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Knowledge Base")
    public void knowledgeBaseButtonTest() {
        assertTrue(YTPage.checkIfYTKnowledgeBaseButtonIsClickable(), "Кнопка Knowledge Base неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки AgileBoards")
    public void agileBoardsButtonTest() {
        assertTrue(YTPage.checkIfYTAgileBoardsButtonIsClickable(), "Кнопка Agile Boards неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Timesheets")
    public void timesheetsButtonTest() {
        assertTrue(YTPage.checkIfYTTimesheetsButtonIsClickable(), "Кнопка Timesheets неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Gantt Charts")
    public void ganttChartsButtonTest() {
        assertTrue(YTPage.checkIfYTGanttChartsButtonIsClickable(), "Кнопка Gantt Charts неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Reports")
    public void reportsButtonTest() {
        assertTrue(YTPage.checkIfYTReportsButtonIsClickable(), "Кнопка Reports неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Helpdesk")
    public void helpdeskLowerButtonTest() {
        assertTrue(YTPage.checkIfYTHelpdeskButtonIsClickable(), "Кнопка Helpdesk неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Workflows")
    public void workflowsButtonTest() {
        assertTrue(YTPage.checkIfYTWorkflowsButtonIsClickable(), "Кнопка Workflows неактивна");
    }

    @Test
    @DisplayName("Открытие страницы Teams")
    public void teamsPageTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/";
        String actualUrl = YTPage.teamsButtonTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Developers")
    public void developersTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/development.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.developersTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Marketing")
    public void marketingTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/marketing.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.marketingTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Support")
    public void supportTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/helpdesk/";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.supportTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Project Management")
    public void managementTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/management.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.managementTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Designers")
    public void designTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/design.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.designTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел QA")
    public void qaTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/qa.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.qaTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка перехода в раздел Operations and Legal")
    public void operationTeamTest() {
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/operations.html";
        YTPage.teamsButtonTransition();
        String actualUrl = YTTeamsPage.operationsTeamsTransition();
        assertEquals(expectedUrl, actualUrl, "Итоговый URL не соответствует ожидаемому");
    }
}
