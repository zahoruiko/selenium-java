package com.example.DWInterface;

import com.example.base.BasicTestClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestMainPageMetaTags extends BasicTestClass {

     @Test
     public void checkMainPageMetaTags() {
     
        String rightPageTitle = "News and current affairs from Germany and around the world | DW"; 
        String rightKeywords = "TOP STORIES, World News,german news,european news,african news,Asian news,current affairs,Germany,European Union,breaking news";
        String rightSiteDescription = "News, off-beat stories and analysis of German and international affairs. Dive deeper with our features from Europe and beyond. Watch our 24/7 TV stream.";
         
        String pageTitle = driver.getTitle();
     
        assertTrue("Page title is not null and not empty", 
                    pageTitle!=null && !pageTitle.isEmpty());
        
        System.out.println("Title = " + pageTitle);
         
        assertTrue("Page title is right", pageTitle.equals(rightPageTitle));        
        
        WebElement siteKeywordsElement = driver.findElement(By.xpath("//meta[@name='keywords']"));
        String siteKeywordsText = siteKeywordsElement.getAttribute("content");
        
        assertTrue("Keywords text is not null and not empty", 
                    siteKeywordsText!=null && !siteKeywordsText.isEmpty());
        
        System.out.println("siteKeywords = " + siteKeywordsText);
        
        assertTrue("Keywords are right", 
           siteKeywordsElement.getAttribute("content").equals(rightKeywords));
        
        WebElement siteDescriptionElement = driver.findElement(By.xpath("//meta[@name='description']"));
        String siteDescriptionText = siteDescriptionElement.getAttribute("content");
        
        assertTrue("Description is not null and not empty", 
                   siteDescriptionText!=null && !siteDescriptionText.isEmpty());
        
        System.out.println("siteDescription = " + siteDescriptionText);
        
        assertTrue("Description is right", 
           siteDescriptionText.equals(rightSiteDescription));        
    }
}
