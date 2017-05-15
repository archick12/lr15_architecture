package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.RemoteDriverManager;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();

    }

    public void open() {
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
    }

    public void enterUsername() {
        driver.findElement(By.id("login-form-username")).sendKeys("a.a.piluck");
    }

    public void enterPassword() {
        driver.findElement(By.id("login-form-password")).sendKeys("111111");
    }

    public void clickLogin() {

        driver.findElement(By.id("login-form-submit")).submit();
    }

    public void dragAndDrop() {
        driver.get("http://soft.it-hillel.com.ua:8080/secure/RapidBoard.jspa?rapidView=13&quickFilter=121");

//        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement source = driver.findElement(By.linkText("QAAUT-200"));
        WebElement source = driver.findElement(By.xpath("//*[contains(@data-issue-key,'QAAUT-217')]"));
        WebElement target = driver.findElement(By.xpath("//*[contains(@data-column-id,'78')]"));


        Actions actions = new Actions(driver);
        actions
                .clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}