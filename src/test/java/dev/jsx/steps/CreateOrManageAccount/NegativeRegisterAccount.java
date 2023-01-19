package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.pages.RegisterPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeRegisterAccount {


    public static WebDriver driver = TestRunner.driver;
    MainPage mainPage = new MainPage(driver);

    RegisterPage registerPage = new RegisterPage(driver);

    OptionPage optionPage = new OptionPage(driver);




    @Then("the user should get an alert message that this username is already registered")
    public void the_user_should_get_an_alert_message_that_this_username_is_already_registered() {
        // Write code here that turns the phrase above into concrete actions
        try {
            String alertMessage = driver.switchTo().alert().getText();
            assertEquals("Username already exists!",alertMessage);
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }

    @Then("the user should remain on the register page")
    public void the_user_should_remain_on_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertEquals("Register", title);
    }

    @When("The user types Testuser9009 into username input")
    public void the_user_types_testuser9009_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        registerPage.usernameInput.sendKeys("Testuser9009");
    }



}
