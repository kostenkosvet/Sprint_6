package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderStatusPage {
    private WebDriver driver;

    // локатор кнопки Статус заказа
    private By orderStatusButton = By.cssSelector(".Header_Link__1TAG7");
    // локатор поля Номер заказа
    private By orderStatusField = By.cssSelector(".Header_SearchInput__3YRIQ input[placeholder='Введите номер заказа']");
    // локатор кнопки Go
    private By goButton = By.cssSelector(".Header_SearchInput__3YRIQ .Button_Button__ra12g");
    //локатор картинки Такого заказа нет
    private By noOrderFoundImg = By.xpath(".//img[@src='/assets/not-found.png']");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void setOrderStatus(String order) {
        WebElement element = driver.findElement(orderStatusField);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(order);
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void checkOrderByNumber(String order) {
        clickOrderStatusButton();
        setOrderStatus(order);
        clickGoButton();
    }

    public boolean isNoSuchOrderImgVisible() {
        WebElement element = driver.findElement(noOrderFoundImg);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();
    }

}
