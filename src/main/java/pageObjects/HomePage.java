package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class HomePage extends TestBase{

	// webelement loginLink= driver.findelement(By.linktext("Login"))
	
			 
	@FindBy(how=How.LINK_TEXT, using= "Login")
	public WebElement loginLink;
	
	@FindBy(how=How.XPATH, using= "//li[@class = 'nav-item']//*[contains(text(),'Contact')]")
	public WebElement contactLink;
	
	@FindBy(how=How.LINK_TEXT, using= "Products")
	 WebElement productLink;
	
	@FindBy(how= How.XPATH , using = "//div[contains(@class , 'footer-bottom-line')]//div[contains(text(),'� Techlift Test')]")
	 WebElement copyrightTxt;
	
	public HomePage(){

		PageFactory.initElements(driver, this);
	}

	public void clickOnLogin() {
		loginLink.click();
	}
	
	public void clickOnContact()
	{
		contactLink.click();
		
	}
	
	public String getPageTitle()
	{
		String Pagetitle = driver.getTitle();
		return Pagetitle;
	}

	public boolean validateFooterCopyright()
	{
		boolean copyRightDisplayed= copyrightTxt.isDisplayed();
		return copyRightDisplayed;
	}
	
}
