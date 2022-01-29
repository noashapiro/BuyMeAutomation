import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RegistrationTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static RegistrationPage registrationPage = new RegistrationPage();

    @BeforeClass
    public static void BeforeAll(){
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://buyme.co.il/?modal=login");

    }

    @Test
    public static void test01_registration() {
        registrationPage.clickRegistration();
    }

    @Test
    public static void test02_fillName(){
        String name = registrationPage.enterFirstName();
        Assert.assertEquals(name, "Noa shapiro");
    }

    @Test
    public static void test03_fillEmail(){
        registrationPage.enterEmail();
    }

    @Test
    public static void test04_fillPassword(){
        registrationPage.enterPassword();
    }

    @Test
    public static void test04_reEnterPassword(){
        registrationPage.reEnterPassword();
    }

    @Test
    public static void test05_confirmRegistration(){
        registrationPage.pressRegistration();
    }



}
