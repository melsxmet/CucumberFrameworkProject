package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application(){
        driver= new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("user enters only valid password")
    public void userEntersOnlyValidPassword() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        click(loginPage.loginButton);
    }

    @Then("user can see username error message")
    public void userCanSeeUsernameErrorMessage() {
        String actualMessage= loginPage.errorMessage.getText();
        Assert.assertEquals("Username cannot be empty", actualMessage);
        loginPage.errorMessage.isDisplayed();
    }

    @When("user enters only valid username")
    public void userEntersOnlyValidUsername() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
    }


    @Then("user can see password error message")
    public void userCanSeePasswordErrorMessage() {
        String actualMessage= loginPage.errorMessage.getText();
        Assert.assertEquals("Password is Empty", actualMessage);
        loginPage.errorMessage.isDisplayed();
    }
    @When("user enters invalid username or password")
    public void userEntersInvalidUsernameOrPassword() {
        sendText("admin", loginPage.usernameField);
        sendText("Humanhrm123", loginPage.passwordField);
    }

    @Then("user can see invalid credentials message")
    public void userCanSeeInvalidCredentialsMessage() {
        String actualMessage= loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials", actualMessage);
        loginPage.errorMessage.isDisplayed();
    }

    @And("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @Then("user can see dashboard page")
    public void userCanSeeDashboardPage() {
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
    }

}
