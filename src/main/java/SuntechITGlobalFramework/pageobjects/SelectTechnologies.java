package SuntechITGlobalFramework.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SuntechITGlobalFramework.AbstractComponents.AbstractComponents;

public class SelectTechnologies extends AbstractComponents {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='navBtn']//button[@id='button']")
    private WebElement continueButton;

    public SelectTechnologies(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    private By getTechnologyLocator(String technologyName) {
        return By.xpath("//p[@class='customCardText' and text()='" + technologyName + "']");
    }
    
    public void selectTechnology(String technologyName) {
        By technologyLocator = getTechnologyLocator(technologyName);
        WebElement technologyElement = waitForElementToAppear(technologyLocator);
        if (technologyElement != null && technologyElement.isDisplayed()) {
            technologyElement.click();
        } else {
            throw new RuntimeException("Technology not found or not visible: " + technologyName);
        }
    }
    
    public SelectCountries selectTechnologies(List<String> technologyNames) {
        for (String technologyName : technologyNames) {
            try {
                selectTechnology(technologyName);
            } catch (Exception e) {
                System.err.println("Failed to select technology: " + technologyName);
                e.printStackTrace();
            }
        }

        WebElement continueButtonElement = waitForElementToAppear(By.xpath("//div[@id='navBtn']//button[@id='button']"));
        if (continueButtonElement != null && continueButtonElement.isDisplayed()) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", continueButtonElement);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButtonElement);
                System.out.println("Continue button clicked successfully.");

                // Wait for a specific element on the new page to be visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='badgeLarge1']/span")));

                System.out.println("Redirection to SelectCountries page confirmed.");
                return new SelectCountries(driver);
            } catch (Exception e) {
                System.err.println("Failed to click the continue button or redirection issue.");
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Continue button not found or not visible.");
        }

        return null;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
