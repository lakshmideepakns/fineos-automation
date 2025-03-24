package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class PlaceOrderPage extends TestExecutionPage {
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement placeOrder;
	 
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="country")
	private WebElement country;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="card")
	private WebElement creditCard;
	
	@FindBy(id="month")
	private WebElement month;

	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	private WebElement purchaseBtn;
	
	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	public WebElement getName() {
		return name;
	}
	public WebElement getCountry() {
		return country;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getCreditCard() {
		return creditCard;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getPurchaseBtn() {
		return purchaseBtn;
	}
}
