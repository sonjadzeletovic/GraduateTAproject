package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Page{
	
	@FindBy (linkText = "Career Development Discussion")//linkText prosledjuje stvaran naziv linka(texta sta pise)
	private WebElement cddLink;
	
	@FindBy(css = "#region-main *[role='main'] h2")
	private WebElement searchResultsLabel;
	
	private By bySearchResultsLabel = new By.ByCssSelector("#region-main *[role='main'] h2");
	
	//private WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		
		super(driver);
		//this.driver = driver;
		//Sleeper.sleepTightInSeconds(5);
		waitForPageToBeLoaded(driver, bySearchResultsLabel, 5);
		//PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on cdd link
	 * @return {CDDPage}
	 */
	public CDDPage clickOncddLink (){
		
		cddLink.click();
		return new CDDPage(driver);
	}
	
	

}
