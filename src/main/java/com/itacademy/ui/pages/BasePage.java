package com.itacademy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

abstract class BasePage <T extends BasePage<T>>{
    public abstract T openPage();

    protected void clickOnElement(SelenideElement element) {
        element.should(Condition.interactable).click();
    }
}
