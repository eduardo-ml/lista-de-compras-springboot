# API de Lista de Compras (Shopping List API)

Projeto de uma API RESTful para gerenciamento de uma lista de compras, desenvolvido com Spring Boot. Este projeto foi criado como parte dos meus estudos em desenvolvimento back-end com Java e Spring, focando em boas práticas de programação e arquitetura de software.

## Features Implementadas

* **CRUD Completo:** Crie, Leia, Atualize e Delete itens da lista de compras.
* **Arquitetura em Camadas:** Lógica de negócio (Service), acesso a dados (Repository) e controle de requisições (Controller) são totalmente desacoplados.
* **Validação de Dados:** A API valida os dados de entrada para garantir a integridade, rejeitando requisições com dados inválidos (ex: nome em branco, quantidade menor que 1).
* **Tratamento de Exceções Centralizado:** Erros como "recurso não encontrado" (404) ou erros de validação são tratados de forma global, retornando mensagens claras para o cliente.
* **Respostas HTTP Semânticas:** A API utiliza os códigos de status HTTP corretos para cada operação (`201 Created`, `204 No Content`, `404 Not Found`, etc.).

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.4**
* **Spring Data JPA**
* **Hibernate**
* **H2 Database** (Banco de dados em memória)
* **Maven**
* **Lombok**

## Como Executar o Projeto

1.  Clone o repositório: `git clone https://github.com/eduardo-ml/lista-de-compras-springboot.git`
2.  Navegue até o diretório do projeto.
3.  Execute o comando: `mvn spring-boot:run`
4.  A API estará disponível em `http://localhost:8080`

## Endpoints da API

| Verbo  | Endpoint          | Descrição                                      |
|--------|-------------------|------------------------------------------------|
| `POST` | `/compras`        | Cria um novo item na lista.                    |
| `GET`  | `/compras`        | Lista todos os itens da lista.                 |
| `PUT`  | `/compras/{id}`   | Atualiza um item existente a partir de seu ID. |
| `DELETE`| `/compras/{id}`  | Exclui um item da lista a partir de seu ID.    |
