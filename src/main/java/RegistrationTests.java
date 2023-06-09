import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests
{
    WebDriver wd;

    @BeforeMethod
    public void init()
    {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}

@Test
public void registrationPositive()
{
    // open login form
    wd.findElement(By.xpath("//*[.='LOGIN']")).click();

    int i = (int)(System.currentTimeMillis()/1000)%3600;
    // fill email
    WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
    emailInput.click();
    emailInput.clear();
    emailInput.sendKeys("testlg" + i + "@mail.com");

    //fill password
    WebElement passInput = wd.findElement(By.xpath("//input[2]"));
    passInput.click();
    passInput.clear();
    passInput.sendKeys("Act123456$");

    // click on Button Login
    wd.findElement(By.xpath("//button[1]")).click();
}


@AfterMethod
public void tearDown()
{
    //wd.close();
}