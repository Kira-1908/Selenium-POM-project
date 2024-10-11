package pgEvents;


import pgObjects.HomePageElements;
import utils.elementFetch;

/* we created page-events package to give class for each webpage
 functionalities like signup, login etc. a class
 */
public class HomePageEvents {

    elementFetch ele = new elementFetch();

    public void signUpBut(){

        ele.getWebElem("XPATH", HomePageElements.login).click();
    }


}
////span[normalize-space()='Start Here']