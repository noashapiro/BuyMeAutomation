import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Buy Me automation test", "Sample description");


    public void clickElement(By locator) {
        try {
            getWebElement(locator).click();
        }catch (NoSuchElementException e){
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(DriverSingleton.getDriverInstance(), "NotFoundElement")).build());
        }

    }

    public void sendKeysToElement(By locator, String text) {
        try {
            getWebElement(locator).clear();
            getWebElement(locator).sendKeys(text);
        }catch (NoSuchElementException e){
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(Utils.takeScreenShot(DriverSingleton.getDriverInstance(), "NotFoundElement")).build());
        }
    }

    public String getTextFromElement(By locator){
        return getWebElement(locator).getText();
    }

    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
