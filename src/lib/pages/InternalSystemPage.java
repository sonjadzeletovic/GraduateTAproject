package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalSystemPage extends Page{
	
	@FindBy(className = "no-overflow")
	private WebElement categoryDescription;
	
	private By parographDecription = new By.ByClassName("no-overflow");

	//private WebDriver driver;

	public InternalSystemPage(WebDriver driver){
		
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(3);
		waitForPageToBeLoaded(driver, parographDecription, 5);
		//PageFactory.initElements(driver, this);
		
	}
	/**
	 * Get text from paragraph
	 * @return{String}
	 */
	public String getParagraphDescription(){
		return categoryDescription.getText();
		
	}
}
