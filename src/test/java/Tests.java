import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {

    private static WebDriver driver;
    private static HomePage homePage = new HomePage();
    private static PickBusinessPage pickBusinessPage = new PickBusinessPage();


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

    }

    @Test
    public static void test02_pickBusiness(){
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

}
