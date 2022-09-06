CREATE DATABASE IF NOT EXISTS portalnoticias 
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE portalnoticias;


/*
-- TESTING DATABASE

CREATE TABLE prueba(
	id INT NULL,
    name VARCHAR(10) NULL
);

COMMIT;

INSERT INTO prueba (id, name) 
VALUES 
	(1, 'nombre_1'),
    (2, 'nombre_2'),
    (3, 'nombre_3'),
    (4, 'nombre_4'),
    (5, 'nombre_5'),
    (6, 'nombre_6');

SELECT * FROM prueba;

*/


CREATE TABLE tipo_noticia (
    id_tipo_noticia INT PRIMARY KEY AUTO_INCREMENT,
    descripcion     VARCHAR(45) NOT NULL
);

CREATE TABLE usuario (
    id_usuario  INT PRIMARY KEY AUTO_INCREMENT,
    nickname    VARCHAR(45) NOT NULL,
    password     VARCHAR(45) NOT NULL,
    is_enabled  BIT NOT NULL
);

CREATE TABLE noticia (
    id_noticia INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    subtitulo VARCHAR(100) NOT NULL,
    cuerpo VARCHAR(800) NOT NULL,
    fecha_emision DATETIME NOT NULL,
    pdf MEDIUMBLOB NOT NULL,
    autor VARCHAR(50) NULL,

    id_tipo_noticia INT,
    FOREIGN KEY (id_tipo_noticia) REFERENCES tipo_noticia(id_tipo_noticia)
);
CREATE TABLE imagen (
    id_imagen INT PRIMARY KEY AUTO_INCREMENT,
    imagen_blob MEDIUMBLOB NOT NULL,

    id_noticia INT,
    FOREIGN KEY (id_noticia) REFERENCES noticia(id_noticia)
);

CREATE TABLE comentario (
    id_comentario INT PRIMARY KEY AUTO_INCREMENT,
    contenido VARCHAR(250) NULL,
    is_enabled BIT NOT NULL,
    id_noticia INT,
    FOREIGN KEY (id_noticia) REFERENCES noticia(id_noticia),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);


-- INSERTS
INSERT INTO tipo_noticia (descripcion) 
VALUES ('politica'),('deportes'),('economia'),('mujer'),('noticias');

