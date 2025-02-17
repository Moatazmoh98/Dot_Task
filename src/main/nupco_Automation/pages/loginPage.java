package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class loginPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private String URL = System.getProperty("baseUrl");

    // Locators
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By login_Button = By.id("login-button");
    private final By cart_Icon = By.xpath("//a[@class='shopping_cart_link']");

    // Constructor
    public loginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    @Step("Navigate To Login Page")
    public void navigateToHomePage() {
        driver.browser().navigateToURL(URL);
    }

    @Step("User Login With userName: {name} And Password: {password}")
    public loginPage newUserLogin(String name, String Password) {
        driver.element()
                .type(userName, name)
                .type(password, Password)
                .click(login_Button);

        return this;
    }

    //////////////////// Validations \\\\\\\\\\\\\\\\\\\\

    @Step("Validate On Login Visibility")
    public loginPage validateOnLoginVisibility(){
        driver.verifyThat().element(cart_Icon).exists().perform();
        return this;
    }



}
