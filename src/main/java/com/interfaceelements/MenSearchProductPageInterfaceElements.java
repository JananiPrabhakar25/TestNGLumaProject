package com.interfaceelements;

public interface MenSearchProductPageInterfaceElements {

	String men_xpath = "(//span[text()='Men'])[1]";String tops_xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[5]";
	String jackets_xpath = "(//span[text()='Jackets'])[2]";
	String montanawindjacket_xpath = "//a[contains(text(), ' Montana Wind Jacket  ')]";
	String mediumsize_xpath = "//div[@aria-label='M']";
	String redcolour_xpath = "//div[@aria-label='Red']";
	String addtocart_xpath = "(//button[@type='submit'])[2]";
	String mycart_xpath = "//div[@data-block='minicart']";
	String proceedToCart_xpath = "//button[@id='top-cart-btn-checkout']";

}
