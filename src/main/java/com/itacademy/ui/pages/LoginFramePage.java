package com.itacademy.ui.pages;



import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginFramePage extends MainPage {
    protected final SelenideElement userName = $("input[placeholder$='il']");
    protected final SelenideElement userPassword = $("[type='password']");
    protected final SelenideElement loginButton = $x("//button[@type='submit']/parent::div");
    protected final SelenideElement emptyPasswordNotification = $x("//div[contains(text(),'Укажите пароль')])");
    protected final SelenideElement emptyUserNameNotification = $x("//div[contains(text(),'Укажите ник или e-mail')]");
    protected final SelenideElement invalidUserNameAndPasswordNotification = $x("//div[contains(text(),'Неверный логин или пароль')]");

    public LoginFramePage() {
    }

}
