-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2020 at 04:18 PM
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
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `ID` int(11) NOT NULL,
  `Artist` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`ID`, `Artist`) VALUES
(1, 'The Chainsmokers'),
(2, 'Alec Benjamin'),
(3, 'Marshmallow'),
(4, 'Harry Styles'),
(5, 'Eminem'),
(6, 'Shawn Mendes'),
(7, 'Ed Sheeran'),
(8, 'Maroon 5'),
(9, 'Billie Eilish'),
(10, 'Post Malone'),
(11, 'Panic! And the Disco'),
(12, 'Tones and I'),
(13, 'Queen'),
(14, 'Lil Nas X'),
(15, 'The Weeknd'),
(16, '5 Seconds of Summer'),
(17, 'Navv Inder');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `ID` int(11) NOT NULL,
  `Genre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`ID`, `Genre`) VALUES
(1, 'Pop'),
(2, 'Rap'),
(3, 'Romantic'),
(4, 'Contemporary'),
(5, 'Metal'),
(6, 'Band'),
(7, 'Folk'),
(8, 'Classical'),
(9, 'Brostep'),
(10, 'Hiphop'),
(11, 'Rock');

-- --------------------------------------------------------

--
-- Table structure for table `groupadmin`
--

CREATE TABLE `groupadmin` (
  `GroupID` int(11) NOT NULL,
  `GroupName` varchar(30) NOT NULL,
  `USERID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `groupadmin`
--

INSERT INTO `groupadmin` (`GroupID`, `GroupName`, `USERID`) VALUES
(1, 'Rns', 'snigdha'),
(2, 'Rise up', 'snigdha');

-- --------------------------------------------------------

--
-- Table structure for table `groupusers`
--

CREATE TABLE `groupusers` (
  `GroupID` int(11) NOT NULL,
  `Members` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `groupusers`
--

INSERT INTO `groupusers` (`GroupID`, `Members`) VALUES
(1, 'divyasri'),
(1, 'Purva@123'),
(1, 'Purva@1234'),
(1, 'saloni'),
(1, 'Sni@13'),
(1, 'snigdha'),
(2, 'Ajeeb@13'),
(2, 'Anon@123'),
(2, 'Purva@1234'),
(2, 'rishabh'),
(2, 'saloni'),
(2, 'snigdha');

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `ID` int(11) NOT NULL,
  `Language` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`ID`, `Language`) VALUES
(1, 'English'),
(2, 'Hindi'),
(3, 'Spanish'),
(4, 'French'),
(7, 'Telugu'),
(8, 'Harayanvi'),
(9, 'Bihari'),
(10, 'Punjabi');

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
('Abcd@13', 'AsStZPbFc2awOObb7FHBZeZrq3sMJ3VD+FrlQnzQTlg='),
('Afk@13', 'GZ7bNNbbf0ddNWVk+nVNfgmQJYAfr/g0tOybpiTu79M='),
('Ajeeb@13', 'cug6fQa0efRLIDw2snwivx+gNk9qixOavslCl7GMmmA='),
('Anon@123', '4cB4+xog3Vps3FHxT70tszVWfYVb9Z0jZsBhbF5c6hc='),
('divyasri', 'ESSpZsvTADsA1BifvkobtcQuCAre6SDYIQCcZOtAo7Y='),
('Hello@3', 'uX/8i1UqB8D0JQXeT2Dz6g1il6SkGRr7m78W1AmbYOU='),
('HEYAa!@12', 'xoZ71k61bIfpsHqPwqla7WJfBC4h9vIS4SMJJwjECGc='),
('Ksh12@', '/A4V3QIkObJduVHhAqD2mTOXVD9RfNuQG/e9rWhvZeM='),
('Purva@123', 'EBLwN4oc7RBGwI8dl0/TMQ1sfCW00NxC3XqbrPNXEdA='),
('Purva@1234', 'uXcyhDs29cEz/Iti8h5GztMkjB+lhYd7h2YsUH/c8F0='),
('rishabh', 'VTNGyc+ZtL7fQjsuzE/p9eg40CdlrrlbX4r6kL8wmaM='),
('saloni', 'zE8wdBA5XZ+jqX5PwqdoMh9gHSVqEGVsiJs+pOpXQEw='),
('Sni@13', 'AsStZPbFc2awOObb7FHBZeZrq3sMJ3VD+FrlQnzQTlg='),
('snigdha', 'vXOAs9vj76icfhaiR28vgFitrofIxC/LhE4jrHekzA0='),
('uhU@123', 'WDZl5z82qfkbInrmPbzO3Kjx/X5gF7g0QJ8B+fjXzG0=');

