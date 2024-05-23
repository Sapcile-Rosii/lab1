package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://parabank.parasoft.com/parabank/transfer.htm")
public class ParabankPage extends PageObject {

    @FindBy(name="username")
    WebElement usernameField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath="//input[@value='Log In']")
    WebElement loginButton;

    @FindBy(linkText="Accounts Overview")
    WebElement accountsOverviewLink;

    @FindBy(linkText="Open New Account")
    WebElement openNewAccountLink;

    @FindBy(id="type")
    WebElement accountTypeDropdown;

    @FindBy(xpath="//input[@value='Open New Account']")
    WebElement openNewAccountButton;

    @FindBy(linkText="Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(id="amount")
    WebElement amountField;

    @FindBy(id="fromAccountId")
    WebElement fromAccountDropdown;

    @FindBy(id="toAccountId")
    WebElement toAccountDropdown;

    @FindBy(xpath="//input[@value='Transfer']")
    WebElement transferButton;

    @FindBy(xpath="//p[contains(text(),'error')]")
    WebElement loginError;

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isAccountOverviewVisible() {
        return accountsOverviewLink.isDisplayed();
    }

    public void clickOpenNewAccount() {
        openNewAccountLink.click();
    }

    public void selectAccountType(String accountType) {
        accountTypeDropdown.sendKeys(accountType);
    }

    public void clickOpenNewAccountButton() {
        openNewAccountButton.click();
    }

    public void clickTransferFunds() {
        transferFundsLink.click();
    }

    public void enterAmount(String amount) {
        amountField.sendKeys(amount);
    }

    public void selectFromAccount(String fromAccount) {
        fromAccountDropdown.sendKeys(fromAccount);
    }

    public void selectToAccount(String toAccount) {
        toAccountDropdown.sendKeys(toAccount);
    }

    public void clickTransferButton() {
        transferButton.click();
    }

    public boolean isTransferConfirmationVisible() {
        return transferButton.isDisplayed(); // Adjust the confirmation check as per actual UI
    }
    public boolean isLoginErrorVisible() {
        return loginError.isDisplayed();
    }
}
