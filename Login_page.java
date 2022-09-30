package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Login_page {
	WebDriver driver ;
	By email= By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]");
	By pin = By.id("input-pin");
	
	public Login_page(WebDriver driver) {
			 this.driver = driver;
		 }
	public void login(String email_id, String pass, String pin_no ) throws InterruptedException {
		
		//js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(email).sendKeys(email_id);
		driver.findElement(password).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(loginButton).click();
		//js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(pin).sendKeys(pin_no);
		driver.findElement(pin).sendKeys(Keys.ENTER);
	}
	
	
		public void getEmail(String textEmail) {
			 
			  driver.findElement(email).sendKeys(textEmail);
		 }
		public void getPassword(String textPassword) {
			driver.findElement(password).sendKeys(textPassword);
		}
		public void clickLoginButton() {
			driver.findElement(loginButton).click();
		}
		

}
