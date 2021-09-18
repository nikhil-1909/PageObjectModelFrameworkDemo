package test;


import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testbase.TestBase;
import utilities.TestUtilities;

import javax.swing.text.Utilities;

public class LoginTest extends TestBase {

	HomePage homePageObj;
	LoginPage loginPageObj;

	
	public LoginTest() {
		super();
		//initialization();
	}
	
	@Test(priority=3)
	public void verifysuccessfullLogin() throws InterruptedException
	{
		test = report.startTest("verifysuccessfullLogin");
		// go to home page
		homePageObj= new HomePage();
		test.log(LogStatus.INFO, "on home page");
		// go to login  page by clciking onm login link
		homePageObj.clickOnLogin();
		
		loginPageObj = new LoginPage();
		// specify userid nad password and click on submit
		loginPageObj.loginWithValidValues();
		test.log(LogStatus.INFO, "login done..");
	
		TestUtilities.waitForPageLoad();
		Thread.sleep(2000);
		// verify whther user has navigated to desk page
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		test.log(LogStatus.INFO, "verifyiong current url...");
		Assert.assertTrue(currentUrl.contains("test.techlift.in/desk"), "not navigated to dek page");
		test.log(LogStatus.PASS, "verifysuccessfullLogin completed..");
		logout();
	}
@Parameter
@Parameters
	@Test(dataProvider = "logintTestdata")
	public void testMultipleCredentialsLogin(String uname,String password) throws InterruptedException {
// Load application
		Thread.sleep(10000);
		driver.navigate().to("https://test.techlift.in/login#login");
		TestUtilities.waitForPageLoad();
		loginPageObj= new LoginPage();

		// clear email field
		loginPageObj.emailTxtBox.clear();

		// Clear password field
		loginPageObj.passwordTxtBox.clear();

// Enter username password
		loginPageObj.login(uname,password);

		logout();

	}


	//@DataProvider(name="testdata")
	@DataProvider
	public Object[][] logintTestdata()
	{
// Create object array with 2 rows and 2 column- first parameter is row and second is //column
		Object [][] techLiftdata=new Object[2][2];
// Enter data to row 0 column 0
		techLiftdata[0][0]="testology.qa.learning@gmail.com";
// Enter data to row 0 column 1
		techLiftdata[0][1]="Testology@123";
// Enter data to row 1 column 0 // incorrect email address
		techLiftdata[1][0]="testology.learning@gmail.com";
// Enter data to row 1 column 0
		techLiftdata[1][1]="Testology@123";
// return arrayobject to testscript
		return techLiftdata;


	}





	public void logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	
}
