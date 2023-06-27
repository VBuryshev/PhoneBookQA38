package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
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
    public void loginPositiveTest()
    {
        User user = User.builder()
                .email("testlg@mail.com")
                .password("Act123456$")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLogged());



   }
    @Test
    public void loginNegativeTestWrongEmail()

    {
        User user = User.builder()
                .email("testlg@mail.com")
                .password("Act123456$")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isWrongFormatMessage());

    }
    @Test
    public void loginNegativeTestWrongPassword()
     {

         User user = User.builder()
                 .email("testlg@mail.com")
                 .password("Act123456")
                 .build();
         app.getUser().openLoginForm();
         app.getUser().fillLoginForm(user);
         app.getUser().submitLogin();
         app.getUser().pause(3000);
         //Assert.assertTrue(app.getUser().isAlertPresent());
  }

}