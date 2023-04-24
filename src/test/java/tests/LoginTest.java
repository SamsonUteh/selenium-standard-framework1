package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.SignInPage;
import resources.Base;

public class LoginTest extends Base {
	
	Logger log;
	public WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {
				
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		
		SignInPage signInPage = new SignInPage(driver);
		signInPage.emailAddressField().sendKeys(email);
		signInPage.passwordField().sendKeys(password);
		signInPage.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
//		Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
		try {
			if(accountPage.editAccountInformationOption().isDisplayed()) {
				
				actualResult = "Successful";
			};
		} catch(Exception e) {
			actualResult = "Failure";
		}
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		Logger log = LogManager.getLogger(LoginTest.class.getName());
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"mark@gmail.com", "mark234", "Successful"},{"s2amson@gmail.com", "good", "Failure"}};
		return data;
	}

}
