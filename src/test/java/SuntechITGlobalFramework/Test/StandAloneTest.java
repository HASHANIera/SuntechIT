package SuntechITGlobalFramework.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import SuntechITGlabaFramework.TestComponents.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SuntechITGlobalFramework.pageobjects.SelectCountries;
import SuntechITGlobalFramework.pageobjects.SelectTechnologies;

public class StandAloneTest extends BaseTest {

    // List of technologies to select
    List<String> technologyNames = Arrays.asList("React", "Node", "Python");

    @Test
    public void hiredevelopers() {
        int retries = 3;
        while (retries > 0) {
            try {
                // Initialize SelectTechnologies object
                SelectTechnologies selectTechnologies = landingpage.EmailEntering("hashaniw@suntechit.com.au");

                // Select the technology and click continue
                SelectCountries selectCountries = selectTechnologies.selectTechnologies(technologyNames);

               

                break; // Exit loop if successful
            } catch (Exception e) {
                e.printStackTrace();
                retries--;
                if (retries == 0) {
                    throw e; // Throw the exception if out of retries
                }
            }
        }
    }
}
