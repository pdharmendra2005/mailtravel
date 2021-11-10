package StepDefinition;

import Mailtravel.Webpages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

  @Before
  public void openBrowser(){
      startBrowser(browserType);
  }
 @After
  public void quitBrowser(){
      exit();
  }

}
