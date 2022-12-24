package com.itacademy.ui.pages;



import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginFramePage extends MainPage {
    protected final SelenideElement userName = $("input[placeholder$='il']");
    protected final SelenideElement userPassword = $("[type='password']");
    protected final SelenideElement loginButton = $x("//button[@type='submit']/parent::div");
    protected final SelenideElement notificationLoginMessage = $$(".auth-form__line.auth-form__line_condensed").get(2);

    public LoginFramePage() {
    }

}
