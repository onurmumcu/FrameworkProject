package TestCases;

import java.io.IOException;


import org.openqa.selenium.By;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base{


public void basePageNavigation(String userName, String password, String text) throws IOException, InterruptedException {
		driver=initializeDriver();
		driver.get("http://qaclickacademy.com");
		driver.manage().window().maximize();
		
		LandingPage l = new LandingPage(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		
		String actual =  l.getTitle().getText();
		//Assert.assertEquals(actual, "FEATURED COURSES");
	
		l.getLogin().click();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		lp.getLogin().click();
		
	
	}
	

	

	public Object [][] getData(){
		
		Object [][] data = new Object [2][3];
		data[0][0]  = "sdjshdffsijh";
		data[0][1]  = "sdjshsijh";
		data[0][2]  = "Restricted User";
		
		data[1][0]  = "sdfishfsijh";
		data[1][1]  = "sdjsshfsijh";
		data[1][2]  = "Non restricted User";
		
		
		
		return data;
		
	}

}
