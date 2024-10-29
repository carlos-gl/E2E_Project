package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

public class CheckoutSteps {
  private final InventoryPage inventoryPage = new InventoryPage();
  private final CartPage cartPage = new CartPage();
  private final CheckoutPage checkoutPage = new CheckoutPage();
  private final CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

  @When("eu adiciono o primeiro produto ao carrinho")
  public void euAdicionoOPrimeiroProdutoAoCarrinho() {
    inventoryPage.addRandomProductToCart();
  }

  @When("navego para o carrinho")
  public void navegoParaOCarrinho() {
    inventoryPage.goToCart();
  }
  @When("verifico se o produto foi adicionado")
  public void verificoSeOProdutoFoiAdicionado() {
    inventoryPage.goToCart();
  }

  @When("clico no botão de checkout")
  public void clicoNoBotaoDeCheckout() {
    cartPage.clickCheckout();
  }

  @When("preencho o primeiro nome com {string}")
  public void preenchoOPrimeiroNomeCom(String firstName) {
    checkoutPage.enterFirstName(firstName);
  }

  @When("preencho o sobrenome com {string}")
  public void preenchoOSobrenomeCom(String lastName) {
    checkoutPage.enterLastName(lastName);
  }

  @When("deixo o campo de sobrenome em branco")
  public void deixoOCampoDeSobrenomeEmBranco() {
    checkoutPage.enterLastName(""); //
  }

  @When("preencho o código postal com {string}")
  public void preenchoOCodigoPostalCom(String postalCode) {
    checkoutPage.enterPostalCode(postalCode);
  }

  @When("clico no botão de continuar")
  public void clicoNoBotaoDeContinuar() {
    checkoutPage.clickContinue();
  }

  @When("verifico o total do pedido")
  public void verificoOTotalDoPedido() {
    String total = checkoutOverviewPage.getOrderTotal();
    Assert.assertNotNull("O total do pedido deve ser exibido.", total);
  }

  @When("clico no botão de finalizar")
  public void clicoNoBotaoDeFinalizar() {
    checkoutOverviewPage.clickFinish();
  }

  @When("eu não adiciono produto ao carrinho")
  public void naoAdicionoProduto() {
    //
  }
  @Then("devo ver uma mensagem de confirmação de compra bem-sucedida")
  public void devoVerUmaMensagemDeConfirmacao() {
    // Verifica se a mensagem de confirmação está visível
    boolean isConfirmationDisplayed = checkoutOverviewPage.isConfirmationMessageDisplayed();
    Assert.assertTrue("Mensagem de confirmação não encontrada", isConfirmationDisplayed);

    String ConfirmationMessage = checkoutOverviewPage.getConfirmationMessageText();
    Assert.assertTrue("Mensagem de erro não correspondente.",
            ConfirmationMessage.contains("Thank you for your order!"));
  }

  @Then("uma mensagem de erro deve ser exibida indicando campos obrigatórios")
  public void umaMensagemDeErroDeveSerExibida() {
    boolean isErrorDisplayed = checkoutPage.isErrorMessageDisplayed();
    Assert.assertTrue("Mensagem de erro não encontrada", isErrorDisplayed);

    String errorMessage = checkoutPage.getErrorMessageText();
    Assert.assertTrue("Mensagem de erro não correspondente.",
            errorMessage.contains("Last Name is required"));
  }

}
