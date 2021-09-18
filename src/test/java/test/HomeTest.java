package test;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;

import testbase.TestBase;
import utilities.TestUtilities;

public class HomeTest extends TestBase{

	public static final String EXPECTED_TITLE="Techlift Test";
	HomePage homePageObj;// declaration of page class object
	public HomeTest() {
		super();// initialization of resources
		//initialization();
	}

	@BeforeClass(alwaysRun = true)
	void setUp()
	{
		homePageObj= new HomePage();
	}
	
	@Test(priority =1, description = "Verify Home page title is correct.")
	public void verifyHomePageTitle()
	{

		test = report.startTest("verifyHomePageTitle");

		test.log(LogStatus.INFO, "home page opened");
		
		String ActualTitle = homePageObj.getPageTitle();
		test.log(LogStatus.INFO, "checking page title ");
try {
	Assert.assertTrue(EXPECTED_TITLE.equals(ActualTitle));
}
catch (Exception e)
{
	test.log(LogStatus.ERROR, e.getMessage());
	test.log(LogStatus.FAIL,"test failed");
}
		test.log(LogStatus.PASS, "verifyHomePageTitle");
		report.endTest(test);
	}
	
	@Test(priority=2)
	public void verifyCopyRight()
	{
		test = report.startTest("verifyCopyRight");
		boolean copyrightPresentCheck= homePageObj.validateFooterCopyright();
		try {
			Assert.assertTrue(copyrightPresentCheck, "copyright not displayed");
		}
		catch (Exception e)
		{
			test.log(LogStatus.ERROR, e.getMessage());
			test.log(LogStatus.FAIL,"test failed");
		}
		test.log(LogStatus.PASS, "verifyCopyRight");
		report.endTest(test);
	}
	
	
}
