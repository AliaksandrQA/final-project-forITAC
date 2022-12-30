package com.itacademy.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.itacademy.ui.steps.MainPageSteps;
import com.itacademy.utils.PropertyManager;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage{
    protected final SelenideElement loginButton = $("div.auth-bar__item.auth-bar__item--text");
    protected final SelenideElement userProfile = $x("//a[@href='https://profile.onliner.by/']");
    protected final SelenideElement searchField = $(".fast-search__input");
    protected final SelenideElement searchFrame = $(".modal-iframe");
    protected final SelenideElement onlinerLogo = $x("//*[@class='onliner_logo']");

    public MainPage() {
    }

    public boolean isLogoPresent() {
        return onlinerLogo.exists();
    }
    public boolean isLogged() {
        return userProfile.exists();
    }
    public boolean isSearchedField() {
        return searchField.exists();
    }

    public boolean isSearchFrame() {
        return searchFrame.exists();
    }



    @Override
    public MainPageSteps openPage() {
        String base_ui_url = PropertyManager.getProperties("BASE_UI_URL");
        Selenide.open(base_ui_url);
        return new MainPageSteps();
}}
