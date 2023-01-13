package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeUpdateHeightWeightStepImpl {

    public static WebDriver driver = JSXrunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


//    @When("the user types a new height {string} inches in the height input")
//    public void the_user_types_a_new_height_inches_in_the_height_input(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        editUserProfilePage.heightInput.sendKeys("");
//    }


    @Given("The user is on the User Edit Page")
    public void the_user_is_on_the_user_edit_page() {
        // Write code here that turns the phrase above into concrete actions
        optionPage.editUserProfileButton.click();
        String title = driver.getTitle();
        assertEquals("User Profile",title);
    }


    @When("the user types a new height that is ten inches in the height input")
    public void the_user_types_a_new_height_that_is_ten_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.sendKeys("10");
    }

    @When("the user clicks on the Submit button")
    public void the_user_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.submitButton.click();
    }

    @Then("there is an alert message that says Are you sure you want to edit your user profile?")
    public void there_is_an_alert_message_that_says_are_you_sure_you_want_to_edit_your_user_profile() {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }

    @Then("the user clicks OK")
    public void the_user_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }

    @Then("an alert message box appears that gives a warning Invalid input")
    public void an_alert_message_box_appears_that_gives_a_warning_invalid_input() {
        // Write code here that turns the phrase above into concrete actions
        try {
            String alert_message = driver.switchTo().alert().getText();
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }

    @When("the user types a new height of zero inches in the height input")
    public void the_user_types_a_new_height_of_zero_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.sendKeys("0");
    }

    @When("the user types a new height negative ten inches in the height input")
    public void the_user_types_a_new_height_negative_ten_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.sendKeys("-10");
    }

    @When("the user types a new weight of ten pounds in the weight input")
    public void the_user_types_a_new_weight_of_ten_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.sendKeys("10");
    }

    @When("the user types a new weight of zero pounds in the weight input")
    public void the_user_types_a_new_weight_of_zero_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.sendKeys("0");
    }

    @When("the user types a new weight negative ten pounds in the weight input")
    public void the_user_types_a_new_weight_negative_ten_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.sendKeys("-10");
    }



}
