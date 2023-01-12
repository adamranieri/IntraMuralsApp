package dev.jsx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SeasonPage {
    private WebDriver driver;

    public SeasonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getSeasons() {
        return seasonTableBody.findElements(By.xpath("./tr/td"))
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    @FindBy(id="seasonTableBody")
    WebElement seasonTableBody;

    @FindBy(xpath="*[@id='seasonTableBody']/tr[1]")
    WebElement firstRow;

    @FindBy(linkText="Back")
    WebElement backLink;
}