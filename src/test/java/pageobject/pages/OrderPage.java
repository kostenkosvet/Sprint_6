package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class OrderPage {

    private WebDriver driver;

    // локатор поля Имя
    private By nameField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Имя']");
    // локатор поля Фамилия
    private By surnameField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Фамилия']");
    // локатор поля Адрес
    private By addressField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Адрес: куда привезти заказ']");
    // локатор dropdown Метро
    private By metroField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Станция метро']");
    // локатор всех dropdown option Метро
    private By metroFieldOption = By.cssSelector(".select-search__select button");
    // локатор поля Телефон
    private By phoneField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки Далее
    private By nextButton = By.cssSelector(".Order_NextButton__1_rCA .Button_Button__ra12g");
    // локатор поля Когда привезти самокат
    private By calendarField = By.cssSelector(".Order_Form__17u6u input[placeholder='* Когда привезти самокат']");
    // локатор недели в выпадающем календаре
    private By calendarFieldWeek = By.cssSelector(".react-datepicker__week");
    // локатор поля Срок аренды
    private By termField = By.cssSelector(".Dropdown-root");
    // локатор dropdown Срока аренды
    private By termFieldOptions = By.cssSelector(".Dropdown-menu .Dropdown-option");
    // локатор чекбоксов цвета
    private By colourCheckboxes = By.cssSelector(".Order_Checkboxes__3lWSI label");
    // локатор поля Комментария для курьера
    private By commentField = By.cssSelector(".Order_Form__17u6u input[placeholder='Комментарий для курьера']");
    // локатор кнопки Заказать
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // локатор кнопки Подтвердить заказ
    private By confirmButton = By.xpath(".//button[text()='Да']");
    // локатор Заголовка Подтверждения
    private By orderConfirmationHeader = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroField).click();
        WebElement metroOption = driver.findElement(
                with(By.xpath(".//*[text()='" + metro + "']")) // Ищем элемент с текстом
                        .below(metroFieldOption) // Который НИЖЕ поля metroFieldOption
        );
        metroOption.click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void setToWhom(String name, String surname, String address, String metro, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setDeliveryDate(int date) {
        driver.findElement(calendarField).click();
        WebElement calendarDay = driver.findElement(
                with(By.xpath(".//*[text()='" + date + "']"))
                        .below(calendarFieldWeek)
        );
        calendarDay.click();
    }

    public void setTerm(int index) {
        driver.findElement(termField).click();
        driver.findElements(termFieldOptions).get(index).click();
    }

    public void chooseColour(int index) {
        driver.findElements(colourCheckboxes).get(index).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void setOrderInfo(int date, int termIndex, int colourIndex, String comment) {
        setDeliveryDate(date);
        setTerm(termIndex);
        chooseColour(colourIndex);
        setComment(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void fillAllOrderForm(String name, String surname, String address, String metro, String phone,
                                 int date, int termIndex, int colourIndex, String comment) {
        setToWhom(name, surname, address, metro, phone);
        clickNextButton();
        setOrderInfo(date, termIndex, colourIndex, comment);
        clickOrderButton();
    }

    public String getOrderConfirmationHeaderText() {
        return driver.findElement(orderConfirmationHeader).getText();
    }

}
