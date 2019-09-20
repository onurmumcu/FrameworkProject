package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public  WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		prop.load(fis);
//		String browserName= prop.getProperty("browser");
		
		
	String browserName= 	System.getProperty("browser");
		
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
			options.addArguments("--headless");
			}
			   driver = new ChromeDriver(options);
		}else if(browserName.equals("firefox")){
			
			//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			   driver = new FirefoxDriver();
		}else if(browserName==null) {
			System.out.println("============ NO WEBDRIVER ===============");
		}
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			return driver;	
	}

}
