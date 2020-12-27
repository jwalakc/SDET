package SeleniumProject_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

WebDriver driver;
    
    @BeforeClass
    public void beforeClass() {
    	Reporter.log("Starting Activtiy2", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }  
    
    @Test
    public void headingTestCase() {
        
        // Check the heading of the page
    	WebElement heading = driver.findElement(By.className("uagb-ifb-title")); 
                             
        //Assertion for page heading
        Assert.assertEquals(heading.getText(), "Learn from Industry Experts");
        
        //Print the page heading
        Reporter.log("Heading is: " + heading.getText(), true);
    }
    
    @AfterClass
    public void afterClass() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 2 is completed", true);
    }

}