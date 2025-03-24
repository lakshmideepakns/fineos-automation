package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {
	WebDriver driver;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    public DetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }
}
