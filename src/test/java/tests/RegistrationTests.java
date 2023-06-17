package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase
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

//    @Test
//    public void registrationPositiveTest()
//    {
//    // open login form
//    wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//    int i = (int)(System.currentTimeMillis()/1000)%3600;
//    // fill email
//    WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//    emailInput.click();
//    emailInput.clear();
//    emailInput.sendKeys("testlg" + i + "@mail.com");
//
//    //fill password
//    WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//    passInput.click();
//    passInput.clear();
//    passInput.sendKeys("Act123456$");
//
//    // click on Button Registration
//    wd.findElement(By.xpath("//button[2]")).click();
//
//      Assert
//
////        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
////        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }
    //HW_05 RegNegativeTest
//    @Test
//    public void registrationNegativeTestWithoutSpecialSymbolInPassword()
//    {
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        // fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("testlg" + i + "@mail.com");
//
//        //fill password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Act123456");
//
//        // click on Button Registration
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        //assert error message
//        //pause(5000);
//        //Assert.assertTrue(wd.findElements(By.xpath("/button")).size()>0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("/button")));
//

//    }

    @Test
    public void registrationNegativeWrongEmail()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "testlg" + i + "mail.com", password = "Act123456";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
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
    }

    @AfterMethod
    public void tearDown()
    {
        //wd.close();
    }
}