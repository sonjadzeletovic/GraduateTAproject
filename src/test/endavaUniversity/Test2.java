package test.endavaUniversity;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.InternalSystemPage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Test2 {

	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	MyProfilePage myProfilePage;
	String message;
	InternalSystemPage internalSystemPage;

	@BeforeClass
	public void beforeClass() {

		System.out.println("Usao u Before Class");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);

		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();
		assert message.contains("You are logged in as") : "You are not logged in. Test failed";
		System.out.println("Test passed");

	}

	@Test
	public void endavaUniversity() {
		System.out.println("Usao je u test");
		
		homePage.clickOnEndavaUniversity();
		
		internalSystemPage = homePage.clickOnLinkInternalSystemSelfHelp();
		message = internalSystemPage.getParagraphDescription();
		assert message.contains("This category contains help materials for Endava") : "Test failed";
		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
