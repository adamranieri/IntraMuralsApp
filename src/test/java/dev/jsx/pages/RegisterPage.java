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
    WebElement usernameInput;

    @FindBy(name="password")
    WebElement passwordInput;

    @FindBy(name="height")
    WebElement heightNumberInput;

    @FindBy(name="weight")
    WebElement weightNumberInput;

    @FindBy(name="picture")
    WebElement pictureTextInput;

    @FindBy(name="biometrics")
    WebElement biometricsCheckbox;

    @FindBy(xpath="/html/body/form/button")
    WebElement submitFormButton;


    @FindBy(xpath="/html/body/a[1]")
    WebElement backButtonLeft;

    @FindBy(xpath="/html/body/a[2]")
    WebElement backButtonRight;


}
