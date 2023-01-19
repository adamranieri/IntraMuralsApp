package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeUpdateHeightWeightStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);



    @When("the user types a new height that is ten inches in the height input")
    public void the_user_types_a_new_height_that_is_ten_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.clear();
        editUserProfilePage.heightInput.sendKeys("10");
    }


    @Then("an alert message box appears that gives a warning Invalid input")
    public void an_alert_message_box_appears_that_gives_a_warning_invalid_input() {
        // Write code here that turns the phrase above into concrete actions
        try {
//            new WebDriverWait(driver, Duration.ofSeconds(5))
//                    .until(ExpectedConditions.alertIsPresent());
            String alert_message = driver.switchTo().alert().getText();
            assertEquals("Invalid Input",alert_message);
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }


    @Then("there is an alert message that says Are you sure you want to edit your user profile?")
    public void there_is_an_alert_message_that_says_are_you_sure_you_want_to_edit_your_user_profile() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Are you sure you want to edit your user profile?", alertMessage);
    }

    @When("the user types a new height of zero inches in the height input")
    public void the_user_types_a_new_height_of_zero_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.clear();
        editUserProfilePage.heightInput.sendKeys("0");
    }

    @When("the user types a new height negative ten inches in the height input")
    public void the_user_types_a_new_height_negative_ten_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.clear();
        editUserProfilePage.heightInput.sendKeys("-10");
    }

    @When("the user types a new weight of ten pounds in the weight input")
    public void the_user_types_a_new_weight_of_ten_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.clear();
        editUserProfilePage.weightInput.sendKeys("10");
//
    }

    @When("the user types a new weight of zero pounds in the weight input")
    public void the_user_types_a_new_weight_of_zero_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.clear();
        editUserProfilePage.weightInput.sendKeys("0");
    }

    @When("the user types a new weight negative ten pounds in the weight input")
    public void the_user_types_a_new_weight_negative_ten_pounds_in_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.weightInput.clear();
        editUserProfilePage.weightInput.sendKeys("-10");
    }



}
