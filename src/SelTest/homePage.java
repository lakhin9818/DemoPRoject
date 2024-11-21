package SelTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.baseUi;

public class homePage extends baseUi {

	WebDriver driver = setup();

	@Test(enabled = true, priority = 1)
	public void GetWelcomeTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

}
