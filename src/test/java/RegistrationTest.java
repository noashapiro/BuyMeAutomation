import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest {
    private static WebDriver driver;
    private static RegistrationPage registrationPage = new RegistrationPage();

    @BeforeClass
    public static void BeforeAll(){
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://buyme.co.il");
        driver.manage().window().maximize();
    }

    @Test
    public static void test00_registrationOrLogin(){
        registrationPage.clickLoginOrRegis();
    }
    @Test
    public static void test01_registration() {
        registrationPage.clickRegistration();
    }

    @Test
    public static void test02_fillName(){
        registrationPage.enterFirstName();
        //Assert.assertEquals(name, "Noa shapiro");
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
    public static void test05_assertAllFields(){
        String name = registrationPage.getTextFromNameElement();
        Assert.assertEquals(name, "Noa Shapiro");
    }

    @Test
    public static void test06_confirmRegistration(){
        registrationPage.pressRegistration();
    }

    @AfterClass
    public static void afterAll(){
        driver.quit();
    }
}
