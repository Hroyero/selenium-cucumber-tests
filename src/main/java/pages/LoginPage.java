package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    // Localizadores
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By productsTitle = By.className("title");
    private By errorMessage = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
        return driver.findElement(productsTitle).getText();
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
