package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init()
//    {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
    @BeforeMethod
    public void preCondition()
    {
        if(app.getUser().isLogged())
        {
            app.getUser().logout();
        }
    }
//    @Test
//    public void loginPositiveTest()
//    {
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("vasya@mail.com");
//
//        //fill password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aa123456$");
//
//        // click on Button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        //Assert
//        //Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//
//    }
//    @Test
//    public void loginNegativeTestWrongEmail()
//
//    {
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("vasyamail.com");
//
//        //fill password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aa123456$");
//
//        // click on Button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        //Assert
//
//    }
//    //HW_06_Task_2
//    @Test
//    public void loginNegativeTestWrongPassword()
//     {
//
//         String email = "testlg@mail.com", password = "act123456";
//         openLoginForm();
//         fillLoginForm(email, password);
//         submitLogin();
//  }
@Test
    public void loginPositiveTestBase()
{
    String email = "testlg@mail.com", password = "Act123456$";
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(email, password);
    app.getUser().submitLogin();
    app.getUser().pause(3000);
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
}


    @AfterMethod
    public void tearDown()
    {
        //wd.close();
    }
}