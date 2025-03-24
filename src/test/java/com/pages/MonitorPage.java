package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class MonitorPage extends TestExecutionPage {
	 public MonitorPage() {
			PageFactory.initElements(driver, this);
		}
		
			
			@FindBy(xpath="//a[text()='Apple monitor 24']")
			private WebElement firstMonitor;
			
			@FindBy(xpath="//h2[text()='Apple monitor 24']//following-sibling::h3")
			private WebElement monitorPrice;
			
			@FindBy(xpath="//a[text()='Add to cart']")
			private WebElement addToCart;
			
			
			public WebElement getFirstMonitor() {
				return firstMonitor;
			}
			
			public WebElement getMonitorPrice() {
				return monitorPrice;
			}
			
			public WebElement getAddToCart() {
				return addToCart;
			}
}
