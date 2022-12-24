package com.itacademy.ui.steps;

import com.codeborne.selenide.Condition;
import com.itacademy.ui.pages.CartPage;

public class CartPageSteps extends CartPage {

    public CartPage clickOnDeleteIcon() {
        changeItemButton.click();
        itemAmountIcon.click();
        deleteIcon.should(Condition.interactable);
        deleteIcon.click();
        return new CartPage();
    }
}
