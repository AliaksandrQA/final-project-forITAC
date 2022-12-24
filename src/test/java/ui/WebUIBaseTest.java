package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.itacademy.configuration.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebUIBaseTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = ConfigManager.CONFIG.baseUiUrl();


    }

    @BeforeTest
    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeTest
    public void init() {
        setUp();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
