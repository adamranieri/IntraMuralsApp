package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OptionPage {

    private WebDriver driver;

    public OptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method creates an explicit wait using a web element as an input parameter
    public WebElement getElementWithWait(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Navigational web elements - leads to other pages
    @FindBy(linkText="Register")
    WebElement registerLink;

    @FindBy(linkText="Edit User Profile")
    public
    WebElement editUserProfileButton;

    @FindBy(linkText="Games")
    WebElement gamesLInk;

    @FindBy(linkText="View Venues")
    WebElement viewVenuesLink;

    @FindBy(linkText="View Seasons")
    WebElement viewSeasonsLink;

    @FindBy(linkText="Approve/Deny Team Requests")
    WebElement approveDenyTeamRequestLink;

    @FindBy(linkText="View Your Team")
    WebElement viewYourTeamLink;

    @FindBy(linkText="Manage User Roles")
    WebElement manageUserRolesLink;

    @FindBy(linkText="Schedule Game")
    WebElement scheduleGameLink;

    @FindBy(linkText="Edit Officiating Choice")
    WebElement editOfficiatingChoiceLink;

    @FindBy(linkText="Officiate Games")
    WebElement officiateGamesLink;


    @FindBy(tagName ="button")
    public
    WebElement logoutButton;



    // Non navigational web elements
    @FindBy(xpath ="/html/body/h1")
    public
    WebElement roleTextInfo;

    @FindBy(xpath ="/html/body/h2")
    WebElement captainTextInfo;

    @FindBy(xpath ="/html/body/div/p[1]")
    WebElement usernameTextInfo;

    @FindBy(xpath ="/html/body/div/p[2]")
    WebElement noProfilePic;

    @FindBy(tagName ="img")
    WebElement profilePic;



}
