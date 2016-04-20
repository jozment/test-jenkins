package uk.co.jozment.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikipediaArticlePage {

	private WebDriver driver;
	
	@FindBy(id="firstHeading")
	private WebElement articleTitle;
	
	public WikipediaArticlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getArticleTitle() {
		return articleTitle.getText();
	}

}
