package com.manheim.shoestore;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manheim.shoestore.selenium.ShoeStoreTestBase;
import com.manheim.shoestore.selenium.pageobjects.HomePage;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReminderEmailTest extends ShoeStoreTestBase {

    @Autowired
    HomePage homePage;

    @Before
    public void setup() {
        this.navigateTo("http://shoestore-manheim.rhcloud.com");
    }

    private String submitEmail(String email) {
        this.homePage.getHeader().submitEmailAddress(email);
        String flashMessage = this.homePage.getHeader().getFlashMessage();
        return flashMessage;
    }

    @Test
    public void verifyEmailFieldIsDisplayed() {
        assertThat(this.homePage.getHeader().isRemindEmailInputDisplayed()).overridingErrorMessage("Expected reminder email input to be displayed in header.").isTrue();
    }

    @Test
    public void verifyInvalidEmailSubmission() {
        String email = "invalidemail";

        String flashMessage = this.submitEmail(email);

        assertThat(flashMessage).overridingErrorMessage("Expected error message to be displayed for invalid user email address '%s' to be present in flash message", email)
                .isNotEqualTo("Thanks! We will notify you of our new shoes at this email: ".concat(email));
    }

    @Test
    public void verifyValidEmailSubmission() {
        String email = "myemail@somesite.com";

        String flashMessage = this.submitEmail(email);

        assertThat(flashMessage).overridingErrorMessage("Expected user email address %s to be present in flash message", email).isEqualTo(
                "Thanks! We will notify you of our new shoes at this email: ".concat(email));
    }
}
