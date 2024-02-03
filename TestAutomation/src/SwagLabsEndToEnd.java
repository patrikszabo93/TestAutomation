import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwagLabsEndToEnd extends SwagLabsTestsStandardUser {
    @Test(priority = -1)
    @Description("Standard user log in and buy a product.")  //teszteset rövid mondatszerű jellemzője
    public void standardUserHappyPath() throws InterruptedException {
        // Előfeltétel
        driver.get("https://www.saucedemo.com");  //weboldal betöltése
        // Teszt lépések

//        1. Beírjuk a standard_user a user name mezőbe
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
//        2. Beírjuk a secret_sauce a password mezőbe
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
//        3. Rákattintunk a Login gombra
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//        4. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bolt T-Shirt" terméknek
        WebElement tShirtCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        tShirtCartButton.click();
//        5. Rákattintunk a Kosár gombra a jobb felső sarokban
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
//        6. Rákattintunk a Checkout gombra
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
//        7. Kitöltöm a First name mezőt "Elek" értékkel
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Elek");
//        8. Kitöltöm a Last name mezőt "Mekk" értékkel
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        // firstNameInput.clear(); // clear paranccsal ki lehet törölni az input field tartalmát
        lastNameInput.sendKeys("Mekk");
//        9. Kitöltöm a Zip/Postal code  mezőt "1111" értékkel
        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));
        zipCodeInput.sendKeys("1111");
