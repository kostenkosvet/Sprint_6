package pageObject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserConfig {

    public static WebDriver setBrowserName(Browser browser) {

        switch (browser) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new FirefoxDriver(firefoxOptions);
            default:
                System.out.println("Wrong browser name");
                return null;
        }

    }
}
