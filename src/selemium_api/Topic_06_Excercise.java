package selemium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_Excercise {

	WebDriver driver;

	By emailTextbox = By.xpath("//input[@id='mail']");
	By ageUnder18Radio = By.xpath("//input[@id='under_18']");
	By educationTextArea = By.xpath("//textarea[@id='edu']");
	By nameUser04 = By.xpath("//h5[text()='Name: User4']//following-sibling::a");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By jobRole01 = By.xpath("//select[@id='job1']");
	By jobRole02 = By.xpath("//select[@id='job2']");
	By developmentCheckbox = By.xpath("//input[@id='development']");
	By ageOver18Radio = By.xpath("//input[@id='over_18	']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void TC_01_IsDisplayed() throws InterruptedException {

		driver.get("https://daominhdam.github.io/basic-form/index.html");
		
//		if (driver.findElement(emailTextbox).isDisplayed()) {
//			driver.findElement(emailTextbox).sendKeys("Automation Testing");
//		}
//		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
//			driver.findElement(ageUnder18Radio).click();
//		}
//		if (driver.findElement(educationTextArea).isDisplayed()) {
//			driver.findElement(educationTextArea).sendKeys("Automation Testing");
//		}

		if (isElementDisplayed(emailTextbox)) {
			sendkeyToElement(emailTextbox, "Automation testing");
		}

		Assert.assertTrue(isElementDisplayed(emailTextbox));

		if (isElementDisplayed(ageUnder18Radio)) {
			clickToElement(ageUnder18Radio);
		}

		Assert.assertTrue(isElementDisplayed(ageUnder18Radio));

		if (isElementDisplayed(educationTextArea)) {
			sendkeyToElement(educationTextArea, "Automation testing");
		}

		Assert.assertTrue(isElementDisplayed(educationTextArea));

		if (isElementDisplayed(nameUser04)) {
			clickToElement(nameUser04);
		}

		Assert.assertFalse(isElementDisplayed(nameUser04));

		Thread.sleep(5000);
	}

	@Test
	public void TC_02_IsEnabled() {

		driver.get("https://daominhdam.github.io/basic-form/index.html");

		Assert.assertTrue(isElementEnabled(emailTextbox));
		Assert.assertTrue(isElementEnabled(ageUnder18Radio));
		Assert.assertTrue(isElementEnabled(educationTextArea));
		Assert.assertTrue(isElementEnabled(ageUnder18Radio));
		Assert.assertFalse(isElementEnabled(jobRole01));
		
		Assert.assertFalse(isElementEnabled(passwordTextbox));
		Assert.assertFalse(isElementEnabled(jobRole02));
	}

	@Test
	public void TC_03() {
		
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		// RadioButton : chọn được 1 lần -> không được bỏ chọn
		clickToElement(ageOver18Radio);
		// Checkbox: Chọn/bỏ chọn nhiều lần
		clickToElement(developmentCheckbox);
		
		Assert.assertTrue(isElementSelected(ageOver18Radio));
		Assert.assertTrue(isElementSelected(developmentCheckbox));
		
		clickToElement(developmentCheckbox);
		Assert.assertFalse(isElementSelected(developmentCheckbox));
		
	}

	public boolean isElementDisplayed(By by) {
		if (driver.findElement(by).isDisplayed()) {
			System.out.println("Element with locator [" + by + "] is displayed");
			return true;
		} else {
			System.out.println("Element with locator [" + by + "] is not displayed");
			return false;
		}
	}

	public boolean isElementEnabled(By by) {
		if (driver.findElement(by).isEnabled()) {
			System.out.println("Element with locator [" + by + "] is enabled");
			return true;
		} else {
			System.out.println("Element with locator [" + by + "] is not enabled");
			return false;
		}
	}

	public boolean isElementSelected(By by) {
		if (driver.findElement(by).isSelected()) {
			System.out.println("Element with locator [" + by + "] is selected");
			return true;
		} else {
			System.out.println("Element with locator [" + by + "] is not selected");
			return false;
		}
	}

	public void sendkeyToElement(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void clickToElement(By by) {
		driver.findElement(by).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
