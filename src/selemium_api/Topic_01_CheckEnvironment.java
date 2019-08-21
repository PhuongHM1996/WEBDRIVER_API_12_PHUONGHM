package selemium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_CheckEnvironment {
	WebDriver driver;

	@Test
	public void TC_01_Check_HomePage_Url() {
		System.out.println("TC_01 - Step 01: Get Current Page Url");
		String homePageUrl = driver.getCurrentUrl();
		
		System.out.println("TC_01 - Step 02: Verify expected url mathching vs actual url");
		AssertJUnit.assertEquals(homePageUrl, "https://itviec.com/");
	}

	@Test
	public void TC_01_Check_HomePage_Title() {
		System.out.println("TC_02 - Step 01: Get Current Page Title");
		String homePageTitle = driver.getTitle();
		
		System.out.println("TC_01 - Step 02: Verify expected url mathching vs actual title");
		AssertJUnit.assertEquals(homePageTitle, "ITviec | Top IT Jobs for You");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condetion - Step 01: Init Chrome browser");

		driver = new FirefoxDriver();

		System.out.println("Pre-condetion - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Pre-condetion - Step 03: Open ItViec app url");
		driver.get("https://itviec.com/");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();

	}

}
