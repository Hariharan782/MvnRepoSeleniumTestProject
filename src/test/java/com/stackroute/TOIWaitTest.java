package com.stackroute;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TOIWaitTest {
	private static WebDriver driver = null;

//	@BeforeClass
//	public static void setup() {
//		String chromePath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", chromePath);
//
//		driver = new ChromeDriver();
//	}
	
//	@BeforeClass
//	public static void setup() {
//		String chromePath = System.getProperty("user.dir") + "/lib/geckodriver.exe";
//		System.setProperty("webdriver.gecko.driver", chromePath);
//
//		driver = new FirefoxDriver();
//	}

	@BeforeClass
	public static void setup() {
		String chromePath = System.getProperty("user.dir") + "/lib/edgedriver.exe";
		System.setProperty("webdriver.edge.driver", chromePath);

		driver = new EdgeDriver();
	}

	@AfterClass
	public static void windUp() {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://timesofindia.indiatimes.com/");
		Thread.sleep(8000);
		String exptectedTitle = "News - Latest News, Breaking News, Bollywood, Sports, Business and Political News | Times of India";
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Not actual TOI page", exptectedTitle, actualTitle);
	}
}
