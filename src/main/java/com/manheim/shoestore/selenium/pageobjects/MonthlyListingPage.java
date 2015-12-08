package com.manheim.shoestore.selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface MonthlyListingPage {

    List<WebElement> getAllShoesList();

    String getShoeBrand(WebElement shoeContainer);

    String getShoeDescription(WebElement shoeContainer);

    String getShoeName(WebElement shoeContainer);

    Integer getShoePrice(WebElement shoeContainer);

    String getShoeReleaseMonth(WebElement shoeContainer);

    Boolean hasShoeListing();

    Boolean isShoeImageDisplayed(WebElement shoeContainer);
}
