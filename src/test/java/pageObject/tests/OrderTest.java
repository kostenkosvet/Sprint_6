package pageObject.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pageObject.pages.HomePage;
import pageObject.pages.OrderPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends BaseTest {

    private static Stream<Arguments> orderInfo() {
        return Stream.of(
                Arguments.of("Иван", "Петров", "Улица Цветов 5", "Черкизовская", "89111234567",
                        10, 2, 0, "Спасибо!"),
                Arguments.of("Мария", "Иванова", "Красная площадь", "Коптево", "89117654321",
                        27, 4, 1, "Сдачи не надо")
        );
    }

    @ParameterizedTest
    @MethodSource("orderInfo")
    void checkPositiveFlowTopOrderButton(String name, String surname, String address, String metro, String phone,
                                         int date, int termIndex, int colourIndex, String comment) {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickTopOrderButton();
        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.fillAllOrderForm(name, surname, address, metro, phone, date, termIndex, colourIndex, comment);
        orderPage.clickConfirmButton();
        assertTrue(orderPage.getOrderConfirmationHeaderText().contains("Заказ оформлен"));
    }

    @ParameterizedTest
    @MethodSource("orderInfo")
    void checkPositiveFlowBottomOrderButton(String name, String surname, String address, String metro, String phone,
                                            int date, int termIndex, int colourIndex, String comment) {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBottomOrderButton();
        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.fillAllOrderForm(name, surname, address, metro, phone, date, termIndex, colourIndex, comment);
        orderPage.clickConfirmButton();
        assertTrue(orderPage.getOrderConfirmationHeaderText().contains("Заказ оформлен"));
    }
}
