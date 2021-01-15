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

public class GoogleKeepWithReminder {
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
       	driver.findElementById("editable_title").sendKeys("GoogleKeep Reminder Title");
       	driver.findElementById("edit_note_text").sendKeys("This is the GoogleKeep Note with reminder");
       	
       	//Add the reminder
       	driver.findElementById("menu_reminder").click();
       	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("dialog_title")));
       	
       	driver.findElementByXPath("//android.widget.LinearLayout[contains(@content-desc, 'Date')]").click();
       	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("reminder_date_tomorrow")));       	
       	driver.findElementById("reminder_date_tomorrow").click();
       	
       	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("dialog_title")));
       	
       	driver.findElementByXPath("//android.widget.LinearLayout[contains(@content-desc, 'Time - Currently selected')]").click();
       	
       	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("reminder_time_afternoon")));       	
       	driver.findElementById("reminder_time_afternoon").click();
       	
       	//Save the reminder
       	driver.findElementById("save").click();
       	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Open navigation drawer")));
               	
       	//Save the note
       	driver.findElementByAccessibilityId("Open navigation drawer").click();
     	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
     	    	
     	//Switching to Reminders page
       	driver.findElementByAccessibilityId("Open navigation drawer").click();
     	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("browse_reminder_chip")));
     	driver.findElementById("browse_reminder_chip").click();
       	
     	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("header_text")));   	
     	
        // Assertion      
    	String Title = driver.findElementById("index_note_title").getText();
   	  	Assert.assertEquals(Title, "GoogleKeep Reminder Title");
   	  	System.out.println("The Title is: " + Title);
   	  	
   	  	String Note = driver.findElementById("index_note_text_description").getText();
	  	Assert.assertEquals(Note, "This is the GoogleKeep Note with reminder");
	  	System.out.println("The Note is: " + Note);
	  	    }
    
    @AfterTest
    public void afterTest() {
        driver.quit();
    }}
