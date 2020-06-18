package com.example.DWInterface;

import com.example.base.BasicTestClass;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestCssLinksAvailability extends BasicTestClass {
    
    @Test
    public void checkAllCssLinksAvailability() {
 
        List<WebElement> stylesheetLinks = driver.findElements(By.xpath("//link[@rel='stylesheet']"));
        
        Iterator<WebElement> stylesheetLinksIterator = stylesheetLinks.iterator();
        
        int i = 0;
        
        while(stylesheetLinksIterator.hasNext()){ 
        
            WebElement webElement = stylesheetLinksIterator.next();
            
            String linkUrl = webElement.getAttribute("href");
            
            System.out.println("Link = " + linkUrl);
            
            assertTrue("Url is not null and not empty", 
                       linkUrl!=null && !linkUrl.isEmpty());
            
            assertTrue("Url is available", 
               isUrlAvailable("link(stylesheet) ", linkUrl));
        }
    }
}