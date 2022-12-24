package com.itacademy.ui.steps;

import com.codeborne.selenide.Condition;
import com.itacademy.ui.pages.LoginFramePage;
import com.itacademy.ui.pages.MainPage;
import com.itacademy.ui.pages.ResultPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class MainPageSteps extends MainPage {
    public void clickOnUserProfile() {
        clickOnElement(userProfile);
    }

    public MainPage clickOnLoginButton() {
        loginButton.should(Condition.visible).click();
        return new LoginFramePage();
    }

    public boolean isMainSiteLogoPresent() {
        return onlinerLogo.isDisplayed();
    }

    public ResultPageSteps searchDevice(String model) {
        searchField.click();
        searchField.sendKeys(model);
        switchTo().frame(searchFrame);
        return new ResultPageSteps();

    }
}
