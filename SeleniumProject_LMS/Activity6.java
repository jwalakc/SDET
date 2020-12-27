package SeleniumProject_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

WebDriver driver;
    
    @BeforeClass
    public void beforeTest() {
    	Reporter.log("Starting Activtiy6", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   

    @Test (priority=1)
    public void MyAccountTest() { 
        //Finding the Navigation Bar  	
    	driver.findElement(By.id("site-navigation"));
    	
    	//Clicking the "My Account" menu item    	
    	driver.findElement(By.linkText("My Account")).click(); 	
    	
    	//Assertion for My Account page
    	Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
    }

    @Test (priority=2)
    @Parameters({"username", "password"})    
    public void LoginTest(String username, String password) { 
    	
    	//Clicking the Login button 
    	driver.findElement(By.cssSelector(".ld-login")).click();
     	    	
    	//Find username and password fields of login
     	WebElement usernameKey = driver.findElement(By.cssSelector("#user_login"));	
       	WebElement passwordKey = driver.findElement(By.cssSelector("#user_pass"));
       	
    	//Type credentials
    	usernameKey.sendKeys(username);
    	passwordKey.sendKeys(password);
        
    	//Click Login button
    	WebElement submit = driver.findElement(By.xpath("//input[contains(@id,'submit')]"));
    	submit.click();
    	
    	//Assertion of successful login
    	Assert.assertEquals(driver.findElement(By.className("display-name")).getText(), username);
    
    	Reporter.log("Sucessfully logged in", true);
    }
    
    @AfterClass
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 6 is completed", true);
    }
}
