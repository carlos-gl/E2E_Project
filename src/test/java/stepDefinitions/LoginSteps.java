package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginSteps {
  private LoginPage loginPage = new LoginPage();
  private InventoryPage inventoryPage = new InventoryPage();

  @Given("que estou na pagina de login")
  public void estouNaPaginaDeLogin() {
  }

  @When("eu insiro o nome de usuário {string}")
  public void insiroONomeDeUsuario(String username) {
    loginPage.enterUsername(username);
  }

  @When("insiro a senha {string}")
  public void insiroASenha(String password) {
    loginPage.enterPassword(password);
  }

  @When("clico no botão de login")
  public void clicoNoBotaoDeLogin() {
    loginPage.clickLogin();
  }

  @Then("devo ser redirecionado para a página de inventário")
  public void devoSerRedirecionadoParaAPaginaDeInventario() {
    Assert.assertTrue("A página de inventário não foi carregada.",
            inventoryPage.isInventoryPageDisplayed());
  }

  @Then("uma mensagem de erro deve ser exibida")
  public void umaMensagemDeErroDeveSerExibida() {
    Assert.assertTrue("A mensagem de erro não foi exibida.",
            loginPage.isErrorMessageDisplayed());
    String errorMessage = loginPage.getErrorMessageText();

    Assert.assertTrue("Mensagem de erro não correspondente.",
            errorMessage.contains("Username and password do not match any user in this service"));
  }
}
