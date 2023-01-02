package com.itacademy.ui;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
