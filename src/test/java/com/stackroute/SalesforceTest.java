package com.stackroute;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceTest {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		String chromePath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);

		driver = new ChromeDriver();
	}

	@AfterClass
	public static void windUp() {
		driver.close();
	}

	@Test
	public void test01() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.salesforce.com/in/form/signup/freetrial-sales/");

//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Thread.sleep(1000);
		WebDriverWait wdWait = new WebDriverWait(driver, 60*2);

		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		
		WebElement firstname = driver.findElement(By.name("UserFirstName"));
		firstname.sendKeys("shruthi");
		Thread.sleep(5000);
	}
}