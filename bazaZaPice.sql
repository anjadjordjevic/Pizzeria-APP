/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.21-MariaDB : Database - pizzeria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pizzeria` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `pizzeria`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `AdminID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

insert  into `admin`(`AdminID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Anja','Đorđević','anja','anja');

/*Table structure for table `pizza` */

DROP TABLE IF EXISTS `pizza`;

CREATE TABLE `pizza` (
  `PizzaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `CenaPoKomadu` decimal(8,2) NOT NULL,
  `Opis` varchar(250) NOT NULL,
  `VrstaPizzeID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`PizzaID`),
  KEY `VrstaPizzeID` (`VrstaPizzeID`),
  CONSTRAINT `pizza_ibfk_1` FOREIGN KEY (`VrstaPizzeID`) REFERENCES `vrstapizze` (`VrstaPizzeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pizza` */

insert  into `pizza`(`PizzaID`,`Naziv`,`CenaPoKomadu`,`Opis`,`VrstaPizzeID`) values 
(1,'Capricciosa',250.00,'Najtraženija pica u gradu!',5),
(5,'Margarita',180.00,'Veoma ukusna!',1);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `RacunID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Vreme` datetime NOT NULL,
  `Cena` decimal(8,2) NOT NULL,
  `KolicinskiRabat` decimal(8,2) NOT NULL,
  `KonacnaCena` decimal(8,2) NOT NULL,
  `AdminID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`),
  KEY `fk_admin_id` (`AdminID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`AdminID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `racun` */

insert  into `racun`(`RacunID`,`Vreme`,`Cena`,`KolicinskiRabat`,`KonacnaCena`,`AdminID`) values 
(1,'2023-08-31 12:51:32',3000.00,10.00,2700.00,1),
(2,'2023-08-31 12:57:56',2500.00,10.00,2250.00,1);

/*Table structure for table `sastojak` */

DROP TABLE IF EXISTS `sastojak`;

CREATE TABLE `sastojak` (
  `PizzaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Rbr` int(11) NOT NULL,
  `NazivSastojka` varchar(50) NOT NULL,
  PRIMARY KEY (`PizzaID`,`Rbr`),
  CONSTRAINT `sastojak_ibfk_1` FOREIGN KEY (`PizzaID`) REFERENCES `pizza` (`PizzaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sastojak` */

insert  into `sastojak`(`PizzaID`,`Rbr`,`NazivSastojka`) values 
(1,1,'Šunka'),
(1,2,'Pelat'),
(1,3,'Pečurke'),
(1,4,'Kačkavalj'),
(1,5,'Kečap'),
(5,1,'Pečurke'),
(5,2,'Paprika'),
(5,3,'Kečap'),
(5,4,'Pelat');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `RacunID` bigint(10) unsigned NOT NULL,
  `RB` int(10) NOT NULL,
  `Kolicina` int(10) NOT NULL,
  `Cena` decimal(10,2) NOT NULL,
  `PizzaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`,`RB`),
  KEY `PizzaID` (`PizzaID`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`RacunID`) REFERENCES `racun` (`RacunID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`PizzaID`) REFERENCES `pizza` (`PizzaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`RacunID`,`RB`,`Kolicina`,`Cena`,`PizzaID`) values 
(1,1,12,3000.00,1),
(2,1,10,2500.00,1);

/*Table structure for table `vrstapizze` */

DROP TABLE IF EXISTS `vrstapizze`;

CREATE TABLE `vrstapizze` (
  `VrstaPizzeID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivVrste` varchar(50) NOT NULL,
  PRIMARY KEY (`VrstaPizzeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `vrstapizze` */

insert  into `vrstapizze`(`VrstaPizzeID`,`NazivVrste`) values 
(1,'Veganska'),
(2,'Posna'),
(3,'Proteinska'),
(4,'Keto'),
(5,'Standard');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
