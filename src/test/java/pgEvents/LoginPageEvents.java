package pgEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pgObjects.LoginPageElements;
import utils.elementFetch;

// All the action of the HomePageEvent will be checked here
public class LoginPageEvents {

    elementFetch ele = new elementFetch();

    //To verify if signup page is redirected from the homepage

    public void verifySignUp() {

        /*This is basically checking whether the signUp button exists on the current loaded page
        indirectly means if the signup page is loaded successfully the signup button ought to be present.
        also we could have use getWebElement() instead of Elements() but in this case if an error occurs it won't
        simply run further the code breaks and will throw EXCEPTION. But since we used elements() it will make use of the
        .size() function and even in-case of an error it will only showcase the given message instead ofn throwing EXCEPTION.
         */

        Assert.assertTrue(ele.getWebElements("CSS", LoginPageElements.LoginButton).size() > 0, "Element not found");

    }


    public void enterEmail() {

        ele.getWebElem("XPATH", LoginPageElements.emailAddress).sendKeys("takeJ@gmail.com");
        ele.getWebElem("XPATH", LoginPageElements.password).sendKeys("asfawfa");
        ele.getWebElem("CSS", LoginPageElements.LoginButton).click();


    }


}