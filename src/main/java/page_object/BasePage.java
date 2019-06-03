package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findVisibleElement(By by, int seconds) {
        Wait <WebDriver> wait = new WebDriverWait (driver, seconds);
        return wait.until (ExpectedConditions.visibilityOfElementLocated (by));
    }

    protected List <WebElement> findVisibleElements(By by, int seconds) {
        Wait <WebDriver> wait = new WebDriverWait (driver, seconds);
        return wait.until (ExpectedConditions.visibilityOfAllElementsLocatedBy (by));
    }

    protected void waitForElementVisibility(By by, int seconds){
        Wait<WebDriver> wait = new WebDriverWait (driver, seconds);
        wait.until (ExpectedConditions.visibilityOfElementLocated (by));
    }

    protected void waitForElementsVisibility(By by, int seconds){
        Wait<WebDriver> wait = new WebDriverWait (driver, seconds);
        wait.until (ExpectedConditions.visibilityOfAllElementsLocatedBy (by));
    }

    public void navigateTo(String URL){
        driver.get (URL);
    }

    public void waitForPageToLoad(){
        throw new NotImplementedException ();
    }
}
