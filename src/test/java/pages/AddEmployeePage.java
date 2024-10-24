package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstnameLocator;

    @FindBy(id="lastName")
    public WebElement lastnameLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="employeeId")
    public WebElement employeeId;

    @FindBy(xpath= "//*[@id='pdMainContainer']/div[1]/h1")
    public WebElement detailsPage;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement errorMessage;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

}
