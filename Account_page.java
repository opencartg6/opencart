package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Account_page {
		public WebDriver driver ;
		By accDetail= By.linkText("Edit your account details");
		By clear = By.xpath("//button[contains(text(),'Clear')]");
		By name = By.id("input-username");
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By company = By.id("input-company");
		By country = By.id("input-country");
		By browse = By.xpath("//button[contains(text(),'Browse')]");
		By submit = By.xpath("//button[contains(text(),'Submit')]");
		By login_email= By.id("input-email");
		By login_password= By.id("input-password");
		By login_submit= By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]");
		By login_pin= By.id("input-pin");
		By first_name= By.xpath("//input[@id='input-firstname']");
		By last_name= By.id("input-lastname");
		By comp_name= By.id("input-company");
		By website= By.id("input-website");
		By email= By.id("input-email");
		By telephone= By.id("input-telephone");
		By part_type= By.id("input-partner-type");
		By short_desc= By.xpath("//textarea[@id='input-description-short']");
		By long_desc= By.xpath("//textarea[@id='input-description-long']");
		By address1= By.id("input-address-1");
		By address2= By.id("input-address-2");
		By city= By.id("input-city");
		By postcode= By.id("input-postcode");
		By zone= By.id("input-zone");
		By terms= By.xpath("//body/div[@id='account-partner']/div[1]/div[1]/div[1]/form[1]/fieldset[7]/div[1]/label[1]/input[1]");
		By terms1= By.xpath("//input[@name='agree']");
		By image = By.xpath("//button[contains(text(),'Clear')]");
		By partner_up = By.xpath("//body/div[@id='account-account']/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/h4[1]/a[1]");
		
		By cp = By.linkText("Change Password");
		By op = By.id("input-current");
		By np = By.id("input-password");
		By npc = By.id("input-confirm");
		By cont = By.xpath("//button[contains(text(),'Continue')]");
		
		public Account_page(WebDriver driver) {
				 this.driver = driver;
		}
		public void changepassword (String op1, String np1, String npc1) throws InterruptedException {
			Thread.sleep(5000);
			//driver.findElement(account).click();
			driver.findElement(cp).click();
			Thread.sleep(2000);
			driver.findElement(op).sendKeys(op1);
			Thread.sleep(1000);
			driver.findElement(np).sendKeys(np1);
			Thread.sleep(1000);
			driver.findElement(npc).sendKeys(npc1);
			Thread.sleep(1000);
			driver.findElement(cont).click();
			Thread.sleep(2000);
		}
		public void accDetails(String username,String f_name,String l_name,String comp) throws InterruptedException, IOException {
			
			//driver.findElement(accDetail).click();
			driver.findElement(name).clear();
			driver.findElement(name).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(fname).clear();
			driver.findElement(fname).sendKeys(f_name);
			Thread.sleep(1000);
			driver.findElement(lname).clear();
			driver.findElement(lname).sendKeys(l_name);
			Thread.sleep(1000);
			driver.findElement(company).clear();
			driver.findElement(company).sendKeys(comp);
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(1000);
			Select drpCountry = new Select(driver.findElement(country));
			drpCountry.selectByVisibleText("France");
			Thread.sleep(1000);
			
		}
		public void profile_valid() throws InterruptedException, IOException {
			driver.findElement(clear).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement chooseFile = driver.findElement(browse);
			chooseFile.click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\Users\\disha_baba\\Documents\\FileUpload.exe");
			Thread.sleep(20000);
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(submit).click();
		}
		
		public void profile_invalid() throws InterruptedException, IOException {	
			driver.findElement(clear).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement chooseFile = driver.findElement(browse);
			chooseFile.click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\Users\\disha_baba\\Documents\\FileUpload_invalid.exe");
			Thread.sleep(20000);
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(submit).click();
			Thread.sleep(2000);
		}
		
		/*public void profile_clear() throws InterruptedException {
			driver.findElement(By.linkText("Edit your account details")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		}
		*/
		public void partnerupClear() throws IOException, InterruptedException {
			
			driver.findElement(first_name).clear();
			driver.findElement(last_name).clear();
			driver.findElement(comp_name).clear();
			driver.findElement(website).clear();
			driver.findElement(email).clear();
			driver.findElement(telephone).clear();
			driver.findElement(short_desc).clear();
			driver.findElement(long_desc).clear();
			driver.findElement(address1).clear();
			driver.findElement(address2).clear();
			driver.findElement(city).clear();
			driver.findElement(postcode).clear();
			driver.findElement(image).click();
		}
		
		public void partnerup(String fname, String lname, String cname, String webname, String mail, String tele, String ptype, String sdesc, String ldesc,
				String ad1, String ad2, String city1, String post) throws IOException, InterruptedException {
			driver.findElement(first_name).sendKeys(fname);
			driver.findElement(last_name).sendKeys(lname);
			driver.findElement(comp_name).sendKeys(cname);
			driver.findElement(website).sendKeys(webname);
			driver.findElement(email).sendKeys(mail);
			driver.findElement(telephone).sendKeys(tele);
			driver.findElement(part_type).sendKeys(ptype);
			driver.findElement(part_type).sendKeys(Keys.ENTER);
			driver.findElement(short_desc).sendKeys(sdesc);
			driver.findElement(long_desc).sendKeys(ldesc);
			driver.findElement(address1).sendKeys(ad1);
			driver.findElement(address2).sendKeys(ad2);
			driver.findElement(city).sendKeys(city1);
			driver.findElement(postcode).sendKeys(post);
			Select country1 = new Select(driver.findElement(country));
			country1.selectByVisibleText("India");
			driver.findElement(zone).click();
			Thread.sleep(2000);
			Select state = new Select(driver.findElement(zone));
			state.selectByVisibleText("Maharashtra");
			driver.findElement(browse).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\disha_baba\\Documents\\FileUpload.exe");
			Thread.sleep(20000);
			driver.findElement(submit).click();
			Thread.sleep(20000);
		}
		public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    		//Convert web driver object to TakeScreenshot
    		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    		//Call getScreenshotAs method to create image file
    		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    		//Move image file to new destination
    		File DestFile=new File(fileWithPath);
    		//Copy file at destination
    		FileUtils.copyFile(SrcFile, DestFile);
    		}
		
}
