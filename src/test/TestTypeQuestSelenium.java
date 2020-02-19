package test;

import static org.junit.Assert.*;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class TestTypeQuestSelenium {

	@Test
	public void testPrintSubject() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://localhost:8080/MAAL/");
		
		//login
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("conte");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("cvma");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		//
		WebElement TxtBoxContent = driver.findElement(By.xpath("//h2"));
		//test
		System.out.println(TxtBoxContent.getText());
		
		assertEquals("Marco Calavaro",TxtBoxContent.getText());
		driver.quit();
		
		
	}

}
