package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="username")
    public WebElement usernameInput;

    @FindBy(name="password")
    public WebElement passwordInput;

    @FindBy(name="height")
    public WebElement heightNumberInput;

    @FindBy(name="weight")
    public WebElement weightNumberInput;

    @FindBy(name="picture")
    public WebElement pictureTextInput;

    @FindBy(name="biometrics")
    public WebElement biometricsCheckbox;

    @FindBy(xpath="/html/body/form/button")
    public WebElement submitFormButton;


    @FindBy(xpath="/html/body/a[1]")
    public WebElement backButtonLeft;

    @FindBy(xpath="/html/body/a[2]")
    public WebElement backButtonRight;


}
