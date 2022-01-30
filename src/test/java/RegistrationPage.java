import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    private WebDriver driver;

    private By loginOrRegisButton = By.cssSelector("li[class=notSigned]");
    private By registrationButton = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[1]/span");
    private By nameInputBox = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input");
    private By eMailInputBox = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input");
    private By passwordInputBox = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input");
    private By reEnterPasswordInputBox = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input");
    private By endRegisButton = By.cssSelector("button[type=submit]");


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
        clickElement(loginOrRegisButton);
    }

    public void clickRegistration() {
        clickElement(registrationButton);
    }

    public void enterFirstName() {
        sendKeysToElement(nameInputBox, "Noa Shapiro");
    }

    public String getTextFromNameElement(){
        return getTextFromElement(nameInputBox);
    }

    public void enterEmail() {
       sendKeysToElement(eMailInputBox, "NoaShapiro@gmail.com");
    }

    public void enterPassword() {
      sendKeysToElement(passwordInputBox, "123456Nn");

    }

    public void reEnterPassword() {
        sendKeysToElement(reEnterPasswordInputBox, "123456Nn");
    }

    public void pressRegistration() {
         clickElement(endRegisButton);
    }
}



