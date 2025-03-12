package com.interfaceelements;

public interface WomenSearchPageInterfaceElements {

	String women_xpath = "//span[text()='Women']";
	String tops_xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[2]";
	String jackets_xpath = "(//span[text()='Jackets'])[1]";
	String junojack_xpath = "//a[contains(text(),' Juno Jacket      ')]";
	String xlsize_xpath = "//div[@aria-label='XL']";
	String greencolour_xpath = "//div[@option-label='Green']";
	String addtocart_xpath = "//button[@title='Add to Cart']";
	String shoppingcart_xpath = "//a[@class='action showcart']";
	String proceedtocheck_xpath = "//button[@class='action primary checkout']";
	String nextbutton_xpath = "button[class='button action continue primary']";
	String mycart_xpath = "//div[@data-block='minicart']";
	String proceedToCart_xpath = "//button[@id='top-cart-btn-checkout']";
}