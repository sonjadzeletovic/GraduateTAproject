package test.cdd;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;
import lib.util.Prepare;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {

	private WebDriver driver;
	boolean b = false;
	LoginPage loginPage; // mozemo da koristimo svuda
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	boolean isChecked = false;
	//String expectedLoginMessage = "You are logged in as";
	String message;

	@BeforeClass
	public void beforeClass() {

		driver = Prepare.chromeDriver();
		loginPage = new LoginPage(driver);

	}

	@Test
	public void checkBox() {
 
		try {
			System.out.println("Step: Login");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
																						
			homePage = loginPage.clickOnLoginButton();
			System.out.println("Step: Verify successful login.");
			message = homePage.getTextFromLoginInfoLabel();
			assert message.contains("You are logged in as") : "You are not logged in. Test failed";
			
			System.out.println("Step: Search app for 'career'.");
			homePage.typeSearchValueIntoSearchField(Property.textCareer);
			searchResult = homePage.clickOnGoButton();
			
			System.out.println("Step: Click on cdd link.");
			cddPage = searchResult.clickOncddLink();
			
			System.out.println("Step: check first checkbox.");
			cddPage.checkInFirstChexBox();
			isChecked = true; //fleg(zastavica) da li je menjano stanje ili nije
			
			System.out.println("Step: Log out.");
			loginPage = cddPage.clickOnLogOutLink();
			
			System.out.println("Step: Login.");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();
			System.out.println("Step: Verify successful login.");
			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);
			assert message.contains("You are logged in as") : "You are not logged in. Test failed";
			
			System.out.println("Step: Search app for 'career'.");
			homePage.typeSearchValueIntoSearchField(Property.textCareer);
			searchResult = homePage.clickOnGoButton();
			
			System.out.println("Step: Click on cdd link.");
			cddPage = searchResult.clickOncddLink();
			
			System.out.println("Step: Verify checkbox is checked.");
			assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
			
			System.out.println("Step: Log out.");
			loginPage = cddPage.clickOnLogOutLink();
			b=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		System.out.println("AfterClass: Kill the driver");
		//ubijemo konekciju sa brauzerom,da budemo na nuli
		driver.quit(); 
		
		if (isChecked){
			try{
				
			System.out.println("AfterClass: Revert to default.");
			driver = Prepare.chromeDriver(); //ako je nas check box chekiran pravimo novi driver,logujemo se...
			loginPage = new LoginPage(driver);
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();

			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);
			assert message.contains("You are logged in as") : "You are not logged in. Test failed";
			

			homePage.typeSearchValueIntoSearchField(Property.textCareer);
			searchResult = homePage.clickOnGoButton();

			cddPage = searchResult.clickOncddLink();
			
			assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
			cddPage.uncheckInFirstChexBox();//chekiraj ga jos jednom da ga odcekiras,unchekirao ga
			loginPage = cddPage.clickOnLogOutLink();
			driver.quit();//ubijamo jos jednom ako je chekiran,zato sto smo ga gore otvorili,da ne bi ostalo nesto nepromenjeno,nevraceno na default stanje
		} catch(Exception e) {
			throw e;
		}
		
		
	} 
		if (b){
			
			System.out.println("test passed");
		} else {
			
			System.out.println("Test failed");
		}

	}}
