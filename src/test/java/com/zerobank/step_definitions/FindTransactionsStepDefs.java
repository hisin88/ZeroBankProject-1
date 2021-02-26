package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startingDate, String finishingDate) {
        new AccountActivityPage().fromDateInputBox.clear();
        new AccountActivityPage().fromDateInputBox.sendKeys(startingDate);
        new AccountActivityPage().toDateInputBox.clear();
        new AccountActivityPage().toDateInputBox.sendKeys(finishingDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        //convert the given parameters to date format using the method in the page
        Date startDate = new AccountActivityPage().convertDate(fromDate);
        Date endDate = new AccountActivityPage().convertDate(toDate);
        //for each date text in the list
        for(String date : new AccountActivityPage().datesText){
            //convert it to date format
            Date actualDate = new AccountActivityPage().convertDate(date);
            //use compareTo method which is used to compare the dates
            //if it is less than the other date, means it is before than that day
            Assert.assertTrue(actualDate.compareTo(startDate) >= 0);
            Assert.assertTrue(actualDate.compareTo(endDate) <= 0);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        //for each date text in the page
        for (int i = 0; i < new AccountActivityPage().datesText.size()-1 ; i++) {
            //convert the i th index to date format
            Date actualDate1 = new AccountActivityPage().convertDate(new AccountActivityPage().datesText.get(i));
            //convert the i+1 th index to date format
            Date actualDate2 = new AccountActivityPage().convertDate(new AccountActivityPage().datesText.get(i+1));
            //and compare them
            Assert.assertTrue(actualDate1.compareTo(actualDate2) >= 0);
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String dateNotExpected) {
        for(String date : new AccountActivityPage().datesText){
            Assert.assertFalse(date.contains(dateNotExpected));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        new AccountActivityPage().description.clear();
        new AccountActivityPage().description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        //verify each description text includes the parameter description
        for(String descriptionText : new AccountActivityPage().descriptionsText){
            Assert.assertTrue(descriptionText.contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        //verify any of the description texts do not include the parameter description
        for(String descriptionText : new AccountActivityPage().descriptionsText){
            Assert.assertFalse(descriptionText.contains(description));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(new AccountActivityPage().deposits.size() >= 1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().withdrawals.size() >= 1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String option) {
        Select dropdown = new Select(new AccountActivityPage().typeDropdown);
        dropdown.selectByVisibleText(option);
        clicks_search();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> withdrawalsText = BrowserUtils.getElementsText(new AccountActivityPage().withdrawals);
        for(String withdrawal : withdrawalsText){
            Assert.assertEquals("", withdrawal);
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> depositsText = BrowserUtils.getElementsText(new AccountActivityPage().deposits);
        for(String deposit : depositsText){
            Assert.assertEquals("", deposit);
        }
    }
}
