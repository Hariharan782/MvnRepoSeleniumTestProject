package com.stackroute;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class MvnRepoWebAppTest {
	
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
	public void test01() {
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/");
		String expectedTitle = "Maven Repository: Search/Browse/Explore";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals("Unable to find page", expectedTitle, actualTitle);
	}

	@Test
	public void test02() {
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/");
		
		String searchText = "selenium server";
		
		WebElement searchField = driver.findElement(By.id("query"));
		searchField.sendKeys(searchText);
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form/input[2]"));
		searchButton.click();
		
		String expectedTitle = "Maven Repository: selenium server";
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Not getting page for " + searchText, expectedTitle, actualTitle);
	}

	@Test
	public void test03(){
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/");
		
		String searchText = "selenium server";
		
		WebElement searchField = driver.findElement(By.id("query"));
		searchField.sendKeys(searchText);
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form/input[2]"));
		searchButton.click();		
		
		WebElement hyperText = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/h2/a[1]"));
		hyperText.click();
		
		String expectedTitle = "Maven Repository: org.seleniumhq.selenium » selenium-server";
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Result Page is not available", expectedTitle, actualTitle);
	}
}
