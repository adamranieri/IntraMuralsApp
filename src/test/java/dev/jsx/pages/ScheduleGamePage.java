package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ScheduleGamePage {

    private WebDriver driver;

    public ScheduleGamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name ="venue")
    public WebElement venueDropDown;

    public void selectVenueDropDown(String string) {
        Select newSelect = new Select(venueDropDown);
        newSelect.selectByValue(string);
    }


    @FindBy(name ="time")
    public WebElement timeInput;



    @FindBy(name ="season")
    public WebElement seasonDropDown;

    public void selectSeasonDropDown(String string) {
        Select newSelect = new Select(seasonDropDown);
        newSelect.selectByValue(string);
    }


    @FindBy(name ="sport")
    public WebElement sportDropDown;


    public void selectSportDropDown(String string) {
        Select newSelect = new Select(sportDropDown);
        newSelect.selectByValue(string);
    }


    @FindBy(name ="home")
    public WebElement homeSelect;

    public void selectHomeDropDown(String string) {
        Select newSelect = new Select(homeSelect);
        newSelect.selectByValue(string);
    }


    @FindBy(name ="away")
    public WebElement awaySelect;

    public void selectAwayDropDown(String string) {
        Select newSelect = new Select(awaySelect);
        newSelect.selectByValue(string);
    }



    @FindBy(xpath ="/html/body/form/button[contains(text(),'Schedule')]")
    public WebElement scheduleButton;

    @FindBy(linkText="Back")
    WebElement backButton;


}
