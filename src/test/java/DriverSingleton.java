import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSingleton {
    private static WebDriver driver;


    public static WebDriver getDriverInstance(){
        if(driver == null){
            String type = null;
            try {
                type = Utils.getData("browserType");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(type.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            }else if(type.equals("FF")){
                System.setProperty("webdriver.gecko.driver", Constants.FFDRIVER_PATH);
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
