-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 04, 2015 at 11:46 PM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `CoffeeHouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `pwhash` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `email`, `pwhash`) VALUES
(14, 'ekir.gustafsson@gmail.com', '94cee9c8b3c01affdccb790fd964163'),
(15, 'q@gmail.com', '7694f4a66316e53c8cdd9d9954bd611d'),
(16, 'a1@gmail.com', '8a8bb7cd343aa2ad99b7d762030857a2'),
(17, 'qq@gmail.com', '99b3b060154898840f0ebdfb46ec78f'),
(18, '111@gmail.com', '698d51a19d8a121ce581499d7b701668'),
(19, 'qqq@gmail.com', '99b3b060154898840f0ebdfb46ec78f'),
(20, 'aqaq@gmai.com', 'f8620055d85f86dc48f18a4f9e3a488d'),
(21, 'aaqaaq@gmail.com', '56f7ee2f505e21d58f7d964794a61eb2'),
(22, '11q@gmail.com', 'c1c2ef88dd94a7a158860f5d00bfb1bc'),
(23, '1111@gmail.com', 'b59c67bf196a4758191e42f76670ceba'),
(24, 'pelle@gmail.com', '5574331fd0ffcb0a268e59f8c5a0cc5d');

-- --------------------------------------------------------

--
-- Table structure for table `guestbookmessage`
--

CREATE TABLE IF NOT EXISTS `guestbookmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customerid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=128 ;

--
-- Dumping data for table `guestbookmessage`
--

INSERT INTO `guestbookmessage` (`id`, `message`, `timestamp`, `customerid`) VALUES
(109, 'asdasd', '2015-06-04 15:57:05', 14),
(110, 'sdfasd asdqweasd', '2015-06-04 15:57:17', 14),
(111, 'asdqweasd', '2015-06-04 15:57:41', 14),
(112, 'asdasd', '2015-06-04 15:59:07', 14),
(113, 'asdqasd', '2015-06-04 16:28:24', 14),
(114, 'asdasd asd', '2015-06-04 16:28:26', 14),
(115, 'qsdasd', '2015-06-04 16:43:56', 14),
(116, 'asdqasdasd', '2015-06-04 16:44:01', 14),
(117, 'asdasdqdqwdasd', '2015-06-04 16:44:04', 14),
(118, 'asdasd qweqwe', '2015-06-04 16:44:36', 14),
(119, 'asdasdas dwqeadasd', '2015-06-04 16:44:38', 14),
(120, 'qweqwdasdasd asd sdqwe', '2015-06-04 16:44:41', 14),
(121, 'q', '2015-06-04 16:45:01', 15),
(122, 'asdasdqweqwd', '2015-06-04 16:45:15', 15),
(123, 'asdasdqweasd', '2015-06-04 16:45:17', 15),
(124, 'qwesadas', '2015-06-04 16:46:37', 15),
(125, 'adasdas asdqweasd', '2015-06-04 16:46:39', 15),
(126, 'qwea', '2015-06-04 16:59:09', 23),
(127, 'wwqeasd', '2015-06-04 18:12:39', 14);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `customer` int(11) NOT NULL,
  `product` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`customer`, `product`, `id`, `timestamp`, `status`) VALUES
(14, 1, 30, '2015-06-04 19:34:04', 0),
(14, 2, 31, '2015-06-04 19:34:08', 0),
(14, 1, 32, '2015-06-04 19:36:23', 0),
(14, 1, 33, '2015-06-04 19:37:27', 0),
(14, 1, 34, '2015-06-04 19:43:23', 1),
(14, 1, 35, '2015-06-04 19:44:34', 1),
(14, 1, 36, '2015-06-04 19:47:50', 1),
(14, 1, 37, '2015-06-04 19:57:56', 1),
(14, 1, 38, '2015-06-04 19:58:48', 1),
(14, 1, 39, '2015-06-04 20:52:44', 0),
(14, 1, 40, '2015-06-04 20:53:45', 1),
(14, 1, 41, '2015-06-04 20:55:47', 0);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `description`) VALUES
(1, 'Tea', 30, 'Good tea'),
(2, 'Coffee', 20, 'Good quality coffee');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
