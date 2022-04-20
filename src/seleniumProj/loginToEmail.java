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

public class loginToEmail {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String browserPath = "C:/eclipse/dependencies/";
		
		System.setProperty("webdriver.chrome.driver", browserPath+"chromedriver.exe");
		
	 driver = new ChromeDriver();
	driver.manage().window().maximize(); 
	Thread.sleep(1000);
		driver.get("https://gmail.com/");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("Automationsampletest@gmail.com");
	    driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SampleTest2022..");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")).click();
	    Thread.sleep(8000);
	    String gMail = driver.findElement(By.xpath("//span[contains(text(),'New Message')]")).getText();
	    sendtext("//textarea[@name='to']","automationsampletest@gmail.com");
	    /*
	    Assert.assertTrue(gMail.contains("New Message"));
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//textarea[@id=':9d']")).sendKeys("automationsampletest@gmail.com");
	     */
	    
	    //int check = driver.findElements(By.xpath("")).size();
	    //if (check>)
	    driver.findElement(By.xpath("//*[@aria-label='More send options']")).click();
	    //driver.findElement(By.xpath("//*[@aria-label='More send options']")).click();
	    driver.findElement(By.xpath("//*[@name='subjectbox']")).sendKeys("Hi");
	    driver.findElement(By.xpath("//*[@aria-label='Message Body'][@class='Am Al editable LW-avf tS-tW']")).sendKeys("Automation test");
	    driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[9]/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div[2]/span/span")).click();
	    String receivedmail = driver.findElement(By.xpath("//div[contains(text(),'Automation test')]")).getText();
	    Assert.assertTrue(receivedmail.contains("Automation"));
	    
	  
	    
	    
	}
	
public static void sendtext(String xpathtolookup, String textvalue) throws InterruptedException {
	
	WebElement xpathWebelement = waitForMyElementXpath(xpathtolookup);
	 
	xpathWebelement.sendKeys(textvalue);


}

public static WebElement waitForMyElementXpath(String elementToFind) throws InterruptedException {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(100))
		       .pollingEvery(Duration.ofSeconds(5))
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