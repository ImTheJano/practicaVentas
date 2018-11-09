DROP DATABASE IF EXISTS DMaquila;
CREATE DATABASE DMaquila;
USE DMAquila;
DROP TABLE IF EXISTS presona;
CREATE TABLE persona(
	id INT AUTO_INCREMENT,
	nombre VARCHAR(50),
	apellidoPat VARCHAR(50),
	apellidoMat VARCHAR(50),
	fechaNac VARCHAR(10),
	direccion VARCHAR(50),
	email VARCHAR(50),
	UNIQUE KEY(nombre,apellidoPat,apellidoMat),
	PRIMARY KEY(id)
);
INSERT INTO persona VALUES 
	(1,'Daniela','Aguilar','Aguirre','01-01-1993','neza','soyDaniela@hotmail.com'),
	(2,'Amalia','Aguilar','Aguirre','10-05-1992','neza','soyAmalia@hotmail.com'),
	(3,'Antonio','Torres','Camacho','01-01-1993','neza','soyTono@hotmail.com');
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	persona INT,
	usr VARCHAR(20),
	pwd VARCHAR(20),
	tipoUsuario INT,
	PRIMARY KEY(persona),
	FOREIGN KEY (persona) REFERENCES persona(id),
	UNIQUE KEY (usr)
);
INSERT INTO usuario VALUES
	(1,'root','root',1),
	(2,'vendedor','123',2);
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente(
	persona INT,
	saldo DOUBLE,
	compras INT,
	PRIMARY KEY(persona),
	FOREIGN KEY (persona) REFERENCES persona(id)
);
INSERT INTO cliente VALUES
	(3,0,0);
DROP TABLE IF EXISTS producto;
CREATE TABLE producto(
	id INT AUTO_INCREMENT,
	nombre VARCHAR(50),
	color VARCHAR(20),
	talla VARCHAR(20),
	detalle VARCHAR(20),
	cantidad INT,
	precio DOUBLE,
	PRIMARY KEY(id),
	UNIQUE KEY(nombre,color,talla)
);
INSERT INTO producto VALUES
	(1,'camisa','azul','ch','rayas',500,99.9);
DROP TABLE IF EXISTS compra;
CREATE TABLE compra(
	id INT AUTO_INCREMENT,
	cliente INT,
	vendedor INT,
	total DOUBLE,
	fecha VARCHAR(20),
	PRIMARY KEY(id),
	FOREIGN KEY (cliente) REFERENCES cliente(persona),
	FOREIGN KEY (vendedor) REFERENCES usuario(persona),
	UNIQUE KEY (cliente,fecha)
);	
DROP TABLE IF EXISTS productoCompra;
CREATE TABLE productoCompra(
	producto INT,
	compra INT,
	cantidad INT,
	PRIMARY KEY(producto,compra),
	FOREIGN KEY(compra) references compra(id),
	FOREIGN KEY(producto) references producto(id)
);
