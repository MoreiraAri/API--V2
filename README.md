# 🔐 API de Autenticação e Autorização com JWT - AV2

Este projeto é uma aplicação Spring Boot focada na implementação de autenticação e autorização usando JWT, com recursos de segurança, testes, monitoramento e deploy. Ele foi desenvolvido como parte da Avaliação 2 da disciplina de Programação Web.

---

## 📦 Tecnologias e Dependências

As principais dependências utilizadas no projeto estão listadas abaixo:

- `Spring Boot Starter Web` – Construção de APIs RESTful.
- `Spring Boot Starter Security` – Autenticação e autorização.
- `Spring Boot Starter OAuth2 Resource Server` – Validação de tokens JWT.
- `Spring Boot Starter Data JPA` – Persistência de dados.
- `H2 Database` – Banco de dados em memória para testes.
- `Lombok` – Redução de código repetitivo.
- `Springdoc OpenAPI` – Geração de documentação Swagger.
- `Spring Boot Starter Test` – Testes com JUnit 5 e Mockito.
- `Spring Boot DevTools` – Ferramentas de desenvolvimento.
- `Spring Boot Actuator` – Monitoramento da aplicação.
- `Prometheus` – Coleta de métricas em tempo real.

---

## ⚙️ Instalação e Configuração

### Pré-requisitos

- Java 17+
- Maven
- Docker (opcional, para deploy)
- Git

### Clonando o projeto

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
Configuração do application.yml
O arquivo application.yml já está configurado com:

Conexão com banco de dados H2

Chave secreta para geração de JWT

Endpoints de segurança

Exposição de métricas via Actuator

Se desejar utilizar outro banco, configure as propriedades de conexão em src/main/resources/application.yml.

▶️ Executando o Projeto
Via terminal com Maven
bash
Copiar
Editar
./mvnw spring-boot:run
Acessando a aplicação
Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console: http://localhost:8080/h2-console

🛡️ Funcionalidades
Registro de novos usuários em /auth/register

Autenticação com geração de token JWT em /auth/login

Endpoints protegidos por roles e tokens

Integração com Spring Security

Monitoramento com Prometheus + Actuator

Testes unitários com JUnit e Mockito

✅ Testes
Testes Unitários
Para rodar os testes:

bash
Copiar
Editar
./mvnw test
Os testes incluem:

Validação de autenticação

Mock de serviços com Mockito

Teste de Carga com JMeter
Utilizar o JMeter para simular múltiplos logins.

Analisar métricas como tempo médio de resposta, throughput e percentual de erro.

Arquivo .jmx disponível na pasta tests/.

📈 Monitoramento
Actuator: endpoints como /actuator/health e /actuator/metrics

Prometheus: coleta de métricas no endpoint /actuator/prometheus

Grafana: integração com Prometheus para criação de dashboards

🚀 Deploy
Com Docker
Gerar o JAR da aplicação:

bash
Copiar
Editar
./mvnw clean package
Criar imagem Docker:

bash
Copiar
Editar
docker build -t jwt-api .
Rodar container:

bash
Copiar
Editar
docker run -p 8080:8080 jwt-api
Plataformas de hospedagem gratuita
Render

Railway

