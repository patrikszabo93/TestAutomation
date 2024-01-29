import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwagLabsEndToEnd extends SwagLabsTestsStandardUser{
    @Test
    @Description("Standard user log in and buy a product.")
    public void standardUserHappyPath(){
        // Előfeltétel
        driver.get("https://www.saucedemo.com");  //weboldal betöltése

        // Teszt lépések

//        1. Beírjuk a standard_user a user name mezőbe
        WebElement userNameInput = driver.findElement(By.name("user-name"));
        userNameInput.sendKeys("standard_user");
//        2. Beírjuk a secret_sauce a password mezőbe
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");
//        3. Rákattintunk a Login gombra
        WebElement  loginButtonClick = driver.findElement(By.name("login-button"));
        loginButtonClick.click();
//        4. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bolt T-Shirt" terméknek
        WebElement  cartTshirtClick = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        cartTshirtClick.click();
//        5. Rákattintunk a Kosár gombra a jobb felső sarokban
        WebElement  CartClick = driver.findElement(By.className("shopping_cart_link"));
        CartClick.click();
//        6. Rákattintunk a Checkout gombra
        WebElement  CheckoutClick = driver.findElement(By.id("checkout"));
        CheckoutClick.click();
//        7. Kitöltöm a First name mezőt "Elek" értékkel
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        firstNameInput.sendKeys("Elek");
//        8. Kitöltöm a Last name mezőt "Mekk" értékkel
        WebElement LastNameInput = driver.findElement(By.name("lastName"));
        LastNameInput.sendKeys("Mekk");
//        9. Kitöltöm a Zip/Postal code  mezőt "1111" értékkel
        WebElement postalCodeInput = driver.findElement(By.name("postalCode"));
        postalCodeInput.sendKeys("1111");
//        10. Rákattintok a "Continue" gombra
        WebElement  continueClick = driver.findElement(By.id("continue"));
        continueClick.click();
//        11. Rákattintok a "Finish" gombra
        WebElement  finishClick = driver.findElement(By.id("finish"));
        finishClick.click();
//        12. Rákattintok a "Back Home" gombra
        WebElement  backtopClick = driver.findElement(By.id("back-to-products"));
        backtopClick.click();

        // Elvárt működés
        /*
        - A felület címe "Products"
        - A cart badge nem jelenik meg a kosár ikonon (opcionális)
         */
    }
}
