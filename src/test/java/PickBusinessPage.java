import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PickBusinessPage extends BasePage{

    private WebDriver driver;

    public PickBusinessPage(){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void PickBusiness(){
        clickElement(By.xpath("//*[@id=\"ember1436\"]/div[2]/span"));
    }

    public void EnterPrice(){
        sendKeysToElement(By.xpath("//*[@id=\"ember1870\"]"), "10");
    }

    public void PressChoice(){
        clickElement(By.xpath("//*[@id=\"ember2145\"]"));
    }



}
