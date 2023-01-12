package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOfficiatingChoicePage {

    private WebDriver driver;

    public EditOfficiatingChoicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name ="registerGameId")
    public WebElement registerGameIdNumberInput;

    @FindBy(xpath = "/html/body/form[1]/button")
    public WebElement submitRegister;


    @FindBy(name ="removeGameId")
    public WebElement removeGameIdNumberInput;


    @FindBy(xpath = "/html/body/form[2]/button")
    public WebElement submitRemoveGame;

    @FindBy(linkText="Back")
    public WebElement backButton;


}
