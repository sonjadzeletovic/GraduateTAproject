package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends Page{
	
	@FindBy (css = "a[href*= 'mailto']") // zvezdica zato sto nije kopiran ceo link
	//@FindBy(linkText = "ivecluj.1@endava.com") moze i ovako //a[contains(@href,'mailto')]
	private WebElement emailLabel;
	
	@FindBy (linkText = "Career Development Discussion")
	private WebElement areaLabel;
	
	
	
	//private WebDriver driver;
	
	private By emailL = new By.ByCssSelector("a[href*= 'mailto']");
	
	public MyProfilePage(WebDriver driver){
		
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(3);
		waitForPageToBeLoaded(driver, emailL, 5);
		//PageFactory.initElements(driver, this);
	}
	
	/**
	 * Get text from email label
	 * @return {String}
	 */
	public String getEmailAdress(){
		
		return emailLabel.getText();

	}
	/**
	 * Get text from area label
	 * @return{String}
	 */
	public String getAreaLabel(){
		
		return areaLabel.getText();
	}
	
	

}
