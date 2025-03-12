package com.interfaceelements;

public interface ShippingAddressPageInterfaceElements {

	String nextbutton_xpath = "(//button[@type='submit'])[2]";
	String shippingaddres_xpath = "(//div[@data-role='title'])[1]";
	String lumalogo_xpath = "//a[@aria-label='store logo']";
	String addnewaddress_xpath = "//span[text()='New Address']";
	String company_xpath = "//input[@name='company']";
	String streetline1_xpath = "//input[@name='street[0]']";
	String streetline2_xpath = "//input[@name='street[1]']";
	String streetline3_xpath = "//input[@name='street[2]']";
	String cityname_xpath = "//input[@name='city']";
	String country_xpath = "//select[@name='country_id']";
	String state_xpath = "//select[@name='region_id']";
	String zipcode_xpath = "//input[@name='postcode']";
	String phone_xpath = "//input[@name='telephone']";
	String checkbox_xpath = "//input[@type='checkbox']";
	String shiphere_xpath = "//span[text()='Ship here']";
	String ordersummart_xpath = "//span[@class='title']";
	String next_xpath = "(//button[@type='submit'])[2]";
	
}
