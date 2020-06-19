package com.example.BrowserCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestDesiredCapabilitiesFirefoxWin {
    
    private WebDriver driver;
    private String baseUrl = "https://www.google.com";
    private String nodeUrl = "http://192.168.10.1:4567/wd/hub";
    
    @Test
    @SuppressWarnings("deprecation")
    public void testDesiredCapabilities() throws MalformedURLException {
        
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WIN10);

        driver = new RemoteWebDriver(new URL(nodeUrl),capability);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
        String pageTitle = driver.getTitle();
        
        Assert.assertTrue("The page title is not null and not empty", 
                          pageTitle!=null && !pageTitle.isEmpty());
        
        System.out.println("Page title is: " + pageTitle);
        
        driver.quit();
    }
}
