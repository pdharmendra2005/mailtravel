package StepDefinition;


import Mailtravel.Utility.Util;
import Mailtravel.Webpages.BasePage;
import Mailtravel.Webpages.DailyMailTravel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

  DailyMailTravel dailyMailTravel;

  public StepDefinitions(){
    dailyMailTravel = new DailyMailTravel();
  }

  @Given("I am on phptravel admin page")
  public void i_am_on_phptravel_admin_page() {
    dailyMailTravel.goToHomePage();
  }

  @Then("I should navigate to admin page")
  public void i_should_navigate_to_admin_page() {
    Assert.assertEquals("Administator Login",dailyMailTravel.isUserOnHomePage());
  }


  @When("I enter {string} and {string} and click on LogOn button")
  public void I_EnterAndAndClickOnLogOnButton(String UserName, String Password) {
    Util.waitTime(200);
    dailyMailTravel.enterEmailPassword(UserName, Password);
  }

  @Then("I should navigate to the Dashboard Page")
  public void i_ShouldNavigateToTheDashboardPage() {
    Assert.assertTrue(dailyMailTravel.isUserOnDashBoard());
  }

  @When("I click on Hotels & Bookings to book Hotel")
  public void IClickOnHotelsBookingsToBookHotel() {
    dailyMailTravel.clickHotelandbooking();
    Util.waitTime(100);
  }

  @And("I am on Add booking Page")
  public void IamonAddBookingPage() {
    dailyMailTravel.clickOnaddbooking();
  }

  @When("I select Hotels from Services")
  public void iSelectHotelsFromServices() {
    dailyMailTravel.selectHotelfromService();
  }

  @And("I enter Customer as {string}, {string}, {string}, {string},{string} and enter next item")
  public void IEnterCustomerAsAndEnterNextItem(String guest, String firstName, String lName, String mobile, String email) {
    dailyMailTravel.enterCustomerDetails(guest, firstName,lName,mobile,email);

  }


  @And("I enter ITEM detail {string},{string},{string} enter next item")
  public void IEnterITEMDetailEnterNextItem(String checkIn, String checkOut, String roomQty) {
    dailyMailTravel.enterItemDetails(checkIn, checkOut, roomQty);

  }
}
