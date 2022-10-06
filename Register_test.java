package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Login_page;
import com.pages.Register_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_test {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Register_page r;
	Login_page l;
		
		@BeforeMethod
		public void launchDriver() {
			//fill your code here
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			r = new Register_page(driver);

		}
		
		@Test(priority=1)
		public void RegisterValid() throws InterruptedException, IOException {
			
			//fill your code here
		
		File src = new File("D:\\Register.xlsx");            
		FileInputStream fileinput = new FileInputStream(src);           
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
		
		//variables (V=Valid,INV=Invalid)
		String usernameV= Sheet1.getRow(3).getCell(3).getStringCellValue();            
		String lastNameV= Sheet1.getRow(36).getCell(2).getStringCellValue();
		String firstNameV= Sheet1.getRow(22).getCell(3).getStringCellValue();
		String emailV= Sheet1.getRow(31).getCell(2).getStringCellValue();
		String passwordV= Sheet1.getRow(12).getCell(3).getStringCellValue();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		r.register(usernameV,firstNameV,lastNameV,emailV,passwordV);
		
		
		}
		
		@Test(priority=2)
		public void RegisterInValid() throws InterruptedException, IOException {
			
			//fill your code here
		File src = new File("D:\\Register.xlsx");            
		FileInputStream fileinput = new FileInputStream(src);           
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
//		 r= new Register_page(driver);
		//variables (V=Valid,INV=Invalid)
		String usernameInV= Sheet1.getRow(5).getCell(3).getStringCellValue();            
		String lastNameInV= Sheet1.getRow(37).getCell(2).getStringCellValue();
		String firstNameInV= Sheet1.getRow(23).getCell(3).getStringCellValue();
		String emailInV= Sheet1.getRow(43).getCell(2).getStringCellValue();
		String passwordInV= Sheet1.getRow(15).getCell(3).getStringCellValue();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		r.register(usernameInV,firstNameInV,lastNameInV,emailInV,passwordInV);
			
		}
		@Test(priority=3)
		public void RegisterEmptyField() throws InterruptedException, IOException {
			
			//fill your code here
		File src = new File("D:\\Register.xlsx");            
		FileInputStream fileinput = new FileInputStream(src);           
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheetAt(0);
//		 r= new Register_page(driver);
		//variables (V=Valid,INV=Invalid)
		String usernameInV= Sheet1.getRow(2).getCell(3).getStringCellValue();            
		String lastNameInV= Sheet1.getRow(37).getCell(2).getStringCellValue();
		String firstNameInV= Sheet1.getRow(20).getCell(3).getStringCellValue();
		String emailInV= Sheet1.getRow(32).getCell(2).getStringCellValue();
		String passwordInV= Sheet1.getRow(14).getCell(3).getStringCellValue();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		r.register(usernameInV,firstNameInV,lastNameInV,emailInV,passwordInV);
			
		}
	
		@AfterMethod
		public void quitDriver() {
			driver.quit();
		}

}