# 📇 Contatos API

API REST simples para gerenciar agenda de contatos.

**Stack:** Spring Boot 4.0 | Java 21 | MySQL | Swagger/OpenAPI

## 📋 Requisitos

- Java 21+
- MySQL 8.0+
- Maven 3.6+
- Git

## 🚀 Instalação e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/contatos.git
cd contatos
```

### 2. Crie o banco de dados
```bash
mysql -u root -p
```

```sql
CREATE DATABASE agenda_contatos;
```

### 3. Configure credenciais (application.properties)
Abra `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agenda_contatos
spring.datasource.username=root
spring.datasource.password=sua_senha
```

### 4. Execute a aplicação
```bash
mvn spring-boot:run
```

Acesse: http://localhost:8080/swagger-ui.html

## 📡 Endpoints

### Criar Contato
```bash
POST /contatos
Content-Type: application/json

{
  "nome": "João Silva",
  "telefone": "11999999999"
}
```

### Listar Todos
```bash
GET /contatos
```

### Buscar por ID
```bash
GET /contatos/{id}
```

### Atualizar
```bash
PUT /contatos/{id}
Content-Type: application/json

{
  "nome": "João Silva Atualizado",
  "telefone": "11988888888"
}
```

### Deletar
```bash
DELETE /contatos/{id}
```

## 🛠️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/contatos/
│   │   ├── controllers/     # REST endpoints
│   │   ├── services/        # Lógica de negócio
│   │   ├── models/          # Entidades JPA
│   │   ├── dto/             # Transfer objects
│   │   └── repository/      # Data access
│   └── resources/
│       └── application.properties
└── test/
    └── ContatosApplicationTests.java
```

## 📦 Build para Produção

```bash
mvn clean package
java -jar target/contatos-0.0.1-SNAPSHOT.jar
```

## 📚 Documentação

Swagger UI: http://localhost:8080/swagger-ui.html

## ⚙️ Variáveis de Ambiente

| Variável | Padrão | Descrição |
|----------|--------|-----------|
| `spring.datasource.url` | `jdbc:mysql://localhost:3306/agenda_contatos` | URL do banco |
| `spring.datasource.username` | `root` | Usuário MySQL |
| `spring.datasource.password` | - | Senha MySQL |
| `server.port` | `8080` | Porta da aplicação |


## 🔗 Dependências Principais

- Spring Boot 4.0.6
- Spring Data JPA
- Spring Validation
- MySQL Connector
- Lombok
- Springdoc OpenAPI (Swagger)

## 🤝 Contribuindo

1. Fork o projeto
2. Crie branch: `git checkout -b feature/sua-feature`
3. Commit: `git commit -m "feat: descrição"`
4. Push: `git push origin feature/sua-feature`
5. Abra Pull Request

## 📄 Licença

MIT

## 👤 Autor

Vitor Santos / Sua Organização

---

**Versão:** 0.0.1  
**Última atualização:** 2026
