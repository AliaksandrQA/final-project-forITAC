package ui;

import com.itacademy.ui.pages.ResultPage;
import com.itacademy.ui.steps.LoginFramePageSteps;
import com.itacademy.ui.steps.MainPageSteps;
import com.itacademy.utils.PropertyManager;
import io.qameta.allure.Attachment;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

/* TODO имя класса все-таки должно быть то что  проверяем.
   здесь, конечно, тестов не много, поэтому они поместились в один класс. Но по факту они проверяют разный функционал
   Скорее всего нужно разделить эти методы по разным тестовым классам (сьютам)
   LoginPageTest (или LoginFormTest, или LoginTest)
   SearchPageTest
   CartPageTest (или CartTest)

 */
public class UITests extends WebUIBaseTest {
    @Attachment(type = "image/png")
    @Test
    public void login() {
        String userName = PropertyManager.getProperties("USER_NAME");
        String password = PropertyManager.getProperties("PASSWORD");

        /* TODO две разных проверки в одном тесте.
        Нужно вынести три строчки кода в отдельный метод testHomePage
        */
        MainPageSteps steps = new MainPageSteps();
        steps.openPage();
        Assert.assertTrue(steps.isMainSiteLogoPresent());

        steps.clickOnLoginButton();

        Assert.assertTrue(new LoginFramePageSteps()
                .loginDataEntering(userName, password)
                .isLogged());
    }

    @Test
    public void invalidLogin() {
        String invalidUserName = PropertyManager.getProperties("INVALIDUSERNAME");
        String password = PropertyManager.getProperties("PASSWORD");

        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();
        mainPagesteps.clickOnLoginButton();

        LoginFramePageSteps loginSteps = new LoginFramePageSteps();
        loginSteps.invalidLoginDataEntering(invalidUserName, password);
        Assert.assertTrue(loginSteps.isLoginInCorrect());

    }

    @Test
    public void searchingItem() {
        String itemModelName = "Google Pixel 6 8GB/128GB";
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

        /* TODO в строчке кода ниже есть new MainPageSteps()
           а в строчках выше есть MainPageSteps mainPagesteps = new MainPageSteps();
           вопрос? mainPagesteps нельзя ниже использовать?
           аналогичный вопрос там дальше в тестах такие же фрагменты использования
         */
        String actualName = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .getItemName();
        Assertions.assertThat(actualName).contains(itemModelName);
    }

    @Test
    public void addingItemToCart() {
        /* TODO хорошо было бы чтобы в разных тестах использовались разные тестовые данные,
            если такая возможность есть. Так мы хоть какое-то разнообразие
            тестовых данных создадим. Чтобы не случилась ситуация, что
            система работает только на этих данных.

         */
        String itemModelName = "Google Pixel 6 8GB/128GB";
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

        String actualName = new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .getItemName();
        Assertions.assertThat(actualName).contains(itemModelName);

    }
    @Test
    public void removingItemFromCart(){
        String itemModelName = "Google Pixel 6 8GB/128GB";
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

        boolean itemDeleted =new MainPageSteps()
                .searchDevice(itemModelName)
                .chooseItem()
                .addItemToCart()
                .clickOnDeleteIcon()
                .isItemDeleted();
        Assert.assertTrue(itemDeleted);
    }
    @Test
    public void checkingItemModelName(){
        String itemModelName = "Google Pixel 6 8GB/128GB";
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

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
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

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
        MainPageSteps mainPagesteps = new MainPageSteps();
        mainPagesteps.openPage();

        new MainPageSteps()
                .searchDevice(itemModelName);

        String actualPrice = ResultPage
                .getResultItemList()
                .get(0)
                .getPrice();
        Assertions.assertThat(actualPrice).contains(requiredItemPrice);
    }
}