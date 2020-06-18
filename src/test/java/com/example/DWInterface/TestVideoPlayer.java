package com.example.DWInterface;

import com.example.base.BasicTestClass;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestVideoPlayer extends BasicTestClass {
    
    public TestVideoPlayer() {
        pageUrl = "https://www.dw.com/de/bedrohlicher-vulkan/av-49218101";
    }
   
    @Test
    public void checkVideoPlayer () throws InterruptedException {
        
        // Accepting cookies
        WebElement cookieOkButtonElement = driver.findElement(By.xpath("//a[@class='cookie__btn cookie__btn--ok']"));   
        cookieOkButtonElement.click();
        Thread.sleep(500);
        
        // Scroll screen up
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);
        
        // Click "Play" button (in the lower left corner)
        WebElement playButtonElement = driver.findElement(By.className("customPlayBtn"));
        playButtonElement.click(); // Play        
        Thread.sleep(2000);
        
//        // Expand the player to full screen
//        WebElement playerFullScreenButtonElement = driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-inline jw-button-color jw-reset jw-icon-fullscreen']"));   
//        playerFullScreenButtonElement.click();
//        Thread.sleep(4000);
//        
//        // Returning the player to a small size
//        WebElement playerSmallScreenButtonElement = driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-inline jw-button-color jw-reset jw-icon-fullscreen jw-off']"));
//        playerSmallScreenButtonElement.click();
//        Thread.sleep(4000);
        
        // Click on the image to pause playback
        WebElement videoContainer = driver.findElement(By.id("videoContainer-492181010"));
        videoContainer.click(); // Pause
        Thread.sleep(2000);
        
        // Click on the image to resume playback
        videoContainer.click(); // Play
        Thread.sleep(2000);
       
        // Click the Pause button to stop playback
        WebElement pauseAndPlaybackButtonElement = driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-inline jw-button-color jw-reset jw-icon-playback']"));
        pauseAndPlaybackButtonElement.click(); // Play
        Thread.sleep(2000);
        
        // You should use a NEW element with the SAME address
        WebElement pauseAndPlaybackButtonElement2 = driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-inline jw-button-color jw-reset jw-icon-playback']"));
        pauseAndPlaybackButtonElement2.click(); // Pause
    }
    
    @After
    public void tearDown() {
//        driver.quit();
    }
}
