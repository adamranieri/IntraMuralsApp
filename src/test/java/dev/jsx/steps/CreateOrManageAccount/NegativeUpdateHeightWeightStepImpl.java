package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeUpdateHeightWeightStepImpl {

    public static WebDriver driver = JSXrunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions


    }

    @Given("The user is on the User Edit Page")
    public void the_user_is_on_the_user_edit_page() {
        // Write code here that turns the phrase above into concrete actions
        optionPage.editUserProfileButton.click();
        String title = driver.getTitle();
        assertEquals("User Profile",title);
    }

    @When("the user types a new height {string} inches in the height input")
    public void the_user_types_a_new_height_inches_in_the_height_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.sendKeys("     ");
    }

    @When("the user clicks on the Submit button")
    public void the_user_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("there is an alert message that says {string}")
    public void there_is_an_alert_message_that_says(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user clicks OK")
    public void the_user_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an alert message box appears that gives a warning {string}")
    public void an_alert_message_box_appears_that_gives_a_warning(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user types a new weight {string} pounds in the weight input")
    public void the_user_types_a_new_weight_pounds_in_the_weight_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
