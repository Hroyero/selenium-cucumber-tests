package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;
    CartPage cartPage;

    @Given("the user is logged in with valid credentials")
    public void loginWithValidCredentials() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
    }

    @And("the user goes to the cart")
    public void goesToTheCart() {
        cartPage = new CartPage(driver);
        cartPage.goToCart();
    }

    @And("removes the product {string}")
    public void removesProduct(String productName) {
        cartPage = new CartPage(driver);
        cartPage.removeProductFromCart(productName);
    }

    @Then("the cart should be empty")
    public void cartShouldBeEmpty() {
        assertTrue(cartPage.isCartEmpty());
    }
}
