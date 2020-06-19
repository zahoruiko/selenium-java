package com.example.DWInterface;

import com.example.base.BasicTestClass;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestLinksAvailability extends BasicTestClass {
    
    @Test
    public void checkAllCssLinksAvailability() {
 
        checkLinksAvailabilityByXPath("//img", "src");
        checkLinksAvailabilityByXPath("//link", "href");
    }
    
    @Ignore("This is not a test, but a utility method.")
    protected void checkLinksAvailabilityByXPath(String xpath, String urlAttr) {
        
        System.out.println("=============== " + xpath + " / " + urlAttr + "=================");
        
        List<WebElement> links = driver.findElements(By.xpath(xpath));
        
        Iterator<WebElement> linksIterator = links.iterator();
        
        while(linksIterator.hasNext()){ 
        
            WebElement webElement = linksIterator.next();
            
            String linkUrl = webElement.getAttribute(urlAttr);
            
            System.out.println("Link = " + linkUrl);
            
            assertTrue("Url is not null and not empty", 
                       linkUrl!=null && !linkUrl.isEmpty());
            
            assertTrue("Url is available", 
               isUrlAvailable(xpath, linkUrl));
        }
    }
}