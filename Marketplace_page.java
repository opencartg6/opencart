package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Marketplace_page {

		WebDriver driver;
		By searchbar = By.className("form-control");
		By sortby = By.id("input-sort");
		By ele = By.className("extension-description");
		By buy_button = By.id("button-purchase");
		By modal_body = By.className("modal-body");
		By cont = By.xpath("//button[@id='button-continue']");
		By credit_no = By.id("credit-card-number");
		By exp_year = By.id("expiration-year");
		By month = By.id("expiration-month");
		By cvv = By.id("cvv");
		By version = By.xpath("//body/div[@id='marketplace-extension']/div[2]/div[1]/div[1]/div[2]/section[2]/div[1]/div[1]/select[1]");
		By check1 = By.id("input-vault");
		By check2 = By.id("agree");
		
		public Marketplace_page(WebDriver driver){
			this.driver=driver;
		//	PageFactory.initElements(driver, this);
		}
		public void search() {
			//driver.findElement(By.linkText("Marketplace")).click();
			driver.findElement(searchbar).sendKeys("watch");
			driver.findElement(searchbar).sendKeys(Keys.ENTER);
		}
		public void searchBy_version() {
			Select drpCountry = new Select(driver.findElement(sortby));
	        drpCountry.selectByVisibleText("Rating");
	         
		}
		public void searchBy_rating() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,750)", "");
		        Select drpCountry1 = new Select(driver.findElement(version));
		        drpCountry1.selectByVisibleText("2.0.2.0");
		}
		public void buy() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			driver.findElement(ele).click();	
			driver.findElement(buy_button).click();
			Thread.sleep(2000);
			WebElement modalContainer = driver.findElement(modal_body);
			WebElement modalAcceptButton = modalContainer.findElement(cont);
			modalAcceptButton.click();
			Thread.sleep(8000);

			//enter the payment details
			driver.switchTo().frame("braintree-hosted-field-number");
			driver.findElement(credit_no).sendKeys("1111111111111111");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			driver.switchTo().frame("braintree-hosted-field-expirationYear");
			Select drpCountry = new Select(driver.findElement(exp_year));
			drpCountry.selectByVisibleText("2024");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			driver.switchTo().frame("braintree-hosted-field-expirationMonth");
			Select drpCountry1 = new Select(driver.findElement(month));
			drpCountry1.selectByVisibleText("8");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			driver.switchTo().frame("braintree-hosted-field-cvv");
			driver.findElement(cvv).sendKeys("909");
			driver.switchTo().defaultContent();
			
			modalContainer.findElement(check1).click();
			modalContainer.findElement(check2).click();
			modalContainer.findElement(cont).click();
		}
		

}
