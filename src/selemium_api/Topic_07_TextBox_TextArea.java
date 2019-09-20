package selemium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_TextBox_TextArea {

	WebDriver driver;

	By usernameLoginTextbox = By.xpath("//input[@name='uid']");
	By passwordLoginTextbox = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//input[@name='btnLogin']");

	By newCustomerButton = By.xpath("//a[text()='New Customer']");
	By editCustomerButton = By.xpath("//a[text()='Edit Customer']");

	By customerNameTextbox = By.xpath("//input[@name='name']");
	By genderTextbox = By.xpath("//input[@name='gender']");
	By dateOfBirthTextbox = By.xpath("//input[@name='dob']");
	By addressTextbox = By.xpath("//textarea[@name='addr']");
	By cityTextbox = By.xpath("//input[@name='city']");
	By stateTextbox = By.xpath("//input[@name='state']");
	By pinTextbox = By.xpath("//input[@name='pinno']");
	By MobiNumberTextbox = By.xpath("//input[@name='telephoneno']");
	By emailTextbox = By.xpath("//input[@name='emailid']");
	By passwordTextbox = By.xpath("//input[@name='password']");
	By submitButton = By.xpath("//input[@name='sub']");

	By customerIDTextbox = By.xpath("//input[@name='cusid']");

	String customerName, gender, dateOfBirth, address, city, state, pin, mobiNumber, email, password, customerID;
	String editAddress, editCity, editState, editPin, editMobiNumber, editEmail;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");

		customerName = "Blinnie Wraight";
		gender = "male";
		dateOfBirth = "1996-02-01";
		address = "1764 Hansons Street";
		city = "Lincoln";
		state = "Maryland";
		pin = "685317";
		mobiNumber = "4029161958";
		email = "gmail2@gmail.com";
		password = "123456a";

		editAddress = "editAddress";
		editCity = "editCity";
		editState = "editState";
		editPin = "111111";
		editMobiNumber = "0123123123";
		editEmail = "editEmail@gmail.com";
	}

	@Test
	public void TC_01_CreateNewCustomer() {

		sendkeyToElement(usernameLoginTextbox, "mngr224077");
		sendkeyToElement(passwordLoginTextbox, "tuhygAd");
		clickToElemet(loginButton);

		clickToElemet(newCustomerButton);
		// Input data
		sendkeyToElement(customerNameTextbox, customerName);
		// sendkeyToElement(by, value);
		sendkeyToElement(dateOfBirthTextbox, dateOfBirth);
		sendkeyToElement(addressTextbox, address);
		sendkeyToElement(cityTextbox, city);
		sendkeyToElement(stateTextbox, state);
		sendkeyToElement(pinTextbox, pin);
		sendkeyToElement(MobiNumberTextbox, mobiNumber);
		sendkeyToElement(emailTextbox, email);
		sendkeyToElement(passwordTextbox, password);

		clickToElemet(submitButton);

		// Output data (Verify = Input)

		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Customer Name']/following-sibling::td")),
				customerName);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Gender']/following-sibling::td")), gender);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Birthdate']/following-sibling::td")), dateOfBirth);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Address']/following-sibling::td")), address);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='City']/following-sibling::td")), city);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='State']/following-sibling::td")), state);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Pin']/following-sibling::td")), pin);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Mobile No.']/following-sibling::td")), mobiNumber);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Email']/following-sibling::td")), email);

		// Get CustomerID 51395
		customerID = getTextElement(By.xpath("// td[text()='Customer ID']/following-sibling::td"));
	}

	@Test
	public void TC_02_EditNewCustomer() {

		clickToElemet(editCustomerButton);
		sendkeyToElement(customerIDTextbox, customerID);
		clickToElemet(By.xpath("//input[@name='AccSubmit']"));

		// Verify data at Edit Customer = Input (New data)
		Assert.assertEquals(getAtributeValue(customerNameTextbox, "value"), customerName);
		Assert.assertEquals(getAtributeValue(genderTextbox, "value"), gender);
		Assert.assertEquals(getAtributeValue(dateOfBirthTextbox, "value"), dateOfBirth);
		Assert.assertEquals(getTextElement(addressTextbox), address);
		Assert.assertEquals(getAtributeValue(cityTextbox, "value"), city);
		Assert.assertEquals(getAtributeValue(stateTextbox, "value"), state);
		Assert.assertEquals(getAtributeValue(pinTextbox, "value"), pin);
		Assert.assertEquals(getAtributeValue(MobiNumberTextbox, "value"), mobiNumber);
		Assert.assertEquals(getAtributeValue(emailTextbox, "value"), email);
		
		cleanElement(addressTextbox);
		sendkeyToElement(addressTextbox, editAddress);
		
		cleanElement(cityTextbox);
		sendkeyToElement(cityTextbox, editCity);
		
		cleanElement(stateTextbox);
		sendkeyToElement(stateTextbox, editState);
		
		cleanElement(pinTextbox);
		sendkeyToElement(pinTextbox, editPin);
		
		cleanElement(MobiNumberTextbox);
		sendkeyToElement(MobiNumberTextbox, editMobiNumber);
		
		cleanElement(emailTextbox);
		sendkeyToElement(emailTextbox, editEmail);

		clickToElemet(submitButton);

		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Customer ID']/following-sibling::td")), customerID);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Customer Name']/following-sibling::td")),
				customerName);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Gender']/following-sibling::td")), gender);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Birthdate']/following-sibling::td")), dateOfBirth);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Address']/following-sibling::td")), editAddress);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='City']/following-sibling::td")), editCity);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='State']/following-sibling::td")), editState);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Pin']/following-sibling::td")), editPin);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Mobile No.']/following-sibling::td")),
				editMobiNumber);
		Assert.assertEquals(getTextElement(By.xpath("// td[text()='Email']/following-sibling::td")), editEmail);

	}

	public void sendkeyToElement(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void clickToElemet(By by) {
		driver.findElement(by).click();
	}

	public String getTextElement(By by) {
		return driver.findElement(by).getText();
	}
	
	public void cleanElement(By by) {
		driver.findElement(by).clear();
	}
	public String getAtributeValue(By by, String attributeName) {
		return driver.findElement(by).getAttribute(attributeName);
	}

	@AfterClass
	public void afterClass() {

		 driver.quit();
	}

}
