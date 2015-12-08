package com.manheim.shoestore.selenium.pageobjects;

import org.openqa.selenium.WebElement;

import com.manheim.shoestore.selenium.pageobjects.modules.HeaderModule;

public interface HomePage {

    HeaderModule getHeader();

    String getInvidualListingShoeBrand(WebElement individualListing);

    String getInvidualListingShoeDescription(WebElement individualListing);

    String getInvidualListingShoeName(WebElement individualListing);

    Integer getInvidualListingShoePrice(WebElement individualListing);

    String getInvidualListingShoeReleaseMonth(WebElement individualListing);

    MonthlyListingPage getMonthlyListing();

    Boolean hasIndividualListings();

    Boolean isInvidualListingShoeImageDisplayed(WebElement individualListing);

}
