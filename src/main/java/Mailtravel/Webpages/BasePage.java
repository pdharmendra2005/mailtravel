package Mailtravel.Webpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BasePage {

  public static String baseUrl = "https://www.mailtravel.co.uk/";
  public static WebDriver driver;
  public static String browserType = "chrome";
  public static String searchIndiaHoliday = "India";

  public static void startBrowser(String browser){
    System.out.println("========i m in start browser");
      if(browser.equalsIgnoreCase("chrome")){
        System.out.println("i m in start browser");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver();
      }

      else if(browser.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        driver = new FirefoxDriver(firefoxOptions);
      }
      driver.manage().window().maximize();

  }
    public void exit(){
      driver.quit();
    }

}
