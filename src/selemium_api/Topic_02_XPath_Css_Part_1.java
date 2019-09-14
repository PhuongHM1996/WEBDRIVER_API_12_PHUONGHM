package selemium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_XPath_Css_Part_1 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() throws Exception {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()= 'My Account']")).click();
		// Tìm element có id = email - sau khi tìm được thì nhập dữ liệu vào cho element
		// này
		driver.findElement(By.id("email")).sendKeys("id_email@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();

		driver.findElement(By.className("validate-email")).sendKeys("name_gmail@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		
		driver.findElement(By.linkText("SITE MAP")).click();
		driver.findElement(By.partialLinkText("ADVANCED")).click();
		driver.findElement(By.xpath("//div[@class='footer']//a[text()= 'My Account']")).click();
		System.out.println("Tat ca link tren page" + driver.findElements(By.tagName("a")).size());
		
		
		//CSS
		driver.findElement(By.cssSelector("#email")).sendKeys("css_01@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#email")).clear();
		
		driver.findElement(By.cssSelector(".validate-email")).sendKeys("css_02@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".validate-email")).clear();
		
		driver.findElement(By.cssSelector("input[name='login[username]']")).sendKeys("css_02@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='login[username]']")).clear();
		System.out.println("Tat ca link tren page" + driver.findElements(By.cssSelector("a")).size());
		
		//Xpath
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xpath_01@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		
		driver.findElement(By.xpath("//input[contains(@class,'validate-email')]")).sendKeys("xpath_02@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'validate-email')]")).clear();
		
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("xpath_03@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='login[username]']")).clear();
		
		System.out.println("Tat ca link tren page" + driver.findElements(By.xpath("//a")).size());
	}

	@Test
	public void TC_02() {

	}

	@AfterClass
	public void afterClass() {
	}

}
