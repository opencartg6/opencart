package com.pages;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Resources_page {

			WebDriver driver;
			By book = By.xpath("//a[contains(text(),'OPENCART GEBRUIKERSGIDS V1.5+')]");
			By ver = By.id("input-option2");
			By domain = By.id("input-option1");
			By cart = By.id("button-cart");
			
			By newsletter = By.name("newsletter");
			By button1 = By.className("input-group-btn");
			By button2 = By.id("button-newsletter");
			By drpdown = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/select");
			By other_check = By.id("fieldjrydjiy-3");
			By check1 = By.id("fieldjrayky-0");
			
			public Resources_page(WebDriver driver){
				this.driver=driver;
			}

			public void AddToCart() throws InterruptedException{
				String parenthandle=driver.getWindowHandle();
				JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("window.scrollBy(0,1500)");
		        Thread.sleep(5000);
		        
		        driver.findElement(book).click();
		        Thread.sleep(3000);
		        
		        Set<String> handles=driver.getWindowHandles();
		        for(String handle:handles) {
		            System.out.println(handle);
		            if(!handle.equals(parenthandle)) {
		                driver.switchTo().window(handle);
		                JavascriptExecutor s = (JavascriptExecutor)driver;
		                s.executeScript("window.scrollBy(0,500)");
		                Thread.sleep(3000);
		                            
		                driver.findElement(ver).sendKeys("1.5.3");
		                driver.findElement(domain).sendKeys("Domain");
		                Thread.sleep(2000);
		                driver.findElement(cart).click();
		            }
		        }
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
