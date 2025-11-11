# 🚀 CRUD de Cadastro de Usuários (API REST)

## 📌 Introdução

Este projeto é uma **API REST** de Cadastro de Usuários (CRUD - Create, Read, Update, Delete), desenvolvida para solidificar os fundamentos de **Java** e do *framework* **Spring Boot**.

O objetivo principal foi criar uma aplicação robusta, utilizando a arquitetura de camadas e as principais dependências do ecossistema Spring para persistência de dados.

## 🛠️ Stack Tecnológico

A aplicação foi construída utilizando as seguintes tecnologias:

* **Linguagem:** Java 21+
* **Framework:** Spring Boot 3.x
* **Acesso a Dados:** Spring Data JPA
* **Banco de Dados:** H2 Database (Banco de dados em memória, ideal para desenvolvimento e testes)
* **Construção:** Maven
* **Produtividade:** Lombok (para redução de código *boilerplate*)

## 🏗️ Arquitetura e Estrutura

O projeto segue a **Arquitetura de Camadas Simples**, uma prática fundamental para organizar o código, separar responsabilidades e garantir a manutenibilidade:

1.  **`controller` (Controlador/API):** Recebe as requisições HTTP e delega as operações para a camada Service. Responsável por mapear as URLs e os verbos HTTP.
2.  **`business` (Regras de Negócio/Service):** Contém a lógica de negócio da aplicação. Aqui o método de *update* (PUT) foi implementado com a validação ternária para garantir que dados ausentes não sobrescrevam informações no banco (Proteção de campos `null`).
3.  **`infrastructure` (Persistência/Repository):** Camada de acesso aos dados.
    * **`entitys`:** Classes mapeadas para as tabelas do banco de dados (Entidade `UserEntity`).
    * **`repository`:** Interfaces que estendem `JpaRepository`, permitindo operações CRUD automáticas.

## 💡 Aprendizados e Conceitos-Chave

Durante o desenvolvimento deste projeto, os seguintes conceitos foram aplicados e consolidados:

* **POO (Programação Orientada a Objetos):** Implementação do domínio com a classe `UserEntity`.
* **JPA e H2:** Mapeamento de Entidades e uso de um banco de dados em memória para testes rápidos.
* **`@Service` e `@Repository`:** Inversão de Controle (IoC) e Injeção de Dependências (DI) via Spring.
* **`@Transactional`:** Utilizado no método `deleteByEmail` para garantir que a operação de exclusão seja atômica (ou tudo acontece, ou nada acontece).
* **Validação de Dados:** Uso de `Optional` no `UserService` para tratar exceções (`RuntimeException`) de forma controlada, evitando o famoso `NullPointerException`.

## ⚙️ Funcionalidades e Endpoints

A aplicação está rodando na porta `8080` (configurada no `application.properties`) e utiliza o prefixo `/users`.

| Verbo HTTP | URI | Descrição | Service |
| :--- | :--- | :--- | :--- |
| **POST** | `/users` | Cria um novo usuário no banco de dados. | `saveUser()` |
| **GET** | `/users?email={email}` | Busca um usuário específico pelo e-mail. | `findUserByEmail()` |
| **PUT** | `/users/{id}` | Atualiza o nome ou e-mail de um usuário existente. | `updateUser()` |
| **DELETE** | `/users?email={email}` | Deleta um usuário específico pelo e-mail. | `deleteUserByEmail()` |

## 🏃 Como Rodar a Aplicação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/victord3vv/java-user-crud.git](https://github.com/victord3vv/java-user-crud.git)
    ```
2.  **Abra o Projeto:** Importe a pasta no seu IDE de preferência (IntelliJ, VS Code ou Eclipse).
3.  **Execute:** Utilize o comando do Maven (ou a função de *Run* da sua IDE) para iniciar a aplicação:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  **Acesse o H2 Console:** Com a aplicação rodando, você pode acessar o console do banco de dados em memória:
    * **URL:** `http://localhost:8080/h2-console`
    * **JDBC URL:** `jdbc:h2:mem:USUARIO` (Conforme configurado no `application.properties`)

## 🖥️ Exemplo de Uso (Postman/cURL)

#### 1. Criar Usuário (POST)

```http
POST http://localhost:8080/users
Content-Type: application/json

{
    "name": "Victor",
    "email": "victor@email.com"
}

2. Buscar Usuário (GET)

GET http://localhost:8080/users?email=angelica@email.com

{
    "id": 1,
    "name": "Victor",
    "email": "victor@email.com"
}

3. Atualizar Usuário (PUT)

PUT http://localhost:8080/users/1
Content-Type: application/json

{
    "name": "Victor"
}

4. Deletar Usuário (DELETE)

DELETE http://localhost:8080/users?email=victor@email.com
