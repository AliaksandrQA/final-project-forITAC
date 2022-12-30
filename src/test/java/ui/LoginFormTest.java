package ui;

import com.itacademy.ui.steps.LoginFramePageSteps;
import com.itacademy.ui.steps.MainPageSteps;
import com.itacademy.utils.PropertyManager;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormTest extends WebUIBaseTest{
    @Attachment(type = "image/png")
    @Test
    public void testHomePageOpening(){
        MainPageSteps steps = new MainPageSteps();
        steps.openPage();
        Assert.assertTrue(steps.isMainSiteLogoPresent());
    }

    @Test
    public void testProperLogin() {
        String userName = PropertyManager.getProperties("USER_NAME");
        String password = PropertyManager.getProperties("PASSWORD");

        clickOnLoginButton();

        Assert.assertTrue(new LoginFramePageSteps()
                .loginDataEntering(userName, password)
                .isLogged());
    }
    @Test
    public void testInvalidLogin() {
        String invalidUserName = PropertyManager.getProperties("INVALIDUSERNAME");
        String password = PropertyManager.getProperties("PASSWORD");

        clickOnLoginButton();

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(invalidUserName, password);
        Assert.assertTrue(loginSteps.isLoginInCorrect());

    }

    private void clickOnLoginButton() {
        MainPageSteps steps = new MainPageSteps();
        steps.openPage().clickOnLoginButton();
    }
}
