package StepDefinition;


import Mailtravel.Webpages.BasePage;
import Mailtravel.Webpages.DailyMailTravel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

  DailyMailTravel dailyMailTravel;

  public StepDefinitions(){
    dailyMailTravel = new DailyMailTravel();
  }

  @Given("I am on mailtravel page")
  public void i_am_on_mailtravel_page() {
    dailyMailTravel.goToHomePage();
  }

  @Then("I should navigate to Homepage")
  public void i_should_navigate_to_homepage() {
    Assert.assertEquals("https://www.mailtravel.co.uk/",dailyMailTravel.isUserOnHomePage());
  }

  @When("I type {string} in then search box and click on search button")
  public void i_type_in_then_search_box_and_click_on_search_button(String string) {

  }

  @When("I click More Info on the first result")
  public void i_click_more_info_on_the_first_result() {

  }

  @Then("I should see days,price and telephone number")
  public void i_should_see_days_price_and_telephone_number() {

  }

  @When("I click on Book Online")
  public void i_click_on_book_online() {

  }



}
