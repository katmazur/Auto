package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String LOGIN_URL = BASE_URL + "/login";
    private static final By USER_NAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN = By.cssSelector(".fa");

    // open Hovers page
    public void goToLoginPage() {
        driver.get(LOGIN_URL);
    }

    // fill in credentials
    public void fillInCreadentials(String username, String password) {
        driver.findElement(USER_NAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);

    }

    public SecureAreaPage clicOnLoginButton() {
        driver.findElement(LOGIN).click();
        return new SecureAreaPage(driver);
    }

    public void assertError() {
        assertEquals(
                "Your username is invalid!",
                driver.findElement(By.cssSelector(".flash.error")).getText()
        );

    }
}

