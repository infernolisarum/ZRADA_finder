package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import infrastructure.BrowserType;
import infrastructure.DriverManagerFactory;
import org.junit.Assert;
import page_object.pages.UkrNetPage;

import static org.hamcrest.core.Is.is;

public class UkrNetSteps extends BaseSteps {
    private UkrNetPage ukrNetPage;

    @Before
    public void initPage() {
        manager = DriverManagerFactory.getDriverManager (BrowserType.CHROME);
        driver = manager.getDriver ();
        ukrNetPage = new UkrNetPage (driver);
    }

    @After
    public void after() {
        manager.quitDriver ();
    }

    @Given ("I navigate to {string}")
    public void i_navigate_to(String string) {
        ukrNetPage.navigateTo (string);
    }

    @And("I am waiting for ukrNetPage loading")
    public void i_waiting_for_page_loading() {
        ukrNetPage.waitForPageToLoad ();
    }

    @Then("I select all news publications from central column")
    public void i_select_all_news_publications_from_central_column() {
        ukrNetPage.findAllElementToFeedSection ();
    }

    @And("If among them I find news from {string} I report on the {string}")
    public void if_among_them_I_find_news_from_I_report_on_the(String string, String string2) {
        Assert.assertThat("!!!" + string2 + "!!! UkrNet page contains news from " + string,
                ukrNetPage.checkForSeparatistPublication (string), is(true));
    }
}
