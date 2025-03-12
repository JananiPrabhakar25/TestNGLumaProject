package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.MenSearchProductPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class MenSearchProductPageObjectModel extends BaseClass_TestNG implements MenSearchProductPageInterfaceElements {

	@FindBy(xpath = men_xpath)
	private WebElement menOption;

	@FindBy(xpath = tops_xpath)
	private WebElement tops;

	@FindBy(xpath = jackets_xpath)
	private WebElement jackets;

	@FindBy(xpath = montanawindjacket_xpath)
	private WebElement montanawindJacket;

	@FindBy(xpath = mediumsize_xpath)
	private WebElement mediunSize;

	@FindBy(xpath = redcolour_xpath)
	private WebElement redColour;

	@FindBy(xpath = addtocart_xpath)
	private WebElement addToCart;

	@FindBy(xpath = mycart_xpath)
	private WebElement myCart;
	
	@FindBy(xpath = proceedToCart_xpath)
	private WebElement proceedToCheckout;
	
	
	public MenSearchProductPageObjectModel() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void getValidMenSearchPage() {
		
		actionMethods(menOption, "move to element");
		actionMethods(tops, "move to element");
		actionMethods(jackets, "move to element");
		clickOnElement(jackets);
		impliciteWait(20);
		clickOnElement(montanawindJacket);
		impliciteWait(10);
		clickOnElement(mediunSize);
		clickOnElement(redColour);
		impliciteWait(20);
		clickOnElement(addToCart);
		impliciteWait(20);
		clickOnElement(myCart);
		impliciteWait(20);
		clickOnElement(proceedToCheckout);
		
		
		
		

	}
	

}
