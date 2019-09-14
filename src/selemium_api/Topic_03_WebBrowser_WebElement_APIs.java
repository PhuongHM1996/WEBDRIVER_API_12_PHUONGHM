package selemium_api;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import bsh.commands.dir;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_WebBrowser_WebElement_APIs {

	WebDriver driver;

	@Test
	public void TC_01_WebBrowserAPI() {
		// Đóng tab hiện tại đang đứng
		driver.close();

		// Đóng browser không quan tâm có bao nhiêu tab:
		driver.quit();

		// Mở ra 1 Url (App link)
		driver.get("https://live.guru99.com");

		// driver.manage().window().fullscreen();

		// Get ra cái url của page hiện tại
		String homePageUrl = driver.getCurrentUrl();

		Assert.assertTrue(homePageUrl.equals("https://live.guru99.com"));

		Assert.assertFalse(homePageUrl.equals("https://live.guru99.com/index.php"));

		Assert.assertEquals(homePageUrl, "https://live.guru99.com");

		// Trả về source code của page hiện tại: html/css/jquery/js/...
		String homepageSource = driver.getPageSource();
		Assert.assertTrue(homepageSource.contains("This is demo site for"));

		// Trả về title của page hiện tại
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Home page");

		// Trong bài xử lý Windows/Tabs
		driver.getWindowHandle();
		driver.getWindowHandles();

		// Chờ cho element được tìm thấy
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chờ cho page được load thành công
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Test GUI: Graphic User Interface
		driver.manage().window().maximize();

		// driver.navigate().back/refresh/forwar();

		// Tracking lại history
		driver.navigate().to("https://live.guru99.com");

		// Alert/Iframe (frame)/ Windowns
		driver.switchTo().alert().accept();
		driver.switchTo().frame("");
		driver.switchTo().window("");
	}

	@Test
	public void TC_02_WebElementAPI() {
		// Tìm element (nhiều) và locator là gì

		// Cách 1: Nếu như mà element này chỉ đùng 1 lần
		driver.findElement(By.id("search")).sendKeys("Samsung");

		// Cách 2: Nếu như mà element này dùng nhiều lần
		WebElement searchTextBox = driver.findElement(By.id("search"));

		// Xoá dữ liệu trước khi sendkeys
		searchTextBox.clear();

		// Nhập dữ liệu vào 1 textbox/textarea
		searchTextBox.sendKeys("");

		// Click vào 1 element: button/ link/ radio/ checkbox/...
		searchTextBox.click();

		// Tìm và thao tác vs 1 element: findElement
		searchTextBox.findElement(By.id("search")).click();

		// Tìm và thao tác vs nhiều element: findElements
		searchTextBox.findElements(By.id("search")).get(0);

		// tagname [@attribute='Value'] = '//input[id = 'search']
		String searchPlaceholderValue = searchTextBox.getAttribute("placeholder");

		// Test GUI: font/size/ color/ position/...
		String loginButtonColor = searchTextBox.getCssValue("background");
		// #3399cc

		// Build framework: Chụp hình nhúng vào Report
		// searchTextBox.getScreenshotAs("");

		WebElement searchTextBox_ = driver.findElement(By.cssSelector("#search"));
		String searchTextboxTagname = searchTextBox_.getTagName();
		// Sẽ trả về thẻ Input

		// Trả về text của 1 elemnet: link/ button/ label/...
		searchTextBox.getText();

		// AssertTrue/ False
		Assert.assertTrue(searchTextBox.isDisplayed());
		Assert.assertTrue(searchTextBox.isEnabled());
		Assert.assertTrue(searchTextBox.isSelected());

		boolean searchTextboxStatus = searchTextBox.isSelected();
		Assert.assertFalse(searchTextboxStatus);
		Assert.assertEquals(searchTextboxStatus, false);

	}

	@BeforeClass
	public void initData() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void cleanData() {
	}

}
