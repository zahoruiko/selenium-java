package com.example.UploadDownloadTesting;

import com.example.base.BasicTestClass;
import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestFileUpload extends BasicTestClass {
    
    public TestFileUpload() {
        pageUrl = "http://www.example.com/fileUpload/";
    }
    
    @Test
    public void testFileUpload()
    {
        String fileForUpload = "/home/usernic/Documents/DoctoralThesis.doc";
        String destinationPageUrl = "http://www.example.com/fileUploadResult";
        String destinationPageTitle = "File upload result";
        String successResultMessage = "File is uploaded";

        File fileForUploading = new File(fileForUpload);
        
        assertTrue("File for upload exists", 
                          fileForUploading.exists() && !fileForUploading.isDirectory());
        assertTrue("The size of the file is >0", 
                          fileForUploading.length() > 0);
        
        driver.get(pageUrl);
        
        WebElement uploadElement = driver.findElement(By.id("uploadfile"));
        
        uploadElement.sendKeys(fileForUpload);
        
        driver.findElement(By.id("chkBoxTerms")).click();
        driver.findElement(By.name("btnUpload")).click();
        
        String uploadResultPageUrl =  driver.getCurrentUrl();
        
        assertTrue("Upload result page URL is correct", 
                  uploadResultPageUrl.equals(destinationPageUrl));
        
        String uploadingResultPageTitle = driver.getTitle();
        
        assertTrue("Result page title text is correct", 
                  uploadingResultPageTitle.equals(destinationPageTitle));
        
        WebElement uploadResultMessqge = driver.findElement(By.id("upload-result"));
        
        assertTrue("File is uploaded", 
                  uploadResultMessqge.getText().equals(successResultMessage));
    } 
}
