package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutStepImpl {

    public static WebDriver driver = JSXrunner.driver;
    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);



    @Given("the user is logged in as a player")
    public void the_user_is_logged_in_as_a_player() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();
        loginPage.usernameInput.sendKeys("margo23");
        loginPage.passwordInput.sendKeys("eCItXyih");
        loginPage.loginButton.click();
    }

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertEquals("User Page",title);
    }

    @When("The user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        optionPage.logoutButton.click();
    }

    @Then("the user should return to the login page")
    public void the_user_should_return_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertEquals("Login",title);
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


}
