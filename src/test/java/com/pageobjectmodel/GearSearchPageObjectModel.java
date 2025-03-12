package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.GearPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class GearSearchPageObjectModel extends BaseClass_TestNG implements GearPageInterfaceElements {

	@FindBy(xpath = gear_xpath)
	private WebElement gear;

	@FindBy(xpath = bags_xpath)
	private WebElement bags;

	@FindBy(xpath = overnightdufflebag_xpath)
	private WebElement overNightDuffleBag;

	@FindBy(xpath = quantity_xpath )
	private WebElement quantity;

	@FindBy(xpath = addtocart_xpath)
	private WebElement addToCart;

	@FindBy(xpath = mycart_xpath)
	private WebElement myCart;

	@FindBy(xpath = proceedToCart_xpath)
	private WebElement proceedToCheckout;
	
	public GearSearchPageObjectModel() {
		PageFactory.initElements(driver, this);
	}
	
	public void getvalidgearsearch() {
		
		actionMethods(gear, "move to element");
		actionMethods(bags, "move to element");
		clickOnElement(bags);
		impliciteWait(20);
		clickOnElement(overNightDuffleBag);
		impliciteWait(20);
		clickOnElement(quantity);
		selectAll();
		passInput(quantity, "2");
		impliciteWait(20);
		clickOnElement(addToCart);
		impliciteWait(20);
		clickOnElement(myCart);
		impliciteWait(20);
		clickOnElement(proceedToCheckout);
	
		

	}
	

}
