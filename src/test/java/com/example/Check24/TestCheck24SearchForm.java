/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Check24;

import com.example.base.BasicTestClass;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestCheck24SearchForm extends BasicTestClass{

    public TestCheck24SearchForm() {
        pageUrl = "https://hotel.check24.de/produkte";
    }
    
    @Test
    public void checkCheck24SearchForm() {

       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
       WebElement destinationSuggestionInputElement = driver.findElement(By.className("destinationSuggestionQueryInput__input"));
       
       destinationSuggestionInputElement.clear();
       destinationSuggestionInputElement.sendKeys("Magdeburg");
       
//       WebElement arivalDateInputElement = driver.findElement(By.id("airBnbDateRangePicker_startDate_standard"));
//       arivalDateInputElement.clear();
//       arivalDateInputElement.sendKeys("01.08.2022");
//    
//       WebElement departureDateInputElement = driver.findElement(By.id("airBnbDateRangePicker_endDate_standard"));
//       departureDateInputElement.clear();
//       departureDateInputElement.sendKeys("31.08.2022");
       
       WebElement tripReason = driver.findElement(By.id("travelReasonIsBusiness"));
//       if(!tripReason.isSelected())
//           tripReason.click();
     
       WebElement submitButtonContainer = driver.findElement(By.className("columns small-6 align-self-bottom"));
       
       WebElement submitButton = submitButtonContainer.findElement(By.tagName("button"));

       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  

       submitButton.click();
       
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
       
    }
}
