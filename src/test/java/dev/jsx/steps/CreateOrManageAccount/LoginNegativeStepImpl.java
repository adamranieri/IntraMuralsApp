package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
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

import static dev.jsx.runners.TestRunner.driver;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeStepImpl {

    public static WebDriver driver = TestRunner.driver;
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


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


    @When("The user types blank into username input")
    public void the_user_types_blank_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //intentionally left blank
    }

    @When("The user types pass123 into password input")
    public void the_user_types_pass123_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys("pass123");
    }

    @When("The user types TopDawg into username input")
    public void the_user_types_top_dawg_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys("TopDawg");
    }

    @When("The user types blank into password input")
    public void the_user_types_blank_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        // intentionally left blank
    }



//  S.R.S. 5.1.2.  The user experience should be as straightforward as possible.
    @Then("the user should get an alert message indicating incorrect credentials")
    public void the_user_should_get_an_alert_message_indicating_incorrect_credentials() {

        try {
//            new WebDriverWait(driver, Duration.ofSeconds(5))
//                    .until(ExpectedConditions.alertIsPresent());
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
