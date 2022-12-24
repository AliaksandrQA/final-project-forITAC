package com.itacademy.ui.steps;

import com.codeborne.selenide.Condition;
import com.itacademy.ui.pages.ItemDetailsPage;

public class ItemsDetailsPageSteps extends ItemDetailsPage {

    public CartPageSteps addItemToCart() {
        addCartButton.should(Condition.visible);
        addCartButton.click();
        locationAreaButton.should(Condition.enabled);
        buyButton.click();
        return new CartPageSteps();
    }


}
