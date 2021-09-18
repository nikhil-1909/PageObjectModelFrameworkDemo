package pageObjects;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class ItemPage extends TestBase{
	
	public ItemPage() {
		PageFactory.initElements(driver, this);
	}

}
