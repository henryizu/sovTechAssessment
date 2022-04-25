package seleniumProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import graphql.Assert;

public class logInWithValidCredentials {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String browserPath = "C:/eclipse/dependencies/";
		
		System.setProperty("webdriver.chrome.driver", browserPath+"chromedriver.exe");
		
	WebDriver driver = new ChromeDriver(); //- launch google chrome
	driver.manage().window().maximize(); // - maximise google chrome
	Thread.sleep(10000);  //wait for 5 secs
		driver.get("https://igrcs-qa-studio.pwcng-rpa.com/");
		//ghnjkml,yujmk,l

		Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@id='LoginInput_Password']")).sendKeys("1q2w3E*");
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
	    Thread.sleep(19000);
	    String validCredTitle = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div[2]/app-home/div[2]/div/div/div/span[1]")).getText();
	    Assert.assertTrue(validCredTitle.contains("EBMON"));
	    driver.findElement(By.xpath("//*[@id=\"kt_header_menu\"]/ul/li[3]/a/span[2]")).click();
	   
	}

}