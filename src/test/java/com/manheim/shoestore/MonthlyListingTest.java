package com.manheim.shoestore;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manheim.shoestore.selenium.ShoeStoreTestBase;
import com.manheim.shoestore.selenium.pageobjects.HomePage;
import com.manheim.shoestore.selenium.pageobjects.utils.MonthNames;

@RunWith(SpringJUnit4ClassRunner.class)
public class MonthlyListingTest extends ShoeStoreTestBase {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Autowired
    HomePage homePage;

    private void logItemDetails(WebElement shoe) {
        this.getLogger().debug("Shoe brand: {}", this.homePage.getInvidualListingShoeBrand(shoe));
        this.getLogger().debug("Shoe desc: {}", this.homePage.getInvidualListingShoeDescription(shoe));
        this.getLogger().debug("Shoe name: {}", this.homePage.getInvidualListingShoeName(shoe));
        this.getLogger().debug("Shoe release month: {}", this.homePage.getInvidualListingShoeReleaseMonth(shoe));
        this.getLogger().debug("Shoe image displayed: {}", this.homePage.isInvidualListingShoeImageDisplayed(shoe).toString());
        this.getLogger().debug("Shoe price: {}", this.homePage.getInvidualListingShoePrice(shoe));
    }

    private void valiateMonthlyListing(MonthNames monthName) {
        for (WebElement shoe : this.homePage.getMonthlyListing().getAllShoesList()) {
            String itemDescription = this.homePage.getInvidualListingShoeDescription(shoe);
            String itemName = this.homePage.getInvidualListingShoeName(shoe);
            Boolean isImageDisplayedForItem = this.homePage.isInvidualListingShoeImageDisplayed(shoe);
            Integer itemPrice = this.homePage.getInvidualListingShoePrice(shoe);

            this.logItemDetails(shoe);

            try {
                assertThat(itemDescription).overridingErrorMessage("Expected non-empty description for item %s displayed on %s shoes page. Actual description was %s",
                        new Object[] { itemName, monthName, itemDescription }).isNotEmpty();

                assertThat(isImageDisplayedForItem).overridingErrorMessage("Expected image to be displayed for item %s displayed on %s shoes page.",
                        new Object[] { itemName, monthName }).isTrue();

                assertThat(itemPrice).overridingErrorMessage("Expected shoe price to be greater than zero but was %s for item %s on %s shoes page.",
                        new Object[] { itemPrice, itemName, monthName }).isGreaterThan(0);
            } catch (AssertionError ae) {
                this.collector.addError(ae);
            }
        }
    }

    @Test
    public void validateHomePage() {
        this.navigateTo("http://shoestore-manheim.rhcloud.com");

        for (MonthNames monthName : MonthNames.values()) {
            this.homePage.getHeader().clickMonth(monthName);

            this.getLogger().info("Validating listings for the month of {}", monthName);

            if (this.homePage.hasIndividualListings()) {
                this.valiateMonthlyListing(monthName);
            } else {
                this.getLogger().info("No items found on {} shoes page, skipping validations assuming no shoes have been added to this month yet.", monthName);
            }
        }
    }
}
