package com.example.AlertPopupTesting;

import com.example.base.BasicTestClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author trident
 */
public class TestAlertPopup {
    
    @Test
    public void testAlertPopup() throws NoAlertPresentException,InterruptedException  {
    
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.example.com/moneyTransfer.php");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("accountNumber")).sendKeys("123456789123");        
        driver.findElement(By.id("sum")).sendKeys("1000000");
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        
        assertTrue("Alert message is not null and not empty", 
                   alertMessage!=null && !alertMessage.isEmpty());
        
        // Displaying alert message		
        System.out.println("Allert message = " + alertMessage);
        
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert.accept();		
    }	
}