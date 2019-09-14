package selemium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_04_Excercise {

	WebDriver driver;
	String emailddress;

	By myAccountLink = By.xpath("//div[@class='footer']//a[text()='My Account']");
	By emailTextbox = By.xpath("//input[@id='email']");
	By paawordTextbox = By.xpath("//input[@id='pass']");
	By loginButton = By.xpath("//button[@id='send2']");

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();

		emailddress = "auto_test_P_" + randomNumber() + "@gmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void loodForEveryTest() {
		driver.get("http://live.guru99.com/index.php/");
		driver.findElement(myAccountLink).click();
	}

	@Test
	public void TC_01_LoginWithEmailAndPasswordEmpty() {

		driver.findElement(emailTextbox).sendKeys("");
		driver.findElement(paawordTextbox).sendKeys("");
		driver.findElement(loginButton).click();

		String emailErrorMsg = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(emailErrorMsg, "This is a required field.");

		String passwordErrorMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();
		Assert.assertEquals(passwordErrorMsg, "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithEmailInvalid() {

		driver.findElement(emailTextbox).sendKeys("12341234@12312.1234");
		driver.findElement(paawordTextbox).sendKeys("");
		driver.findElement(loginButton).click();

		String emailInvalidMsg = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertEquals(emailInvalidMsg, "Please enter a valid email address. For example johndoe@domain.com.");

		String passwordErrorMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();
		Assert.assertEquals(passwordErrorMsg, "This is a required field.");
	}

	@Test
	public void TC_03_LoginWithPasswordLessThan6Chars() {

		driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
		driver.findElement(paawordTextbox).sendKeys("123");
		driver.findElement(loginButton).click();

		String passwordErrorMsg = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals(passwordErrorMsg, "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_04_LoginWithPasswordIncorrect() {

		driver.findElement(emailTextbox).sendKeys("automation@132.com");
		driver.findElement(paawordTextbox).sendKeys("123123123");
		driver.findElement(loginButton).click();

		String invalidMsg = driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
		Assert.assertEquals(invalidMsg, "Invalid login or password.");

	}

	@Test
	public void TC_05_CreateNewAccount() {

		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Hoàng Minh");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Phương");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Register']")).click();

		String customerAccountLink = driver.getCurrentUrl();
		Assert.assertEquals(customerAccountLink, "http://live.guru99.com/index.php/customer/account/index/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {

		Random random = new Random();
		return random.nextInt(999999);
	}

}
