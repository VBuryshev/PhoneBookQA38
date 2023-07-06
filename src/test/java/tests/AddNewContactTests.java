package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase
{
    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod
    public void precondition()
    {
        if(!app.getUser().isLogged())
        {
            String email = "vasyap@mail.com", password = "Act123456$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email,password);
            app.getUser().submitLogin();
        }
    }

    @Test(invocationCount = 1)
    public void addNewContactPositive()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Petya_" + i)
                .lastName("Ivanov")
                .phone("25465914" + i)
                .email("petya" +i+"@mail.com")
                .address("Washington")
                .description("Ponyatija ne imeju kto eto")
                .build();

        logger.info("Phone number is " + contact.getPhone());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        app.getHelperContact().pause(3000);
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
        app.getHelperContact().pause(3000);
        app.getHelperContact().deleteRandomContact();
    }

}
