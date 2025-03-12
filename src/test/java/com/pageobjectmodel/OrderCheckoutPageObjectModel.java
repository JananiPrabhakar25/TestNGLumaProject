package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.interfaceelements.OrderCheckOutPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;
import com.utilityfiles.ExcelUtility;

public class OrderCheckoutPageObjectModel extends BaseClass_TestNG implements OrderCheckOutPageInterfaceElements {
	
	@FindBy(xpath = placeorder_xpath)
	private WebElement placeOrderButton;
	
	@FindBy(xpath = ordernumber_xpath)
	private WebElement orderNumber;
	
	@FindBy(css = message_css)
	private WebElement message;
	
	public OrderCheckoutPageObjectModel() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean getValidCheckOutOrderPage(ExtentTest extenttest) {
		
		try {
			impliciteWait(20);
			scrollDown_new(2000);
			javaScriptClick(placeOrderButton);
			impliciteWait(20);
			String orderno = getText(orderNumber);
			System.out.println("Your order number is:"+ orderno);
			validation(message.getText(), "Thank you for your purchase!");
			System.out.println("Actual: " + message.getText() + " and Expected: "+ExcelUtility.getCellValue("Data", "ID", "Title")  );
			extenttest.log(Status.PASS, "Order Successful");
		} catch (Exception e) {
			extenttest.log(Status.FAIL, "Order unsuccessful");
			return false;
			
		}
		return true;
		
		
		

	}
	

}
