package com.example.BrowserCapabilities;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class TestDesiredCapabilitiesIE {

    private String baseUrl = "https://www.google.com";
    
    @Test
    public void testIEDesiredCapabilities() {

        // Define IE capability 
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE 6");
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setJavascriptEnabled(true);
        capabilities.acceptInsecureCerts();

        System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Drivers\\IEDriverServer.exe");

        // Initialize the IE driver
        WebDriver driver = new InternetExplorerDriver(capabilities);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
        String pageTitle = driver.getTitle();
        
        Assert.assertTrue("The page title is not null and not empty", 
                           pageTitle!=null && !pageTitle.isEmpty());
        
        System.out.println("Page title is: " + pageTitle);
        
        driver.quit();
    }
}