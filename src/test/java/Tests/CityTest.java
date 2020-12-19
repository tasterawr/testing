package Tests;

import Pages.CityPage;
import Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class CityTest {
    public static CityPage cityPage;
    public static WebDriver driver;
    public static String cityname;

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
                { "Екатеринбург" },
                { "Магнитогорск" },
                { "Выборг" },
        });
    }

    public CityTest(String cityname){
        this.cityname = cityname;
    }

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        cityPage = new CityPage(driver);
    }



    @Test
    public void ChangeCityTest() throws InterruptedException {
        cityPage.clickCityPage();
        cityPage.clickChangeCity(cityname);
        Assert.assertEquals(cityname, cityPage.GetCurrentCity());
        cityPage.clickLoginButton();
        cityPage.inputLogin(ConfProperties.getProperty("login"));
        cityPage.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(5000);
        cityPage.clickSubmit();
        cityPage.GoToProfile();
        Thread.sleep(5000);
        String shipping_city = cityPage.GetAddress();
        Assert.assertEquals(cityname, shipping_city);
        cityPage.LogOut();
    }

    @AfterClass
    public static void EndTest(){
        driver.quit();
    }
}
