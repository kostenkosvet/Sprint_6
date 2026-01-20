package pageobject.tests;

import org.junit.jupiter.api.Test;
import pageobject.pages.BasePage;
import pageobject.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderTest extends BaseTest {

    @Test
    void isSamokatPageOpenedByClickingSamokatLogoMainPage() {
        BasePage basePage = new BasePage(getDriver());
        basePage.clickSamokatLogo();
        assertEquals("https://qa-scooter.praktikum-services.ru/", getDriver().getCurrentUrl());
    }

    @Test
    void isSamokatPageOpenedByClickingSamokatLogoOrderPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickTopOrderButton();
        BasePage basePage = new BasePage(getDriver());
        basePage.clickSamokatLogo();
        assertEquals("https://qa-scooter.praktikum-services.ru/", getDriver().getCurrentUrl());
    }

    @Test
    void isYandexPageOpenedByClickingYandexLogo() {
        BasePage basePage = new BasePage(getDriver());
        basePage.clickYandexLogo();
        assertEquals("https://ya.ru/", getDriver().getCurrentUrl());
    }
}
