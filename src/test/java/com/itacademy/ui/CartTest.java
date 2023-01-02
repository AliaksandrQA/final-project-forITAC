package com.itacademy.ui;

import com.itacademy.ui.pages.MainPage;
import com.itacademy.ui.pages.ResultPage;
import com.itacademy.ui.steps.LoginFramePageSteps;
import com.itacademy.ui.steps.MainPageSteps;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    MainPageSteps mainPagesteps;

    @BeforeMethod
    public void openMainPage() {
        mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();
    }

    @Test
    public void addingItemToCart() {
        String itemModelName = "Google Pixel 6 8GB/128GB";

        String actualName = mainPagesteps
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .getItemName();

        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void removingItemFromCart(){
        String itemModelName = "Google Pixel 6 8GB/128GB";

        boolean itemDeleted = mainPagesteps
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .clickOnDeleteIcon()
                .isItemDeleted();

        Assert.assertTrue(itemDeleted);
    }
}