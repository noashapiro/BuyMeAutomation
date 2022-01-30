import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator){
        return getWebElement(locator).getText();
    }


    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
