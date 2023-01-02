package com.itacademy.ui.steps;

import com.codeborne.selenide.Condition;
import com.itacademy.ui.pages.LoginFramePage;
import com.itacademy.ui.pages.MainPage;

public class LoginFramePageSteps extends LoginFramePage {
    public MainPage loginDataEntering(String name, String password) {
        userName.should(Condition.interactable).sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        return new MainPage();

    }
    public LoginFramePage invalidLoginDataEntering(String name, String password) {
        userName.should(Condition.interactable).sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        return new LoginFramePage();
    }
    public LoginFramePage submitLogin() {
        clickOnElement(loginButton);
        return new LoginFramePage();
    }
    public boolean isLoginInCorrect() {
        return notificationLoginMessage.shouldBe(Condition.visible).isDisplayed();
    }

}
