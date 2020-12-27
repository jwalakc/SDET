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

public class Activity3 {

WebDriver driver;
    
    @BeforeClass
    public void beforeClass() {
    	Reporter.log("Starting Activtiy3", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   
    
    @Test
    public void ActionableTrainingTest() {
        
        // Check the title of the first info box
        WebElement title1 = driver.findElement(By.cssSelector("h3.uagb-ifb-title"));
                             
        //Assertion for title of the first info box
        Assert.assertEquals(title1.getText(), "Actionable Training");
        
        //Print heading of the first info box
        Reporter.log("Heading is: " + title1.getText(), true);
    }
    
    @AfterClass
    public void afterClass() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 3 is completed", true);
    }


}
