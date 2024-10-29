package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class LoginPage {
  private WebDriver driver;

  // Localizadores dos elementos da página de login
  private final By usernameField = By.id("user-name");
  private final By passwordField = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = By.cssSelector(".error-message-container");

  public LoginPage() {
    this.driver = DriverFactory.getDriver();
  }

  public void enterUsername(String username) {
    driver.findElement(usernameField).sendKeys(username);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
  }

  public void clickLogin() {
    driver.findElement(loginButton).click();
  }

  public boolean isErrorMessageDisplayed() {
    return !driver.findElements(errorMessage).isEmpty();
  }

  public String getErrorMessageText() {
    return driver.findElement(errorMessage).getText();
  }
}
