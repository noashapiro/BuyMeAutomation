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

    public void receiverName(){
        sendKeysToElement(By.xpath("//*[@id=\"ember1278\"]"), "Shai");
    }

    public void pickAnEvent(){
        clickElement(By.className("selected-text")); //click on dropdown
        clickElement(By.cssSelector("li[value=\"10\"]")); //choose birthday
    }

    public void enterBlessing(String blessing){
        sendKeysToElement(By.cssSelector("textarea[placeholder=\"מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים\""), blessing);
    }

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
        clickElement(By.cssSelector("circle[class=\"fill\"]"));
    }

    public void pickEmailOrSms(){
        clickElement(By.xpath("//*[@id=\"ember1648\"]/div[2]/div[1]/svg/path[1]"));
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
