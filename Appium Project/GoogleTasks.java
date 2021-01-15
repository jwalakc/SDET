package Appium_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
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

public class GoogleTasks {
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void CreateTasks() {
    	
    	//wait for page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text = 'My Tasks']")));
 	    String Title = driver.findElementByXPath("//android.widget.TextView[@text = 'My Tasks']").getText();
 		Assert.assertEquals(Title, "My Tasks");
 		System.out.println("The page title is: " + Title);
    	
    	//Adding and saving Tasks
    	MobileElement CreateTask = driver.findElementByAccessibilityId("Create new task");
    	CreateTask.click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
	    MobileElement taskTitle = driver.findElementById("add_task_title");
	    MobileElement addTask = driver.findElementById("add_task_done");
	    driver.findElementById("touch_outside").click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
		 
	    String[] tasksToAdd	 = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
	    
	    for (String taskToAdd : tasksToAdd) {
	    	CreateTask.click();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
			taskTitle.sendKeys(taskToAdd);
			addTask.click();	
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
		   	}
		     	    	
        // Assertion      
 	 	List<MobileElement> tasks = driver.findElementsById("task_name");
    	System.out.println("Number of tasks: " + tasks.size());
	    Assert.assertEquals(tasks.size(), 3);
	    
	    List<String> taskNames = new ArrayList<>(); 
	    List<String> expectedTaskNames = new ArrayList <>(Arrays.asList("Complete the second Activity Google Keep", "Complete Activity with Google Keep", "Complete Activity with Google Tasks"));
	    
	    System.out.println("The Tasks are: ");
	  	for (MobileElement task:tasks) {
				System.out.println(task.getText());
				taskNames.add(task.getText());
		    	}
	  	Assert.assertEquals(taskNames, expectedTaskNames);
    }
    
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    }
