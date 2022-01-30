import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {

    private static WebDriver driver;
    private static HomePage homePage = new HomePage();
    private static PickBusinessPage pickBusinessPage = new PickBusinessPage();
    private static SenderReceiverInfPage senderReceiverInfPage = new SenderReceiverInfPage();


    @BeforeClass
    public static void BeforeAll(){
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public static void test01_selectPrice(){
        homePage.pickPrice();
    }

    @Test
    public static void test02_selectArea(){
        homePage.pickArea();
    }

    @Test
    public static void test02_selectCategory(){
        homePage.pickCategory();
    }

    @Test
    public static void test03_findClick(){
        homePage.clickFindButton();
    }

    @Test
    public static void test01_assertUrl(){
        String url = "https://buyme.co.il/search?budget=1&category=16&region=14";
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Test
    public static void test02_pickBusiness(){
        //driver.get("https://buyme.co.il/search?budget=1&category=16&region=14");
        pickBusinessPage.PickBusiness();
    }

    @Test
    public static void test03_pickPrice(){
        pickBusinessPage.EnterPrice();
    }

    @Test
    public static void test04_clickChoiceButton(){
        pickBusinessPage.PressChoice();
    }

    @Test
    public static void test01_clickForSomeOne(){
        driver.get("https://buyme.co.il/money/1290005?price=100");
        senderReceiverInfPage.someBodyElseButton();
    }

    @Test
    public static void test02_receiverName(){
       driver.get("https://buyme.co.il/money/1290005?price=100");
        senderReceiverInfPage.receiverName();
    }

    @Test
    public static void test03_pickEvent(){
        driver.get("https://buyme.co.il/money/1290005?price=100");
        senderReceiverInfPage.pickAnEvent();
    }

    @Test
    public static void test04_blessing(){
        driver.get("https://buyme.co.il/money/1290005?price=100");
        senderReceiverInfPage.enterBlessing();
    }

    @Test
    public static void test05_uploadPic(){
       senderReceiverInfPage.uploadPic();
    }

    @Test
    public static void test06_pressContinue(){
        driver.get("https://buyme.co.il/money/1290005?price=100");
        senderReceiverInfPage.pressContinue();
    }

    @Test
    public static void test07_pressNow(){
        senderReceiverInfPage.pressNow();
    }


    @Test
    public static void test08_pickEmail(){
        senderReceiverInfPage.pickEmailOrSms();
    }

    @Test
    public static void test09_enterEmail(){
        senderReceiverInfPage.enterEmailOrNum();
    }

    @Test
    public static void test10_senderName(){
        senderReceiverInfPage.enterSenderName();
    }

    @Test
    public static void test11_payment() {
        senderReceiverInfPage.pressPayment();
    }

    @AfterClass
    public static void AfterAll(){
        driver.quit();
    }

}
