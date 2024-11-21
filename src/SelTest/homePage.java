package SelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Loggers;
import Base.baseUi;
import pageObjectAndFunction.homePageObject;

public class homePage extends baseUi {
	Loggers logger = new Loggers();
	WebDriver driver = setup();
	homePageObject hmO = new homePageObject();

	// WebElement library
	WebElement signupButton = driver.findElement(By.xpath("//a[contains(text(),' Signup')]"));

	@Test(enabled = true, priority = 1)
	public void GetWelcomeTitle() {
		String title = driver.getTitle();
		String expectedTitle = "Automation Exercised";
		Assert.assertEquals(title, expectedTitle);
//		Assert();
	}

	@Test(enabled = true, priority = 2)
	public void registerUser() throws InterruptedException {
		Thread.sleep(300);
		hmO.click(signupButton);

	}
}
