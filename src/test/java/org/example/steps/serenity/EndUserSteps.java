package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.ParabankPage;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EndUserSteps {
    public EndUserSteps() {
    }

    ParabankPage parabankPage;

    @Step
    public void opens_home_page() {
        parabankPage.open();
    }

    @Step
    public void logs_in(String username, String password) {
        parabankPage.enterUsername(username);
        parabankPage.enterPassword(password);
        parabankPage.clickLoginButton();
    }

    @Step
    public void should_see_account_overview() {
        assertTrue(parabankPage.isAccountOverviewVisible());
    }

    @Step
    public void open_new_account() {
        parabankPage.clickOpenNewAccount();
        parabankPage.selectAccountType("SAVINGS");
        parabankPage.clickOpenNewAccountButton();
    }

    @Step
    public void transfer_funds(String amount, String fromAccount, String toAccount) {
        parabankPage.clickTransferFunds();
        parabankPage.enterAmount(amount);
        parabankPage.selectFromAccount(fromAccount);
        parabankPage.selectToAccount(toAccount);
        parabankPage.clickTransferButton();
    }

    @Step
    public void should_see_transfer_confirmation() {
        assertTrue(parabankPage.isTransferConfirmationVisible());
    }

    @Step
    public void should_see_login_error() {
        assertTrue(parabankPage.isLoginErrorVisible());
    }
}
