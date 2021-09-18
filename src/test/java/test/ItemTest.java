package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.DeskPage;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.LoginPage;
import pageObjects.SelleingPage;
import testbase.TestBase;

public class ItemTest extends TestBase{
	// Declaration of page class objects should happen at class level
	HomePage homePageObj;
	LoginPage loginPageObj;
	ItemPage itemPageObj;
	DeskPage deskPageObj;
	SelleingPage sellingPageObj;
	public ItemTest(){
		super();
		//initialization();
	}
	
	@BeforeClass
	public void setUp(){
		System.out.println("i am under before test");
		homePageObj=new HomePage();
		loginPageObj = new LoginPage();
		itemPageObj  = new ItemPage();
		deskPageObj = new DeskPage();
		sellingPageObj= new SelleingPage();
	}

	@Test(priority=4)
	public void verifyNewItemCreation()
	{
		test = report.startTest("verifyNewItemCreation");
		homePageObj.clickOnLogin();
		test.log(LogStatus.INFO, "login link click");
		
		loginPageObj.login("testology.qa.learning@gmail.com", "Testology@123");
		test.log(LogStatus.INFO, "login page");
		
		deskPageObj.clickOnSellingModule();
		test.log(LogStatus.INFO, "navigate to selling module");
		sellingPageObj.clickOnItem();
		test.log(LogStatus.INFO, "navigate to item page");
		test.log(LogStatus.PASS, "item test done");
	}
		
}
 