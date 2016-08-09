package test.login;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TNGAnotation {
	
	private static WebDriver driver;
	LoginPage loginPage; //mozemo da koristimo svuda
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	
  @BeforeClass
	  public void beforeClass() {
	  System.out.println("Usao u Before Class");
	  driver = new FirefoxDriver();
	  loginPage = new LoginPage(driver);
	  }
  
  @BeforeMethod
	  public void clearFields() {
	  System.out.println("Usao u Before methods");
	  	loginPage.clearUsernameAndPasswordFields();
	  
	  }
  
  @Test
  public void wrongUsername() {
	  
	  System.out.println("Test: Neuspesno logovanje invalid user");
	  loginPage.typeUsername(Property.wrongUsername);
	  loginPage.typePassword(Property.password);
	  loginPage.clickOnLoginButtonInvalidData();
	  
	  String errorMessage = loginPage.getErrorMessage();
	  
	  Sleeper.sleepTightInSeconds(5);
	  System.out.println(errorMessage);
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message); 
	  
	  assert message.contains("Invalid login, please try again") : "You are logged in.";
	  
	  System.out.println("Test passed");
	  
  }
  
  @Test (dependsOnMethods = "wrongUsername") // groups = "login" // da pripada nekoj grupi
  public void wrongPassword() {
	  
	  System.out.println("Test: Neuspesno logovanje invalid pass");
	  loginPage.typeUsername(Property.username);
	  loginPage.typePassword(Property.wrongPassword);
	  loginPage.clickOnLoginButtonInvalidData();
	  
	  String errorMessage = loginPage.getErrorMessage();
	  
	  Sleeper.sleepTightInSeconds(5);
	  System.out.println(errorMessage);
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invalid login, please try again") : "You are logged in.";
	  
	  System.out.println("Test passed");

  
  } 
 
  @Test (dependsOnMethods = "wrongPassword")
  public void login() {
	  
	  loginPage.typeUsername(Property.username).typePassword(Property.password); //preko . zbog onog this-a iz LoginPage mozes ovako da pozivas
	  homePage = loginPage.clickOnLoginButton();
	  
	  String message = homePage.getTextFromLoginInfoLabel();
	  assert message.contains("You are logged in as") : "You are not logged in. Test failed";
	  System.out.println("Test passed");

	  
  }
  

  @AfterMethod
  public void afterMethod() {
  }

 
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  System.out.println("Usao u after class");
	  driver.quit();
  }

}
