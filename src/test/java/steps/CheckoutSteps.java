package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.DriverFactory;

import static org.junit.Assert.*;

public class CheckoutSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

/*
    @Given("the user is logged in with valid credentials")
    public void loginWithValidCredentials() {
        driver.get("https://www.saucedemo.com/");
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
    }*/

    @When("the user adds the product {string} to the cart")
    public void addProductToCart(String productName) {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.addProductToCart(productName);
    }

    @And("proceeds to checkout")
    public void proceedsToCheckout() {
        checkoutPage.goToCart();
        checkoutPage.proceedToCheckout();
    }

    @And("fills in personal information with {string}, {string}, {string}")
    public void fillCheckoutInformation(String firstName, String lastName, String zip) {
        checkoutPage.fillCheckoutInfo(firstName, lastName, zip);
    }

    @And("completes the purchase")
    public void completePurchase() {
        checkoutPage.finishPurchase();
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String product1, String product2) {
        checkoutPage.goToCart();
        assertTrue(checkoutPage.isProductInCart(product1));
        assertTrue(checkoutPage.isProductInCart(product2));
    }

    @Then("the cart badge should show {string}")
    public void theCartBadgeShouldShow(String expectedCount) {
        String actualCount = checkoutPage.getCartBadgeCount();
        assertEquals(expectedCount, actualCount);
    }


    @Then("the user should see a confirmation message {string}")
    public void verifyConfirmation(String expectedMessage) {
        String actual = checkoutPage.getConfirmationMessage();
        assertEquals(expectedMessage, actual);
    }

    @Then("the checkout error message should be {string}")
    public void errorMessage(String expectedMessage) {
        String actual = checkoutPage.errorMessage();
        assertEquals(expectedMessage, actual);
    }

}
