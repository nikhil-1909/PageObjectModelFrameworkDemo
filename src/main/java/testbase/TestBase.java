package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.TestUtilities;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports report;
	public static final String PATH_TO_EXTENT_REPORTS="target/generated-sources/ExtentReportResults.html";
	public static final String URL="url";

	
	public TestBase(){
		prop=new Properties();
		try {
		FileInputStream fi = new FileInputStream("src/main/resources/properties/config.properties");
		prop.load(fi);
		}catch(FileNotFoundException f)
		{
			f.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@BeforeSuite
	public void initialization(){
		report = new ExtentReports(PATH_TO_EXTENT_REPORTS);
		initializeWebDriver();
		String testURL= prop.getProperty(URL);
		driver.get(testURL);
	}

	public void initializeWebDriver()
	{
		String testBrowser=prop.getProperty("browser");
		if(testBrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}

		if(testBrowser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@AfterSuite
	public void endTest()
	{
		/*driver.close();
		driver.quit();*/
		report.endTest(test);
		report.flush();
	}



}
