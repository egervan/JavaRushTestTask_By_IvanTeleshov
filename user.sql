-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.7-rc-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- Дамп структуры для таблица test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` int(3) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы test.user: ~39 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `age`, `isAdmin`, `createDate`) VALUES
	(1, 'Егерь', 24, b'1', '2016-05-21 21:24:52'),
	(2, 'IvanSan', 26, b'1', '2016-05-21 13:37:46'),
	(3, 'Alexei', 30, b'0', '2016-05-20 21:59:50'),
	(4, 'Марк', 44, b'0', '2016-05-20 22:42:29'),
	(5, 'Antony', 72, b'0', '2016-05-15 23:15:49'),
	(6, 'Cesar', 48, b'0', '2016-05-15 23:15:39'),
	(7, 'Roarg', 43, b'0', '2016-05-16 21:16:49'),
	(8, 'Rollo', 42, b'0', '2016-05-16 21:15:54'),
	(9, 'Ragnar', 45, b'0', '2016-05-16 21:16:16'),
	(10, 'Ivan', 29, b'1', '2016-05-21 16:57:10'),
	(11, 'Ivan', 28, b'1', '2016-05-21 17:00:11'),
	(12, 'Alex', 20, b'0', '2016-05-18 23:22:48'),
	(13, 'Alex', 20, b'0', '2016-05-19 21:14:36'),
	(14, 'Alex', 20, b'0', '2016-05-19 21:15:07'),
	(15, 'Alex', 20, b'0', '2016-05-19 22:04:42'),
	(16, 'Alex', 20, b'0', '2016-05-19 22:05:50'),
	(17, 'Alex', 20, b'1', '2016-05-21 21:32:17'),
	(18, 'Alex', 20, b'0', '2016-05-19 22:37:16'),
	(19, 'Alex', 20, b'0', '2016-05-19 22:39:48'),
	(20, 'Alex', 20, b'0', '2016-05-19 22:41:54'),
	(21, 'Kirill', 20, b'0', '2016-05-19 22:41:54'),
	(22, 'Alex', 20, b'0', '2016-05-19 22:43:38'),
	(23, 'Kirill', 20, b'0', '2016-05-19 22:43:38'),
	(24, 'Alex', 20, b'0', '2016-05-19 22:59:31'),
	(25, 'Kirill', 20, b'0', '2016-05-19 22:59:31'),
	(26, 'Alex', 20, b'0', '2016-05-19 23:10:15'),
	(27, 'Kirill', 20, b'0', '2016-05-19 23:10:15'),
	(28, 'Alex', 20, b'0', '2016-05-19 23:12:28'),
	(29, 'Alex', 20, b'0', '2016-05-19 23:14:00'),
	(30, 'Alex', 20, b'0', '2016-05-20 01:50:44'),
	(31, 'Kirill', 20, b'0', '2016-05-20 01:50:44'),
	(32, 'Alex', 20, b'0', '2016-05-20 01:51:56'),
	(33, 'Kirill', 20, b'0', '2016-05-20 01:51:56'),
	(34, 'Alex', 20, b'0', '2016-05-20 02:05:11'),
	(35, 'Kirill', 20, b'0', '2016-05-20 02:05:11'),
	(36, 'Alex', 20, b'0', '2016-05-20 21:46:44'),
	(37, 'kira', 88, b'0', '2016-05-21 18:58:05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
