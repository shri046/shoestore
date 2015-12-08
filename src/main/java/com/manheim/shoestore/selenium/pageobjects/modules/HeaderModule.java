package com.manheim.shoestore.selenium.pageobjects.modules;

import com.manheim.shoestore.selenium.pageobjects.utils.MonthNames;

public interface HeaderModule {

    void clickMonth(MonthNames month);

    String getFlashMessage();

    Boolean isRemindEmailInputDisplayed();

    void submitEmailAddress(String email);
}
