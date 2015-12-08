package com.manheim.shoestore.selenium.pageobjects.impl;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.manheim.shoestore.selenium.ShoeStoreTestBase;

public abstract class ShoeStoreBasePageObject {

    private static final int WAIT_TIMEOUT = 15;

    protected WebElement findElement(By selector) {
        return this.findElement(ExpectedConditions.presenceOfElementLocated(selector));
    }

    protected WebElement findElement(ExpectedCondition<WebElement> expectedCondition) {
        return this.getWebDriverWait().until(expectedCondition);
    }

    protected List<WebElement> findElements(By selector) {
        return this.getDriver().findElements(selector);
    }

    protected List<WebElement> findElements(ExpectedCondition<List<WebElement>> expectedCondition) {
        return this.getWebDriverWait().until(expectedCondition);
    }

    protected Locale getCurrentLocale() {
        return new Locale("en", "us");
    }

    private WebDriver getDriver() {
        return ShoeStoreTestBase.getThreadLocalWebDriver();
    }

    protected String getElementText(By selector) {
        return StringUtils.trim(this.findElement(selector).getText());
    }

    protected String getElementText(WebElement parentElement, By selector) {
        return StringUtils.trim(parentElement.findElement(selector).getText());
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(this.getDriver(), WAIT_TIMEOUT);
    }

    protected WebDriverWait getWebDriverWait(final int waitTimeout) {
        return new WebDriverWait(this.getDriver(), waitTimeout);
    }

    protected Boolean isElementDisplayed(By selector) {
        return this.findElement(selector).isDisplayed();
    }

    protected Boolean isElementDisplayed(WebElement parentElement, By selector) {
        return parentElement.findElement(selector).isDisplayed();
    }
}
