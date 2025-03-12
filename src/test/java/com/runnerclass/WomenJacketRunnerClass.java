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
public class WomenJacketRunnerClass extends BaseClass_TestNG {

	PageObjectManager pageObject = new PageObjectManager();

	@BeforeTest
	private void browserlaunch() {
		launchBrowser(pageObject.getFilereader().getDataProperty("browser"));
		launchUrl(pageObject.getFilereader().getDataProperty("url"));
	}

	@Test(priority = 1)
	private void loginPage() {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Search Test" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid SearchProduct Test");
		Assert.assertTrue(pageObject.getLoginPageManager().getValidLogin(ExtentReport_Test.extenttest));

	}

	@Test(priority = 2)
	private void searchProductPage() {
		pageObject.getWomenSearchPageManager().getValidWomenSearchPage();

	}

	@Test(priority = 3)
	private void shippingPage() {
		pageObject.getShippingPageManager().getvalidshippingdetails();

	}

	@Test(priority = 4)
	private void checkoutPage() {
		Assert.assertTrue(pageObject.getOrderCheckoutPageObjectManager().getValidCheckOutOrderPage(ExtentReport_Test.extenttest));
		staticWait(2000);
	}

	@AfterTest
	private void terminateBrowser() {
		pageObject.getLogoutPageManager().getValidLogoutPage();
		terminatingBrowser();
	}

	@BeforeSuite
	private void extentStart() {
		extentReportStart("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports");

	}

	@AfterSuite
	private void extentEnd() {
		extentReportTearDown("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports\\index.html");

	}

}
