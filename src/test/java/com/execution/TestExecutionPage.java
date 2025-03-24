package com.execution;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.DetailPage;
import com.pages.HomePage;
import com.pages.LaptopPage;
import com.pages.PhonePage;
import com.pages.PlaceOrderPage;
import com.pages.PurchasePopUpPage;
import com.pages.RemoveFromCartPage;
import com.pages.MonitorPage;
import com.pages.OrderDetailsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExecutionPage {
	public static WebDriver driver;
	int mobilePriceValue;
	int monitorPriceValue;
	int laptopPriceValue;

	@BeforeClass
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
//1-	Navigate to www.demoblaze.com
	@Test(priority = 1)
	public void navigateToDemoBlaze() {
		driver.get("https://www.demoblaze.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expectedTitle = "STORE";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	}
//2-	Navigate to phones and choose one of them to buy. Get its price.
	@Test(priority = 2)
	public void buyPhone() {
		HomePage homePage = new HomePage();
		homePage.getMobileMenu().click();

		PhonePage mobilePage = new PhonePage();
		mobilePage.getFirstPhone().click();

		String mobilePrice = mobilePage.getPhoneprice().getText();

		String[] split = mobilePrice.split(" ");
		String substring = split[0].substring(1);
		mobilePriceValue = Integer.parseInt(substring);

		System.out.println("Mobile Price value is $" + mobilePriceValue);

		mobilePage.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			alert.accept();
			System.out.println(alertMessage);
		}

	}
//3-	Navigate to Laptops and add one of the laptops to the shopping cart. Get its price.
	@Test(priority = 3)
	public void addLaptop() {
		HomePage homePage = new HomePage();
		homePage.getHomePage().click();
		homePage.getLaptopsMenu().click();

		LaptopPage laptopPage = new LaptopPage();
		laptopPage.getFirstLaptop().click();

		String laptopPrice = laptopPage.getLaptopPrice().getText();
		String[] split = laptopPrice.split(" ");
		String substring = split[0].substring(1);
		laptopPriceValue = Integer.parseInt(substring);

		System.out.println("Laptop Price value is $" + laptopPriceValue);

		laptopPage.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			alert.accept();
			System.out.println(alertMessage);
		}

	}
//4-	Navigate to Monitors, add one of them to the cart. Get its price.
	@Test(priority = 4)
	public void addMonitor() {
		HomePage homePage = new HomePage();
		homePage.getHomePage().click();
		homePage.getMonitorMenu().click();

		MonitorPage monitorPage = new MonitorPage();
		monitorPage.getFirstMonitor().click();

		String monitorPrice = monitorPage.getMonitorPrice().getText();
		String[] split = monitorPrice.split(" ");
		String substring = split[0].substring(1);
		monitorPriceValue = Integer.parseInt(substring);
		System.out.println("Monitor Price value is $" + monitorPriceValue);
		monitorPage.getAddToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			alert.accept();
			System.out.println(alertMessage);
		}

	}
//5-	Go to the shopping cart and remove the phone.
	@Test(priority = 5)
	public void removePhoneFromCartPage() throws InterruptedException {
		RemoveFromCartPage removeFromCartPage = new RemoveFromCartPage();
		removeFromCartPage.getCart().click();
		removeFromCartPage.getRemovePhoneFromCart().click();
		System.out.println("Phone Removed Successfully From Cart Page");
		Thread.sleep(10000);
	}
//6-	Place the order.
	@Test(priority = 6)
	public void placeOrder(){
		PlaceOrderPage placeOrderPage = new PlaceOrderPage();
		OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver, placeOrderPage);
		orderDetailsPage.completePurchase("Deepak", "India", "Chennai", "7685698432456798", "March", "2025");
		System.out.println("Order Placed Successfully");
	}
//7-	Check that your purchase has been successful, with the correct amount, and get its purchase id.
	@Test(priority = 7)
	public void verifyPurchaseDetails() {
		String actualMessage = "Thank you for your purchase!";
		PurchasePopUpPage purchasePopUpPage = new PurchasePopUpPage();
		String expectedMessage = purchasePopUpPage.getSuccessMessage().getText();
		
		Assert.assertEquals(expectedMessage, actualMessage, "order placing is failed");
		System.out.println("Order succesfully placed Message Verified");

		String purchaseDetails = purchasePopUpPage.getPurchaseDetails().getText();
		String id = purchaseDetails.split("/n")[0].split(":")[1].trim().substring(0, 6);

		System.out.println("Purchase ID is " + id);
		String amount = purchaseDetails.split("/n")[0].split(":")[2].trim().split(" ")[0];
		int expectedAmount = Integer.parseInt(amount);
		System.out.println("Total Purchase Amount is $" + expectedAmount);
		int actualAmount = laptopPriceValue + monitorPriceValue;
		Assert.assertEquals(actualAmount, expectedAmount, "Purchase Value Total Mismatched");
		System.out.println("Total Purcahse Value Matches With Added Product Prices");
	}
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
}
