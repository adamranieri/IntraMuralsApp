package dev.jsx.steps.CreateOrManageAccount;

import dev.jsx.pages.EditUserProfilePage;
import dev.jsx.runners.TestRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeUpdateProfilePictureStepImpl {


    public static WebDriver driver = TestRunner.driver;

    EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);


    @Then("the user pastes the url for an invalid image link")
    public void the_user_pastes_the_url_for_an_invalid_image_link() {
        // Write code here that turns the phrase above into concrete actions
        editUserProfilePage.pictureInput.clear();
        editUserProfilePage.pictureInput.sendKeys("https://s-i.huffpost.com/gen/2223300/images/o-SCARY");
    }

    @Then("an alert message box appears that gives an error")
    public void an_alert_message_box_appears_that_gives_an_error() {
        // Write code here that turns the phrase above into concrete actions

        try {
            String alertMessage = driver.switchTo().alert().getText();
            assertEquals("This is not a valid image url",alertMessage);
        }
        catch (NoAlertPresentException Ex) {
            fail();
        }

    }

}
