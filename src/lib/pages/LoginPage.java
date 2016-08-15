package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;

public class LoginPage extends Page{
	
	@FindBy(id = "username") //vrsi mapiranje elemenata,da nadjemo element da nam non stop bude dostupan
	private WebElement usernameInputField;
	
	@FindBy (id = "password")
	private WebElement passwordInputField;
	
	@FindBy (id = "loginbtn")
	private WebElement loginButton;
	
	@FindBy(className = "error")
	private WebElement errorLabel;
	
	//private WebDriver driver;
	
	public LoginPage(WebDriver driver){ //konstuktor
		super(driver);//pozivas konstruktor nadklase
		//this.driver = driver;
		driver.manage().window().maximize();
		driver.get(Property.URL); //ne mora da kreiras novi objekat da bi pristupio njenim elementima,mozes preko klase jer je static
		//PageFactory.initElements(driver, this);//pravi se stranica,inicijalizira elemente,on ce da prodje kroz svaki findby i da kreira elemente	
		
	}
	//da omogucimo kliktanje,upisivanje vrednosti...
	//javadoc /**
/**
 * Type username into username input field
 * @param username {String}
 * @return {LoginPage}
 */
	public LoginPage typeUsername(String username){
		usernameInputField.sendKeys(username);
		return this; //this se odnosi na istancu ove klase
			
	}
	/**
	 * Type password into password input field
	 * @param password {String}
	 * @return {LoginPage}
	 */
	public LoginPage typePassword(String password){
		
		passwordInputField.sendKeys(password);
		return this;
	}
	
	/**
	 * Click on Login button
	 * @return {HomePage}
	 */
	public HomePage clickOnLoginButton (){
		loginButton.click();
		return new HomePage(driver);
		
	}
	/**
	 * Get text from error label
	 * @return{String}
	 */
	public String getErrorMessage (){
		return errorLabel.getText();
	}
	/**
	 * Click on login button when invalid data provider
	 * @return {LoginPage}
	 */
	public LoginPage clickOnLoginButtonInvalidData(){
		loginButton.click();
		return this;
		
	}
	/**
	 * Clear username and password fields
	 * @return{LoginPage}
	 */
	public LoginPage clearUsernameAndPasswordFields(){
		usernameInputField.clear();
		passwordInputField.clear();
		return this;
		
	}
}
