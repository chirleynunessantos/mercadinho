
CREATE TABLE PRODUTOS (
    codigo_produto VARCHAR(10) PRIMARY KEY,
    nome_produto VARCHAR(50) NOT NULL,
    preco NUMERIC(17,2) NOT NULL,
    quantidade_estoque INT NOT NULL,
	descricao VARCHAR(50),
    peso NUMERIC(17,2) NOT NULL
);