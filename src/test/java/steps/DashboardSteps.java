package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void userClicksOnPIMOption() {
        WebElement pimOption= driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimOption);
    }

    @And("user clicks on add employee option")
    public void userClicksOnAddEmployeeOption() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeOption);
    }
}
