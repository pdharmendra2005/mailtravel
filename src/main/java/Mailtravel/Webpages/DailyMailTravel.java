package Mailtravel.Webpages;

import Mailtravel.Utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;


public class DailyMailTravel extends BasePage {


  public DailyMailTravel() {
    driverWait = new WebDriverWait(driver, 20);
    PageFactory.initElements(driver, this);
  }


  @FindBy(css = "input[type='text']")
  WebElement enterEmail;

  @FindBy(css = "input[name='password']")
  WebElement enterPwd;


  @FindBy(css = "button[type='submit']")
  WebElement clickLogon;

  @FindBy(xpath = "//*[text()='DASHBOARD']")
  WebElement verifyDashboard;

  @FindBy(xpath = "//*[text()='hotels ']")
  WebElement clickHotel;

  @FindBy(xpath = "//a[@href='https://phptravels.net/api/admin/hotels/booking']")
  WebElement clickBooking;

  @FindBy(css = "i.fa.fa-dashboard.fa-lg")
  WebElement clickaddBooking;

  @FindBy(css = "#servicetype")
  WebElement selectServiceType;

  @FindBy(xpath = "//option[@value='Hotels']")
  WebElement selectServiceTypeHotel;

  @FindBy(css = "#selusertype")
  WebElement selectCustomer;

  @FindBy(css = "option[value='guest']")
  WebElement selectGuest;

  @FindBy(css = "#fname")
  WebElement enterFirstName;

  @FindBy(css = "#lname")
  WebElement enterLastName;

  @FindBy(css = "#mobile")
  WebElement enterMobileNumber;

  @FindBy(css = "#email")
  WebElement enterEmailadd;

  @FindBy(css = "input#Hotels")
  WebElement enterCheckIndate;

  @FindBy(css = "body > div:nth-child(27) > div.datepicker-days")
  WebElement selectCheckInDate;

  @FindBy(css = "input.form-control.dpd2")
  WebElement enterCheckOutDate;

  @FindBy(css = "#s2id_autogen3")
  WebElement chooseHotelName;

  @FindBy(xpath = "//div[contains(text(),' Rendezvous Hotels ')]")
  WebElement selectHotelName;

  @FindBy(xpath = "//span[contains(text(),'Select Room')]")
  WebElement chooseRoomName;

  @FindBy(xpath = "//div[contains(text(),'Delux Room')]")
  WebElement selectRoomName;

  @FindBy(css = "#stay")
  WebElement totalNights;

  @FindBy(css = "input[name='totalroomprice']")
  WebElement totalRoomPrice;

  @FindBy(css = "input[name='perNight']")
  WebElement perNightPrice;

  @FindBy(css = "#taxhotel")
  WebElement taxVatValue;

  @FindBy(css = "#b2c_markup")
  WebElement b2cMarkup;

  @FindBy(css = "#grandtotal")
  WebElement grandTotalActual;

  public void goToHomePage() {

    driver.get(baseUrl);

  }

  public String isUserOnHomePage() {
    String title = driver.getTitle();
    return title;
  }

  public void enterEmailPassword(String stringEmail, String Password) {
    // Util.waitTime(600);
    driverWait.until(ExpectedConditions.visibilityOf(enterEmail));
    Util.sendKey(enterEmail, emailEnter);
    Util.sendKey(enterPwd, passwrd);
    Util.waitTime(300);
    Util.click(clickLogon);
    Util.waitTime(200);
  }

  public boolean isUserOnDashBoard() {
    return Util.isDisplayed(verifyDashboard);

  }

  public void clickHotelandbooking() {
    Util.click(clickHotel);
    Util.waitTime(200);
    Util.click(clickBooking);
  }

  public void clickOnaddbooking() {
    Util.waitTime(100);
    Util.click(clickaddBooking);
  }

  public void selectHotelfromService() {
    Util.click(selectServiceType);
    Util.waitTime(400);
    Util.click(selectServiceTypeHotel);
  }

  public void selectDate(String month_year, String select_day) throws InterruptedException {
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

    for (int i = 0; i < elements.size(); i++) {
      System.out.println(elements.get(i).getText());

//Selecting the month
      if (elements.get(i).getText().equals(month_year)) {

//Selecting the date
        List<WebElement> days = driver.findElements(By.xpath("/html/body/div[4]"));

        for (WebElement d : days) {
          System.out.println(d.getText());
          if (d.getText().equals(select_day)) {
            d.click();
          }
        }
      }
    }
  }


