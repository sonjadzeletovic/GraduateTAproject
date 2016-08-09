package test.account;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Test1 {
	
	private static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	MyProfilePage myProfilePage;
	String message;

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
		
		homePage.clickOnMyAccount();
		myProfilePage = homePage.clickOnMyProfile();
		
		
	}

	@Test(dependsOnMethods = "verifyArea")
	public void verifyProfileAccount() {
		
		System.out.println("Usao u test verify Profile");
		
		message = myProfilePage.getEmailAdress();
		assert message.contains(Property.email) : "You are not logged or this not your email adress";
		System.out.println("Test passed");

	}
	
	@Test
	public void verifyArea(){
		
		System.out.println("Usao u test verify Area");
		
		message = myProfilePage.getAreaLabel();
		assert message.contains(Property.area) : "Test failed";
		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {
		
		System.out.println("Usao u after class");
		
		loginPage = myProfilePage.clickLogOut();
		System.out.println("Test passed");
		driver.quit();
		
	}

}
