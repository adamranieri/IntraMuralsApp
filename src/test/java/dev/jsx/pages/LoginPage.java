package dev.jsx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="username")
    public
    WebElement usernameInput;

    @FindBy(name="password")
    public
    WebElement passwordInput;

    @FindBy(tagName="button")
    public
    WebElement loginButton;

    @FindBy(linkText="Main Page")
    WebElement mainPageLink;


}
