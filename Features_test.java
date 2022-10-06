package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.Features_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Features_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com";
    Features_page f;
 
	    	@BeforeMethod
	    	public void launchDriver() throws IOException {
	    	WebDriverManager.chromedriver().setup();
	    	//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			f = new Features_page(driver);
	    	}

		    @Test(priority=0)
		    public void Read() throws InterruptedException, IOException {
		        	f.explore();
		        }
		    
	        @Test(priority=1)
	        public void newsletterValid() throws InterruptedException {
	        	f.Newsletter("nupurkomari@gmail.com");
	        	Thread.sleep(2000);
	        	driver.switchTo().alert().accept();
	        	Thread.sleep(2000);
	        }
	        
	        @Test(priority=2)
	        public void newsletterInvalid() throws InterruptedException {
	        	f.Newsletter("abc");
	        	driver.switchTo().alert().accept();
	        	Thread.sleep(2000);
	        }
	        
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}

}
