package test;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class CrossBrowserLoginTest2 {


    @Test()
    public void chromeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
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

    @Test()
    public void fireFoxTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
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

    @Test()
    public void edgeBrowserTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
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