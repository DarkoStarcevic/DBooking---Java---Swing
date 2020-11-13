-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2020 at 12:14 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `id_destination` int(11) NOT NULL,
  `country` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `zipcode` varchar(13) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_residence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`id_destination`, `country`, `city`, `address`, `zipcode`, `phone_number`, `email`, `id_residence`) VALUES
(1, 'Serbia', 'Kopaonik', 'Kopaonik', '36354', '+381 63 1234567', 'rtanj@rtanjkopaonik.rs', 1),
(2, 'Serbia', 'Vinci', 'Resavska br. 7', '12000', '+381 677 123456', 'bajka@serbia.rs', 2),
(3, 'France', 'Val-d\'Isère', 'Rue Principale', '73150', '+33 4 79 06 06 45', 'madame@valdisere.fr', 4),
(4, 'France', 'Val-d\'Isère', 'Route du Prariond', '73150', '+33 4 79 06 06 47', 'avancher@valdisereavanc.fr', 5),
(5, 'France', 'Val-d\'Isère', '95 Avenue Des Jeux Olympiques', '73153', '+33 4 79 06 06 456', 'hotelhubert@valdisere.fr', 6),
(6, 'Cuba', 'Havana', 'Calle O esquina 21, Vedado', '10100', '+35 15897566', 'nacionaldecuba@cuba.cu', 7),
(7, 'Uruguay', 'Montevideo', 'Grande Milovan 1146, Buceo', '11300', '+598 8799896', 'palladiumhotel@montevideo.ur', 8),
(8, 'Greece', 'Thásos', 'Skala Rachoniou, 64', '64004', '+30 98653245', 'sunshine@thasos.gr', 9),
(9, 'French Polynesia', 'Bora Bora', 'BP 547, Motu Tehotu', '98730', '+689 5468795', 'fourseasons@borabora.com', 10),
(10, 'French Polynesia', 'Bora Bora', 'Motu Piti Aau', '98730 ', '+689 4546899116', 'boranui@bora.com', 11),
(11, 'Cook Islands', 'Arutanga', 'Amuri', '000', '+682 5464849', 'pacificresort@aitutaki.nz', 12),
(12, 'Cook Islands', 'Artunaga', 'Motu Akitua', '000', '+682 6545686', 'privateisland@cook.com', 13),
(13, 'Italy', 'ldgjsoivsdfvsdfm', 'ofikdjgiosdfio1', '65161651', '+31465165', 'dsnfui@vmdkslvmkl', 2);

-- --------------------------------------------------------

--
-- Table structure for table `gps_coordinates`
--

CREATE TABLE `gps_coordinates` (
  `id_gps_coordinates` int(11) NOT NULL,
  `id_destination` int(11) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL,
  `id_usera` int(11) NOT NULL,
  `id_residence` int(11) NOT NULL,
  `id_reservation` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `type_of_payment` varchar(50) NOT NULL,
  `card_number` varchar(50) NOT NULL,
  `security_code` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id_payment`, `id_usera`, `id_residence`, `id_reservation`, `price`, `type_of_payment`, `card_number`, `security_code`) VALUES
(1, 10, 13, 2, '16860', ' Visa', '160 - 16516895165- 38', 456);

-- --------------------------------------------------------

--
-- Table structure for table `photo_album`
--

CREATE TABLE `photo_album` (
  `id_photo_album` int(11) NOT NULL,
  `id_residence` int(11) NOT NULL,
  `photo_image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photo_album`
--

INSERT INTO `photo_album` (`id_photo_album`, `id_residence`, `photo_image`) VALUES
(1, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\43498150.jpg'),
(2, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\213973397.jpg'),
(3, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\213999072.jpg'),
(4, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\43498159.jpg'),
(5, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\246317120.jpg'),
(6, 1, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Kopaonik\\246319795.jpg'),
(7, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\26336960.jpg'),
(8, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747037.jpg'),
(9, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747067.jpg'),
(10, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747085.jpg'),
(11, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747126.jpg'),
(12, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747140.jpg'),
(13, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\191069293.jpg'),
(14, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\191069913.jpg'),
(15, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\257352336.jpg'),
(16, 2, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Srbija\\Guesthouse Bajka\\189747181.jpg'),
(17, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213324871.jpg'),
(18, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213324870.jpg'),
(19, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213324840.jpg'),
(20, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213324839.jpg'),
(21, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213323049.jpg'),
(22, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213318481.jpg'),
(23, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213318468.jpg'),
(24, 4, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere\\213318464.jpg'),
(25, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165116683.jpg'),
(26, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165116663.jpg'),
(27, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165116704.jpg'),
(28, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165116720.jpg'),
(29, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165188477.jpg'),
(30, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165194928.jpg'),
(31, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\252083911.jpg'),
(32, 5, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 2\\165195245.jpg'),
(33, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\125134694.jpg'),
(34, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\124625337.jpg'),
(35, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\129964139.jpg'),
(36, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\125135386.jpg'),
(37, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere apartmant\\210592781.jpg'),
(38, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\125133235.jpg'),
(39, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\125132599.jpg'),
(40, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\124626160.jpg'),
(41, 6, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Val d Isere\\Val d Isere 4\\124625267.jpg'),
(43, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\115290029.jpg'),
(44, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\115290029.jpg'),
(45, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\114657253.jpg'),
(46, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\145211010.jpg'),
(47, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\216301783.jpg'),
(48, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\216299516.jpg'),
(49, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\216297962.jpg'),
(50, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\205409199.jpg'),
(51, 7, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Cuba\\111018062.jpg'),
(52, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\254458325.jpg'),
(53, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\203402584.jpg'),
(54, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\31136854.jpg'),
(55, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\124914732.jpg'),
(56, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\165101922.jpg'),
(57, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\254458486.jpg'),
(58, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\254460170.jpg'),
(59, 8, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Urugvaj\\43466678.jpg'),
(60, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\150326527.jpg'),
(61, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\72648328.jpg'),
(62, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\72648329.jpg'),
(63, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\72648331.jpg'),
(64, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\150326586.jpg'),
(65, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\150326588.jpg'),
(66, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\158658024.jpg'),
(67, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\158659415.jpg'),
(68, 9, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Thassos\\158658018.jpg'),
(69, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\37242591.jpg'),
(70, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\51610536.jpg'),
(71, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\51610571.jpg'),
(72, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\247806514.jpg'),
(73, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\247802941.jpg'),
(74, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\247802937.jpg'),
(75, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\247802932.jpg'),
(76, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\246878766.jpg'),
(77, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\246878763.jpg'),
(78, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\51610571.jpg'),
(79, 10, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\1\\51610543.jpg'),
(80, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\246607904.jpg'),
(81, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\246607916.jpg'),
(82, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\245099715.jpg'),
(83, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\245099715.jpg'),
(84, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\235448003.jpg'),
(85, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\235447984.jpg'),
(86, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\235447967.jpg'),
(87, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\235447901.jpg'),
(88, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\149333379.jpg'),
(89, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\93017403.jpg'),
(90, 11, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Bora Bora\\2\\149150580.jpg'),
(91, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\15886033.jpg'),
(92, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\15886058.jpg'),
(93, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\15886091.jpg'),
(94, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\253799381.jpg'),
(95, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\120753211.jpg'),
(96, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\120753207.jpg'),
(97, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\120753201.jpg'),
(98, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\120753196.jpg'),
(99, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\120275381.jpg'),
(100, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\64250475.jpg'),
(101, 12, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\1\\198587375.jpg'),
(102, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\70267053.jpg'),
(103, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\142125105.jpg'),
(104, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\142123618.jpg'),
(105, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\110009515.jpg'),
(106, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\113140615.jpg'),
(107, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\117938181.jpg'),
(108, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\142123447.jpg'),
(109, 13, 'C:\\Users\\Dare\\Desktop\\Booking Smestaj\\Aitutaki, Cook Islands\\2\\79612666.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `id_usera` int(11) NOT NULL,
  `id_residence` int(11) NOT NULL,
  `id_room` int(11) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `number_of_rooms` int(11) NOT NULL,
  `number_of_adults` int(11) NOT NULL,
  `number_of_children` int(11) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_usera`, `id_residence`, `id_room`, `check_in_date`, `check_out_date`, `number_of_rooms`, `number_of_adults`, `number_of_children`, `total_price`) VALUES
