package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.ShippingAddressPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;
import com.utilityfiles.ExcelUtility;
import com.utilityfiles.FileReaderManager;

public class ShippingPageObjectModel extends BaseClass_TestNG implements ShippingAddressPageInterfaceElements {

	@FindBy(xpath = nextbutton_xpath)
	private WebElement nextButton;
	@FindBy(xpath = shippingaddres_xpath)
	private WebElement shippingAddress;

	@FindBy(xpath = lumalogo_xpath)
	private WebElement lumaLogo;
	
	@FindBy(xpath = addnewaddress_xpath)
	private WebElement addNewAddress;
	
	@FindBy(xpath = company_xpath)
	private WebElement company;
	
	@FindBy(xpath =streetline1_xpath )
	private WebElement streetLine1;
	
	@FindBy(xpath = streetline2_xpath)
	private WebElement streetLine2;
	
	@FindBy(xpath = streetline3_xpath )
	private WebElement streetLine3;
	
	@FindBy(xpath = cityname_xpath )
	private WebElement city;
	
	@FindBy(xpath = country_xpath)
	private WebElement country;
	
	@FindBy(xpath = state_xpath)
	private WebElement state;
	
	@FindBy(xpath = zipcode_xpath)
	private WebElement zipcode;
	
	@FindBy(xpath = phone_xpath )
	private WebElement phone;
	
	@FindBy(xpath = checkbox_xpath)
	private WebElement checkBox;
	
	@FindBy(xpath = shiphere_xpath)
	private WebElement shiphereButton;
	
	@FindBy(xpath = ordersummart_xpath)
	private WebElement ordersummary;
	
	@FindBy(xpath = next_xpath)
	private WebElement nextBtn;
	

	public ShippingPageObjectModel() {
		PageFactory.initElements(driver, this);
	}

	public void getvalidshippingdetails() {
		
		FileReaderManager reader= new FileReaderManager();

		scrollDown_new(1000);
		javaScriptClick(addNewAddress);
		impliciteWait(20);
		
		passInput(company,ExcelUtility.getCellValue("Data", "ID", "Company"));
		passInput(streetLine1,ExcelUtility.getCellValue("Data", "ID", "Streetline1"));
		passInput(streetLine2,ExcelUtility.getCellValue("Data", "ID", "Streetline2"));
		passInput(streetLine3,ExcelUtility.getCellValue("Data", "ID", "Streetline3"));
		passInput(city, ExcelUtility.getCellValue("Data", "ID", "City"));
		passInput(zipcode,ExcelUtility.getCellValue("Data", "ID", "ZipCode"));
		select("visible text", ExcelUtility.getCellValue("Data", "ID", "Country"), country);
		select("visible text", ExcelUtility.getCellValue("Data", "ID", "State"), state);
		passInput(phone, ExcelUtility.getCellValue("Data", "ID", "Phone number"));
		clickOnElement(checkBox);
		clickOnElement(shiphereButton);
		scrollDown(ordersummary);
		javaScriptClick(nextBtn);
		

	}
}