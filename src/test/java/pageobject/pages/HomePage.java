package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // локатор всех элементов FAQ Dropdown вопросов
    private By faqDropdownElements = By.cssSelector(".Home_FAQ__3uVm4 .accordion__item .accordion__button");
    // локатор всех элементов FAQ Dropdown ответов
    private By faqDropdownTextElements = By.cssSelector(".Home_FAQ__3uVm4 .accordion__item .accordion__panel");
    // локатор верхней кнопки "Заказать"
    private By topOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    // локатор нижней кнопки "Заказать"
    private By bottomOrderButton = By.cssSelector(".Home_RoadMap__2tal_ .Button_Button__ra12g");

    public HomePage(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    public void clickFAQDropdown(int index) {
        WebElement element = driver.findElements(faqDropdownElements).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    public WebElement getFAQDropdownTextElement(int index) {
        WebElement element = driver.findElements(faqDropdownTextElements).get(index);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElements(element));

        return element;
    }

    public String getFAQDropdownTextElementText(int index) {
        WebElement element = getFAQDropdownTextElement(index);
        return element.findElement(By.tagName("p")).getText();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

}
