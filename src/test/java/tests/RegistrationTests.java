package tests;

import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
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
        User user = User.builder()
                        .email("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "@mail.com")
                        .password("Act123456$")
                        .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeTestWithoutSpecialSymbolInPassword()
    {
        User user = User.builder()
                        .email("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "@mail.com")
                        .password("Act123456")
                        .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeWrongEmail()
    {
        User user = User.builder()
                        .email("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "mail.com")
                        .password("Act123456")
                        .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }


    @Test
    public void registrationNegativeWrongPassword()
    {
        User user = User.builder()
                        .email("testlg" + (int)(System.currentTimeMillis()/1000)%3600 + "@mail.com")
                        .password("Act123456")
                        .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

}