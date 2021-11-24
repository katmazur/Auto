package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.interactions.Actions;



public class SecureAreaPage extends Page {

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }


    public boolean verifyLogin() {
        String verification = driver.findElement(By.id ("flash")).getText();
        return verification.contains("You logged into a secure area!");
        }

    }
