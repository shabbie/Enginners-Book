-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2018 at 08:42 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `engineersbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `street` varchar(20) NOT NULL,
  `city` varchar(15) NOT NULL,
  `pincode` int(6) NOT NULL,
  `state` varchar(15) NOT NULL,
  `country` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`user_id`, `street`, `city`, `pincode`, `state`, `country`) VALUES
('1', 'wadi', 'Vadodara', 390017, 'Gujarat', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `answer_id` int(14) NOT NULL,
  `doubt_id` int(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `upvotes` int(11) NOT NULL,
  `downvotes` int(11) NOT NULL,
  `answer_image` varchar(35) DEFAULT NULL,
  `create_time` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answer_id`, `doubt_id`, `user_id`, `text`, `upvotes`, `downvotes`, `answer_image`, `create_time`) VALUES
(2, 2, 1, 'my answer', 1, 1, NULL, 0),
(4, 3, 1, 'my answer', 0, 0, NULL, 0),
(5, 1, 1, 'My answer@QueryProjectionIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 0, 0, NULL, 1521964336770),
(6, 2, 2, 'My answer@QueryProjectionIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 0, 0, NULL, 1521964336770),
(7, 3, 3, 'My answer@QueryProjectionIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 0, 0, NULL, 1521964336770),
(8, 2, 4, 'My answer@QueryProjectionIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 0, 0, NULL, 1521964336770);

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `user_id` int(10) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `article_id` int(14) NOT NULL COMMENT '14 is the length of article id',
  `likes` int(11) NOT NULL,
  `article_type` int(3) NOT NULL,
  `article_text` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `article_image` varchar(35) DEFAULT NULL,
  `create_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`user_id`, `dept_id`, `article_id`, `likes`, `article_type`, `article_text`, `article_image`, `create_time`) VALUES
(1, 7, 1, 1, 1, 'hello there', NULL, 0),
(3, 7, 2, 0, 1, 'second art', NULL, 0),
(2, 7, 3, 0, 1, 'another user', NULL, 0),
(2, 7, 4, 0, 0, 'abc', NULL, 0),
(2, 7, 5, 0, 0, 'the text of doubt', NULL, 1521963516863);

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE `college` (
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
('1', '1', 41, 'SVIT', 'svitvasad.ac.in', 9999999999, 'Ajit Shah'),
('18', '2154', 42, 'parul', 'www.svit.com', 0, 'ajit shah'),
('21', '2154', 43, 'svi', 'www.svit.com', 0, 'ajit shah');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `article_id` int(14) NOT NULL,
  `comment_id` int(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `create_time` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`article_id`, `comment_id`, `user_id`, `text`, `create_time`) VALUES
(3, 1, 1, 'My comment', 0),
(2, 2, 2, 'this is my comment', 0),
(2, 3, 3, 'my comment', 1521964146798);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `comp_id` varchar(10) NOT NULL,
  `comp_name` varchar(30) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `address` text NOT NULL,
  `hr_name` varchar(35) NOT NULL,
  `hr_contact` bigint(20) NOT NULL,
  `domain` varchar(40) DEFAULT NULL COMMENT 'csv''s of the technologies nd all',
  `profile_pic` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`comp_id`, `comp_name`, `contact`, `address`, `hr_name`, `hr_contact`, `domain`, `profile_pic`) VALUES
('723', 'gateway', 90232238233, 'amdavad', 'shahsha', 28714981234, NULL, NULL),
('877', 'TCS', 812648112, 'malad west, mumbai, maharashtra.', 'Mayank', 923902932, 'all services', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_id` int(2) NOT NULL COMMENT '2 is std length of dept',
  `dept_name` varchar(20) NOT NULL,
  `hod_name` text NOT NULL,
  `placements` int(3) NOT NULL DEFAULT '0',
  `colg_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`, `hod_name`, `placements`, `colg_id`) VALUES
(7, 'computer', 'bijal mam', 0, 41);

-- --------------------------------------------------------

--
-- Table structure for table `doubts`
--

CREATE TABLE `doubts` (
  `doubt_id` int(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  `heading` varchar(200) NOT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `doubt_image` varchar(35) DEFAULT NULL,
  `tag` varchar(100) NOT NULL,
  `upvotes` int(11) NOT NULL,
  `downvotes` int(11) NOT NULL,
  `create_time` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doubts`
--

INSERT INTO `doubts` (`doubt_id`, `user_id`, `dept_id`, `heading`, `text`, `doubt_image`, `tag`, `upvotes`, `downvotes`, `create_time`) VALUES
(1, 1, 7, 'Help me', 'orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letra', NULL, 'java', 1, 1, 0),
(2, 2, 7, 'Having Ptoblem in adtabase', 'orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letra', NULL, 'android', 0, 0, 1522392314740),
(3, 2, 7, 'Unable to get data', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', NULL, 'C', 0, 0, 1522175400000),
(4, 3, 7, 'Php my admin not responding', 'the text of doubt', NULL, 'C', 0, 0, 0),
(5, 4, 7, 'Problem!!', 'the text of doubt', NULL, 'C', 0, 0, 0),
(6, 5, 7, 'help!', 'the text of doubt', NULL, 'C', 0, 0, 0),
(7, 4, 7, 'can you help me', 'the text of doubt', NULL, 'C', 0, 0, 1521961765869),
(8, 3, 7, 'why so serious?', 'the text of doubt', NULL, 'C', 0, 0, 1521962446504);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `enroll_no` bigint(14) NOT NULL,
  `user_id` int(10) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `ranking` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`enroll_no`, `user_id`, `dept_id`, `colg_id`, `univ_id`, `ranking`) VALUES
(14041071222, 13, 7, 41, 2154, 0),
(14041071223, 31, 7, 41, 222, 0),
(540410107024, 33, 7, 41, 222, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hod`
--

CREATE TABLE `hod` (
  `user_id` int(10) NOT NULL,
  `enroll_no` bigint(12) NOT NULL,
  `dept_id` int(2) NOT NULL,
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `ranking` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hod`
--

INSERT INTO `hod` (`user_id`, `enroll_no`, `dept_id`, `colg_id`, `univ_id`, `ranking`) VALUES
(14, 14041071223, 7, 41, 2154, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `user_id` int(10) NOT NULL COMMENT 'This is a unique id assigned to every user',
  `enroll_no` bigint(12) NOT NULL COMMENT 'every member of universityy is assigned a unique number by it',
  `dept_id` int(2) DEFAULT NULL COMMENT 'dept id ',
  `colg_id` int(3) NOT NULL,
  `univ_id` int(11) NOT NULL,
  `year_of_passing` int(4) NOT NULL,
  `ranking` int(3) NOT NULL DEFAULT '0',
  `interest` text NOT NULL,
  `comp_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`user_id`, `enroll_no`, `dept_id`, `colg_id`, `univ_id`, `year_of_passing`, `ranking`, `interest`, `comp_id`) VALUES
(25, 6464, 7, 41, 222, 2018, 0, '', 0),
(38, 576767, 7, 41, 222, 98660, 0, '', 0),
(36, 949494, 7, 41, 222, 2018, 0, '', 0),
(44, 45845445, 7, 41, 222, 67677, 0, 'and', 0),
(46, 1404040404, 7, 41, 222, 60606, 0, 'nnnb', 0),
(51, 1404040440, 7, 41, 222, 97997, 0, 'zggz', 0),
(34, 15349799794, 7, 41, 222, 2018, 0, '', 0),
(39, 140370107559, 7, 42, 222, 2018, 0, '', 0),
(1, 140410107002, 7, 41, 0, 2018, 0, '', 877),
(3, 140410107003, 7, 41, 2154, 2017, 0, '', 877),
(26, 140410107004, 7, 41, 222, 2018, 0, '', 0),
(45, 140410107005, 7, 41, 222, 2018, 0, 'usa', 0),
(47, 140410107006, 7, 41, 222, 2018, 0, 'usa', 0),
(50, 140410107007, 7, 41, 222, 2018, 0, 'javac', 0),
(29, 140410107009, 7, 41, 222, 2018, 0, '', 0),
(30, 140410107010, 7, 41, 222, 2018, 0, '', 0),
(32, 140410107011, 7, 41, 222, 2018, 0, '', 0),
(35, 140410107012, 7, 41, 222, 2018, 0, '', 0),
(2, 140410107024, 7, 41, 0, 2018, 0, '', 877),
(24, 140410107025, 7, 41, 222, 2018, 0, '', 0),
(27, 140410107037, 7, 41, 222, 2018, 0, '', 0),
(37, 140410107045, 7, 41, 222, 2017, 0, '', 0),
(41, 1404101070003, 7, 41, 222, 2018, 0, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `user_id` varchar(10) NOT NULL,
  `uni_name` varchar(50) NOT NULL,
  `uni_id` varchar(5) NOT NULL,
  `website` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`user_id`, `uni_name`, `uni_id`, `website`) VALUES
('22', 'GTU', '222', 'gtu.ac.in');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `login_status` tinyint(1) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(10) NOT NULL,
  `profile_pic` varchar(150) DEFAULT NULL,
  `gender` int(1) NOT NULL COMMENT '0- male',
  `dob` varchar(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `contact` bigint(13) NOT NULL,
  `address` text NOT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `approved` tinyint(1) NOT NULL DEFAULT '0',
  `token` varchar(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `login_status`, `fname`, `lname`, `profile_pic`, `gender`, `dob`, `email`, `contact`, `address`, `user_type`, `approved`, `token`) VALUES
(1, '1234', 1, 'shabbir', 'bhaisaheb', '', 0, '2017-12-11', 'abc@gmail.com', 9033257850, '', 'student', 0, 'OPEVGBF'),
(2, '1234', 1, 'abhi', 'koranne', '', 0, '2017-12-11', 'abhishekkoranne@gmail.com', 9999999999, '', 'faculty', 1, '8XBCVE1'),
(3, '1234', 0, 'Shabbir', 'bhaisaheb', '', 0, '1996-09-15', 'shabbirhussainb@gmail.com', 9033257850, '', 'student', 1, NULL),
(4, '12345', 1, 'shabbir', 'bhaisaheb', '', 0, '15-09-1996', 'abhi@gmail.com', 9033257850, '', NULL, 1, NULL),
(5, '12345', 0, 'charu', 'bhadaurya', '', 1, '15-04-1996', 'avs@gasjb.com', 9233257850, 'abc bunglow, vadodara', NULL, 0, NULL),
(10, '12345', 0, 'ra', 'chan', '', 0, '15-04-1997', 'avs@gasb.com', 9233257855, 'ab bunglow, vadodara', NULL, 0, NULL),
(13, '123456', 0, 'nitin', 'patel', '', 0, '15-09-1986', 'avc@gasjb.com', 9033257750, 'aligadh', NULL, 0, NULL),
(14, '123456', 0, 'Bijal', 'talati', '', 1, '15-09-1976', 'avc@gasb.com', 9033254750, 'majalpura', NULL, 0, NULL),
(18, '123456', 0, 'jayesh', 'deshkar', '', 0, '15-09-1966', 'avc@gab.com', 9033257755, 'anand', NULL, 0, NULL),
(21, '123456', 0, 'jayesh', 'deshkar', '', 0, '15-09-1966', 'avc@ga.com', 9033257759, 'anand', NULL, 0, NULL),
(22, '123456', 0, 'ni', 'pa', '', 0, '15-09-1966', 'avc@gaqb.com', 9033257744, 'amdavad', NULL, 0, NULL),
(24, '12345', 0, 'absk', 'korr', '', 0, '15-04-1995', 'abss@gasb.com', 9233257855, 'abc bunglow, vadodara', NULL, 0, NULL),
(25, '1234', 0, 'hshdh', 'bznzn', '', 0, '24/04/1996', 'zhab@sjsj.com', 898979, 'dvdbdb', NULL, 0, NULL),
(26, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@gasb.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(27, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@asb.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(29, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@as.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(30, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@a.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(31, '123456', 0, 'niti', 'jain', '', 0, '15-09-1986', 'av@gasjb.com', 9033257750, 'aligadh', NULL, 0, NULL),
(32, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@add.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(33, '1234', 0, 'Hiren', 'Patel', '', 0, '25/06/1986', 'hirenpatel@gmail.com', 9556432256, 'Abcdef', NULL, 0, NULL),
(34, 'avc', 1, 'vineet', 'chotrani', '', 0, '05/03/1997', 'rajkumar@gmail.com', 9737486668, 'abc banglows, opp. juhu beach', NULL, 1, NULL),
(35, '12345', 0, 'abs', 'kor', '', 0, '15-04-1994', 'abqs@gmail.com', 92332578500, 'abc bunglow, vadodara', NULL, 0, NULL),
(36, 'hshs', 0, 'hzhzh', 'nxnxn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hzhzh//cropped2141461264.jpg', 0, '67/68//8', 'bxbz@hssj.djxkk', 9898, 'hxxhh', NULL, 0, NULL),
(37, '1234', 0, 'czvs', 'hzbz', 'EngBook\\src\\main\\resources\\images\\studentprofile\\czvs//cropped2095415195.jpg', 0, '24/04/1999', 'sghs@hshs.com', 9979794456, 'zbzbbz', NULL, 0, NULL),
(38, '1234', 1, 'vabz', 'vxbx', 'EngBook\\src\\main\\resources\\images\\studentprofile\\vabz//cropped686292479.jpg', 0, '52/55/', 'xyz@gmail.com', 7587877, 'tacV', NULL, 1, NULL),
(39, '1234', 0, 'jigish', 'vyas', 'EngBook\\src\\main\\resources\\images\\studentprofile\\jigish//imgDog.jpg', 0, '13-04-1996', 'vyas.jigish13@gmail.com', 7874056649, 'xyz bunglow, vadodara', NULL, 0, NULL),
(41, '1234', 0, 'anuj', 'bhrambhatt', 'EngBook\\src\\main\\resources\\images\\studentprofile\\anuj//imgDog.jpg', 0, '13-05-1996', 'anuj@gmail.com', 987654321, 'pqr bunglow, vadodara', NULL, 0, NULL),
(44, 'nzbzbz', 0, 'hzhAh', 'nznzn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hzhAh//cropped1440732062.jpg', 0, '2/2/5', 'jxnznzn', 659797979, 'hzhzhz', NULL, 0, NULL),
(45, '1234', 0, 'charles', 'patel', 'EngBook\\src\\main\\resources\\images\\studentprofile\\charles//imgDog.jpg', 0, '13-05-1997', 'charles@gmail.com', 987654320, 'qwertty bunglow, vadodara', NULL, 0, NULL),
(46, 'nnnn', 0, 'zsvsv', 'jdjxn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\zsvsv//cropped2073650192.jpg', 0, '5/5/5/', 'bddsh', 686867, 'bhzhzj', NULL, 0, NULL),
(47, '1234', 0, 'adutya', 'choksi', 'EngBook\\src\\main\\resources\\images\\studentprofile\\adutyachoksi@gmail.com//imonkey.jpg', 0, '13-05-1995', 'choksi@gmail.com', 987654322, 'qwertty bunglow, vadodara', NULL, 0, NULL),
(50, '12345', 0, 'hiral', 'dalwadi', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hiralhiral@gasb.com//Recylcer_View-Steps.png', 0, '15-04-1997', 'hiral@gasb.com', 923325755, 'ab bunglow, vadodara', NULL, 0, NULL),
(51, 'yzhzh', 0, 'zhzhHH', 'jHHJ', 'EngBook\\src\\main\\resources\\images\\studentprofile\\zhzhHHzhzhz//cropped739547515.jpg', 0, '97/6/6/8', 'zhzhz', 37677, 'hzjzh', NULL, 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answer_id`);

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `college`
--
ALTER TABLE `college`
  ADD PRIMARY KEY (`colg_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`comp_name`),
  ADD UNIQUE KEY `comp_name` (`comp_name`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`),
  ADD UNIQUE KEY `colg_id` (`colg_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id_2` (`colg_id`);

--
-- Indexes for table `doubts`
--
ALTER TABLE `doubts`
  ADD PRIMARY KEY (`doubt_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD UNIQUE KEY `enroll_no` (`enroll_no`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `univ_id` (`univ_id`);

--
-- Indexes for table `hod`
--
ALTER TABLE `hod`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `enroll_id` (`enroll_no`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `univ_id` (`univ_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`enroll_no`),
  ADD UNIQUE KEY `enroll_no_2` (`enroll_no`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `colg_id` (`colg_id`),
  ADD KEY `enroll_no` (`enroll_no`),
  ADD KEY `univ_id` (`univ_id`),
  ADD KEY `user_id_2` (`user_id`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`uni_id`),
  ADD UNIQUE KEY `uni_id` (`uni_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `uni_name` (`uni_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `email_2` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `answer_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `article_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '14 is the length of article id', AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `comment_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `doubts`
--
ALTER TABLE `doubts`
  MODIFY `doubt_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
