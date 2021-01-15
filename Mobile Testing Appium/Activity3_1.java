package Appium_Activities;

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

public class Activity3_1 {
	    AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeTest
	    public void beforeTest() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 4 Emulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("noReset", true);
	        // Use your own device's messaging app
	        caps.setCapability("appPackage", "com.google.android.apps.messaging");
	        caps.setCapability("appActivity", ".ui.ConversationListActivity");

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);
	    }

	    @Test
	    public void smsTest() {
	        // Locate the button to write a new message and click it
	        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

	        // Enter the contact to send the SMS to
	        String contact = "textContains(\"My Number\")";
	        
	        // Click on the contact
	        driver.findElement(MobileBy.AndroidUIAutomator(contact)).click();
	        
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("compose_message_text")));
	    	 
	        // Focus on the message text box
	        String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
	        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
	     
	        // Type in a message
	        //messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/sms_edit_text\")";
	        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
	        composeMessageInput.sendKeys("Hello from Appium");

	        // Send the message
	        String sendMessage = "resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")";
	        driver.findElement(MobileBy.AndroidUIAutomator(sendMessage)).click();
	     	    
	    	// Wait for message to show
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));

	        // Assertion
	        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
	        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
	        Assert.assertEquals(sentMessageText, "Hello from Appium");
	    }

	    @AfterTest
	    public void afterTest() {
	        driver.quit();
	    }
	}