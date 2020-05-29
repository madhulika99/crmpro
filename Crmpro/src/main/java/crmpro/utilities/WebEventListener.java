package crmpro.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import crmpro.base.TestBase;



public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("before navigating to:  '" + url + "' ");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("after navigating to:  '" + url + "' ");

	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("navigating back to previous page");

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("navigated back to previous page");

	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("navigating forward to next page");

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("navigated forward to next page");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("refresh before navigationg");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("refresh after navigationg");

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("trying to click on: " + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("clicked on: " + element.toString());

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
