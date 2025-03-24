package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.execution.TestExecutionPage;

public class OrderDetailsPage extends TestExecutionPage {
	private JavascriptExecutor js;
    private PlaceOrderPage placeOrderPage;

    public OrderDetailsPage(WebDriver driver, PlaceOrderPage placeOrderPage) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.placeOrderPage = placeOrderPage;
    }

    private void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    private void setElementValue(WebElement element, String value) {
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", element, value);
    }

    public void completePurchase(String name, String country, String city, String creditCard, String month, String year) {
        clickElement(placeOrderPage.getPlaceOrder());
        setElementValue(placeOrderPage.getName(), name);
        setElementValue(placeOrderPage.getCountry(), country);
        setElementValue(placeOrderPage.getCity(), city);
        setElementValue(placeOrderPage.getCreditCard(), creditCard);
        setElementValue(placeOrderPage.getMonth(), month);
        setElementValue(placeOrderPage.getYear(), year);
        clickElement(placeOrderPage.getPurchaseBtn());
    }
}
