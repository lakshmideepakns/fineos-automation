package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.execution.TestExecutionPage;

public class HomePage extends TestExecutionPage{
	public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="//a[text()='Phones']")
    private WebElement mobileMenu;
    
    @FindBy(xpath="//a[text()='Laptops']")
	private WebElement laptopMenu;
    
    @FindBy(xpath="//a[text()='Home ']")
   	private WebElement homePage;
    
    @FindBy(xpath="//a[text()='Monitors']")
	private WebElement monitorMenu;
    
    public WebElement getMobileMenu() {
		return mobileMenu;
	}
    
    public WebElement getLaptopsMenu() {
		return laptopMenu;
	}
    
	public WebElement getHomePage() {
	return homePage;
	}
	
	public WebElement getMonitorMenu() {
		return monitorMenu;
	}
}
