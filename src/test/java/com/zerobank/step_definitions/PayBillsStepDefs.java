package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    @When("the user enters amount {string} date {string} description {string}")
    public void the_user_enters_amount_date_description(String amount, String date, String description) {
        PayBillsPage payBillsPage = new PayBillsPage();

        if(!amount.isEmpty()){
            int count = 0;
            for (int i = 0; i < amount.length() ; i++) {

                int eachNum = Integer.parseInt(""+amount.charAt(i));

                if(eachNum >= 0 && eachNum < 10){
                    count++;
                }
            }
            if(count == amount.length()){
                amount = amount;
            }
            payBillsPage.amount.sendKeys(amount);
        }

        if(!date.isEmpty()){
            int count = 0;
            for (int i = 0; i < amount.length(); i++) {
                if(!Character.isAlphabetic(date.charAt(i))){
                    count++;
                }
            }
            if(count == date.length()){
                date = date;
            }
            payBillsPage.date.sendKeys(date);
        }

        payBillsPage.description.sendKeys(description);

    }

    @And("the user clicks on the pay button")
    public void the_user_clicks_on_the_pay_button() {
        new PayBillsPage().payBtn.click();
    }

    @Then("the user should see the payment submitted message")
    public void the_user_should_see_the_payment_submitted_message() {
        String actualSubmitMessage = new PayBillsPage().submitMessage.getText();
        String expectedSubmitMessage = "The payment was successfully submitted.";

        Assert.assertEquals(expectedSubmitMessage,actualSubmitMessage);
    }

    @Then("the user should see the error message on {string} input box")
    public void the_user_should_see_the_error_message_on_input_box(String inputBoxName) {
        String actualErrorMessage = "";

        if(inputBoxName.equals("amount")){
            actualErrorMessage = new PayBillsPage().amount.getAttribute("validationMessage");
        }else if(inputBoxName.equals("date")){
            actualErrorMessage = new PayBillsPage().date.getAttribute("validationMessage");
        }

        String expectedErrorMessage = "Please fill out this field.";

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualErrorMessage = " + actualErrorMessage);
    }

}
