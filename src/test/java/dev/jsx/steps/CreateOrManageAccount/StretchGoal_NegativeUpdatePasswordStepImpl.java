package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StretchGoal_NegativeUpdatePasswordStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage  = new EditUserProfilePage(driver);
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


    @When("the user clears the password input")
    public void the_user_clears_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.passwordInput.clear();
    }

    @Then("an alert message box that shows unsuccess")
    public void an_alert_message_box_that_shows_unsuccess() {
        // Write code here that turns the phrase above into concrete actions
        String alertMessage = driver.switchTo().alert().getText();
    }


}
