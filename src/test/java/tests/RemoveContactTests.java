package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase
{
    @BeforeTest(alwaysRun = true)
    public void preconditions()
    {
        if(!app.getUser().isLogged())
        {
            String email = "vasyap@mail.com", password = "Act123456$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email,password);
            app.getUser().submitLogin();
        }
    }
    @Test
    public void removeOneContactPositive()
    {
        int res = app.getHelperContact().removeOneContact();
        Assert.assertEquals(-1, res);
    }

    @Test
    public void removeAllContacts()
    {
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContacts());
    }
}
