package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFunds;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;

    @FindBy(id = "money_map_tab")
    public WebElement moneyMap;

    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatements;


    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateTo(String pageName){

        if(pageName.equals("Account Summary")){
            accountSummary.click();
        }else if(pageName.equals("Account Activity")){
            accountActivity.click();
        }else if(pageName.equals("Transfer Funds")){
            transferFunds.click();
        }else if(pageName.equals("Pay Bills")){
            payBills.click();
        }else if(pageName.equals("Money Map")){
            moneyMap.click();
        }else if(pageName.equals("Online Statements")){
            onlineStatements.click();
        }

    }

}
