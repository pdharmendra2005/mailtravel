package Mailtravel.Webpages;

import Mailtravel.Utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DailyMailTravel extends BasePage {


  public DailyMailTravel(){
    driverWait = new WebDriverWait(driver, 20);
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

  @FindBy ( css = "#servicetype")
  WebElement selectServiceType;

  @FindBy ( xpath = "//option[@value='Hotels']")
  WebElement selectServiceTypeHotel;

  @FindBy ( css = "#selusertype")
  WebElement selectCustomer;

  @FindBy ( css = "option[value='guest']")
  WebElement selectGuest;

  @FindBy ( css = "#fname")
  WebElement enterFirstName;

  @FindBy ( css = "#lname")
  WebElement enterLastName;

  @FindBy ( css = "#mobile")
  WebElement enterMobileNumber;

  @FindBy ( css = "#email")
  WebElement enterEmailadd;

  @FindBy ( css = "input#Hotels")
  WebElement enterCheckIndate;

  @FindBy ( css = "input.form-control.dpd2")
  WebElement enterCheckOutDate;

  @FindBy ( css = "#s2id_autogen3")
  WebElement chooseHotelName;

  @FindBy ( xpath = "//div[contains(text(),' Rendezvous Hotels ')]")
  WebElement selectHotelName;

  @FindBy ( xpath = "//span[contains(text(),'Select Room')]")
  WebElement chooseRoomName;

  @FindBy ( xpath = "//div[contains(text(),'Delux Room')]")
  WebElement selectRoomName;




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
   // Util.waitTime(600);
    driverWait.until(ExpectedConditions.visibilityOf(enterEmail));
    Util.sendKey(enterEmail, emailEnter);
    Util.sendKey(enterPwd, passwrd);
    Util.waitTime(300);
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
    Util.waitTime(400);
    Util.click(selectServiceTypeHotel);
  }



  public void enterCustomerDetails(String CusName, String Fname,String lName,String mobileNum,String Email) {
    Util.waitTime(400);
    driverWait.until(ExpectedConditions.visibilityOf(selectCustomer));
    Util.sendKey( selectCustomer , CusName);

    Util.click(selectGuest);
    driverWait.until(ExpectedConditions.visibilityOf(selectGuest));
    Util.waitTime(100);
    Util.sendKey( enterFirstName , Fname);
    Util.waitTime(100);
    Util.sendKey( enterLastName,   lName);
    Util.waitTime(100);
    Util.sendKey( enterMobileNumber  , mobileNum);
    Util.waitTime(100);
    Util.sendKey(  enterEmailadd , Email);
  }
  public void  enterItemDetails( String checkIn, String checkOut, String roomQty){
    driverWait.until(ExpectedConditions.visibilityOf(enterCheckIndate));
    Util.sendKey(enterCheckIndate, checkIn);
    Util.sendKey(enterCheckOutDate, checkOut);
    driverWait.until(ExpectedConditions.visibilityOf(chooseHotelName));
    Util.click(chooseHotelName);
    Util.waitTime(200);
    Util.click(selectHotelName);
    driverWait.until(ExpectedConditions.visibilityOfAllElements(selectRoomName,selectRoomName));
    Util.click(chooseRoomName);

    Util.click(selectRoomName);

  }

}
