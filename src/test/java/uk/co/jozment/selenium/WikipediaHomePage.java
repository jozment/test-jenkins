package uk.co.jozment.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage {

	private WebDriver driver;
	
	@FindBy(id="searchInput")
	private WebElement searchField;
	
	@FindBy(id="searchButton")
	private WebElement goButton;

	@FindBy(id="pt-login")
    private WebElement loginLink;
	
	public WikipediaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public static WikipediaHomePage navigateTo(WebDriver driver) {
		driver.get("https://en.wikipedia.org/");
		return PageFactory.initElements(driver, WikipediaHomePage.class);
	}
	
	public WikipediaArticlePage searchFor(String searchTerm) {
		searchField.sendKeys(searchTerm);
		searchField.submit();
		
		return PageFactory.initElements(driver, WikipediaArticlePage.class);
	}

    public WikipediaLoginPage clickLoginLink(WebDriver driver) {
        loginLink.click();

        return PageFactory.initElements(driver, WikipediaLoginPage.class);
    }
}
