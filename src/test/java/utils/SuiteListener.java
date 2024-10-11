package utils;

import Base.miniProj;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

    /* This is used because in case we get any error, so the particular
    flow that control will come to this code and takes a ss and will execute this method */
    public void onTestFailure(ITestResult result){

        //String fileName = System.getProperty("user.dir")+ "SCREENSHOT/sparkReport.html";
        String fileName = System.getProperty("user.dir") + File.separator + "SCREENSHOT" + File.separator + "sparkReport.html";


        //Taking screenshot
        File fl = ((TakesScreenshot) miniProj.dr).getScreenshotAs(OutputType.FILE);

        //Copying the screenshot (using try-catch method is must)
        try {
            FileUtils.copyFile(fl, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }
    /*This method is basically telling TestNG to use the Retry.Class for retrying the tests*/
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        annotation.setRetryAnalyzer(Retry.class);

    }


}
