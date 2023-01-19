package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PositiveUpdatePasswordStepImpl {

    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);

    MainPage mainPage = new MainPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    OptionPage optionPage = new OptionPage(driver);



    @When("the user types a new password newpass123 into the password input")
    public void the_user_types_a_new_password_newpass123_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.passwordInput.clear();
        editUserProfilePage.passwordInput.sendKeys("newpass123");
    }

}
