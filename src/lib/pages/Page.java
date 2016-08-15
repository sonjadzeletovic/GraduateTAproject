package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import lib.util.Wait;

public class Page {
	
	@FindBy(css = "#header-branding>div.logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutFromMyProfile;
	
	//@FindBy(xpath = ".//*[@id='header-branding']/div/a[2]")
		@FindBy (linkText = "Log out")
		private WebElement logOutLink;
	
	//private By loginInfo = new By.ByCssSelector("#header-branding>div.logininfo");
	
	protected WebDriver driver;
	
	
	public Page(WebDriver driver){
		this.driver = driver;
		//waitForPageToBeLoaded(driver, loginInfo, 5);
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
		 * Click on log out link
		 * @return{LoginPage}
		 */
		public LoginPage clickLogOut(){
			logOutFromMyProfile.click();
			Sleeper.sleepTightInSeconds(3);
			return new LoginPage(driver);
			
		}
		
		public void waitForPageToBeLoaded(WebDriver driver, By byWebElement, int time){	
			System.out.println("waitForPageToBeLoaded(driver, webElement,"+ time +")");
			//Wait.untilWebElementClickable(driver, webElement, time);
			WebElement identifierElement = null;
			long baseTime = System.currentTimeMillis() + (time * 1000);
			// Trenutak ulaska u metodu [System.currentTimeMillis() - vraca trenutno vreme u milisekundama] uvecan za time * 1000 (milisekunde)
			
			boolean b = false;
			while (!b && ((baseTime - System.currentTimeMillis()) > 0)) {
				try {			
					identifierElement = driver.findElement(byWebElement);
					b = true;
					System.out.println(b);
				} catch (Exception e) {
				}
				Wait.untilWebElementVisible(driver, identifierElement, time);
			}
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
