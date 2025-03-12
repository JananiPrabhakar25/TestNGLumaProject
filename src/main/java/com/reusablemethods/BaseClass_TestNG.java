package com.reusablemethods;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass_TestNG {
	public static WebDriver driver;
	public static Select s;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js;
	public static ExtentReports extentReports;
	public static File file;

//1.LAUNCH BROWSER
	protected static WebDriver launchBrowser(String BrowserName) {

		try {
			if (BrowserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (BrowserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (BrowserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING BROWSER LAUNCH");

		}

		driver.manage().window().maximize();
		return driver;
	}

//2.GET URL
	protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING URL LAUNCH");
		}
	}

//3.GET TITLE
	protected static String getTitle() {

		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING TITLE");
		}

		return title;
	}

//4.GET CURRENT URL
	protected static String getCurrentUrl() {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();

		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING GETTING CURRENT PAGE URL");
		}
		return currentUrl;
	}

//5.GET PAGE SOURCE
	protected static void getPageSource() {
		try {
			String pageSource = driver.getPageSource();
			System.out.println(pageSource);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING GETTING CURRENT PAGE SOURCE");
		}
	}

// 6.CLOSE
	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING CLOSING BROWSER");
		}
	}

//7.QUIT
	protected static void terminatingBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING QUITTING BROWSER");
		}
	}

// 8.GETWINDOWHANDLE
	protected static void windowHandling(int number) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(windowHandles);
			driver.switchTo().window(li.get(number));
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING WINDOWS HANDLING");
		}
	}

//WEBELEMENT METHODS
// 9.SENDKEYS
	protected static void passInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING PASSING INPUTS TO TEXTFIELDS");
		}
	}

// 11.CLICK
	protected static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE CLICKING ELEMENT");
		}
	}

// 12.CLEAR
	protected static void clearTextBox(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROE OCCURED WHILE CLEARING TEXT BOX");
		}
	}

// 13.GET TEXT
	protected static String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
			// System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING TEXT FROM ELEMENT");
		}
		return text;
	}

// 14.GET ATTRITUBE
	protected static String getAttribute(WebElement element, String value) {
		String attribute = null;
		try {
			attribute = element.getAttribute(value);

		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING ATTRIBUTE FROM ELEMENT");
		}
		return attribute;
	}

