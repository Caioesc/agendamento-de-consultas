<h1 align="center"> API de Gestão de Agendamentos</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange.svg" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen.svg" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MySQL-Database-blue.svg" alt="MySQL">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-success.svg" alt="Swagger">
</p>

> API REST desenvolvida em Java e Spring Boot para o controle de agendamentos, contemplando regras de negócio, validações e testes automatizados. Projeto construído como solução para teste prático de Desenvolvedor Júnior.

## Tecnologias e Ferramentas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 4.1.1
* **Persistência:** Spring Data JPA, Hibernate
* **Bancos de Dados:** MySQL
* **Testes:** JUnit 5, Mockito, MockMvc
* **Documentação:** SpringDoc OpenAPI 3 (Swagger UI)
* **Outros:** Lombok, Bean Validation, Maven

## Funcionalidades

-  **Gestão de Pacientes:** Cadastro e listagem.
-  **Gestão de Agendamentos:** Criação de consultas validando conflitos de horário e barrando datas retroativas.
-  **Filtros Dinâmicos:** Busca de agendamentos por paciente, profissional e status.
-  **Cancelamento de Consultas:** Exclusão lógica com mudança para o status `CANCELADO` e registro de motivo obrigatório, permanecendo o registro no banco de dados.
-  **Tratamento Global de Erros:** Interceptação via `@RestControllerAdvice` para devolver JSON padronizado em erros de validação e recursos não encontrados.
-  **Data Seeding:** População automática de médicos via `CommandLineRunner` ao iniciar a aplicação, permitindo testar o fluxo de agendamentos imediatamente.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:
* [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/) rodando na porta padrão (3306).
* [Git](https://git-scm.com/downloads) para clonar o repositório.

## Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/Caioesc/agendamento-de-consultas.git
cd agendamento-de-consultas/backend
```

**2. Configuração do Banco de Dados:**
A aplicação está configurada para criar o banco de dados automaticamente caso ele não exista. Certifique-se apenas de que as credenciais no arquivo `src/main/resources/application.properties` correspondem ao seu ambiente local:

```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

**3. Inicie a aplicação:**
Na raiz do projeto, rode o comando:

```bash
mvn spring-boot:run
```

## Documentação (Swagger UI)

A API está documentada utilizando o padrão OpenAPI. **Com a aplicação em execução local**, acesse o link abaixo para visualizar os endpoints, regras dos DTOs e realizar testes práticos direto no navegador:

**[Acessar Documentação Swagger](http://localhost:8080/swagger-ui.html)**

## Testes Automatizados

O projeto possui testes automatizados cobrindo a camada Controller do agendamento, garantindo que as validações como o bloqueio de datas no passado operem corretamente junto ao tratador global de exceções.

Para rodar os testes, execute:

```bash
mvn test
```

## Próximos Passos

- [ ] **Interface de Usuário (Front-end):** Desenvolvimento de uma interface simples para demonstrar o consumo visual desta API, integrando todo o fluxo da mesma.

---
Desenvolvido por **Caio Escorel Heráclio Lopes Fernandes**
