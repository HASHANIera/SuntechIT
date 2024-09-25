package SuntechITGlobalFramework.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicOrder {
    public static void main(String[] args) {
        // Set up WebDriver and initialize ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://suntechitglobalhiring.azurewebsites.net/select-skills/684");

        // Select technology
        WebElement techElement = driver.findElement(By.xpath("//p[@class='customCardText' and text()='React']"));
        techElement.click();

        // Wait until the button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='navBtn']//button[@id='button']"))
        );
        button = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navBtn']//button[@id='button']"))
        );

        // Scroll the button into view and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        // Optionally, you can add a wait here to see the result before closing the browser
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        
    }
}