//        10. Rákattintok a "Continue" gombra
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
//        11. Rákattintok a "Finish" gombra
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
//        12. Rákattintok a "Back Home" gombra
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();
        // Elvárt működés

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

    @Test(priority = 1)
    @Description("Standard user log in and buy multiple products with cart modification.")
    //teszteset rövid mondatszerű jellemzője
    public void standardUserMultipleProductPath() throws InterruptedException {
        // Előfeltétel
        driver.get("https://www.saucedemo.com");  //weboldal betöltése
        // Teszt lépések
// ---------------------------- A feladatmegoldáshoz By.id() locator NEM használható ----------------------
//        1. Beírjuk a standard_user a user name mezőbe
        WebElement userNameInput = driver.findElement(By.name("user-name"));
        userNameInput.sendKeys("standard_user");
//        2. Beírjuk a secret_sauce a password mezőbe
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");
//        3. Rákattintunk a Login gombra
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
//        4. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bolt T-Shirt" terméknek
        WebElement tShirtCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        tShirtCartButton.click();
//        5. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Backpack" terméknek
        WebElement backpackCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        backpackCartButton.click();
//        6. Rákattintunk az "Add to cart" gombjára a "Sauce Labs Bike Light" terméknek
        WebElement bikelightCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        bikelightCartButton.click();
//        7. Rákattintunk a Kosár gombra a jobb felső sarokban
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
//        8. Remove gombbal eltávolítjuk a középső terméke
        WebElement removeBackbackButton = driver.findElement(By.cssSelector("button[data-test='remove-sauce-labs-backpack']"));
        removeBackbackButton.click();
//        9. Rákattintunk a Checkout gombra
        WebElement checkoutButton = driver.findElement(By.name("checkout"));
        checkoutButton.click();
//        10. Kitöltöm a First name mezőt "Elek" értékkel
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[data-test='firstName']"));
        firstNameInput.sendKeys("Elek");
//        11. Kitöltöm a Last name mezőt "Mekk" értékkel
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[data-test='lastName']"));
        lastNameInput.sendKeys("Mekk");
//        12. Kitöltöm a Zip/Postal code  mezőt "1111" értékkel
        WebElement zipCodeInput = driver.findElement(By.name("postalCode"));
        zipCodeInput.sendKeys("1111");
//        13. Rákattintok a "Continue" gombra
        WebElement continueButton = driver.findElement(By.name("continue"));
        continueButton.click();
//        14. Rákattintok a "Finish" gombra
        WebElement finishButton = driver.findElement(By.name("finish"));
        finishButton.click();
//    Megjelenik a "Thank you for your order!" felirat a képernyőn (Asser használatával)
        WebElement confirmText = driver.findElement(By.className("complete-header"));
        //confirmText.getText() //Ha ez "Thank you for your order!" string, akkor PASS
        String confirmTextString = confirmText.getText();
        Assert.assertEquals(confirmTextString, "Thank you for your order!");
        // 15. Rákattintunk a menü "Logout" menüpontjára
        WebElement menu = driver.findElement(By.xpath("//*[@class='bm-burger-button']/button"));
        menu.click();
        //WebElement logoutMenu = driver.findElement(By.linkText("Logout"));
        //WebElement logoutMenu = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        //WebElement logoutMenu = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        WebElement logoutMenu = driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
        logoutMenu.click();
        // Elvárt működés
//      Bejelentkezési képernyőre való navigálás sikeres
//         1. Megoldás
//      Ha ez a keresés nem lenne itt, akkor StaleElementException-t kapunk, mert már nem aktuális a referenciánk az elemre
//        loginButton = driver.findElement(By.name("login-button"));
//        Assert.assertTrue(loginButton.isDisplayed());

//        2. Megoldás (aktuális URL-t vizsgáljuk)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @Test(priority = -2)
    public void checkUserInput() {
        String actualFirstName = "Zsenyuk";
        String actualLastName = "Tomi";
        String actualZipCode = "2151";

        // bejelentkezési képernyőn vagyok
        driver.get("https://www.saucedemo.com");
        // bejelentkezek mint standard_user
        loginWithUserAndPassword("standard_user", "secret_sauce");
        //loginWithUserAndPassword("error_user", "secret_sauce");

        // Bike Light terméket adok a kosárhoz
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement bikeLightAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLightAddButton.click();

        // megtekintem a kosaram
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        // továbbmegyek a vásárláshoz
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

        // megadom az adataimat
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys(actualFirstName);

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys(actualLastName);

        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys(actualZipCode);

        // elenőrzöm, hogy az adataimat fogadta-e a rendszer
        // input field esetében ne így kérjük el az aktuális text-et
        //Assert.assertEquals(firstName.getText(), actualFirstName);

        Assert.assertEquals(firstName.getAttribute("value"), actualFirstName);
        Assert.assertEquals(lastName.getAttribute("value"), actualLastName);
        Assert.assertEquals(zipCode.getAttribute("value"), actualZipCode);
    }


    @Test(priority = -3)
    public void testOrder() {
        // bejelentkezési képernyőn vagyok
        driver.get("https://www.saucedemo.com");

        // bejelentkezek mint standard_user
        loginWithUserAndPassword("standard_user", "secret_sauce");

        WebElement selectWebElement = driver.findElement(By.className("product_sort_container"));

        Select select = new Select(selectWebElement);

        //select.selectByIndex(1);
        //select.selectByValue("hilo");
        select.selectByVisibleText("Price (low to high)");

        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        // 1. megoldás
        // megkeressük az első és utolsó elemeket, és elkérjük a tartalmazó szövegeiket
        String lowestPriceString = items.get(0).findElement(By.className("inventory_item_price")).getText();
        String highestPriceString = items.get(5).findElement(By.className("inventory_item_price")).getText();

        // levágjuk a dollár jelet a legelejéről és parsoljuk double-lé
        Double lowestPriceDouble = Double.parseDouble(lowestPriceString.substring(1));
        Double highestPriceDouble = Double.parseDouble(highestPriceString.substring(1));


        Assert.assertTrue(highestPriceDouble > lowestPriceDouble);

        //2. megoldás
        // az előző konverziós lépések megtörténnek itt is, viszont minden egyes elemre
        // a konvertált számokat mentjük ide: pricesInActualOrder
        List<Double> pricesInActualOrder = new ArrayList<>();

        for(WebElement i :items) {
            pricesInActualOrder.add(
                    Double.parseDouble(
                            i.findElement(By.className("inventory_item_price")).getText().substring(1)
                    )
            );
        }

        // most lemásoljuk a listánkat egy másikba
        List<Double> pricesSorted = new ArrayList<>(pricesInActualOrder);

        // majd a helyén rendezzük a másolt listát. Ez egy kényelmi metódus épp erre a célra
        Collections.sort(pricesSorted);

        // összevetjük a saját rendezésü listánkat azzal, ami az oldalon volt
        Assert.assertEquals(pricesInActualOrder, pricesSorted);

    }
}
