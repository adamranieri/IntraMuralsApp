package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserProfilePage {
    private WebDriver driver;

    public EditUserProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="username")
    WebElement usernameInput;

    @FindBy(name="password")
    WebElement passwordInput;

    @FindBy(name="height")
    WebElement heightInput;

    @FindBy(name="weight")
    WebElement pictureInput;

    @FindBy(name="biometrics")
    WebElement biometricsCheckbox;

    @FindBy(xpath="//button[text() = 'Submit']")
    WebElement submitButton;

    @FindBy(linkText="Back")
    WebElement backLink;
}
