package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class LaptopPage extends TestExecutionPage {
	public LaptopPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sony vaio i5']")
	private WebElement firstLaptop;
	
	@FindBy(xpath="//h2[text()='Sony vaio i5']//following-sibling::h3")
	private WebElement laptopPrice;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCart;
	
	
	public WebElement getFirstLaptop() {
		return firstLaptop;
	}
	
	public WebElement getLaptopPrice() {
		return laptopPrice;
	}
	
	public WebElement getAddToCart() {
		return addToCart;
	}
}
