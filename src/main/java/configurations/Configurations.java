package configurations;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Configurations {
    WebDriver driver;
    String PATH_DRIVER_CHROME="./src/test/resources/drivers/chromedriver.exe";
    String TYPE_DRIVER_CHROME="webdriver.chrome.driver";

    public WebDriver setup(){
        System.setProperty(TYPE_DRIVER_CHROME,PATH_DRIVER_CHROME);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(2000,1));
        driver.manage().window().maximize();
        return driver;
    }
}
