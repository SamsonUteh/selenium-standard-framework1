package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void twoTest() throws InterruptedException, IOException {
		System.out.println("two test");
		driver = initialiseDriver();
		driver.get("http://tutorialsninja.com/demo");
		Thread.sleep(4000);
		Assert.assertTrue(false);
		driver.close();
	}
	
	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}


}
