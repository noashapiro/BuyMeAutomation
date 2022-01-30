import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void pickPrice(){
        clickElement(By.xpath("//*[@id=\"ember1034\"]/div/div[1]/span"));
        clickElement(By.xpath("//*[@id=\"ember1056\"]"));
        // clickChoiceFromSelect(By.xpath("//*[@id=\"ember1034\"]/div/div[1]/span"), "2");
    }

    public void pickArea(){
        clickElement(By.xpath("//*[@id=\"ember1069\"]/div/div[1]/span"));
        clickElement(By.xpath("//*[@id=\"ember1095\"]/span"));
    }

    public void pickCategory(){
        clickElement(By.xpath("//*[@id=\"ember1101\"]/div/div[1]"));
        clickElement(By.xpath("//*[@id=\"ember1156\"]/span"));
    }

    public void clickFindButton(){
        clickElement(By.xpath("//*[@id=\"ember1180\"]"));
    }


}
