/*
 Navicat Premium Data Transfer

 Source Server         : SKIRESORT
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : SKIRESORT

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 14/04/2024 16:14:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for UserRate
-- ----------------------------
DROP TABLE IF EXISTS `UserRate`;
CREATE TABLE `UserRate` (
  `Username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Time` datetime NOT NULL,
  `SkiResort` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `Rate` decimal(4,2) NOT NULL,
  `Content` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of UserRate
-- ----------------------------
BEGIN;
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('123', '2024-04-13 02:52:47', 'Killington Ski Resort', 10.00, 'Perfect');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('123', '2024-04-13 02:54:48', 'Killington Ski Resort', 10.00, 'Good');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('123', '2024-04-13 02:55:40', 'Killington Ski Resort', 10.00, 'qwe');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('User1', '2024-04-13 02:55:40', 'Killington Ski Resort', 10.00, 'Perfect');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('234', '2024-04-13 03:03:55', 'Wachusett Mountain Ski Area', 7.00, 'Fine');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('234', '2024-04-13 03:04:08', 'Pats Peak Ski Area', 8.00, 'Good');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('234', '2024-04-13 03:04:22', 'Okemo Mountain Resort', 5.00, 'Too far');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('345', '2024-04-13 03:04:43', 'Stratton Mountain', 10.00, 'Nice resort');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('345', '2024-04-13 03:05:01', 'Sunday River Resort', 4.00, 'Hard icy');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('999', '2024-04-13 03:07:00', 'Nashoba Valley Ski Area', 2.00, 'BAD');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('000', '2024-04-14 01:48:58', 'Sunday River Resort', 4.00, 'Not good');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('000', '2024-04-14 01:49:20', 'Stowe Mountain Resort', 9.00, 'Very nice!!!');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('000', '2024-04-14 01:49:43', 'Mountain Sunapee Resort', 10.00, 'Not too far, the snow condition is good');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('Derrick', '2024-04-14 04:09:36', 'Pats Peak Ski Area', 6.00, 'The distance is good');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('Derrick', '2024-04-14 04:09:55', 'Mountain Sunapee Resort', 10.00, 'Many black trail');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('Chris', '2024-04-14 04:14:10', 'Wachusett Mountain Ski Area', 1.00, 'Bad');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('An Lu', '2024-04-14 04:17:13', 'Wachusett Mountain Ski Area', 3.00, 'So badddd');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('Yufei', '2024-04-14 15:44:45', 'Killington Ski Resort', 9.00, 'Nice but far');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
