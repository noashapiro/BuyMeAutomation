package BuyMeTests;
import Pages.*;
import Infrastructure.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {

    private static WebDriver driver;
    private static WebDriverWait wait;
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
        test.info("Click registration Or Login");
        try{
            registrationPage.clickLoginOrRegis();
            test.log(Status.PASS, "registrationOrLogin passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @Test(priority = 2)
    public static void registration() {
        test.info("Registration to buy me");
        try{
            registrationPage.registration();
            test.log(Status.PASS, "registration passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
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
        test.info("confirmRegistration");
        try{
            registrationPage.pressRegistration();
            test.log(Status.PASS, "confirm registration passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }


    @Test(priority = 5)
    public static void homePage(){
        test.info("homePage");
        try{
            homePage.pickPrice();
            homePage.pickArea();
            homePage.pickCategory();
            homePage.clickFindButton();
            test.log(Status.PASS, "choose price, area and category passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @Test(priority = 5)
    public static void assertUrl(){
        String url = "https://buyme.co.il/search?budget=1&category=16&region=14";
        test.info("assertUrl");
        try{
            Assert.assertEquals(url, driver.getCurrentUrl());
            test.log(Status.PASS, "assertUrl passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @Test(priority = 6)
    public static void pickBusiness(){
        test.info("pickBusiness");
        try{
            pickBusinessPage.PickBusiness();
            pickBusinessPage.EnterPrice("100");
            pickBusinessPage.PressChoice();
            test.log(Status.PASS, "pickBusiness passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @Test(priority = 7)
    public static void fillDetails_firstStep(){
        test.info("fillDetails");
        try{
            senderReceiverInfPage.someBodyElseButton();
            senderReceiverInfPage.receiverName();
            senderReceiverInfPage.pickAnEvent();
            senderReceiverInfPage.enterBlessing("MazalTov");
            senderReceiverInfPage.uploadPic();
            senderReceiverInfPage.pressContinue();
            test.log(Status.PASS, "fillDetails passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @Test(priority = 8)
    public static void fillDetails_secondStep(){
       // driver.get("https://buyme.co.il/money/1290005?price=1&step=2");
        test.info("fillDetails");
        try{
            senderReceiverInfPage.pressNow();
            senderReceiverInfPage.pickEmailOrSms();
            senderReceiverInfPage.enterEmailOrNum();
            senderReceiverInfPage.enterSenderName();
            senderReceiverInfPage.pressPayment();
            test.log(Status.PASS, "fillDetails passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            test.fail("The test has failed " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(driver, "NotFoundElement")).build());
        }
    }

    @AfterClass
    public static void AfterAll(){
        driver.quit();
        extent.flush();
    }
}
