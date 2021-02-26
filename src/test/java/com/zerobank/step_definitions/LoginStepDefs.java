package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        new LoginPage().loginValid();
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        the_user_is_on_the_login_page();
        the_user_enters_valid_username_and_password();
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String pageTitle) {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - " + pageTitle;
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {

        if(username.equals("wrong username") && password.equals("valid password")){
            username = "Mehmet";
            password = ConfigurationReader.get("password");
            new LoginPage().login(username,password);
        }else if(username.equals("valid username") && password.equals("wrong password")){
            username = ConfigurationReader.get("username");
            password = "1234";
            new LoginPage().login(username,password);
        }else if(username.equals("blank username")){
            username = "";
            password = ConfigurationReader.get("password");
            new LoginPage().login(username,password);
        }else if(password.equals("blank password")){
            username = ConfigurationReader.get("username");
            password = "";
            new LoginPage().login(username,password);
        }
    }

    @Then("error message should be displayed.")
    public void error_message_should_be_displayed() {
        String actaulMessage = new LoginPage().errorMessage.getText();
        String expectedmessage = "Login and/or password are wrong.";

        Assert.assertEquals(expectedmessage,actaulMessage);
    }



}
