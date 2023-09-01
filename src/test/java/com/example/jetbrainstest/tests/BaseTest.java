package com.example.jetbrainstest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        try {
            System.setProperty("webdriver.gecko.driver", "C:/ChromeDriver/firefoxDriver/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        //WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
       // driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
