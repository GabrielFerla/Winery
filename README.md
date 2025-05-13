# Winery System - SOAP Web Services

Este projeto demonstra a criação e consumo de Web Services SOAP utilizando Java e Maven.

## Estrutura do Projeto

O projeto é dividido em três módulos Maven:

1.  **`Publisher/WinerySys`**: Publica dois Web Services:
    *   `WineStockService`: Gerencia o estoque de vinhos (operações: `getMenu`, `placeOrder`). Publicado em `http://localhost:8085/WineStockService`.
    *   `WineWarningService`: Envia avisos sobre o estoque (operação: `sendWarn`). Publicado em `http://localhost:8086/WineWarningService`.
2.  **`Consumer/WineStockClient`**: Consome o `WineStockService` para exibir o menu de vinhos.
3.  **`Consumer/WineOrderClient`**: Consome ambos os serviços (`WineStockService` para fazer um pedido e `WineWarningService` para verificar avisos).

## Pré-requisitos

*   Java JDK (versão 17 ou superior)
*   Apache Maven (versão 3.6.0 ou superior)

## Instruções para Execução

Siga os passos abaixo na ordem indicada. É recomendado utilizar terminais separados para o publicador e cada cliente.

Assuma que `<caminho_para_o_projeto>` é o diretório onde você clonou ou descompactou este projeto (ou seja, o diretório que contém esta pasta `Winery`).

### 1. Publicar os Web Services (`WinerySys`)

1.  Navegue até o diretório do publicador:
    ```bash
    cd "<caminho_para_o_projeto>/Winery/Publisher/WinerySys"
    ```
2.  Compile e execute a aplicação que publica os serviços:
    ```bash
    mvn exec:java
    ```
    Este comando iniciará os serviços. `WineStockService` estará disponível em `http://localhost:8085/WineStockService?wsdl` e `WineWarningService` em `http://localhost:8086/WineWarningService?wsdl`.
    Mantenha este terminal em execução.

### 2. Executar o Cliente de Estoque (`WineStockClient`)

1.  Em um **novo terminal**, navegue até o diretório do cliente de estoque:
    ```bash
    cd "<caminho_para_o_projeto>/Winery/Consumer/WineStockClient"
    ```
2.  Compile e execute a aplicação cliente:
    ```bash
    mvn exec:java
    ```
    Você deverá ver a lista de vinhos disponíveis no console.

### 3. Executar o Cliente de Pedidos (`WineOrderClient`)

1.  Em um **novo terminal**, navegue até o diretório do cliente de pedidos:
    ```bash
    cd "<caminho_para_o_projeto>/Winery/Consumer/WineOrderClient"
    ```
2.  Compile e execute a aplicação cliente:
    ```bash
    mvn exec:java
    ```
    Você deverá ver a confirmação do pedido e um aviso de estoque no console.

## Observações

*   Certifique-se de que as portas `8085` e `8086` não estão sendo utilizadas por outras aplicações.
*   Os clientes (`WineStockClient` e `WineOrderClient`) dependem que os serviços em `WinerySys` estejam em execução.
*   Os arquivos `pom.xml` de cada módulo contêm as configurações para o `jaxws-maven-plugin` (geração de stubs a partir do WSDL) e o `exec-maven-plugin` (para facilitar a execução das classes principais).