-- --------------------------------------------------------

--
-- Table structure for table `playlistsong`
--

CREATE TABLE `playlistsong` (
  `PlaylistID` int(11) NOT NULL,
  `SongID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `playlistsong`
--

INSERT INTO `playlistsong` (`PlaylistID`, `SongID`) VALUES
(3, 2),
(3, 3),
(3, 4),
(3, 6),
(3, 7),
(5, 2),
(5, 3),
(5, 4),
(7, 21),
(8, 20),
(9, 19),
(11, 16),
(11, 17),
(11, 18),
(11, 19),
(11, 20),
(11, 21),
(13, 1),
(14, 2);

-- --------------------------------------------------------

--
-- Table structure for table `playlistuser`
--

CREATE TABLE `playlistuser` (
  `USERID` varchar(20) NOT NULL,
  `PlaylistID` int(11) NOT NULL,
  `PlaylistName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `playlistuser`
--

INSERT INTO `playlistuser` (`USERID`, `PlaylistID`, `PlaylistName`) VALUES
('snigdha', 1, 'Hellothere'),
('snigdha', 3, 'hym'),
('snigdha', 5, '1122'),
('snigdha', 6, 'waak'),
('snigdha', 7, '78j'),
('snigdha', 8, '97h'),
('snigdha', 9, ''),
('snigdha', 10, '6677hh'),
('snigdha', 11, '3566'),
('snigdha', 12, '46'),
('snigdha', 13, 'abcd'),
('snigdha', 14, 'fv');

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
  `DateAdded` date DEFAULT NULL,
  `Likes` int(11) NOT NULL DEFAULT 0,
  `Dislikes` int(11) NOT NULL DEFAULT 0,
  `TimesPlayed` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`SongId`, `Name`, `Path`, `Lyrics`, `PublishYear`, `DateAdded`, `Likes`, `Dislikes`, `TimesPlayed`) VALUES
