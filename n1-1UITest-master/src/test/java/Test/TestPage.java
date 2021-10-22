package Test;
import PageModels.BaseModel;
import PageModels.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPage {
    WebDriver webDriver;

    BaseModel baseModel = new BaseModel(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void ComputerProductTest(){
        baseModel.setUp();
        Assert.assertTrue(baseModel.shouldPageSite(), "Websıte yüklenmedı");
        baseModel.closePopup();
        //loginPage.login("hanayrecep@gmail.com","15711571203h");
        baseModel.setSearchTextModel("Bilgisayar");
        baseModel.nextpage();
        baseModel.clickComputerProduct();
        baseModel.clicktBasket();
        Assert.assertEquals(baseModel.clickcount(),"1","Sepettekı ürün sayısı yanlış");
        baseModel.clickMyBasketButton();
        baseModel.deleteProduct();
        Assert.assertEquals(baseModel.deleteMesage()=="Sepetinizde ürün bulunmamaktadır.","İlgili mesaj görüntülenmedi");

        baseModel.quitWebBrowser();

    }
}
