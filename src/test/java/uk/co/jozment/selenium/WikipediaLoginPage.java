package uk.co.jozment.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaLoginPage {

    private WebDriver driver;

    @FindBy(id="wpName1")
    private WebElement usernameField;

    @FindBy(id="wpPassword1")
    private WebElement passwordField;

    @FindBy(id="wpLoginAttempt")
    private WebElement loginButton;

    @FindBy(id="pt-userpage")
    private WebElement loggedInHeader;

    public WikipediaLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static WikipediaLoginPage navigateTo(WebDriver driver) {
        driver.get("https://en.wikipedia.org/wiki/Special:UserLogin");
        return PageFactory.initElements(driver, WikipediaLoginPage.class);
    }

    public void login(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public String getLoginHeaderText() {
        return loggedInHeader.getText();
    }
}
