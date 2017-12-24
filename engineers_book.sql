-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 24, 2017 at 06:53 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `engineers book`
--
CREATE DATABASE IF NOT EXISTS `engineers book` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `engineers book`;

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

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

CREATE TABLE IF NOT EXISTS `articles` (
  `user_id` int(10) NOT NULL,
  `article_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '14 is the length of article id',
  `article_type` int(3) NOT NULL,
  `article_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `article_image` longblob,
  `created_time` mediumint(11) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`user_id`, `article_id`, `article_type`, `article_text`, `article_image`, `created_time`) VALUES
(1, 1, 1, 'hello there', NULL, 0),
(1, 2, 1, 'second art', NULL, 0),
(2, 3, 1, 'another user', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE IF NOT EXISTS `college` (
  `user_id` varchar(10) NOT NULL,
  `univ_id` varchar(5) NOT NULL,
  `colg_id` varchar(5) NOT NULL,
  `colg_name` text NOT NULL,
  `website` varchar(40) NOT NULL,
  `tpo_no` bigint(13) NOT NULL,
  `tpo_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

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

CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` varchar(5) NOT NULL COMMENT '5 is std length of dept',
  `user_id` varchar(10) NOT NULL,
  `dept_name` text NOT NULL,
  `hod_name` text NOT NULL,
  `placements` int(3) NOT NULL,
  `clog_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE IF NOT EXISTS `faculty` (
  `enroll_no` int(14) NOT NULL,
  `user_id` varchar(10) NOT NULL,
  `dept_id` varchar(5) NOT NULL,
  `colg_id` varchar(5) NOT NULL,
  `ranking` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'This is a unique id assigned to every user',
  `enroll_no` int(14) DEFAULT NULL COMMENT 'every member of universityy is assigned a unique number by it',
  `dept_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'dept id ',
  `colg_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `year_of_passing` date NOT NULL,
  `ranking` int(2) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

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
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `login_status`, `fname`, `lname`, `Gender`, `dob`, `email`, `contact`) VALUES
(1, '1234', 0, 'shabbir', 'bhaisaheb', 0, '2017-12-11', 'abc@gmail.com', 9033257850),
(2, '1234', 0, 'shabbir', 'bhaisaheb', 0, '2017-12-11', 'abc@gmail.com', 9033257850);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
