import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        try {
          WebElement  userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys("standard_user");
        }catch (NoSuchElementException ex){
            System.err.println("Cannot find username input field");
        }
        Thread.sleep(5000);
        try {
            WebElement  passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("secret_sauce");
        }catch (NoSuchElementException ex){
            System.err.println("Cannot find username input field");
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
