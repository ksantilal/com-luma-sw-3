package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {
        //Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try { //Click on Bags
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Bags')]")));
            element.click();
        } catch (ElementNotInteractableException e) {
            System.out.println(e.getMessage());
        }
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        String aProduct = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        //Verify the text ‘Overnight Duffle’
        String eProduct = "Overnight Duffle";
        Assert.assertEquals(eProduct, aProduct);

        driver.findElement(By.id("qty")).clear();
        //Change Qty 3
        sendTextToElement(By.id("qty"), "3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        String aMsg = getTextFromElement(By.xpath("//div[contains(text(),'Overnight')]"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.'
        String eMsg = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals(eMsg, aMsg);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the product name ‘Overnight Duffle’
        String eName = "Overnight Duffle";
        String aName = getTextFromElement(By.xpath("//a[text() = 'Overnight Duffle']"));
        Assert.assertEquals(eName, aName);

        WebElement Qty = driver.findElement(By.xpath("//input[@title = 'Qty']"));
        String aQty = Qty.getAttribute("value");
        //Verify the Qty is ‘3’  //Verify the Qty is ‘3’
        String eQty = "3";
        Assert.assertEquals(eQty, aQty);
        //Verify the product price ‘$135.00’
        String aPrice = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        String ePrice = "$135.00";
        Assert.assertEquals(ePrice, aPrice);
        //Change Qty to ‘5’
        Qty.clear();
        Qty.sendKeys("5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        //Verify the product price ‘$225.00’
        String aTotal = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        String eTotal = "$225.00";
        Assert.assertEquals(eTotal, aTotal);

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
