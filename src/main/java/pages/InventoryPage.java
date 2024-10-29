package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InventoryPage {
  private WebDriver driver;

  // Localizadores para os elementos da página de inventário
  private final By addToCartButton = By.cssSelector(".btn_inventory");
  private final By cartIcon = By.id("shopping_cart_container");
  private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";

  // Construtor que inicializa o driver
  public InventoryPage() {
    this.driver = DriverFactory.getDriver();
  }

  // Método para adicionar um produto ao carrinho
  public void addRandomProductToCart() {
    // Obtém todos os botões de adicionar ao carrinho
    List<WebElement> addToCartButtons = driver.findElements(addToCartButton);

    // Verifica se há produtos disponíveis para adicionar
    if (!addToCartButtons.isEmpty()) {
      int randomIndex = new Random().nextInt(addToCartButtons.size());
      addToCartButtons.get(randomIndex).click();
    } else {
      throw new RuntimeException("Não há produtos disponíveis para adicionar ao carrinho.");
    }
  }

  private double getProductPrice(WebElement product) {
    String priceText = product.findElement(By.cssSelector(".inventory_item_price")).getText(); // Seletor do preço
    return Double.parseDouble(priceText.replace("$", "").trim());
  }
  // Método para acessar o carrinho
  public void goToCart() {
    driver.findElement(cartIcon).click();
  }

  // Método para verificar se a página de inventário está visível
  public boolean isInventoryPageDisplayed() {
    return driver.getCurrentUrl().equals(INVENTORY_URL);
  }

}
