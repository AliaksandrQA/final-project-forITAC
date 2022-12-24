package com.itacademy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class ItemDetailsPage {
    protected final SelenideElement buyButton = $x("//a[contains(@class,'buy')][1]");
    protected final SelenideElement addCartButton = $(".product-aside__button_cart.button-style_expletive");
    protected final SelenideElement itemTitle = $(".catalog-masthead");
    protected final SelenideElement locationAreaButton = $(".button-style_base.product-aside__button");
    protected final SelenideElement moveToCartButton = $x("//a[contains(@class,'button-style button-style_another button-style')]");
    protected ElementsCollection elementList = $$(By.xpath("//div[@class='result__item result__item_product']"));
    protected final ElementsCollection itemsList = $$(".search__results");

    private final List resultItemList = new ArrayList<>();

    public String getItemName() {
        return itemTitle.should(Condition.visible).getText();
    }
}
