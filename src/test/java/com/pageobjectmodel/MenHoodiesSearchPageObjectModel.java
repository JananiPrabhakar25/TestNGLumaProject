package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.MenHoodiesSearchPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class MenHoodiesSearchPageObjectModel extends BaseClass_TestNG implements MenHoodiesSearchPageInterfaceElements {
	
	@FindBy(xpath = men_xpath)
	private WebElement men;
	
	@FindBy(xpath = tops_xpath)
	private WebElement tops;
	
	@FindBy(xpath = hoodies_xpath)
	private WebElement hoodies;
	
	@FindBy(xpath = macrolightweighthoodie_xpath)
	private WebElement macroLightWeightHoodie;
	
	@FindBy(xpath = size_xpath)
	private WebElement size;
	
	@FindBy(xpath = colour_xpath)
	private WebElement colour;
	
	@FindBy(xpath = addtocart_xpath)
	private WebElement addToCart;
	
	@FindBy(xpath = mycart_xpath)
	private WebElement myCart;
	
	@FindBy(xpath = proceedToCart_xpath)
	private WebElement proceedToCheckout;
	
	
	
	public MenHoodiesSearchPageObjectModel() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void getValidMenHoodiePage() {
		
		actionMethods(men, "move to element");
		actionMethods(tops, "move to element");
		clickOnElement(hoodies);
		impliciteWait(20);
		clickOnElement(macroLightWeightHoodie);
		impliciteWait(20);
		clickOnElement(size);
		clickOnElement(colour);
		impliciteWait(20);
		clickOnElement(addToCart);
		impliciteWait(20);
		clickOnElement(myCart);
		impliciteWait(10);
		clickOnElement(proceedToCheckout);

	}
	

}
