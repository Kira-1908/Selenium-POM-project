package QA.Test;


import Base.miniProj;
import pgEvents.HomePageEvents;
import pgEvents.LoginPageEvents;
import utils.elementFetch;
import org.testng.annotations.Test;

public class TestCase1 extends miniProj {

    elementFetch Ef = new elementFetch();
    HomePageEvents homePage = new HomePageEvents();
    LoginPageEvents signUpPage = new LoginPageEvents();


    @Test
    public void sampleMthod(){

        homePage.signUpBut();

        //verifying if signup page loaded or not
        signUpPage.verifySignUp();
        signUpPage.enterEmail();
    }
}
