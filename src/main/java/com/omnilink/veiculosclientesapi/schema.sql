CREATE TABLE clientes (
                          cpf VARCHAR(11) PRIMARY KEY,
                          nome VARCHAR(100),
                          email VARCHAR(255),
                          telefone VARCHAR(15)
);

CREATE TABLE veiculos (
                          placa VARCHAR(7) PRIMARY KEY,
                          marca VARCHAR(50),
                          modelo VARCHAR(50),
                          ano INT,
                          possuiRastreador BOOLEAN,
                          numeroRastreador VARCHAR(50),
                          cliente_cpf VARCHAR(11),
                          FOREIGN KEY (cliente_cpf) REFERENCES clientes(cpf)
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       login VARCHAR(50) UNIQUE,
                       password VARCHAR(255),
                       role VARCHAR(20)
);
