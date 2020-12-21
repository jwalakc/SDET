package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser and display page title
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Page title: " + driver.getTitle());

        //Click the button to open a simple alert
        driver.findElement(By.cssSelector("button#simple")).click();

        //Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();

        //Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert box
        simpleAlert.accept();

        //Close the Browser
        driver.close();
    }
}