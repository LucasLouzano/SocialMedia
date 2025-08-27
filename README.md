# 📱 SocialMedia — Sistema de Rede Social Distribuído

Aplicação Spring Boot que simula uma rede social com autenticação, postagens, comentários, controle de pagamentos mensais e envio de e-mails. Estruturada em microsserviços e pronta para produção.

---

## 🚀 Funcionalidades

- Registro e login de usuários com autenticação JWT
- Criação, leitura, atualização e exclusão de postagens
- Comentários vinculados a posts
- Controle de pagamentos mensais por usuário
- Envio e consulta de e-mails via serviço externo
- Integração com serviços externos (PostService, PaymentService, EmailService)

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- MapStruct
- OkHttp + RestTemplate
- Swagger/OpenAPI
- MySQL/PostgreSQL
- Jakarta Validation
- Docker + Docker Compose

---

## 🧩 Arquitetura de Microsserviços

```plaintext
+---------------------+       REST       +---------------------+
|   SocialMedia App   | <--------------> |   PostService       |
|                     | <--------------> |   PaymentService    |
|                     | <--------------> |   EmailService      |
+---------------------+                  +---------------------+
Autenticação
JWT com expiração de 30 minutos

Filtro de autenticação via FilterToken

Roles: USER, ADMIN

Senhas criptografadas com BCrypt

📮 Endpoints REST
🔑 Autenticação
POST /login

POST /register

📝 Posts
GET /posts

GET /posts/{id}

POST /posts

PUT /posts/{id}

DELETE /posts/{id}

GET /posts/comments

💬 Comentários
GET /comments

GET /comments/{id}

POST /comments

PUT /comments/{id}

DELETE /comments/{id}

💳 Pagamentos
GET /api/paymentClients

GET /api/paymentClients/paid

POST /api/paymentClients

GET /api/paymentClients/betweenDates

💰 Valores de Pagamento
GET /socialmedia/{snCurrentValue}

POST /socialmedia

GET /socialmedia/paymentValues

📧 E-mails
POST /socialmedia/emails

GET /socialmedia/emails

GET /socialmedia/emails/{emailId}

