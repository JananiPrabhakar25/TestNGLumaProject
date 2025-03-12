package com.pageobjectmanager;

import com.pageobjectmodel.GearSearchPageObjectModel;
import com.pageobjectmodel.LogOutPageObjectModel;
import com.pageobjectmodel.LoginPageObjectModel;
import com.pageobjectmodel.MenHoodiesCheckoutPageObjectModel;
import com.pageobjectmodel.MenHoodiesSearchPageObjectModel;
import com.pageobjectmodel.MenSearchProductPageObjectModel;
import com.pageobjectmodel.OrderCheckoutPageObjectModel;
import com.pageobjectmodel.ShippingPageObjectModel;
import com.pageobjectmodel.WomenSearchPageObjectModel;
import com.utilityfiles.FileReaderManager;

public class PageObjectManager {

	private LoginPageObjectModel loginPage;
	private WomenSearchPageObjectModel womenSearchPage;
	private ShippingPageObjectModel shippingPage;
	private FileReaderManager reader;
	private MenSearchProductPageObjectModel menSearchPage;
	private GearSearchPageObjectModel gearSearchPage;
	private MenHoodiesSearchPageObjectModel menHoodiesPage;
	private OrderCheckoutPageObjectModel gearOrderPage;
	private MenHoodiesCheckoutPageObjectModel menHoodiesCheckoutPage;
	private LogOutPageObjectModel logoutPage;

	public LoginPageObjectModel getLoginPageManager() {
		if (loginPage == null) {
			loginPage = new LoginPageObjectModel();
		}
		return loginPage;
	}

	public WomenSearchPageObjectModel getWomenSearchPageManager() {
		if (womenSearchPage == null) {
			womenSearchPage = new WomenSearchPageObjectModel();
		}
		return womenSearchPage;
	}

	public ShippingPageObjectModel getShippingPageManager() {

		if (shippingPage == null) {
			shippingPage = new ShippingPageObjectModel();
		}
		return shippingPage;

	}

	public MenSearchProductPageObjectModel getMenSearchPageManager() {
		if (menSearchPage == null) {
			menSearchPage = new MenSearchProductPageObjectModel();
		}
		return menSearchPage;
	}

	public GearSearchPageObjectModel getGearPageManager() {
		if (gearSearchPage == null) {
			gearSearchPage = new GearSearchPageObjectModel();
		}
		return gearSearchPage;

	}

	public MenHoodiesSearchPageObjectModel getMenHoodiesSearchPageManger() {
		if (menHoodiesPage == null) {
			menHoodiesPage = new MenHoodiesSearchPageObjectModel();

		}
		return menHoodiesPage;

	}

	public OrderCheckoutPageObjectModel getOrderCheckoutPageObjectManager() {
		if (gearOrderPage == null) {
			gearOrderPage = new OrderCheckoutPageObjectModel();
		}
		return gearOrderPage;

	}

	public MenHoodiesCheckoutPageObjectModel getMenHoodiesCheckoutPageManager() {
		if (menHoodiesCheckoutPage == null) {
			menHoodiesCheckoutPage = new MenHoodiesCheckoutPageObjectModel();
		}
		return menHoodiesCheckoutPage;
	}

	public LogOutPageObjectModel getLogoutPageManager() {
		if (logoutPage == null) {
			logoutPage = new LogOutPageObjectModel();
		}
		return logoutPage;
	}

	public FileReaderManager getFilereader() {
		if (reader == null) {
			reader = new FileReaderManager();
		}
		return reader;
	}
}
