package test.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {
	
	public static String username = "ivecluj1";
	public static String password = "IveParola2";
	
	public static String username1 = "ivecluj2";
	public static String password2 = "IveParola2";
	
	public static final String URL = "https://www.endavauniversity.com/";
	
	private static WebDriver driver;
	
 
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get(URL); //get otvara web adresu
	  
  }
  
  @Test
  public void login() {
	  
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  Sleeper.sleepTightInSeconds(5); //kada se uloguje nista nece da se desava u 5sec
	  
	  String message = driver.findElement(By.className("logininfo")).getText();//ovo radimo zbog verifikacije,ali ovde smo samo pokupili podatke
	  //da pokupi sav tekst koji nadje u njemu
	  //mora da skladistimo informaciju i pravimo promenljivu string
	  //kada je pokupimo mora da je ispisemo
	  System.out.println(message);
	  
	  //za verifikaciju,da li se u message nalazi niz karaktera(contains-ne mora cela recenica ako nisi siguran kako ti izgleda poruka...)
	  //posle : pises poruku sta se desi(koja poruka da se ispise) ako se ne ispuni zahtev
	  
	  assert message.contains("You are logged in as") : "You are not logged in. Test failed";
	  
	  System.out.println("Test passed");

	  
  }

  @AfterClass //(alwaysRun = true)da se test uvek izvrsava
  public void afterClass() {
	  
	  driver.quit();
  }

}
