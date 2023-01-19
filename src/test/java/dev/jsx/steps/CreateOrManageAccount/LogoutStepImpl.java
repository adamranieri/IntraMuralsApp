package dev.jsx.steps.CreateOrManageAccount;

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

public class LogoutStepImpl {

    public static WebDriver driver = TestRunner.driver;
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);



    @Given("the user is logged in as a player")
    public void the_user_is_logged_in_as_a_player() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.loginLink)).click();

        loginPage.usernameInput.sendKeys("margo23");
        loginPage.passwordInput.sendKeys("eCItXyih");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

    }

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionPage.roleTextInfo));
        String title = driver.getTitle();
        assertEquals("User Page",title);
    }

    @When("The user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionPage.logoutButton)).click();
    }





    @Given("the user is logged in as a captain")
    public void the_user_is_logged_in_as_a_captain() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();
        loginPage.usernameInput.sendKeys("Bobby202");
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();
    }

    @Given("the user is logged in as an admin")
    public void the_user_is_logged_in_as_an_admin() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();
        loginPage.usernameInput.sendKeys("gatorFan99");
        loginPage.passwordInput.sendKeys("chomp!!");
        loginPage.loginButton.click();
    }

    @Given("the user is logged in as a referee")
    public void the_user_is_logged_in_as_a_referee() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();
        loginPage.usernameInput.sendKeys("cindy101");
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();
    }


    @Then("the user should return to the index page")
    public void the_user_should_return_to_the_index_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.loginLink));
        String title = driver.getTitle();
        assertEquals("Welcome!",title);
    }


}
