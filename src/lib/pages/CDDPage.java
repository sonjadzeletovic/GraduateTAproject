package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDDPage extends Page{
	
	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	//@FindBy(xpath = "//input[contains (@type,'image') and contains (@title, 'Mark as complete: CDD Animation Scripts')]")
	private WebElement checkBoxFirst;
	
	
	
	private By firstCheckBox= new By.ByXPath("//input[contains(@title, 'CDD Animation Scripts')]");
	
	//private WebDriver driver;

	public CDDPage(WebDriver driver) {
		
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(3);
		waitForPageToBeLoaded(driver, firstCheckBox, 5);
		//PageFactory.initElements(driver, this);
	}
	/**
	 	* Check in first check box
	 	* @return {CDDPage}
	 */
	public CDDPage checkInFirstChexBox (){
	
		if(!isFirstCheckBoxSelected()){
			checkBoxFirst.click();
		Sleeper.sleepTightInSeconds(2); }
		return this;
	
	}
	
	/**
 	* UnCheck in first check box
 	* @return {CDDPage}
 */
	public CDDPage uncheckInFirstChexBox (){

		if(isFirstCheckBoxSelected()){
			checkBoxFirst.click();
		Sleeper.sleepTightInSeconds(2); }
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
		} else 
			return false;
			
	}
	
	
 


}


