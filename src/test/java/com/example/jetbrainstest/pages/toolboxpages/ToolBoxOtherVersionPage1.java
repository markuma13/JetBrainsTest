package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ToolBoxOtherVersionPage1 {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxOtherVersionPage1.class));


   public String getTitleText() {
       LOG.info("В заголовке текст: " + driver.getTitle());
       return driver.getTitle();
    }
    @FindBy (css = "div[id='2.1'] div.wt-col-inline:last-child")
    private WebElement versionList;
   public void versionListClick(){
       LOG.info("Нажали на список с версиями");
       versionList.click();
   }
   @FindBy(xpath = "//div[text() = '2.1.3']")
   private WebElement version;
   public void versionCheck(){
       LOG.info("Выбрана версия " + version.getText());
       versionList.click();
   }
   public String getCheckedVersion(){
       LOG.info("Возвращение выбранной версии");
       return version.getText();
   }
   @FindBy(css = "div[id = '2.1'] table tr:nth-child(2)")
   private WebElement windowsVersion;
   public String getWindowsVersion(){
       LOG.info("Возвращение выбранной версии виндовс");
       return windowsVersion.getText();
   }
   public ToolBoxOtherVersionPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
   }
}
