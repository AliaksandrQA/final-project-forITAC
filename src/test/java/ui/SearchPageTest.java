package ui;

import com.itacademy.ui.pages.ResultPage;
import com.itacademy.ui.steps.MainPageSteps;
import io.qameta.allure.Attachment;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SearchPageTest extends WebUIBaseTest {
    @Attachment(type = "image/png")
    @Test
    public void searchingItem() {
        String itemModelName = "Marshall Major IV";
        openHomePage();

        String actualName = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .getItemName();
        Assertions.assertThat(actualName).contains(itemModelName);
    }


    @Test
    public void checkingItemModelName() {
        String itemModelName = "Nothing Phone (1) 12GB/256GB";
        openHomePage();

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualName = ResultPage
                .getResultItemList()
                .get(0)
                .getTitleText();
        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void checkingItemOS() {
        String itemModelName = "Samsung Galaxy S22 5G";
        String itemModelOS = "Android";
        openHomePage();

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualName = ResultPage
                .getResultItemList()
                .get(0)
                .getDescription();
        Assertions.assertThat(actualName).contains(itemModelOS);
    }

    @Test
    public void checkingItemPriceEdge() {
        String itemModelName = "Google Pixel 6 8GB/128GB";
        String requiredItemPrice = "1600";
        openHomePage();

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualPrice = ResultPage
                .getResultItemList()
                .get(0)
                .getPrice();
        Assertions.assertThat(actualPrice).contains(requiredItemPrice);
    }

    private void openHomePage() {
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();
    }
}
