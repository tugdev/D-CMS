-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 31 Tem 2013, 10:06:43
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
-- Tablo için tablo yapısı `kategoriler`
--

CREATE TABLE IF NOT EXISTS `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_adi` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `kat_ust_id` int(11) DEFAULT NULL,
  `aktifpasif` int(11) DEFAULT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=30 ;

--
-- Tablo döküm verisi `kategoriler`
--

INSERT INTO `kategoriler` (`kategori_id`, `kategori_adi`, `kat_ust_id`, `aktifpasif`) VALUES
(1, 'Kategoriler', 0, NULL),
(28, 'deneme', 1, NULL),
(29, 'rtfgykjl?', 28, NULL);

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
