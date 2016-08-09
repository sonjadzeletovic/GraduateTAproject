package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDDPage {
	
	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	//@FindBy(xpath = "//input[contains (@type,'image') and contains (@title, 'Mark as complete: CDD Animation Scripts')]")
	private WebElement checkBoxFirst;
	
	//@FindBy(xpath = ".//*[@id='header-branding']/div/a[2]")
	@FindBy (linkText = "Log out")
	private WebElement logOutLink;
	
	private WebDriver driver;

	public CDDPage(WebDriver driver) {
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
	}
	/**
	 	* Check in first check box
	 	* @return {CDDPage}
	 */
	public CDDPage checkInFirstChexBox (){
	
		if(!isFirstCheckBoxSelected()){
			checkBoxFirst.click();}
		Sleeper.sleepTightInSeconds(2);
		return this;
	
	}
	
	/**
 	* UnCheck in first check box
 	* @return {CDDPage}
 */
	public CDDPage uncheckInFirstChexBox (){

		if(isFirstCheckBoxSelected()){
			checkBoxFirst.click();}
		Sleeper.sleepTightInSeconds(2);
		return this;

}
	/**
	 * Is first check box selected
	 * @return {boolean}
	 */
	public boolean isFirstCheckBoxSelected(){
		String atributeValue = checkBoxFirst.getAttribute("title"); //da vidi da li je cekiran check box
		if (atributeValue.contains("Mark not as complete")){
			return true;
		} else return false;
			
	}
	
	
	/**
	 * Click on LogOut link to log out
	 * @return {LoginPage}
	 */
	
	public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		Sleeper.sleepTightInSeconds(3);
		return new LoginPage(driver);
		
		
	}
 


}


