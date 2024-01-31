import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsEndToEnd extends SwagLabsTestsStandardUser {
    @Test
    @Description("Standard user log in and buy a product.")
    public void standardUserHappyPath() {
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
        WebElement loginButtonClick = driver.findElement(By.name("login-button"));
        loginButtonClick.click();
//        4. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bolt T-Shirt" terméknek
        WebElement cartTshirtClick = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        cartTshirtClick.click();
//        5. Rákattintunk a Kosár gombra a jobb felső sarokban
        WebElement CartClick = driver.findElement(By.className("shopping_cart_link"));
        CartClick.click();
//        6. Rákattintunk a Checkout gombra
        WebElement CheckoutClick = driver.findElement(By.id("checkout"));
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
        WebElement continueClick = driver.findElement(By.id("continue"));
        continueClick.click();
//        11. Rákattintok a "Finish" gombra
        WebElement finishClick = driver.findElement(By.id("finish"));
        finishClick.click();
//        12. Rákattintok a "Back Home" gombra
        WebElement backtopClick = driver.findElement(By.id("back-to-products"));
        backtopClick.click();
//         Elvárt működés
//        - A felület címe "Products"
        WebElement productsTitle = driver.findElement(By.className("title"));
        Assert.assertNotNull(productsTitle);
        Assert.assertEquals(productsTitle.getText(), "Products");

//        - A cart badge nem jelenik meg a kosár ikonon (opcionális)
        // megoldás 1
        /*
        try {
            WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
            //Assert.assertFalse(shoppingCartBadge.isDisplayed());  //elvárt forgatókönyv szerint ez az utasítás nem hajtódik végre
        }catch (NoSuchElementException ex){
            Assert.assertTrue(true);  //Passed test status
        }
        */
        // megoldás 2
        //System.out.println(driver.getPageSource().contains("shopping_cart_badge"));  // true vagy false. false ha nem szerepel az oldal forrásában a "shopping_cart_badge"
        boolean isWebpageContainsBadge = driver.getPageSource().contains("shopping_cart_badge");
        Assert.assertFalse(isWebpageContainsBadge);
    }

    @Test
    @Description("Standard user log in and buy multiple products with cart modification then logout.")
    public void standardUserMultipleProductPath() {
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
        WebElement loginButtonClick = driver.findElement(By.name("login-button"));
        loginButtonClick.click();
        //        4. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bolt T-Shirt" terméknek
        WebElement cartTshirtClick = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        cartTshirtClick.click();
        //        5. Rákattintunk az "Add to cart" gombjára a "Sauce Labs BAckpack" terméknek
        WebElement backpackClick = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        backpackClick.click();
        //        6. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bike Light" terméknek
        WebElement bikelightClick = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        bikelightClick.click();
        //        7. Rákattintunk a Kosár gombra a jobb felső sarokban
        WebElement CartClick = driver.findElement(By.className("shopping_cart_link"));
        CartClick.click();
        //        8.Remove gombbal eltávolitjuk a középső terméket
        WebElement bikelightremoveClick = driver.findElement(By.name("remove-sauce-labs-backpack"));
        bikelightremoveClick.click();
        //        9. Rákattintunk a Checkout gombra
        WebElement CheckoutClick = driver.findElement(By.name("checkout"));
        CheckoutClick.click();
//        10. Kitöltöm a First name mezőt "Elek" értékkel
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        firstNameInput.sendKeys("Elek");
//        11. Kitöltöm a Last name mezőt "Mekk" értékkel
        WebElement LastNameInput = driver.findElement(By.name("lastName"));
        LastNameInput.sendKeys("Mekk");
//        12. Kitöltöm a Zip/Postal code  mezőt "1111" értékkel
        WebElement postalCodeInput = driver.findElement(By.name("postalCode"));
        postalCodeInput.sendKeys("1111");
//        13. Rákattintok a "Continue" gombra
        WebElement continueClick = driver.findElement(By.name("continue"));
        continueClick.click();
//        14. Rákattintok a "Finish" gombra
        WebElement finishClick = driver.findElement(By.name("finish"));
        finishClick.click();

        //    Megjelenik a "Thank you for your order!" felirat a képernyőn (Asser használatával)
        boolean isWebpageContainsBadge = driver.getPageSource().contains("Thank you for your order!");
        Assert.assertTrue(isWebpageContainsBadge);
        // 15. Rákattintunk a menü "Logout" menüpontjára
        WebElement menuClick = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        menuClick.click();
        WebElement logoutClick = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        logoutClick.click();
        // Elvárt működés
//      Bejelentkezési képernyőre való navigálás sikeres
        boolean isWebpageContainsUsernames = driver.getPageSource().contains("Accepted usernames are:");
        Assert.assertTrue(isWebpageContainsUsernames);
    }
}
