DROP DATABASE balonmano;
CREATE DATABASE balonmano;
USE balonmano;
CREATE TABLE Club(
nombre VARCHAR(50) UNIQUE NOT NULL,
cp INT,
localidad VARCHAR(50) NOT NULL,
teléfono VARCHAR(15) NOT NULL,
calle VARCHAR(100) NOT NULL,
numero INT NOT NULL,
piso INT ,
escalera VARCHAR(50),
persona_contacto VARCHAR(50),
PRIMARY KEY (nombre)
);

CREATE TABLE Categoria_edad (
id INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
descripcion VARCHAR(100) NOT NULL,
edad_minima INT,
edad_maxima INT,
PRIMARY KEY (id)
);

CREATE TABLE Categoria_competicion(
id INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
descripción VARCHAR(100) NOT NULL,
numero_max_equipos INT,
PRIMARY KEY (id)
);

CREATE TABLE Equipo(
licencia CHAR(5) UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
telefono VARCHAR(15) NOT NULL,
nombre_Club VARCHAR(100),
id_Categoria_edad INT,
id_Categoria_competicion INT,
PRIMARY KEY (licencia),
FOREIGN KEY (nombre_Club) REFERENCES Club (nombre)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_Categoria_edad) REFERENCES Categoria_edad(id)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_Categoria_competicion) REFERENCES Categoria_competicion(id)
ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Centro_Deportivo(
id INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
calle VARCHAR(100) NOT NULL,
numero INT NOT NULL,
cp INT NOT NULL,
localidad VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE Arbitro(
numero_colegiado INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido1 VARCHAR(50) NOT NULL,
apellido2 VARCHAR(50) NOT NULL,
PRIMARY KEY (numero_colegiado)
);

CREATE TABLE Partido(
id INT UNIQUE NOT NULL,
fecha DATE,
licencia_Equipo CHAR(5),
id_Centro_Deportivo INT,
numero_colegiado_Arbitro INT,
PRIMARY KEY (id),
FOREIGN KEY (licencia_Equipo) REFERENCES Equipo(licencia)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_Centro_Deportivo) REFERENCES Centro_Deportivo(id)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (numero_colegiado_Arbitro) REFERENCES Arbitro(numero_colegiado)
ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Acta(
id INT UNIQUE NOT NULL,
tantos_equipo_visitante INT,
tantos_equipo_local INT,
hora_inicio TIME,
PRIMARY KEY (id)
);

CREATE TABLE Jugador(
nif INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido1 VARCHAR(50) NOT NULL,
apellido2 VARCHAR(50) NOT NULL,
fecha_nacimiento DATE,
PRIMARY KEY (nif)
);

CREATE TABLE Jugador_registra_Acta(
nif_Jugador INT,
id_Acta INT,
FOREIGN KEY (nif_Jugador) REFERENCES Jugador(nif)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_Acta) REFERENCES Acta(id)
ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Equipo_milita_Jugador(
fecha_inicio DATE UNIQUE,
fecha_fin DATE,
licencia_Equipo CHAR(5),
nif_Jugador INT,
PRIMARY KEY (fecha_inicio),
FOREIGN KEY (licencia_Equipo) REFERENCES Equipo (licencia)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (nif_Jugador) REFERENCES Jugador(nif)
ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Tipo_evento(
id INT UNIQUE NOT NULL,
nombre VARCHAR(50) NOT NULL,
descripcion VARCHAR(100) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE Evento(
hora_de_partido TIME UNIQUE,
id_Acta INT,
nif_Jugador INT,
id_Tipo_evento INT,
PRIMARY KEY (hora_de_partido),
FOREIGN KEY (id_Acta) REFERENCES Acta(id)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (nif_Jugador) REFERENCES Jugador(nif)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_Tipo_evento) REFERENCES Tipo_evento(id)
ON DELETE SET NULL ON UPDATE CASCADE
);