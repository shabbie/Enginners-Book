-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 10, 2018 at 07:42 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `engineerbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `user_id` varchar(10) NOT NULL,
  `street` varchar(20) NOT NULL,
  `city` text NOT NULL,
  `pincode` int(6) NOT NULL,
  `state` text NOT NULL,
  `country` text NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `user_id` int(10) NOT NULL,
  `article_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '14 is the length of article id',
  `article_type` int(3) NOT NULL,
  `article_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `article_image` longblob,
  `create_time` mediumint(11) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`user_id`, `article_id`, `article_type`, `article_text`, `article_image`, `create_time`) VALUES
(1, 1, 1, 'hello there', NULL, 0),
(1, 2, 1, 'second art', NULL, 0),
(2, 3, 1, 'another user', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
CREATE TABLE IF NOT EXISTS `college` (
  `user_id` varchar(10) NOT NULL,
  `univ_id` varchar(5) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `colg_name` text NOT NULL,
  `website` varchar(40) NOT NULL,
  `tpo_no` bigint(13) NOT NULL,
  `tpo_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `college`
--

INSERT INTO `college` (`user_id`, `univ_id`, `colg_id`, `colg_name`, `website`, `tpo_no`, `tpo_name`) VALUES
('1', '1', 41, 'SVIT', 'svitvasad.ac.in', 9999999999, 'Ajit Shah');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `comp_name` varchar(30) NOT NULL,
  `address` varchar(40) NOT NULL,
  `hr_name` text NOT NULL,
  `domain` varchar(20) NOT NULL,
  PRIMARY KEY (`comp_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` int(2) NOT NULL COMMENT '5 is std length of dept',
  `user_id` varchar(10) NOT NULL,
  `dept_name` text NOT NULL,
  `hod_name` text NOT NULL,
  `placements` int(3) NOT NULL DEFAULT '0',
  `colg_id` int(3) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `user_id`, `dept_name`, `hod_name`, `placements`, `colg_id`) VALUES
(7, '1', 'computer', 'bijal mam', 0, 41);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE IF NOT EXISTS `faculty` (
  `enroll_no` int(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `ranking` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hod`
--

DROP TABLE IF EXISTS `hod`;
CREATE TABLE IF NOT EXISTS `hod` (
  `user_id` int(10) NOT NULL,
  `enroll_id` bigint(12) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `ranking` int(3) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `enroll_id` (`enroll_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `user_id` int(10) NOT NULL COMMENT 'This is a unique id assigned to every user',
  `enroll_no` bigint(12) NOT NULL COMMENT 'every member of universityy is assigned a unique number by it',
  `dept_id` int(2) DEFAULT NULL COMMENT 'dept id ',
  `colg_id` int(3) NOT NULL,
  `year_of_passing` int(4) NOT NULL,
  `ranking` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`user_id`, `enroll_no`, `dept_id`, `colg_id`, `year_of_passing`, `ranking`) VALUES
(1, 140410107002, 7, 41, 2018, 0),
(2, 140410107024, 7, 41, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
CREATE TABLE IF NOT EXISTS `university` (
  `user_id` varchar(10) NOT NULL,
  `uni_name` text NOT NULL,
  `uni_id` varchar(5) NOT NULL,
  `website` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(16) NOT NULL,
  `login_status` tinyint(1) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `Gender` int(1) NOT NULL COMMENT '0- male',
  `dob` date NOT NULL,
  `email` varchar(20) NOT NULL,
  `contact` bigint(13) NOT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `login_status`, `fname`, `lname`, `Gender`, `dob`, `email`, `contact`, `user_type`) VALUES
(1, '1234', 0, 'shabbir', 'bhaisaheb', 0, '2017-12-11', 'abc@gmail.com', 9033257850, 'student'),
(2, '1234', 0, 'abhi', 'koranne', 0, '2017-12-11', 'xyz@gmail.com', 9999999999, 'faculty');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
