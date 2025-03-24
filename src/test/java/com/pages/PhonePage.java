package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class PhonePage extends TestExecutionPage {
	 public PhonePage() {
	        PageFactory.initElements(driver, this);
	    }
	 
	    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
	    private WebElement firstPhone;

	    @FindBy(xpath="//h2[text()='Samsung galaxy s6']//following-sibling::h3")
		private WebElement phoneprice;
	    
	    @FindBy(xpath="//a[text()='Add to cart']")
	    private WebElement addToCart;

	    public WebElement getAddToCart() {
			return addToCart;
		}

		public WebElement getFirstPhone() {
			return firstPhone;
		}
	    
		public WebElement getPhoneprice() {
			return phoneprice;
		}

}
