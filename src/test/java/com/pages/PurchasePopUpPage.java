package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class PurchasePopUpPage extends TestExecutionPage {
	public PurchasePopUpPage() {
	     PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
		private WebElement successMessage;
		
		@FindBy(xpath="//p[@class='lead text-muted ']")
		private WebElement purchaseDetails;
		
		public WebElement getSuccessMessage() {
			return successMessage;
		}
		public WebElement getPurchaseDetails() {
			return purchaseDetails;
		}
}
