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

public class Activity5 {

WebDriver driver;
    
    @BeforeClass
    public void beforeTest() {
    	Reporter.log("Starting Activtiy5", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   

    @Test
    public void MyAccountTest() { 
        //Finding the Navigation Bar  	
    	driver.findElement(By.id("site-navigation"));
    	
    	//Clicking the "My Account" menu item
    	WebElement myAccount = driver.findElement(By.linkText("My Account"));
    	myAccount.click(); 	
    	
    	//Assertion for My Account page
    	Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
    	
    	Reporter.log("The current page is: " + driver.getTitle(), true);
    }

    @AfterClass
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 5 is completed", true);
    }
}
