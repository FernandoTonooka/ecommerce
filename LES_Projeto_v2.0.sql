CREATE DATABASE  IF NOT EXISTS `ecommerce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ecommerce`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_cartao`
--

DROP TABLE IF EXISTS `tb_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cartao` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `bandeira` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `validade` date DEFAULT NULL,
  `cvv` varchar(45) DEFAULT NULL,
  `id_cli` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `id_UNIQUE` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cartao`
--

LOCK TABLES `tb_cartao` WRITE;
/*!40000 ALTER TABLE `tb_cartao` DISABLE KEYS */;
INSERT INTO `tb_cartao` VALUES (3,'dinersclub','Fernando Koiti Tonooka','123456789012','2023-10-10','444',43),(4,'mastercard','Fernando Koiti Tonooka','1234123412341234','2023-10-10','444',43),(9,'americanexpress','MÃ´nica Sales Tonooka','666666666','2021-12-15','666',44),(10,'visa','MÃ´nica Sales Tonooka','999999999999','2025-02-04','555',44),(13,'americanexpress','Fernando Koiti Tonooka','123123123123','2023-02-08','222',43),(15,'americanexpress','José da Silva','322123554666','2022-11-02','111',45),(16,'hipercard','José da Silva','098098098098','2022-09-12','999',45);
/*!40000 ALTER TABLE `tb_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `cli_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `dtnascimento` date DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cli_id`),
  UNIQUE KEY `cli_id_UNIQUE` (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (43,'Fernando Koiti Tonooka','masculino','1971-12-12','154.421.628-92','11996154593','fernandotonooka@icloud.com','12345678'),(44,'Mônica Sales Tonooka','feminino','1971-08-07','185.985.658-65','(11) 99993-9868','monicatonooka@gmail.com','777777'),(45,'José da Silva','outro','1974-01-03','965.771.068-51','(11) 91234-5678','josedasilva@teste.com','888888'),(46,'João da Silva','masculino','2021-09-21','69396973815','11987654321','teste@teste.com','123456'),(48,'Teste Funcional','outro','2021-09-21','96577106851','11987654321','teste@teste.com','1234'),(49,'Fernando KoitiTonooka','masculino','1971-12-12','15442162892','11950848128','fernandotonooka@icloud.com','EuKJ8XrzH2rwrzJ'),(51,'José Gonçalves Arimatéa',NULL,'2021-09-02','965.771.068-51','(11) 99999-8888','teste@teste.com','222222'),(52,'João da Silva','masculino','1997-03-12','246.473.438-12','(11) 99999-8888','joao@teste.com','9999');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_endereco` (
  `end_id` int(11) NOT NULL AUTO_INCREMENT,
  `tpendereco` varchar(45) DEFAULT NULL,
  `tpresidencia` varchar(45) DEFAULT NULL,
  `tplogradouro` varchar(45) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `observacoes` varchar(45) DEFAULT NULL,
  `id_cli` int(11) DEFAULT NULL,
  PRIMARY KEY (`end_id`),
  UNIQUE KEY `end_id_UNIQUE` (`end_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
INSERT INTO `tb_endereco` VALUES (7,'residencia','apartamento','rua','08717130','Rua Francisco Affonso de Melo','361','apto 22 bloco C','Parque Santana','Mogi das Cruzes','SP','brasil','Home',43),(8,'residencia','apartamento','rua','08717130','Rua Francisco Affonso de Melo','361','apto 22 bloco C','Parque Santana','Mogi das Cruzes','SP','brasil','Residencia + Entrega',44),(9,'cobranca','apartamento','rua','08717130','Rua Francisco Affonso de Melo','361','apto 22 bloco C','Parque Santana','Mogi das Cruzes','SP','brasil','CobranÃ§a',44),(10,'residencia','casa','rua','08770000','Rua Professora Norma Piccolomini de Vicente','123','casa','Jardim Santa Carolina','Mogi das Cruzes','SP','brasil','Residência',45),(11,'entrega','casa','rua','08770000','Rua Capitão Leôncio Arouche de Toledo','333','casa','Vila Avignon','Mogi das Cruzes','SP','brasil','Antigo',43),(12,'cobranca','casa','rua','08725260','Rua JoÃ£o Moro','10','casa','Conjunto Habitacional Ana Paula','Mogi das Cruzes','SP','brasil','CobranÃ§a',44),(13,'entrega','casa','rua','08725260','Rua JoÃ£o Moro','10','casa','Conjunto Habitacional Ana Paula','Mogi das Cruzes','SP','brasil','Entrega',44),(14,'cobranca','galpao','avenida','07112070','Avenida Presidente Tancredo de Almeida Neves','529','','Macedo','Guarulhos','SP','brasil','Comercial',43),(15,'residencia','apartamento','alameda','08770000','Rua Professora Norma Piccolomini de Vicente','123','','Jardim Santa Carolina','Mogi das Cruzes','SP','brasil','Home',46),(16,'cobranca','apartamento','alameda','07112080','Rua Sorocaba','2332','casa','Vila das Palmeiras','Guarulhos','SP','brasil','Trabalho',49),(17,'entrega','casa','rua','01409001','Rua Peixoto Gomide','125','','Jardim Paulista','São Paulo','SP','brasil','Casa do pai',45),(18,'entrega','apartamento','alameda','07112080','Rua Sorocaba','12','apto 112','Vila das Palmeiras','Guarulhos','SP','brasil','Principal',52);
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecommerce'
--

--
-- Dumping routines for database 'ecommerce'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-21 22:36:05
