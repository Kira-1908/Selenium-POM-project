package utils;

/*This class is made when our test case is flaky or result is flaky
we might be interested in retry the test again
 */

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        while(count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}
