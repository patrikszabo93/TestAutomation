
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        driver.get("https://www.saucedemo.com/");


        try {
          WebElement  userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys("standard_user");
            Thread.sleep(2500);
            WebElement  passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("secret_sauce");
            Thread.sleep(2500);
            WebElement  loginButtonClick = driver.findElement(By.id("login-button"));
            loginButtonClick.click();
            Thread.sleep(2500);
        }catch (NoSuchElementException ex){
            System.err.println("Cannot find username/Password input field or login button");
        }

        driver.quit();

    }

}
