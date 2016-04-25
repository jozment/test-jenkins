package uk.co.jozment.selenium;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaSearchTest {

	private FirefoxDriver driver;

	@Before
	public void setupSelenium() {
		driver = new FirefoxDriver();
	}
	
	@After
	public void closeSelenium() {
		driver.close();
		driver.quit();
	}
	
	@Test public void search_wikipedia() {
		WikipediaHomePage homePage = WikipediaHomePage.navigateTo(driver);
		WikipediaArticlePage resultsPage = homePage.searchFor("george washington");
		assertThat(resultsPage.getArticleTitle(), containsString("George Washington"));
	}

	@Test public void log_in_to_wikipedia() {
		WikipediaLoginPage loginPage = WikipediaLoginPage.navigateTo(driver);
		loginPage.login("The.ether.eel", "test-jenkins");
        assertThat(loginPage.getLoginHeaderText(), containsString("The.ether.eel"));
    }
}
