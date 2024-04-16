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

 Date: 16/04/2024 16:01:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for resort
-- ----------------------------
DROP TABLE IF EXISTS `resort`;
CREATE TABLE `resort` (
  `SkiResort` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Introduction` varchar(1450) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Location` varchar(145) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Website` varchar(145) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`SkiResort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of resort
-- ----------------------------
BEGIN;
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Killington Ski Resort', 'Known as \"The Beast of the East,\" Killington offers a variety of terrain across six peaks. Famous for its long skiing season and vibrant après-ski scene.', '4763 Killington Road, Killington, VT 05751', 'https://www.killington.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Mountain Sunapee Resort', 'Family-friendly ski resort in New Hampshire with over 65 trails and slopes designed for various skill levels.', '1398 Route 103, Newbury, NH 03255', 'https://www.mountsunapee.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Nashoba Valley Ski Area', 'A popular small ski area in Massachusetts, known for its accessibility to Boston and for hosting a variety of winter activities.', '79 Powers Road, Westford, MA 01886', 'https://www.skinashoba.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Okemo Mountain Resort', 'Located in Vermont, Okemo is known for its family-friendly amenities, excellent snow quality, and a commitment to service and quality.', '77 Okemo Ridge Road, Ludlow, VT 05149', 'https://www.okemo.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Pats Peak Ski Area', 'A family-owned ski resort in New Hampshire, offering varied terrain, night skiing, and a range of seasonal activities.', '686 Flanders Road, Henniker, NH 03242', 'https://www.patspeak.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Stowe Mountain Resort', 'Premier ski destination in Vermont known for its challenging terrain, upscale amenities, and historic village.', '5781 Mountain Road, Stowe, VT 05672', 'https://www.stowe.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Stratton Mountain', 'Offers a top-rated ski and snowboard school in Vermont, with diverse terrain and vibrant village life.', '5 Village Lodge Road, Stratton Mountain, VT 05155', 'https://www.stratton.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Sunday River Resort', 'Known for its eight interconnected mountain peaks, extensive snowmaking, and year-round activities in Maine.', '15 South Ridge Road, Newry, ME 04261', 'https://www.sundayriver.com');
INSERT INTO `resort` (`SkiResort`, `Introduction`, `Location`, `Website`) VALUES ('Wachusett Mountain Ski Area', 'Located in Massachusetts, Wachusett is known for its accessible location and night skiing, catering to families and day-trippers from Boston.', '499 Mountain Road, Princeton, MA 01541', 'https://www.wachusett.com');
COMMIT;

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
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('12432', '2024-04-16 15:39:00', 'Pats Peak Ski Area', 3.00, 'Close too early');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('qewq', '2024-04-16 15:43:32', 'Jay Peak Resort', 1.00, 'Nooo');
INSERT INTO `UserRate` (`Username`, `Time`, `SkiResort`, `Rate`, `Content`) VALUES ('qewq', '2024-04-16 15:43:56', 'Wachusett Mountain Ski Area', 10.00, 'Goooood');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
