# CuidaBot ESG API — Desafio DevOps FIAP

**Aluna:** Lorena de Oliveira Steinwascher Polli — RM 561712  
**Projeto:** CuidaBot ESG API  
**Stack:** Java 17, Spring Boot, Maven, Oracle, Docker, Docker Compose e GitHub Actions.

## 1. Objetivo

Aplicar práticas de DevOps ao projeto Spring Boot do CuidaBot ESG, automatizando **build, testes e deploy**, além de containerizar a aplicação e orquestrar aplicação + banco de dados.

## 2. Pré-requisitos

- Git
- Docker Desktop / Docker Engine com Docker Compose
- Java 17 (opcional para execução fora do Docker)

## 3. Como executar localmente com Docker

1. Copie o arquivo de variáveis:

```bash
cp .env.example .env
```

2. Ajuste as senhas do `.env` se desejar.

3. Suba banco + staging:

```bash
docker compose up -d --build oracle-db staging
```

4. Verifique os containers:

```bash
docker compose ps
```

5. A API de staging ficará em `http://localhost:8081`.

6. Para subir produção usando a mesma imagem:

```bash
docker compose up -d production
```

A produção ficará em `http://localhost:8080`.

> Os endpoints utilizam HTTP Basic. Usuário e senha são definidos por `APP_USER` e `APP_PASSWORD` no `.env`.

## 4. Pipeline CI/CD

O workflow `.github/workflows/ci-cd.yml` possui três estágios:

1. **Build e Testes** — executa `./mvnw clean verify` e gera a imagem Docker.
2. **Deploy Staging** — valida a configuração Docker Compose e representa o deploy automatizado do ambiente de staging.
3. **Deploy Production** — executado após staging, valida a configuração e representa o deploy automatizado de produção.

Para execução real em servidores, os jobs de deploy devem ser conectados a runners/hosts de staging e produção e executar `docker compose up -d` nesses hosts.

## 5. Testes automatizados

O projeto possui teste de contexto Spring Boot em `src/test/java`. Para que o CI não dependa do Oracle externo da FIAP, os testes usam H2 em memória, configurado em `src/test/resources/application.properties`.

Execute:

```bash
./mvnw clean verify
```

## 6. Containerização

O `Dockerfile` usa **multi-stage build**:

- estágio `build`: compila o projeto com Maven Wrapper;
- estágio final: executa apenas o JAR em uma imagem JRE Java 17, com usuário não-root.

Build manual:

```bash
docker build -t cuidabot-esg-api:local .
```

## 7. Orquestração

O `docker-compose.yml` define:

- `oracle-db`: Oracle Free, com volume persistente;
- `staging`: API na porta 8081;
- `production`: API na porta 8080;
- `oracle-data`: volume do banco;
- `cuidabot-net`: rede interna dos serviços.

As credenciais são externalizadas através do `.env` e o `.env.example` pode ser versionado sem segredos reais.

## 8. Tecnologias utilizadas

- Java 17
- Spring Boot 4.0.6
- Spring MVC
- Spring Data JPA
- Spring Security / HTTP Basic
- Flyway
- Oracle Database
- H2 para testes
- Maven
- Docker / Docker Compose
- GitHub Actions

## 9. Evidências para a entrega

Salvar os prints em `docs/evidencias/`:

- `01-maven-testes.png` — `./mvnw clean verify` concluído;
- `02-docker-build.png` — imagem criada;
- `03-compose-staging.png` — `docker compose ps` com staging ativo;
- `04-staging-api.png` — chamada à API na porta 8081;
- `05-compose-production.png` — produção ativa na porta 8080;
- `06-github-actions.png` — workflow CI/CD concluído.

## 10. Desafios encontrados e soluções

**Dependência do Oracle FIAP:** o projeto original apontava diretamente para um banco Oracle externo. A configuração foi alterada para variáveis de ambiente, permitindo o uso tanto do banco acadêmico quanto do Oracle em container.

**Testes dependentes de banco externo:** foi criado um perfil de teste usando H2 em memória e Flyway desabilitado durante os testes, tornando o pipeline reprodutível.

**Segredos no código:** usuário e senha do banco e da API deixaram de ficar fixos no `application.properties` e passaram a ser fornecidos por variáveis de ambiente.

## 11. Checklist obrigatório da entrega

- [ ] Projeto compactado em `.ZIP` com estrutura organizada
- [x] Dockerfile funcional
- [x] `docker-compose.yml`
- [x] Pipeline com etapas de build, teste e deploy
- [x] README.md com instruções e espaço para evidências
- [ ] Documentação técnica com evidências (PDF ou PPT)
- [ ] Deploy executado e evidenciado em staging e produção

> Os dois últimos itens devem ser marcados somente depois de executar o projeto e inserir os prints reais.
