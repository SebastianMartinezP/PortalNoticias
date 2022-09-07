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

INSERT INTO noticia (titulo, subtitulo, cuerpo, fecha_emision, autor, id_tipo_noticia, pdf)
VALUES
('titulo_noticia_politica_1', 'subtitulo_noticia_politica_1', 'cuerpo_noticia_politica_1', '2022/07/09 16:43:00', 'autor_noticia_politica_1', 6, null),
('titulo_noticia_politica_2', 'subtitulo_noticia_politica_2', 'cuerpo_noticia_politica_2', '2022/07/09 16:43:00', 'autor_noticia_politica_2', 6, null),
('titulo_noticia_politica_3', 'subtitulo_noticia_politica_3', 'cuerpo_noticia_politica_3', '2022/07/09 16:43:00', 'autor_noticia_politica_3', 6, null),
('titulo_noticia_politica_4', 'subtitulo_noticia_politica_4', 'cuerpo_noticia_politica_4', '2022/07/09 16:43:00', 'autor_noticia_politica_4', 6, null),
('titulo_noticia_deportes_1', 'subtitulo_noticia_deportes_1', 'cuerpo_noticia_deportes_1', '2022/07/09 16:43:00', 'autor_noticia_deportes_1', 7, null),
('titulo_noticia_deportes_2', 'subtitulo_noticia_deportes_2', 'cuerpo_noticia_deportes_2', '2022/07/09 16:43:00', 'autor_noticia_deportes_2', 7, null),
('titulo_noticia_deportes_3', 'subtitulo_noticia_deportes_3', 'cuerpo_noticia_deportes_3', '2022/07/09 16:43:00', 'autor_noticia_deportes_3', 7, null),
('titulo_noticia_deportes_4', 'subtitulo_noticia_deportes_4', 'cuerpo_noticia_deportes_4', '2022/07/09 16:43:00', 'autor_noticia_deportes_4', 7, null),
('titulo_noticia_economia_1', 'subtitulo_noticia_economia_1', 'cuerpo_noticia_economia_1', '2022/07/09 16:43:00', 'autor_noticia_economia_1', 8, null),
('titulo_noticia_economia_2', 'subtitulo_noticia_economia_2', 'cuerpo_noticia_economia_2', '2022/07/09 16:43:00', 'autor_noticia_economia_2', 8, null),
('titulo_noticia_economia_3', 'subtitulo_noticia_economia_3', 'cuerpo_noticia_economia_3', '2022/07/09 16:43:00', 'autor_noticia_economia_3', 8, null),
('titulo_noticia_economia_4', 'subtitulo_noticia_economia_4', 'cuerpo_noticia_economia_4', '2022/07/09 16:43:00', 'autor_noticia_economia_4', 8, null),
('titulo_noticia_mujer_1', 'subtitulo_noticia_mujer_1', 'cuerpo_noticia_mujer_1', '2022/07/09 16:43:00', 'autor_noticia_mujer_1', 9, null),
('titulo_noticia_mujer_2', 'subtitulo_noticia_mujer_2', 'cuerpo_noticia_mujer_2', '2022/07/09 16:43:00', 'autor_noticia_mujer_2', 9, null),
('titulo_noticia_mujer_3', 'subtitulo_noticia_mujer_3', 'cuerpo_noticia_mujer_3', '2022/07/09 16:43:00', 'autor_noticia_mujer_3', 9, null),
('titulo_noticia_mujer_4', 'subtitulo_noticia_mujer_4', 'cuerpo_noticia_mujer_4', '2022/07/09 16:43:00', 'autor_noticia_mujer_4', 9, null),
('titulo_noticia_noticias_1', 'subtitulo_noticia_noticias_1', 'cuerpo_noticia_noticias_1', '2022/07/09 16:43:00', 'autor_noticia_noticias_1',10, null),
('titulo_noticia_noticias_2', 'subtitulo_noticia_noticias_2', 'cuerpo_noticia_noticias_2', '2022/07/09 16:43:00', 'autor_noticia_noticias_2',10, null),
('titulo_noticia_noticias_3', 'subtitulo_noticia_noticias_3', 'cuerpo_noticia_noticias_3', '2022/07/09 16:43:00', 'autor_noticia_noticias_3',10, null),
('titulo_noticia_noticias_4', 'subtitulo_noticia_noticias_4', 'cuerpo_noticia_noticias_4', '2022/07/09 16:43:00', 'autor_noticia_noticias_4',10, null);