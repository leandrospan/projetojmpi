# projetojmpi
Projeto de junção de java - mariadb - php - ionic

para conectar o JDBC, coloque ele na pasta do projeto
logo depois crie uma variável de ambiente chamada CLASSPATH
e nela coloque da seguinte maneira:
.;c:\caminhodoprojeto;c:\caminhodoprojeto\arquivojdbc.jar

Banco
CREATE DATABASE banco01;

USE banco01;

CREATE TABLE usuarios(codusu INT NOT NULL AUTO_INCREMENT, usuario VARCHAR(255), senha VARCHAR(255), tipo VARCHAR(255), PRIMARY KEY(codusu));

INSERT INTO usuarios(usuario, senha, tipo) VALUES ('leandro', '123', 'admin');

CREATE TABLE clientes(codcli INT NOT NULL AUTO_INCREMENT, nome VARCHAR(255), sobrenome VARCHAR(255), rg VARCHAR(255), cpf VARCHAR(11), rua VARCHAR(255), bairro VARCHAR(255), numero VARCHAR(255), complemento VARCHAR(255), cep VARCHAR(255), cidade VARCHAR(255), estado VARCHAR(255), sexo VARCHAR(255), estadocivil VARCHAR(255), datanascimento VARCHAR(255), PRIMARY KEY(codcli));