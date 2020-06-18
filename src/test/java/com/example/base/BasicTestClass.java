package com.example.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Oleksii Zahoruiko
 */
public class BasicTestClass {

    protected ChromeDriver driver;
    protected String pageUrl ="https://www.dw.com";
    
    protected final int NOT_ACCEPTABLE_RESPONSE_CODE_LEVEL = 400;
    
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/trident/Drivers/83/chromedriver");
        
        driver = new ChromeDriver();
        driver.get(pageUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);        
    }
        
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Ignore("This is not a test, but a utility method.")
    protected boolean isUrlAvailable(String tagName, String linkUrl) {
        
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();

            System.out.println(tagName + " LinkResponseCode = " + responseCode);

            return responseCode < NOT_ACCEPTABLE_RESPONSE_CODE_LEVEL;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Ignore("This is not a test, but a utility method")
    protected int getFileSize(String urlToFile) throws MalformedURLException {
        
        URL url = new URL(urlToFile);
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            if (conn instanceof HttpURLConnection) {
                ((HttpURLConnection) conn).setRequestMethod("HEAD");
            }
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn instanceof HttpURLConnection) {
                ((HttpURLConnection) conn).disconnect();
            }
        }
    }
}
