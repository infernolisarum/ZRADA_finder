package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import infrastructure.BrowserType;
import infrastructure.DriverManagerFactory;
import org.openqa.selenium.By;
import page_object.pages.UkrNetPage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UkrNetSteps extends BaseSteps {
    private UkrNetPage page;

    @Before
    public void initPage() {
        manager = DriverManagerFactory.getDriverManager (BrowserType.CHROME);
        driver = manager.getDriver ();
        page = new UkrNetPage (driver);
    }

    @After
    public void after() {
        manager.quitDriver ();
    }

    @Given ("I navigate to {string}")
    public void i_navigate_to(String string) {
        page.navigateTo (string);
    }

    @And("I waiting for page loading")
    public void i_waiting_for_page_loading() {
        page.waitForPageToLoad (By.xpath ("//section[@class='header__logo']//a//img"), 8);
    }

    @Then("I select all news publications from central column")
    public void i_select_all_news_publications_from_central_column() {
        page.findAllElementToFeedSection (By.xpath ("//article[@id='feed']"), 8);
    }

    @And("If among them I find news from {string} I report on the {string}")
    public void if_among_them_I_find_news_from_I_report_on_the(String string, String string2) {
        assertThat("!!!" + string2 + "!!! Contains news on the news page from " + string,
                page.checkForSeparatistPublication (string), is(true));
    }
}
