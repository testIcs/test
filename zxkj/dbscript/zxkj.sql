CREATE TABLE `tbl_apply_money` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '提现申请ID' ,
`applyFlow_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '申请业务流水号(Yyyymmdd-uuid)' ,
`user_id`  int(10) NULL DEFAULT NULL COMMENT '提现用户id' ,
`apply_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '申请提现金额' ,
`beginApply_date`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请开始日期' ,
`endApply_date`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请结束日期' ,
`apply_status`  int(10) NULL DEFAULT NULL COMMENT '提现申请状态(0:申请中，1：申请通过，2：申请未通过)' ,
`paygate_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现申请渠道类型' ,
`account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现申请账号' ,
`real_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='提现申请表'
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;


CREATE TABLE `tbl_audit_account` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核用户名' ,
`user_pwd`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
`role_type`  int(10) NULL DEFAULT NULL COMMENT '角色类型（1.业务审核人员, 2.财务审核人员）' ,
`real_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名' ,
`phone_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='审核人信息表'
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

CREATE TABLE `tbl_apply_money_history` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '提现申请轨迹主键，自增' ,
`applyFlow_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水(外键)' ,
`audit_date`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '审核日期' ,
`audit_status`  int(10) NULL DEFAULT NULL COMMENT '审核状态(1,审核发起，2正在审核，3审核通过，4审核驳回)' ,
`audit_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核备注' ,
`audit_user`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人' ,
`role_type`  int(11) NULL DEFAULT NULL COMMENT '审核人角色' ,
`audit_step`  int(10) NULL DEFAULT NULL COMMENT '审核第几步' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='提现申请轨迹表'
ROW_FORMAT=COMPACT
;

CREATE TABLE `tbl_expense_info` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '账户主键，自增' ,
`user_id`  int(10) NULL DEFAULT NULL COMMENT '用户id（外键）' ,
`drawMoney_password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现密码' ,
`total_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '累计收入' ,
`surplus_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '剩余金额' ,
`freeze_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '冻结金额（申请提现金额）' ,
`already_apply_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '累计提现金额' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='个人收支总表'
ROW_FORMAT=COMPACT
;


CREATE TABLE `tbl_finance_details` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '财务id，自增' ,
`user_id`  int(11) NULL DEFAULT NULL COMMENT '用户id做关联使用' ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称' ,
`reward_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '总收入' ,
`bonus_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '奖金' ,
`forfeit_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '罚金' ,
`bug_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '缺陷收益' ,
`testcase_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '用例收益' ,
`moneyfrom_description`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入来源描述（项目, 红包，砸蛋，摇大奖）' ,
`moneyfrom_type`  int(10) NULL DEFAULT NULL COMMENT '收入来源类型（1-项目（缺陷，用例） 2-红包，3-摇大奖，4-砸蛋））' ,
`finance_timestamp`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '财务数据生成时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='财务明细表'
ROW_FORMAT=COMPACT
;

CREATE TABLE `tbl_moneyaudit_info` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`audit_remark`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核备注' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='提现审核表'
ROW_FORMAT=COMPACT
;



CREATE TABLE `tbl_paygate` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`paygate_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付渠道类型' ,
`paygate_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付渠道名称' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='支付渠道表'
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

CREATE TABLE `tbl_gateaccount_info` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`paygate_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付渠道类型' ,
`account_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名称' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道账户表'
ROW_FORMAT=COMPACT
;

CREATE TABLE `tbl_pay_flowrecord` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自增' ,
`user_id`  int(11) NULL DEFAULT NULL COMMENT 'userid做外键关联使用' ,
`businessFlow_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水（外键）' ,
`thirdorder_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付流水(支付渠道返回的订单号)' ,
`pay_status`  int(10) NULL DEFAULT NULL COMMENT '支付状态(0:支付中，1：支付成功，2：支付失败,3:支付失败已退回)' ,
`pay_account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付账号' ,
`pay_time`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '流水产生时间' ,
`pay_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '支付金额' ,
`beforepay_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '支付前余额' ,
`afterpay_money`  decimal(10,2) NULL DEFAULT NULL COMMENT '支付后余额' ,
`pay_remark`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录支付成功或失败的备注' ,
`export_flag`  int(11) NULL DEFAULT 0 COMMENT '导出状态 0-未导出 1-已导出' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='支付流水记录表'
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

--支付方式初始化
INSERT INTO `tbl_paygate` VALUES ('1', '0', '支付宝');
--账户初始化
INSERT INTO `tbl_audit_account` VALUES ('1', 'account', '96E79218965EB72C92A549DD5A330112', '0', '0', '111111');





