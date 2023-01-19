package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PositiveUpdateProfilePictureStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);


    @When("the user selects the profile picture text input")
    public void the_user_selects_the_profile_picture_text_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.pictureInput.clear();
    }


    @Then("the user pastes the url for an image")
    public void the_user_pastes_the_url_for_an_image() {
        // Write code here that turns the phrase above into concrete actions
//        editUserProfilePage.pictureInput.clear();
        editUserProfilePage.pictureInput.sendKeys("https://s-i.huffpost.com/gen/2223300/images/o-SCARY-TERMINATOR-ROBOT-facebook.jpg");
    }



    @Given("The user is logged in as username cindy101")
    public void the_user_is_logged_in_as_username_cindy101() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage.loginLink.click();

        loginPage.usernameInput.sendKeys("cindy101");
        loginPage.passwordInput.sendKeys("pass123");

        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(optionPage.usernameTextInfo));

//        System.out.println("player logged in");
    }


}
