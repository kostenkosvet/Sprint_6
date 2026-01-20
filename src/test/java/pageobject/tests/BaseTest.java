package pageobject.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pageobject.pages.BasePage;
import pageobject.utils.Browser;
import pageobject.utils.BrowserConfig;

public class BaseTest {

    private WebDriver driver;
    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    @BeforeEach
    void startUp() {
        driver = BrowserConfig.setBrowserName(Browser.CHROME);
//        driver = BrowserConfig.setBrowserName(Browser.FIREFOX);
        // Открой страницу тестового стенда

        driver.get(BASE_URL);

        BasePage basePage = new BasePage(driver);
        basePage.clickAcceptCookieButton();
    }

    WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
