package com.example.BrowserCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestDesiredCapabilitiesChromeAndroid {
    
    private WebDriver driver;
    private String baseUrl = "https://www.google.com";
    private String nodeUrl = "http://192.168.10.1:4567/wd/hub";
    
    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung Galaxy S20");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.VERSION, "83.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setJavascriptEnabled(true);
        capabilities.acceptInsecureCerts();
        
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
        String pageTitle = driver.getTitle();
        
        assertTrue("The page title is not null and not empty", 
                          pageTitle!=null && !pageTitle.isEmpty());
        
        System.out.println("Page title is: " + pageTitle);
        
        driver.quit();
    }
}
