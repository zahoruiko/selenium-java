package com.example.AlertTesting;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestAlertMessage {
    
    @Test
    public void testAlertPopup() throws NoAlertPresentException,InterruptedException  {
    
        String rightAlertMessage = "Perform this transaction?";
        
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.example.com/moneyTransfer.php");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("accountNumber")).sendKeys("123456789123");        
        driver.findElement(By.id("sum")).sendKeys("1000000");
        driver.findElement(By.id("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        
        assertTrue("Alert message is not null and not empty", 
                   alertMessage!=null && !alertMessage.isEmpty());
        
        // Displaying alert message		
        System.out.println("Allert message = " + alertMessage);
        
        assertTrue("Alert message is right", 
           rightAlertMessage.equals(alertMessage));
        
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert.accept();		
    }	
}