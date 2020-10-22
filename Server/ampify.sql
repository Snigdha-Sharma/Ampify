-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2020 at 10:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ampify`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Uname` varchar(20) NOT NULL,
  `Passwd` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Uname`, `Passwd`) VALUES
('aB@#23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('abcdefg', 'phOyuWRqtrr9xP3DroUxgQHnJWbPNHdsCqxJmrcpx2w='),
('alPha@23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('amcnN@#@!23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('bAS@#23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('divyasri', 'ESSpZsvTADsA1BifvkobtcQuCAre6SDYIQCcZOtAo7Y='),
('dlksdklsK@2323', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('gautam.purva', 'gautam.purva'),
('Ksh@121', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Ksh@123', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Ksh@1234', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Ksh@123423', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Ksh@12345', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('KsHiS@2', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('kshitij', '8902340934'),
('Kshk@!23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('ljsakJ@32', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('lkjhAS@#234', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('lkjhAS@#23466', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('lkjhAS@#23489', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('maNK@21223', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('purvag15', 'pgpg'),
('rishabh', 'VTNGyc+ZtL7fQjsuzE/p9eg40CdlrrlbX4r6kL8wmaM='),
('saloni', 'zE8wdBA5XZ+jqX5PwqdoMh9gHSVqEGVsiJs+pOpXQEw='),
('sijakK@#23', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('skdK2@', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('snigdha', 'vXOAs9vj76icfhaiR28vgFitrofIxC/LhE4jrHekzA0='),
('Syn@2k', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Syn@2k_', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Syn@2k_1', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Syn@2k_2', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Syn@2k_3', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM=');

-- --------------------------------------------------------

--
-- Table structure for table `song`
--

CREATE TABLE `song` (
  `SongId` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Path` varchar(100) DEFAULT NULL,
  `Lyrics` varchar(100) DEFAULT NULL,
  `PublishYear` year(4) DEFAULT NULL,
  `DateAdded` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`SongId`, `Name`, `Path`, `Lyrics`, `PublishYear`, `DateAdded`) VALUES
(1, 'I Don\'t Care', '..\\Songs\\IDon\'tCare.mp3', '..\\Songs\\IDon\'tCare.srt', 2019, '2020-10-16'),
(2, 'Blinding Lights', '..\\Songs\\BlindingLights.mp3', '..\\Songs\\BlindingLights.srt', 2019, '2020-10-16'),
(3, 'Sunflower', '..\\Songs\\Sunflower.mp3', '..\\Songs\\Sunflower.srt', 2019, '2020-10-16'),
(4, 'Adore You', '..\\Songs\\AdoreYou.mp3', '..\\Songs\\AdoreYou.srt', 2019, '2020-10-18'),
(5, 'Circles', '..\\Songs\\Circles.mp3', '..\\Songs\\Circles.srt', 2019, '2020-10-18'),
(6, 'Dance Monkey', '..\\Songs\\DanceMonkey.mp3', '..\\Songs\\DanceMonkey.srt', 2019, '2020-10-18'),
(7, 'Girls Like You', '..\\Songs\\GirlsLikeYou.mp3', '..\\Songs\\GirlsLikeYou.srt', 2018, '2020-10-18'),
(8, 'Happier', '..\\Songs\\Happier.mp3', '..\\Songs\\Happier.srt', 2018, '2020-10-18'),
(9, 'High Hopes', '..\\Songs\\HighHopes.mp3', '..\\Songs\\HighHopes.srt', 2018, '2020-10-18'),
(10, 'If I Can\'t Have You', '..\\Songs\\IfICan\'tHaveYou.mp3', '..\\Songs\\IfICan\'tHaveYou.srt', 2019, '2020-10-18'),
(11, 'Let Me Down Slowly', '..\\Songs\\LetMeDownSlowly.mp3', '..\\Songs\\LetMeDownSlowly.srt', 2018, '2020-10-18'),
(12, 'Lose Yourself', '..\\Songs\\LoseYourself.mp3', '..\\Songs\\LoseYourself.srt', 2004, '2020-10-18'),
(13, 'Lovely', '..\\Songs\\Lovely.mp3', '..\\Songs\\Lovely.srt', 2018, '2020-10-18'),
(14, 'No Time To Die', '..\\Songs\\NoTimeToDie.mp3', '..\\Songs\\NoTimeToDie.srt', 2020, '2020-10-18'),
(15, 'Old Town Remix', '..\\Songs\\OldTownRemix.mp3', '..\\Songs\\OldTownRemix.srt', 2019, '2020-10-18'),
(16, 'Photograph', '..\\Songs\\Photograph.mp3', '..\\Songs\\Photograph.srt', 2013, '2020-10-18'),
(17, 'Something Just Like This', '..\\Songs\\SomethingJustLikeThis.mp3', '..\\Songs\\SomethingJustLikeThis.srt', 2017, '2020-10-18'),
(18, 'Takeaway', '..\\Songs\\Takeaway.mp3', '..\\Songs\\Takeaway.srt', 2019, '2020-10-18'),
(19, 'We Are The Champions', '..\\Songs\\WeAreTheChampions.mp3', '..\\Songs\\WeAreTheChampions.srt', 1977, '2020-10-18'),
(20, 'Youngblood', '..\\Songs\\Youngblood.mp3', '..\\Songs\\Youngblood.srt', 2018, '2020-10-18'),
(21, 'Wakhra Swag', '..\\Songs\\WakhraSwag.mp3', '\\Songs\\WakhraSwag.srt', 2015, '2020-10-19');

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `USERID` varchar(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PhoneNo` varchar(10) DEFAULT NULL,
  `Dob` datetime(6) DEFAULT current_timestamp(6),
  `Email` varchar(60) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`USERID`, `Name`, `PhoneNo`, `Dob`, `Email`, `State`) VALUES
('Ksh@121', 'kshitij111', 'abcd', '2020-10-09 00:00:00.000000', 'jksal', 'Uttarakhand');

-- --------------------------------------------------------

--
-- Table structure for table `usergenre`
--

CREATE TABLE `usergenre` (
  `USERID` varchar(20) NOT NULL,
  `Genre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `userlang`
--

CREATE TABLE `userlang` (
  `USERID` varchar(20) NOT NULL,
  `Language` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Uname`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`SongId`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`USERID`,`Name`);

--
-- Indexes for table `usergenre`
--
ALTER TABLE `usergenre`
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `userlang`
--
ALTER TABLE `userlang`
  ADD KEY `USERID` (`USERID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `song`
--
ALTER TABLE `song`
  MODIFY `SongId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `userdata`
--
ALTER TABLE `userdata`
  ADD CONSTRAINT `userdata_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `usergenre`
--
ALTER TABLE `usergenre`
  ADD CONSTRAINT `usergenre_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `userlang`
--
ALTER TABLE `userlang`
  ADD CONSTRAINT `userlang_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
