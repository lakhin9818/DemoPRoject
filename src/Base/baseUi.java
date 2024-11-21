package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import SelTest.homePage;

public class baseUi {
	public static WebDriver driver;
	homePage objhomePage;

	@BeforeMethod
	public static WebDriver setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\lakhin\\DemoProject\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://automationexercise.com/");
		return driver;
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}
