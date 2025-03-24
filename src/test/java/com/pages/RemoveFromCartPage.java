package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class RemoveFromCartPage extends TestExecutionPage {
	public RemoveFromCartPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cart;
	
	@FindBy(xpath="//td[text()='Samsung galaxy s6']//following-sibling::td//child::a[text()='Delete']")
	private WebElement removePhoneFromCart;
	
	public WebElement getCart() {
		return cart;
	}
	
	public WebElement getRemovePhoneFromCart() {
		return removePhoneFromCart;
	}
}