  public void enterCustomerDetails(String CusName, String Fname, String lName, String mobileNum, String Email) {
    Util.waitTime(800);
    driverWait.until(ExpectedConditions.visibilityOf(selectCustomer));
    Util.waitTime(800);
    Util.sendKey(selectCustomer, CusName);
    Util.waitTime(400);
    Util.click(selectGuest);

    driverWait.until(ExpectedConditions.visibilityOf(selectGuest));
    Util.waitTime(300);
    Util.sendKey(enterFirstName, Fname);
    Util.waitTime(300);
    Util.sendKey(enterLastName, lName);
    Util.waitTime(300);
    Util.sendKey(enterMobileNumber, mobileNum);
    Util.waitTime(200);
    Util.sendKey(enterEmailadd, Email);
  }

  public void enterItemDetails(String checkIn, String checkOut, String roomQty) throws ParseException, InterruptedException {


    // split input string by " " space to get each word as String[]
    String[] dt = checkIn.split("/");
    // loop over the array from back
    String checkinDay = dt[0];

    //Click and open the Date Picker
    driverWait.until(ExpectedConditions.visibilityOf(enterCheckIndate));
    Util.sendKey(enterCheckIndate, checkIn);

    JavascriptExecutor je = (JavascriptExecutor) driver;
    je.executeScript("window.scrollBy(0,250)", chooseHotelName);


    WebElement dateWidget = driver.findElement(By.className("datepicker-days"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", dateWidget);

    List<WebElement> columns = dateWidget.findElements(By.tagName("tr"));

    for (WebElement cell : columns) {
      //Select 13th Date
      if (cell.getText().equals(checkinDay)) {
        System.out.println("===checkinday" + cell.getText());
        //System.out.println("cell"+cell.findElement(By.linkText(checkinDay)));
        cell.findElement(By.linkText(checkinDay)).click();
        break;
      }
    }

    Util.sendKey(enterCheckOutDate, checkOut);
    String[] dt2 = checkOut.split("/");
    // loop over the array from back

    WebElement dateWidget2 = driver.findElement(By.className("datepicker-days"));
    List<WebElement> columns2 = dateWidget2.findElements(By.tagName("tr"));


    for (WebElement cell : columns2) {
      //Select 13th Date
      if (cell.getText().equals(dt2[0])) {
        System.out.println("===02" + cell.getText());
        cell.findElement(By.linkText(dt2[0])).click();
        break;
      }
    }


    driver.findElement(By.xpath("//html")).click();

    Util.isDisplayed(chooseHotelName);
    Util.click(chooseHotelName);
    Util.waitTime(200);
    Util.click(selectHotelName);
    // driverWait.until(ExpectedConditions.visibilityOfAllElements(selectRoomName, selectRoomName));
    Util.click(chooseRoomName);

    Util.click(selectRoomName);


  }


  public int grandTotalasPerSelection() throws NumberFormatException {
    Util.waitTime(200);
/*

    int totalNight = Integer.parseInt(totalNights.getAttribute("value"));
    System.out.println("====total night"+ totalNight );

    Util.waitTime(500);
    int perNight = Integer.parseInt(perNightPrice.getAttribute("value"));
    System.out.println("====perNight"+perNight);
    Util.waitTime(500);
    int taxVat = Integer.parseInt(taxVatValue.getAttribute("value"));
    System.out.println("=====taxVat"+taxVat);
    Util.waitTime(500);
    int b2cMarkupValue = Integer.parseInt(b2cMarkup.getAttribute("value"));
    System.out.println("===b2cMarkupValue"+b2cMarkupValue);
*/

    Util.waitTime(500);
    int totalRoomPriceval = Integer.parseInt(totalRoomPrice.getText());
    System.out.println("----g--totalroompricevalu"+totalRoomPriceval);
/*
    Util.waitTime(400);   totalRoomPrice
    int taxVatValue = ((((totalNight*perNight)*2)/100)+ ( totalNight+perNight));
    Util.waitTime(400);
    int b2cmarkUpPercent = ( ( ( totalNight+perNight)*10)/100) ;

    int grandTotalValue = taxVatValue + b2cmarkUpPercent ;
    System.out.println("====grandTotalValue output"+grandTotalValue);
    return grandTotalValue;
   */
    return totalRoomPriceval;
  }


  public int grandTotalActual(){
    Util.waitTime(400);
    int grandTotalActualValue = Integer.parseInt(grandTotalActual.getAttribute("value"));
    System.out.println("Actual grand total value"+grandTotalActualValue);
    return grandTotalActualValue;
  }
}