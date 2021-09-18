package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase{

	// webelement loginLink= driver.findelement(By.linktext("Login"))

	@FindBy(how=How.ID, using= "login_email")
	public WebElement emailTxtBox;

	@FindBy(xpath = "//input[@id='login_email']")
	public WebElement emailTxtBox_;

	//public WebElement emailTxtBox__= driver.findElement(By.xpath("//input[@id='login_email']"));

	@FindBy(how=How.ID, using= "login_password")
	public WebElement passwordTxtBox;
	
	@FindBy(how=How.CSS, using= "button[type='submit']")
	public WebElement submitBtn;


	@FindBy(how=How.XPATH, using= "//xpath")
	public WebElement invalidRequestPopUp;



	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public void login(String u, String p) {
		emailTxtBox.sendKeys(u);
		passwordTxtBox.sendKeys(p);
		submitBtn.click();
	}
	
	public void loginWithValidValues()
	{
		emailTxtBox.sendKeys(prop.getProperty("user"));
		passwordTxtBox.sendKeys(prop.getProperty("password"));
		submitBtn.click();
	}
	
}
