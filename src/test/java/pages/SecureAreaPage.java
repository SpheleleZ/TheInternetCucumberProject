package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By loggedSecureArea = By.id("flash");
    private By secureAreaTitle = By.tagName("h2");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.findElement(secureAreaTitle).getText().equals("Secure Area")) {
            System.out.println("The page Title is " + driver.findElement(secureAreaTitle).getText());
            throw new IllegalStateException("This is not Secure Area Page. The current page is " + driver.getCurrentUrl());
        }
    }

    public String isSecureAreaDisplayed() {
        return driver.findElement(loggedSecureArea).getText();
    }
}
