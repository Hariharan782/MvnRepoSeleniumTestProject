package com.stackroute;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleTest {
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
	
//	@Test
//	public void test01() {
//		driver.navigate().to("https://www.google.com");
//		Set<Cookie> allCookies = driver.manage().getCookies();
//		
//		for(Cookie cookie : allCookies) {
//			System.out.println("Cookie " + cookie);
//		}
//	}
//	
//	@Test
//	public void test02() throws InterruptedException {
//		Point winPosition = new Point(100, 100);
//		
//		driver.navigate().to("https://www.google.com");
//		driver.manage().window().setPosition(winPosition);
//		driver.findElement(By.name("q")).sendKeys("Rajesh");;
//
////		Thread.sleep(10000);
//	}
//	
//	@Test
//	public void test03() throws InterruptedException {
//		Point winPosition = new Point(100, 100);
//		
//		driver.navigate().to("https://www.google.com");
//		driver.manage().window().setPosition(winPosition);
//		driver.findElement(By.linkText("Images")).click();
//
////		Thread.sleep(10000);
//	}
//	
//	@Test
//	public void test04() throws InterruptedException {
//		
//		driver.navigate().to("https://www.google.com");
////		Thread.sleep(5000);
//		
//		driver.findElement(By.className("gLFyf")).sendKeys("Selenium documentation");
////		Thread.sleep(10000);
//	}
//	
	@Test
	public void test05() throws InterruptedException {
		
		driver.navigate().to("https://www.google.com");
		Thread.sleep(5000);
		
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys("Java 8 tutorial");
		Thread.sleep(5000);
		
		searchField.clear();
		Thread.sleep(5000);
		
//		Select list = new Select(driver.findElement(By.id("list")));
//		list.selectByVisibleText(text);
		
		
		
		
	}
}
