package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureAreaPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps{

    WebDriver driver;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Given("^user on the login page$")
    public void user_on_the_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_and(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
    }

    @And("^user click login button$")
    public void user_click_login_button() {
        loginPage.ClickLoginButton();
    }

    @Then("^logged in successfully$")
    public void logged_in_successfully() {
        secureAreaPage = new SecureAreaPage(driver);
        assertTrue(secureAreaPage.isSecureAreaDisplayed().contains("You logged into a secure area!"), "Login was not successful");
    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @After
    public void teatDownMethod() {
        driver.close();
        driver.quit();
    }
}
