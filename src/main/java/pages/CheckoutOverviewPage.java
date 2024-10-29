package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class CheckoutOverviewPage {
  private WebDriver driver;

  // Localizadores para os elementos da página de checkout
  private final By finishButton = By.id("finish");
  private final By summaryTotalLabel = By.className("summary_total_label");
  private final By confirmationMessage = By.cssSelector(".complete-header");

  // Construtor da classe que inicializa o WebDriver
  public CheckoutOverviewPage() {
    this.driver = DriverFactory.getDriver();
  }

  // Método que retorna o total do pedido
  public String getOrderTotal() {
    return driver.findElement(summaryTotalLabel).getText();
  }

  // Método que verifica se a mensagem de confirmação está visível
  public boolean isConfirmationMessageDisplayed() {
    return !driver.findElements(confirmationMessage).isEmpty();
  }

  // Método que clica no botão de finalizar compra
  public void clickFinish() {
    driver.findElement(finishButton).click();
  }

  // Método que retorna o texto da mensagem de confirmação
  public String getConfirmationMessageText() {
    return driver.findElement(confirmationMessage).getText();
  }
}
