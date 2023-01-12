package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPositiveStepImpl {

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

    @When("The user types {string} into username input")
    public void the_user_types_into_username_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys(string);
    }

    @When("The user types {string} into password input")
    public void the_user_types_into_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys(string);
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.loginButton.click();
    }

    @Then("the user should be on the User Page")
    public void the_user_should_be_on_the_user_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        assertEquals("User Page",title);
    }

    @Then("The user should see their name {string} on the home page")
    public void the_user_should_see_their_name_on_the_home_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        String userRole = optionPage.roleTextInfo.getText();
        String STwo = string + " Page";
        assertEquals(userRole, STwo);
    }


}
