Spring Boot Essentials 🚀
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar um catálogo de produtos. Ele serve como uma base sólida para demonstrar boas práticas de desenvolvimento, tratamento de exceções e documentação automática de APIs.

🛠️ Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Data JPA (Persistência de dados)

SpringDoc OpenAPI (Swagger UI) (Documentação da API)

Maven (Gerenciador de dependências)

📖 Documentação da API (Swagger)
Uma vez que o projeto esteja rodando localmente, você pode acessar a interface do Swagger para testar os endpoints em:

http://localhost:8080/swagger-ui/index.html



🚀 Como rodar o projeto
Clone o repositório:

Bash
git clone https://github.com/guirodriguesxz/spring-boot-essentials.git
Entre na pasta do projeto:

Bash
cd spring-boot-essentials
Execute o projeto usando o Maven:

Bash
./mvnw spring-boot:run

📂 Estrutura de Pacotes
controller: Camada de exposição dos endpoints REST.

service: Camada de regras de negócio.

database/model: Entidades que representam as tabelas no banco de dados.

dto: Objetos de transferência de dados para segurança e performance.

handler/exception: Tratamento global de erros da aplicação.
