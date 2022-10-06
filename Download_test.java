package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Download_page;
import com.pages.Login_page;
import com.pages.Marketplace_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_test {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Download_page d;
	Login_page l;
		
		@BeforeMethod
		public void launchDriver() {
			//fill your code here
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			d = new Download_page(driver);
			l = new Login_page(driver);
		}
		
		@Test(priority=0)
		public void testDwn() throws InterruptedException {
			
			//fill your code here
			
			//driver.findElement(By.linkText("Login")).click();
			l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
			driver.findElement(By.linkText("Download")).click();
	        Thread.sleep(2000);
			d.dwn_localhost();
			Thread.sleep(2000);
		}
		
		@Test(priority=1)
		public void addExtension() throws InterruptedException {
			//driver.findElement(By.linkText("Download")).click();
			l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
			driver.findElement(By.linkText("Download")).click();
	        Thread.sleep(2000);
			d.dwn_extension();

		}
	
		@AfterMethod
		public void quitDriver() {
			//fill your code here
			driver.quit();
		}

}
