package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(css =".alert.alert-error")
    public WebElement errorMessage;

    public void loginValid(){
        String usernameStr = ConfigurationReader.get("username");
        String passwordStr = ConfigurationReader.get("password");

        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();

        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);

        new HomePage().moreServicesBtn.click();

        new OnlineBankingPage().accountSummary.click();

    }

    public void login(String usernameStr, String passwordStr) {
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }

}