(1, 'I Dont Care', '..\\Songs\\IDon\'tCare.mp3', '..\\Songs\\IDon\'tCare.srt', 2019, '2020-10-16', 0, 0, 0),
(2, 'Blinding Lights', '..\\Songs\\BlindingLights.mp3', '..\\Songs\\BlindingLights.srt', 2019, '2020-10-16', 0, 0, 0),
(3, 'Sunflower', '..\\Songs\\Sunflower.mp3', '..\\Songs\\Sunflower.srt', 2019, '2020-10-16', 0, 0, 0),
(4, 'Adore You', '..\\Songs\\AdoreYou.mp3', '..\\Songs\\AdoreYou.srt', 2019, '2020-10-18', 0, 0, 0),
(5, 'Circles', '..\\Songs\\Circles.mp3', '..\\Songs\\Circles.srt', 2019, '2020-10-18', 0, 0, 0),
(6, 'Dance Monkey', '..\\Songs\\DanceMonkey.mp3', '..\\Songs\\DanceMonkey.srt', 2019, '2020-10-18', 0, 0, 0),
(7, 'Girls Like You', '..\\Songs\\GirlsLikeYou.mp3', '..\\Songs\\GirlsLikeYou.srt', 2018, '2020-10-18', 0, 0, 0),
(8, 'Happier', '..\\Songs\\Happier.mp3', '..\\Songs\\Happier.srt', 2018, '2020-10-18', 0, 0, 0),
(9, 'High Hopes', '..\\Songs\\HighHopes.mp3', '..\\Songs\\HighHopes.srt', 2018, '2020-10-18', 0, 0, 0),
(10, 'If I Can\'t Have You', '..\\Songs\\IfICan\'tHaveYou.mp3', '..\\Songs\\IfICan\'tHaveYou.srt', 2019, '2020-10-18', 0, 0, 0),
(11, 'Let Me Down Slowly', '..\\Songs\\LetMeDownSlowly.mp3', '..\\Songs\\LetMeDownSlowly.srt', 2018, '2020-10-18', 0, 0, 0),
(12, 'Lose Yourself', '..\\Songs\\LoseYourself.mp3', '..\\Songs\\LoseYourself.srt', 2004, '2020-10-18', 0, 0, 0),
(13, 'Lovely', '..\\Songs\\Lovely.mp3', '..\\Songs\\Lovely.srt', 2018, '2020-10-18', 0, 0, 0),
(14, 'No Time To Die', '..\\Songs\\NoTimeToDie.mp3', '..\\Songs\\NoTimeToDie.srt', 2020, '2020-10-18', 0, 0, 0),
(15, 'Old Town Remix', '..\\Songs\\OldTownRemix.mp3', '..\\Songs\\OldTownRemix.srt', 2019, '2020-10-18', 0, 0, 0),
(16, 'Photograph', '..\\Songs\\Photograph.mp3', '..\\Songs\\Photograph.srt', 2013, '2020-10-18', 0, 0, 0),
(17, 'Something Just Like This', '..\\Songs\\SomethingJustLikeThis.mp3', '..\\Songs\\SomethingJustLikeThis.srt', 2017, '2020-10-18', 0, 0, 0),
(18, 'Takeaway', '..\\Songs\\Takeaway.mp3', '..\\Songs\\Takeaway.srt', 2019, '2020-10-18', 0, 0, 0),
(19, 'We Are The Champions', '..\\Songs\\WeAreTheChampions.mp3', '..\\Songs\\WeAreTheChampions.srt', 1977, '2020-10-18', 0, 0, 0),
(20, 'Youngblood', '..\\Songs\\Youngblood.mp3', '..\\Songs\\Youngblood.srt', 2018, '2020-10-18', 0, 0, 0),
(21, 'Wakhra Swag', '..\\Songs\\WakhraSwag.mp3', '\\Songs\\WakhraSwag.srt', 2015, '2020-10-19', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `songartist`
--

CREATE TABLE `songartist` (
  `SongID` int(11) NOT NULL,
  `ArtistID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `songartist`
--

INSERT INTO `songartist` (`SongID`, `ArtistID`) VALUES
(1, 7),
(2, 15),
(3, 10),
(5, 10),
(6, 12),
(7, 8),
(8, 3),
(9, 11),
(10, 6),
(11, 2),
(12, 5),
(13, 9),
(14, 9),
(15, 14),
(16, 7),
(17, 1),
(18, 1),
(20, 16),
(21, 17);

-- --------------------------------------------------------

--
-- Table structure for table `songgenre`
--

CREATE TABLE `songgenre` (
  `SongID` int(11) NOT NULL,
  `GenreID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `songgenre`
--

INSERT INTO `songgenre` (`SongID`, `GenreID`) VALUES
(1, 1),
(2, 4),
(3, 2),
(4, 1),
(5, 2),
(6, 1),
(7, 1),
(8, 9),
(9, 1),
(10, 1),
(11, 1),
(12, 10),
(13, 1),
(14, 1),
(15, 2),
(16, 1),
(17, 1),
(18, 1),
(19, 11),
(20, 6),
(21, 10);

-- --------------------------------------------------------

--
-- Table structure for table `songlang`
--

CREATE TABLE `songlang` (
  `SongID` int(11) NOT NULL,
  `LangID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `songlang`
--

INSERT INTO `songlang` (`SongID`, `LangID`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 10);

-- --------------------------------------------------------

--
-- Table structure for table `userartist`
--

CREATE TABLE `userartist` (
  `USERID` varchar(20) NOT NULL,
  `Artist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userartist`
--

INSERT INTO `userartist` (`USERID`, `Artist`) VALUES
('Hello@3', 1),
('Hello@3', 5),
('Hello@3', 10),
('Ksh12@', 1),
('Ksh12@', 3),
('Ksh12@', 5),
('Ksh12@', 6),
('Ksh12@', 7),
('Ksh12@', 8),
('Sni@13', 4);

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
('Hello@3', 'kjbfekjw', '9988732414', '2003-10-31 00:00:00.000000', 'gnm@hjn.com', 'North-Eastern States'),
('Ksh12@', 'Kshitij', '9263046669', '2000-02-04 00:00:00.000000', 'kshtj09@gmail.com', 'Madhya Pradesh'),
('Purva@1234', 'Purva Gautam', '7987318738', '2001-01-15 00:00:00.000000', 'gautam.purva@gmail.com', 'Madhya Pradesh'),
('Sni@13', 'gj', '9888999878', '2003-10-23 00:00:00.000000', 'fbg@ab.com', 'Uttarakhand'),
('uhU@123', 'Hello', '8978939890', '1999-10-08 00:00:00.000000', 'mdsnkj@manksh.com', 'Karnataka');

-- --------------------------------------------------------

--
-- Table structure for table `usergenre`
--

CREATE TABLE `usergenre` (
  `USERID` varchar(20) NOT NULL,
  `Genre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usergenre`
--

INSERT INTO `usergenre` (`USERID`, `Genre`) VALUES
('Hello@3', 5),
('Sni@13', 5);

-- --------------------------------------------------------

--
-- Table structure for table `userlang`
--

CREATE TABLE `userlang` (
  `USERID` varchar(20) NOT NULL,
  `Language` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userlang`
--

INSERT INTO `userlang` (`USERID`, `Language`) VALUES
('Hello@3', 7),
('Hello@3', 8),
('Ksh12@', 1),
('Ksh12@', 2),
('Ksh12@', 3),
('Ksh12@', 10),
('Sni@13', 9);

-- --------------------------------------------------------

--
-- Table structure for table `usersong`
--

CREATE TABLE `usersong` (
  `USERID` varchar(20) NOT NULL,
  `SongID` int(11) NOT NULL,
  `Liked` tinyint(1) NOT NULL,
  `TimesPlayed` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `groupadmin`
--
ALTER TABLE `groupadmin`
  ADD PRIMARY KEY (`GroupID`),
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `groupusers`
--
ALTER TABLE `groupusers`
  ADD PRIMARY KEY (`GroupID`,`Members`),
  ADD KEY `Members` (`Members`),
  ADD KEY `GroupID` (`GroupID`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Uname`);

--
-- Indexes for table `playlistsong`
--
ALTER TABLE `playlistsong`
  ADD PRIMARY KEY (`PlaylistID`,`SongID`),
  ADD KEY `SongID` (`SongID`),
  ADD KEY `PlaylistID` (`PlaylistID`);

--
-- Indexes for table `playlistuser`
--
ALTER TABLE `playlistuser`
  ADD PRIMARY KEY (`PlaylistID`),
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`SongId`);

--
-- Indexes for table `songartist`
--
ALTER TABLE `songartist`
  ADD PRIMARY KEY (`SongID`,`ArtistID`),
  ADD KEY `ArtistID` (`ArtistID`),
  ADD KEY `SongID` (`SongID`);

--
-- Indexes for table `songgenre`
--
ALTER TABLE `songgenre`
  ADD PRIMARY KEY (`SongID`,`GenreID`),
  ADD KEY `GenreID` (`GenreID`),
  ADD KEY `SongID` (`SongID`);

--
-- Indexes for table `songlang`
--
ALTER TABLE `songlang`
  ADD PRIMARY KEY (`SongID`,`LangID`),
  ADD KEY `LangID` (`LangID`),
  ADD KEY `SongID` (`SongID`) USING BTREE;

--
-- Indexes for table `userartist`
--
ALTER TABLE `userartist`
  ADD PRIMARY KEY (`USERID`,`Artist`),
  ADD KEY `Artist` (`Artist`),
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`USERID`,`Name`),
  ADD KEY `USERID` (`USERID`);

--
-- Indexes for table `usergenre`
--
ALTER TABLE `usergenre`
  ADD PRIMARY KEY (`USERID`,`Genre`),
  ADD KEY `USERID` (`USERID`),
  ADD KEY `Genre` (`Genre`);

--
-- Indexes for table `userlang`
--
ALTER TABLE `userlang`
  ADD PRIMARY KEY (`USERID`,`Language`),
  ADD KEY `USERID` (`USERID`),
  ADD KEY `Language` (`Language`);

--
-- Indexes for table `usersong`
--
ALTER TABLE `usersong`
  ADD PRIMARY KEY (`USERID`,`SongID`),
  ADD KEY `SongID` (`SongID`),
  ADD KEY `USERID` (`USERID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `groupadmin`
--
ALTER TABLE `groupadmin`
  MODIFY `GroupID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `playlistuser`
--
ALTER TABLE `playlistuser`
  MODIFY `PlaylistID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `song`
--
ALTER TABLE `song`
  MODIFY `SongId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `groupadmin`
--
ALTER TABLE `groupadmin`
  ADD CONSTRAINT `groupadmin_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `groupusers`
--
ALTER TABLE `groupusers`
  ADD CONSTRAINT `groupusers_ibfk_1` FOREIGN KEY (`GroupID`) REFERENCES `groupadmin` (`GroupID`),
  ADD CONSTRAINT `groupusers_ibfk_2` FOREIGN KEY (`Members`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `playlistsong`
--
ALTER TABLE `playlistsong`
  ADD CONSTRAINT `playlistsong_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`),
  ADD CONSTRAINT `playlistsong_ibfk_2` FOREIGN KEY (`PlaylistID`) REFERENCES `playlistuser` (`PlaylistID`);

--
-- Constraints for table `playlistuser`
--
ALTER TABLE `playlistuser`
  ADD CONSTRAINT `playlistuser_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `songartist`
--
ALTER TABLE `songartist`
  ADD CONSTRAINT `songartist_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`),
  ADD CONSTRAINT `songartist_ibfk_2` FOREIGN KEY (`ArtistID`) REFERENCES `artist` (`ID`);

--
-- Constraints for table `songgenre`
--
ALTER TABLE `songgenre`
  ADD CONSTRAINT `songgenre_ibfk_1` FOREIGN KEY (`GenreID`) REFERENCES `genre` (`ID`),
  ADD CONSTRAINT `songgenre_ibfk_2` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`),
  ADD CONSTRAINT `songgenre_ibfk_3` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`);

--
-- Constraints for table `songlang`
--
ALTER TABLE `songlang`
  ADD CONSTRAINT `songlang_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`),
  ADD CONSTRAINT `songlang_ibfk_2` FOREIGN KEY (`LangID`) REFERENCES `language` (`ID`),
  ADD CONSTRAINT `songlang_ibfk_3` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`);

--
-- Constraints for table `userartist`
--
ALTER TABLE `userartist`
  ADD CONSTRAINT `userartist_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`),
  ADD CONSTRAINT `userartist_ibfk_2` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`),
  ADD CONSTRAINT `userartist_ibfk_3` FOREIGN KEY (`Artist`) REFERENCES `artist` (`ID`),
  ADD CONSTRAINT `userartist_ibfk_4` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `userdata`
--
ALTER TABLE `userdata`
  ADD CONSTRAINT `userdata_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);

--
-- Constraints for table `usergenre`
--
ALTER TABLE `usergenre`
  ADD CONSTRAINT `usergenre_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`),
  ADD CONSTRAINT `usergenre_ibfk_2` FOREIGN KEY (`Genre`) REFERENCES `genre` (`ID`);

--
-- Constraints for table `userlang`
--
ALTER TABLE `userlang`
  ADD CONSTRAINT `userlang_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`),
  ADD CONSTRAINT `userlang_ibfk_2` FOREIGN KEY (`Language`) REFERENCES `language` (`ID`);

--
-- Constraints for table `usersong`
--
ALTER TABLE `usersong`
  ADD CONSTRAINT `usersong_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongId`),
  ADD CONSTRAINT `usersong_ibfk_2` FOREIGN KEY (`USERID`) REFERENCES `login` (`Uname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
