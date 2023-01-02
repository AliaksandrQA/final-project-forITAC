package com.itacademy.ui;

import com.itacademy.ui.steps.LoginFramePageSteps;
import com.itacademy.ui.steps.MainPageSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void openMainPageAndClickLoginButton() {
        MainPageSteps steps = new MainPageSteps();
        steps.openPage();
        steps.clickOnLoginButton();
    }

    @Ignore
    @Test
    public void testLoginWithValidCredentials() {
        String userName = "";
        String password = "";

        LoginFramePageSteps loginFramePageSteps = new LoginFramePageSteps();
        loginFramePageSteps.loginDataEntering(userName, password);

        // не знаю как там у кого, меня проверяют на РОБОТА
        //Assert.assertTrue();
    }

    @Test
    public void invalidLogin() {
        String invalidUserName = "invalidLogin@gmail.com";
        String password = "invalidPassword";

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(invalidUserName, password);

        // конечно проверять просто видимость сообщения об ошибке - это не дело.
        // нужно проверять появление конкретного сообщения
        Assert.assertTrue(loginSteps.isLoginInCorrect());
    }

    // ну и количество тестов по проверке формы логина
    // 1. Если ник или мыло пустое
    // 2. Если ник или мыло пустое и пароль пустой
    // 3. Если ник или мыло хоть какой и пароль пустой
    // 4. Если ник или мыло хоть какое и пароль хоть какой
}