// 15.SELECT CLASS
//( VALUE, VISIBLE TEXT,INDEX)
	protected static void select(String type, String value, WebElement element) {
		try {
			s = new Select(element);

			if (type.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (type.equalsIgnoreCase("visible text")) {
				s.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			} else {
				Assert.fail("INVALID TYPE SELECTION- SELECT BY INDEX,VALUE,VISIBLE TEXT");
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR OCCURED DURING VALUE SELECT");
		}

	}

// 16.SELECT IS MULTIPLE
	protected static void isMultiple(WebElement element) {
		try {
			s = new Select(element);
			boolean multiple = s.isMultiple();
			System.out.println(multiple);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING VALUE SELECT IS MULTIPLE");
		}
	}

// 17.SELECT GET OPTIONS
	protected static void getAllOptionsSelect(WebElement element) {
		try {
			s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (WebElement alloptions : options) {
				System.out.println(alloptions.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING GETTING ALL OPTIONS FROM DROPDOWN");
		}

	}

// 18.SELECT GET ALL SELECTED
	protected static void getAllSelectedOptions(WebElement element) {
		try {
			s = new Select(element);
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			for (WebElement allselectedoptions : allSelectedOptions) {
				System.out.println(allselectedoptions.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING ALL SELECTED OPTIONS FROM DROPDOWN");
		}
	}

// 19.SELECT GET FIRST SELECTED
	protected static void getFirstSelectedOptions(WebElement element) {
		try {
			s = new Select(element);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING FIRST SELECTED OPTIONS FROM DROPDOWN");
		}
	}

// 20.DESELECT (VALUE, VISIBLE TEXT,INDEX)
	protected static void deselect(WebElement element, String type, String value) {
		try {
			s = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				s.deselectByValue(value);
			} else if (type.equalsIgnoreCase("visible text")) {
				s.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				s.deselectByIndex(Integer.parseInt(value));
			} else {
				Assert.fail("INVALID TYPE DESELECTION- DESELECT BY INDEX,VALUE,VISIBLE TEXT");
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR OCCURED DURING VALUE DESELECT");
		}
	}

// 21.DESELECT ALL
	protected static void deselectAll(WebElement element) {
		try {
			s = new Select(element);
			s.deselectAll();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE  DESELECTING ALL OPTIONS FROM DROPDOWN");
		}
	}

// 22.ACTION CLASS
// MOVE TO ELEMENT/ DOUBLE CLICK /CONTEXT CLICK
	protected static void actionMethods(WebElement element, String type) {
		try {
			a = new Actions(driver);
			if (type.equalsIgnoreCase("move to element")) {
				a.moveToElement(element).perform();
			} else if (type.equalsIgnoreCase("double click")) {
				a.doubleClick(element).perform();
			} else if (type.equalsIgnoreCase("context click")) {
				a.contextClick(element).perform();
			} else {
				Assert.fail("INVALID ACTION TYPE-USE MOVE TO ELEMENT,CONTEXT CLICK,DOUBLE CLICK");
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE PERFORMING ACTIONS ON ELEMENT");
		}
	}

// 23.DRAG AND DROP
	protected static void dragAndDrop(WebElement scr, WebElement des) {
		try {
			a = new Actions(driver);
			a.dragAndDrop(scr, des).build().perform();
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE DRAG AND DROP ACTION");
		}
	}

// 24.ROBOT CLASS
// COPY
	protected static void copyText() {
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);

			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			Assert.fail("ERROR OCCURED WHILE COPYING TEXT");
		}

	}

// 25.PASTE
	protected static void pasteText() {
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);

			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			Assert.fail("ERROR OCCURED WHILE PASTING TEXT");
		}

	}

//26.ENTER
	protected static void pressEnter() {
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			Assert.fail("ERROR OCCURED WHILE  PRESSING ENTER");
		}

	}

//27.DELETE
	protected static void delete() {
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_DELETE);

			r.keyRelease(KeyEvent.VK_DELETE);
		} catch (AWTException e) {
			Assert.fail("ERROR OCCURED WHILE DELETING");
		}

	}

//28.SELECT ALL
	protected static void selectAll() {
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);

			r.keyRelease(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			Assert.fail("ERROR OCCURED WHILE SELECTING ALL");
		}

	}

//29.JAVASCRIPT EXECUTOR
//SCROLL DOWN
	protected static void scrollDown(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE SCROLLING DOWN THE WEBPAGE");
		}
	}

//30.SCROLL UP
	protected static void scrollUp(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE SCROLLING UP THE WEBPAGE");
		}
	}

//31.REPLACEMENT FOR SENDKEYS
	protected static void passInputwithJsexecutor(WebElement element, String value_1) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttritube('value',value_1')", element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE PASSING VALUES WITH JAVASCRIPTEXECUTOR");
		}
	}

//32.REPLACEMENT FOR CLICK
	protected static void clickWithJsexecutor(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE CLICKING ELEMENT WITH JAVASCRIPTEXECUTOR");
		}
	}

//33.REPLACEMENT FOR RETRIEVING VALUES FROM TEXTBOX
	protected static void getAttributeWithJsexecutor(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("return arguments[0].setAttribute('value')", element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE RETRIEVING VALUES FROM TEXTBOX WITH JAVASCRIPTEXECUTOR");
		}
	}

//34.TAKESCREENSHOT
	protected static void takeScreenShot(String path) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(path);
			FileHandler.copy(source, destination);

		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE TAKING SCREENSHOT");
		}
	}

