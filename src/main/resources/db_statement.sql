#MYSQL Statements

#create database
CREATE DATABASE enderecos;


#create table
CREATE TABLE `menagerie`.`endereco`
(
endereco_id bigint(20),
bairro varchar(255),
cep varchar(255),
cidade varchar(255),
complemento varchar(255),
estado varchar(255),
numero varchar(255),
rua varchar(255)
);


#insert 
INSERT INTO `enderecos`.`endereco`
(`bairro`,
`cep`,
`cidade`,
`complemento`,
`estado`,
`numero`,
`rua`)
VALUES
('jardins',
'555555555',
'sao paulo',
'casa',
'sp',
'167',
'rua do cafe');
