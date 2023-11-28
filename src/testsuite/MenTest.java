package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
        Thread.sleep(1000);
        // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        // Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//a[@class='product-item-link']"));
        clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black
        clickOnElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),'Cronus ')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the text ‘Shopping Cart.’
        String expectedMessage1 = "Shopping Cart";
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Shopping Cart']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // Verify the product name ‘Cronus Yoga Pant’
        String expectedMessage2 = "Shopping Cart";
        String actualMessage2 = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        // Verify the product size ‘32’
        String expectedMessage3 = "32";
        String actualMessage3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expectedMessage3, actualMessage3);
        // Verify the product colour ‘Black’
        String expectedMessage4 = "Black";
        String actualMessage4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expectedMessage4, actualMessage4);
    }

    @After
    public void tearDown() {
        //Close the Browser
        driver.quit();
    }


}
