-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2018 at 01:06 PM
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
  `answer_image` varchar(150) DEFAULT NULL,
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
(8, 2, 4, 'My answer@QueryProjectionIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 0, 0, NULL, 1521964336770),
(9, 1, 1, 'Hello shabbie', 0, 0, 'EngBook\\src\\main\\resources\\images\\article\\shabbir//cropped4328461393153069089.jpg', 1526035453656);

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
  `article_image` varchar(150) DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `type` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`user_id`, `dept_id`, `article_id`, `likes`, `article_type`, `article_text`, `article_image`, `create_time`, `type`) VALUES
(1, 7, 1, 2, 1, 'There is a new research work going on in messachusets university on Quantum computing. Refer Link: qis.mit.edu', NULL, 0, 1),
(3, 7, 2, 13, 1, 'There is a new research work going on in messachusets university on Quantum computing. Refer Link: qis.mit.edu', NULL, 0, 1),
(2, 7, 3, 4, 1, 'I have found a way of reducing the time complexity of Matrix multiplication to the order of n^2', NULL, 0, 1),
(2, 7, 4, 0, 0, 'I have found that TCS has got few interesting projects, so we have good prospectus if we get selected', NULL, 0, 0),
(55, 7, 5, 0, 0, 'Read My blog here on Artificial intelligence. ........', NULL, 1521963516863, 1),
(1, 7, 6, 1, 0, '\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"', '', 0, 1),
(1, 7, 7, 1, 0, 'Today Google I/O event will commence, some cool features are expected to hit the floor.\r\n', '', 0, 1),
(1, 7, 8, 0, 1, 'The I/O event was really awesome some cool features added;)', NULL, 1525951465683, 1),
(2, 7, 9, 0, 1, 'IOS developer required in quicksoftware at vadodara ', 'EngBook\\src\\main\\resources\\images\\article\\abhi//cropped6520627664181305469.jpg', 1525953399031, 0),
(2, 7, 10, 0, 1, 'bhh', 'EngBook\\src\\main\\resources\\images\\article\\abhi//cropped-1736815639.jpg', 1526034281535, 0);

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
('63', '115', 41, 'SVIT', 'svitvasad.ac.in', 9976479956, 'Ajit');

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
(2, 3, 3, 'my comment', 1521964146798),
(1, 4, 2, 'Hello there this is a comment', 1525955266622),
(1, 5, 2, 'This is Abhishek commenting', 1525955330448),
(1, 6, 2, 'comment', 1526025558331),
(2, 7, 2, 'comenting', 1526025746916),
(3, 8, 2, 'good article', 1526025780586),
(3, 9, 2, 'test comment', 1526025938852),
(2, 10, 2, 'pavan', 1526026219994),
(2, 11, 2, '.', 1526026245398),
(2, 12, 2, 'temp', 1526026369384),
(2, 13, 2, 'fjte4ui', 1526117397393);

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
(7, 'Computer', 'BijalTalati', 0, 41);

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
  `doubt_image` varchar(150) DEFAULT NULL,
  `tag` varchar(100) NOT NULL,
  `upvotes` int(11) NOT NULL,
  `downvotes` int(11) NOT NULL,
  `create_time` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doubts`
--

INSERT INTO `doubts` (`doubt_id`, `user_id`, `dept_id`, `heading`, `text`, `doubt_image`, `tag`, `upvotes`, `downvotes`, `create_time`) VALUES
(1, 1, 7, 'Help me', 'Not able to start prolog', NULL, 'java', 2, 2, 0),
(2, 2, 7, 'Having Problem in database', 'how to create a composite key in mysql', NULL, 'android', 10, 2, 1522392314740),
(3, 2, 7, 'Unable to get data', 'I am not able to get the image stored on server in spring boot', NULL, 'C', 15, 3, 1522175400000),
(4, 3, 7, 'Php my admin not responding', 'i am not landed to home page of phpmyadmin when i type local host. It is instead showing my error in response', NULL, 'C', 22, 10, 0),
(5, 4, 7, 'unable to start tomcat server', 'i am using IntelliJ Ideal C for developing spring boot, but when i am trying to start the server, it is asking me to setup server, though it is not asked normally', NULL, 'C', 0, 0, 0),
(6, 5, 7, 'help!', 'How to Install JDK on my laptop', NULL, 'C', 0, 0, 0),
(7, 4, 7, 'C program not compiling using Mingw', 'I am using command shell to compile my c program using mingw. But it is not recognizing MingW compiler', NULL, 'C', 0, 0, 1521961765869),
(8, 3, 7, 'java doubt', 'How to handle Multithreading in java', NULL, 'C', 0, 0, 1521962446504),
(9, 1, 7, 'javac', 'Javac is not a recognised commad is shown in cmd when i am trying to compile the java program', '', 'java', 1, 1, 0),
(10, 1, 7, 'java Servlet', 'Should i use java servlet instead of Spring for a light weighted application?', '', 'abc', 1, 1, 0),
(11, 1, 7, 'python', 'How to handle Unknown State Exception in python?', '', 'perl', 1, 1, 0),
(12, 1, 7, 'spark', 'how much time i need to spend to learn spark if i know the basic of c?', NULL, 'spark', 1, 1, 0),
(13, 1, 7, 'spring boot', 'Is Spring Boot the best framework to use if developing service in java?', '', 'java', 1, 1, 0),
(14, 2, 7, 'C++', 'Why is Multiple Inheritance supported in c++?', 'EngBook\\src\\main\\resources\\images\\article\\abhi//cropped3788546212189329254.jpg', 'Vodafone', 0, 0, 1525953633631),
(15, 2, 7, 'vbh', 'ghj', 'EngBook\\src\\main\\resources\\images\\article\\abhi//cropped-1132663316.jpg', 'vbh', 0, 0, 1526034335920);

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
(1404679567, 56, 7, 41, 222, 0),
(14041071222, 13, 7, 41, 2154, 0),
(14041071223, 31, 7, 41, 222, 0),
(140412107056, 53, 7, 41, 222, 0),
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
(66, 109764794653, 7, 41, 115, 0);

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
(52, 140410107055, 7, 41, 222, 2018, 0, 'Android', 0),
(54, 140423652852, 7, 41, 222, 2018, 0, 'Java', 0),
(55, 143410108056, 7, 41, 222, 2018, 0, 'Android', 0),
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
('62', 'GTU', '115', 'gtu.ac.in');

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
  `email` varchar(50) NOT NULL,
  `contact` bigint(13) NOT NULL,
  `address` text NOT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `approved` tinyint(1) NOT NULL DEFAULT '1',
  `token` varchar(7) DEFAULT NULL,
  `fcmtoken` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `login_status`, `fname`, `lname`, `profile_pic`, `gender`, `dob`, `email`, `contact`, `address`, `user_type`, `approved`, `token`, `fcmtoken`) VALUES
(1, '1234', 1, 'shabbir', 'hussain', NULL, 0, '2017-12-11', 'abc@gmail.com', 9033257850, '', 'student', 1, 'UWF0IX1', NULL),
(2, '1234', 1, 'abhi', 'koranne', NULL, 0, '2017-12-11', 'abhishekkoranne@gmail.com', 9999999999, '', 'faculty', 1, '2M51KCY', NULL),
(3, '1234', 1, 'Shabbir', 'bhaisaheb', NULL, 0, '1996-09-15', 'shabbirhussainb@gmail.com', 9033257850, '', 'student', 1, NULL, NULL),
(4, '1234', 1, 'vineet', 'chotrani', NULL, 0, '15-09-1996', 'abhi@gmail.com', 9033257850, '', NULL, 1, NULL, NULL),
(5, '12345', 1, 'charu', 'bhadaurya', NULL, 1, '15-04-1996', 'avs@gasjb.com', 9233257850, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(10, '12345', 1, 'raj', 'chanpura', NULL, 0, '15-04-1997', 'avs@gasb.com', 9233257855, 'ab bunglow, vadodara', NULL, 1, NULL, ''),
(13, '123456', 1, 'nitin', 'patel', NULL, 0, '15-09-1986', 'avc@gasjb.com', 9033257750, 'aligadh', NULL, 1, NULL, ''),
(14, '123456', 1, 'Bijal', 'talati', NULL, 1, '15-09-1976', 'avc@gasb.com', 9033254750, 'majalpura', NULL, 1, NULL, ''),
(18, '123456', 1, 'jayesh', 'deshkar', NULL, 0, '15-09-1966', 'avc@gab.com', 9033257755, 'anand', NULL, 1, NULL, ''),
(21, '123456', 1, 'jayesh', 'deshkar', NULL, 0, '15-09-1966', 'avc@ga.com', 9033257759, 'anand', NULL, 1, NULL, ''),
(22, '123456', 1, 'ni', 'pa', NULL, 0, '15-09-1966', 'avc@gaqb.com', 9033257744, 'amdavad', NULL, 1, NULL, ''),
(24, '12345', 1, 'absk', 'korr', NULL, 0, '15-04-1995', 'abss@gasb.com', 9233257855, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(25, '1234', 1, 'hshdh', 'bznzn', NULL, 0, '24/04/1996', 'dhruvalnandurkar25@gmail.com', 898979, 'dvdbdb', NULL, 1, 'YSQ50C4', ''),
(26, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@gasb.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(27, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@asb.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(29, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@as.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(30, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@a.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(31, '123456', 1, 'niti', 'jain', NULL, 0, '15-09-1986', 'av@gasjb.com', 9033257750, 'aligadh', NULL, 1, NULL, ''),
(32, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@add.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(33, '1234', 1, 'Hiren', 'Patel', NULL, 0, '25/06/1986', 'hirenpatel@gmail.com', 9556432256, 'Abcdef', NULL, 1, NULL, ''),
(34, 'avc', 1, 'vineet', 'chotrani', NULL, 0, '05/03/1997', 'rajkumar@gmail.com', 9737486668, 'abc banglows, opp. juhu beach', NULL, 1, NULL, ''),
(35, '12345', 1, 'abs', 'kor', NULL, 0, '15-04-1994', 'abqs@gmail.com', 92332578500, 'abc bunglow, vadodara', NULL, 1, NULL, ''),
(36, 'hshs', 1, 'hzhzh', 'nxnxn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hzhzh//cropped2141461264.jpg', 0, '67/68//8', 'bxbz@hssj.djxkk', 9898, 'hxxhh', NULL, 1, NULL, ''),
(37, '1234', 1, 'czvs', 'hzbz', 'EngBook\\src\\main\\resources\\images\\studentprofile\\czvs//cropped2095415195.jpg', 0, '24/04/1999', 'sghs@hshs.com', 9979794456, 'zbzbbz', NULL, 1, NULL, ''),
(38, '1234', 1, 'vabz', 'vxbx', 'EngBook\\src\\main\\resources\\images\\studentprofile\\vabz//cropped686292479.jpg', 0, '52/55/', 'xyz@gmail.com', 7587877, 'tacV', NULL, 1, NULL, ''),
(39, '1234', 1, 'jigish', 'vyas', 'EngBook\\src\\main\\resources\\images\\studentprofile\\jigish//imgDog.jpg', 0, '13-04-1996', 'vyas.jigish13@gmail.com', 7874056649, 'xyz bunglow, vadodara', NULL, 1, NULL, ''),
(41, '1234', 1, 'anuj', 'bhrambhatt', 'EngBook\\src\\main\\resources\\images\\studentprofile\\anuj//imgDog.jpg', 0, '13-05-1996', 'anuj@gmail.com', 987654321, 'pqr bunglow, vadodara', NULL, 1, NULL, ''),
(44, 'nzbzbz', 1, 'hzhAh', 'nznzn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hzhAh//cropped1440732062.jpg', 0, '2/2/5', 'jxnznzn', 659797979, 'hzhzhz', NULL, 1, NULL, ''),
(45, '1234', 1, 'charles', 'patel', 'EngBook\\src\\main\\resources\\images\\studentprofile\\charles//imgDog.jpg', 0, '13-05-1997', 'charles@gmail.com', 987654320, 'qwertty bunglow, vadodara', NULL, 1, NULL, ''),
(46, 'nnnn', 1, 'zsvsv', 'jdjxn', 'EngBook\\src\\main\\resources\\images\\studentprofile\\zsvsv//cropped2073650192.jpg', 0, '5/5/5/', 'bddsh', 686867, 'bhzhzj', NULL, 1, NULL, ''),
(47, '1234', 1, 'adutya', 'choksi', 'EngBook\\src\\main\\resources\\images\\studentprofile\\adutyachoksi@gmail.com//imonkey.jpg', 0, '13-05-1995', 'choksi@gmail.com', 987654322, 'qwertty bunglow, vadodara', NULL, 1, NULL, ''),
(50, '12345', 1, 'hiral', 'dalwadi', 'EngBook\\src\\main\\resources\\images\\studentprofile\\hiralhiral@gasb.com//Recylcer_View-Steps.png', 0, '15-04-1997', 'hiral@gasb.com', 923325755, 'ab bunglow, vadodara', NULL, 1, NULL, ''),
(51, 'yzhzh', 1, 'zhzhHH', 'jHHJ', 'EngBook\\src\\main\\resources\\images\\studentprofile\\zhzhHHzhzhz//cropped739547515.jpg', 0, '97/6/6/8', 'zhzhz', 37677, 'hzjzh', NULL, 1, NULL, ''),
(52, '1234', 1, 'Testing', 'test2', 'EngBook\\src\\main\\resources\\images\\studentprofile\\Testingtest@gm.com//cropped3389815436151722392.jpg', 0, '24/06/96', 'test@gm.com', 9865326495, 'Addr test', NULL, 1, NULL, ''),
(53, '1234', 1, 'Ahg', 'Dhg', 'EngBook\\src\\main\\resources\\images\\facultyprofile\\Ahgahgdhg@gm.com//cropped1289601764654773252.jpg', 0, '24/06/96', 'ahgdhg@gm.com', 9809524456, 'addr', NULL, 1, NULL, ''),
(54, '1234', 1, 'Jigyo', 'dtg', 'EngBook\\src\\main\\resources\\images\\studentprofile\\Jigyojigdtg@gm.com//cropped622624522575756991.jpg', 0, '8/4/17', 'jigdtg@gm.com', 9909064432, 'ST Depo', NULL, 1, NULL, ''),
(55, '1234', 1, 'Jigyo', 'Vyas', 'EngBook\\src\\main\\resources\\images\\studentprofile\\Jigyojigyovyas@gm.com//cropped3573231640901492446.jpg', 0, '13/04/1996', 'jigyovyas@gm.com', 9946413346, 'Airport', 'student', 1, NULL, ''),
(56, '1234', 1, 'Jigido', 'vyaso', 'EngBook\\src\\main\\resources\\images\\facultyprofile\\Jigidojigido@gm.com//cropped1328054556285155453.jpg', 0, '8/02/2018', 'jigido@gm.com', 9090909990, 'St', 'faculty', 1, NULL, ''),
(62, '1234', 1, 'Yash', 'Shah', 'EngBook\\src\\main\\resources\\images\\chancellorprofile\\Yashchancellor@gtu.ac.in//cropped8855105068794818558.jpg', 0, '4/2/1970', 'chancellor@gtu.ac.in', 9976456679, 'Gandhinagar', 'chancellor', 1, NULL, NULL),
(63, '1234', 1, 'Jayesh', 'Deshkar', 'EngBook\\src\\main\\resources\\images\\principalprofile\\Jayeshprincipal@svitvasad.ac//cropped1844086428351372032.jpg', 0, '4/2/1978', 'principal@svitvasad.ac', 9976431156, 'Vadodara', 'principal', 1, NULL, NULL),
(66, '1234', 1, 'Bijal', 'Talati', 'EngBook\\src\\main\\resources\\images\\hodprofile\\Bijalhod@svitvasad.ac.in//cropped3175508087658863470.jpg', 1, '4/6/1986', 'hod@svitvasad.ac.in', 9976451123, 'Vadodara', 'hod', 1, NULL, NULL);

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
  MODIFY `answer_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `article_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '14 is the length of article id', AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `comment_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `doubts`
--
ALTER TABLE `doubts`
  MODIFY `doubt_id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
