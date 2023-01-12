package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeStepImpl {

    public static WebDriver driver = JSXrunner.driver;
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();
    }

    @When("The user types asdfasdf into username input")
    public void the_user_types_asdfasdf_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys("asdfasdf");
    }

    @When("The user types asdfadsf into password input")
    public void the_user_types_asdfadsf_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys("asdfasdf");
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.loginButton.click();
    }


//  S.R.S. 5.1.2.  The user experience should be as straightforward as possible.
    @Then("the user should get an alert message indicating incorrect credentials")
    public void the_user_should_get_an_alert_message_indicating_incorrect_credentials() {

        try {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }
    }


    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertEquals("Login",title);
    }

}
