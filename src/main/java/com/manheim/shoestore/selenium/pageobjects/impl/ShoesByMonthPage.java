package com.manheim.shoestore.selenium.pageobjects.impl;

import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.manheim.shoestore.selenium.pageobjects.MonthlyListingPage;

@Component
public class ShoesByMonthPage extends ShoeStoreBasePageObject implements MonthlyListingPage {

    private static final By SHOE_LIST_CONTAINER = By.cssSelector("ul#shoe_list li");

    private static final String SHOE_CONTAINER = "div.shoe_result";

    private static final By SHOE_BRAND = By.cssSelector(SHOE_CONTAINER + " td.shoe_brand a");
    private static final By SHOE_DESCRIPTION = By.cssSelector(SHOE_CONTAINER + " td.shoe_description");

    private static final By SHOE_NAME = By.cssSelector(SHOE_CONTAINER + " td.shoe_name");
    private static final By SHOE_PRICE = By.cssSelector(SHOE_CONTAINER + " td.shoe_price");
    private static final By SHOE_RELEASE_MONTH = By.cssSelector(SHOE_CONTAINER + " td.shoe_release_month a");
    private static final By SHOE_IMAGE = By.cssSelector(SHOE_CONTAINER + " td.shoe_image img");

    public List<WebElement> getAllShoesList() {
        return this.findElements(SHOE_LIST_CONTAINER);
    }

    public String getShoeBrand(WebElement shoeContainer) {
        return this.getElementText(shoeContainer, SHOE_BRAND);
    }

    public String getShoeDescription(WebElement shoeContainer) {
        return this.getElementText(shoeContainer, SHOE_DESCRIPTION);
    }

    public String getShoeName(WebElement shoeContainer) {
        return this.getElementText(shoeContainer, SHOE_NAME);
    }

    public Integer getShoePrice(WebElement shoeContainer) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(this.getCurrentLocale());
        int price = -1;
        try {
            price = nf.parse(this.getElementText(shoeContainer, SHOE_PRICE)).intValue();
        } catch (Exception e) {

        }
        return price;
    }

    public String getShoeReleaseMonth(WebElement shoeContainer) {
        return this.getElementText(shoeContainer, SHOE_RELEASE_MONTH);
    }

    public Boolean hasShoeListing() {
        return !this.findElements(SHOE_LIST_CONTAINER).isEmpty();
    }

    public Boolean isShoeImageDisplayed(WebElement shoeContainer) {
        return this.isElementDisplayed(shoeContainer, SHOE_IMAGE);
    }
}
