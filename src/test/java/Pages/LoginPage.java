package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора поля ввода логина
     */

    @FindBy(className = "AuthPopup")
    private WebElement loginButton;

    @FindBy(name = "login")
    private WebElement loginField;
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(className = "SignIn__actions")
    private WebElement submitButton;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(name = "pass")
    private WebElement passwdField;

    @FindBy(className = "HeaderUserName__name")
    private WebElement userName;

    public void clickLoginButton() {
        loginButton.click();
    }
    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login); }
    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */

    public void clickSubmit() {
        submitButton.click(); }

    public String GetUserName(){
        return userName.getText();
    }
}