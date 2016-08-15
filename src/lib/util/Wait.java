package lib.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, By webElement, int time) {
		
		WebElement element = null; //prosledili smo mu by,od by pravimo element,ako on ne postoji ide u try
		boolean b = false;
		while(!b){ 
		try {
			element = driver.findElement(webElement); //ako nadje element b ce da se promeni u true
			b = true;
		} catch (Exception e) {
		}
		}
		WebDriverWait wait = new WebDriverWait(driver, time); //uci ce u wait i cekace da element bude visible
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Wait until web element become clickable.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementClickable(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	/**
	 * Wait until web element shows
	 * @param driver {WebDriver}
	 * @param webElement {By}
	 * @param time {int}
	 */
	public static void waitUntilElementPresent (WebDriver driver, By by, int time){
		
		WebDriverWait wait  = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		
	}
}
