package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	@FindBy(linkText = "ivecluj.1@endava.com")
	private WebElement emailLabel;
	
	@FindBy (linkText = "Career Development Discussion")
	private WebElement areaLabel;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutFromMyProfile;
	
	private WebDriver driver;
	
	public MyProfilePage(WebDriver driver){
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
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
	
	public LoginPage clickLogOut(){
		logOutFromMyProfile.click();
		Sleeper.sleepTightInSeconds(3);
		return new LoginPage(driver);
		
	}

}
