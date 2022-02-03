import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SenderReceiverInfPage extends BasePage {
    private WebDriver driver;

    public SenderReceiverInfPage(){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void someBodyElseButton(){
        clickElement(By.className("button-forSomeone"));
    }

    public void receiverName(){ sendKeysToElement(By.className("ember-text-field"), "Shai");}


    public void pickAnEvent(){
        clickElement(By.className("selected-text")); //click on dropdown
        clickElement(By.cssSelector("li[value=\"10\"]")); //choose birthday
    }

    public void enterBlessing(String blessing){
        sendKeysToElement(By.cssSelector("textarea[placeholder=\"מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים\""), blessing);
    }

    //????
    public void uploadPic(){
        String picPath = "C:\\Users\\97250\\Desktop\\pand.JPEG";
        WebElement myElement = driver.findElement(By.cssSelector("input[type=\"file\"]"));
        String js = "arguments[0].setAttribute('value','"+picPath+"')";
        ((JavascriptExecutor) driver).executeScript(js, myElement);
    }

    public void pressContinue(){
        clickElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public void pressNow(){
        clickElement(By.xpath("//*[@id=\"ember4071\"]/svg/circle[1]"));
    }

    public void pickEmailOrSms(){
          clickElement(By.cssSelector("div:nth-child(2) > div.circle-area"));
    }

    public void enterEmailOrNum(){
        sendKeysToElement(By.id("email"), "ns@gmail.com");
    }

    public void enterSenderName(){
        sendKeysToElement(By.cssSelector("input[type=\"text\"]"), "Noa");
    }

    public void pressPayment(){
        clickElement(By.cssSelector("button[type=\"submit\"]"));
    }

}
