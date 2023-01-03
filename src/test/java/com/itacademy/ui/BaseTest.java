package com.itacademy.ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;


public class BaseTest {

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
