-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3309
-- Tiempo de generación: 27-05-2024 a las 00:00:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `correo` varchar(128) NOT NULL,
  `celular` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `correo`, `celular`) VALUES
(1, 'Marcelo Quir', 'marcelo@mail.com', '77712345'),
(2, 'Caleb Benitez', 'benitez@mail.org', '70012345'),
(3, 'Ursula Gonzales', 'nec@lacus.ca', '79112345'),
(5, 'Juan Carlos Arce', 'conejo@mail.com', '71512345'),
(6, 'Halee Kirby', 'tiam@tempor.com', '72012345'),
(7, 'Marco Perez', 'marco@mail.com', '71526789'),
(8, 'Pedro Marquez', 'peter@mail.com', '72054578'),
(9, 'Juan de Arco', 'juanita@mail.com', '77112456'),
(10, 'Luis Callejas', 'lucho@mial.com', '77122456'),
(16, 'Marcelo Martins', 'marcelo@mail.com', '70012345'),
(20, 'katherine', 'kathy@gmail.com', '69965522');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `descripcion` text NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'iPhone 4s', 'Que viene desde Apple', 200),
(2, 'iPhone 5', 'iPhone 5 from Apple', 150),
(3, 'iPhone 5s', 'iPhone 5s is too expensive.', 300.8),
(4, 'iPad Air', 'iPad Air is thin like samurai!', 250),
(5, 'HTC One', 'Best of 2013', 250),
(6, 'God', 'God is not on sale. Sorry.', 132),
(7, 'Lenovo 2020', 'This sword is so sharp that it can slice itself. Good for slicing jellies.', 2000),
(8, 'Latitude e6420', 'Built by ultimate killing machines. For ultimate killing hobies.', 50),
(72, 'Parlantes RGB', 'Parlantes con luces rgb cno sonido surround y cargador', 112);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `email`, `password`) VALUES
(1, 'admin@mail.com', '8cb2237d0679ca88db6464eac60da96345513964'),
(2, 'marco@mail.com', '12345'),
(3, 'kathy@gmail.com', '8cb2237d0679ca88db6464eac60da96345513964');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `producto_id`, `cliente_id`, `fecha`) VALUES
(1, 1, 2, '2019-02-08'),
(2, 5, 5, '2018-01-08'),
(4, 7, 2, '2014-07-19'),
(5, 5, 8, '2019-05-07'),
(15, 5, 1, '2021-05-18');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
