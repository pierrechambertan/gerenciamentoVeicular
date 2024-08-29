Está uma aplicação RESTful desenvolvida em Java 17 utilizando o Spring Boot, Hibernate e MySQL. Ela permite gerenciar informações de veículos e clientes, oferecendo operações de CRUD (Create, Read, Update, Delete) com segurança, validação de dados e cache. O sistema implementa autenticação e autorização utilizando JWT (JSON Web Tokens) para garantir a segurança dos endpoints.
Tecnologias Utilizadas

    Java 17: Linguagem de programação utilizada.
    Spring Boot: Framework para desenvolvimento rápido de aplicações em Java.
    Hibernate: ORM (Object-Relational Mapping) utilizado para mapeamento dos objetos Java para o banco de dados.
    MySQL: Banco de dados relacional utilizado para armazenar as informações.
    JWT: Utilizado para autenticação e autorização.
    SLF4J e Logback: Utilizados para logging.
    Swagger: Utilizado para documentação da API.
    Ehcache: Utilizado para implementar cache na aplicação.

Funcionalidades

    Gestão de Veículos:
        Criação, leitura, atualização e exclusão de registros de veículos.
        Validação de campos (placa, marca, modelo, ano).
        Relacionamento com clientes.

    Gestão de Clientes:
        Criação, leitura, atualização e exclusão de registros de clientes.
        Validação de campos (CPF, nome, e-mail, telefone).
        Relacionamento com veículos.

    Autenticação e Autorização:
        Implementação de JWT para garantir a segurança dos endpoints.
        Endpoints protegidos para operações CRUD.

    Cache:
        Implementado cache nas operações de busca para otimizar o desempenho.

    Logging:
        Logs estruturados para monitorar as operações da API.

    Documentação da API:
        API documentada utilizando Swagger.

Requisitos de Instalação

    Java 17 ou superior
    Maven
    MySQL

Configuração

    Clone o repositório:

    bash

git clone https://github.com/seu-usuario/veiculosclientesapi.git
cd veiculosclientesapi

Configure o banco de dados no arquivo application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/veiculos_clientes_db
spring.datasource.username=root
spring.datasource.password=SuaSenha

Execute os scripts DDL para criar as tabelas no MySQL.

Compile e execute a aplicação:

bash

mvn clean install
mvn spring-boot:run

Acesse a documentação da API no Swagger:

url

    http://localhost:8080/swagger-ui/index.html

Endpoints Principais
Autenticação

    POST /auth/register: Registro de novo usuário.
    POST /auth/login: Autenticação do usuário e geração de token JWT.

Clientes

    GET /clientes: Lista todos os clientes.
    GET /clientes/{cpf}: Busca cliente por CPF.
    POST /clientes: Criação de novo cliente.
    PUT /clientes/{cpf}: Atualização de cliente existente.
    DELETE /clientes/{cpf}: Exclusão de cliente.

Veículos

    GET /veiculos: Lista todos os veículos.
    GET /veiculos/{placa}: Busca veículo por placa.
    POST /veiculos: Criação de novo veículo.
    PUT /veiculos/{placa}: Atualização de veículo existente.
    DELETE /veiculos/{placa}: Exclusão de veículo.

