package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testdata.JsonDataReader;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    JsonDataReader Reader = new JsonDataReader();
    Boolean found = false;

    private final By addButton = By.xpath("//*[name()='path' and contains(@d,'M12,2A10,1')]");
    private final By uploadImg = By.xpath("//input[@accept='.jpg,.png,.gif']");
    private final By title = By.xpath("//input[@name='title']");
    private final By description = By.xpath("//input[@name='description']");
    private final By price = By.xpath("//input[@name='price']");
    private final By createProductButton = By.xpath("//button[normalize-space()='Create Product']");
    private final By productsGrid = By.xpath("//div[@class='grid grid-cols-4 gap-7']");
    WebElement grid = driver.findElement(productsGrid);
    List<WebElement> products = grid.findElements(By.xpath(".//div[contains(@class, 'sc-jXbUNg eZFFTp flex flex-col p-4')]"));


    public WebElement getAddButton() {return driver.findElement(addButton);}
    public WebElement getPrice() {
        return driver.findElement(price);
    }
    public WebElement getTitle() {return driver.findElement(title);}
    public WebElement getDescription() {return driver.findElement(description);}
    public WebElement getUploadImg() {return driver.findElement(uploadImg);}
    public WebElement getCreateProductButton() {return driver.findElement(createProductButton);}

    public void makeSureThatAddedProductExistsInGrid(String expectedTitle, String expectedPrice) {
        for (WebElement product : products) {
            String title = product.findElement(By.className("sc-kpDqfm hfQJgD mt-4 cursor-pointer")).getText();
            String price = product.findElement(By.className("sc-jlZhew iBKUby flex justify-between items-center mt-4")).getText();

            if (title.equals(expectedTitle) && price.equals(expectedPrice)) {
                found = true;
                break;
            } else {
                found = false;
            }
        }
    }



}
