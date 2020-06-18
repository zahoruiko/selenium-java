package com.example.UploadDownloadTesting;

import com.example.base.BasicTestClass;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Oleksii Zhoruiko
 */
public class TestFileDownloadWithWget extends BasicTestClass {

    @Test
    public void testFileDownload() throws IOException {
        
        String downloadPath = "/tmp/SeleniumTests/";
        String baseUrl = "http://www.example.com/downloads.html";
        String rightUrlToFile = "http://www.example.com/files/fileToDownload.xml";
        
        System.setProperty("webdriver.gecko.driver", "/home/usernic/Drivers/geckodriver");
        
        WebDriver driver = new FirefoxDriver();
        
        driver.get(baseUrl);
        
        WebElement downloadLink = driver.findElement(By.linkText("Download"));
        String fileUrl = downloadLink.getAttribute("href");
        
        assertTrue("The URL to the file is not null and not empty", 
                           fileUrl!=null && !fileUrl.isEmpty());
        assertTrue("The URL to the file is right", 
                   fileUrl.equals(rightUrlToFile));
        
        String fileName = FilenameUtils.getName(fileUrl);

        assertTrue("The file name is not null and not empty", 
                            fileName!=null && !fileName.isEmpty());
        
        int remoteFileSize = getFileSize(fileUrl);
        
        assertTrue("The size of the file is not 0", remoteFileSize > 0);
        
        String wget_command = "wget.exe -P " + downloadPath + " D: --no-check-certificate " + fileUrl;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
            
            assertTrue("Wget exit value = 0", exitVal == 0);
            
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
              
        File downloadedFile = new File(downloadPath + fileName);
        
        assertTrue("The file is exists", downloadedFile.exists() && !downloadedFile.isDirectory());
        assertTrue("The file was downloaded completely", remoteFileSize == downloadedFile.length());
        assertTrue("The downloaded file is deleted", downloadedFile.delete());
        
        driver.close();
    }
}