-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2020 at 01:27 PM
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
('divyasri', 'ESSpZsvTADsA1BifvkobtcQuCAre6SDYIQCcZOtAo7Y='),
('Purva@123', 'EBLwN4oc7RBGwI8dl0/TMQ1sfCW00NxC3XqbrPNXEdA='),
('Purva@1234', 'uXcyhDs29cEz/Iti8h5GztMkjB+lhYd7h2YsUH/c8F0='),
('rishabh', 'VTNGyc+ZtL7fQjsuzE/p9eg40CdlrrlbX4r6kL8wmaM='),
('saloni', 'zE8wdBA5XZ+jqX5PwqdoMh9gHSVqEGVsiJs+pOpXQEw='),
('snigdha', 'vXOAs9vj76icfhaiR28vgFitrofIxC/LhE4jrHekzA0='),
('uhU@123', 'WDZl5z82qfkbInrmPbzO3Kjx/X5gF7g0QJ8B+fjXzG0=');

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
-- Table structure for table `userartist`
--

CREATE TABLE `userartist` (
  `USERID` varchar(20) NOT NULL,
  `Artist` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userartist`
--

INSERT INTO `userartist` (`USERID`, `Artist`) VALUES
('Purva@1234', 'Ed Sheeran'),
('Purva@1234', 'Maroon 5'),
('Purva@1234', 'Marshmallow'),
('Purva@1234', 'Post Malone'),
('Purva@1234', 'Shawn Mendes'),
('Purva@1234', 'The Chainsmokers');

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
('Purva@1234', 'Purva Gautam', '7987318738', '2001-01-15 00:00:00.000000', 'gautam.purva@gmail.com', 'Madhya Pradesh'),
('uhU@123', 'Hello', '8978939890', '1999-10-08 00:00:00.000000', 'mdsnkj@manksh.com', 'Karnataka');

-- --------------------------------------------------------

--
-- Table structure for table `usergenre`
--

CREATE TABLE `usergenre` (
  `USERID` varchar(20) NOT NULL,
  `Genre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usergenre`
--

INSERT INTO `usergenre` (`USERID`, `Genre`) VALUES
('Purva@1234', 'Band'),
('Purva@1234', 'Classical'),
('Purva@1234', 'Contemporary'),
('Purva@1234', 'Folk'),
('Purva@1234', 'Hiphop'),
('Purva@1234', 'Rock'),
('Purva@1234', 'Romantic'),
('uhU@123', 'Band'),
('uhU@123', 'Brostep'),
('uhU@123', 'Regional');

-- --------------------------------------------------------

--
-- Table structure for table `userlang`
--

CREATE TABLE `userlang` (
  `USERID` varchar(20) NOT NULL,
  `Language` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userlang`
--

INSERT INTO `userlang` (`USERID`, `Language`) VALUES
('Purva@1234', 'English'),
('Purva@1234', 'French'),
('Purva@1234', 'Hindi'),
('Purva@1234', 'Punjabi'),
('Purva@1234', 'Spanish'),
('uhU@123', 'Hindi'),
('uhU@123', 'Punjabi'),
('uhU@123', 'Telugu');

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
-- Indexes for table `userartist`
--
ALTER TABLE `userartist`
  ADD PRIMARY KEY (`USERID`,`Artist`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`USERID`,`Name`);

--
-- Indexes for table `usergenre`
--
ALTER TABLE `usergenre`
  ADD PRIMARY KEY (`USERID`,`Genre`),
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `userlang`
--
ALTER TABLE `userlang`
  ADD PRIMARY KEY (`USERID`,`Language`),
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
-- Constraints for table `userartist`
--
ALTER TABLE `userartist`
  ADD CONSTRAINT `userartist_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`),
  ADD CONSTRAINT `userartist_ibfk_2` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

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
