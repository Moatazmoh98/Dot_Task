package pages;


import com.shaft.db.DatabaseActions;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class loginTestCases {

    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    // Tests Cases


    @Test()
    public void loginWithCorrectEmailAndPassword() {
       new loginPage(driver)
               .newUserLogin(testData.getTestData("userName"), testData.getTestData("password") )
               .validateOnLoginVisibility();

    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("LoginWithCorrectEmailAndPasswordTestsTestData.json");
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new loginPage(driver)
          .navigateToHomePage();
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
