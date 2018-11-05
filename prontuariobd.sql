-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Nov-2018 às 23:10
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prontuariobd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE `animal` (
  `id` int(8) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `idade` int(3) NOT NULL,
  `tipo` varchar(32) NOT NULL,
  `cor` varchar(32) NOT NULL,
  `idCliente` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(8) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `cpf` int(11) NOT NULL,
  `endereco` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `id` int(8) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `cpf` int(11) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `matricula` int(16) NOT NULL,
  `cargo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`id`, `nome`, `cpf`, `senha`, `matricula`, `cargo`) VALUES
(1, 'admin', 1, '1', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `prontuario`
--

CREATE TABLE `prontuario` (
  `id` int(8) NOT NULL,
  `idAnimal` int(8) NOT NULL,
  `idAluno` int(8) NOT NULL,
  `idProfessor` int(8) NOT NULL,
  `motivo` text NOT NULL,
  `tratamento` text NOT NULL,
  `dataAtendimento` date NOT NULL,
  `dataRetorno` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cliente` (`idCliente`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prontuario`
--
ALTER TABLE `prontuario`
  ADD KEY `fk_animal` (`idAnimal`),
  ADD KEY `fk_aluno` (`idAluno`),
  ADD KEY `fk_professor` (`idProfessor`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`);

--
-- Limitadores para a tabela `prontuario`
--
ALTER TABLE `prontuario`
  ADD CONSTRAINT `fk_aluno` FOREIGN KEY (`idAluno`) REFERENCES `medico` (`id`),
  ADD CONSTRAINT `fk_animal` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`id`),
  ADD CONSTRAINT `fk_professor` FOREIGN KEY (`idProfessor`) REFERENCES `medico` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
