package com.listeners;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.reusablemethods.BaseClass_TestNG;


public class ExtentReport_Test  {

	public static ExtentTest extenttest;

	@BeforeSuite
	public void extentTestReportStartup()throws IOException {
		BaseClass_TestNG base = new BaseClass_TestNG() {
		};
		base.extentReportStart(null);
	}

	@AfterSuite
	public void extentReportEnd() throws IOException {
		BaseClass_TestNG base = new BaseClass_TestNG() {
		};
		base.extentReportTearDown(null);
	}

}
