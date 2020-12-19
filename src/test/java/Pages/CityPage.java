package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityPage {
    public WebDriver driver;

    public CityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(partialLinkText = "Мой профиль")
    private WebElement profileBtn;

    @FindBy(partialLinkText = "Выйти")
    private WebElement logOutBtn;

    @FindBy(className = "MainHeader__city")
    private WebElement cityPageBtn;

    @FindBy(className = "AuthPopup")
    private WebElement loginButton;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(className = "SignIn__actions")
    private WebElement submitButton;

    @FindBy(name = "pass")
    private WebElement passwdField;

    @FindBy(className = "delivery_address")
    private WebElement address;

    @FindBy(className = "HeaderUserName__name")
    private WebElement userName;

    @FindBy(className = "HeaderUserName")
    private WebElement userBtn;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }


    public void clickSubmit() {
        submitButton.click(); }

    public void GoToProfile(){
        userName.click();
        profileBtn.click();
    }

    public String GetAddress(){
        return address.getText().split(",")[0];
    }

    public void LogOut(){
        userBtn.click();
        logOutBtn.click();
    }

    public void clickCityPage(){
        cityPageBtn.click();
    }

    public String GetCurrentCity(){
        return cityPageBtn.getText();
    }

    public void clickChangeCity(String cityname){
        WebElement chosen_city = driver.findElement(By.partialLinkText(cityname));
        chosen_city.click();
    }
}
