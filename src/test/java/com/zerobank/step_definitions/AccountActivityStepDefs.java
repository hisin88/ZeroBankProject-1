package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String pageName) {
        new BasePage().navigateTo(pageName);
    }

    @Then("the Account drop down default option should be {string}")
    public void the_Account_drop_down_default_option_should_be(String defaultOption) {

        Select dropdownElement = new Select(new AccountActivityPage().dropdownMenu);
        String actualDefaultOption = dropdownElement.getFirstSelectedOption().getText();

        Assert.assertEquals(defaultOption,actualDefaultOption);
    }

    @Then("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> dropdownOptions) {
        Select dropdownElement = new Select(new AccountActivityPage().dropdownMenu);

        List<String> actualOptions = BrowserUtils.getElementsText(dropdownElement.getOptions());

        Assert.assertEquals(dropdownOptions,actualOptions);
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("dropdownOptions = " + dropdownOptions);
    }

    @Then("the Transaction Table should have the following column names")
    public void the_Transaction_Table_should_have_the_following_column_names(List<String> columnNames) {
        BrowserUtils.waitFor(2);
        List<String> actualColumnNames = BrowserUtils.getElementsText(new AccountActivityPage().transactionHeaders);

        Assert.assertEquals(columnNames,actualColumnNames);
        System.out.println("columnNames = " + columnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);

    }
}
