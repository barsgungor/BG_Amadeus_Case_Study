package com.flightsapp.pages;

import com.flightsapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsAppPage {

    public FlightsAppPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "headlessui-combobox-input-:Rq9lla:")
    public WebElement fromInput;

    @FindBy(id = "headlessui-combobox-input-:Rqhlla:")
    public WebElement toInput;

    @FindBy(className = "mb-10")
    public WebElement displayedNumber;

    @FindBy(xpath = "//ul/li/div")
    public List<WebElement> flightsList;

}
