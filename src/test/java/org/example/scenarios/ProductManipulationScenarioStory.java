package org.example.scenarios;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("features.login/test_data.csv")
public class ProductManipulationScenarioStory {

    @Managed(uniqueSession = true, driver = "firefox")
    WebDriver driver;

    @Steps
    EndUserSteps user;

    @Test
    public void test_login() {
        user.opens_home_page();
        user.logs_in("validUsername", "validPassword");
        user.should_see_account_overview();
    }

    @Test
    public void test_open_new_account() {
        user.opens_home_page();
        user.logs_in("validUsername", "validPassword");
        user.open_new_account();
    }

    @Test
    public void test_transfer_funds() {
        user.opens_home_page();
        user.logs_in("validUsername", "validPassword");
        user.transfer_funds("100", "12345", "67890");
        user.should_see_transfer_confirmation();
    }

    @Test
    public void test_scenario_based_testing() {
        user.opens_home_page();
        user.logs_in("validUsername", "validPassword");
        user.open_new_account();
        user.transfer_funds("100", "12345", "67890");
        user.should_see_transfer_confirmation();
    }
}