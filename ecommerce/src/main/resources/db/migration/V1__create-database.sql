-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24/11/2024 às 17:13
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ecommerce`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `auditoria`
--

CREATE TABLE `auditoria` (
  `id_auditoria` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `valor_atual` decimal(10,2) DEFAULT NULL,
  `valor_novo` decimal(10,2) DEFAULT NULL,
  `motivo` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome_categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nome_categoria`) VALUES
(1, 'Placas de Vídeo'),
(2, 'Processadores'),
(3, 'Memória RAM'),
(4, 'Armazenamento'),
(5, 'Fontes'),
(6, 'Gabinetes'),
(7, 'Placas Mãe'),
(8, 'Coolers'),
(9, 'Kit Upgrade');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nasc` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` int(11) DEFAULT NULL,
  `id_endereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `endereco`
--

CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL,
  `logr` varchar(100) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `cep` varchar(7) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `forma_pgto`
--

CREATE TABLE `forma_pgto` (
  `id_forma_pgto` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `item_pedido`
--

CREATE TABLE `item_pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `id_pedido` int(11) NOT NULL,
  `id_forma_pgto` int(11) NOT NULL,
  `data_pgto` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_pedido` date NOT NULL,
  `total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `nome_produto` varchar(100) NOT NULL,
  `ds_produto` text NOT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `nome_produto`, `ds_produto`, `preco`, `id_categoria`) VALUES
(1, 'Placa de Vídeo RTX 4060 VENTUS MSI', 'a', 1969.99, 1),
(2, 'Placa de Vídeo RX 6750XT Gaming XFX', 'a', 2199.99, 1),
(3, 'Placa de Vídeo RTX 4070 Super Gigabyte', 'a', 4199.99, 1),
(4, 'Placa de Vídeo RX 570 Phantom Gaming Elite ASRock', 'a', 719.99, 1),
(5, 'Placa de Vídeo RX 7600 GAMING OC 8G AMD Radeon Gigabyte', 'a', 1799.99, 1),
(6, 'Processador AMD Ryzen 7 5700X3D', 'a', 1397.99, 2),
(7, 'Processador Intel Core i5-12400F', 'a', 669.99, 2),
(8, 'Processador AMD Ryzen 7 7800X3D', 'a', 2999.99, 2),
(9, 'Processador Intel Core i3-10105', 'a', 599.99, 2),
(10, 'Processador Intel Core i9-14900KF', 'a', 3599.99, 2),
(11, 'Fonte Gamer Rise Mode Zeus_500W_White_PFC Ativo_Preto', 'a', 219.99, 5),
(12, 'Fonte Gamer Rise Mode Zeus 850W_Platinum_Full Modular_PFC Ativo', 'a', 629.99, 5),
(13, 'Fonte Corsair CX Series CX750_750W_80 Plus Bronze_Com Cabo', 'a', 499.99, 5),
(14, 'Fonte XPG Core Reactor_850W_80 Plus Gold_Modular_com cabo', 'a', 629.99, 5),
(15, 'Fonte MSI MAG A850GL, 850W, 80 Plus Gold, Modular, PFC Ativo', 'a', 679.99, 5),
(16, 'Memória RAM Kingston Fury Beast, 16GB, 3200MHz, DDR4', 'a', 273.99, 3),
(17, 'Memória RAM Gamer Husky Gaming Avalanche, 8GB, 3200MHz, DDR4', 'a', 139.99, 3),
(18, 'Memória RAM Kingston Fury Beast, RGB, 16GB, 3200MHz, DDR4', 'a', 299.99, 3),
(19, 'Memória RAM Rise Mode Z, 8GB, 3200MHz, DDR4', 'a', 119.99, 3),
(20, 'Memória RAM XPG Spectrix D35G, RGB, 16GB, 3200MHz, DDR4', 'a', 264.99, 3),
(21, 'HD Seagate IronWolf NAS, 8TB, SATA', 'a', 1309.99, 4),
(22, 'HD Externo Portátil 2TB Seagate, USB 3.0', 'a', 489.99, 4),
(23, 'SSD Kingston A400, 480 GB, SATA III, 2.5\"', 'a', 239.99, 4),
(24, 'SSD Kingston NV3, 500 GB', 'a', 339.99, 4),
(25, 'SSD Kingston Fury Renegade, 1 TB, M.2', 'a', 599.99, 4),
(26, 'Placa Mãe Asus TUF GAMING A520M-PLUS II, AMD AM4', 'a', 599.99, 7),
(27, 'Placa Mãe Gigabyte B550M Aorus Elite (rev. 1.3), AMD AM4, Micro ATX, DDR4', 'a', 829.99, 7),
(28, 'Placa Mãe MSI A520M-A PRO, AMD AM4, mATX, DDR4', 'a', 399.99, 7),
(29, 'Placa Mãe ASRock B450M Steel Legend, AMD AM4, mATX, DDR4', 'a', 769.99, 7),
(30, 'Placa Mãe Gigabyte X670e Aorus Xtreme, DDR5, E-ATX, AM5', 'a', 6581.52, 7),
(31, 'Gabinete Gamer Corsair 4000D Airflow, Mid-Tower', 'a', 599.90, 6),
(32, 'Gabinete Gamer Rise Mode Glass 06X, Mid Tower', 'a', 229.90, 6),
(33, 'Gabinete Gamer Redragon Superion, Mid Tower', 'a', 289.90, 6),
(34, 'Gabinete Gamer Sharkoon TG4, RGB, Mid Tower', 'a', 329.90, 6),
(35, 'Gabinete Corsair iCUE Link 6500X, Mid Tower', 'a', 2329.90, 6);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `auditoria`
--
ALTER TABLE `auditoria`
  ADD PRIMARY KEY (`id_auditoria`),
  ADD KEY `id_produto` (`id_produto`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `id_endereco` (`id_endereco`);

--
-- Índices de tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`);

--
-- Índices de tabela `forma_pgto`
--
ALTER TABLE `forma_pgto`
  ADD PRIMARY KEY (`id_forma_pgto`);

--
-- Índices de tabela `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD PRIMARY KEY (`id_pedido`,`id_produto`),
  ADD KEY `fk_produto` (`id_produto`);

--
-- Índices de tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`id_pedido`,`id_forma_pgto`,`data_pgto`),
  ADD KEY `fk_pagamento_forma_pgto` (`id_forma_pgto`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `auditoria`
--
ALTER TABLE `auditoria`
  MODIFY `id_auditoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `forma_pgto`
--
ALTER TABLE `forma_pgto`
  MODIFY `id_forma_pgto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `auditoria`
--
ALTER TABLE `auditoria`
  ADD CONSTRAINT `auditoria_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`);

--
-- Restrições para tabelas `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`);

--
-- Restrições para tabelas `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD CONSTRAINT `fk_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `fk_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`);

--
-- Restrições para tabelas `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `fk_pagamento_forma_pgto` FOREIGN KEY (`id_forma_pgto`) REFERENCES `forma_pgto` (`id_forma_pgto`),
  ADD CONSTRAINT `fk_pagamento_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
