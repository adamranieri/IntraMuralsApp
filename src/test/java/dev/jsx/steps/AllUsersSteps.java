package dev.jsx.steps;

import com.uni.entities.Venue;
import dev.jsx.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static dev.jsx.runners.TestRunner.*;
import static org.junit.Assert.*;

public class AllUsersSteps {
    MainPage mainPage;
    LoginPage loginPage;
    OptionPage optionPage;
    GameSchedulesPage gameSchedulesPage;
    VenuePage venuePage;

    @Given("the user logs in using the username {string} and  the password {string}")
    public void theUserLogsInUsingTheUsernameAndThePassword(String username, String password) {
        driver.get("http://localhost:5500");

        mainPage = new MainPage(driver);

        mainPage.loginLink.click();

        loginPage = new LoginPage(driver);

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @And("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        optionPage = new OptionPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(optionPage.gamesLink));
    }

    @When("the user clicks on Games")
    public void theUserClicksOnGames() {
        optionPage.gamesLink.click();
    }

    @Then("the user should see details of games")
    public void theUserShouldSeeDetailsOfGames() {
        assertNotNull(gameSchedulesPage.firstRow);
        List<WebElement> cells = gameSchedulesPage.firstRow.findElements(By.xpath("./td"));
    }

    @Then("the user should see details of game schedules")
    public void theUserShouldSeeDetailsOfGameSchedules() {
        assertNotNull(gameSchedulesPage.firstRow);

        List<WebElement> cells = gameSchedulesPage.firstRow.findElements(By.xpath("./td"));

        assertNotNull(cells);

        // Ensure that the cell contains something resembling a date
        assertTrue(cells.get(1).getText().matches("[0-9]{1,2}\\/[0-9]{2}\\/[0-9]{4}"));

        // Ensure that the cell contains something resembling a time
        assertTrue(cells.get(2).getText().matches(".*?[0-9]{1,2}:[0-9]{2}:[0-9]{2}.*?"));
    }

    @When("the user clicks on View Venues")
    public void theUserClicksOnViewVenues() {
        optionPage.viewVenuesLink.click();
    }

    @Then("the user should see details of venues")
    public void theUserShouldSeeDetailsOfVenues() {
        assertNotNull(venuePage.getVenues());
        assertTrue(venuePage.getVenues().size() > 0);
    }

    @Then("the user should be on the Game Schedules page")
    public void theUserShouldBeOnTheGameSchedulesPage() {
        gameSchedulesPage = new GameSchedulesPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(gameSchedulesPage.firstRow));

        assertEquals("Game Schedules", driver.getTitle());
    }

    @Then("the user should be on the Venue page")
    public void theUserShouldBeOnTheVenuePage() {
        venuePage = new VenuePage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(venuePage.firstRow));

        assertEquals("Venue", driver.getTitle());
    }
}
