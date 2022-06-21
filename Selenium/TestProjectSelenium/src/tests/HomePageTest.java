package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    

    int numberOfAllItems = 6;
    String firstMenuTitle = "ALL ITEMS";
    String secondMenuTitle = "ABOUT";
    String thirdMenuTitle = "LOGOUT";



@Test
public void checkNumberOfItemsOnHomePage(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(validUsername, validPassword);
    homePage.validateNumberOfProducts(numberOfAllItems);
}
@Test
public void validateMenuItemTitles(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(validUsername, validPassword);
    homePage.openMenu();
    homePage.validateMenuItemTitles(firstMenuTitle, secondMenuTitle, thirdMenuTitle);
    }
@Test 
public void validateAboutUrl(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(validUsername, validPassword);
    homePage.openMenu();
    homePage.verifyAboutLink();
}
}