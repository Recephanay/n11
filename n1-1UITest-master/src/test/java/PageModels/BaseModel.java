package PageModels;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseModel  {
    public BaseModel(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    WebDriver webDriver;
    By txtSearchArea = By.id("searchData");
    By siteIcon = By.xpath("//a[@href='https://www.n11.com']");
    By txtComputerProduct = By.cssSelector(".productName");
    By next = By.xpath("//a[text()='2']");
    By basket = By.cssSelector(".product-add-cart");
    By count = By.cssSelector(".basketTotalNum");
    By delete = By.cssSelector(".removeProd");
    By deletmesage = By.xpath("//*[@class='cartEmptyText']/h2");
    By popup = By.cssSelector(".seg-popup-close");

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.n11.com/");


    }
    public boolean shouldPageSite(){
        return webDriver.findElement(siteIcon).isEnabled();

    }
    public void setSearchTextModel(String value){
        webDriver.findElement(txtSearchArea).sendKeys(value + Keys.ENTER);
    }
    public void quitWebBrowser(){
        webDriver.quit();
    }
    public void clickComputerProduct(){
        webDriver.findElements(txtComputerProduct).get(0).click();
    }
    public  void nextpage(){
        webDriver.findElement(next).click();
   }
   public void clicktBasket(){
        webDriver.findElement(basket).click();

   }
   public String clickcount(){
        return webDriver.findElement(count).getText();

   }
    public void clickMyBasketButton(){
        webDriver.findElement(count).click();

    }
   public void deleteProduct(){
      webDriver.findElement(delete).click();
   }
   public String deleteMesage(){
        return webDriver.findElement(deletmesage).getText();
   }

    public void closePopup() {
        webDriver.findElement(popup).click();
    }
}

