package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.pages.RegisterPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveRegisterAccount {


    public static WebDriver driver = TestRunner.driver;
    MainPage mainPage = new MainPage(driver);

    RegisterPage registerPage = new RegisterPage(driver);

    OptionPage optionPage = new OptionPage(driver);

    @Given("The user is on the register page")
    public void the_user_is_on_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");

        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(mainPage.registerLink)).click();
    }


    @When("The user types Testuser111 into username input")
    public void the_user_types_testuser111_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        registerPage.usernameInput.sendKeys("Testuser111");
    }

    @When("The user types password111 into password input")
    public void the_user_types_password111_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        registerPage.passwordInput.sendKeys("password111");
    }

    @When("The user clicks on the register button")
    public void the_user_clicks_on_the_register_button() {
        // Write code here that turns the phrase above into concrete actions
        registerPage.submitFormButton.click();
    }

    @Then("the user gets an alert message Registration Successful")
    public void the_user_gets_an_alert_message_registration_successful() {
        // Write code here that turns the phrase above into concrete actions
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent());
            String alertMessage = driver.switchTo().alert().getText();
//            System.out.println(alertMessage);
            assertEquals("Registration successful!",alertMessage);
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }


    @Then("user clicks accept button on the alert message")
    public void user_clicks_accept_button_on_the_alert_message() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }

    @Then("The user should see their name Testuser111 on the home page")
    public void the_user_should_see_their_name_testuser111_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        String username = optionPage.usernameTextInfo.getText();
        assertEquals("Welcome, Testuser111!",username);
    }



}
