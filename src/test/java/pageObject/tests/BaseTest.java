package pageObject.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pageObject.pages.BasePage;
import pageObject.utils.Browser;
import pageObject.utils.BrowserConfig;

public class BaseTest {

    private WebDriver driver;

    @BeforeEach
    void startUp() {
        driver = BrowserConfig.setBrowserName(Browser.CHROME);
//        driver = BrowserConfig.setBrowserName(Browser.FIREFOX);
        // Открой страницу тестового стенда
        driver.get("https://qa-scooter.praktikum-services.ru/");

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
