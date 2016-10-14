DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `phone_no` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `id_number` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `descrip` varchar(255) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


DROP TABLE IF EXISTS `tbl_appointment`;
CREATE TABLE `tbl_appointment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `app_user_name` varchar(100) DEFAULT NULL COMMENT '预约人姓名',
  `app_phone_no` varchar(30) DEFAULT NULL COMMENT '预约人电话',
  `app_affair` int(2) DEFAULT NULL COMMENT '预约事务数量',
  `app_date` datetime DEFAULT NULL COMMENT '预约日期',
  `app_time_slot` int(2) DEFAULT NULL COMMENT '预约时间段',
  `app_status` tinyint(1) DEFAULT '1' COMMENT '预约状态1正常0取消',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约表';


DROP TABLE IF EXISTS `dic_time_slot`;
CREATE TABLE `dic_time_slot` (
  `value` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '时间段设置',
  `status` varchar(255) DEFAULT '1' COMMENT '开关 0表示关闭不可见1表示开启可见',
  PRIMARY KEY (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='时间段设置';
