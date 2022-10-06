package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.Resources_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resources_test {
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
			 r = new Resources_page(driver);
		}
		@Test(priority=0)
		public void showcase() throws InterruptedException {
			r.resources();
			Thread.sleep(1000);
			r.showcase();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(1000);
			r.showcase_allStores();
			Thread.sleep(1000);
			r.showcase_closthesAppeal();
			Thread.sleep(1000);
			r.showcase_techGadgets();
			Thread.sleep(1000);
		}
		
		@Test(priority=1)
		public void contactUs() throws InterruptedException {
			r.resources();
			Thread.sleep(2000);
			r.contactUs();
			Thread.sleep(2000);
			r.contactUs_input1();
			Thread.sleep(2000);
			r.contactUs_input2();
			Thread.sleep(1000);
			r.contactUs_input3();
			Thread.sleep(2000);
			r.contactUs_input4();
			Thread.sleep(2000);
		}
		
		@Test(priority=2)
		public void partners() throws InterruptedException {
			r.resources();		
			Thread.sleep(2000);
			r.opencartPartner();
			Thread.sleep(2000);
			r.openCartPrtnerCountry();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
			r.oc_partner_view();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();	
		}
		
		@Test(priority=3)
		public void Books() throws InterruptedException {
			
			//fill your code here
			
			 driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
			 Thread.sleep(2000);
		     driver.findElement(By.linkText("OpenCart Books")).click();
		     Thread.sleep(2000);
		     r.AddToCart();
		     Thread.sleep(2000);
		    
		}
		
		@Test(priority=4)
		public void git_bug_tracker() throws InterruptedException{
			r.gitTrack();
		}
		
		@Test(priority=5)
		public void forums() throws InterruptedException {
			r.comn_forum("Project_OC", "abc@123");
		}

		@AfterMethod
		public void quitDriver() {
			//fill your code here
			driver.quit();
		}

}
