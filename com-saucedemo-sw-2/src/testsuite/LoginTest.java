package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // Enter “standard_user” username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // Enter “secret_sauce” password
        driver.findElement(By.id("login-button")).click(); // * Click on ‘LOGIN’ button

        /// <div class="inventory_item_name ">Sauce Labs Bike Light</div>
        String expectedText = "Sauce Labs Bike Light";
        // Find the error message
        String actualText = driver.findElement(By.xpath("//div[@class='inventory_item_name ']//div[text()='Sauce Labs Bike Light']")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // Enter “standard_user” username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // Enter “secret_sauce” password
        driver.findElement(By.id("login-button")).click(); // * Click on ‘LOGIN’ button

     // * Verify that six products are displayed on page
        driver.findElement(By.xpath("//a[@id='item_1_img_link']")).isDisplayed(); //Product 1 is display
        driver.findElement(By.xpath("//a[@id='item_2_img_link']")).isDisplayed(); //Product 2 is display
        driver.findElement(By.xpath("//a[@id='item_3_img_link']")).isDisplayed(); //Product 3 is display
        driver.findElement(By.xpath("//a[@id='item_4_img_link']")).isDisplayed(); //Product 4 is display
        driver.findElement(By.xpath("//a[@id='item_5_img_link']")).isDisplayed(); //Product 5 is display
        driver.findElement(By.xpath("//a[@id='item_6_img_link']")).isDisplayed(); //Product 6 is display


        driver.quit();

    }
}
