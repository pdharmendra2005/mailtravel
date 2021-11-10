package Mailtravel.Webpages;

import Mailtravel.Utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DailyMailTravel extends BasePage {


  public DailyMailTravel(){
    System.out.println("constructor"+driver);
    PageFactory.initElements(driver,this);
  }


  @FindBy (css = "#searchtext_freetext_search_form")
  WebElement searchText;

  @FindBy (css = "#freetext_search_form > form > button > div")
  WebElement searchClick;

 // @FindBy ( css = "#iterator_1_product_custom_product-price-row > div > div > span ")
 // WebElement moreInfoClick;

 // @FindBy ( css = "button[id='iterator_1_product_custom_more-info-button']")
  //WebElement moreInfoClick;

  @FindBy ( xpath = "//*[text()='More info']")
  WebElement moreInfoClick;
  //button[@id='iterator_1_product_custom_more-info-button']

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
    System.out.println("Title "+title);
    return title;
  }


  public void searchIndia(String string) {
    Util.sendKey(searchText, BasePage.searchIndiaHoliday);
    Util.click(searchClick);

  }

  public void clickMoreInfo() {
   // Util.click(driver.findElement(By.cssSelector("div[class='optanon-clearfix optanon-alert-box-bottom-padding']")));

    Util.click(moreInfoClick);
  }
}
