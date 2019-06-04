package page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.BasePage;
import zmq.util.Objects;

import java.util.List;

public class UkrNetPage extends BasePage {

    public UkrNetPage(WebDriver driver) {
        super (driver);
    }

    private List<WebElement> resultList;

    public void findAllElementToFeedSection(){
        resultList = findVisibleElements (By.id ("feed"), 8);
    }

    public boolean checkForSeparatistPublication(String separName){
        Objects.requireNonNull (resultList, "List with publications is empty,"
                + " please use findAllElementToFeedSection method before the operation");
        for (WebElement element:resultList) {
            if (element.getText ().equalsIgnoreCase (separName))
                return true;
        }
        return false;
    }

    @Override
    public void waitForPageToLoad(){
        waitForElementVisibility (By.className ("header__logo"), 8);
    }
}
