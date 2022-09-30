package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.Resources_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Resources {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=common/home";
	Resources_page r;
		
		@BeforeMethod
		public void launchDriver() {
			//fill your code here
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		@Test
		public void testMP() throws InterruptedException {
			
			//fill your code here
			 r = new Resources_page(driver);
			 driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
			 Thread.sleep(2000);
		     driver.findElement(By.linkText("OpenCart Books")).click();
		     Thread.sleep(2000);
		     r.AddToCart();
		     Thread.sleep(2000);
		     driver.get("https://www.opencart.com/index.php?route=common/home");
		     r.Newsletter("jainsarthak444@gmail.com");
		}
		
		@AfterMethod
		public void quitDriver() {
			//fill your code here
			driver.quit();
		}

}
