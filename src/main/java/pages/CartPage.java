package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By cartIcon = By.className("shopping_cart_link");

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void removeProductFromCart(String productName){
        By removeButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='Remove']");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public boolean isCartEmpty() {
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        return cartItems.isEmpty();
    }
}
