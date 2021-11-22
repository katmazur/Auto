package herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureAreaPage;

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
    public void positivLoginTest() {
        //open Login Page
        loginPage.goToLoginPage();
        loginPage.fillInCreadentials("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clicOnLoginButton();
        secureAreaPage.assertLogin();


    }

    @Test
    public void negativLoginTest() {
        //open Login Page
        loginPage.goToLoginPage();
        loginPage.fillInCreadentials("tmsith", "SuperSecretPassword!");
        loginPage.clicOnLoginButton();
        loginPage.assertError();

    }

}
