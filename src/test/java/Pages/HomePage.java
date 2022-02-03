package Pages;
import Infrastructure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;

    private By Parent = By.className("search-bar-wrapper");

    private By amount = By.cssSelector("span[title=\"סכום\"]");
    private By selectAmount = By.cssSelector("li[value=\"1\"]");

    private By area = By.cssSelector("span[title=\"אזור\"]");
    private By selectArea = By.cssSelector("li[value=\"14\"]");

    private By category = By.cssSelector("span[title=\"קטגוריה\"]");
    private By selectCategory = By.cssSelector("li[value=\"16\"]");

    private By submit = By.cssSelector("a[rel=\"nofollow\"]");

    public HomePage(){
        this.driver = DriverSingleton.getDriverInstance();
    }

    public void pickPrice(){
        clickElement(amount);
        clickElement(selectAmount);
    }

    public void pickArea(){
        clickElement(area);
        clickElement(selectArea);
    }

    public void pickCategory(){
        clickElement(category);
        clickElement(selectCategory);
    }

    public void clickFindButton(){
        clickElement(submit);
    }

}
