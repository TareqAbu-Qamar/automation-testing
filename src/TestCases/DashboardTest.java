package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;






public class DashboardTest {
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
		Email.sendKeys("ghaithsuleiman04@gmail.com");
		Password.sendKeys("Yde079078@");
		loginButton.click();
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();	
	}
	@Test(priority = 12)    
	public void manageTest() {
		WebElement img = driver.findElement(By.xpath("(//*[@class='roundedcorners'])"));
		img.click();
		WebElement manage = driver.findElement(By.linkText("Manage Account"));
		boolean actual = manage.isDisplayed();
		manage.click();
		Assert.assertTrue(actual, "The Manage Account option is not display");	
	}
	@Test(priority = 13)
	public void userNameTest() {
		manageTest();
		WebElement input = driver.findElement(By.id("UserNamee"));
		boolean actual = input.isEnabled();
		input.clear();
		Assert.assertTrue(actual, "The UserName textbox is enabled");
	}
	@Test(priority = 14)
	public void addressTest() {
		manageTest();
		WebElement address = driver.findElement(By.id("Address"));
		Select city = new Select(address);
		city.selectByValue("Amman");
		WebElement button = driver.findElement(By.xpath("//*[@class='btn btn-default']"));
		boolean actual = button.isEnabled();
		//button.click();
		Assert.assertTrue(actual, "The Save Button is not enabled");
	}
	@Test(priority = 17)
	public void logoutTest() {
		manageTest();
		WebElement img = driver.findElement(By.xpath("(//*[@class='roundedcorners'])"));
		img.click();
		WebElement log = driver.findElement(By.partialLinkText("Log"));
		boolean actual = log.isDisplayed();
		log.click();
		Assert.assertTrue(actual, "the LogOut option is not display");	
	}
	@Test(priority = 15)
	public void usersTest() {
		driver.findElement(By.xpath("//*[@class='col text-center']")).click();
		WebElement mytable = driver.findElement(By.tagName("table"));
		List <WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		System.out.println("The Data of User 1 : " + rows_table.get(1).getText());
		for (WebElement e : rows_table)
			System.out.print(e.getText() + "\n");
		System.out.println("Number of users : " + (rows_table.size() - 1));
	}
	@Test(priority = 16)
	public void itemsTest() {
		driver.findElement(By.xpath("(//*[@class='col text-center'])[2]")).click();
		WebElement table = driver.findElement(By.className("table"));

		List<WebElement> E = table.findElements(By.xpath("//*[@class='table']/tbody[text()]"));
		for (WebElement e : E)
			System.out.println(e.getText());	
	}



}