(2, 10, 13, 64, '2020-08-02', '2020-08-22', 1, 2, 1, 16860),
(3, 10, 2, 30, '2020-06-13', '2020-06-15', 1, 2, 1, 80),
(4, 14, 1, 28, '2020-12-20', '2021-01-09', 2, 4, 3, 3960),
(5, 14, 9, 52, '2020-05-19', '2020-05-29', 2, 4, 3, 1060),
(6, 14, 4, 34, '2020-06-19', '2020-06-20', 1, 1, 0, 200),
(8, 15, 1, 27, '2020-04-20', '2020-04-30', 1, 2, 1, 600),
(9, 15, 9, 52, '2020-06-10', '2020-06-20', 1, 2, 1, 530),
(10, 10, 1, 28, '2020-06-10', '2020-06-20', 1, 2, 1, 990),
(11, 12, 13, 64, '2020-05-20', '2020-05-30', 1, 2, 0, 8430),
(12, 12, 7, 45, '2020-06-18', '2020-06-19', 1, 1, 0, 95),
(13, 13, 12, 60, '2020-06-20', '2020-06-24', 1, 2, 0, 3680),
(18, 9, 5, 35, '2020-06-21', '2020-07-01', 1, 2, 0, 1000),
(21, 9, 1, 27, '2020-12-26', '2021-01-15', 1, 2, 1, 1200),
(22, 9, 10, 53, '2020-06-21', '2020-06-24', 1, 2, 1, 1500),
(23, 9, 1, 26, '2020-06-25', '2020-06-29', 1, 2, 2, 220);

-- --------------------------------------------------------

--
-- Table structure for table `residence`
--

