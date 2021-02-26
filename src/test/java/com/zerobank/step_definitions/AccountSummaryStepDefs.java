package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @Then("the page should have the title {string}")
    public void the_page_should_have_the_title(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user should see the following options")
    public void the_user_should_see_the_following_options(List<String> expectedAccountTypes) {
        BrowserUtils.waitFor(2);
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);

        System.out.println("expectedAccountTypes = " + expectedAccountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);
    }

    @Then("the user should see the following options under Credit Accounts")
    public void the_user_should_see_the_following_options_under_Credit_Accounts(List<String> expectedColumnHeaders) {
        BrowserUtils.waitFor(2);
        List<String> actualColumnHeaders = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsHeaders);
        Assert.assertEquals(expectedColumnHeaders,actualColumnHeaders);

        System.out.println("actualColumnHeaders = " + actualColumnHeaders);
        System.out.println("expectedColumnHeaders = " + expectedColumnHeaders);
    }
}
