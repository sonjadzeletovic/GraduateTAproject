package lib.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prepare {

	/**
	 * Get firefox driver
	 * @return{WebDriver}
	 */
	public static WebDriver firefoxDriver (){
		return new FirefoxDriver();
		
	}
	
	public static WebDriver chromeDriver(){
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		return new ChromeDriver();
		
	}
}
