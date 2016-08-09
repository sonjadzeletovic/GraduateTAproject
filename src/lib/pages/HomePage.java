package lib.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;

public class HomePage {
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputFild;
	
	//@FindBy (xpath = "//input[contains (@type,'submit') and contains (@value, 'Go')]")
	@FindBy (css = "input[type = 'submit'][value = 'Go']")
	private WebElement Gobutton;
	
	//@FindBy (className = "dropdown-toggle")
	@FindBy (xpath = "//a[contains(@title, 'My Account')]")
	private WebElement myAccount;
	
	@FindBy(css = "a[title = 'My Profile']")
	private WebElement myProfile;
	
	@FindBy(css = "a[title = 'Endava University']")
	private WebElement endavaUniversity;
	
	@FindBy (css = "a[title = 'Internal systems self help']")
	private WebElement internalSystemSelfHelp;
	

	private WebDriver driver;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
		
	}
/**
 * Get text form login label
 * @return{String}
 */
	public String getTextFromLoginInfoLabel(){ //kupimo text da bi verifikovali da smo se logovali
		return loginInfoLabel.getText();
		
		
	}
	/**
	 * Type search value into search field
	 * @param {String}
	 * @return {HomePage}
	 */
	
	public HomePage typeSearchValueIntoSearchField(String value){
		searchInputFild.sendKeys(value);
		return this;
		
	}
	/**
	 * Click on go button
	 * @return{SearchResultPage}
	 */
	
	public SearchResultPage clickOnGoButton(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Gobutton);
		//Gobutton.click();
		return new SearchResultPage(driver);
	}	
	
	/**
	 * Click on dropdown menu my account 
	 * @return {HomePage}
	 */
	public HomePage clickOnMyAccount (){
		myAccount.click();
		return this;
		
	}
	/**
	 * Click on dropdown menu my profile
	 * @return {MyProfilePage}
	 */
	public MyProfilePage clickOnMyProfile(){
		myProfile.click();
		return new MyProfilePage(driver);
		
	}
	/**
	 * Click on dropdown menu endava university
	 * @return{HomePage}
	 */
	public HomePage clickOnEndavaUniversity(){
		endavaUniversity.click();
		return this;
		
	}
	
	/**
	 * Click on dropdown menu internal system self help
	 * @return{InternalSystemPage}
	 */
	public InternalSystemPage clickOnLinkInternalSystemSelfHelp(){
		
		internalSystemSelfHelp.click();
		return new InternalSystemPage(driver);
	}

}
