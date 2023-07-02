 

# API de Controle de Estoque

Esta é uma API de Controle de Estoque desenvolvida em Spring Boot.

A StockManagementAPI é uma poderosa solução de gerenciamento de estoque, oferecendo recursos avançados para o controle de produtos, unidades de medida e movimentações, proporcionando eficiência e precisão no monitoramento e otimização dos níveis de estoque.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- Java JDK 11 ou superior
- Spring Boot 2.7.13
- SqlServer (ou outro banco de dados de sua escolha)
- Maven

## Configuração do Banco de Dados

1. Crie um banco de dados SqlServer chamado "StockManagementDB".
2. No arquivo `application.properties`, defina as configurações do banco de dados, incluindo URL, nome de usuário e senha.

## Executando a Aplicação

1. Clone o repositório para o seu ambiente local.
2. Navegue até o diretório raiz da aplicação.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
4. Acesse a API em `http://localhost:8080`.

## Endpoints

A API possui os seguintes endpoints:

- `GET /api/products`: Retorna todos os products cadastrados.
- `GET /api/products/{id}`: Retorna um produto específico pelo ID.
- `POST /api/products`: Cria um novo produto.
- `PUT /api/products/{id}`: Atualiza um produto existente pelo ID.
- `DELETE /api/products/{id}`: Exclui um produto pelo ID.

## Formato de Dados

Os dados são enviados e recebidos no formato JSON.

Exemplo de um objeto Produto:

```json
{
  "id": 1,
  "description": "Produto 1",
  "generalComments": "Descrição do Produto 1",
  "value": 10.99,
  "unit": "un", 
}
```

## Tratamento de Erros

A API possui tratamento de erros e retornará respostas adequadas em caso de falhas. Certifique-se de verificar os códigos de status HTTP e as mensagens de erro retornadas.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema, ou tiver alguma sugestão de melhoria, sinta-se à vontade para abrir uma nova issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).

---

Sinta-se à vontade para personalizar e adaptar o README de acordo com as necessidades e especificidades da sua API de Controle de Estoque.