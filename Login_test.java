package com.test;

import com.pages.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.commons.io.IOUtils;
//import org.apache.commons.io.IOUtils.read;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

public class Login_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com/index.php?route=account/login";
    Login_page y;
 
	    	@BeforeMethod
	    	public void launchDriver() throws IOException {
	    	WebDriverManager.chromedriver().setup();
	    	//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			//driver.manage().window().maximize();
			
	    	}

	        @Test(priority=0)
	        public void TestCase1() throws InterruptedException, IOException {
	        	File src = new File("D:\\CredentialForLoginPage.xlsx");	        
	    		FileInputStream fileinput = new FileInputStream(src);	       
	    		Workbook wb = new XSSFWorkbook(fileinput);	        
	    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
		        String username1= Sheet1.getRow(1).getCell(0).getStringCellValue();	        
		        String pass1= Sheet1.getRow(1).getCell(1).getStringCellValue();
		        int pin1 = (int) Sheet1.getRow(1).getCell(2).getNumericCellValue();
		        String pinstring= String.valueOf(pin1);
		        System.out.println(pinstring);
		        y= new Login_page(driver);
		        y.login(username1, pass1, pinstring);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[1]")).click();
	        }
	
	        @Test(priority=1)
	        public void TestCase2() throws InterruptedException, IOException {
	        	File src = new File("D:\\CredentialForLoginPage.xlsx");	        
	    		FileInputStream fileinput = new FileInputStream(src);	       
	    		Workbook wb = new XSSFWorkbook(fileinput);	        
	    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
	        	String username2= Sheet1.getRow(2).getCell(0).getStringCellValue();	        
	        	String pass2= Sheet1.getRow(2).getCell(1).getStringCellValue();   
	        	y= new Login_page(driver);
	        	y.getEmail(username2);
		        y.getPassword(pass2);
				y.clickLoginButton();	        	
	        	Thread.sleep(1000);
	        	}
	       
	        
	        @Test(priority=2)
	        public void TestCase3() throws InterruptedException, IOException {
	        	File src = new File("D:\\CredentialForLoginPage.xlsx");	        
	    		FileInputStream fileinput = new FileInputStream(src);	       
	    		Workbook wb = new XSSFWorkbook(fileinput);	        
	    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
	        	String username3= Sheet1.getRow(3).getCell(0).getStringCellValue();	  		        	
				y= new Login_page(driver);
				y.getEmail(username3);
				
				//driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
				//driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[2]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
				y.clickLoginButton();
				Thread.sleep(4000);
	        }
	
	
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}
}



