-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 09 Tem 2013, 12:08:59
-- Sunucu sürümü: 5.6.12-log
-- PHP Sürümü: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `toplam`
--
CREATE DATABASE IF NOT EXISTS `toplam` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `toplam`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `topla`
--

CREATE TABLE IF NOT EXISTS `topla` (
  `sayi1` int(10) NOT NULL,
  `sayi2` int(10) NOT NULL,
  `sonuc` int(10) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Tablo döküm verisi `topla`
--

INSERT INTO `topla` (`sayi1`, `sayi2`, `sonuc`, `id`) VALUES
(5, 9, 0, 1),
(6298, 87, 6385, 2),
(6298, 87, 6385, 3),
(629858, 6, 629864, 4),
(6298, 8, 6306, 5),
(32, 2, 34, 6);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
