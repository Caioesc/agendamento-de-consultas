<h1 align="center"> API de Gestão de Agendamentos</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/springboot-000000?style=for-the-badge&logo=springboot&logoColor=green" alt="Spring Boot">
  <img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white" alt="TypeScript">
  <img src="https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white" alt="Angular">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger">
</p>

> API REST desenvolvida em Java e Spring Boot para o controle de agendamentos, contemplando regras de negócio, validações e testes automatizados com Front-End para consumo da API em Angular. Projeto construído como solução para teste prático de Desenvolvedor Júnior.

## Tecnologias e Ferramentas

* **Linguagens:** Java 17, TypeScript
* **Frameworks:** Spring Boot 4.1.1, Angular 21
* **Persistência:** Spring Data JPA, Hibernate
* **Bancos de Dados:** MySQL
* **Testes:** JUnit 5, Mockito, MockMvc
* **Documentação:** SpringDoc OpenAPI 3 (Swagger UI)
* **Outros:** Lombok, Bean Validation, Maven, Node

## Funcionalidades

-  **Gestão de Pacientes:** Cadastro e listagem.
-  **Gestão de Agendamentos:** Criação de consultas validando conflitos de horário e barrando datas retroativas.
-  **Filtros Dinâmicos:** Busca de agendamentos por paciente, profissional e status.
-  **Cancelamento de Consultas:** Exclusão lógica com mudança para o status `CANCELADO` e registro de motivo obrigatório, permanecendo o registro no banco de dados.
-  **Tratamento Global de Erros:** Interceptação via `@RestControllerAdvice` para devolver JSON padronizado em erros de validação e recursos não encontrados.
-  **Data Seeding:** População automática de profissionais, pacientes e agendamentos via `CommandLineRunner` ao iniciar a aplicação, permitindo testar o fluxo de agendamentos imediatamente.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:
* [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Node.js e npm](https://nodejs.org/pt-br/download) para rodar o front-end
* [Maven](https://maven.apache.org/download.cgi)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/) rodando na porta padrão (3306).
* [Git](https://git-scm.com/downloads) para clonar o repositório.

## Como Executar o Projeto

**1. Clone o repositório:**
```bash
git clone https://github.com/Caioesc/agendamento-de-consultas.git
```
e vá para o diretório dele:
```bash
cd agendamento-de-consultas
```

**2. Configuração do Banco de Dados:**
A aplicação está configurada para criar o banco de dados automaticamente caso ele não exista. Certifique-se apenas de que as credenciais no arquivo `backend/src/main/resources/application.properties` correspondem ao seu ambiente local:

```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

**3. Inicie a aplicação Back-End:**
Dentro do diretório do projeto, vá para o do back-end:
```bash
cd backend
```

Execute:
```bash
mvn spring-boot:run
```

**4. Inicie a aplicação Front-End:**
Em outro terminal, volte para a raiz do projeto e vá para o front-end:
```bash
cd frontend
```

Instale as dependências:
```bash
npm install
```

Execute a aplicação:
```bash
npm start
```
Ou
```bash
ng serve
```

Após iniciar, acesse o endereço informado pelo Angular, que deve ser:
http://localhost:4200

## Documentação (Swagger UI)

A API está documentada utilizando o padrão OpenAPI. **Com a aplicação em execução local**, acesse o link abaixo para visualizar os endpoints, regras dos DTOs e realizar testes práticos direto no navegador:

**[Acessar Documentação Swagger](http://localhost:8080/swagger-ui.html)**

## Testes Automatizados

O projeto possui testes automatizados cobrindo a camada Controller do agendamento, garantindo que as validações como o bloqueio de datas no passado operem corretamente junto ao tratador global de exceções.

Para rodar os testes, primeiro certifique-se de que as credenciais no arquivo `backend/src/main/resources/application-test.properties` correspondem ao seu ambiente local:

```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

e execute:

```bash
mvn test
```

## Status do projeto

### 🟢 Concluído

O projeto possui backend e frontend integrados, persistência em banco de dados, regras de negócio, tratamento de erros, documentação da API e testes automatizados.

---
Desenvolvido por **Caio Escorel Heráclio Lopes Fernandes**
