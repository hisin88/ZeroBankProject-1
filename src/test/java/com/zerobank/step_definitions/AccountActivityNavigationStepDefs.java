package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityNavigationStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkText) {
        WebElement linkElement = null;

        switch(linkText){
            case "Savings":
                linkElement = new AccountSummaryPage().savingsLink;
                break;
            case "Brokerage":
                linkElement = new AccountSummaryPage().brokerageLink;
                break;
            case "Checking":
                linkElement = new AccountSummaryPage().checkingLink;
                break;
            case "Credit Card":
                linkElement = new AccountSummaryPage().creditCardLink;
                break;
            case "Loan":
                linkElement = new AccountSummaryPage().loanLink;
                break;
        }

        linkElement.click();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
        BrowserUtils.waitFor(1);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - " + pageName;
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedSelectedOption) {
        String actualSelectedOption = new AccountActivityPage().getSelectedOption();

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);
        System.out.println("actualSelectedOption = " + actualSelectedOption);
        System.out.println("expectedSelectedOption = " + expectedSelectedOption);
    }

}
