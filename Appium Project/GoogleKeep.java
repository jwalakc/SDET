package Appium_Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeep {
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void CreateTasks() {
    	//Go to Add Note
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
    	driver.findElementById("new_note_button").click();
    	
    	//Add the note
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
       	driver.findElementById("editable_title").sendKeys("GoogleKeep Title");
       	driver.findElementById("edit_note_text").sendKeys("This is the GoogleKeep Note");
       	
       	//Save the note
       	driver.findElementByAccessibilityId("Open navigation drawer").click();
    	   	
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
     	    	
        // Assertion      
    	String Title = driver.findElementById("index_note_title").getText();
   	  	Assert.assertEquals(Title, "GoogleKeep Title");
   	  	System.out.println("The Title is: " + Title);
   	  	
   	  	String Note = driver.findElementById("index_note_text_description").getText();
	  	Assert.assertEquals(Note, "This is the GoogleKeep Note");
	  	System.out.println("The Note is: " + Note);
	  	    }
    
    @AfterTest
    public void afterTest() {
        driver.quit();
    }}
