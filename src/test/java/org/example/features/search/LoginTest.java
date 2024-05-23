package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("features.login/login_test_data.csv")
public class LoginTest {
    public LoginTest() {
    }

    @Managed(uniqueSession = true, driver = "firefox")
    WebDriver driver;

    @Steps
    EndUserSteps user;

    private String username;
    private String password;
    private boolean isValid;


    @Before
    public void setUp() {
        user.opens_home_page();
    }

    @Test
    public void test_login() {
        user.logs_in(username, password);
        if (isValid) {
            user.should_see_account_overview();
        } else {
            user.should_see_login_error();
        }
    }
}