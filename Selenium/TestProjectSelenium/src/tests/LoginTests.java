package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;// sve klase iz loginPage klase ce nam biti ovde dostupne

public class LoginTests extends BaseTest{
    
    public LoginPage loginPage; 
    public HomePage homePage; 
    String homepageTitle = "PRODUCTS";
    String invalidUsername = "invalid Username";
    String invalidPassword = "invalid password";
    String lockedUserName = "locked_out_user";
    String messageErrorForLocked = "Epic sadface: Sorry, this user has been locked out.";
    String messageErrorOne = "Epic sadface: Username and password do not match any user in this service";

   
    
    @Test
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);


        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.verifyLogin(homepageTitle);

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    @Test
    public void invalidUsername() {
        loginPage = new LoginPage(driver);
        
        loginPage.basePage();
        loginPage.login(invalidUsername, validPassword);
        loginPage.verifyUnseccesfulLogin(messageErrorOne);
       

    }   
    @Test 
    public void invalidPassword() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, invalidPassword);
        loginPage.verifyUnseccesfulLogin(messageErrorOne);

    }
    @Test
    public void emptyUsername() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(" ", validPassword);
        loginPage.verifyUnseccesfulLogin(messageErrorOne);

    }
    @Test
    public void emptyPassword() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, " ");
        loginPage.verifyUnseccesfulLogin(messageErrorOne);

    }
    @Test
    public void lockedOutUser() {
        loginPage = new LoginPage(driver);
        

        loginPage.basePage();
        loginPage.login(lockedUserName, validPassword);
        loginPage.verifyUnseccesfulLogin(messageErrorForLocked);
    
    }    

}