//35.ALERTS
//ACCEPT/DISMISS
	protected static void alertacceptDismiss(String alertType) {
		try {
			Alert a = driver.switchTo().alert();
			if (alertType.equalsIgnoreCase("simple")) {
				a.accept();
			} else if (alertType.equalsIgnoreCase("dismiss")) {
				a.dismiss();
			} else {
				Assert.fail("INVALID ALERT HANDLING- USE ONLY ACCEPT OR DISMISS");
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE  HANDLING ALERTS");
		}

	}

//36.ALERT SENDKEYS
	protected static void alertSendkeys(String value) {
		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE PASSING INPUTS TO ALERT");
		}
	}

//37.ALERT GETTEXT
	protected static void alertGetText() {
		try {
			Alert a = driver.switchTo().alert();
			String text = a.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE GETTING TEXT FROM ALERT");
		}
	}

//38.FRAMES  SWITCH BY WEBELEMENT
	protected static void switchToFramesByWebelement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE SWITCHING TO FRAME");
		}
	}

//39.FRAMES SWITCH BY ID,NAME AND INDEX
	protected static void switchToFrameByNameIdidex(String type, String value) {

		try {
			if (type.equalsIgnoreCase("id")) {
				driver.switchTo().frame(value);
			} else if (type.equalsIgnoreCase("name")) {
				driver.switchTo().frame(value);
			} else if (type.equalsIgnoreCase("id")) {
				driver.switchTo().frame(Integer.parseInt(value));
			} else {
				Assert.fail("INVALID TYPE OF FRAME SWITCHING");
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR OCCURED WHILE SWITCHING TO FRAME");
		}
	}

//40.NAVIGATION
	protected static void navigationToUrl(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE NAVIGATING TO URL");
		}
	}

//41.NAVIGATION-BACKWARD FORWARD REFRESH
	protected static void navigation(String type) {
		try {
			if (type.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (type.equalsIgnoreCase("backward")) {
				driver.navigate().back();
			} else if (type.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE NAVIGATING");
		}
	}

//42. ENABLED
	protected static void enabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE ENABLING  ELEMENT");
		}
	}

// 43.DISPLAYED
	protected static void displayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE DISPLAYING  ELEMENT");
		}
	}

// 44.SELECT
	protected static void selected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			System.out.println(selected);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED WHILE SELECTING  ELEMENT");
		}
	}

//45.WAITS
//STATIC WAITS
	protected static void staticWait(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			Assert.fail("ERROR OCCURED DURING STATIC WAIT");
		}
	}

//46.IMPLICITE WAITS
	protected static void impliciteWait(int i) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING IMPLICITE WAIT");
		}
	}

//47.EXPLICITE WAITS
	protected static void expliciteWait(WebElement element, int i, String type) {
		try {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(i));
			if (type.equalsIgnoreCase("visibility of elements")) {
				w.until(ExpectedConditions.visibilityOf(element));
			} else if (type.equalsIgnoreCase("element to be clickable")) {
				w.until(ExpectedConditions.elementToBeClickable(element));
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING EXPLICITE WAIT");
		}

	}

//48.

	public static void extentReportStart(String location) {
		try {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Exception e) {
			Assert.fail("ERROR DURING REPORT GENERATION");
		}

	}

//49.
	public static void extentReportTearDown(String location) {

		try {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
		} catch (IOException e) {
			Assert.fail("ERROR DURING REPORT GENERATION");
		}

	}

//50.TakeSCreenShot
	public static String takeScreensShot() throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrFile, desFile);

		return desFile.getAbsolutePath();

	}

//51. scroll down by pixels
	protected static void scrollDown_new(int pixels) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0," + pixels + ")", "");
		} catch (Exception e) {
			Assert.fail("ERROR WHILE SCROLLING DOWN");
		}

	}

//52.javascript click
	protected static void javaScriptClick(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Assert.fail("ERROR WHILE CLICKING ELEMENT");
		}
	}

// 53.HARD ASSERT
	protected static void validation(String actual, String expected) {

		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			Assert.fail("ERROR DURING VALIDATION");
		}

	}
}
