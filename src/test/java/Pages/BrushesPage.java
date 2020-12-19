package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrushesPage {
    public WebDriver driver;

    public BrushesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__catalog")
    private WebElement catalogueBtn;

    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement categoryBtn;

    @FindBy(partialLinkText = "Зубные щетки и аксессуары")
    private WebElement subcategoryBtn;

    @FindBy(partialLinkText = "Посмотреть все товары")
    private WebElement allProductsBtn;

    @FindBy(name = "input-min")
    private WebElement input_min_field;

    @FindBy(name = "input-max")
    private WebElement input_max_field;

    @FindBy(className = "PriceSlider__header")
    private WebElement pricePanel;

    public void clickCatalogue(){
        catalogueBtn.click();
    }

    public void clickCategory(){
        categoryBtn.click();
    }

    public void clickSubcategory(){
        subcategoryBtn.click();
    }

    public void clickAllProducts(){
        allProductsBtn.click();
    }

    public void SetPrice(String min, String max) {
        input_min_field.sendKeys(min);
        input_max_field.sendKeys(max);
        input_max_field.submit();
    }
}
