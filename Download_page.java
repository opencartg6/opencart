package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Download_page {
	WebDriver driver;
	By dwn2 = By.xpath("//tbody/tr[1]/td[4]/a[1]");
	By dwn1 = By.xpath("//body/div[@id='marketplace-extension-info']/div[2]/div[1]/div[2]/div[1]/a[1]");
	By dwn = By.xpath("//body/div[@id='cms-download']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]");
	By extension = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/a[1]/div[1]");
	
	public Download_page(WebDriver driver){
		this.driver=driver;
	}
	
	public void dwn_localhost() throws InterruptedException {
		driver.findElement(dwn).click();
        Thread.sleep(5000);
	}
	
	public void dwn_extension() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,400)", "");
	        Thread.sleep(1000);
	        js.executeScript("window.scrollBy(0,400)", "");
	        Thread.sleep(1000);
	        driver.findElement(extension).click();
	        driver.findElement(dwn1).sendKeys(Keys.ENTER);
	        js.executeScript("window.scrollBy(0,250)", "");
	        Thread.sleep(1000);
	        driver.findElement(dwn2).click();
	}

}
