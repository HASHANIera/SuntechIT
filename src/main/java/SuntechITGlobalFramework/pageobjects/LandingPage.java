package SuntechITGlobalFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SuntechITGlobalFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    // Constructor to initialize the driver and PageFactory elements
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "(//span[@class='elementor-button-text'])[1]")
    WebElement hireDevelopersButton;
    
    @FindBy(css = "input[id='inputEmail']")
    WebElement emailele;
    
    @FindBy(css = "button[id='button']")
    WebElement continuebuttonele;
    
    @FindBy(css = "div[id='letsFind']")
    WebElement heading1;
    
    public SelectTechnologies EmailEntering(String email) {
        // Wait for the hireDevelopersButton to be clickable and then click
        waitForElementToBeVisible(hireDevelopersButton);
        hireDevelopersButton.click();
        
        // Wait for the email input field to be visible and then enter the email
        waitForElementToBeVisible(emailele);
        emailele.sendKeys(email);
        
        // Wait for the continue button to be clickable and then click
        waitForElementToBeVisible(continuebuttonele);
        continuebuttonele.click();
        
        // Wait for the heading1 to be visible
        waitForElementToBeVisible(heading1);
        
        // Return the SelectTechnologies page object
        SelectTechnologies selecttechnologies = new SelectTechnologies(driver);
        return selecttechnologies;
    }
    
    // Method to navigate to the landing page
    public void goTo() {
        driver.get("https://suntechit.global/");
    }
}
