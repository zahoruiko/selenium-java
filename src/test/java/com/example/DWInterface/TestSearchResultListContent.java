package com.example.DWInterface;

import com.example.base.BasicTestClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestSearchResultListContent extends BasicTestClass {
    
    protected final int searchResultsLinksMaxAmount = 10;
       
    @Test
    public void testSearchResultListContent() {
               
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                
        WebElement searchField = driver.findElement(By.cssSelector("#item"));
        searchField.clear();
        searchField.sendKeys("Deutschland");

        WebElement searchButton = driver.findElement(By.cssSelector("#searchButton"));
        searchButton.click();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        List<WebElement> webElements = driver.findElements(By.className("searchResult"));
        
        int linksAmount = webElements.size();
        
        System.out.println("webElements.size() = " + linksAmount);
        
        assertTrue("Search links amount is allowed", linksAmount <= searchResultsLinksMaxAmount); 
        
        int i = 1;
        
        for(WebElement webElement: webElements) {

            WebElement linkElement = webElement.findElement(By.tagName("a"));
            String aHref = linkElement.getAttribute("href");     
            
            assertFalse(aHref == null);
            assertFalse(aHref.isEmpty());
            
            System.out.println("aHref[" + i + "] = " + aHref);
            
            assertTrue(isUrlAvailable("[A]", aHref));
              
            WebElement imgElement = webElement.findElement(By.tagName("img"));            
            String imgSrc = imgElement.getAttribute("src");
            
            assertFalse(imgSrc == null);
            assertFalse(imgSrc.isEmpty());
            
            System.out.println("imgSrc[" + i + "] = " + imgSrc);
            
            assertTrue(isUrlAvailable("[IMG]", imgSrc));
            
            String imgAlt = imgElement.getAttribute("alt");
            
            assertFalse(imgAlt == null);
            assertFalse(imgAlt.isEmpty());
            
            System.out.println("imgAlt[" + i + "] = " + imgAlt);
            
            String imgTitle = imgElement.getAttribute("title");
            
            assertFalse(imgTitle== null);
            assertFalse(imgTitle.isEmpty());
            
            System.out.println("imgTitle[" + i + "] = " + imgTitle);
                 
            if(imgAlt.equals(imgTitle)) {
                System.out.println("imgAlt[" + i + "] == imgTitle[" + i + "]");
            } else {
                System.out.println("imgAlt[" + i + "] != imgTitle[" + i + "]");
            }
            
            assertTrue(imgAlt.equals(imgTitle));
            
            System.out.println("imgAlt == imgTitle");
              
            WebElement articleDateElement = webElement.findElement(By.className("date"));
            String articleDateText = articleDateElement.getText();
            
            assertFalse(articleDateText == null);
            assertFalse(articleDateText.isEmpty());
            
            System.out.println("articleDateText[" + i + "] = " + articleDateText);
            
            WebElement linkHeader = webElement.findElement(By.tagName("h2"));
            String imgHeaderText = linkHeader.getText().replace(articleDateText, "");
            
            assertFalse(imgHeaderText == null);
            assertFalse(imgHeaderText.isEmpty());
            
            System.out.println("imgHeaderText[" + i + "] = " + imgHeaderText);
              
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< [" + i + "] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            i++;
        }  
    }
}