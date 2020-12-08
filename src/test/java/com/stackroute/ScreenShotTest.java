package com.stackroute;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotTest {
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

	// Screenshot when page is same size as screen
	@Test
	public void test01() throws IOException {
		driver.navigate().to("https://www.google.com");
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File scrShotFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				"D:\\Programs\\JavaPrograms\\CGI-Wave2-TestAutomation\\MvnRepoSeleniumProject\\screenshot\\google.png");
		FileUtils.copyFile(scrShotFile, destinationFile);
	}

	// Screenshot when page is bigger than screen
	@Test
	public void test02() throws IOException {
		driver.navigate().to("https://mvnrepository.com/");
		Screenshot screenShot = new AShot().takeScreenshot(driver);
		Screenshot bigScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);

		ImageIO.write(screenShot.getImage(), "png", new File(
				"D:\\Programs\\JavaPrograms\\CGI-Wave2-TestAutomation\\MvnRepoSeleniumProject\\screenshot\\ScreenShot.png"));
		ImageIO.write(bigScreenShot.getImage(), "png", new File(
				"D:\\Programs\\JavaPrograms\\CGI-Wave2-TestAutomation\\MvnRepoSeleniumProject\\screenshot\\CompleteScreenShot.png"));
	}

//	// Screenshot for individual element
//	@Test
//	public void test03() throws IOException {
//		driver.navigate().to("https://google.com/");
//		WebElement queryElement = driver.findElement(By.name("btnK"));
//		
//		Screenshot screenShot = new AShot().takeScreenshot(driver, queryElement);
//	
//		ImageIO.write(screenShot.getImage(), "jpg", new File(
//				"D:\\Programs\\JavaPrograms\\CGI-Wave2-TestAutomation\\MvnRepoSeleniumProject\\screenshot\\QueryImage.jpg"));
//		
//	}
}
