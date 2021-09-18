package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserLoginTest1 {
    static WebDriver driver=null;



    @Parameters( "browser")
    @Test()
    public void loginTest(@Optional("chrome") String browser) throws Exception {
        System.out.println("Parameter's value : " +browser);
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
            driver=new EdgeDriver();
        }
        else {
            throw new Exception("Incorrect Browser");

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(envRootDir+"\\src\\test\\resources\\html\\iframes.html");
        driver.get("https://test.techlift.in/");

        WebElement loginLink =  driver.findElement(By.xpath("//a[@class='nav-link btn-login-area']"));
        loginLink.click();// start of web element search and click

        WebElement loginButton =  driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.click();

        WebElement loginEmail =  driver.findElement(By.cssSelector("input#login_email"));
        loginEmail.sendKeys("testology.qa.learning@gmail.com");

        WebElement loginPassword =  driver.findElement(By.cssSelector("input#login_password"));
        loginPassword.sendKeys("Testology@123");
        loginButton.click();
        Thread.sleep(10000);
        driver.quit();
    }


}
