package com.example.testbench;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest extends TestCase {
    WebDriver driver;
    String UIUrl, nodeURL;

    @Override
    @Before
    public void setUp() {
        UIUrl = "http://localhost:8080/example";
        driver = new FirefoxDriver();
    }
    @Test
    public void testWithoutTestbench() {
        driver.get(UIUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        final WebElement button = findButtonByCaption("Click");
        button.click();
        final List<WebElement> elements = driver.findElements(By.id("labelid"));
        if (elements.isEmpty()) {
            throw new RuntimeException("No Labelfound");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        final String value = elements.get(0).getText();
        Assert.assertEquals("Clicked", value);
    }
    public WebElement findButtonByCaption(String caption) {
        final List<WebElement> buttons = driver
                .findElements(By.className("v-button"));
        for (final WebElement button : buttons) {
            if (button.getText().equals(caption)) {
                return button;
            }
        }
        return null;
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
