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

public class SearchTest extends BaseTest {

    @BeforeMethod
    public void openMainPage() {
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();
    }

    @Test
    public void searchingItem() {
        String itemModelName = "Google Pixel 6 8GB/128GB";

        String actualName = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .getItemName();

        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void checkingItemModelName(){
        String itemModelName = "Google Pixel 6 8GB/128GB";

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualName = ResultPage
                .getResultItemList()
                .get(0)
                .getTitleText();

        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void checkingItemOS(){
        String itemModelName = "Google Pixel 6 8GB/128GB";
        String itemModelOS = "Android";

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualName = ResultPage
                .getResultItemList()
                .get(0)
                .getDescription();

        Assertions.assertThat(actualName).contains(itemModelOS);
    }

    @Test
    public void checkingItemPriceEdge(){
        String itemModelName = "Google Pixel 6 8GB/128GB";
        String requiredItemPrice = "1600";

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualPrice = ResultPage
                .getResultItemList()
                .get(0)
                .getPrice();

        Assertions.assertThat(actualPrice).contains(requiredItemPrice);
    }
}