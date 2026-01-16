package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    // локатор кнопки принять Cookie
    private By acceptCookieButton = By.id("rcc-confirm-button");
    // локатор лого Самоката
    private By samokatLogo = By.cssSelector(".Header_LogoScooter__3lsAR");
    // локатор лого Яндекса
    private By yandexLogo = By.cssSelector(".Header_LogoYandex__3TSOI");

    public BasePage(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    // метод кликает по кнопке принять Cookie
    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }

    public void clickSamokatLogo() {
        driver.findElement(samokatLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
        goToNextTab();
    }

    public void goToNextTab() {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

}
