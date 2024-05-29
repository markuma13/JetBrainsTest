package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.RustRoverPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RustRoverTest extends BaseTest {
    private RustRoverPage rustRoverPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        rustRoverPage = new RustRoverPage(getDriver());
    }
    @Test
    @DisplayName("Check that new page is opened")
    public  void CheckUrlAfterClickOnDownloadRustPreviewButton() {
        rustRoverPage = new RustRoverPage(getDriver());
        Assertions.assertEquals(rustRoverPage.clickRustDownloadAndCheckUrl(), "https://www.jetbrains.com/rust/nextversion/", "URL не равен ожидаемому");
    }
}
