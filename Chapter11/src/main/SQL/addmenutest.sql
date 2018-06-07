# Host: 10.168.10.152  (Version 5.6.38)
# Date: 2018-06-07 17:20:12
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "addmenutest"
#

DROP TABLE IF EXISTS `addmenutest`;
CREATE TABLE `addmenutest` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `store_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `expected` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "addmenutest"
#

INSERT INTO `addmenutest` VALUES (777,'红烧狮子头',1,50,'1');
