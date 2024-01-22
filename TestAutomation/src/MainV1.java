
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainV1 {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
    webDriverSetup();
    //loginByIDTest();
     //   loginByNameTest();
        loginByClassTest();
    webDriverTearDown();
        System.out.println("Test execution done");


    }
    public static void webDriverSetup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.saucedemo.com/");

         wait = new WebDriverWait(driver,Duration.ofMillis(30000));
    }

    public static void webDriverTearDown() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }
    public static void loginByIDTest(){
        driver.get("https://www.saucedemo.com/");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement  userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement  passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
            WebElement  loginButtonClick = driver.findElement(By.id("login-button"));
            loginButtonClick.click();

        }catch (NoSuchElementException ex){
            System.err.println("Cannot find username/Password input field or login button");
        }
    }

    public static void loginByNameTest(){
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInput = driver.findElement(By.name("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement  passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement  loginButtonClick = driver.findElement(By.name("login-button"));
        loginButtonClick.click();
    }
    public static void loginByClassTest(){
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInput = driver.findElement(By.className("input_error"));
        userNameInput.sendKeys("standard_user");

        WebElement  passwordInput = driver.findElement(By.className("input_error"));
        passwordInput.sendKeys("secret_sauce");

        WebElement  loginButtonClick = driver.findElement(By.className("submit-button"));
        loginButtonClick.click();
    }

}
