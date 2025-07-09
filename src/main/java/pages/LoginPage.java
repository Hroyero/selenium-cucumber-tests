package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By productsTitle = By.className("title");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public String getTituloPagina() {
        return driver.getTitle();
    }

    public void ingresarCredenciales(String usuario, String clave) {
        driver.findElement(usernameField).sendKeys(usuario);
        driver.findElement(passwordField).sendKeys(clave);
        driver.findElement(loginButton).click();
    }

    public String obtenerTextoTitulo() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    public boolean isUsernameFieldVisible() {
        return driver.findElement(By.id("user-name")).isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return driver.findElement(By.id("password")).isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(By.id("login-button")).isDisplayed();
    }

}
