package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


    public class Utility extends BaseTest {
        /**
         * This method will click on element
         */
        public void clickOnElement(By by) {
            driver.findElement(by).click();
        }

        /**
         * This method will send text on element
         */
        public void sendTextToElement(By by, String text) {
            // WebElement element = driver.findElement(by);
            // element.sendKeys(text);
            driver.findElement(by).sendKeys(text);

        }

        /**
         * This method will get text from element
         */
        public String getTextFromElement(By by) {
       /* WebElement webElement = driver.findElement(by);
        String text = webElement.getText();
        return text;*/
            return driver.findElement(by).getText();
        }
        //*********************************Alert Method *******************************

        /**
         * This method will switch to alert
         */
        public void switchToAlert() {
            driver.switchTo().alert();
        }

        /**
         * This method will switch to alert
         */
        public void acceptAlert() {
            driver.switchTo().alert().accept();
        }

        /**
         * This method will dismiss to alert
         */
        public void dismissAlert() {
            driver.switchTo().alert().dismiss();
        }

        /**
         * This method will get alert text
         */

        public String getTextAlert(By by) {
            return driver.switchTo().alert().getText();
        }

        /**
         * This method will send text to alert
         */
        public void sendTextAlert(By by, String text) {
            driver.switchTo().alert().sendKeys(text);
        }

        //*************************Select Method*********************

        public void selectByValueFromDropDown(By by, String value) {
            WebElement dropDown = driver.findElement(by);
            // Create the object of select class
            Select select = new Select(dropDown);
            select.selectByValue(value);
        }

        // Select by visible from dropdown

        public void selectByVisibleTextFromDropDown(By by, String visibleText) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByVisibleText(visibleText);
        }

        // Select by index from dropdown
        public void selectByIndexFromDropDown(By by, int index) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByIndex(index);
        }

        // Select by contains text drop dropdown
        public List<String> selectByContainsTextFromDropDown(By by) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);

            List<String> optionsText = new ArrayList<>();
            for (WebElement option : select.getOptions()) {
                optionsText.add(option.getText());
            }
            return optionsText;
        }


        //*********************************Action Method **********************************

        /**
         * This method will use to hover mouse on element
         */

        public void mouseHoverToElement(By by) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(by)).build().perform();

        }

        /**
         * This method will use to right click on element
         */
        public void rightClickOnElement(By by) {
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(by);
            actions.contextClick(element).build().perform();
        }

        /**
         * This method performs a drag-and-drop on element.
         */
        public void dragAndDrop(By source, By target) {
            Actions actions = new Actions(driver);
            WebElement sourceElement = driver.findElement(source);
            WebElement targetElement = driver.findElement(target);
            actions.dragAndDrop(sourceElement, targetElement).build().perform();
        }

        /**
         * Slider - Dragging the Slider
         */
        public void setSliderValue(By sliderLocator, int valueToSet) {
            WebElement slider = driver.findElement(sliderLocator);
            int sliderWidth = slider.getSize().getWidth();
            int xOffset = (int) (sliderWidth * (valueToSet / 100.0));
            Actions actions = new Actions(driver);
            actions.clickAndHold(slider).moveByOffset(xOffset, 0).release().build().perform();
        }

        /**
         * Keyboard Events
         */
        public void performKeyboardEvent(By elementLocator, CharSequence keys) {
            WebElement element = driver.findElement(elementLocator);
            Actions actions = new Actions(driver);
            actions.sendKeys(element, keys).build().perform();
        }
    }

