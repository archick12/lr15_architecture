import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Parameters({"myParam"})
    @Test(groups = {"functest"})
    public void testMethod1(String myParam) {
        // System.out.println("I got a parameter: " + myParam);
        Assert.assertTrue(false);
    }

    @Test(groups = {"functest"})
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }


}