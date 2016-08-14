
-- 贷款期限
DROP TABLE IF EXISTS `dic_loan_term`;
CREATE TABLE `dic_loan_term` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(2) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款期限';


--  贷款产品类别
DROP TABLE IF EXISTS `dic_loan_type`;
CREATE TABLE `dic_loan_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(2) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款产品类别';


-- 首付比例
DROP TABLE IF EXISTS `dic_payment_ratio`;
CREATE TABLE `dic_payment_ratio` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(2) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首付比例';


-- 手机号码-试算
DROP TABLE IF EXISTS `tbl_phone_info`;
CREATE TABLE `tbl_phone_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_no` int(1) DEFAULT '0',
  `IP` varchar(13) DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试算手机号码';


-- 人员基本信息
DROP TABLE IF EXISTS `tbl_user_baseinfo`;
CREATE TABLE `tbl_user_baseinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT '' COMMENT '姓名',
  `card_no` varchar(18) DEFAULT '0' COMMENT '身份证信息',
  `phone_no` int(1) DEFAULT '0',
  `email` varchar(100) DEFAULT '0',
  `addtime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `add_ip` varchar(255) DEFAULT NULL COMMENT '注册ip地址',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录地址',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户基础信息';

