# API REST para Gestão de Abastecimentos de Posto de Combustível

Uma API RESTful desenvolvida com **Java 17** e **Spring Boot 3**, voltada para a **gestão de combustíveis, bombas e abastecimentos** de um posto. O projeto adota uma arquitetura em camadas e práticas modernas de desenvolvimento, além de estar preparado para testes via Swagger UI.

---

## Visão Geral e Arquitetura

Este sistema foi construído com foco na separação de responsabilidades, manutenibilidade e clareza. A arquitetura está dividida em:

- **Camada Controller** (`/controller`) — Define os endpoints da API.
- **Camada de Serviço** (`/business`) — Contém a lógica de negócio.
- **Camada DTO** (`/dto`) — Facilita a comunicação e evita acoplamentos desnecessários com entidades JPA.
- **Camada Entidades** (`/infrastructure/entity`) — Representa as tabelas do banco de dados.
- **Camada Repositórios** (`/infrastructure/repository`) — Acesso aos dados via Spring Data JPA.
- **Camada de Exceções** (`/infrastructure/exceptions`) — Define erros customizados como `ConflictException`.

---

## Funcionalidades da API

### Tipos de Combustível (`/api/tipos-combustivel`)
| Método | Endpoint                     | Descrição                      |
|--------|------------------------------|--------------------------------|
| GET    | `/api/tipos-combustivel`     | Lista todos os tipos           |
| GET    | `/api/tipos-combustivel/{id}`| Busca tipo por ID              |
| POST   | `/api/tipos-combustivel`     | Cria novo tipo                 |
| PUT    | `/api/tipos-combustivel/{id}`| Atualiza tipo existente        |
| DELETE | `/api/tipos-combustivel/{id}`| Remove tipo existente          |

### Bombas de Combustível (`/api/bombas`)
| Método | Endpoint            | Descrição                      |
|--------|---------------------|--------------------------------|
| GET    | `/api/bombas`       | Lista todas as bombas          |
| GET    | `/api/bombas/{id}`  | Busca bomba por ID             |
| POST   | `/api/bombas`       | Cadastra uma nova bomba        |
| PUT    | `/api/bombas/{id}`  | Atualiza bomba existente       |
| DELETE | `/api/bombas/{id}`  | Remove bomba existente         |

### Abastecimentos (`/api/abastecimentos`)
| Método | Endpoint                  | Descrição                      |
|--------|---------------------------|--------------------------------|
| GET    | `/api/abastecimentos`     | Lista todos os abastecimentos |
| GET    | `/api/abastecimentos/{id}`| Busca abastecimento por ID    |
| POST   | `/api/abastecimentos`     | Registra novo abastecimento   |
| PUT    | `/api/abastecimentos/{id}`| Atualiza abastecimento        |
| DELETE | `/api/abastecimentos/{id}`| Remove abastecimento          |

---

## Testes Interativos com Swagger

O projeto já possui documentação interativa via Swagger.

> Após executar o projeto, acesse no navegador:

🔗 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

Você poderá:
- Ver os modelos das entidades e DTOs;
- Testar os endpoints diretamente no navegador;
- Validar entradas e saídas da API.

---

## Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3.5.3
- **Banco de Dados:** PostgreSQL
- **ORM:** Hibernate (via Spring Data JPA)
- **Documentação da API:** SpringDoc OpenAPI (Swagger)
- **Empacotamento:** Maven
- **Utilitários:** Lombok

---

## Configuração e Execução Local

### Pré-requisitos

- JDK 17+
- Maven 3.8+
- PostgreSQL instalado e em execução
- Postman, Insomnia ou navegador web
