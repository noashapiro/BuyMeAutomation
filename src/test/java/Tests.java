import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
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
    private static RegistrationPage registrationPage = new RegistrationPage();
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Buy Me automation test", "Sample description");

    @BeforeClass
    public static void BeforeAll() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");

        driver = DriverSingleton.getDriverInstance();
        String url = Utils.getData("URL");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public static void registrationOrLogin(){
        try{
            registrationPage.clickLoginOrRegis();
            test.log(Status.PASS, "passed");
        }catch (WebDriverException e){
            test.log(Status.FAIL, "failed");
        }
    }

    @Test(priority = 2)
    public static void registration() {
        try{
            registrationPage.registration();
            test.log(Status.PASS, "passed");
        }catch (WebDriverException e){
            test.log(Status.FAIL, "failed");
        }
    }

    @Test(priority = 3)
    public static void assertAllField(){
        Assert.assertEquals(registrationPage.getTextFromNameElement(),"Noa Shapiro");
        Assert.assertEquals(registrationPage.getTextFromEmailElement(),"Noashapiro@gmail.com");
        Assert.assertEquals(registrationPage.getTextFromPasswordElement(),"123456Nn");
        Assert.assertEquals(registrationPage.getTextFromRePassElement(),"123456Nn");
    }

    @Test(priority = 4)
    public static void confirmRegistration(){
        registrationPage.pressRegistration();
    }


    @Test(priority = 5)
    public static void homePage(){
        homePage.pickPrice();
        homePage.pickArea();
        homePage.pickCategory();
        homePage.clickFindButton();
    }

    @Test(priority = 5)
    public static void assertUrl(){
        String url = "https://buyme.co.il/search?budget=1&category=16&region=14";
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Test(priority = 6)
    public static void pickBusiness(){
        pickBusinessPage.PickBusiness();
        pickBusinessPage.EnterPrice("100");
        pickBusinessPage.PressChoice();
    }

    @Test(priority = 7)
    public static void fillDetails_firstStep(){
        driver.get("https://buyme.co.il/money/1290005?price=1");
        senderReceiverInfPage.someBodyElseButton();
        senderReceiverInfPage.receiverName();
        senderReceiverInfPage.pickAnEvent();
        senderReceiverInfPage.enterBlessing("MazalTov");
        senderReceiverInfPage.uploadPic();
        senderReceiverInfPage.pressContinue();
        senderReceiverInfPage.pressNow();
        senderReceiverInfPage.pickEmailOrSms();
        senderReceiverInfPage.enterEmailOrNum();
        senderReceiverInfPage.enterSenderName();
        senderReceiverInfPage.pressPayment();
    }

    @Test(priority = 8)
    public static void fillDetails_secondStep(){
        senderReceiverInfPage.pressNow();
        senderReceiverInfPage.pickEmailOrSms();
        senderReceiverInfPage.enterEmailOrNum();
        senderReceiverInfPage.enterSenderName();
        senderReceiverInfPage.pressPayment();
    }

    @AfterClass
    public static void AfterAll(){
        //driver.quit();
        extent.flush();
    }
}
