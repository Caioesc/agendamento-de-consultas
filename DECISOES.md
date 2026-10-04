# Decisões Arquiteturais e Técnicas

>Este documento apresenta as principais decisões tomadas durante o desenvolvimento do sistema de gestão de agendamentos, considerando os requisitos do teste prático e a evolução da solução para uma aplicação Full Stack.

### 1. Quais foram as principais decisões técnicas?
* **Arquitetura em Camadas:** Adoção do padrão Controller-Service-Repository para garantir a separação de responsabilidades.
* **Uso de DTOs:** Implementação de Data Transfer Objects utilizando `records` do Java 17 para evitar a exposição direta das Entidades JPA, garantindo mais segurança e controle sobre o tráfego de dados.
* **Tratamento Global de Exceções:** Criação de um `GlobalExceptionHandler` para capturar erros de validação do bean validation e regras de negócio, retornando respostas JSON padronizadas e com os HTTP Status corretos.
* **Soft Delete:** Para o cancelamento de consultas, optei por uma exclusão lógica, atualizando o status para `CANCELADO` via verbo `PATCH`), preservando o histórico no banco de dados conforme exigido.
* **Testes automatizados:** utilização de JUnit 5, Mockito e MockMvc, com profile de testes e banco MySQL dedicado.
* **Data Seeding:** Utilização do `CommandLineRunner` para injetar dados iniciais de médicos no banco, facilitando a testabilidade imediata da API.
* **Frontend Angular:** Desenvolvimento de uma interface com Angular, Standalone Components e Angular Material para consumo da API e entrega da solução como aplicação Full Stack.

### 2. O que você priorizou e o que ficou de fora?
* **Priorizado:** O foco principal foi garantir a integridade das regras de negócio, como o bloqueio de horários conflitantes e datas no passado, validações de entrada consistentes e uma arquitetura limpa e escalável.
* **Ficou de fora:** 

  * Não foi implementado um CRUD completo para `Profissional`, pois o documento de requisitos focava no fluxo do Agendamento. A questão foi resolvida via Data Seeding para inserir profissionais automaticamente ao iniciar a aplicação.
  * Camada de Segurança (Spring Security / JWT) para autenticação, por não ser um requisito e para manter a simplicidade da avaliação.
  * Uso de banco de dados Oracle. Optei por manter a persistência em MySQL pela familiaridade e agilidade na entrega, embora a adoção do Spring Data JPA garanta a compatibilidade do código com o Oracle, necessitando apenas da troca do driver e dialeto nas configurações.

### 3. Se utilizou IA, em quais partes e como validou o resultado?
Sim. A IA foi utilizada como apoio durante o desenvolvimento, principalmente para discutir decisões arquiteturais, esclarecer dúvidas, estruturar testes, gerar dados de teste e auxiliar na documentação. 
* **Onde:** Principalmente para discutir abordagens arquiteturais (ex: configuração do profile de testes, padronização de commits) e gerar massa de dados (JSONs de teste). Além disso, a IA me auxiliou na descoberta da anotação `@FutureOrPresent` do Bean Validation, na estruturação da lógica dos testes automatizados com MockMvc (especificamente no cenário de data retroativa), na personalização visual do Swagger e na formatação e revisão da sintaxe Markdown. Já no front-end, principalmente no entendimento do Angular Materials, na aplicação dos filtros na tabela de agendamento e em compreender o fluxo do framework, comparando com minha experiência em React.
* **Como validei:** A IA atuou como uma ferramenta consultiva para o destravamento de dúvidas e aprendizado de novos conceitos. Todo o conteúdo sugerido foi criteriosamente analisado para que eu compreendesse a lógica e o funcionamento antes de qualquer aplicação. Os trechos propostos foram testados ativamente na IDE e via Postman, e foram adaptados manualmente por mim para garantir a total integração com a arquitetura, as regras de negócio e as especificidades do meu projeto.
