/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : hospital_system

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 26/06/2019 21:52:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assignment
-- ----------------------------
DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment`  (
  `registerid` int(11) NOT NULL COMMENT '挂号处',
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人',
  `doctor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分配医生',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约时间',
  `num` int(3) NOT NULL COMMENT '预约号码',
  INDEX `registerid`(`registerid`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  INDEX `doctor`(`doctor`) USING BTREE,
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `fee` decimal(10, 0) NULL DEFAULT NULL COMMENT '收费',
  `register` int(11) NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `register`(`register`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `charge_ibfk_1` FOREIGN KEY (`register`) REFERENCES `register` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `charge_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL COMMENT '科室id',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '二楼', '内科', '123132312');
INSERT INTO `dept` VALUES (2, '二楼', '外科', '23213213123');
INSERT INTO `dept` VALUES (3, '五楼', '妇科', '22223333');
INSERT INTO `dept` VALUES (4, '四楼', '儿科', '1312312');
INSERT INTO `dept` VALUES (5, '三楼', '精神科', '666666');
INSERT INTO `dept` VALUES (6, '三楼', '神经科', '111111');
INSERT INTO `dept` VALUES (7, '四楼', '肿瘤科', '5666666');
INSERT INTO `dept` VALUES (8, '三楼', '皮肤科', '88888');
INSERT INTO `dept` VALUES (9, '三楼', '五官科', '333333');
INSERT INTO `dept` VALUES (10, '四楼', '放射科', '99999');
INSERT INTO `dept` VALUES (11, '五楼', '口腔科', '33333');
INSERT INTO `dept` VALUES (13, '四楼', '中医', '887777');

-- ----------------------------
-- Table structure for diagnose
-- ----------------------------
DROP TABLE IF EXISTS `diagnose`;
CREATE TABLE `diagnose`  (
  `doctor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
  INDEX `doctor`(`doctor`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `diagnose_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `diagnose_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diagnose
-- ----------------------------
INSERT INTO `diagnose` VALUES ('123', '123', '哈哈哈哈哈哈哈哈哈哈或');
INSERT INTO `diagnose` VALUES ('123456', '123456', 'hhhhhhh');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('123', 'jack', '123', '主治医师', '123', '内科');
INSERT INTO `doctor` VALUES ('123456', 'jack', '123456', '主任医生', '123', '儿科');
INSERT INTO `doctor` VALUES ('doctor2', 'Jack', '66666666', '副主任医师', '123', '五官科');

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug`  (
  `id` int(11) NOT NULL,
  `classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES (1, '抗生素类药品', 129, '青霉素');
INSERT INTO `drug` VALUES (2, '抗生素类药品', 130, '阿莫西林');
INSERT INTO `drug` VALUES (3, '注射剂类药品', 60, '盐酸布比卡因注射液');
INSERT INTO `drug` VALUES (4, '注射剂类药品', 690, '注射用泮托拉䂳钠');

-- ----------------------------
-- Table structure for drugclassify
-- ----------------------------
DROP TABLE IF EXISTS `drugclassify`;
CREATE TABLE `drugclassify`  (
  `classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`classify`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugclassify
-- ----------------------------
INSERT INTO `drugclassify` VALUES ('五官科用药');
INSERT INTO `drugclassify` VALUES ('呼吸系统用药');
INSERT INTO `drugclassify` VALUES ('妇科用药');
INSERT INTO `drugclassify` VALUES ('心脑血管用药');
INSERT INTO `drugclassify` VALUES ('抗生素类药品');
INSERT INTO `drugclassify` VALUES ('抗精神病用药');
INSERT INTO `drugclassify` VALUES ('抗肿瘤用药');
INSERT INTO `drugclassify` VALUES ('抗风湿类药品');
INSERT INTO `drugclassify` VALUES ('泌尿系统用药');
INSERT INTO `drugclassify` VALUES ('注射剂类药品');
INSERT INTO `drugclassify` VALUES ('消化系统用药');
INSERT INTO `drugclassify` VALUES ('清热解毒药品');
INSERT INTO `drugclassify` VALUES ('滋补类药品');
INSERT INTO `drugclassify` VALUES ('激素类药品');
INSERT INTO `drugclassify` VALUES ('皮肤科用药');
INSERT INTO `drugclassify` VALUES ('糖尿病用药');
INSERT INTO `drugclassify` VALUES ('维生素、矿物质药品');
INSERT INTO `drugclassify` VALUES ('血液系统用药');
INSERT INTO `drugclassify` VALUES ('阻断药');

-- ----------------------------
-- Table structure for drugpurchase
-- ----------------------------
DROP TABLE IF EXISTS `drugpurchase`;
CREATE TABLE `drugpurchase`  (
  `drugid` int(11) NULL DEFAULT NULL,
  `drugstoreid` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  INDEX `drugid`(`drugid`) USING BTREE,
  INDEX `drugstoreid`(`drugstoreid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugpurchase
-- ----------------------------
INSERT INTO `drugpurchase` VALUES (1, 1, 1);
INSERT INTO `drugpurchase` VALUES (1, 1, 1);
INSERT INTO `drugpurchase` VALUES (2, 2, 10);
INSERT INTO `drugpurchase` VALUES (1, 5, 5);
INSERT INTO `drugpurchase` VALUES (2, 4, 5);
INSERT INTO `drugpurchase` VALUES (3, 3, 1);
INSERT INTO `drugpurchase` VALUES (4, 3, 1);
INSERT INTO `drugpurchase` VALUES (1, 2, 3);
INSERT INTO `drugpurchase` VALUES (2, 5, 8);
INSERT INTO `drugpurchase` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for drugstore
-- ----------------------------
DROP TABLE IF EXISTS `drugstore`;
CREATE TABLE `drugstore`  (
  `id` int(11) NOT NULL COMMENT '药厂id',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugstore
-- ----------------------------
INSERT INTO `drugstore` VALUES (1, '前湖大道696号', '1232132', '太极集团');
INSERT INTO `drugstore` VALUES (2, '滨江大道666号', '66666666', '哈药集团');
INSERT INTO `drugstore` VALUES (3, '上海XXX', '12345678977', '上海医药有限公司');
INSERT INTO `drugstore` VALUES (4, '山东*****', '2333333', '山东东阿阿胶集团有限责任公司');
INSERT INTO `drugstore` VALUES (5, '江苏#####', '22222222', '江苏扬子江药业集团公司');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `doctor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '化验检查结果',
  INDEX `doctor`(`doctor`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('123', '123', '红红火火恍恍惚惚');
INSERT INTO `exam` VALUES ('123456', '123456', 'hhhhh');

-- ----------------------------
-- Table structure for getcard
-- ----------------------------
DROP TABLE IF EXISTS `getcard`;
CREATE TABLE `getcard`  (
  `registerid` int(11) NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办卡卡号',
  INDEX `registerid`(`registerid`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `getcard_ibfk_1` FOREIGN KEY (`registerid`) REFERENCES `register` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `getcard_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for getdrug
-- ----------------------------
DROP TABLE IF EXISTS `getdrug`;
CREATE TABLE `getdrug`  (
  `drugid` int(11) NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL COMMENT '取药数量',
  INDEX `drugid`(`drugid`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `getdrug_ibfk_1` FOREIGN KEY (`drugid`) REFERENCES `drug` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `getdrug_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of getdrug
-- ----------------------------
INSERT INTO `getdrug` VALUES (1, '123', 1);

-- ----------------------------
-- Table structure for injection
-- ----------------------------
DROP TABLE IF EXISTS `injection`;
CREATE TABLE `injection`  (
  `doctor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drugid` int(11) NULL DEFAULT NULL COMMENT '静脉注射药物',
  `amount` int(11) NULL DEFAULT NULL,
  INDEX `doctor`(`doctor`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  INDEX `drugid`(`drugid`) USING BTREE,
  CONSTRAINT `injection_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `injection_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `injection_ibfk_3` FOREIGN KEY (`drugid`) REFERENCES `drug` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of injection
-- ----------------------------
INSERT INTO `injection` VALUES ('123', '123', 3, 2);
INSERT INTO `injection` VALUES ('123', '123', 1, 1);
INSERT INTO `injection` VALUES ('123456', '123456', 3, 1);
INSERT INTO `injection` VALUES ('123456', '123456', 4, 1);

-- ----------------------------
-- Table structure for ordernumber
-- ----------------------------
DROP TABLE IF EXISTS `ordernumber`;
CREATE TABLE `ordernumber`  (
  `doctor_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生账号',
  `date` date NOT NULL COMMENT '日期',
  `time` int(1) NOT NULL COMMENT '1为上午，2为下午',
  `number` int(3) NOT NULL COMMENT '挂号号码',
  `is_order` int(1) NOT NULL COMMENT '是否被预约',
  PRIMARY KEY (`doctor_account`, `date`, `time`, `number`) USING BTREE,
  CONSTRAINT `ordernumber_ibfk_1` FOREIGN KEY (`doctor_account`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ordernumber
-- ----------------------------
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 1, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 2, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 3, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 4, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 5, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 6, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 7, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 8, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 9, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 10, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 11, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 12, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 13, 1);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 14, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 15, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 16, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 17, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 18, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 19, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-24', 2, 20, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 1, 1);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 2, 1);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 3, 1);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 4, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 5, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 6, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 7, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 8, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 9, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 10, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 11, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 12, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 13, 1);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 14, 0);
INSERT INTO `ordernumber` VALUES ('123456', '2019-06-26', 1, 15, 0);

-- ----------------------------
-- Table structure for ordertime
-- ----------------------------
DROP TABLE IF EXISTS `ordertime`;
CREATE TABLE `ordertime`  (
  `doctor_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生账号',
  `day` int(2) NOT NULL COMMENT '0表示周日，1表示周一，依此类推',
  `morning` int(1) NULL DEFAULT NULL COMMENT '早上是否可预约,1为可预约，0为不可预约',
  `mor_all_num` int(3) NULL DEFAULT NULL COMMENT '早上可预约的号码数量',
  `mor_left_num` int(3) NULL DEFAULT NULL COMMENT '早上已经预约的号码数量',
  `afternoon` int(1) NULL DEFAULT NULL COMMENT '下午是否可预约',
  `aft_all_num` int(3) NULL DEFAULT NULL COMMENT '下午可预约的号码数量',
  `aft_left_num` int(3) NULL DEFAULT NULL COMMENT '下午已经预约的号码数量',
  INDEX `ordertime_ibfk_1`(`doctor_account`) USING BTREE,
  CONSTRAINT `ordertime_ibfk_1` FOREIGN KEY (`doctor_account`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ordertime
-- ----------------------------
INSERT INTO `ordertime` VALUES ('123456', 0, 0, 15, 15, 0, 20, 20);
INSERT INTO `ordertime` VALUES ('123456', 1, 1, 15, 15, 1, 20, 19);
INSERT INTO `ordertime` VALUES ('123456', 2, 0, 15, 15, 1, 20, 20);
INSERT INTO `ordertime` VALUES ('123456', 3, 1, 15, 10, 1, 20, 20);
INSERT INTO `ordertime` VALUES ('123456', 4, 1, 15, 15, 0, 20, 20);
INSERT INTO `ordertime` VALUES ('123456', 5, 1, 15, 15, 1, 20, 20);
INSERT INTO `ordertime` VALUES ('123456', 6, 0, 15, 15, 1, 20, 20);

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` tinyint(4) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('123', 'jerry', '159777', 12, 0, '123');
INSERT INTO `patient` VALUES ('123456', 'tom', '123456', 20, 1, '123456');
INSERT INTO `patient` VALUES ('patient', '春游', '15970826302', 22, 1, '123456');

-- ----------------------------
-- Table structure for pharmacyadmin
-- ----------------------------
DROP TABLE IF EXISTS `pharmacyadmin`;
CREATE TABLE `pharmacyadmin`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药房管理员编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pharmacyadmin
-- ----------------------------
INSERT INTO `pharmacyadmin` VALUES ('123', 'hhh', '123456', '123');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `doctor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drugid` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  INDEX `doctor`(`doctor`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  INDEX `durgid`(`drugid`) USING BTREE,
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prescription_ibfk_3` FOREIGN KEY (`drugid`) REFERENCES `drug` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('123456', '123456', 1, 1);
INSERT INTO `prescription` VALUES ('123456', '123456', 2, 1);
INSERT INTO `prescription` VALUES ('123456', '123456', 3, 1);
INSERT INTO `prescription` VALUES ('123456', '123456', 4, 1);

-- ----------------------------
-- Table structure for registe
-- ----------------------------
DROP TABLE IF EXISTS `registe`;
CREATE TABLE `registe`  (
  `registerid` int(11) NULL DEFAULT NULL COMMENT '挂号处编号',
  `patient` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人',
  `num` int(11) NULL DEFAULT NULL COMMENT '挂号号码',
  INDEX `registerid`(`registerid`) USING BTREE,
  INDEX `patient`(`patient`) USING BTREE,
  CONSTRAINT `registe_ibfk_1` FOREIGN KEY (`registerid`) REFERENCES `register` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registe_ibfk_2` FOREIGN KEY (`patient`) REFERENCES `patient` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `id` int(255) NOT NULL COMMENT '挂号处编号',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for systemadmin
-- ----------------------------
DROP TABLE IF EXISTS `systemadmin`;
CREATE TABLE `systemadmin`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemadmin
-- ----------------------------
INSERT INTO `systemadmin` VALUES ('admin', 'Jerry', '123456', '123');

-- ----------------------------
-- Triggers structure for table drugpurchase
-- ----------------------------
DROP TRIGGER IF EXISTS `add_stock`;
delimiter ;;
CREATE TRIGGER `add_stock` AFTER INSERT ON `drugpurchase` FOR EACH ROW BEGIN
	UPDATE drug set stock=stock+NEW.amount where NEW.drugid=drug.id;
	END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table getdrug
-- ----------------------------
DROP TRIGGER IF EXISTS `substact_stock`;
delimiter ;;
CREATE TRIGGER `substact_stock` AFTER INSERT ON `getdrug` FOR EACH ROW BEGIN
	UPDATE drug set stock=stock-NEW.quantity where NEW.drugid=drug.id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
