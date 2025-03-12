package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.interfaceelements.LoginPageInterfaceElements;
import com.reusablemethods.BaseClass_TestNG;
import com.utilityfiles.FileReaderManager;

public class LoginPageObjectModel extends BaseClass_TestNG implements LoginPageInterfaceElements {

	@FindBy(xpath = cookieBtn_xpath)
	private WebElement cookie_btn;

	@FindBy(xpath = heading1_xpath)
	private WebElement heading;

	@FindBy(xpath = homeSigninBtn_xpath)
	private WebElement homeSignIn;

	@FindBy(id = email_id)
	private WebElement email;

	@FindBy(xpath = password_xpath)
	private WebElement password;

	@FindBy(xpath = loginBtn_xpath)
	private WebElement loginBtn;

	@FindBy(xpath = greetings_xpath)
	private WebElement greeting;

//constructor
	public LoginPageObjectModel() {
		PageFactory.initElements(driver, this);
	}
 public void getCookiesBtn() {

}
//action methods
	public boolean getValidLogin(ExtentTest extenttest) {

		try {
			FileReaderManager reader = new FileReaderManager();
			impliciteWait(20);
			clickOnElement(cookie_btn);

			clickOnElement(homeSignIn);
			scrollDown(heading);
			passInput(email, reader.getDataProperty("email"));

			passInput(password, reader.getDataProperty("password"));
			clickOnElement(loginBtn);
			impliciteWait(30);

			validation(greeting.getText(), reader.getDataProperty("title"));
			System.out.println("Actual: " + greeting.getText() + " and Expected: " + reader.getDataProperty("title"));
			extenttest.log(Status.PASS, "Login Successful");
		} catch (AssertionError e) {
			extenttest.log(Status.FAIL, "Login Failed" + e.getMessage());
			return false;
		}
		return true;

	}

}
