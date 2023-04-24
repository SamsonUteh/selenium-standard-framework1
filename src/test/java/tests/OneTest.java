package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class OneTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void oneTest() throws IOException, InterruptedException {
		System.out.println("one test");
		
	    driver = initialiseDriver();
		driver.get("http://tutorialsninja.com/demo");
		Thread.sleep(4000);
		driver.close();
	}

}
