package com.example.DWInterface;

import com.example.base.BasicTestClass;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestNewsSearchByCssSelector extends BasicTestClass {
       
    @Test
    public void searchCoronaVirusNews() {
        
        WebElement searchField = driver.findElement(By.cssSelector("#item"));
        searchField.clear();
        searchField.sendKeys("Deutschland");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement searchButton = driver.findElement(By.cssSelector("#searchButton"));
        searchButton.click();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        String searchListTitle = driver.getTitle();

        assertTrue("Search list title is not null and not empty", 
                    searchListTitle!=null && !searchListTitle.isEmpty());
        
        System.out.println("Search list title: " + searchListTitle);
    }
}
