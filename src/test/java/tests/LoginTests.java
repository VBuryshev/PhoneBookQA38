package tests;

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
        String email = "testlg@mail.com", password = "Act123456$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLogged());
   }
    @Test
    public void loginNegativeTestWrongEmail()

    {
        String email = "testlgmail.com", password = "Act12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        //Assert

    }
    @Test
    public void loginNegativeTestWrongPassword()
     {

         String email = "vasya@gmail.com", password = "Act12345";
         app.getUser().openLoginForm();
         app.getUser().fillLoginForm(email, password);
         app.getUser().submitLogin();
         app.getUser().pause(3000);
         //Assert
  }

}