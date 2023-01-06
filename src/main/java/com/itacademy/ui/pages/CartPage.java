package com.itacademy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends MainPage{
    protected final SelenideElement itemTitle = $x("//div[@class='cart-form__description cart-form__description_primary cart-form__description_base cart-form__description_condensed-complementary cart-form__description_nonadaptive']");
    protected final SelenideElement changeItemButton = $x("//*[@class='cart-form__link cart-form__link_primary cart-form__link_tiny cart-form__link_font-weight_normal cart-form__link_ellipsis']");
    protected final SelenideElement deleteIcon = $(".cart-form__control > a");
    protected final SelenideElement itemAmountIcon = $(".cart-form__offers-part_count > div > div > div > input");
    protected final SelenideElement deletedItemMessage = $(".cart-form__description_condensed-extra");

    public String getItemName() {
        return itemTitle.getText();
    }

    public boolean isItemDeleted() {
        deletedItemMessage.should(Condition.visible);
        return deletedItemMessage.isDisplayed();
    }

}
