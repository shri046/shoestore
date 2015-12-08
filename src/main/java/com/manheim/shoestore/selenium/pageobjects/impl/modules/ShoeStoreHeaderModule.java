package com.manheim.shoestore.selenium.pageobjects.impl.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.manheim.shoestore.selenium.pageobjects.impl.ShoeStoreBasePageObject;
import com.manheim.shoestore.selenium.pageobjects.modules.HeaderModule;
import com.manheim.shoestore.selenium.pageobjects.utils.MonthNames;

@Component
public class ShoeStoreHeaderModule extends ShoeStoreBasePageObject implements HeaderModule {

    private static final By EMAIL_INPUT = By.id("remind_email_input");
    private static final By EMAIL_SUBMIT_BUTTON = By.xpath("//form[@id='remind_email_form']/div/input[@type='submit']");
    private static final By FLASH_MESSAGE = By.id("flash");

    public void clickMonth(MonthNames month) {
        this.findElement(By.linkText(month.name())).click();
    }

    public String getFlashMessage() {
        return this.getElementText(FLASH_MESSAGE);
    }

    public Boolean isRemindEmailInputDisplayed() {
        return this.isElementDisplayed(EMAIL_INPUT);
    }

    public void submitEmailAddress(String email) {
        WebElement emailInputField = this.findElement(EMAIL_INPUT);
        emailInputField.clear();
        emailInputField.sendKeys(email);
        this.findElement(EMAIL_SUBMIT_BUTTON).click();
    }

}
