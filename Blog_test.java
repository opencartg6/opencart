package com.test;

import com.pages.Blog_page;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Blog_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com/blog";
    Blog_page b;
 
	    	@BeforeMethod
	    	public void launchDriver() throws IOException {
	    	WebDriverManager.chromedriver().setup();
	    	//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			b = new Blog_page(driver);
	    	}
	  
	        @Test(priority=0)
	        public void Read() throws InterruptedException, IOException {
	        	b.SearchBox("google");
	        	
	        }
	        
	        @Test(priority=1)
	        public void trendingRead() throws InterruptedException {
	        	b.TrendingBlog();
	        }
	     
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}
}



