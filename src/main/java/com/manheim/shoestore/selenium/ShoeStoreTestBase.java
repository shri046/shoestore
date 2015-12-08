package com.manheim.shoestore.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.manheim.shoestore.selenium.spring.testcontext.ShoeStoreTestContext;

@ContextConfiguration(classes = ShoeStoreTestContext.class)
public class ShoeStoreTestBase {

    private Logger logger;
    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getThreadLocalWebDriver() {
        return threadLocalWebDriver.get();
    }

    public ShoeStoreTestBase() {
        this.logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    private WebDriver createWebDriverInstance() {
        this.getLogger().info("Creating new WebDriver instance");
        String browser = System.getProperty("browserType", BrowserType.FIREFOX);

        this.getLogger().info("Read browserType as {} from system property", browser);

        if (BrowserType.IEXPLORE.equalsIgnoreCase(browser)) {
            return new InternetExplorerDriver();
        } else if (BrowserType.CHROME.equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        } else {
            return new FirefoxDriver();
        }
    }

    private WebDriver getDriver() {
        return this.driver;
    }

    protected Logger getLogger() {
        return this.logger;
    }

    protected String getPageTitle() {
        return this.getDriver().getTitle();
    }

    private void initiateWebDriver() {
        this.driver = threadLocalWebDriver.get();
        if (this.driver == null) {
            this.driver = this.createWebDriverInstance();
            threadLocalWebDriver.set(this.driver);
        }
    }

    @After
    public void killWebDriver() {
        this.getLogger().info("Test complete, shutting down WebDriver instance");
        this.getDriver().quit();
        threadLocalWebDriver.remove();
    }

    protected void navigateTo(final String url) {
        this.getDriver().get(url);
    }

    @Before
    public void setupWebDriver() {
        this.initiateWebDriver();
    }
}
