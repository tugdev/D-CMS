-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 10 Tem 2013, 21:03:41
-- Sunucu sürümü: 5.5.24-log
-- PHP Sürümü: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `calis`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kaydet`
--

CREATE TABLE IF NOT EXISTS `kaydet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sayi1` float NOT NULL,
  `sayi2` float NOT NULL,
  `sonuc` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Tablo döküm verisi `kaydet`
--

INSERT INTO `kaydet` (`id`, `sayi1`, `sayi2`, `sonuc`) VALUES
(2, 7, 45, 52),
(3, 15, 45, 60),
(4, 15, 45, 60),
(5, 15, 45, 675),
(6, 15, 45, -30),
(7, 15, 45, 0.333333),
(11, 10.6, 14.82, 25.42),
(14, 1205480, 4582140, 5787620);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
