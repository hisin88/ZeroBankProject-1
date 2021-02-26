package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//div[@class='board'])[3]//th")
    public List<WebElement> creditAccountsHeaders;

    @FindBy(linkText = "Savings")
    public WebElement savingsLink;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerageLink;

    @FindBy(linkText = "Checking")
    public WebElement checkingLink;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCardLink;

    @FindBy(linkText = "Loan")
    public WebElement loanLink;

}
