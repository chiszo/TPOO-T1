-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2025 a las 02:17:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuerto`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpasajero` ()   BEGIN
    SELECT 
        p.idpasajero,
        p.nombre,
        p.documento,
        p.telefono,
        c.descripcion
    FROM pasajero p
    INNER JOIN tipodocumento c 
        ON c.idtipodocumento = p.idtipodocumento;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarvuelo` ()   BEGIN
    SELECT 
        p.idvuelo,
        p.origen,
        p.destino,
        p.capacidad,
        p.ocupados,
        c.estado
    FROM vuelo p
    INNER JOIN puerta c 
        ON c.idpuerta = p.puerta;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipaje`
--

CREATE TABLE `equipaje` (
  `idequipaje` int(11) NOT NULL,
  `idpasajero` int(11) NOT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipaje`
--

INSERT INTO `equipaje` (`idequipaje`, `idpasajero`, `peso`) VALUES
(1, 1, 15.5),
(2, 2, 20),
(3, 3, 18.3),
(4, 4, 22.1),
(5, 5, 19.8),
(6, 6, 17),
(7, 7, 16.4),
(8, 8, 21.2),
(9, 9, 14.9),
(10, 10, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero`
--

CREATE TABLE `pasajero` (
  `idpasajero` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `documento` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `idtipodocumento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajero`
--

INSERT INTO `pasajero` (`idpasajero`, `nombre`, `documento`, `telefono`, `idtipodocumento`) VALUES
(1, 'Juan Pérez', '12345678', '987654321', 1),
(2, 'María López', '87654321', '912345678', 2),
(3, 'Carlos Ruiz', '11223344', '999888777', 3),
(4, 'Ana Torres', '55667788', '988776655', 4),
(5, 'Luis Gómez', '99887766', '977665544', 5),
(6, 'Sofía Castro', '44332211', '966554433', 6),
(7, 'Pedro Sánchez', '33445566', '955443322', 7),
(8, 'Laura Fernández', '22113344', '944332211', 2),
(9, 'Diego Morales', '66778899', '933221100', 9),
(10, 'Valeria Ríos', '77889900', '922110099', 10),
(11, 'Gibeth', '74854123', '912561329', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puerta`
--

CREATE TABLE `puerta` (
  `idpuerta` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `puerta`
--

INSERT INTO `puerta` (`idpuerta`, `estado`) VALUES
(1, 'disponible'),
(2, 'no disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetaembarque`
--

CREATE TABLE `tarjetaembarque` (
  `idtarjetaEmbarque` int(11) NOT NULL,
  `idpasajero` int(11) NOT NULL,
  `asiento` varchar(10) NOT NULL,
  `idpuerta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idtipodocumento`, `descripcion`) VALUES
(1, 'DNI'),
(2, 'Pasaporte'),
(3, 'Carnet Extranjería'),
(4, 'Licencia'),
(5, 'ID Militar'),
(6, 'Visa'),
(7, 'Permiso Temporal'),
(8, 'Cedula'),
(9, 'Documento Nacional'),
(10, 'Otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`username`, `password`, `rol`, `nombre`, `id_usuario`) VALUES
('admin', 'admin123', 'Administrador', 'Administrador', 1),
('anatorres', 'passana', 'Cliente', 'Ana', 2),
('carlosr', 'passcarlos', 'Cliente', 'Carlos', 3),
('diegom', 'passdiego', 'Cliente', 'Diego', 4),
('juanp', 'passjuan', 'Cliente', 'Juan', 5),
('lauraf', 'passlaura', 'Cliente', 'Laura', 6),
('luisg', 'passluis', 'Cliente', 'Luis', 7),
('marial', 'passmaria', 'Cliente', 'Maria', 8),
('pedros', 'passpedro', 'Cliente', 'Pedro', 9),
('sofiac', 'passsofia', 'Cliente', 'Sofia', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `idvuelo` int(11) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `ocupados` int(11) DEFAULT 0,
  `puerta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`idvuelo`, `origen`, `destino`, `capacidad`, `ocupados`, `puerta`) VALUES
(1, 'Lima', 'Cusco', 180, 90, 1),
(2, 'Lima', 'Arequipa', 150, 75, 2),
(3, 'Lima', 'Trujillo', 120, 60, 2),
(4, 'Lima', 'Piura', 100, 50, 2),
(5, 'Lima', 'Iquitos', 130, 65, 2),
(6, 'Lima', 'Tacna', 140, 70, 1),
(7, 'Lima', 'Chiclayo', 110, 55, 1),
(8, 'Lima', 'Pucallpa', 125, 62, 1),
(9, 'Lima', 'Juliaca', 135, 67, 2),
(10, 'Lima', 'Tumbes', 115, 57, 2),
(11, 'Huanuco', 'Ica', 200, 120, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipaje`
--
ALTER TABLE `equipaje`
  ADD PRIMARY KEY (`idequipaje`),
  ADD KEY `idpasajero` (`idpasajero`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`idpasajero`),
  ADD KEY `idtipodocumento` (`idtipodocumento`);

--
-- Indices de la tabla `puerta`
--
ALTER TABLE `puerta`
  ADD PRIMARY KEY (`idpuerta`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `tarjetaembarque`
--
ALTER TABLE `tarjetaembarque`
  ADD PRIMARY KEY (`idtarjetaEmbarque`),
  ADD KEY `idpasajero` (`idpasajero`),
  ADD KEY `idpuerta` (`idpuerta`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idtipodocumento`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`id_usuario`,`id_rol`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`idvuelo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipaje`
--
ALTER TABLE `equipaje`
  MODIFY `idequipaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  MODIFY `idpasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `puerta`
--
ALTER TABLE `puerta`
  MODIFY `idpuerta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarjetaembarque`
--
ALTER TABLE `tarjetaembarque`
  MODIFY `idtarjetaEmbarque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `idvuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipaje`
--
ALTER TABLE `equipaje`
  ADD CONSTRAINT `equipaje_ibfk_1` FOREIGN KEY (`idpasajero`) REFERENCES `pasajero` (`idpasajero`);

--
-- Filtros para la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD CONSTRAINT `pasajero_ibfk_1` FOREIGN KEY (`idtipodocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);

--
-- Filtros para la tabla `tarjetaembarque`
--
ALTER TABLE `tarjetaembarque`
  ADD CONSTRAINT `tarjetaembarque_ibfk_1` FOREIGN KEY (`idpasajero`) REFERENCES `pasajero` (`idpasajero`),
  ADD CONSTRAINT `tarjetaembarque_ibfk_2` FOREIGN KEY (`idpuerta`) REFERENCES `puerta` (`idpuerta`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
