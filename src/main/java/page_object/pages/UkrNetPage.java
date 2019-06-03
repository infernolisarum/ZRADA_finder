package page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_object.BasePage;

import java.util.List;

public class UkrNetPage extends BasePage {
    public UkrNetPage(WebDriver driver) {
        super (driver);
    }

    List<WebElement> resultList;

    public void findAllElementToFeedSection(By by, int seconds){
        resultList = findVisibleElements (by, seconds);
    }

    public boolean checkForSeparatistPublication(String separName){
        for (WebElement element:resultList
             ) {
            if (element.getText ().equalsIgnoreCase (separName))
                return true;
        }
        return false;
    }
}
