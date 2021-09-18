package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class DeskPage extends TestBase{

	@FindBy(how= How.CSS , using = "a[href *= 'Selling'][class = 'module-box-link']")
	public WebElement sellingModuleLink;

	public DeskPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSellingModule()
	{
		sellingModuleLink.click();
	}
}
