package com.nuna.step_definitions;

import com.nuna.pages.GoogleTranslate_Page;
import com.nuna.utility.ConfigReader;
import com.nuna.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class Google_Translate {
    GoogleTranslate_Page translate = new GoogleTranslate_Page();

    @Given("as a User I login into Google Translate Application {string}")
    public void as_a_user_i_login_into_google_translate_application(String url) {
        translate.login(url);
    }

    @Then("I should be successfully logged into the application")
    public void i_should_be_successfully_logged_into_the_application() {
        Assert.assertEquals("Google Translate", Driver.getDriver().getTitle());
    }

    @Then("I select {string} from the drop-down menu on the left")
    public void i_select_from_the_drop_down_menu_on_the_left(String string) {
        translate.selectLanguageFromLeft(ConfigReader.read(string));
    }

    @Then("I verify the {string} displayed on the left side")
    public void i_verify_the_displayed_on_the_left_side(String string) {
        translate.leftLanguageSelectedCorrectly(string);
    }

    @Then("I select {string} from the drop-down menu on the right")
    public void i_select_from_the_drop_down_menu_on_the_right(String string) {
        translate.selectLanguageFromRight(ConfigReader.read(string));
    }

    @Then("I verify the {string} displayed on the right side")
    public void i_verify_the_displayed_on_the_right_side(String string) {
        translate.rightLanguageSelectedCorrectly(string);
    }

    @When("I enter the {string} in the input field on the left")
    public void i_enter_the_in_the_input_field_on_the_left(String string) {
        translate.interText(string);
    }

    @Then("The {string} should display as expected")
    public void the_should_display_as_expected(String string) {
        Assert.assertEquals(ConfigReader.read(string), translate.responseText());
    }

    @Then("I click swap languages button")
    public void i_click_swap_languages_button() {
        translate.clickSwapLanguageBtn();
    }

    @Then("I verify the result")
    public void i_verify_the_result() {
        System.out.println(translate.responseText());
    }

    @Then("I cleared the input field")
    public void i_cleared_the_input_field() {
        translate.clearInputField();
    }

    @Then("I verify that input is empty")
    public void i_verify_that_input_is_empty() {
        Assert.assertTrue(translate.inputFieldIsEmpty());
    }

    @Then("I click <select input tool> button and select <screen keyboard>")
    public void i_click_button_and_select() {
        translate.selectInputBtn();
    }

    @Then("I enter <Hi> to input field")
    public void i_enter_to_input_field() {
        translate.typeHi();
    }

    @Then("I verify that {string} is displayed in the input field")
    public void i_verify_that_is_displayed_in_the_input_field(String string) {
        Assert.assertEquals(string, translate.inputText());
    }

}
