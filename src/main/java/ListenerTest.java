import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    final static Logger logger = Logger.getLogger(ListenerTest.class);

    public void onTestStart(ITestResult iTestResult) {
        String browserName = iTestResult.getTestContext().getCurrentXmlTest().getParameter("browserName");

        WebDriver driver = RemoteWebDriverFactory.createInstance(browserName);
        RemoteDriverManager.setWebDriver(driver);
    }

    public void onTestSuccess(ITestResult iTestResult) {

        String testNGUsersParameter = iTestResult.getTestContext().getCurrentXmlTest().getParameter("myParam");
        String testCaseName = iTestResult.getName();

        // TODO плохой вариант вывода отладочной инфрмации

        System.out.println(testNGUsersParameter);
        System.out.println("The name of the testcase passed is :" + testCaseName);


        // TODO кореектный вариант вывода отладочной инфрмации

        logger.info("The name of the testcase passed is :" + testCaseName);

        //logs a debug message
        if (logger.isDebugEnabled()) {
            logger.debug("This is debug");
        }

        //logs an error message with parameter
        logger.error("This is error : " + testNGUsersParameter);

        // logs an exception thrown from somewhere
        // logger.error("This is error", exception);

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failed is :" + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("The name of the testcase Skipped is :" + iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println(iTestContext.getName() + " test case started");
    }

    public void onFinish(ITestContext iTestContext) {
        RemoteDriverManager.closeDriver();
    }
}
