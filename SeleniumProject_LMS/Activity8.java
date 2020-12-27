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

public class Activity8 {

WebDriver driver;
    
    @BeforeClass
    public void beforeTest() {
    	Reporter.log("Starting Activtiy8", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   

    @Test
    public void ContactTest() { 
        //Finding the Navigation Bar  	
    	driver.findElement(By.id("site-navigation"));
    	
    	//Clicking the "Contact" menu item
    	WebElement contact = driver.findElement(By.linkText("Contact"));
    	contact.click(); 	
    	
    	//Assertion for Contact page
    	Assert.assertEquals(driver.getTitle(), "Contact – Alchemy LMS");
    	   	
    	//Find contact form fields
    	WebElement fullName = driver.findElement(By.cssSelector("#wpforms-8-field_0"));
    	WebElement email = driver.findElement(By.cssSelector("#wpforms-8-field_1"));	
    	WebElement subject = driver.findElement(By.cssSelector("#wpforms-8-field_3"));
    	WebElement message = driver.findElement(By.cssSelector("#wpforms-8-field_2"));
    	
    	//Type credentials
    	fullName.sendKeys("Jwala C");
    	email.sendKeys("test@gmail.com");
    	subject.sendKeys("Request for access");
    	message.sendKeys("Hi, Please grant me course access.");
    	
    	//Click Submit button
    	WebElement submit = driver.findElement(By.xpath("//button[contains(@id,'submit')]"));
    	submit.click();
    	
    	//Print confirmation message 
    	WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(@id, 'confirmation')]"));
    	Reporter.log("The confirmation message is: " + confirmationMessage.getText(), true); 
  }
    	
    @AfterClass
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 8 is completed", true);
    }
}
