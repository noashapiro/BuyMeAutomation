package Pages;
import Infrastructure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private WebDriver driver;

    private By loginOrRegisButton = By.cssSelector("li[class=notSigned]");
    private By registrationButton = By.cssSelector(".register-or-login .text-link");
    private By nameInputBox = By.cssSelector("input[placeholder=\"שם פרטי\"]");
    private By eMailInputBox = By.cssSelector("input[type=\"email\"]");
    private By passwordInputBox = By.id("valPass");
    private By reEnterPasswordInputBox = By.cssSelector("input[placeholder=\"אימות סיסמה\"]");
    private By endRegisButton = By.cssSelector("button[type=submit]");


    public RegistrationPage(){
       this.driver = DriverSingleton.getDriverInstance();
    }

    public void registration() {
        clickRegistration();
        enterFirstName();
        enterEmail();
        enterPassword();
        reEnterPassword();
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
    public String getTextFromEmailElement(){
        return getTextFromElement(eMailInputBox);
    }
    public String getTextFromPasswordElement(){
        return getTextFromElement(passwordInputBox);
    }
    public String getTextFromRePassElement(){
        return getTextFromElement(reEnterPasswordInputBox);
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



