package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionHeaders;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInputBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInputBox;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> transactionDates;

    //get the text of the dates
    public List<String> datesText = BrowserUtils.getElementsText(transactionDates);

    @FindBy(css = "#aa_description")
    public WebElement description;

    @FindBy(xpath = "(//tbody)[2]/tr/td[2]")
    public List<WebElement> descriptions;

    //get the text of the descriptions
    public List<String> descriptionsText = BrowserUtils.getElementsText(descriptions);

    @FindBy(css = "#aa_type")
    public WebElement typeDropdown;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> deposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> withdrawals;


    //this method converts a string to a date
    //accepts String and returns a date format
    public Date convertDate(String date){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = null;
        try{
            dateFormat = fmt.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return dateFormat;
    }








    public String getSelectedOption(){
        Select dropdown = new Select(dropdownMenu);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        return selectedOption;
    }









}
