package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("the user opens the browser")
    public void openBrowser() {
        // browser setup is already handled in @Before
    }

    @When("they navigate to the SauceDemo login page")
    public void navigateToSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @And("they should see the page title {string}")
    public void theyShouldSeeThePageTitle(String expectedTitle) {
        String actualTitle = loginPage.getTituloPagina();
        assertEquals(expectedTitle, actualTitle);
    }

    @And("they enter username {string} and password {string}")
    public void they_enter_username_and_password(String usuario, String clave) {
        loginPage.ingresarCredenciales(usuario, clave);
    }

    @Then("they should see the text {string}")
    public void theyShouldSeeTheText(String expectedText) {
        assertTrue(loginPage.obtenerTextoTitulo().contains(expectedText));
    }

    @Then("they should see the error message {string}")
    public void they_should_see_the_error_message(String expectedMessage) {
        String currentMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, currentMessage);
    }

    @Then("the username field should be visible")
    public void usernameFieldShouldBeVisible() {
        assertTrue(loginPage.isUsernameFieldVisible());
    }

    @Then("the password field should be visible")
    public void passwordFieldShouldBeVisible() {
        assertTrue(loginPage.isPasswordFieldVisible());
    }

    @Then("the login button should be visible")
    public void loginButtonShouldBeVisible() {
        assertTrue(loginPage.isLoginButtonVisible());
    }

    @Then("The user should see the result {string}")
    public void the_user_should_see_the_result(String expectedResult) {
        if (expectedResult.equals("dashboard")) {
            assertTrue(loginPage.obtenerTextoTitulo().equalsIgnoreCase("Products"));
        } else {
            assertEquals(expectedResult, loginPage.getErrorMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
                Allure.step("Captura agregada al fallo");
            }
            driver.quit();
        }
    }
}
