package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {// konstruktor
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void click(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }
    public void writeText (By elementBy, String text) {// elemenyBy nad elementom koji smo locirali
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public void assertStringEquals (String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertElementVisible(By elementBy){
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible);
    }

    public String readHref(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
    }
    public int countItems(By elementBy){
         waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }
    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public List<WebElement> locateElements( By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }
    
}
