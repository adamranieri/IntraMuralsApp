package dev.jsx.steps;

import dev.jsx.pages.LoginPage;
import dev.jsx.pages.MainPage;
import dev.jsx.pages.OptionPage;
import dev.jsx.pages.TeamApplicationPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dev.jsx.runners.TestRunner.*;
import static org.junit.Assert.*;

public class PlayersSteps {
    MainPage mainPage;
    LoginPage loginPage;
    OptionPage optionPage;
    TeamApplicationPage teamApplicationPage;


    @Given("the player is logged in")
    public void thePlayerIsLoggedIn() {
        driver.get("http://localhost:5500");

        mainPage = new MainPage(driver);
        mainPage.loginLink.click();

        loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys("eegdell0");
        loginPage.passwordInput.sendKeys("DyAU3y5hLA");
        loginPage.loginButton.click();
    }

    @And("the player is on the home page")
    public void thePlayerIsOnTheHomePage() {
        optionPage = new OptionPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(optionPage.teamApplicationsLink));
    }

    @When("the player clicks on the Team Applications link")
    public void thePlayerClicksOnTheTeamApplicationsLink() {
        optionPage.teamApplicationsLink.click();
    }

    @Then("the player should be on the Team Application page")
    public void thePlayerShouldBeOnTheTeamApplicationPage() {
        teamApplicationPage = new TeamApplicationPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.firstRowTeamInfoTable));
    }

    @When("the player selects the team {string} from the dropdown menu")
    public void thePlayerSelectsTheTeamFromTheDropdownMenu(String teamName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.teamSelectDropDown));

        teamApplicationPage.selectDropDown(teamName);
    }

    @And("the player clicks on the Submit button")
    public void thePlayerClicksOnTheSubmitButton() {
        teamApplicationPage.applyButton.click();
    }

    @Then("the application status for the team {string} should say {string}")
    public void theApplicationStatusForTheTeamShouldSay(String teamName, String expectedValue) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.applicationForm));

        String status = teamApplicationPage.getStatusByTeamName(teamName);
        assertNotNull(status);
        assertEquals(expectedValue, status);
    }

    @When("the player clicks on the See The Captain button for the team {string}")
    public void thePlayerClicksOnTheSeeTheCaptainButtonForTheTeam(String teamName) {
        WebElement seeTheCaptainButton = teamApplicationPage.getCaptainButtonByTeamName(teamName);
        seeTheCaptainButton.click();
    }

    @Then("a section should appear with information about the captain {string}")
    public void aSectionShouldAppearWithInformationAboutTheCaptain(String captainName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.captainName));

        String captainNameText = teamApplicationPage.captainName.getText();
        assertTrue(captainNameText.contains(captainName));
    }

    @Then("an alert should appear saying {string}")
    public void anAlertShouldAppearSaying(String expectedMessage) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        String alertMessage = driver.switchTo().alert().getText();
        assertEquals(expectedMessage, alertMessage);
    }

    @When("the player accepts the alert")
    public void thePlayerAcceptsTheAlert() {
        driver.switchTo().alert().accept();
    }
}
