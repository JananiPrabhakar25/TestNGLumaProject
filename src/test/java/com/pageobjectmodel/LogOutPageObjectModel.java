package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.LogOutPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;

public class LogOutPageObjectModel extends BaseClass_TestNG implements LogOutPageInterfaceElements {
	
	@FindBy(xpath = accountname_xpath)
	private WebElement accoutName;
	
	@FindBy(xpath = signout_xpath )
	private WebElement signOut1;
	
	public LogOutPageObjectModel() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void getValidLogoutPage() {
		
		impliciteWait(30);
		javaScriptClick(accoutName);
		clickOnElement(signOut1);

	}

}
