package com.runnerclass;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;
import com.reusablemethods.BaseClass_TestNG;

@Listeners(ITestListenerClass.class)
public class MenJacketRunnerClass extends BaseClass_TestNG {

	PageObjectManager pageObjectManager = new PageObjectManager();

	@BeforeTest
	private void setUp() {
		launchBrowser(pageObjectManager.getFilereader().getDataProperty("browser"));
		launchUrl(pageObjectManager.getFilereader().getDataProperty("url"));

	}

	@AfterTest
	private void terminateBrowser() {
		pageObjectManager.getLogoutPageManager().getValidLogoutPage();
		terminatingBrowser();
	}

	@Test(priority = 1)
	private void loginPage() {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Search Test" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid SearchProduct Test");
		Assert.assertTrue(pageObjectManager.getLoginPageManager().getValidLogin(ExtentReport_Test.extenttest));
	}

	@Test(priority = 2)
	private void searchProductPage() {

		pageObjectManager.getMenSearchPageManager().getValidMenSearchPage();

	}

	@Test(priority = 3)
	private void shippingPage() {
		pageObjectManager.getShippingPageManager().getvalidshippingdetails();

	}

	@Test(priority = 4)
	private void checkoutPage() {
		Assert.assertTrue(pageObjectManager.getOrderCheckoutPageObjectManager()
				.getValidCheckOutOrderPage(ExtentReport_Test.extenttest));
		staticWait(2000);
	}

	@BeforeSuite
	private void startExtend() {
		extentReportStart("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports");
	}

	@AfterSuite
	private void extendEnd() {
		extentReportTearDown("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports\\index.html");

	}

}
