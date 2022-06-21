package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    By headerTitleV2By = By.xpath("//*[@id='header_container']/div[2]/span");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By menuButtonBy = By.xpath("//*[@id='react-burger-menu-btn']");

    By menuTitleAllItems= By.xpath("//*[@id='inventory_sidebar_link']");

    By menuTitleAbout= By.xpath(" //*[@id='about_sidebar_link']");
    By menuTitleLogout = By.xpath(" //*[@id='logout_sidebar_link']");
    By aboutButton = By.xpath("//*[@id='about_sidebar_link']");
    String expectedHref = "https://saucelabs.com/";
  
       public HomePage verifyLogin( String expectedText){
        String pageTitle = readText(headerTitleV2By);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }


    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actualNumberOfProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public HomePage openMenu(){
        click(menuButtonBy);
        return this;
    }
    public HomePage verifyAboutLink(){
        String actualHref = readHref(aboutButton);
        assertStringEquals(expectedHref, actualHref);
        return this;
    }
    public HomePage validateMenuItemTitles(String expectedText1, String expectedText2, String expectedText3 ){
        String allItemsTitle = readText(menuTitleAllItems);
        assertStringEquals( allItemsTitle, expectedText1 );

        String aboutTitle = readText(menuTitleAbout);
        assertStringEquals( aboutTitle, expectedText2 );

        String logoutTitle = readText(menuTitleLogout);
        assertStringEquals( logoutTitle, expectedText3 );
        return this;
    }
}
    