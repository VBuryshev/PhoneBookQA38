package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase
{

    public HelperContact(WebDriver wd)
    {
        super(wd);
    }

    public void openContactForm()
    {
        wd.findElement(By.xpath("//*[.='ADD']")).click();
    }

    public void fillContactForm(Contact contact)
    {
        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"),contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contact.getDescription());
    }
    public void submitContactForm()
    {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(Contact contact)
    {
        String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        return phone.equals(contact.getPhone());
    }

    public boolean isContactExist()
    {
        return isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM']"));
    }

    public void deleteRandomContact()
    {
        click(By.xpath("//a[@class='active']"));
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[2]"));
        //assert - kak schitat` elementy do i posle udalenija (????)
    }
}
