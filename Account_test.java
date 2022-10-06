package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import com.pages.Account_page;
import com.pages.Login_page;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Account_test {
	
	public static WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Account_page a;
	Login_page l;
	
	@BeforeTest
	public void launchDriver() {
		//fill your code here
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		a = new Account_page(driver);
		l = new Login_page(driver);
	}
	
	@Test(priority=0)
	public void accountDetail() throws Exception {
		//with valid profile pic
		l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
		driver.findElement(By.linkText("Edit your account details")).click();
		a.accDetails("Project_OC_01", "Aish", "khobare", "PSL");
		a.profile_valid();
		a.takeSnapShot(driver, "C:\\Users\\disha_baba\\eclipse-workspace\\OpenCart3\\screenshots\\test_accDetail_valid.png") ;
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void pwchange() throws IOException, InterruptedException {
		
		//l.login("nupurkomari227@gmail.com","pqrs@123","2345");
		a.changepassword("pqrs@1234", "pqrs@1234", "pqrs@1234");
		
	}
	
	@Test(priority=2)
	public void partnerUp() throws IOException, InterruptedException {
		String sdesc="fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbv";
		String ldesc="fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgydriver.findElement(By.id(\\\"\\\")).sendKeys(\\\"fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbv\\\");ujbv";
		
		//xlsx setup
		File src = new File("D:\\opencart.xlsx");            
	    FileInputStream fileinput = new FileInputStream(src);           
	    Workbook wb = new XSSFWorkbook(fileinput);            
	    XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
	    
	    //variables (V=Valid,INV=Invalid)
	    String firstNameV= Sheet1.getRow(2).getCell(2).getStringCellValue();            
	    String lastNameV= Sheet1.getRow(11).getCell(2).getStringCellValue();
	    String companyNameV= Sheet1.getRow(20).getCell(2).getStringCellValue();
	    String websiteNameV= Sheet1.getRow(63).getCell(1).getStringCellValue();	   
	    String emailV= Sheet1.getRow(65).getCell(1).getStringCellValue();
	    int telephoneV = (int) Sheet1.getRow(29).getCell(2).getNumericCellValue();   
	    String telephoneVstring= String.valueOf(telephoneV);	    
	    String address1V= Sheet1.getRow(36).getCell(2).getStringCellValue();
	    String address2V= Sheet1.getRow(45).getCell(2).getStringCellValue();
	    String cityNameV= Sheet1.getRow(67).getCell(1).getStringCellValue();
	    int postcodeV = (int) Sheet1.getRow(56).getCell(2).getNumericCellValue();   
	    String postcodeVstring= String.valueOf(postcodeV);
		
	    //login page functionality	    
	    //l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
	    driver.findElement(By.linkText("Edit Partner Information")).click();
	    a.partnerupClear();
	    
	    //test with valid details
	    a.partnerup(firstNameV,lastNameV,companyNameV,websiteNameV,emailV,telephoneVstring,"D",sdesc,ldesc,address1V,address2V,cityNameV,postcodeVstring);
	    
	}
	
	@Test(priority=3)
	public void partnerUpInvalid() throws Exception {
		String sdesc="fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbv";
		String ldesc="fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgydriver.findElement(By.id(\\\"\\\")).sendKeys(\\\"fdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbvfdghjgfhjfghjgfghjtresdfghjkluytredfghjkliuytrewsdfghjoiuytresdfghjkl,mnbvfgtyukmnbvftyujbgfgtyujbgyujgyujbv\\\");ujbv";
		
		//xlsx setup
		File src = new File("D:\\opencart.xlsx");            
	    FileInputStream fileinput = new FileInputStream(src);           
	    Workbook wb = new XSSFWorkbook(fileinput);            
	    XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
	    String firstNameINV= Sheet1.getRow(3).getCell(2).getStringCellValue();
	    String lastNameINV= Sheet1.getRow(12).getCell(2).getStringCellValue();
	    String companyNameINV= Sheet1.getRow(21).getCell(2).getStringCellValue();
	    String websiteNameINV= Sheet1.getRow(65).getCell(1).getStringCellValue();
	    int telephoneINV = (int) Sheet1.getRow(29).getCell(2).getNumericCellValue();   
	    String telephoneINVstring= String.valueOf(telephoneINV);
	    String address1INV= Sheet1.getRow(39).getCell(2).getStringCellValue();
	    String address2INV= Sheet1.getRow(48).getCell(2).getStringCellValue();
	    String cityNameINV= Sheet1.getRow(68).getCell(1).getStringCellValue();
	    int postcodeINV = (int) Sheet1.getRow(58).getCell(2).getNumericCellValue();   
	    String emailV= Sheet1.getRow(65).getCell(1).getStringCellValue();
	    String postcodeINVstring= String.valueOf(postcodeINV);
	    
	    driver.findElement(By.linkText("Edit Partner Information")).click();
	    a.partnerupClear();
	    
	    //test with invalid details
	    a.partnerup(firstNameINV,lastNameINV,companyNameINV,websiteNameINV,emailV,telephoneINVstring,"D",sdesc,ldesc,address1INV,address2INV,cityNameINV,postcodeINVstring);
		a.takeSnapShot(driver, "C:\\Users\\disha_baba\\eclipse-workspace\\OpenCart3\\screenshots\\test_partnerUp_invalid.png") ;
		
	    
	}
	
	@Test(priority=4)
	public void accDetailInvalid() throws Exception {
		//with invalid profile pic
		//driver.findElement(accDetail).click();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);
		//l.login("nupurkomari227@gmail.com", "pqrs@1234","2345");
		driver.findElement(By.linkText("Edit your account details")).click();
		a.accDetails("Project_OC_02", "Aish", "khobare", "PSL");
		a.profile_invalid();
		a.takeSnapShot(driver, "C:\\Users\\disha_baba\\eclipse-workspace\\OpenCart3\\screenshots\\test_accDetail_invalid.png") ;
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		    
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
