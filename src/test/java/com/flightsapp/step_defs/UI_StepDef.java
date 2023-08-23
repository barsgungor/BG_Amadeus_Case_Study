package com.flightsapp.step_defs;

import com.flightsapp.pages.FlightsAppPage;
import com.flightsapp.utilities.ConfigurationReader;
import com.flightsapp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class UI_StepDef {

    FlightsAppPage page = new FlightsAppPage();

    @Given("user is on the flights app")
    public void user_is_on_the_flights_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui_url"));

    }
    @When("user enters {string} in the From input field")
    public void user_enters_in_the_from_input_field(String input) {
        page.fromInput.sendKeys(input + Keys.ENTER);
    }
    @When("user enters {string} in the To input field")
    public void user_enters_in_the_to_input_field(String input) {
        page.toInput.sendKeys(input + Keys.ENTER);
    }
    @Then("the selected departure country should not be the same as the selected arrival country")
    public void the_selected_departure_country_should_not_be_the_same_as_the_selected_arrival_country() {
        assertNotEquals(page.fromInput.getText(), page.toInput.getText());
    }

    @Then("the available flight count should match the displayed number")
    public void the_available_flight_count_should_match_the_displayed_number() {
        int actualNumber = Integer.parseInt(page.displayedNumber.getText().substring(page.displayedNumber.getText().indexOf(" ")+1,page.displayedNumber.getText().lastIndexOf(" ")));
        int expectedNumber = page.flightsList.size();
        assertEquals(actualNumber,expectedNumber);
    }

}
