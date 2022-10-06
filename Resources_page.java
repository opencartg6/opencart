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
			
			By resource = By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]");
			By showcase = By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/ul[1]/li[1]/a[1]");

			By viewWebsite = By.xpath("//body/div[@id='cms-showcase']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/a[1]");
			By allStores = By.xpath("//a[contains(text(),'All Stores')]");
			By clothesAppeal = By.linkText("Clothes & Apparel");
			By techGadgets = By.xpath("//a[contains(text(),'Tech & Gadgets')]");

			By contactUs = By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/ul[1]/li[2]/a[1]");
			By contacUsinput1 = By.xpath("//select[@id='input-reason']");
			By contactUsinput2 = By.xpath("//input[@id='input-name']");
			By contactUsinput3 = By.xpath("//input[@id='input-email']");
			By contactUsinput4 = By.xpath("//textarea[@id='input-enquiry']");


			By communityForums = By.xpath("//a[contains(text(),'Community Forums')]");


			By opencartPartner = By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/ul[1]/li[3]/a[1]");
			By ocPartner_country = By.cssSelector("div.container div.row div.col-sm-4.col-md-3 section:nth-child(1) div.form-group:nth-child(2) > select.form-control");
			By ocPartner_view = By.xpath("//body/div[@id='support-partner']/div[2]/div[1]/div[2]/section[1]/div[2]/div[1]/p[2]/a[1]");
			By resources = By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]");
			By community = By.xpath("//a[contains(text(),'Community Forums')]");
			By news = By.linkText("News & Announcements");
			By article1 = By.linkText("[LEGAL] EC Court Decision about \"Buy Button\" (and how to name it)");
			By forum_log = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]/span[1]");
			By username = By.id("username");
			By password = By.id("password");
			By login_button = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/form[1]/fieldset[1]/input[1]");
			By project_oc = By.xpath("//body/div[@id='forum']/div[@id='top-breadcrumb']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]/span[1]");
			By post = By.linkText("Your posts");
			By logout = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[6]/a[1]/button[1]");          
			By git_tracker = By.linkText("Github Bug Tracker");
			By article2 = By.linkText("Upgrading a 3.x shop to 4.x dosnt respect an already out-of-root storage dir");
		
			
		
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
		        Thread.sleep(2000);
		        driver.switchTo().window(parenthandle);
			}
			
			public void resources() {
				driver.findElement(resource).click();
			}
			public void showcase() {
				driver.findElement(showcase).click();
				
			}
			public void showcase_viewWEbsite() {
				driver.findElement(viewWebsite).click();
				
			}
			public void showcase_allStores() {
				driver.findElement(allStores).click();
				
			}
			public void showcase_closthesAppeal() {
				driver.findElement(clothesAppeal).click();
				
			}
			public void showcase_techGadgets() {
				driver.findElement(techGadgets).click();
				
			}
			public void contactUs() {
				driver.findElement(contactUs).click();
				
			}
			public void communityForums() {
				driver.findElement(communityForums);
			}

			public void contactUs_input1() {
				Select input1 = new Select(driver.findElement(contacUsinput1));
			    input1.selectByVisibleText("I would like to report an account issue");
			}
			public void contactUs_input2() {
				driver.findElement(contactUsinput2).sendKeys("The ShubhAM SHAH");
				
			}
			public void contactUs_input3() {
				driver.findElement(contactUsinput3).sendKeys("abctp@gmail.com");
			}
			public void contactUs_input4() {
				driver.findElement(contactUsinput4).sendKeys("I really like to interact with you  I like your idea it is great thankyou plz contact as soon as possible ");
			}
			public void opencartPartner() {
				driver.findElement(opencartPartner).click();
			}
			public void openCartPrtnerCountry() {
				Select country1 = new Select(driver.findElement(ocPartner_country));
			    country1.selectByValue("https://www.opencart.com/index.php?route=support/partner&filter_country_id=99");
				
			}
			public void oc_partner_view() {
				driver.findElement(ocPartner_view).click();
			}
			
			public void comn_forum(String u_name, String pass) throws InterruptedException{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				driver.findElement(resources).click();
				Thread.sleep(4000);
				driver.findElement(community).click();
				js.executeScript("window.scrollBy(0,500)", "");
				driver.findElement(news).click();
				js.executeScript("window.scrollBy(0,350)", "");
				driver.findElement(article1).click();
				js.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(5000);
				driver.findElement(forum_log).click();
				driver.findElement(username).sendKeys(u_name);
				driver.findElement(password).sendKeys(pass);
				Thread.sleep(5000);
				driver.findElement(login_button).click();
				Thread.sleep(5000);
				driver.findElement(project_oc).click();
				Thread.sleep(5000);
				driver.findElement(post).click();
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,-500)", "");
				driver.findElement(project_oc).click();
				Thread.sleep(5000);
				driver.findElement(logout).click();
			}
			
			public void gitTrack() throws InterruptedException{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				driver.findElement(resources).click();
				Thread.sleep(4000);
				driver.findElement(git_tracker).click();
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,400)", "");
				Thread.sleep(5000);
				driver.findElement(article2).click();
				Thread.sleep(5000);
		        js.executeScript("window.scrollBy(0,400)", "");
		        Thread.sleep(5000);
		        js.executeScript("window.scrollBy(0,400)", "");
		        Thread.sleep(5000);
		        js.executeScript("window.scrollBy(0,400)", "");
		        Thread.sleep(5000);
		        js.executeScript("window.scrollBy(0,400)", "");
		        Thread.sleep(5000);
		        driver.navigate().back();
		        Thread.sleep(5000);
		        driver.navigate().back();
			}

}
