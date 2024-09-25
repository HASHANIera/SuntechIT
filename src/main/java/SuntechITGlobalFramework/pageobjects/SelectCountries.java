package SuntechITGlobalFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import SuntechITGlobalFramework.AbstractComponents.AbstractComponents;

public class SelectCountries extends AbstractComponents {
    
    WebDriver driver;

    public SelectCountries(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        // Optionally, verify the page has loaded by checking for a specific element
        // Example:
        // waitForElementToAppear(By.id("someElementIdOnSelectCountriesPage"));
    }
}
