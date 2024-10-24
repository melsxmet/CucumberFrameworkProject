package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @And("user enters firstname and lastname")
    public void userEntersFirstnameAndLastname() {
        sendText("Mellisa", addEmployeePage.firstnameLocator);
        sendText("Outtrim", addEmployeePage.lastnameLocator);
    }

    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employeeAddedSuccessfully() {
        WebElement addedSuccessfully= driver.findElement(By.xpath("//*[@id='pdMainContainer']/div[1]/h1"));
        String personalDetails= addedSuccessfully.getText();
        Assert.assertEquals(personalDetails,"Personal Details");
    }

    @And("user clears id field")
    public void userClearsIdField() {
        addEmployeePage.employeeId.clear();
    }

    @And("user enters id")
    public void userEntersId() {
        sendText("3647910832", addEmployeePage.employeeId);
    }

    @And("user enters firstname")
    public void userEntersFirstname() {
        sendText("Mellisa", addEmployeePage.firstnameLocator);
    }

    @And("user enters lastname")
    public void userEntersLastname() {
        sendText("Outtrim", addEmployeePage.lastnameLocator);
    }

    @Then("user can see lastname error message")
    public void userCanSeeLastnameErrorMessage() {
        addEmployeePage.errorMessage.isDisplayed();
    }

    @Then("user can see firstname error message")
    public void userCanSeeFirstnameErrorMessage() {
        addEmployeePage.errorMessage.isDisplayed();
    }
}
