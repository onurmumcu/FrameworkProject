package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class HomePageTest extends Base{
	
	@Test
	public void basePageNavigation() throws IOException {
		driver=initializeDriver();
		driver.get("http://qaclickacademy.com");
		driver.manage().window().maximize();
		
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
	}

}
