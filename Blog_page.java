package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Blog_page {
	WebDriver driver ;
	By search_bar = By.name("filter_search");
	By cont_button = By.xpath("//body/div[@id='cms-blog']/div[3]/div[1]/div[1]/div[1]/a[2]");
	
	By trending = By.linkText("OpenCart Version 3.0.0.0 Available to Download Now");
	

	public Blog_page(WebDriver driver) {
			 this.driver = driver;
	}
	
	public void SearchBox(String search_word) throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(search_bar).sendKeys(search_word);
		driver.findElement(search_bar).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(4000);
		driver.findElement(cont_button).click();
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(4000);
	}
	public void TrendingBlog() throws InterruptedException {
		driver.findElement(trending).click();
		Thread.sleep(2000);
	}
	
}
