package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Account_page;
import com.pages.Login_page;
import com.pages.Marketplace_page;
import com.pages.Resources_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_end_Marketplace {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Account_page a;
	Login_page l;
	Marketplace_page m;
	Resources_page r;
	
		@BeforeMethod
		public void launchDriver() {
			//fill your code here
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			a = new Account_page(driver);
			l = new Login_page(driver);
			m = new Marketplace_page(driver);
			r = new Resources_page(driver);
			
		}
		
		@Test
		@Parameters({"username","fname","lname","company"}) 
		public void testMP(String username,String fname,String lname,String company) throws InterruptedException, IOException {
			
			//login
			File src = new File("D:\\CredentialForLoginPage.xlsx");	        
    		FileInputStream fileinput = new FileInputStream(src);	       
    		Workbook wb = new XSSFWorkbook(fileinput);	        
    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
	        String username1= Sheet1.getRow(1).getCell(0).getStringCellValue();	        
	        String pass1= Sheet1.getRow(1).getCell(1).getStringCellValue();
	        int pin1 = (int) Sheet1.getRow(1).getCell(2).getNumericCellValue();
	        String pinstring= String.valueOf(pin1);
	        
	        l= new Login_page(driver);
	        l.login(username1, pass1, pinstring);
			//l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
			
			//edit account details
			driver.findElement(By.linkText("Edit your account details")).click();
			a.accDetails(username,fname,lname,company);
			
			//upload profile photo
			a.profile_valid();
			Thread.sleep(2000);
			
			//change password
			a.changepassword("pqrs@1234", "pqrs@1234", "pqrs@1234");
			
			//go to marketplace and search
			driver.findElement(By.linkText("Marketplace")).click();
			Thread.sleep(2000);
			m.searchBy_rating();
			m.searchBy_version();
			m.search();
			Thread.sleep(2000);
			//buy product
			m.buy();
			Thread.sleep(2000);
			driver.navigate().back();
			
			//go to resources and add to cart- book
			Thread.sleep(2000);
			driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("OpenCart Books")).click();
		    Thread.sleep(2000);
		    r.AddToCart();
		    Thread.sleep(2000);
		    
		}
		
		@AfterMethod
		public void quitDriver() {
			//fill your code here
			driver.quit();
		}

}
