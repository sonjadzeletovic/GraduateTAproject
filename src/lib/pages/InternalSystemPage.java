package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalSystemPage {
	
	@FindBy(className = "no-overflow")
	private WebElement categoryDescription;

	private WebDriver driver;

	public InternalSystemPage(WebDriver driver){
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
		
	}
	/**
	 * Get text from paragraph
	 * @return{String}
	 */
	public String getParagraphDescription(){
		return categoryDescription.getText();
		
	}
}
