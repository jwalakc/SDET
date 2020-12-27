package SeleniumProject_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {

WebDriver driver;
    
    @BeforeTest
    public void beforeTest() {
    	Reporter.log("Starting Activtiy4", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   
    
    @BeforeClass
    public void beforeClass() {
    	  // Click on All Courses
    	driver.findElement(By.linkText("All Courses")).click();
    	
    	//Assertion for title of the "All Courses" page
        Assert.assertEquals(driver.getTitle(), "All Courses – Alchemy LMS");
    }
    
    @Test
    public void Course2Test() { 
        //Get title of the second course    	
    	WebElement course2 = driver.findElement(By.xpath("//div/h3[contains(text(), 'Email')]"));
    	
    	//Assertion for title of the second course
        Assert.assertEquals(course2.getText(), "Email Marketing Strategies");
        
        Reporter.log("The title of the second course is: " + course2.getText(), true);
    }

    @AfterTest
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 4 is completed", true);
    }
}
