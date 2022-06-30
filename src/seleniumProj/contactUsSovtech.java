package seleniumProj;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import graphql.Assert;

public class contactUsSovtech {
static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String browserPath = "C:/eclipse/dependencies/";
		
		System.setProperty("webdriver.chrome.driver", browserPath+"chromedriver.exe");
		
	WebDriver driver = new ChromeDriver(); //- launch google chrome
	driver.manage().window().maximize(); // - maximise google chrome
	Thread.sleep(2000);  //wait for 5 secs
		driver.get("https://www.sovtech.co.za/contact-us/");
		

		Thread.sleep(5000);
	  
	  
	  WebElement hframe = driver.findElement(By.xpath("//*[@class='hs-form-iframe']"));
	  driver.switchTo().frame(hframe);
	
	

	  driver.findElement(By.xpath("//*[@id='your_name-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).sendKeys("Henry Izumunna");
		driver.findElement(By.xpath("//input[@id='email-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).sendKeys("Automationsampletest");
		  driver.findElement(By.xpath("//input[@id='mobilephone-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).sendKeys("2347036494598");
	    driver.findElement(By.xpath("//select[@id='numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).click();
	    driver.findElement(By.xpath("//*[@id=\"numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a\"]/option[5]")).click();
	    driver.findElement(By.xpath("//select[@id='what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).click();
	    driver.findElement(By.xpath("//option[contains(text(),'Augment current engineering staff')]")).click();
	    driver.findElement(By.xpath("//textarea[@id='message-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).sendKeys("Request for more information about the product");
	    driver.findElement(By.xpath("//input[@id='LEGAL_CONSENT.subscription_type_10841063-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")).click();
	    driver.findElement(By.xpath("//*[@id=\"hsForm_c2e387f9-4bd8-496f-ab2a-81fbbc31712a\"]/div/div[2]/input")).click();
	    Thread.sleep(5000);
	    
	    
	}
	
	public static WebElement waitForMyElementXpath(String elementToFind) throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(1))
			       .ignoring(NoSuchElementException.class)
			       .withMessage("Element Not Found after several trial");
		
		 WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if (driver.findElement(By.xpath(elementToFind)).isDisplayed()){
		    		 return driver.findElement(By.xpath(elementToFind));
		    	 }else{
		    		 return null;
		    	 }
		    	 
		      
		     }
		   });
		 
		return foundElement;
		
	}

}