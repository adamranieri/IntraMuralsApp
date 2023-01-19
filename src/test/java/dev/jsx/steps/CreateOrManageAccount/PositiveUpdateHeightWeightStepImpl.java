package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveUpdateHeightWeightStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);

    @When("the user types a new height seventy five inches in the height input")
    public void the_user_types_a_new_height_seventy_five_inches_in_the_height_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.clear();
        editUserProfilePage.heightInput.sendKeys("75");
    }

    @Then("an alert message box appears that says Update successful!")
    public void an_alert_message_box_appears_that_says_update_successful() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Update successful!", alertMessage);
    }

    @Then("the input for height remains seventy five inches")
    public void the_input_for_height_remains_seventy_five_inches() {
        // Write code here that turns the phrase above into concrete actions
        String height =  editUserProfilePage.heightInput.getAttribute("value");
        assertEquals("75",height);
    }

    @When("the user types a new weight one hundred eighty into the weight input")
    public void the_user_types_a_new_weight_one_hundred_eighty_into_the_weight_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.heightInput.clear();
        editUserProfilePage.heightInput.sendKeys("180");
    }

    @Then("the input for weight remains one hundred eighty inches")
    public void the_input_for_weight_remains_one_hundred_eighty_inches() {
        // Write code here that turns the phrase above into concrete actions
        String height =  editUserProfilePage.heightInput.getAttribute("value");
        assertEquals("180",height);
    }



}
