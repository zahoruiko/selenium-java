package com.example.SelectElementTesting;

import com.example.base.BasicTestClass;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestSelectDropDown extends BasicTestClass {

    public TestSelectDropDown() {
        pageUrl = "http://www.example.com/TypeOfGoods";
    }

    @Test
    public void testSeclectDropDown() 
    { 	
        System.out.println("Page[1]: " + driver.getTitle());
        
        WebElement selectElement = driver.findElement(By.name("types-of-goods"));
        
        int selectElementSize = Integer.valueOf(selectElement.getAttribute("size").toString());
        
        assertTrue("Size of the selectElement = 1", selectElementSize == 1); 
          
        Select typesOfGoods = new Select(selectElement);
        
        assertFalse("Select mode is single", typesOfGoods.isMultiple());
          
        List<WebElement> presentOptions = typesOfGoods.getOptions();
        
        String typeOfGoodsToSelect = "Stationery";
        boolean optionPresent = false;
        
        for(WebElement presentOption: presentOptions) {
            if(presentOption.getText() == typeOfGoodsToSelect) {
                optionPresent = true;
                break;
            }
        }
        
        assertTrue("Type of goods is present in the list", optionPresent);
        
        typesOfGoods.deselectAll();  
        typesOfGoods.selectByVisibleText(typeOfGoodsToSelect);

        String firstSelectedOption = typesOfGoods.getFirstSelectedOption().getText();
        
        assertTrue("Type of goods is selected", typeOfGoodsToSelect.equals(firstSelectedOption));
        
        WebElement nextButton = driver.findElement(By.className("btn-next"));
        nextButton.click();
        
        System.out.println("Page[2]: " + driver.getTitle());
        
        WebElement selectGoodsElement = driver.findElement(By.id("goods"));
        
        Select goodsSelector = new Select(selectGoodsElement);

        assertTrue("Select mode is multiple", goodsSelector.isMultiple());
        
        String[] itemsToSelect = {"Pen", "Pencil", "Ruller"};          
        for(String itemToSelect: itemsToSelect) {
            System.out.println("Select item: " + itemToSelect);
            goodsSelector.selectByVisibleText(itemToSelect);
        }
           
        List<WebElement> selectedItems = goodsSelector.getAllSelectedOptions();
        
        assertTrue("Amount selected elements = 3", itemsToSelect.length == selectedItems.size());
        
        for(WebElement selectedItem: selectedItems) {
            System.out.println("Selected item: " + selectedItem.getText());
            assertTrue("Item is selected", Arrays.asList(itemsToSelect).contains(selectedItem.getText()));
        }
        
        WebElement okButton = driver.findElement(By.className("btn-submit"));
        okButton.click();
    }
}