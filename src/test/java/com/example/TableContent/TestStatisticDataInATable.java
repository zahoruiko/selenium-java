package com.example.TableContent;

import com.example.base.BasicTestClass;
import java.text.ParseException;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestStatisticDataInATable extends BasicTestClass  {

    public TestStatisticDataInATable() {
        pageUrl = "http://www.example.com/dataTable.php";
    }

    @Test
    public void getStatisticDataFromATable() throws ParseException {

        WebElement unevenTableElement = driver.findElement(By.xpath("//table/tbody"));
        
        List< WebElement> rowElements = unevenTableElement.findElements(By.tagName("tr"));
        
        int rowsAmount = rowElements.size();
        
        System.out.println("Rows amount = " + rowsAmount);
        
        List< WebElement> cellsInTheRowElements = rowElements.get(0).findElements(By.tagName("td"));
        
        int cellsAmount = cellsInTheRowElements.size();
        
        System.out.println("Cols amount = " + cellsAmount);
        
        float firstValue = Float.parseFloat(driver.findElement(By.xpath("//tr[1]/td[2]")).getText());
        
        System.out.println("Value[1] = " + firstValue);
        
        float maxValue = firstValue;
        float minValue = firstValue;
        float sumValues = firstValue;
        
        for (int rowId = 2; rowId <= rowsAmount; rowId++) {
            
            float currentValue = Float.parseFloat(driver.findElement(By.xpath("//tr[" + (rowId) + "]/td[2]")).getText());
            
            System.out.println("Value[" + rowId + "] = " + currentValue);
            
            if(currentValue > maxValue)
                maxValue = currentValue;
            
            if(currentValue < minValue)
                minValue = currentValue;
            
            sumValues += currentValue;
        }
        
        float averageValue = sumValues/rowsAmount;
        
        System.out.println("Values amount = " + rowsAmount);
        
        assertTrue("Values amount > 0 ", rowsAmount > 0);
        
        System.out.println("Max value = " + maxValue);
        System.out.println("Average value = " + averageValue);
        System.out.println("Min value = " + minValue);
        
        assertTrue("maxValue > averageValue", maxValue > averageValue);
        
        assertTrue("averageValue > minValue", averageValue > minValue);
    }
}