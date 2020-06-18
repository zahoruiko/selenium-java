package com.example.AlertPopupTesting;

import com.example.base.BasicTestClass;
import org.junit.Test;
import java.util.Iterator;		
import java.util.Set;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author trident
 */
public class TestWindowHandling extends BasicTestClass {
    
    @Test
    public void testWindowHandling() throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();		
        driver.get("http://www.example.com/popup.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String mainWindow = driver.getWindowHandle();

        // To handle all new opened window.				
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String childWindow = i1.next();

            if (!mainWindow.equalsIgnoreCase(childWindow)) {

                // Switching to Child window
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid"))
                      .sendKeys("example@mail.com");                			
                    
                driver.findElement(By.name("btnLogin")).click();

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainWindow);
    }
}