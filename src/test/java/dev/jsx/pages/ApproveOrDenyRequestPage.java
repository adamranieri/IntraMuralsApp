package dev.jsx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApproveOrDenyRequestPage {
    private WebDriver driver;

    public ApproveOrDenyRequestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRowByUserId(String userId) {
        List<WebElement> rows = teamRequestsTableBody.findElements(By.xpath("./tr"));

        for (int i = 0; i < rows.size(); i++) {
            WebElement userIdCell = rows.get(i).findElement(By.xpath("./td[1]"));

            if (userId == userIdCell.getText()) {
                return rows.get(i);
            }
        }

        return null;
    }

    @FindBy(id="teamRequests")
    public WebElement teamRequestsTableBody;



    @FindBy(linkText="Back")
    public WebElement backLink;
}
