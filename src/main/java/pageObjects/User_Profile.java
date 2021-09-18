package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User_Profile {


    WebDriver driver;
public WebElement changeUserButton= driver.findElement(By.xpath("//button[@data-label='Change User']"));

}
