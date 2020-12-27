package SeleniumProject_LMS;

import java.util.List;
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

public class Activity7 {

WebDriver driver;
    
    @BeforeTest
    public void beforeTest() {
    	Reporter.log("Starting Activtiy7", true);
    	
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
    public void CourseCountTest() { 
    	// Find the list of courses
    	List <WebElement> courses = driver.findElements(By.xpath("//div[contains(@class, 'ld-course-list-items')]/div"));
    	
    	// Print the number of courses
    	Reporter.log("The number of courses are: " + courses.size(), true);
    }
      
    @AfterTest
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 7 is completed", true);
    }
}
