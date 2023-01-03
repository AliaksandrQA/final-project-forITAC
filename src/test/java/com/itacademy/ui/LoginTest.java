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

    }

    @Test
    public void testLoginWithInvalidLoginAndPassword() {
        String invalidUserName = "invalidLogin@gmail.com";
        String password = "invalidPassword";

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(invalidUserName, password);


        Assert.assertTrue(loginSteps.isInvalidUserNameNotificationPresent());
    }
    @Test
    public void testLoginWithEmptyUserNameAndEmptyPassword() {
        String emptyUserName = "";
        String emptyPassword = "";

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(emptyUserName, emptyPassword);


        Assert.assertTrue(loginSteps.isUserNameNotificationPresent());
        Assert.assertTrue(loginSteps.isUserPasswordNotificationPresent());


}
    @Test
    public void testLoginWithEmptyUserNameOnly() {
        String emptyUserName = "";
        String password = "1111";

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(emptyUserName, password);


        Assert.assertTrue(loginSteps.isUserNameNotificationPresent());


    }
    @Test
    public void testLoginWithEmptyPasswordOnly() {
        String userName = "testUser@gmail.com";
        String emptyPassword = "";

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(userName, emptyPassword);


        Assert.assertTrue(loginSteps.isUserPasswordNotificationPresent());

    }


}