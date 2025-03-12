package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.MenHoodiesCheckOutPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class MenHoodiesCheckoutPageObjectModel extends BaseClass_TestNG
		implements MenHoodiesCheckOutPageInterfaceElements {

	@FindBy(xpath = placeorder_xpath)
	private WebElement placeOrder;
	
	@FindBy(xpath = ordernumber_xpath )
	private WebElement orderNumber;
	
	public MenHoodiesCheckoutPageObjectModel() {

		PageFactory.initElements(driver, this);
	}

	public void getValidMenHoodiesCheckoutPage() {

		scrollDown_new(2000);
		javaScriptClick(placeOrder);
		String text = getText(orderNumber);
		System.out.println("The order number is:"+ text);
		

	}
}
