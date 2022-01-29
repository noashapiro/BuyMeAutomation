import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private WebDriver driver;

    public RegistrationPage(){
       this.driver = DriverSingleton.getDriverInstance();
    }

    public void registration() {
        clickLoginOrRegis();
        clickRegistration();
        enterFirstName();
        enterEmail();
        enterPassword();
        reEnterPassword();
        pressRegistration();
    }
    public void clickLoginOrRegis(){
        //clickElement(By.cssSelector("li[class=notSigned]"));
    }
    public void clickRegistration() {
        clickElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[1]/span"));
    }

    public String enterFirstName() {
        String nameElement = "/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input";
        sendKeysToElement(By.xpath(nameElement), "Noa Shapiro");
        String name = getTextFromElement(By.xpath(nameElement));
        return name;
    }

    public void enterEmail() {
       sendKeysToElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input"), "NoaShapiro@gmail.com");
    }

    public void enterPassword() {
    //    sendKeysToElement(By.cssSelector("input[placeholder=שם פרטי]"), "1234");

    }

    public void reEnterPassword() {
   //     sendKeysToElement(By.cssSelector("input[placeholder=שם פרטי]"), "1234");

    }

    public void pressRegistration() {
   //     clickElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div[1]/span"));
    }
}



