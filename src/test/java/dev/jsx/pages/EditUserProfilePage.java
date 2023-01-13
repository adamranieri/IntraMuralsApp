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
    public WebElement usernameInput;

    @FindBy(name="password")
    public WebElement passwordInput;

    @FindBy(name="height")
    public WebElement heightInput;

    @FindBy(name="weight")
<<<<<<< HEAD
    public WebElement weightInput;


    @FindBy(name="picture")
=======
>>>>>>> master
    public WebElement pictureInput;

    @FindBy(name="biometrics")
    public WebElement biometricsCheckbox;

    @FindBy(xpath="//button[text() = 'Submit']")
    public WebElement submitButton;

    @FindBy(linkText="Back")
    public WebElement backLink;
}
