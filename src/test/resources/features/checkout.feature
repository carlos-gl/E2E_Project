Feature: Checkout

  @AllTests
  Scenario: Adicionar produto ao carrinho e finalizar compra com sucesso
    Given que estou na pagina de login
    When eu insiro o nome de usuário "standard_user"
    And insiro a senha "secret_sauce"
    And clico no botão de login
    When eu adiciono o primeiro produto ao carrinho
    And navego para o carrinho
    And verifico se o produto foi adicionado
    And clico no botão de checkout
    And preencho o primeiro nome com "João"
    And preencho o sobrenome com "Silva"
    And preencho o código postal com "12345"
    And clico no botão de continuar
    And verifico o total do pedido
    And clico no botão de finalizar
    Then devo ver uma mensagem de confirmação de compra bem-sucedida

  @AllTests
  Scenario: Falha ao tentar finalizar compra sem preencher todos os campos obrigatórios
    Given que estou na pagina de login
    When eu insiro o nome de usuário "standard_user"
    And insiro a senha "secret_sauce"
    And clico no botão de login
    When eu adiciono o primeiro produto ao carrinho
    And navego para o carrinho
    And clico no botão de checkout
    And preencho o primeiro nome com "João"
    And deixo o campo de sobrenome em branco
    And preencho o código postal com "12345"
    And clico no botão de continuar
    Then uma mensagem de erro deve ser exibida indicando campos obrigatórios

  @AllTests
  Scenario: Falha ao tentar finalizar compra sem preencher produtos
    Given que estou na pagina de login
    When eu insiro o nome de usuário "standard_user"
    And insiro a senha "secret_sauce"
    And clico no botão de login
    When eu não adiciono produto ao carrinho
    And navego para o carrinho
    And clico no botão de checkout
    And preencho o primeiro nome com "João"
    And preencho o sobrenome com "Silva"
    And preencho o código postal com "12345"
    And clico no botão de continuar
    And verifico o total do pedido
    And clico no botão de finalizar
    Then uma mensagem de erro deve ser exibida