package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;


public class miniProj {

    public static WebDriver dr;
    public ExtentSparkReporter spRep;
    public ExtentReports ext;
    public ExtentTest logger;

    @BeforeTest
    public void BT () {

        spRep = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator + "REPORTS" + File.separator +"sparkReport.html");
        spRep.config().setTheme(Theme.DARK);
        spRep.config().setDocumentTitle("Automation Report");
        spRep.config().setReportName("Automation Test Results");

        ext = new ExtentReports();
        ext.attachReporter(spRep);

    }

    @BeforeMethod //initializing browser and parameters
    @Parameters({"browser"})
    public void BM (String browser, Method tstMethod){

        logger = ext.createTest(tstMethod.getName());
        setupDr(browser);
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        dr.get(Constants.url);

    }


    @AfterMethod //customizing and setting up report logging
    public void AM (ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "TEST CASE FAILED", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case failed", ExtentColor.RED));
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "TEST CASE SKIPPED", ExtentColor.ORANGE));
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "TEST CASE PASSED", ExtentColor.GREEN));
        }

        dr.quit();
    }

    @AfterTest
    public void AT (){

        ext.flush();
    }

    //Setting up browser
    public void setupDr(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            dr = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            dr = new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("Edge")) {
            dr = new EdgeDriver();
        }
    }


}
