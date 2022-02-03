package Infrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public void clickElement(By locator) {
            getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
            getWebElement(locator).clear();
            getWebElement(locator).click();
            getWebElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator){
        getWebElement(locator).click();
        return getWebElement(locator).getText();
    }

    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
