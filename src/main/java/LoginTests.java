import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests
{
    WebDriver wd;

    @BeforeMethod
    public void init()
    {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositiveTest()
    {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        // fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("vasya@mail.com");

        //fill password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Aa123456$");

        // click on Button Login
        wd.findElement(By.xpath("//button[1]")).click();

        //Assert
        //Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

    }
    @Test
    public void loginNegative()

    {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        // fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("vasyamail.com");

        //fill password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Aa123456$");

        // click on Button Login
        wd.findElement(By.xpath("//button[1]")).click();
    }

    @AfterMethod
    public void tearDown()
    {
        //wd.close();
    }
}