package seleniumProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import graphql.Assert;

public class loginToEmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String browserPath = "C:/eclipse/dependencies/";
		
		System.setProperty("webdriver.chrome.driver", browserPath+"chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();
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
	    Thread.sleep(7000);
	    String gMail = driver.findElement(By.xpath("//span[contains(text(),'New Message')]")).getText();
	    Assert.assertTrue(gMail.contains("New Message"));
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//textarea[@id=':9d']")).sendKeys("automationsampletest@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\":8v\"]")).sendKeys("Hi");
	    driver.findElement(By.xpath("//div[@id=':a1']")).sendKeys("Automation test");
	    driver.findElement(By.xpath("//*[@id=\":8l\"]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[9]/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div[2]/span/span")).click();
	    String receivedmail = driver.findElement(By.xpath("//div[contains(text(),'Automation test')]")).getText();
	    Assert.assertTrue(receivedmail.contains("Automation"));
	    
	   
	}

}