package com.itacademy.ui;

import com.itacademy.ui.steps.MainPageSteps;
import io.qameta.allure.Attachment;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends WebUIBaseTest {
    @Attachment(type = "image/png")
    @Test
    public void addingItemToCart() {
        String itemModelName = "Apple iPhone 14 128GB";
        openHomePage();

        String actualName = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .getItemName();
        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void removingItemFromCart() {
        String itemModelName = "Google Pixel 6 8GB/128GB";
        openHomePage();

        boolean itemDeleted = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .clickOnDeleteIcon()
                .isItemDeleted();
        Assert.assertTrue(itemDeleted);
    }

    private void openHomePage() {
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();
    }
}