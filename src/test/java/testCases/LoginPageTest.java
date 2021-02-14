package testCases;

import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPageObj;
	
@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	 }

@Test(priority=1)
    public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException {
	loginPageObj.enterUserName("demo@techfios.com");
	loginPageObj.enterPassword("abc123");
	loginPageObj.clickSignInButton();
	Thread.sleep(3000);
}
	@Test(priority=2)
	 public void loginpageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException {  
		loginPageObj.enterUserName("demo@techfios.com");  
	  Thread.sleep(2000);  
	  loginPageObj.enterPassword("abc123");
	  Thread.sleep(2000);  
	  loginPageObj.clickSignInButton();  
	  String expectedTitle="Dashboard- iBilling";
	  String actualTitle=loginPageObj.getPageTitle();
	  Assert.assertEquals(expectedTitle, actualTitle); 
	 }


@AfterMethod
public void tearDown() {  
 driver.close();
 driver.quit();
}



}
