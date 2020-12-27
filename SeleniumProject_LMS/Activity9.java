package SeleniumProject_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity9 {

WebDriver driver;
    
    @BeforeTest 
    public void beforeTest() {
    	Reporter.log("Starting Activtiy9", true);
    	
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }   
    
    @Test (priority = 0)
    public void AllCoursesTest() {
        //Finding the Navigation Bar  	
        driver.findElement(By.id("site-navigation"));
        	
    	// Click on All Courses
    	driver.findElement(By.linkText("All Courses")).click();
    	
    	//Assertion for title of the "All Courses" page
        Assert.assertEquals(driver.getTitle(), "All Courses – Alchemy LMS");
    }
    
    @Test (priority = 1)
    @Parameters({"username", "password"}) 
    public void SelectCourseTest(String username, String password) { 
    	//Click on course: Content Marketing
    	driver.findElement(By.xpath("//h3[text()='Content Marketing']/preceding::a[1]/img")).click();
    	
    	//Assertion for course title 
        Assert.assertEquals(driver.getTitle(), "Content Marketing – Alchemy LMS");
    	
    	//Click login if "Course Content" is not displayed
        if(driver.findElements(By.xpath("//h2[text()='Course Content']")).size() == 0) {
         	
        	//First Login to see the Course Content
        	driver.findElement(By.linkText("Login")).click();
        	driver.findElement(By.cssSelector("#user_login")).sendKeys(username);
        	driver.findElement(By.cssSelector("#user_pass")).sendKeys(password);
        	driver.findElement(By.xpath("//input[contains(@id, 'submit')]")).click();

         	Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Course Content']")).isDisplayed());
           	}    }
        
    @Test (priority = 2)
    public void MarkCompleteTest() { 
    	//Click on lesson: Effective Writing & Promoting Your Content
    	driver.findElement(By.xpath("//div[contains(text(), 'Effective Writing')]")).click();
    	Assert.assertEquals(driver.getTitle(), "Effective Writing & Promoting Your Content – Alchemy LMS");
    	
    	//Click "Mark Complete" if it is displayed
    	if(driver.findElements(By.xpath("//input[contains(@class, 'mark_complete_button')]")).size() != 0) {
    		
    		// Click on "Mark Complete"
    		driver.findElement(By.xpath("//input[contains(@class, 'mark_complete_button')]")).click();
    		  		
    		//Assertion of Complete Button turning blue
    		WebElement CompleteButton = driver.findElement(By.xpath("//div[contains(text(), 'Effective Writing')]/preceding-sibling::div"));   		
    		Assert.assertEquals(CompleteButton.getCssValue("background-color"), "rgb(9, 132, 227)");
    		 
    		//Print Completion status to Console
    		Reporter.log("The lesson is marked complete", true);
    		}
    	
    	else {
    		//Print Completion status to Console
    		Reporter.log("The lesson is already completed", true);
    	}
    }
    
    @AfterTest
    public void afterTest() {
        //Close the browser
        driver.close();
        Reporter.log("Activity 9 is completed", true);
    }
}
