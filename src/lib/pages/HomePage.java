package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;
import lib.util.Wait;

public class HomePage extends Page{
	
	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;
	
	//@FindBy (xpath = "//input[contains (@type,'submit') and contains (@value, 'Go')]")
	@FindBy (css = "input[type = 'submit'][value = 'Go']")
	private WebElement Gobutton;
	
	private By goBtn = new By.ByCssSelector("input[type = 'submit'][value = 'Go']");
	
	private By searchInput = new By.ById("shortsearchbox");
	
	//@FindBy (className = "dropdown-toggle")
	@FindBy (xpath = "//a[contains(@title, 'My Account')]")
	private WebElement myAccount;
	
	@FindBy(css = "a[title = 'My Profile']")
	private WebElement myProfile;
	
	@FindBy(css = "a[title = 'Endava University']")
	private WebElement endavaUniversity;
	
	@FindBy (css = "a[title = 'Internal systems self help']")
	private WebElement internalSystemSelfHelp;
	

	//private WebDriver driver;
	

	public HomePage(WebDriver driver) {
		super(driver);//poziva se konstruktor nad klase
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(5);
		waitForPageToBeLoaded(driver, goBtn, 5);// da budem siguran da mi se stranica ucitala,da su svi elementi vidljivi,pa tek onda initelement uradi
		//PageFactory.initElements(driver, this);
		
		
	}
	
	/**
	 * Type search value into search field
	 * @param {String}
	 * @return {HomePage}
	 */
	
	public HomePage typeSearchValueIntoSearchField(String value){
		System.out.println("typeSearchValueIntoSearchField("+value+")");
		Wait.waitUntilElementPresent(driver,searchInput, 3);
		searchInputField.sendKeys(value);
		return this;
		
	}
	/**
	 * Click on go button
	 * @return{SearchResultPage}
	 */
	
	public SearchResultPage clickOnGoButton(){
		System.out.println("clickOnGoButton()");
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
