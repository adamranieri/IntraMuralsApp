package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TeamViewerPage {

    private WebDriver driver;

    public TeamViewerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // gets a list of the 'See The Player' buttons.
    @FindBy(xpath="//*[@id=\"teammateInfo\"]/tr/td[4]/button[contains(text(),'See The Captain')]")
    public List<WebElement> showCaptainButtonList;

    @FindBy(linkText="Back")
    public WebElement backButton;

    @FindBy(xpath="/html/body/section/button[contains(text(),'Close')]")
    public WebElement closeWindowButton;



}
