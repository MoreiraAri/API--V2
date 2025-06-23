# 🚀 API de Autenticação e Autorização com JWT

Este projeto é uma API REST desenvolvida com **Spring Boot**, que implementa **autenticação e autorização usando JWT**. A API permite autenticar usuários e acessar rotas protegidas com tokens gerados internamente.

---

## 📁 Clonando o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
⚙️ Configuração do ambiente
Certifique-se de ter o Java 17+ e Maven instalados.

Abra o projeto em uma IDE como IntelliJ, Eclipse ou VS Code.

Verifique o arquivo application.yml (ou application.properties) para alterar a porta ou configurações, se necessário.

Porta padrão configurada: 8080 (ou 8081, 9090 se alterado).

Banco H2 já está configurado em memória.

▶️ Executando a aplicação
bash
Copiar
Editar
./mvnw spring-boot:run
Ou execute pela IDE a partir da classe Application.java.

A API estará disponível em:
📍 http://localhost:8080

🧪 Rotas da API
POST /auth/login → Autentica e retorna um JWT

GET /api/protegida → Acesso somente com JWT válido no header

🔐 Dados de login de teste
json
Copiar
Editar
{
  "username": "admin",
  "password": "123456"
}
🛢️ Console H2
Acesse o console H2 no navegador:

📍 http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (deixe em branco)

📚 Documentação Swagger
A documentação da API está disponível em:

📍 http://localhost:8080/swagger-ui.html
ou
📍 http://localhost:8080/swagger-ui/index.html (dependendo da versão do Swagger)

📈 Testes de carga com Apache JMeter
🧪 Passos para executar
Baixe o Apache JMeter

Abra o arquivo .jmx incluído no repositório com o JMeter.

Ajuste a porta e o caminho conforme a configuração do seu backend:

Vá em HTTP Request Defaults:

Server Name: localhost

Port Number: 8080 (ou a porta usada)

Em "Login Request", adicione os parâmetros:

username: admin

password: 123456

Clique no botão Start (▶️) para iniciar os testes.

Visualize os resultados em View Results Tree ou Summary Report.

💡 Tecnologias utilizadas
Java 17

Spring Boot

Spring Security

JWT (JSON Web Token)

H2 Database

Swagger (OpenAPI)

Apache JMeter

✍️ Autora
Desenvolvido por Ariana Moreira
📧 [seu-email@email.com]
🔗 linkedin.com/in/seu-usuario

🛡️ Observações
⚠️ Este projeto é para fins educacionais. Para uso em produção:

Armazene o jwt.secret como variável de ambiente.

Use um banco de dados persistente.

Implemente controle de permissões com roles/grupos se necessário.

