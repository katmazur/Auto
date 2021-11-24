package herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureAreaPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {
    LoginPage loginPage;
    private ChromeDriver driver;

    @BeforeEach
    public void initPageObjects() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void positiveLoginTest() {
        //open Login Page
        loginPage.goToLoginPage();
        loginPage.fillInCreadentials("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clicOnLoginButton();
        assertTrue(secureAreaPage.verifyLogin());


    }

    @Test
    public void negativeLoginTest() {
        //open Login Page
        loginPage.goToLoginPage();
        loginPage.fillInCreadentials("tmsith", "SuperSecretPassword!");
        loginPage.clicOnLoginButton();
        assertTrue(loginPage.verifyError());
    }
}
