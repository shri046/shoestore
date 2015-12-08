package com.manheim.shoestore.selenium.pageobjects.impl;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manheim.shoestore.selenium.pageobjects.HomePage;
import com.manheim.shoestore.selenium.pageobjects.MonthlyListingPage;
import com.manheim.shoestore.selenium.pageobjects.modules.HeaderModule;

@Component
public class ShoeStoreHomePage implements HomePage {

    @Autowired
    private HeaderModule headerModule;

    @Autowired
    private MonthlyListingPage monthlyListing;

    public HeaderModule getHeader() {
        return this.headerModule;
    }

    public String getInvidualListingBrand(WebElement individualListing) {
        return this.monthlyListing.getShoeBrand(individualListing);
    }

    public String getInvidualListingShoeBrand(WebElement individualListing) {
        return this.monthlyListing.getShoeBrand(individualListing);
    }

    public String getInvidualListingShoeDescription(WebElement individualListing) {
        return this.monthlyListing.getShoeDescription(individualListing);
    }

    public String getInvidualListingShoeName(WebElement individualListing) {
        return this.monthlyListing.getShoeName(individualListing);
    }

    public Integer getInvidualListingShoePrice(WebElement individualListing) {
        return this.monthlyListing.getShoePrice(individualListing);
    }

    public String getInvidualListingShoeReleaseMonth(WebElement individualListing) {
        return this.monthlyListing.getShoeReleaseMonth(individualListing);
    }

    public MonthlyListingPage getMonthlyListing() {
        return this.monthlyListing;
    }

    public Boolean hasIndividualListings() {
        return this.monthlyListing.hasShoeListing();
    }

    public Boolean isInvidualListingShoeImageDisplayed(WebElement individualListing) {
        return this.monthlyListing.isShoeImageDisplayed(individualListing);
    }
}
