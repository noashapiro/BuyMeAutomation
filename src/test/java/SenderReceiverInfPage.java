import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        clickElement(By.xpath("//*[@id=\"ember1604\"]")); //choose birthday
    }

    public void enterBlessing(){
        sendKeysToElement(By.xpath("//*[@id=\"ember1295\"]/textarea"), "Mazal Tov");
    }

    public void uploadPic(){

    }

    public void pressContinue(){
        clickElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/button"));
    }

    public void pressNow(){
        clickElement(By.xpath("//*[@id=\"ember2863\"]/svg/circle[1]"));
    }

    public void pickEmailOrSms(){
        clickElement(By.xpath("//*[@id=\"ember2872\"]/div[2]/div[1]/svg/path[1]"));
    }

    public void enterEmailOrNum(){
        sendKeysToElement(By.id("email"), "ns@gmail.com");
    }

    public void enterSenderName(){
        sendKeysToElement(By.xpath("//*[@id=\"ember2892\"]"), "Noa");
    }

    public void pressPayment(){
        clickElement(By.xpath("//*[@id=\"ember2897\"]"));
    }

}
