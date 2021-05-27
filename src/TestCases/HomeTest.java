package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest {
	WebDriver driver;
	@BeforeClass
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.onlinevirtualstorewebsite.somee.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
		driver.manage().deleteAllCookies();
		
		WebElement Email = driver.findElement(By.id("Email"));
		WebElement Password = driver.findElement(By.id("Password"));
		WebElement loginButton = driver.findElement(By.name("submit"));	
		Email.sendKeys("ghaitheldalahmeh@gmail.com");
		Password.sendKeys("Yde079078@");
		loginButton.click();
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();	
	}
	@Test(priority = 10)
	public void feedbackTest() {
		driver.findElement(By.partialLinkText("Feedback")).click();
		WebElement Content = driver.findElement(By.id("Content"));
		Content.clear();
		Content.sendKeys("The best choice for Online Virtual Shopping");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
	}
	@Test(priority = 9)
	public void manageTest() {
		WebElement img = driver.findElement(By.xpath("(//*[@class='roundedcorners'])"));
		img.click();
		WebElement manage = driver.findElement(By.linkText("Manage Account"));
		boolean actual = manage.isDisplayed();
		manage.click();
		Assert.assertTrue(actual, "the Manage Account option is not display");	
	}
	@Test(priority = 11)
	public void logoutTest() {
		manageTest();
		WebElement img = driver.findElement(By.xpath("(//*[@class='roundedcorners'])"));
		img.click();
		WebElement log = driver.findElement(By.partialLinkText("Log"));
		boolean actual = log.isDisplayed();
		log.click();
		Assert.assertTrue(actual, "the LogOut option is not display");	
	}

}
