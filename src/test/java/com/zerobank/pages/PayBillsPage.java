package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{


    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(css = "#alert_content>span")
    public WebElement submitMessage;

    @FindBy(css = "")
    public WebElement errorMessage;


}
