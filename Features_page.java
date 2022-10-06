package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Features_page {
	
	WebDriver driver ;
	By search_bar = By.name("filter_search");
	By trending = By.linkText("OpenCart Version 3.0.0.0 Available to Download Now");
	By cont_button = By.xpath("//body/div[@id='cms-blog']/div[3]/div[1]/div[1]/div[1]/a[2]");
	By feature = By.linkText("Features");
	By unlimited_tab = By.linkText("Unlimited everything");
	By customer_tab = By.linkText("Customer");
	By shipping_tab = By.linkText("Shipping, Payments and Reports");
	By extension_tab = By.linkText("Extensions");
	By mobile_tab = By.linkText("Mobile & SEO");
	By dev_tab = By.linkText("Developer");
	
	By newsletter = By.name("newsletter");
	By button1 = By.className("input-group-btn");
	By button2 = By.id("button-newsletter");
	By drpdown = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/select");
	By other_check = By.id("fieldjrydjiy-3");
	By check1 = By.id("fieldjrayky-0");
	
	public Features_page(WebDriver driver) {
			 this.driver = driver;
	}
	
	public void explore() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(feature).click();
        Thread.sleep(1000);
        
        for(int i=0;i<7;i++) {
        	 js.executeScript("window.scrollBy(0,400)", "");
             Thread.sleep(1000);
        }
        /*
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
        */
        js.executeScript("window.scrollBy(0,-2800)", "");
        Thread.sleep(1000);
        driver.findElement(unlimited_tab).click();
        Thread.sleep(1000);
        for(int i=0;i<7;i++) {
       	 js.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(1000);
       }
        js.executeScript("window.scrollBy(0,-2800)", "");
        Thread.sleep(1000);
        
        driver.findElement(customer_tab).click();
        Thread.sleep(1000);
        for(int i=0;i<6;i++) {
          	 js.executeScript("window.scrollBy(0,400)", "");
               Thread.sleep(1000);
          }
        js.executeScript("window.scrollBy(0,-2400)", "");
        Thread.sleep(1000);
        
        
        driver.findElement(shipping_tab).click();
        Thread.sleep(2000);
        for(int i=0;i<6;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
              Thread.sleep(1000);
         }
        js.executeScript("window.scrollBy(0,-2400)", "");
        Thread.sleep(1000);
        
        driver.findElement(extension_tab).click();
        Thread.sleep(2000);
        for(int i=0;i<7;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
              Thread.sleep(1000);
         }
        js.executeScript("window.scrollBy(0,-2800)", "");
        Thread.sleep(1000);
        
        driver.findElement(mobile_tab).click();
        Thread.sleep(2000);
        for(int i=0;i<7;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
              Thread.sleep(1000);
         }
        js.executeScript("window.scrollBy(0,-2800)", "");
        Thread.sleep(1000);
        
        driver.findElement(dev_tab).click();
        Thread.sleep(2000);
        for(int i=0;i<6;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
              Thread.sleep(1000);
         }
        js.executeScript("window.scrollBy(0,-2400)", "");
        Thread.sleep(1000);
	}
	
	public void Newsletter(String email_id) throws InterruptedException {
		WebElement email = driver.findElement(newsletter);
        email.sendKeys(email_id);
        Thread.sleep(3000);
        WebElement buttn = driver.findElement(button1);
        buttn.click();
        Thread.sleep(2000);
        
        Select country = new Select(driver.findElement(drpdown));
        country.selectByVisibleText("India");
        Thread.sleep(2000);
        
        driver.findElement(other_check).click();
        Thread.sleep(2000);
       
        driver.findElement(check1).click();;
        Thread.sleep(2000);
        
        driver.findElement(button2).click();
        Thread.sleep(2000);
	}
	

	
}
