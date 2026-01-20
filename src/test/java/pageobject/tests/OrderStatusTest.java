package pageobject.tests;

import org.junit.jupiter.api.Test;
import pageobject.pages.OrderStatusPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderStatusTest extends BaseTest {

    @Test
    void checkIncorrectOrderStatus() {
        OrderStatusPage orderStatusPage = new OrderStatusPage(getDriver());
        orderStatusPage.checkOrderByNumber("1234v");
        assertTrue(orderStatusPage.isNoSuchOrderImgVisible());
    }

}
