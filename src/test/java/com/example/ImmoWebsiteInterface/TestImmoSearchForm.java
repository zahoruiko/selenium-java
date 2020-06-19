package com.example.ImmoWebsiteInterface;

import com.example.base.BasicTestClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestImmoSearchForm extends BasicTestClass {

    public TestImmoSearchForm() {
       pageUrl = "https://immo.example.de/";    
    }
        
    @Test
    public void testImmoSearchForm() {
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Select marketingTypes = new Select(driver.findElement(By.xpath("//select[@name='marketingType']")));
        marketingTypes.selectByIndex(1);
        
        WebElement locationElement = driver.findElement(By.id("oss-location"));
        locationElement.clear();
        locationElement.sendKeys("44801 Bochum");
        
        List<WebElement> locationSuggestionsListElement = driver.findElements(By.className("ui-menu-item"));        
        locationSuggestionsListElement.get(0).click();
        
        Select immobilienType = new Select(driver.findElement(By.id("oss-real-estate-type-rent")));
        immobilienType.selectByIndex(0);
        
        WebElement price = driver.findElement(By.id("oss-price"));
        price.clear();
        price.sendKeys("5000000");
        
        Select rooms = new Select(driver.findElement(By.id("oss-rooms")));
        rooms.selectByIndex(2);
        
        WebElement area = driver.findElement(By.id("oss-area"));
        area.clear();
        area.sendKeys("100");
        
        Select radius = new Select(driver.findElement(By.id("oss-radius")));
        radius.selectByIndex(5);
        
        WebElement searchFormContainerElement = driver.findElement(By.id("main-search-tab-content-property"));
        WebElement submitSearchFormButton = searchFormContainerElement.findElement(By.tagName("button"));
        submitSearchFormButton.click();
       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        String searchListTitle = driver.getTitle();
        
        assertTrue("Search list title is not null and not empty", 
                    searchListTitle!=null && !searchListTitle.isEmpty());
    }
}