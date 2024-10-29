package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class CartPage {
  private WebDriver driver;

  // Localizadores para os elementos da página do carrinho
  private final By checkoutButton = By.id("checkout");

  // Construtor que inicializa o driver
  public CartPage() {
    this.driver = DriverFactory.getDriver();
  }

  // Método para prosseguir com o checkout
  public void clickCheckout() {
    driver.findElement(checkoutButton).click();
  }
}
