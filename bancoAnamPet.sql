CREATE DATABASE IF NOT EXISTS anampet;
USE anampet;

CREATE TABLE IF NOT EXISTS usuarios(
	id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    crmv VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    login VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS tutores(
	id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL, 
    bairro VARCHAR(255) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255) NOT NULL,
    observacao VARCHAR(255) NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS pets(
	id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    raca VARCHAR(255) NOT NULL,
    castrado BOOLEAN NOT NULL,
    data_castracao DATE,
    pelagem VARCHAR(255) NOT NULL,
    acesso_rua BOOLEAN NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(255) NOT NULL,
    microchip VARCHAR(255),
    porte VARCHAR(255) NOT NULL,
    temperamento VARCHAR(255),
    observacao VARCHAR(255),
    vivo BOOLEAN NOT NULL,
    id_tutor INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_tutor) REFERENCES tutores(id)
);

CREATE TABLE IF NOT EXISTS consultas(
	id INT AUTO_INCREMENT,
    data_realizada DATE NOT NULL,
    temperatura DOUBLE NOT NULL,
    peso DOUBLE,
    vacinou BOOLEAN NOT NULL,
    atendimento_medico BOOLEAN NOT NULL,
    prescreveu BOOLEAN NOT NULL,
	observacao VARCHAR(255),
    id_pet INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pet) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS pesagens(
	id INT AUTO_INCREMENT,
    data_realizada DATE NOT NULL,
    indice_corporal VARCHAR(255) NOT NULL,
    observacao VARCHAR(255),
    id_pet INT NOT NULL,
    id_consulta INT,
    PRIMARY KEY (id),
    FOREIGN KEY(id_consulta) REFERENCES consultas(id),
    FOREIGN KEY (id_pet) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS vacinas(
	id INT AUTO_INCREMENT,
    data_realizada DATE,
    tipo VARCHAR(255) NOT NULL,
    nome_produto VARCHAR(255) NOT NULL,
    marca_produto VARCHAR(255) NOT NULL,
    reforco BOOLEAN NOT NULL,
    id_pet INT NOT NULL,
    id_consulta INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(id_consulta) REFERENCES consultas(id),
    FOREIGN KEY (id_pet) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS prescricoes(
	id INT AUTO_INCREMENT,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS prontuarios(
	id INT AUTO_INCREMENT,
    PRIMARY KEY (id)
);