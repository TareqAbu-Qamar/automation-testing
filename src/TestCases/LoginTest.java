package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.onlinevirtualstorewebsite.somee.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
		driver.manage().deleteAllCookies();
	}
	@AfterClass
	public void teardown() {
		driver.quit();	
	}
	@Test(priority = 4)
	public void infoTest() {
		ChromeOptions option = new ChromeOptions();
		WebDriver d = new ChromeDriver(option);
		d.navigate().to("http://www.onlinevirtualstorewebsite.somee.com");
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS , true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.out.println(option.getBrowserName());
		System.out.println(option.getCapability(CapabilityType.ACCEPT_INSECURE_CERTS));
		System.out.println(option.getCapability(CapabilityType.ACCEPT_SSL_CERTS));
	}
	@Test(priority = 5)
	public void titleTest() {
		String expected = "Login - Virtual Store";
		String actual = driver.getTitle();
		if(actual.equals(expected))
			System.out.println(actual);	
	}
	@Test(priority = 6)
	public void urlTest() {
		String expected = "http://www.onlinevirtualstorewebsite.somee.com";
		String actual = driver.getCurrentUrl();
		if(actual.equals(expected))
			System.out.println(actual);	
	}
	@Test(priority = 7)
	public void logoTest() {
		WebElement logo = driver.findElement(By.xpath("(//*[@class='navbar-brand'])"));
		boolean expected = true;
		boolean actual = logo.isDisplayed();
		if(actual == expected)
			System.out.println(actual);
	}
	@Test(priority = 8)
	public void formTest() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='form-group']"));
		System.out.println(elements.size());
		for(WebElement e : elements)
			System.out.println(e.getText() + " is enabled to editable : " + e.isEnabled());
	}
}
