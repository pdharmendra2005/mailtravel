package Mailtravel.Webpages;

import Mailtravel.Utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DailyMailTravel extends BasePage {


  public DailyMailTravel(){

    PageFactory.initElements(driver,this);
  }


  @FindBy ( css = "input[type='text']")
  WebElement enterEmail;

  @FindBy (css = "input[name='password']")
  WebElement enterPwd;


  @FindBy ( css = "button[type='submit']")
  WebElement clickLogon;

  @FindBy ( xpath = "//*[text()='DASHBOARD']")
  WebElement verifyDashboard;

  @FindBy ( xpath = "//*[text()='hotels ']")
  WebElement clickHotel;

  @FindBy ( xpath = "//a[@href='https://phptravels.net/api/admin/hotels/booking']")
  WebElement clickBooking;

  @FindBy ( css = "i.fa.fa-dashboard.fa-lg")
  WebElement clickaddBooking;

  @FindBy ( xpath = "//select[@id='servicetype']")
  WebElement selectServiceType;

  @FindBy ( xpath = "//option[@value='Hotels']")
  WebElement selectServiceTypeHotel;

  @FindBy ( css = "#selusertype")
  WebElement selectCustomer;

  @FindBy ( css = "#regcust")
  WebElement selectGuest;

  @FindBy ( css = "#lname")
  WebElement enterFirstName;

  @FindBy ( css = "#lname")
  WebElement enterLastName;

  @FindBy ( css = "#mobile")
  WebElement enterMobileNumber;

  @FindBy ( css = "#email")
  WebElement enterEmailadd;


  public void goToHomePage() {
    System.out.println("I am inside homePage");
    driver.get(baseUrl);

  }
  public String isUserOnHomePage(){
    String title = driver.getTitle();
    System.out.println("Title "+title);
    return title;
  }

  public void enterEmailPassword(String stringEmail, String Password ) {
    Util.waitTime(100);
    Util.sendKey(enterEmail, emailEnter);
    Util.sendKey(enterPwd, passwrd);
    Util.waitTime(100);
    Util.click(clickLogon);
    Util.waitTime(200);
  }

  public boolean isUserOnDashBoard(){
    return Util.isDisplayed(verifyDashboard);

  }

  public void clickHotelandbooking(){
    Util.click(clickHotel);
    Util.waitTime(200);
    Util.click(clickBooking);
  }
  public void clickOnaddbooking(){
    Util.waitTime(100);
    Util.click(clickaddBooking);
  }
  public void selectHotelfromService(){
    Util.click(selectServiceType);
    Util.waitTime(100);
    Util.click(selectServiceTypeHotel);
  }
  public void customerDetails(String CusName, String Fname,String lName,int mobileNum,String Email){



  }


}
