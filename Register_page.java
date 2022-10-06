package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_page {
	WebDriver driver;
	By username = By.id("input-username");
	By firstname = By.id("input-firstname");
	By lastname = By.id("input-lastname");
	By email_id = By.id("input-email");
	By country = By.id("input-country");
	By password = By.id("input-password");
	//By button = By.xpath("//body/div[@id='account-register']/div[@id='register']/div[1]/div[1]/form[1]/div[7]/button[2]");
	//By button = By.cssSelector("button.btn.btn-primary.btn-lg.btn-block.visible-xs-block");
			//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/button[2]
	By button = By.cssSelector("button[type='submit']");
	public Register_page(WebDriver driver){
		this.driver=driver;
	}

	public void register(String usernameV, String firstNameV, String lastNameV, String emailV, String passwordV) throws InterruptedException{
		driver.findElement(username).sendKeys(usernameV);
		Thread.sleep(1000);
		driver.findElement(firstname).sendKeys(firstNameV);
		Thread.sleep(1000);
		driver.findElement(lastname).sendKeys(lastNameV);
		Thread.sleep(1000);
		driver.findElement(email_id).sendKeys(emailV);
		Thread.sleep(2000);
		Select country1 = new Select(driver.findElement(country));
        country1.selectByVisibleText("India");
        Thread.sleep(2000);
		driver.findElement(password).sendKeys(passwordV);
		Thread.sleep(10000);
		driver.findElement(button).click();
		Thread.sleep(10000);
	}
}
