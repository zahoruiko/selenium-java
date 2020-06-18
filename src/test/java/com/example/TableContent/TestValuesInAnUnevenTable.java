package com.example.TableContent;

import com.example.base.BasicTestClass;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestValuesInAnUnevenTable extends BasicTestClass {

    public TestValuesInAnUnevenTable() {
        pageUrl = "http://www.example.com/table.html";
    }
    
    @Test
    public void getValuesFromAnUnevenTable() {
        
        WebElement unevenTableElement = driver.findElement(By.xpath("//table/tbody"));
        
        List< WebElement> rowElements = unevenTableElement.findElements(By.tagName("tr"));
        
        int tableRowsAmount = rowElements.size();
        
        System.out.println("Table rows amount = " + tableRowsAmount);
        
        assertTrue("Table rows amount > 0", tableRowsAmount > 0);
        
        for (int rowId = 0; rowId < tableRowsAmount; rowId++) {
            
            List< WebElement> cellsInTheRowElements = rowElements.get(rowId).findElements(By.tagName("td"));
            
            int cellsInTheRowAmount = cellsInTheRowElements.size();
            
            System.out.println("Cells amount in the row #" + rowId + " is " + cellsInTheRowAmount);
            
            assertTrue("Cells in the row > 0", cellsInTheRowAmount > 0);
            
            for (int cellId = 0; cellId < cellsInTheRowAmount; cellId++) {
                
                String cellValue = cellsInTheRowElements.get(cellId).getText();
                
                System.out.println("Cell[" + cellId + "] = " + cellValue);
                
                assertTrue("Cell[" + cellId + "] value is not null and not empty", 
                                   cellValue!=null && !cellValue.isEmpty());
            }
            
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<< [" + rowId + "]>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }
}