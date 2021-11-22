package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SecureAreaPage extends Page {

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public void assertLogin() {
            assertEquals(
                    "Secure Area",
                    driver.findElement(By.cssSelector("#content h2")).getText()
            );
        }

    }
