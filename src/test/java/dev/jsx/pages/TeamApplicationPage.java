package dev.jsx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TeamApplicationPage {

    private WebDriver driver;

    public TeamApplicationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // drop down menu element & associated method for choosing dropdown menu value based on string value
    @FindBy(xpath="//select")
    public WebElement teamSelectDropDown;

    public void selectDropDown(String string) {
        Select newSelect = new Select(teamSelectDropDown);
        newSelect.selectByValue(string);
    }

    public String getStatusByTeamName(String teamName) {
        List<WebElement> rows = teamInfoTableBody.findElements(By.xpath("./tr"));

        for (var row: rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));

            if (cells.get(0).getText().equals(teamName)) {
                return cells.get(3).getText();
            }
        }

        return null;
    }

    public WebElement getCaptainButtonByTeamName(String teamName) {
        List<WebElement> rows = teamInfoTableBody.findElements(By.xpath("./tr"));

        for (var row: rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));

            if (cells.get(0).getText().equals(teamName)) {
                return cells.get(4).findElement(By.xpath("./button"));
            }
        }

        return null;
    }

    @FindBy(xpath="/html/body/section/p[2]")
    public WebElement captainName;

    @FindBy(id="teamInfo")
    public WebElement teamInfoTableBody;

    @FindBy(xpath="//*[@id='teamInfo']/tr[1]")
    public WebElement firstRowTeamInfoTable;

    @FindBy(xpath="//body/div")
    public WebElement applicationForm;

    @FindBy(xpath ="/html/body/div/button[contains(text(),'Apply')]")
    public WebElement applyButton;

    @FindBy(linkText="Back")
    public WebElement backButton;




}
