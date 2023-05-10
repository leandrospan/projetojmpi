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
