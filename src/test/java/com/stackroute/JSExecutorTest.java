package com.stackroute;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class JSExecutorTest {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		String chromePath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);

		driver = new ChromeDriver();
		driver.get("https://javascript.info/alert-prompt-confirm");
	}

	@AfterClass
	public static void windUp() {
		driver.close();
	}

	@Test
	public void test01() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.setTimeout(1000);");
	}

	@Test
	public void test02() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[1]/article/div[2]/div[1]/div/div[1]/div[1]/a")).click();
		driver.switchTo().alert().accept();
	}

	@Test
	public void test03() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[1]/article/div[2]/div[4]/div/div[1]/div[1]/a")).click();
		Thread.sleep(2000);
		Alert alertWin = driver.switchTo().alert();
		alertWin.sendKeys("20");
		alertWin.accept();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
}
