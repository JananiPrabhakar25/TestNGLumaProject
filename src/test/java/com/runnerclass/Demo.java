package com.runnerclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;
import com.reusablemethods.BaseClass_TestNG;

@Listeners(ITestListenerClass.class)
public class Demo extends BaseClass_TestNG {
	PageObjectManager po = new PageObjectManager();

	@BeforeTest
	private void bef() {
		launchBrowser(po.getFilereader().getDataProperty("browser"));
		launchUrl(po.getFilereader().getDataProperty("url"));

	}

	@Test
	private void tc1() {
		ExtentReport_Test.extenttest = extentReports
				.createTest(
						"Login Test " + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Login Test");

		Assert.assertTrue(po.getLoginPageManager().getValidLogin(ExtentReport_Test.extenttest));
		// po.getMenSearchPageManager().getValidMenSearchPage();
		// po.getShippingPageManager().getvalidshippingdetails();

	}

	@BeforeSuite
	private void extentStart() {
		extentReportStart("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports");
	}

	@AfterSuite
	private void extentEnd() throws IOException {
		extentReportTearDown("C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\Reports\\index.html");
	}

}