CREATE TABLE `residence` (
  `id_residence` int(11) NOT NULL,
  `name_of_residence` varchar(50) NOT NULL,
  `type_of_residence` varchar(50) NOT NULL,
  `id_usera` int(11) NOT NULL,
  `avg_rating` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `residence`
--

INSERT INTO `residence` (`id_residence`, `name_of_residence`, `type_of_residence`, `id_usera`, `avg_rating`) VALUES
(1, 'Rtanj', 'Hotel', 3, '4.24'),
(2, 'Bajka', 'Guesthouse', 3, '4.14'),
(4, 'Madame Vacances Résidence', 'Hotel', 5, '4.57'),
(5, 'Hôtel Avancher', 'Hotel', 5, '0.00'),
(6, 'Hôtel Auberge Saint Hubert', 'Hotel', 5, '0.00'),
(7, 'Hotel Nacional de Cuba ', 'Hotel', 11, '4.29'),
(8, 'Palladium Business Hotel', 'Hotel', 19, '0.00'),
(9, 'Golden Sunset ', 'Apartment', 18, '4.79'),
(10, 'Four Seasons Resort', 'Resort', 17, '4.57'),
(11, 'Conrad Bora Bora Nui ', 'Resort', 17, '4.86'),
(12, 'Pacific Resort Aitutaki', 'Resort', 16, '0.00'),
(13, 'Aitutaki Lagoon Private Island Resort', 'Resort', 16, '5.00'),
(14, 'Marina', 'Hotel', 3, '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id_review` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_residence` int(11) NOT NULL,
  `id_reservation` int(11) NOT NULL,
  `rating` decimal(10,2) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id_review`, `id_user`, `id_residence`, `id_reservation`, `rating`, `comment`) VALUES
(1, 9, 11, 1, '4.86', 'The staff was very friendly. Food was awesome. \nStayed in King suite with Lagoon view and the view was amazing.'),
(2, 10, 2, 3, '4.14', 'Good location, close to the Danube, in a pine tree forest. Beautiful courtyard\n with a small creek and a pond, benches and hammocks. '),
(4, 14, 4, 6, '4.57', 'l’accueil du personnel ,très bon accueil et toujours disponible et à l’écoute des vacanciers.\nEtabissement calme'),
(5, 14, 9, 5, '4.57', 'Good location with private beach. Room was cleaned daily and with a nice view over the pool and the sea. \nThe sunset is amazing there.\nDisliked · Bad coffee, but I guess this is a general problem in Greece :)\n'),
(7, 15, 9, 9, '5.00', 'Beautiful hotel on a beautiful location, friendly staff, tasty breakfast,\n nice and not crowded beach, magnificent view to the sea, \nclose to the pubs, the markets and the main town.\nI do reccommend it for a long relaxing stay.'),
(12, 10, 1, 10, '4.86', 'Ljubaznost osoblja. Veoma prijatna atmosfera u hotelu.'),
(17, 12, 13, 11, '5.00', 'The location is fabulous - best in Aituatiki. \nThe view over the sparking blue waters of the lagoon is amazing. \nOur bungalow was well equipped, clean and comfortable with beautiful view. \nThe staff are very friendly and helpful, restaurant was good \nand the show on Saturday night featuring local culture was great. '),
(18, 12, 7, 12, '4.29', 'Muy bien'),
(25, 9, 1, 15, '4.86', 'Skijanje se stvarno brzo uci :::))) :D'),
(27, 14, 1, 4, '3.00', 'Monogo je hladno :D'),
(28, 9, 10, 22, '4.57', 'Super je bilo   wwwwoooooww');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id_room` int(11) NOT NULL,
  `room_type` varchar(50) NOT NULL,
  `number_of_rooms` int(150) NOT NULL,
  `number_of_beds` varchar(150) NOT NULL,
  `price_per_night` double NOT NULL,
  `room_size` int(11) NOT NULL,
  `id_residence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id_room`, `room_type`, `number_of_rooms`, `number_of_beds`, `price_per_night`, `room_size`, `id_residence`) VALUES
(26, 'Double room', 13, '2', 55, 40, 1),
(27, 'Triple room', 20, '1 double bed + 1 single bed', 60, 50, 1),
(28, 'Master Suite', 3, '2 x double bed', 99, 90, 1),
(29, 'Double room', 5, '2', 30, 30, 2),
(30, 'Triple room', 4, '3', 40, 40, 2),
(32, 'Quad room', 15, '4', 120, 60, 4),
(33, 'Junior Suite', 10, '1 king size + 2 single beds', 300, 101, 4),
(34, 'Triple room', 25, '3', 200, 70, 4),
(35, 'Double room', 22, '2', 100, 33, 5),
(36, 'Triple room', 12, '3', 150, 40, 5),
(37, 'Quad room', 13, '4', 200, 50, 5),
(39, 'Twin room', 2, '2', 100, 30, 6),
(40, 'Studio', 15, '1 king size + 2 single beds', 180, 70, 6),
(42, 'Double room', 2, '2', 100, 33, 6),
(43, 'Double-double room', 30, '2+2', 60, 60, 7),
(44, 'Master Suite', 20, '2 + 3', 120, 120, 7),
(45, 'Junior Suite', 20, '3', 95, 95, 7),
(46, 'Double room', 40, '2', 45, 35, 8),
(47, 'Triple room', 20, '3', 53, 53, 8),
(48, 'Master Suite', 3, '6', 350, 150, 8),
(49, 'Junior Suite', 5, '5', 235, 95, 8),
(51, 'Double room', 5, '2', 22, 32, 9),
(52, 'Triple room', 5, '3', 53, 53, 9),
(53, 'Beach View Over Water Bungalow Suite King Bed', 25, '1 king bed', 500, 200, 10),
(54, 'Two-Bedroom Suite Herenui', 15, '2 king beds', 800, 237, 10),
(55, 'One Bedroom Beachfront Villa with Private Pool', 5, '1 king bed', 1500, 253, 10),
(56, 'King Suite with Lagoon View', 10, 'Living room: 1 sofa bed  Bedroom 2: 1 king bed ', 779, 101, 11),
(57, 'Twin Suite with Lagoon View', 11, '2 twin beds', 779, 101, 11),
(58, 'Overwater Villa', 8, '1 king bed and 1 sofa bed', 829, 116, 11),
(59, 'Beachfront Bungalow', 15, '1 king bed', 747, 62, 12),
(60, 'Deluxe Beachfront Bungalow', 13, '1 king bed', 920, 125, 12),
(61, 'Bungalow - Beach Front ', 15, '1 king bed', 421, 60, 13),
(62, 'Deluxe Bungalow - Beach Front', 15, '1 king bed', 543, 65, 13),
(63, 'Honeymoon Villa with private pool', 7, '1 king bed + 1 queen bed', 694, 175, 13),
(64, 'Overwater Bungalow', 9, '1 king bed', 843, 70, 13),
(65, 'Junior Suite', 5, 'jgsdfjio', 30, 30, 2);

-- --------------------------------------------------------

--
-- Table structure for table `room_info`
--

CREATE TABLE `room_info` (
  `id_room_info` int(11) NOT NULL,
  `AC` tinyint(1) NOT NULL,
  `WIFI` tinyint(1) NOT NULL,
  `balcony` tinyint(1) NOT NULL,
  `TV` tinyint(1) NOT NULL,
  `kitchen` tinyint(1) NOT NULL,
  `private_bathroom` tinyint(1) NOT NULL,
  `parking` tinyint(1) NOT NULL,
  `restaurant` tinyint(1) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `id_room` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room_info`
--

INSERT INTO `room_info` (`id_room_info`, `AC`, `WIFI`, `balcony`, `TV`, `kitchen`, `private_bathroom`, `parking`, `restaurant`, `description`, `id_room`) VALUES
(2, 1, 1, 1, 1, 1, 1, 1, 1, 'Located in Kopaonik, 1.8 km from Kopaonik SKI Resort, Rtanj Kopaonik has accommodations with a restaurant, free private parking, free bikes and a bar. The property provides ski-to-door access and a ski pass sales point, as well as a shared lounge and a garden. Free WiFi and a 24-hour front desk are available.\nAt the hotel all rooms include a closet, a flat-screen TV and a private bathroom.\nRtanj Kopaonik offers a continental or buffet breakfast.\nThe accommodation has a terrace. Ski equipment rental and bike rental are available at Rtanj Kopaonik and the area is popular for hiking and skiing.\n', 26),
(3, 1, 1, 1, 1, 1, 1, 1, 1, 'Located in Kopaonik, 1.8 km from Kopaonik SKI Resort, Rtanj Kopaonik has accommodations with a restaurant, free private parking, free bikes and a bar. The property provides ski-to-door access and a ski pass sales point, as well as a shared lounge and a garden. Free WiFi and a 24-hour front desk are available.\nAt the hotel all rooms include a closet, a flat-screen TV and a private bathroom.\nRtanj Kopaonik offers a continental or buffet breakfast.\nThe accommodation has a terrace. Ski equipment rental and bike rental are available at Rtanj Kopaonik and the area is popular for hiking and skiing.\n', 27),
(4, 1, 1, 1, 1, 1, 1, 1, 1, 'Located in Kopaonik, 1.8 km from Kopaonik SKI Resort, Rtanj Kopaonik has accommodations with a restaurant, free private parking, free bikes and a bar. The property provides ski-to-door access and a ski pass sales point, as well as a shared lounge and a garden. Free WiFi and a 24-hour front desk are available.\nAt the hotel all rooms include a closet, a flat-screen TV and a private bathroom.\nRtanj Kopaonik offers a continental or buffet breakfast.\nThe accommodation has a terrace. Ski equipment rental and bike rental are available at Rtanj Kopaonik and the area is popular for hiking and skiing.\n', 28),
(5, 0, 1, 1, 0, 1, 1, 1, 0, 'Located in Vinci, 100 m from the Danube River, Guest house Bajka is surrounded with a pine forest and offers simply furnished rooms. Free parking is available on site.\r\nAll rooms here will provide you with a balcony. Featuring a shower, private bathrooms also come with a hairdryer and towels. At Guest house Bajka you will find a garden and a shared kitchen.\r\nA grocery shop and a restaurant can be found 100 m away. The town\'s marketplace is located at a distance of 100 m.\r\nSwimming can be enjoyed on a beach 100 m from the property. An array of activities can be enjoyed on site or in the surroundings, including darts and cycling. Fishing is very popular in these parts and a fishing permit can be obtained in the town of Golubac, 5.6 mi away.\r\n', 29),
(6, 0, 1, 1, 0, 1, 1, 1, 0, 'Located in Vinci, 100 m from the Danube River, Guest house Bajka is surrounded with a pine forest and offers simply furnished rooms. Free parking is available on site.\nAll rooms here will provide you with a balcony. Featuring a shower, private bathrooms also come with a hairdryer and towels. At Guest house Bajka you will find a garden and a shared kitchen.\nA grocery shop and a restaurant can be found 100 m away. The town\'s marketplace is located at a distance of 100 m.\nSwimming can be enjoyed on a beach 100 m from the property. An array of activities can be enjoyed on site or in the surroundings, including darts and cycling. Fishing is very popular in these parts and a fishing permit can be obtained in the town of Golubac, 5.6 mi away.\n', 30),
(7, 1, 1, 0, 1, 0, 1, 1, 1, 'Alpina Lodge apartments are located in Val-d’Isère city center. The Espace Killy ski slopes and ski elevators are just 300 m away.\nThe apartments are decorated in a chalet style. All apartments feature a balcony providing mountain views.\nYou can prepare meals in the kitchen equipped with a dishwasher, refrigerator, and stove with an oven. \nBreakfast can be served upon request. Mid-stay cleaning is available for a supplement and upon request.\nThe Borg Saint-Maurice TGV train station is 19 mi away. All of the Alpina Lodge apartments have access to Val-d’Isère ski facilities.\n', 34),
(8, 1, 1, 1, 1, 1, 1, 1, 1, 'Alpina Lodge apartments are located in Val-d’Isère city center. The Espace Killy ski slopes and ski elevators are just 300 m away.\nThe apartments are decorated in a chalet style. All apartments feature a balcony providing mountain views.\nYou can prepare meals in the kitchen equipped with a dishwasher, refrigerator, and stove with an oven. \nBreakfast can be served upon request. Mid-stay cleaning is available for a supplement and upon request.\nThe Borg Saint-Maurice TGV train station is 19 mi away. All of the Alpina Lodge apartments have access to Val-d’Isère ski facilities.\n', 33),
(9, 1, 1, 1, 1, 1, 1, 1, 1, 'Alpina Lodge apartments are located in Val-d’Isère city center. The Espace Killy ski slopes and ski elevators are just 300 m away.\nThe apartments are decorated in a chalet style. All apartments feature a balcony providing mountain views.\nYou can prepare meals in the kitchen equipped with a dishwasher, refrigerator, and stove with an oven. \nBreakfast can be served upon request. Mid-stay cleaning is available for a supplement and upon request.\nThe Borg Saint-Maurice TGV train station is 19 mi away. All of the Alpina Lodge apartments have access to Val-d’Isère ski facilities.\n', 32),
(10, 1, 1, 1, 1, 0, 1, 1, 1, 'This chalet-style hotel is decorated in a characteristic Alpine style and is located in Val d’Isère, \na 5-minute walk from the ski station and 50 m from the free ski shuttle bus. The rooms have flat-screen TVs and free Wi-Fi internet access.\nEach guest room at the Hôtel Avancher also has a private bathroom.\nA buffet breakfast is offered each morning and guests can sample traditional \nSavoyard specialties in the restaurant, which prepares its meals with fresh, local produce. \nThe bar offers a large selection of wine.\nGuests are also invited to relax with a cocktail in the lounge,\nwhich has a piano and a selection of games or in the sauna.', 35),
(11, 1, 1, 1, 1, 0, 1, 1, 1, 'This chalet-style hotel is decorated in a characteristic Alpine style and is located in Val d’Isère, \na 5-minute walk from the ski station and 50 m from the free ski shuttle bus. The rooms have flat-screen TVs and free Wi-Fi internet access.\nEach guest room at the Hôtel Avancher also has a private bathroom.\nA buffet breakfast is offered each morning and guests can sample traditional \nSavoyard specialties in the restaurant, which prepares its meals with fresh, local produce. \nThe bar offers a large selection of wine.\nGuests are also invited to relax with a cocktail in the lounge,\nwhich has a piano and a selection of games or in the sauna.', 36),
(12, 1, 1, 1, 1, 1, 1, 1, 1, 'This chalet-style hotel is decorated in a characteristic Alpine style and is located in Val d’Isère, \na 5-minute walk from the ski station and 50 m from the free ski shuttle bus. The rooms have flat-screen TVs and free Wi-Fi internet access.\nEach guest room at the Hôtel Avancher also has a private bathroom.\nA buffet breakfast is offered each morning and guests can sample traditional \nSavoyard specialties in the restaurant, which prepares its meals with fresh, local produce. \nThe bar offers a large selection of wine.\nGuests are also invited to relax with a cocktail in the lounge,\nwhich has a piano and a selection of games or in the sauna.', 37),
(14, 1, 1, 1, 1, 0, 1, 1, 1, 'Hôtel Auberge Saint Hubert is located in the heart of Val d’Isere, just 150 m from the slopes and ski elevators.\nIt features comfortable accommodations with a sauna. Guests can enjoy a welcome drink on the first evening, and hot beverages and pastries are offered each day after your ski session.\nFree WiFi is offered throughout the property.\nGuest rooms are decorated in a traditional chalet style.\nThey include a private bathroom and satellite TV.\nMany rooms have a balcony with views of the village or the mountains.\nThe hotel restaurant serves regional Savoy dishes and Thai dishes. \nGuests can enjoy a drink in the tea room or bar. \nThe bar and restaurant have fireplaces.\n', 42),
(15, 1, 1, 1, 1, 1, 1, 1, 1, 'Hôtel Auberge Saint Hubert is located in the heart of Val d’Isere, just 150 m from the slopes and ski elevators.\nIt features comfortable accommodations with a sauna. Guests can enjoy a welcome drink on the first evening, and hot beverages and pastries are offered each day after your ski session.\nFree WiFi is offered throughout the property.\nGuest rooms are decorated in a traditional chalet style.\nThey include a private bathroom and satellite TV.\nMany rooms have a balcony with views of the village or the mountains.\nThe hotel restaurant serves regional Savoy dishes and Thai dishes. \nGuests can enjoy a drink in the tea room or bar. \nThe bar and restaurant have fireplaces.\n', 40),
(16, 1, 1, 1, 1, 0, 1, 1, 1, 'Hôtel Auberge Saint Hubert is located in the heart of Val d’Isere, just 150 m from the slopes and ski elevators.\nIt features comfortable accommodations with a sauna. Guests can enjoy a welcome drink on the first evening, and hot beverages and pastries are offered each day after your ski session.\nFree WiFi is offered throughout the property.\nGuest rooms are decorated in a traditional chalet style.\nThey include a private bathroom and satellite TV.\nMany rooms have a balcony with views of the village or the mountains.\nThe hotel restaurant serves regional Savoy dishes and Thai dishes. \nGuests can enjoy a drink in the tea room or bar. \nThe bar and restaurant have fireplaces.\n', 39),
(17, 1, 1, 1, 1, 0, 1, 1, 1, 'Located 1.6 mi from Castillo de San Salvador de la Punta in Havana,\nHotel Nacional de Cuba welcomes guests with a restaurant and bar.\nYou will find a 24-hour front desk at the property.\nLa Bodeguita del Medio is 1.9 mi from Hotel Nacional de Cuba, while Old Square is 2.1 mi away. \nJosé Martí International Airport is 9.9 mi from the property.', 43),
(18, 1, 1, 1, 1, 1, 1, 1, 1, 'Located 1.6 mi from Castillo de San Salvador de la Punta in Havana,\nHotel Nacional de Cuba welcomes guests with a restaurant and bar.\nYou will find a 24-hour front desk at the property.\nLa Bodeguita del Medio is 1.9 mi from Hotel Nacional de Cuba, while Old Square is 2.1 mi away. \nJosé Martí International Airport is 9.9 mi from the property.', 44),
(19, 1, 1, 1, 1, 1, 1, 1, 1, 'Located 1.6 mi from Castillo de San Salvador de la Punta in Havana,\nHotel Nacional de Cuba welcomes guests with a restaurant and bar.\nYou will find a 24-hour front desk at the property.\nLa Bodeguita del Medio is 1.9 mi from Hotel Nacional de Cuba, while Old Square is 2.1 mi away. \nJosé Martí International Airport is 9.9 mi from the property.', 45),
(20, 1, 1, 1, 1, 0, 1, 1, 1, 'This 4-star hotel in Montevideo is located near the new Zona Franca \nand offers a rooftop terrace with city views. Free Wi-Fi is available. \nCarrasco International Airport is a 15-minute drive away.\nRooms at the Palladium Business Hotel have classical-style furnishings \nand include a cable TV, mini-bar and an private bathroom. \nThe Corner Suites have a hydromassage tub and a spacious work desk.\nGuests can go for a swim in the outdoor swimming pool, or work out in the well-equipped gym.\nLaundry, dry cleaning and ironing services can be arranged for an extra fee.\n', 46),
(21, 1, 1, 1, 1, 0, 1, 1, 1, 'This 4-star hotel in Montevideo is located near the new Zona Franca \nand offers a rooftop terrace with city views. Free Wi-Fi is available. \nCarrasco International Airport is a 15-minute drive away.\nRooms at the Palladium Business Hotel have classical-style furnishings \nand include a cable TV, mini-bar and an private bathroom. \nThe Corner Suites have a hydromassage tub and a spacious work desk.\nGuests can go for a swim in the outdoor swimming pool, or work out in the well-equipped gym.\nLaundry, dry cleaning and ironing services can be arranged for an extra fee.\n', 47),
(22, 1, 1, 1, 1, 1, 1, 1, 1, 'This 4-star hotel in Montevideo is located near the new Zona Franca \nand offers a rooftop terrace with city views. Free Wi-Fi is available. \nCarrasco International Airport is a 15-minute drive away.\nRooms at the Palladium Business Hotel have classical-style furnishings \nand include a cable TV, mini-bar and an private bathroom. \nThe Corner Suites have a hydromassage tub and a spacious work desk.\nGuests can go for a swim in the outdoor swimming pool, or work out in the well-equipped gym.\nLaundry, dry cleaning and ironing services can be arranged for an extra fee.\n', 48),
(23, 1, 1, 1, 1, 1, 1, 1, 1, 'This 4-star hotel in Montevideo is located near the new Zona Franca \nand offers a rooftop terrace with city views. Free Wi-Fi is available. \nCarrasco International Airport is a 15-minute drive away.\nRooms at the Palladium Business Hotel have classical-style furnishings \nand include a cable TV, mini-bar and an private bathroom. \nThe Corner Suites have a hydromassage tub and a spacious work desk.\nGuests can go for a swim in the outdoor swimming pool, or work out in the well-equipped gym.\nLaundry, dry cleaning and ironing services can be arranged for an extra fee.\n', 49),
(24, 1, 1, 1, 1, 1, 1, 1, 0, 'Golden Sunset in Skala Rachoniou features a private beach area, a seasonal outdoor swimming pool and a shared lounge. The property has a bar, as well as a restaurant serving Greek cuisine. Both free WiFi and private parking are available at the hotel.\nAt Golden Sunset, rooms include a wardrobe and a flat-screen TV. \nThe accommodations offers some rooms that have a terrace, and all rooms are equipped with a private bathroom with a shower and a hair dryer. All rooms will provide guests with a fridge.\nBreakfast is available every morning, and includes continental and American options.\n', 51),
(25, 1, 1, 1, 1, 0, 1, 1, 0, 'Golden Sunset in Skala Rachoniou features a private beach area, a seasonal outdoor swimming pool and a shared lounge. The property has a bar, as well as a restaurant serving Greek cuisine. Both free WiFi and private parking are available at the hotel.\nAt Golden Sunset, rooms include a wardrobe and a flat-screen TV. \nThe accommodations offers some rooms that have a terrace, and all rooms are equipped with a private bathroom with a shower and a hair dryer. All rooms will provide guests with a fridge.\nBreakfast is available every morning, and includes continental and American options.\n', 52),
(26, 1, 1, 1, 1, 1, 1, 1, 1, 'Overlooking the magnificent turquoise waters of a private beach, the Four Seasons Resort Bora Bora features luxurious over-water bungalows and beachfront villas with views of Mount Otemanu. \nAfter an invigorating workout in the open-air fitness center, you can enjoy an afternoon of pampering at the waterfront day spa.\nThe Four Seasons Resort is on Point Matira in Bora Bora, which was voted ‘the best island in the world’ by U.S. News in 2012. \nMotu Mute Airport is a 15-minute boat ride away.\nThe resort features an infinity pool, a tennis court and free guided snorkeling tours of the lagoon sanctuary, which is home to many exotic marine animals.\n Guests can also enjoy kayaking, catamaran cruises, windsurfing and shark feeding.\n', 53),
(27, 1, 1, 1, 1, 1, 1, 1, 1, 'Overlooking the magnificent turquoise waters of a private beach, the Four Seasons Resort Bora Bora features luxurious over-water bungalows and beachfront villas with views of Mount Otemanu. After an invigorating workout in the open-air fitness center, you can enjoy an afternoon of pampering at the waterfront day spa.\nThe Four Seasons Resort is on Point Matira in Bora Bora, which was voted ‘the best island in the world’ by U.S. News in 2012. Motu Mute Airport is a 15-minute boat ride away.\nThe resort features an infinity pool, a tennis court and free guided snorkeling tours of the lagoon sanctuary, which is home to many exotic marine animals. Guests can also enjoy kayaking, catamaran cruises, windsurfing and shark feeding.\n', 54),
(28, 1, 1, 1, 1, 1, 1, 1, 1, 'Overlooking the magnificent turquoise waters of a private beach, the Four Seasons Resort Bora Bora features luxurious over-water bungalows and beachfront villas with views of Mount Otemanu. After an invigorating workout in the open-air fitness center, you can enjoy an afternoon of pampering at the waterfront day spa.\nThe Four Seasons Resort is on Point Matira in Bora Bora, which was voted ‘the best island in the world’ by U.S. News in 2012. Motu Mute Airport is a 15-minute boat ride away.\nThe resort features an infinity pool, a tennis court and free guided snorkeling tours of the lagoon sanctuary, which is home to many exotic marine animals. Guests can also enjoy kayaking, catamaran cruises, windsurfing and shark feeding.\n', 55),
(29, 1, 1, 1, 1, 0, 1, 1, 1, 'Exclusively located in a private cove on Motu To’opua, Conrad Bora Bora Nui enjoys vast blue ocean views and a white sand beach. \nThe property features luxurious villas floating on the turquoise waters of the lagoon and perched on the tropical hillside. Guests can enjoy a swim in the infinity pool, feel pampered with a treatment at the day spa or sample fine cuisine at 4 restaurants.\nThe air-conditioned renovated villas feature wooden floors and an elegant marble bathroom. Each includes a spacious lounge area with flat-screen cable TV.\nA customizable pillow menu, walk-in closet with a vanity desk and a selection of complimentary beverages are provided. Some villas offer private infinity plunge pools and catamaran-like nets offering ocean views\nThe resort offers 3 bars, a kids club, a hilltop spa and fitness center. Free WiFi is available throughout the property.\n', 56),
(30, 1, 1, 1, 1, 0, 1, 1, 1, 'Exclusively located in a private cove on Motu To’opua, Conrad Bora Bora Nui enjoys vast blue ocean views and a white sand beach. The property features luxurious villas floating on the turquoise waters of the lagoon and perched on the tropical hillside. Guests can enjoy a swim in the infinity pool, feel pampered with a treatment at the day spa or sample fine cuisine at 4 restaurants.\nThe air-conditioned renovated villas feature wooden floors and an elegant marble bathroom. Each includes a spacious lounge area with flat-screen cable TV. A customizable pillow menu, walk-in closet with a vanity desk and a selection of complimentary beverages are provided. Some villas offer private infinity plunge pools and catamaran-like nets offering ocean views\nThe resort offers 3 bars, a kids club, a hilltop spa and fitness center. Free WiFi is available throughout the property.\n', 57),
(31, 1, 1, 1, 1, 1, 1, 1, 1, 'Exclusively located in a private cove on Motu To’opua, Conrad Bora Bora Nui enjoys vast blue ocean views and a white sand beach. The property features luxurious villas floating on the turquoise waters of the lagoon and perched on the tropical hillside. Guests can enjoy a swim in the infinity pool, feel pampered with a treatment at the day spa or sample fine cuisine at 4 restaurants.\nThe air-conditioned renovated villas feature wooden floors and an elegant marble bathroom. Each includes a spacious lounge area with flat-screen cable TV. A customizable pillow menu, walk-in closet with a vanity desk and a selection of complimentary beverages are provided. Some villas offer private infinity plunge pools and catamaran-like nets offering ocean views\nThe resort offers 3 bars, a kids club, a hilltop spa and fitness center. Free WiFi is available throughout the property.\n', 58),
(32, 1, 1, 1, 1, 1, 1, 1, 1, 'Pacific Resort Aitutaki is a luxury 5-star resort on the island of Aitutaki. This hideaway resort offers private beachfront accommodations, beautiful lagoon views and great spa facilities.\nChoose between the spacious beachfront bungalows or villas. All of the accommodations includes a private sun deck and beach shower overlooking the lagoon. The larger villas also offer a private garden bathroom.\nA full a la carte breakfast is included in the room rate daily, which includes fresh tropical fruit. Guests can enjoy Pacific influenced cuisine in the hotel’s lagoon view restaurant or simply chill out at the beachfront bar. The resort also offers a Polynesian themed buffet evening with live entertainment.\n', 60),
(33, 1, 1, 1, 1, 1, 1, 1, 1, 'Pacific Resort Aitutaki is a luxury 5-star resort on the island of Aitutaki. This hideaway resort offers private beachfront accommodations, beautiful lagoon views and great spa facilities.\nChoose between the spacious beachfront bungalows or villas. All of the accommodations includes a private sun deck and beach shower overlooking the lagoon. The larger villas also offer a private garden bathroom.\nA full a la carte breakfast is included in the room rate daily, which includes fresh tropical fruit. Guests can enjoy Pacific influenced cuisine in the hotel’s lagoon view restaurant or simply chill out at the beachfront bar. The resort also offers a Polynesian themed buffet evening with live entertainment.\n', 59),
(34, 1, 1, 1, 1, 1, 1, 1, 1, 'Located on its own private island, this luxury resort offers beach-front and over-water bungalows with panoramic views of Aitutaki Lagoon. Facilities include a restaurant, bar, day spa and beachfront pool.\nEach bungalow is air-conditioned and features satellite TV, DVD player, refrigerator and a veranda with sun loungers. Bungalows with open-air showers and direct access to the lagoon are available.\nContinental breakfast is included each morning, with fresh fruits, baked pastries, cereals, juice, tea and coffee. Guests at Aitutaki Lagoon Private Island Resort (Adults Only) enjoy free standup paddle boarding, kayaking, canoeing, snorkeling and cultural activities.\nFlying Boat Beach Bar & Grill features views over Sunset Beach. Bounty Brasserie offers seafood platters or a tasting menu with matching wines. The day spa offers massages, a sauna and a hot tub.\nThe Aitutaki Lagoon Private Island Resort (Adults Only) is a 2-minute ride by small private ferry from the main island of Aitutaki. Rarotonga Airport is a 45-minute flight from Aitutaki.\n', 61),
(35, 1, 1, 1, 1, 1, 1, 1, 1, 'Located on its own private island, this luxury resort offers beach-front and over-water bungalows with panoramic views of Aitutaki Lagoon. Facilities include a restaurant, bar, day spa and beachfront pool.\nEach bungalow is air-conditioned and features satellite TV, DVD player, refrigerator and a veranda with sun loungers. Bungalows with open-air showers and direct access to the lagoon are available.\nContinental breakfast is included each morning, with fresh fruits, baked pastries, cereals, juice, tea and coffee. Guests at Aitutaki Lagoon Private Island Resort (Adults Only) enjoy free standup paddle boarding, kayaking, canoeing, snorkeling and cultural activities.\nFlying Boat Beach Bar & Grill features views over Sunset Beach. Bounty Brasserie offers seafood platters or a tasting menu with matching wines. The day spa offers massages, a sauna and a hot tub.\nThe Aitutaki Lagoon Private Island Resort (Adults Only) is a 2-minute ride by small private ferry from the main island of Aitutaki. Rarotonga Airport is a 45-minute flight from Aitutaki.\n', 62),
(36, 1, 1, 1, 1, 1, 1, 1, 1, 'Located on its own private island, this luxury resort offers beach-front and over-water bungalows with panoramic views of Aitutaki Lagoon. Facilities include a restaurant, bar, day spa and beachfront pool.\nEach bungalow is air-conditioned and features satellite TV, DVD player, refrigerator and a veranda with sun loungers. Bungalows with open-air showers and direct access to the lagoon are available.\nContinental breakfast is included each morning, with fresh fruits, baked pastries, cereals, juice, tea and coffee. Guests at Aitutaki Lagoon Private Island Resort (Adults Only) enjoy free standup paddle boarding, kayaking, canoeing, snorkeling and cultural activities.\nFlying Boat Beach Bar & Grill features views over Sunset Beach. Bounty Brasserie offers seafood platters or a tasting menu with matching wines. The day spa offers massages, a sauna and a hot tub.\nThe Aitutaki Lagoon Private Island Resort (Adults Only) is a 2-minute ride by small private ferry from the main island of Aitutaki. Rarotonga Airport is a 45-minute flight from Aitutaki.\n', 63),
(37, 1, 1, 1, 1, 1, 1, 1, 1, 'Located on its own private island, this luxury resort offers beach-front and over-water bungalows with panoramic views of Aitutaki Lagoon. Facilities include a restaurant, bar, day spa and beachfront pool.\nEach bungalow is air-conditioned and features satellite TV, DVD player, refrigerator and a veranda with sun loungers. Bungalows with open-air showers and direct access to the lagoon are available.\nContinental breakfast is included each morning, with fresh fruits, baked pastries, cereals, juice, tea and coffee. Guests at Aitutaki Lagoon Private Island Resort (Adults Only) enjoy free standup paddle boarding, kayaking, canoeing, snorkeling and cultural activities.\nFlying Boat Beach Bar & Grill features views over Sunset Beach. Bounty Brasserie offers seafood platters or a tasting menu with matching wines. The day spa offers massages, a sauna and a hot tub.\nThe Aitutaki Lagoon Private Island Resort (Adults Only) is a 2-minute ride by small private ferry from the main island of Aitutaki. Rarotonga Airport is a 45-minute flight from Aitutaki.\n', 64);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_usera` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_usera`, `username`, `password`, `email`, `first_name`, `last_name`, `phone_number`, `status`) VALUES
(1, 'super', '111', 'super@gmail.com', 'COM_TRADE', 'CODE', '123456789', 'superAdmin'),
(3, 'dare', '111', 'dbookingtestsend@gmail.com', 'Darko', 'Starcevic', '2703007', 'owner'),
(5, 'darkoni', '111', 'darkoni@gmail.com', 'dare', 'dax', '123456', 'owner'),
(9, 'Darko', '123', 'dax@dax.com', 'Darko', 'Starcevic ', '0638209885', 'user'),
(10, 'Djoksi', '123', 'djoksi@gmail.com', 'Djordje', 'Starcevic', '0638209885', 'user'),
(11, 'Junior', '111', 'rike@gmail.com', 'Junior', 'Rosa', '+53 12345678', 'owner'),
(12, 'Dejan', '123', 'bogi89@gmail.com', 'Dejan', 'Bogicevic', '+381641324567', 'user'),
(13, 'Marina', '123', 'marina@code.rs', 'Marina', 'Markovic', '+381 631239878', 'user'),
(14, 'Mladen', '123', 'mladen@gmail.com', 'Mladen', 'Lazic', '+381699876543', 'user'),
(15, 'Masa', '123', 'masa@gmail.com', 'Masa ', 'Lazic', '+381651236547', 'user'),
(16, 'Casey', '111', 'casey@motgp.com', 'Casey', 'Stoner', '+682 3214568', 'owner'),
(17, 'Bora', '111', 'bora@borabora.com', 'Maimiti', 'Rai', '+689 6547891', 'owner'),
(18, 'Apollonia', '111', 'apolon@gmail.com', 'Apollonia', 'Angelos', '+30 654321897', 'owner'),
(19, 'Lucas', '111', 'lucas@gmail.com', 'Lucas', 'Martinez', '+598 357951223', 'owner');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`id_destination`),
  ADD KEY `destination_ibfk_1` (`id_residence`);

--
-- Indexes for table `gps_coordinates`
--
ALTER TABLE `gps_coordinates`
  ADD PRIMARY KEY (`id_gps_coordinates`),
  ADD KEY `id_destination` (`id_destination`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id_payment`),
  ADD KEY `id_residence` (`id_residence`),
  ADD KEY `id_usera` (`id_usera`),
  ADD KEY `payment_ibfk_1` (`id_reservation`);

--
-- Indexes for table `photo_album`
--
ALTER TABLE `photo_album`
  ADD PRIMARY KEY (`id_photo_album`),
  ADD KEY `photo_album_ibfk_1` (`id_residence`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `id_room` (`id_room`),
  ADD KEY `id_usera` (`id_usera`),
  ADD KEY `id_residence` (`id_residence`);

--
-- Indexes for table `residence`
--
ALTER TABLE `residence`
  ADD PRIMARY KEY (`id_residence`),
  ADD KEY `id_usera` (`id_usera`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id_review`),
  ADD KEY `reviews_ibfk_1` (`id_user`),
  ADD KEY `reviews_ibfk_2` (`id_residence`),
  ADD KEY `reviews_ibfk_3` (`id_reservation`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id_room`),
  ADD KEY `room_ibfk_1` (`id_residence`);

--
-- Indexes for table `room_info`
--
ALTER TABLE `room_info`
  ADD PRIMARY KEY (`id_room_info`),
  ADD KEY `room_info_ibfk_1` (`id_room`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_usera`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `destination`
--
ALTER TABLE `destination`
  MODIFY `id_destination` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `gps_coordinates`
--
ALTER TABLE `gps_coordinates`
  MODIFY `id_gps_coordinates` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id_payment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `photo_album`
--
ALTER TABLE `photo_album`
  MODIFY `id_photo_album` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `residence`
--
ALTER TABLE `residence`
  MODIFY `id_residence` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id_review` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id_room` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `room_info`
--
ALTER TABLE `room_info`
  MODIFY `id_room_info` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_usera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `destination`
--
ALTER TABLE `destination`
  ADD CONSTRAINT `destination_ibfk_1` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`) ON DELETE CASCADE;

--
-- Constraints for table `gps_coordinates`
--
ALTER TABLE `gps_coordinates`
  ADD CONSTRAINT `gps_coordinates_ibfk_1` FOREIGN KEY (`id_destination`) REFERENCES `destination` (`id_destination`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`id_reservation`) REFERENCES `reservation` (`id_reservation`) ON DELETE CASCADE,
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`),
  ADD CONSTRAINT `payment_ibfk_3` FOREIGN KEY (`id_usera`) REFERENCES `user` (`id_usera`);

--
-- Constraints for table `photo_album`
--
ALTER TABLE `photo_album`
  ADD CONSTRAINT `photo_album_ibfk_1` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`) ON DELETE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_room`) REFERENCES `room` (`id_room`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_usera`) REFERENCES `user` (`id_usera`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`);

--
-- Constraints for table `residence`
--
ALTER TABLE `residence`
  ADD CONSTRAINT `residence_ibfk_1` FOREIGN KEY (`id_usera`) REFERENCES `user` (`id_usera`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_usera`),
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`),
  ADD CONSTRAINT `reviews_ibfk_3` FOREIGN KEY (`id_reservation`) REFERENCES `reservation` (`id_reservation`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`id_residence`) REFERENCES `residence` (`id_residence`) ON DELETE CASCADE;

--
-- Constraints for table `room_info`
--
ALTER TABLE `room_info`
  ADD CONSTRAINT `room_info_ibfk_1` FOREIGN KEY (`id_room`) REFERENCES `room` (`id_room`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
