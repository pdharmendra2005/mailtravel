package Mailtravel.Webpages;

import Mailtravel.Utility.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DailyMailTravel extends BasePage {


  public DailyMailTravel(){
    System.out.println("constructor"+driver);
    PageFactory.initElements(driver,this);
  }


 /* @FindBy (id = "")
  WebElement clickSearch;
*/
  /*public void goToHomePage(){
    driver.get(baseUrl);
  }
*/
  public void goToHomePage() {
    System.out.println("I am inside homePage");
    System.out.println("driver"+driver);
    driver.get(baseUrl);

  }
  public String isUserOnHomePage(){
    String title = driver.getTitle();
    return title;
  }



}
