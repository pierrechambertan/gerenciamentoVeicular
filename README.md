markdown



## Descrição

API REST para gerenciar veículos e clientes usando Java 17, Spring Boot, Hibernate, MySQL e autenticação JWT.

## Configuração

### Banco de Dados

1. Crie o banco de dados MySQL:
   ```sql
   CREATE DATABASE veiculos_clientes_db;

    Configure as credenciais no application.properties:

    properties

    spring.datasource.url=jdbc:mysql://localhost:3306/veiculos_clientes_db
    spring.datasource.username=root
    spring.datasource.password=Gawaluzia01!

Execução

    Clone o repositório:

    bash

git clone https://github.com/pierrechambertan/Desafio_omni.git
cd Desafio_omni

Construa e execute o projeto:

bash

    mvn clean install
    mvn spring-boot:run

Acesse a API em http://localhost:8080.
Endpoints

    Autenticação:
        Registro: POST /auth/register
        Login: POST /auth/login

    Clientes:
        Criar: POST /clientes
        Listar: GET /clientes
        Obter por CPF: GET /clientes/{cpf}
        Atualizar: PUT /clientes/{cpf}
        Deletar: DELETE /clientes/{cpf}

    Veículos:
        Criar: POST /veiculos
        Listar: GET /veiculos
        Obter por Placa: GET /veiculos/{placa}
        Atualizar: PUT /veiculos/{placa}
        Deletar: DELETE /veiculos/{placa}


