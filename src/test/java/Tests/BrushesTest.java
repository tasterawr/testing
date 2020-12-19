package Tests;

import Pages.BrushesPage;
import Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrushesTest {
    public static BrushesPage brushesPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        brushesPage = new BrushesPage(driver);
    }

    @Test
    public void BrushTest() throws InterruptedException {
        brushesPage.clickCatalogue();
        brushesPage.clickCategory();
        brushesPage.clickSubcategory();
        brushesPage.clickAllProducts();
        brushesPage.SetPrice(ConfProperties.getProperty("min_price"), ConfProperties.getProperty("max_price"));
    }

    @AfterClass
    public static void EndTest(){
        driver.quit();
    }
}
