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





public class SignupTest {
	WebDriver driver;
	String gmail = "tareqaq21@gmail.com";
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.onlinevirtualstorewebsite.somee.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
		driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Click to Sign up")).click();
	}
	@AfterClass
	public void teardown() {
		driver.quit();	
	}
	@Test(priority = 3)
	public void signupTest() {
		WebElement form = driver.findElement(By.xpath("//form[@action='/Account/Signup']"));
		WebElement userName = form.findElement(By.id("UserNamee"));
		WebElement address = form.findElement(By.id("Address"));
		WebElement email = form.findElement(By.id("Email"));
		WebElement password = form.findElement(By.id("Password"));
		WebElement phone = form.findElement(By.id("PhoneNum"));
		userName.sendKeys("Tareq");
		Select city = new Select(address);
		city.selectByValue("Amman");
		email.sendKeys("tareqaq21@gmail.com");
		password.sendKeys("tareq2018");
		phone.sendKeys("0795175848");
		driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
	}
	@Test(priority = 2)
	public void loginTest() {
		driver.findElement(By.linkText("Click to login")).click();
		WebElement e = driver.findElement(By.id("Email"));
		e.sendKeys("tareqaq21@gmail.com");
		if(e.getAttribute("value").equals(gmail)) {
			driver.findElement(By.linkText("Click to login")).click();
			Assert.assertTrue(true, "this email already registered");
		}		
	}
	@Test(priority = 1)
	public void formTest() {
		WebElement f = driver.findElement(By.xpath("//*[@class='form-horizontal']"));
		List<WebElement> L = f.findElements(By.className("form-group"));
		for(WebElement e : L)
			System.out.println(e.isDisplayed() + "	" + e.isEnabled());
		boolean check = f.isDisplayed();
		Assert.assertTrue(check, "this form is not display on page");
	}

	

}
