
-- 初始化贷款期限数据
INSERT INTO `dic_loan_term` VALUES (1,1,'12期'),(2,2,'24期'),(3,3,'26期');

-- 初始化 贷款产品类别
INSERT INTO `dic_loan_type` VALUES (1,1,'简易贷A'),(2,2,'简易贷B'),(3,3,'首付5%'),(4,4,'首付10%'),(5,5,'首付20%'),(6,6,'二手车零首付'),(7,7,'二手车低首付');

-- 初始化首付比例
INSERT INTO `dic_payment_ratio` VALUES (1,1,'30%'),(2,2,'40%'),(3,3,'50%'),(4,4,'60%'),(5,5,'70%'),(6,6,'80%');

-- 人员信息
INSERT INTO `tbl_user_baseinfo` VALUES (1,'zxkj','123456789',111,'guorongbin@chinasoftinc.com','0000-00-00 00:00:00','0000-00-00 00:00:00','11','11');
