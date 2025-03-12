package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.WomenSearchPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class WomenSearchPageObjectModel extends BaseClass_TestNG implements WomenSearchPageInterfaceElements {

	@FindBy(xpath = women_xpath)
	private WebElement women;

	@FindBy(xpath = tops_xpath)
	private WebElement tops;

	@FindBy(xpath = jackets_xpath)
	private WebElement jackets;

	@FindBy(xpath = junojack_xpath)
	private WebElement junoJacket;

	@FindBy(xpath = xlsize_xpath)
	private WebElement xlSize;

	@FindBy(xpath = greencolour_xpath)
	private WebElement greenColour;

	@FindBy(xpath = addtocart_xpath)
	private WebElement addToCart;

	@FindBy(xpath = mycart_xpath)
	private WebElement mycart;

	@FindBy(xpath = proceedToCart_xpath)
	private WebElement proceedToCheckOut;

	@FindBy(xpath = proceedtocheck_xpath)
	private WebElement checkoutBtn;

	public WomenSearchPageObjectModel() {

		PageFactory.initElements(driver, this);
	}

	public void getValidWomenSearchPage() {

		actionMethods(women, "move to element");
		actionMethods(tops, "move to element");
		actionMethods(jackets, "move to element");
		clickOnElement(jackets);
		impliciteWait(30);
		clickOnElement(junoJacket);
		impliciteWait(30);
		clickOnElement(xlSize);
		clickOnElement(greenColour);
		impliciteWait(10);
		clickOnElement(addToCart);
		clickOnElement(mycart);
		impliciteWait(20);
		clickOnElement(proceedToCheckOut);

	}

}
