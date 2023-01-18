package dev.jsx.steps;

import com.uni.entities.Game;
import dev.jsx.pages.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static dev.jsx.runners.TestRunner.*;
import static org.junit.Assert.*;

public class RefereesSteps {
    MainPage mainPage;
    LoginPage loginPage;
    OptionPage optionPage;
    EditOfficiatingChoicePage editOfficiatingChoicePage;
    OfficiateGamePage officiateGamePage;
    GameSchedulesPage gameSchedulesPage;

    int chosenGameToOfficiate = -1;

    String editedGameId;

    @Given("the referee is logged in")
    public void theRefereeIsLoggedIn() {
        driver.get("http://localhost:5500");

        mainPage = new MainPage(driver);
        mainPage.loginLink.click();

        loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys("cindy101");
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();
    }

    @And("the referee is on the home page")
    public void theRefereeIsOnTheHomePage() {
        optionPage = new OptionPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(optionPage.editOfficiatingChoiceLink));
    }

    @When("the referee clicks on the Edit Officiating Choice link")
    public void theRefereeClicksOnTheEditOfficiatingChoiceLink() {
        optionPage.editOfficiatingChoiceLink.click();
    }

    @Then("the referee should be on the Officiating Choice page")
    public void theRefereeShouldBeOnTheOfficiatingChoicePage() {
        editOfficiatingChoicePage = new EditOfficiatingChoicePage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(editOfficiatingChoicePage.submitRegister));
    }

    @When("the referee enters an existing game ID into the Game ID input to register for a game")
    public void theRefereeEntersAnExistingGameIDIntoTheGameIDInput() {
        editOfficiatingChoicePage.registerGameIdNumberInput.sendKeys("1");
        chosenGameToOfficiate = 1;
    }

    @And("the referee clicks on the Submit button to register for a game")
    public void theRefereeClicksOnTheSubmitButton() {
        editOfficiatingChoicePage.submitRegister.click();
    }

    @When("the referee enters a non-existing game ID into the Game ID input to register for a a game")
    public void theRefereeEntersANonExistingGameIDIntoTheGameIDInput() {
        editOfficiatingChoicePage.registerGameIdNumberInput.sendKeys("-1");
    }

    @Then("the referee should see an alert appear saying {string}")
    public void theRefereeShouldSeeAnAlertAppearSaying(String expectedMessage) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals(expectedMessage, alertMessage);
    }

    @When("the referee enters an existing game ID into the Game ID input to remove themself from a game")
    public void theRefereeEntersAnExistingGameIDIntoTheGameIDInputToRemoveThemselfFromAGame() {
        editOfficiatingChoicePage.removeGameIdNumberInput.sendKeys("1");
    }

    @And("the referee clicks on the Submit button to remove themself from a game")
    public void theRefereeClicksOnTheSubmitButtonToRemoveThemselfForAGame() {
        editOfficiatingChoicePage.submitRemoveGame.click();
    }

    @When("the referee enters an invalid game ID into the Game ID input to remove themself from a game")
    public void theRefereeEntersAnInvalidGameIDIntoTheGameIDInputToRemoveThemselfFromAGame() {
        editOfficiatingChoicePage.removeGameIdNumberInput.sendKeys("-1");
    }

    @When("the referee enters text into the Game ID input to register for a game")
    public void theRefereeEntersTextIntoTheGameIDInputToRegisterForAGame() {
        editOfficiatingChoicePage.registerGameIdNumberInput.sendKeys("abc");
    }

    @Then("the referee should not see an alert")
    public void anAlertShouldNotAppear() {
        boolean alertAppears = false;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent());

            driver.switchTo().alert().accept();
            alertAppears = true;
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        assertFalse(alertAppears);
    }

    @When("the referee enters a floating point number into the Game ID input to register for a game")
    public void theRefereeEntersAFloatingPointNumberIntoTheGameIDInputToRegisterForAGame() {
        editOfficiatingChoicePage.registerGameIdNumberInput.sendKeys("1.1");
    }

    @When("the referee enters nothing into the Game ID input to register for a game")
    public void theRefereeEntersNothingIntoTheGameIDInputToRegisterForAGame() {
        editOfficiatingChoicePage.registerGameIdNumberInput.sendKeys("");
    }

    @When("the referee enters text into the Game ID input to remove themself from a game")
    public void theRefereeEntersTextIntoTheGameIDInputToRemoveThemselfFromAGame() {
        editOfficiatingChoicePage.removeGameIdNumberInput.sendKeys("abc");
    }

    @When("the referee enters a floating point number into the Game ID input to remove themself from a game")
    public void theRefereeEntersAFloatingPointNumberIntoTheGameIDInputToRemoveThemselfFromAGame() {
        editOfficiatingChoicePage.removeGameIdNumberInput.sendKeys("1.1");
    }

    @When("the referee enters nothing into the Game ID input to to remove themself from a game")
    public void theRefereeEntersNothingIntoTheGameIDInputToToRemoveThemselfFromAGame() {
        editOfficiatingChoicePage.removeGameIdNumberInput.sendKeys("");
    }

    @When("the referee accepts the dialog")
    public void theRefereeAcceptsTheDialog() {
        driver.switchTo().alert().accept();
    }

    @Then("the referee should be on the home page")
    public void theRefereeShouldBeOnTheHomePage() {
        optionPage = new OptionPage(driver);

        boolean onOptionPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(optionPage.editOfficiatingChoiceLink));
        } catch (TimeoutException e) {
            onOptionPage = false;
        }

        assertTrue(onOptionPage);
    }

    @When("the referee clicks on the Officiate Games link")
    public void theRefereeClicksOnTheOfficiateGamesLink() {
        optionPage.officiateGamesLink.click();
    }

    @Then("the referee should be on the Officiate Games page")
    public void theRefereeShouldBeOnTheOfficiateGamesPage() {
        officiateGamePage = new OfficiateGamePage(driver);

        boolean onPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(officiateGamePage.firstRow));
        } catch (TimeoutException e) {
            onPage = false;
        }

        assertTrue(onPage);
    }

    @And("the referee should see a game with the ID of the game they chose to officiate")
    public void theRefereeShouldSeeAGameWithTheIDOfTheGameTheyChoseToOfficiate() {
        List<WebElement> rows = officiateGamePage.gameTableBody.findElements(By.xpath("./tr"));

        boolean isGameIdInTable = false;

        for (int i = 0; i < rows.size(); i++) {
            WebElement firstTd = rows.get(i).findElement(By.xpath("./td[1]"));

            if (Integer.parseInt(firstTd.getText()) == chosenGameToOfficiate) {
                isGameIdInTable = true;
            }
        }

        assertTrue(isGameIdInTable);
    }

    @And("the referee clicks on the Back link from the Officiating Choice page")
    public void theRefereeClicksOnTheBackLinkFromTheOfficiatingChoicePage() {
        editOfficiatingChoicePage.backButton.click();
    }

    @And("the referee should not see the game ID of the game they removed")
    public void theRefereeShouldNotSeeTheGameIDOfTheGameTheyRemoved() {
        List<WebElement> rows = officiateGamePage.gameTableBody.findElements(By.xpath("./tr"));

        boolean isGameIdInTable = false;

        for (int i = 0; i < rows.size(); i++) {
            WebElement firstTd = rows.get(i).findElement(By.xpath("./td[1]"));

            if (Integer.parseInt(firstTd.getText()) == chosenGameToOfficiate) {
                isGameIdInTable = true;
            }
        }

        assertFalse(isGameIdInTable);
    }

    @When("the referee selects the Update Scores button for the first game in the list")
    public void theRefereeSelectsTheUpdateScoresButtonForTheFirstGameInTheList() {
        WebElement firstRow = officiateGamePage.gameTableBody.findElement(By.xpath("./tr[1]"));
        WebElement updateScoresButton = firstRow.findElement(By.xpath("./td[8]/button"));
        editedGameId = firstRow.findElement(By.xpath("./td[1]")).getText();

        updateScoresButton.click();
    }

    @Then("the referee should see a section appear with inputs for the points and fouls in a game")
    public void theRefereeShouldSeeASectionAppearWithInputsForThePointsAndFoulsInAGame() {
        boolean canSeeAddPointsButton = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(officiateGamePage.homeAddOnePointButton));
        } catch (Exception e) {
            canSeeAddPointsButton = false;
        }

        assertTrue(canSeeAddPointsButton);
    }

    @When("the referee clicks on each of the Add point buttons for the home team")
    public void theRefereeClicksOnEachOfTheAddPointButtonsForTheHomeTeam() {
        officiateGamePage.homeAddOnePointButton.click();
        officiateGamePage.homeAddTwoPointsButton.click();
        officiateGamePage.homeAddThreePointsButton.click();
    }

    @Then("the referee should see the home team's score to be six")
    public void theRefereeShouldSeeTheHomeTeamSScoreToBeSix() {
        assertEquals("6", officiateGamePage.homePointInput.getAttribute("value"));
    }

    @When("the referee clicks on each of the Add point buttons for the away team")
    public void theRefereeClicksOnEachOfTheAddPointButtonsForTheAwayTeam() {
        officiateGamePage.awayAddOnePointButton.click();
        officiateGamePage.awayAddTwoPointsButton.click();
        officiateGamePage.awayAddThreePointsButton.click();
    }

    @Then("the referee should see the away team's score to be six")
    public void theRefereeShouldSeeTheAwayTeamSScoreToBeSix() {
        assertEquals("6", officiateGamePage.awayPointInput.getAttribute("value"));
    }

    @When("the referee clicks on the Add button to add a foul to the home team")
    public void theRefereeClicksOnTheAddButtonToAddAFoulToTheHomeTeam() {
        officiateGamePage.addFoulsButton.click();
    }

    @Then("the referee should see one foul in the home team input")
    public void theRefereeShouldSeeOneFoulInTheHomeTeamInput() {
        assertEquals("1", officiateGamePage.homeFoulsInput.getAttribute("value"));
    }

    @When("the referee clicks on the Add button to add a foul to the away team")
    public void theRefereeClicksOnTheAddButtonToAddAFoulToTheAwayTeam() {
        officiateGamePage.awayFoulsButton.click();
    }

    @Then("the referee should see one foul in the away team input")
    public void theRefereeShouldSeeOneFoulInTheAwayTeamInput() {
        assertEquals("1", officiateGamePage.awayFoulsInput.getAttribute("value"));
    }

    @When("the referee clicks on the Save button")
    public void theRefereeClicksOnTheSaveButton() {
        officiateGamePage.saveButton.click();
    }

    @And("the referee clicks on the Back Link from the Officiate Game page")
    public void theRefereeClicksOnTheBackLinkFromTheOfficiateGamePage() {
        officiateGamePage.backLink.click();
    }

    @And("the referee clicks on the Games link")
    public void theRefereeClicksOnTheGamesLink() {
        optionPage.gamesLink.click();
    }

    @Then("the referee should be on the Game Schedules page")
    public void theRefereeShouldBeOnTheGameSchedulesPage() {
        gameSchedulesPage = new GameSchedulesPage(driver);

        boolean onGameSchedulesPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(gameSchedulesPage.firstRow));
        } catch (Exception e) {
            onGameSchedulesPage = false;
        }

        assertTrue(onGameSchedulesPage);
    }

    @And("the user should see the new scores reflected for the edited game")
    public void theUserShouldSeeTheNewScoresReflectedForTheEditedGame() {
        List<WebElement> rows = gameSchedulesPage.gameTableBody.findElements(By.xpath("./tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement editedGameRow = gameSchedulesPage.gameTableBody.findElements(By.xpath("./tr"))
                .stream()
                .filter(currentRow -> editedGameId.equals(currentRow.findElement(By.xpath("./td[1]")).getText()))
                .findAny()
                .orElse(null);

        assertNotNull(editedGameRow);

        WebElement homeTeamScoreCell = editedGameRow.findElement(By.xpath("./td[8]"));
        WebElement homeTeamFouls = editedGameRow.findElement(By.xpath("./td[9]"));
        WebElement awayTeamScoreCell = editedGameRow.findElement(By.xpath("./td[10]"));
        WebElement awayTeamFouls = editedGameRow.findElement(By.xpath("./td[11]"));

        assertEquals("6", homeTeamScoreCell.getText());
        assertEquals("1", homeTeamFouls.getText());
        assertEquals("6", awayTeamScoreCell.getText());
        assertEquals("1", awayTeamFouls.getText());
    }
}
