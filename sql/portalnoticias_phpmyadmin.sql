-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-09-2022 a las 20:54:47
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portalnoticias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` int(11) NOT NULL,
  `contenido` varchar(250) DEFAULT NULL,
  `is_enabled` bit(1) NOT NULL,
  `id_noticia` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id_imagen` int(11) NOT NULL,
  `imagen_blob` longblob NULL,
  `id_noticia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `id_noticia` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `subtitulo` varchar(100) NOT NULL,
  `cuerpo` varchar(800) NOT NULL,
  `fecha_emision` datetime NOT NULL,
  `pdf` longblob NULL,
  `autor` varchar(50) DEFAULT NULL,
  `id_tipo_noticia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`id_noticia`, `titulo`, `subtitulo`, `cuerpo`, `fecha_emision`, `pdf`, `autor`, `id_tipo_noticia`) VALUES
(21, 'titulo_noticia_politica_1', 'subtitulo_noticia_politica_1', 'cuerpo_noticia_politica_1', '2022-07-09 16:43:00', '', 'autor_noticia_politica_1', 1),
(22, 'titulo_noticia_politica_2', 'subtitulo_noticia_politica_2', 'cuerpo_noticia_politica_2', '2022-07-09 16:43:00', '', 'autor_noticia_politica_2', 1),
(23, 'titulo_noticia_politica_3', 'subtitulo_noticia_politica_3', 'cuerpo_noticia_politica_3', '2022-07-09 16:43:00', '', 'autor_noticia_politica_3', 1),
(24, 'titulo_noticia_politica_4', 'subtitulo_noticia_politica_4', 'cuerpo_noticia_politica_4', '2022-07-09 16:43:00', '', 'autor_noticia_politica_4', 1),
(25, 'titulo_noticia_deportes_1', 'subtitulo_noticia_deportes_1', 'cuerpo_noticia_deportes_1', '2022-07-09 16:43:00', '', 'autor_noticia_deportes_1', 2),
(26, 'titulo_noticia_deportes_2', 'subtitulo_noticia_deportes_2', 'cuerpo_noticia_deportes_2', '2022-07-09 16:43:00', '', 'autor_noticia_deportes_2', 2),
(27, 'titulo_noticia_deportes_3', 'subtitulo_noticia_deportes_3', 'cuerpo_noticia_deportes_3', '2022-07-09 16:43:00', '', 'autor_noticia_deportes_3', 2),
(28, 'titulo_noticia_deportes_4', 'subtitulo_noticia_deportes_4', 'cuerpo_noticia_deportes_4', '2022-07-09 16:43:00', '', 'autor_noticia_deportes_4', 2),
(29, 'titulo_noticia_economia_1', 'subtitulo_noticia_economia_1', 'cuerpo_noticia_economia_1', '2022-07-09 16:43:00', '', 'autor_noticia_economia_1', 3),
(30, 'titulo_noticia_economia_2', 'subtitulo_noticia_economia_2', 'cuerpo_noticia_economia_2', '2022-07-09 16:43:00', '', 'autor_noticia_economia_2', 3),
(31, 'titulo_noticia_economia_3', 'subtitulo_noticia_economia_3', 'cuerpo_noticia_economia_3', '2022-07-09 16:43:00', '', 'autor_noticia_economia_3', 3),
(32, 'titulo_noticia_economia_4', 'subtitulo_noticia_economia_4', 'cuerpo_noticia_economia_4', '2022-07-09 16:43:00', '', 'autor_noticia_economia_4', 3),
(33, 'titulo_noticia_mujer_1', 'subtitulo_noticia_mujer_1', 'cuerpo_noticia_mujer_1', '2022-07-09 16:43:00', '', 'autor_noticia_mujer_1', 4),
(34, 'titulo_noticia_mujer_2', 'subtitulo_noticia_mujer_2', 'cuerpo_noticia_mujer_2', '2022-07-09 16:43:00', '', 'autor_noticia_mujer_2', 4),
(35, 'titulo_noticia_mujer_3', 'subtitulo_noticia_mujer_3', 'cuerpo_noticia_mujer_3', '2022-07-09 16:43:00', '', 'autor_noticia_mujer_3', 4),
(36, 'titulo_noticia_mujer_4', 'subtitulo_noticia_mujer_4', 'cuerpo_noticia_mujer_4', '2022-07-09 16:43:00', '', 'autor_noticia_mujer_4', 4),
(37, 'titulo_noticia_noticias_1', 'subtitulo_noticia_noticias_1', 'cuerpo_noticia_noticias_1', '2022-07-09 16:43:00', '', 'autor_noticia_noticias_1', 5),
(38, 'titulo_noticia_noticias_2', 'subtitulo_noticia_noticias_2', 'cuerpo_noticia_noticias_2', '2022-07-09 16:43:00', '', 'autor_noticia_noticias_2', 5),
(39, 'titulo_noticia_noticias_3', 'subtitulo_noticia_noticias_3', 'cuerpo_noticia_noticias_3', '2022-07-09 16:43:00', '', 'autor_noticia_noticias_3', 5),
(40, 'titulo_noticia_noticias_4', 'subtitulo_noticia_noticias_4', 'cuerpo_noticia_noticias_4', '2022-07-09 16:43:00', '', 'autor_noticia_noticias_4', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_noticia`
--

CREATE TABLE `tipo_noticia` (
  `id_tipo_noticia` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_noticia`
--

INSERT INTO `tipo_noticia` (`id_tipo_noticia`, `descripcion`) VALUES
(1, 'politica'),
(2, 'deportes'),
(3, 'economia'),
(4, 'mujer'),
(5, 'noticias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `is_enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `id_noticia` (`id_noticia`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id_imagen`),
  ADD KEY `id_noticia` (`id_noticia`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id_noticia`),
  ADD KEY `id_tipo_noticia` (`id_tipo_noticia`);

--
-- Indices de la tabla `tipo_noticia`
--
ALTER TABLE `tipo_noticia`
  ADD PRIMARY KEY (`id_tipo_noticia`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id_comentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id_imagen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id_noticia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `tipo_noticia`
--
ALTER TABLE `tipo_noticia`
  MODIFY `id_tipo_noticia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`),
  ADD CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`);

--
-- Filtros para la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD CONSTRAINT `noticia_ibfk_1` FOREIGN KEY (`id_tipo_noticia`) REFERENCES `tipo_noticia` (`id_tipo_noticia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;