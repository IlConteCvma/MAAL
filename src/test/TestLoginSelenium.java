package test;

/*
 * 
 * Alessandro Chillotti
 * Test the login with fields empties
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLoginSelenium {
	@Test
	public void testLoginEmpty() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
	               		
        driver.get("http://localhost:8080/MAAL/");			                    		
     
        //Login with fields empties
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");					
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");			
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
       
        //Check the value of alert
		assertEquals("compile form please", driver.switchTo().alert().getText());
		driver.quit(); 
	}
}
