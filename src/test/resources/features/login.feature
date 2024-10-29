Feature: Login

  @AllTests
  Scenario: Login bem-sucedido com credenciais válidas
    Given que estou na pagina de login
    When eu insiro o nome de usuário "standard_user"
    And insiro a senha "secret_sauce"
    And clico no botão de login
    Then devo ser redirecionado para a página de inventário

  @AllTests
  Scenario: Login falha com credenciais inválidas
    Given que estou na pagina de login
    When eu insiro o nome de usuário "usuario_invalido"
    And insiro a senha "senha_errada"
    And clico no botão de login
    Then uma mensagem de erro deve ser exibida
