package utils;

import Base.miniProj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*We are using this class to @override findElement method, by using
which we can identify element on the web page by xpath, css-selector, ID etc
 */
public class elementFetch {

    /*This will be our own way to fetch elements,
    by this we will not be needing to use findElement method
     */

    public WebElement getWebElem (String elType, String elValue){

        switch (elType){

            case "XPATH":
                return miniProj.dr.findElement(By.xpath(elValue));

            case "ID":
                return miniProj.dr.findElement(By.id(elValue));

            case "NAME":
                return miniProj.dr.findElement(By.name(elValue));

            case "CSS":
                return miniProj.dr.findElement(By.cssSelector(elValue));

            default:
                return null;

        }
    }

    public List<WebElement> getWebElements(String elType, String elValue){
        //List<WebElement> elements = new ArrayList<>();

        switch (elType){

            case "XPATH":
                return miniProj.dr.findElements(By.xpath(elValue));

            case "ID":
                return miniProj.dr.findElements(By.id(elValue));

            case "NAME":
                return miniProj.dr.findElements(By.name(elValue));

            case "CSS":
                return miniProj.dr.findElements(By.cssSelector(elValue));

            default:
                System.out.println("Invalid element type " + elType);
                break;

        }
        return null;
    }



}
