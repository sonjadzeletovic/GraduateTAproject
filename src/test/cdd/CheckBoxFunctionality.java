package test.cdd;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {

	private static WebDriver driver;
	LoginPage loginPage; // mozemo da koristimo svuda
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	boolean isChecked = false;
	//String expectedLoginMessage = "You are logged in as";
	String message;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);

	}

	@Test
	public void checkBox() {

		loginPage.typeUsername(Property.username).typePassword(Property.password);
																					
		homePage = loginPage.clickOnLoginButton();

	    message = homePage.getTextFromLoginInfoLabel();
		assert message.contains("You are logged in as") : "You are not logged in. Test failed";
		

		homePage.typeSearchValueIntoSearchField(Property.textCareer);
		Sleeper.sleepTightInSeconds(5);
		searchResult = homePage.clickOnGoButton();
		cddPage = searchResult.clickOncddLink();
		

		cddPage.checkInFirstChexBox();
		isChecked = true; //fleg(zastavica) da li je menjano stanje ili nije
		

		loginPage = cddPage.clickOnLogOutLink();
		

		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();
		assert message.contains("You are logged in as") : "You are not logged in. Test failed";
		

		homePage.typeSearchValueIntoSearchField(Property.textCareer);
		Sleeper.sleepTightInSeconds(5);
		searchResult = homePage.clickOnGoButton();

		cddPage = searchResult.clickOncddLink();
		
		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
		
		
		loginPage = cddPage.clickOnLogOutLink();
		System.out.println("Test passed");

	}

	@AfterClass
	public void afterClass() {
		//ubijemo konekciju sa brauzerom,da budemo na nuli
		driver.quit(); 
		
		if (isChecked){
			driver = new FirefoxDriver(); //ako je nas check box chekiran pravimo novi driver,logujemo se...
			loginPage = new LoginPage(driver);
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();

			message = homePage.getTextFromLoginInfoLabel();
			assert message.contains("You are logged in as") : "You are not logged in. Test failed";
			

			homePage.typeSearchValueIntoSearchField(Property.textCareer);
			searchResult = homePage.clickOnGoButton();

			cddPage = searchResult.clickOncddLink();
			
			assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
			cddPage.uncheckInFirstChexBox();//chekiraj ga jos jednom da ga odcekiras,unchekirao ga
			loginPage = cddPage.clickOnLogOutLink();
			driver.quit();//ubijamo jos jednom ako je chekiran,zato sto smo ga gore otvorili,da ne bi ostalo nesto nepromenjeno,nevraceno na default stanje
		}
		
	}

}
