import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.idokep.hu/idojaras/Budapest");

    }
}
