package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase
{
    @BeforeMethod
    public void preCondition()
    {
        if(app.getUser().isLogged())
        {
            app.getUser().logout();
        }
    }
    @Test
    public void registrationPositiveTest()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "testlg" + i + "@mail.com", password = "Act123456789$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeTestWithoutSpecialSymbolInPassword()
    {
        String email = "testlg" + (int)(System.currentTimeMillis()/1000)%3600;
        String password = "Act123456";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeWrongEmail()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "testlg" + i + "mail.com", password = "Act123456";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    //HW_06_Task1
    @Test
    public void registrationNegativeWrongPassword()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "testlg" + i + "@mail.com", password = "act123456";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

}