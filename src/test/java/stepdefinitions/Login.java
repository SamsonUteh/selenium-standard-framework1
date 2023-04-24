package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.SignInPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landingPage;
	SignInPage signInPage;
	AccountPage accountPage;

    @Given("^Open any browser$")
    public void open_any_browser() throws IOException {
    	driver = initialiseDriver();
    }
    
    @And("^Navigate to login page$")
    public void navigate_to_login_page() {
    	driver.get(prop.getProperty("url"));
    	landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
    }


    @When("^User enters user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_user_name_as_something_and_password_as_something(String email, String password) {
    	signInPage = new SignInPage(driver);
		signInPage.emailAddressField().sendKeys(email);
		signInPage.passwordField().sendKeys(password);
    }
    
    @And("^User clicks on login button$")
    public void user_clicks_on_login_button() {
    	signInPage.loginButton().click();
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() throws Throwable {
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
    }
    
    @After
    public void closeBrowser() {
    	driver.close();
    }

    
   


}
