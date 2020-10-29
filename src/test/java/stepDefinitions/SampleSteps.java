package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class SampleSteps {
    private WebDriver driver;
    private static WebDriverWait wait;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    //

    @Given("^Navigate to URL \"([^\"]*)\"$")
    public void navigateToURL(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get(arg0);
        Thread.sleep(1000);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsr")));
        //driver.findElement(By.xpath("//*[@id='gsr']")).click();

    }

    @When("^I enter \"([^\"]*)\"$")
    public void iEnter(String arg0) throws Throwable {
        WebElement numberField = driver.findElement(By.id("numb"));
        numberField.click();
        numberField.sendKeys(arg0);
    }

    @And("^I click on the Submit button$")
    public void iClickOnTheSubmitButton() {
        WebElement numberField = driver.findElement(By.tagName("button"));
        numberField.click();

    }

    @Then("^I will see an error \"([^\"]*)\"$")
    public void iWillSeeAnError(String arg0) throws Throwable {
        assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());
    }


    @Then("^I will see a popup with calculation \"([^\"]*)\"$")
    public void iWillSeeAPopupWithCalculation(String arg0) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(arg0, alert.getText());

    }

    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) throws Throwable {
       WebElement button = driver.findElement(By.id(arg0));
       button.click();

    }



    @Then("^Person appears in the main list with correct name and surname$")
    public void personAppearsInTheMainListWithCorrectNameAndSurname() {

        assertEquals("Andrejs",driver.findElement(By.xpath("//*[@class = 'name' and text()='Andrejs']")).getText());
        //*[@id="person3"]/div/span[1]
        //*[@class='text' and @id='dummy'
        //assertEquals("Silins", driver.findElement(By.className("surname")).getText());
        assertEquals("Silins", driver.findElement(By.xpath("//*[@class = 'surname' and text()='Silins']")).getText());
    }

    @When("^I click on first person Edit button$")
    public void iClickOnFirstPersonEditButton() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listOfPeople")));
        driver.findElement(By.xpath("//*[@id='person0']/span[2]")).click();
    }

    @And("^Change the name of the person to \"([^\"]*)\"$")
    public void changeTheNameOfThePersonTo(String arg0) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(arg0);
    }

    @And("^Fill in all the details with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void fillInAllTheDetailsWithAnd(String arg0, String arg1) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(arg0);
        driver.findElement(By.id("surname")).sendKeys(arg1);
        driver.findElement(By.id("job")).sendKeys("Test Automation Engineer");
        driver.findElement(By.id("dob")).sendKeys("10/10/1987");
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        dateWidget.findElement(By.xpath("//a[text()='10']")).click();
        driver.findElement(By.id("male")).click();
        Select sex = new Select(driver.findElement(By.id("status")));
        sex.selectByVisibleText("Intern");

    }

    @Then("^Person appears in the main list with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void personAppearsInTheMainListWithAnd(String arg0, String arg1) throws Throwable {
        String xPathWithName = "//*[@class = 'name' and text()='" + arg0 +"']";
        String xPathWithSurname = "//*[@class = 'surname' and text()='" + arg1 +"']";
        assertEquals(arg0,driver.findElement(By.xpath(xPathWithName)).getText());
        assertEquals(arg1, driver.findElement(By.xpath(xPathWithSurname)).getText());
    }

    @And("^I click on first person Remove button$")
    public void iClickOnFirstPersonRemoveButton() {
        driver.findElement(By.xpath("//*[@id='person0']/span[1]")).click();
    }

    @And("^I click to reset the list$")
    public void iClickToResetTheList() {
        driver.findElement(By.xpath("//*[contains(@onclick, 'resetListOfPeople()')]")).click();
        //*[contains(@class, 'text')


    }

    @Then("^Person \"([^\"]*)\" \"([^\"]*)\" is not present in the list$")
    public void personIsNotPresentInTheList(String arg0, String arg1) throws Throwable {
        String xPathWithName = "//*[@class = 'name' and text()='" + arg0 +"']";
        String xPathWithSurname = "//*[@class = 'surname' and text()='" + arg1 +"']";
        //assertNotEquals(arg0,driver.findElement(By.xpath(xPathWithName)).getText());
        //assertNotEquals(arg1,driver.findElement(By.xpath(xPathWithSurname)).getText());
        Assert.assertEquals(0,driver.findElements(By.xpath(xPathWithName)).size());
        Assert.assertEquals(0,driver.findElements(By.xpath(xPathWithSurname)).size());

    }

    @Then("^List of persons contains only default entries$")
    public void listOfPersonsContainsOnlyDefaultEntries() {
        List<WebElement> persons = driver.findElements(By.className("w3-xlarge"));

        // for (WebElement person : persons) {
        //  System.out.println(person.getText());
        // }
        if (persons.size()==3) {
            assertEquals("Mike Kid", persons.get(0).getText());
            assertEquals("Jill Watson", persons.get(1).getText());
            assertEquals("Jane Doe", persons.get(2).getText());
        } else {
            fail();
        }

    }

    @And("^I click on Clear all fields button$")
    public void iClickOnClearAllFieldsButton() {
        driver.findElement(By.className("#addPersonBtn")).click();
    }

    @Then("^All 'Add new person' fields are empty$")
    public void allAddNewPersonFieldsAreEmpty() {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("surname")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());
        assertEquals("",driver.findElement(By.id("dob")).getText());
        assertFalse(driver.findElement(By.id("french")).isSelected());
        assertFalse(driver.findElement(By.id("spanish")).isSelected());
        assertTrue(driver.findElement(By.id("english")).isSelected());
        assertFalse(driver.findElement(By.id("male")).isSelected());
        assertFalse(driver.findElement(By.id("female")).isSelected());
        Select sex = new Select(driver.findElement(By.id("status")));
        assertTrue(sex.getFirstSelectedOption().isDisplayed());
    }
}
