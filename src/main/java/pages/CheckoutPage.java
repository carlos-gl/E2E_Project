package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class CheckoutPage {
  private WebDriver driver;

  // Localizadores para os campos e botões da página de checkout
  private final By firstNameField = By.id("first-name");
  private final By lastNameField = By.id("last-name");
  private final By postalCodeField = By.id("postal-code");
  private final By continueButton = By.id("continue");
  private final By errorMessage = By.cssSelector(".error-message-container");

  // Construtor que inicializa o driver
  public CheckoutPage() {
    this.driver = DriverFactory.getDriver();
  }

  // Métodos para inserir informações do cliente
  public void enterFirstName(String firstName) {
    driver.findElement(firstNameField).sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    driver.findElement(lastNameField).sendKeys(lastName);
  }

  public void enterPostalCode(String postalCode) {
    driver.findElement(postalCodeField).sendKeys(postalCode);
  }

  // Método para continuar para a próxima etapa do checkout
  public void clickContinue() {
    driver.findElement(continueButton).click();
  }
  public boolean isErrorMessageDisplayed() {
    return !driver.findElements(errorMessage).isEmpty();
  }

  public String getErrorMessageText() {
    return driver.findElement(errorMessage).getText();
  }
}
