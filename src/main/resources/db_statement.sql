#MYSQL Statements

#create database
CREATE DATABASE enderecos;


#create table
CREATE TABLE `menagerie`.`endereco`
(
endereco_id bigint(20),
bairro varchar(55),
cep varchar(60),
cidade varchar(55),
complemento varchar(55),
estado varchar(55),
numero varchar(55),
rua varchar(80)
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
