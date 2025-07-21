CREATE DATABASE MERCADINHO;

	CREATE TABLE PRODUTOS(
		 codProduto VARCHAR (10),
		 nomeProduto VARCHAR(50),
		 PRECO NUMERIC(17,2),
		 QUANTIDADEESTOQUE INT,	
		 PESOS NUMERIC(17,2)
	)


	CREATE TABLE CLIENTES(
		 codCliente VARCHAR (10),
		 nomeCompleto VARCHAR(50),
		 cpfCnpj VARCHAR(11),
		 email VARCHAR(50),
		 telefone VARCHAR (10)
	)


	CREATE TABLE ENDERECOS(
		 codCliente VARCHAR (10),
		 CEP VARCHAR(50),
		 rua VARCHAR(11),
		 número VARCHAR(50),
		 bairro VARCHAR (50),
		 cidade VARCHAR (50),
		 estado VARCHAR (50),
		 complemento VARCHAR (50)
	)

	CREATE TABLE CATEGORIAS(
		codCategoria VARCHAR(11),
		nomeCategoria VARCHAR(11),
		descricaoCategoria VARCHAR(50)	
	)


	CREATE TABLE SUBCATEGORIAS(
		codCategoria VARCHAR(11),
		codSubCategoria VARCHAR(11),
		nomeSubCategoria VARCHAR(11),
		descricaoSubCategoria VARCHAR(50)	
	)



