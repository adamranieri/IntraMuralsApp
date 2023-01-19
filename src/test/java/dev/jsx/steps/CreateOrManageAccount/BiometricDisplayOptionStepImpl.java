package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dev.jsx.runners.TestRunner.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiometricDisplayOptionStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage  = new EditUserProfilePage(driver);
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


    // logs in player Bobby202 who is a player and captain
    @Given("The user is logged in as player")
    public void the_user_is_logged_in_as_player() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();

        loginPage.usernameInput.sendKeys("Bobby202");
        loginPage.passwordInput.sendKeys("pass123");

        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionPage.usernameTextInfo));

//        System.out.println("player logged in");

    }


    @Given("The user is on the User Edit Page")
    public void the_user_is_on_the_user_edit_page() {

//        System.out.println("user on edit page function");

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionPage.usernameTextInfo));

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(optionPage.editUserProfileButton)).click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(editUserProfilePage.submitButton));
    }

    @When("the user clicks on the Display Biometrics checkbox")
    public void the_user_clicks_on_the_display_biometrics_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.biometricsCheckbox.click();
    }

    @Then("the user clicks on the Submit button")
    public void the_user_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.submitButton.click();
    }

    @Then("there is an alert message that asks user to confirm")
    public void there_is_an_alert_message_that_asks_user_to_confirm() {
        // Write code here that turns the phrase above into concrete actions
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Are you sure you want to edit your user profile?", alertMessage);
    }

    @Then("the user clicks OK")
    public void the_user_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }

    @Then("an alert message box appears that says update was successful")
    public void an_alert_message_box_appears_that_says_update_was_successful() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Update successful!", alertMessage);
    }

    @Then("click OK")
    public void click_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }


}
