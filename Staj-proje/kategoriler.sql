-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 26 Ağu 2013, 14:54:51
-- Sunucu sürümü: 5.6.12-log
-- PHP Sürümü: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `kategoriler`
--
CREATE DATABASE IF NOT EXISTS `kategoriler` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kategoriler`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `aktif`
--

CREATE TABLE IF NOT EXISTS `aktif` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `k_ad` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `dialog`
--

CREATE TABLE IF NOT EXISTS `dialog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `akpa` int(11) DEFAULT NULL,
  `k_ad` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kategoriler`
--

CREATE TABLE IF NOT EXISTS `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `aktifpasif` int(11) DEFAULT NULL,
  `kat_ust_id` int(11) DEFAULT NULL,
  `kategori_adi` varchar(255) NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Tablo döküm verisi `kategoriler`
--

INSERT INTO `kategoriler` (`kategori_id`, `aktifpasif`, `kat_ust_id`, `kategori_adi`) VALUES
(1, NULL, 0, 'Kategoriler'),
(2, NULL, 1, 'java'),
(3, NULL, 1, 'tugdev'),
(4, NULL, 1, 'c#'),
(5, NULL, 1, 'ruby'),
(6, NULL, 5, 'elma'),
(7, NULL, 2, 'cehars'),
(8, NULL, 5, '&lt;bxdh'),
(9, NULL, 1, 'f?k'),
(10, NULL, 7, 'java2'),
(11, NULL, 1, 'dersler');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE IF NOT EXISTS `kullanici` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ad` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `sifre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`id`, `ad`, `rol`, `sifre`) VALUES
(1, 'tugba', 'user', 'f6b0a866bde16bad5b64ddef72208b14'),
(2, 'tugdev', 'admin', '552bf364f7b6647d1820cc8113f3beef');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `makale`
--

CREATE TABLE IF NOT EXISTS `makale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baslik` varchar(255) DEFAULT NULL,
  `icerik` longblob,
  `yazar` varchar(255) DEFAULT NULL,
  `tarih` date DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- Tablo döküm verisi `makale`
--

INSERT INTO `makale` (`id`, `baslik`, `icerik`, `yazar`, `tarih`, `kategori`) VALUES
(39, 'baslik', 0x73646667686a6b, 'yazar', '2013-08-17', '10'),
(40, 'son', 0x696e3f616c6c6168206275206b657a206f6c7572, 'tugdev', '2013-08-30', '11');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pasif`
--

CREATE TABLE IF NOT EXISTS `pasif` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `k_ad` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
