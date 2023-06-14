package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By clickLogin = By.xpath("//button[@class=\"radius\"]");
    private By loginTitle = By.tagName("h2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.findElement(loginTitle).getText().equals("Login Page")) {
            System.out.println("The page Title is " + driver.findElement(loginTitle).getText());
            throw new IllegalStateException("This is not login Page. The current page is " + driver.getCurrentUrl());
        }
    }

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage ClickLoginButton() {
        driver.findElement(clickLogin).click();
        return new SecureAreaPage(driver);
    }
}
