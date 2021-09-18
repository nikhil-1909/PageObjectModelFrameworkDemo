import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DeskPage;
import pageObjects.LoginPage;
import pageObjects.User_Profile;

public class FirstTestClass {

    User_Profile user_profile;
    DeskPage deskPage;
    LoginPage loginPage;
    @BeforeClass
    public void setUp()
    {
        user_profile= new User_Profile();
        deskPage=new DeskPage();

    }

    @Test
    public void myFirstTestUsingPOM()
    {

        user_profile.changeUserButton.click();
        deskPage.clickOnSellingModule();

        loginPage.login("email","password");
    }

}
