package tests;

import models.User;
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
        User user = new User()
                .withEmail("testlg" + i + "@mail.com")
                .withPassword("Act123456$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeTestWithoutSpecialSymbolInPassword()
    {
        User user = new User()
                .withEmail("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "@mail.com")
                .withPassword("Act123456");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeWrongEmail()
    {
        User user = new User()
                .withEmail("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "mail.com")
                .withPassword("Act123456$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    //HW_06_Task1
    @Test
    public void registrationNegativeWrongPassword()
    {
        User user = new User()
                .withEmail("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "@mail.com")
                .withPassword("act123456$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

}