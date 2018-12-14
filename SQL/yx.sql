/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : yx

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-06 16:26:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bi_device
-- ----------------------------
DROP TABLE IF EXISTS `bi_device`;
CREATE TABLE `bi_device` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `device_no` varchar(40) DEFAULT NULL,
  `mer_no_id` bigint(20) DEFAULT NULL,
  `mer_no` varchar(40) DEFAULT NULL,
  `access_type` varchar(1) DEFAULT NULL,
  `key_system` varchar(1) DEFAULT NULL,
  `key_index` varchar(40) DEFAULT NULL,
  `vender_name` varchar(100) DEFAULT NULL,
  `serial_no` varchar(40) DEFAULT NULL,
  `mount_time` datetime DEFAULT NULL,
  `mount_addr` varchar(255) DEFAULT NULL,
  `mount_person` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_device
-- ----------------------------
INSERT INTO `bi_device` VALUES ('860037393787387904', '0', '2017-05-04 15:44:28', '2017-05-04 15:44:28', '0', '00001', '860029573272698880', 'ABCDEFG', '0', '0', '', '', 'x-ABCD-6689', null, '', '');

-- ----------------------------
-- Table structure for bi_merchant
-- ----------------------------
DROP TABLE IF EXISTS `bi_merchant`;
CREATE TABLE `bi_merchant` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `org_name` varchar(40) DEFAULT NULL,
  `rgn_id` bigint(20) DEFAULT NULL,
  `rgn_name` varchar(40) DEFAULT NULL,
  `mer_type_id` bigint(20) DEFAULT NULL,
  `mer_type_name` varchar(40) DEFAULT NULL,
  `mer_name` varchar(100) DEFAULT NULL,
  `mer_addr` varchar(255) DEFAULT NULL,
  `mer_cert_no` varchar(40) DEFAULT NULL,
  `mer_cert_image` varchar(255) DEFAULT NULL,
  `mer_deposit_bank` varchar(100) DEFAULT NULL,
  `mer_deposit_account` varchar(100) DEFAULT NULL,
  `standard_fee` varchar(20) DEFAULT NULL,
  `cap_amount` varchar(20) DEFAULT NULL,
  `mer_contact_person` varchar(20) DEFAULT NULL,
  `mer_contact_phone` varchar(40) DEFAULT NULL,
  `mer_contact_duty` varchar(20) DEFAULT NULL,
  `lawer` varchar(20) DEFAULT NULL,
  `union_id` bigint(20) DEFAULT NULL,
  `union_name` varchar(40) DEFAULT NULL,
  `his_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_merchant
-- ----------------------------
INSERT INTO `bi_merchant` VALUES ('859941344762658816', '4', '2017-05-04 09:22:48', '2017-05-06 03:47:50', '0', '859681609924739072', '一级机构', '859657785162334208', '惠州市', '859665160179023872', '医院', '白花医院', '', '', '/TZ_M2M/upload/common/20170504/20170504105628_9638926.png', '', '', '', '', '', '', '', '', '860005115052949504', '银信', '950002');
INSERT INTO `bi_merchant` VALUES ('861417925897093120', '0', '2017-05-08 11:10:12', '2017-05-08 11:10:12', '0', '859681609924739072', '一级机构', '859657785162334208', '惠州市', '859665160179023872', '医院', '多祝医院', '', '', '', '', '', '', '', '', '', '', '', '860005115052949504', '银信', '950003');

-- ----------------------------
-- Table structure for bi_merchant_no
-- ----------------------------
DROP TABLE IF EXISTS `bi_merchant_no`;
CREATE TABLE `bi_merchant_no` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mer_id` bigint(20) DEFAULT NULL,
  `mer_name` varchar(40) DEFAULT NULL,
  `no_name` varchar(40) DEFAULT NULL,
  `mer_tenant_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_merchant_no
-- ----------------------------
INSERT INTO `bi_merchant_no` VALUES ('860029573272698880', '1', '2017-05-04 15:13:23', '2017-05-07 14:25:34', '0', '859941344762658816', '白花医院', 'ABCDEFG', '白花医院附属诊所');

-- ----------------------------
-- Table structure for bi_merchant_type
-- ----------------------------
DROP TABLE IF EXISTS `bi_merchant_type`;
CREATE TABLE `bi_merchant_type` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mer_no` varchar(40) DEFAULT NULL,
  `mer_name` varchar(80) DEFAULT NULL,
  `type` varchar(1) DEFAULT NULL,
  `standard_fee` varchar(20) DEFAULT NULL,
  `cap_amount` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_merchant_type
-- ----------------------------
INSERT INTO `bi_merchant_type` VALUES ('859665160179023872', '0', '2017-05-03 15:05:20', '2017-05-03 15:05:20', '0', '001', '医院', '0', '', '');
INSERT INTO `bi_merchant_type` VALUES ('859665200951853056', '0', '2017-05-03 15:05:30', '2017-05-03 15:05:30', '0', '002', '诊所', '0', '', '');

-- ----------------------------
-- Table structure for bi_org
-- ----------------------------
DROP TABLE IF EXISTS `bi_org`;
CREATE TABLE `bi_org` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `org_no` varchar(40) DEFAULT NULL,
  `org_name` varchar(100) DEFAULT NULL,
  `acq_perm` varchar(1) DEFAULT NULL,
  `issue_perm` varchar(1) DEFAULT NULL,
  `forward_perm` varchar(1) DEFAULT NULL,
  `org_type_id` bigint(20) DEFAULT NULL,
  `org_type_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_org
-- ----------------------------
INSERT INTO `bi_org` VALUES ('859681609924739072', '0', '2017-05-03 16:10:42', '2017-05-03 16:10:42', '0', 'A001', '一级机构', '0', '0', '0', '859676186500923392', '收单机构');

-- ----------------------------
-- Table structure for bi_org_type
-- ----------------------------
DROP TABLE IF EXISTS `bi_org_type`;
CREATE TABLE `bi_org_type` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `type_no` varchar(40) DEFAULT NULL,
  `type_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_org_type
-- ----------------------------
INSERT INTO `bi_org_type` VALUES ('859676186500923392', '0', '2017-05-03 15:49:09', '2017-05-03 15:49:09', '0', '0001', '收单机构');

-- ----------------------------
-- Table structure for bi_part
-- ----------------------------
DROP TABLE IF EXISTS `bi_part`;
CREATE TABLE `bi_part` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `serial_number` varchar(100) DEFAULT NULL,
  `part_name` varchar(80) DEFAULT NULL,
  `part_type_id` bigint(20) DEFAULT NULL,
  `part_type_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_part
-- ----------------------------
INSERT INTO `bi_part` VALUES ('859672446272274432', '1', '2017-05-03 15:34:17', '2017-05-03 15:40:57', '0', 'SZ00001', '配件名称', '859669332945272832', '易损件');

-- ----------------------------
-- Table structure for bi_part_type
-- ----------------------------
DROP TABLE IF EXISTS `bi_part_type`;
CREATE TABLE `bi_part_type` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `type_no` varchar(40) DEFAULT NULL,
  `type_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_part_type
-- ----------------------------
INSERT INTO `bi_part_type` VALUES ('859669332945272832', '0', '2017-05-03 15:21:55', '2017-05-03 15:21:55', '0', '0001', '易损件');

-- ----------------------------
-- Table structure for bi_region
-- ----------------------------
DROP TABLE IF EXISTS `bi_region`;
CREATE TABLE `bi_region` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(11) DEFAULT NULL,
  `rgn_no` varchar(40) DEFAULT NULL,
  `rgn_name` varchar(40) DEFAULT NULL,
  `rgn_full` varchar(255) DEFAULT NULL,
  `parent_no` varchar(40) DEFAULT NULL,
  `parent_name` varchar(40) DEFAULT NULL,
  `expanded_flag` tinyint(1) DEFAULT NULL,
  `leaf_flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_region
-- ----------------------------
INSERT INTO `bi_region` VALUES ('1', '3', null, '2017-05-03 14:22:04', '0', '0', null, null, '', null, null, '0');
INSERT INTO `bi_region` VALUES ('859654279634354176', '1', '2017-05-03 14:22:06', '2017-05-03 14:31:26', '0', '01', '中国', '', '0', '', '0', '0');
INSERT INTO `bi_region` VALUES ('859656627840614400', '2', '2017-05-03 14:31:26', '2017-05-03 14:36:47', '0', '0101', '广东省', '', '01', '中国', '0', '0');
INSERT INTO `bi_region` VALUES ('859657785162334208', '0', '2017-05-03 14:36:02', '2017-05-03 14:36:02', '0', '010101', '惠州市', '', '0101', '广东省', '0', '1');
INSERT INTO `bi_region` VALUES ('859657974841344000', '0', '2017-05-03 14:36:47', '2017-05-03 14:36:47', '0', '010102', '深圳市', '', '0101', '广东省', '0', '1');

-- ----------------------------
-- Table structure for bi_union
-- ----------------------------
DROP TABLE IF EXISTS `bi_union`;
CREATE TABLE `bi_union` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `union_no` varchar(40) DEFAULT NULL,
  `union_name` varchar(40) DEFAULT NULL,
  `parent_no` varchar(40) DEFAULT NULL,
  `parent_name` varchar(40) DEFAULT NULL,
  `expanded_flag` tinyint(1) DEFAULT NULL,
  `leaf_flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bi_union
-- ----------------------------
INSERT INTO `bi_union` VALUES ('1', '1', null, '2017-05-04 13:36:12', '0', '0', null, '', null, null, '0');
INSERT INTO `bi_union` VALUES ('860005115052949504', '0', '2017-05-04 13:36:12', '2017-05-04 13:36:12', '0', '01', '银信', '0', '', '1', '1');

-- ----------------------------
-- Table structure for his_bed
-- ----------------------------
DROP TABLE IF EXISTS `his_bed`;
CREATE TABLE `his_bed` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  `merchant_name` varchar(40) DEFAULT NULL COMMENT '商家名称',
  `bed_no` varchar(40) DEFAULT NULL COMMENT '床位编号',
  `bed_name` varchar(40) DEFAULT NULL COMMENT '床位名称',
  `building` varchar(20) DEFAULT NULL COMMENT '所属建筑',
  `storey` varchar(20) DEFAULT NULL COMMENT '所属楼层',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_bed
-- ----------------------------
INSERT INTO `his_bed` VALUES ('868171917687783424', '1', '2017-05-27 02:28:09', '2017-05-27 02:32:10', '0', '859941344762658816', '白花医院', '01.01.001', '001床', '住院楼', '1', '');
INSERT INTO `his_bed` VALUES ('868172853537669120', '1', '2017-05-27 02:31:52', '2017-05-27 02:32:17', '0', '859941344762658816', '白花医院', '01.01.002', '002床', '住院部', '1', '');

-- ----------------------------
-- Table structure for his_fee_settle
-- ----------------------------
DROP TABLE IF EXISTS `his_fee_settle`;
CREATE TABLE `his_fee_settle` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `ykc675` varchar(6) DEFAULT NULL,
  `aae040` varchar(20) DEFAULT NULL,
  `akc264` float DEFAULT NULL,
  `akc253` float DEFAULT NULL,
  `akc254` float DEFAULT NULL,
  `yka319` float DEFAULT NULL,
  `ykc624` float DEFAULT NULL,
  `aka151` float DEFAULT NULL,
  `akb066` float DEFAULT NULL,
  `ykc631` float DEFAULT NULL,
  `akb068` float DEFAULT NULL,
  `ake039` float DEFAULT NULL,
  `ykc627` float DEFAULT NULL,
  `ckc504` float DEFAULT NULL,
  `ckc688` float DEFAULT NULL,
  `akc630` float DEFAULT NULL,
  `ykc629` float DEFAULT NULL,
  `akb063` int(4) DEFAULT NULL,
  `ykc618` varchar(40) DEFAULT NULL,
  `ykc666` varchar(100) DEFAULT NULL,
  `yka430` float DEFAULT NULL,
  `yka431` float DEFAULT NULL,
  `yka402` float DEFAULT NULL,
  `ckc938` float DEFAULT NULL,
  `ckc939` float DEFAULT NULL,
  `ckc940` float DEFAULT NULL,
  `ckc941` float DEFAULT NULL,
  `ckc942` float DEFAULT NULL,
  `ckc943` float DEFAULT NULL,
  `ckc944` float DEFAULT NULL,
  `ckc945` float DEFAULT NULL,
  `aae013` varchar(200) DEFAULT NULL,
  `ckeA0N` varchar(6) DEFAULT NULL,
  `mer_id` bigint(20) DEFAULT NULL,
  `mer_name` varchar(40) DEFAULT NULL,
  `mer_no_id` bigint(20) DEFAULT NULL,
  `mer_ins_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_fee_settle
-- ----------------------------

-- ----------------------------
-- Table structure for his_hisconfig
-- ----------------------------
DROP TABLE IF EXISTS `his_hisconfig`;
CREATE TABLE `his_hisconfig` (
  `id` bigint(20) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `fdel_flag` tinyint(4) DEFAULT NULL,
  `fhospital_name` varchar(200) DEFAULT NULL,
  `fkey` varchar(40) DEFAULT NULL,
  `fusername` varchar(40) DEFAULT NULL,
  `fpassword` varchar(40) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_hisconfig
-- ----------------------------
INSERT INTO `his_hisconfig` VALUES ('861444228289396736', '0', '2017-05-08 12:54:37', '2017-05-08 12:54:37', '0', '白花医院', '950002', '胡燕玲', '8888', '859941344762658816');

-- ----------------------------
-- Table structure for his_inhospital_dtl
-- ----------------------------
DROP TABLE IF EXISTS `his_inhospital_dtl`;
CREATE TABLE `his_inhospital_dtl` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `aka185` varchar(3) DEFAULT NULL COMMENT '监控使用标志',
  `ykc610` varchar(20) DEFAULT NULL COMMENT '医疗费用序列号',
  `yka111` varchar(6) DEFAULT NULL COMMENT '大类代码',
  `yka112` varchar(100) DEFAULT NULL COMMENT '大类名称',
  `akc222y` varchar(20) DEFAULT NULL COMMENT '医院项目代码',
  `akc223y` varchar(100) DEFAULT NULL COMMENT '医院项目名称',
  `akc226` float DEFAULT NULL COMMENT '数量',
  `akc225` float DEFAULT NULL COMMENT '单价',
  `akc264` float DEFAULT NULL COMMENT '医疗费用总额',
  `akc221` varchar(20) DEFAULT NULL COMMENT '处方单据时间',
  `aae011` varchar(20) DEFAULT NULL COMMENT '嵌入式用户编码',
  `mas_id` bigint(20) DEFAULT NULL,
  `send_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_inhospital_dtl
-- ----------------------------
INSERT INTO `his_inhospital_dtl` VALUES ('868275124560723968', '2', '2017-05-27 09:18:16', '2017-05-27 09:22:14', '0', '0', null, 'B01', null, '160560', '一般诊疗费', '1', '1', '1', '2017-05-27', null, '868267217379131392', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('868275124606861312', '2', '2017-05-27 09:18:16', '2017-05-27 09:22:14', '0', '0', null, 'B02', null, '157023', '手术费', '1', '0', '0', '2017-05-27', null, '868267217379131392', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('868275968278528000', '1', '2017-05-27 09:21:37', '2017-05-27 09:22:14', '0', '0', null, 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-27', null, '868267217379131392', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('868276124931588096', '0', '2017-05-27 09:22:14', '2017-05-27 09:22:14', '0', '0', null, 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-27', null, '868267217379131392', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('882837250293891072', '0', '2017-07-06 13:42:57', '2017-07-06 13:42:57', '0', '0', null, 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-07-06', null, '882837104860594176', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('882837250323251200', '0', '2017-07-06 13:42:57', '2017-07-06 13:42:57', '0', '0', null, 'B01', '普通门诊', '1602910', '一般医疗费用', '1', '0', '0', '2017-07-06', null, '882837104860594176', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('882837250352611328', '0', '2017-07-06 13:42:57', '2017-07-06 13:42:57', '0', '0', null, 'B02', '特定门诊', '157023', '手术费', '1', '0', '0', '2017-07-06', null, '882837104860594176', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('882837250381971456', '0', '2017-07-06 13:42:57', '2017-07-06 13:42:57', '0', '0', null, 'B01', '普通门诊', '1602910', '一般医疗费用', '1', '0', '0', '2017-07-06', null, '882837104860594176', '0');
INSERT INTO `his_inhospital_dtl` VALUES ('882837250407137280', '0', '2017-07-06 13:42:57', '2017-07-06 13:42:57', '0', '0', null, 'B02', '特定门诊', '157023', '手术费', '1', '0', '0', '2017-07-06', null, '882837104860594176', '0');

-- ----------------------------
-- Table structure for his_inhospital_mas
-- ----------------------------
DROP TABLE IF EXISTS `his_inhospital_mas`;
CREATE TABLE `his_inhospital_mas` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `aac044` varchar(22) DEFAULT NULL COMMENT '证件号码',
  `aac057` varchar(20) DEFAULT NULL COMMENT '离退休证号',
  `yzz016` varchar(20) DEFAULT NULL COMMENT '转诊备案号',
  `aka130` varchar(4) DEFAULT NULL COMMENT '就诊类别',
  `akc190` varchar(20) DEFAULT NULL COMMENT '住院号',
  `akc090` int(4) DEFAULT NULL COMMENT '住院次数',
  `akf001` varchar(4) DEFAULT NULL COMMENT '入院科室',
  `ykc012` varchar(12) DEFAULT NULL COMMENT '入院床位',
  `akc050` varchar(100) DEFAULT NULL COMMENT '入院诊断',
  `akc193` varchar(20) DEFAULT NULL COMMENT 'ICD10_1',
  `ykc601` varchar(20) DEFAULT NULL COMMENT 'ICD10_2',
  `ykc602` varchar(20) DEFAULT NULL COMMENT 'ICD10_3',
  `ckz564` varchar(20) DEFAULT NULL COMMENT '生育备案审批号',
  `ckc798` varchar(3) DEFAULT NULL COMMENT '意外伤害标志',
  `ckc949` varchar(6) DEFAULT NULL COMMENT '二次返院传入标志',
  `ykc701` varchar(20) DEFAULT NULL COMMENT '入院日期',
  `aae005` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `aae013` varchar(150) DEFAULT NULL COMMENT '备注',
  `in_hosp_type` varchar(6) DEFAULT NULL COMMENT '入院方式',
  `aab014` varchar(20) DEFAULT NULL COMMENT '医护人员公民身份号码',
  `ckc936` varchar(6) DEFAULT NULL COMMENT '医疗个人结算类型',
  `ckc937` varchar(6) DEFAULT NULL COMMENT '单病种诊断',
  `merchant_id` bigint(20) DEFAULT NULL,
  `merchant_name` varchar(80) DEFAULT NULL COMMENT '医院',
  `jbrmc` varchar(20) DEFAULT NULL COMMENT '经办人',
  `person_name` varchar(20) DEFAULT NULL COMMENT '人员名称',
  `aaz217` varchar(20) DEFAULT NULL COMMENT '就诊记录号',
  `his_bill_state` varchar(1) DEFAULT NULL COMMENT '单据状态',
  `yka115` float DEFAULT NULL COMMENT '本次已付起付线',
  `ykc618` varchar(20) DEFAULT NULL COMMENT '费用结算序列号',
  `ykc675` varchar(6) DEFAULT NULL COMMENT '费用结算类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_inhospital_mas
-- ----------------------------
INSERT INTO `his_inhospital_mas` VALUES ('868157090466627584', '6', '2017-05-27 01:29:14', '2017-05-27 02:01:46', '0', '44252819421016101X', '', '', 'B12', '1', '1', 'B01', '001', '未知症状', null, null, null, '', 'B02', 'B02', '2017-05-27', '15016700502', '', 'B01', '', null, null, '859941344762658816', '', '白花医院', '张纪坤', '25289730', '2', '0', null, null);
INSERT INTO `his_inhospital_mas` VALUES ('868254057699999744', '4', '2017-05-27 07:54:33', '2017-05-27 08:41:55', '0', '44252819421016101X', '', '', 'B12', '3', '1', 'B01', '002床', '住院', null, null, null, '', 'B02', 'B02', '2017-05-27', '15016700502', '', 'B01', '', null, null, '859941344762658816', '白花医院', '白花医院', '张纪坤', '25289731', '2', '0', '', '');
INSERT INTO `his_inhospital_mas` VALUES ('868267217379131392', '3', '2017-05-27 08:46:50', '2017-05-27 08:47:00', '0', '44252819421016101X', '', '', 'B12', '4', '1', 'B02', '001床', '小腿骨裂', null, null, null, '', 'B02', 'B02', '2017-05-27', '15016700502', '', 'B01', '', null, null, '859941344762658816', '白花医院', '白花医院', '张纪坤', '25289733', '0', '0', '', 'B01');
INSERT INTO `his_inhospital_mas` VALUES ('875650417256562688', '12', '2017-06-16 17:45:02', '2017-06-17 08:33:34', '0', '441323197910230514', '', '', 'B04', '10001', '1', 'B01', '001床', '骨折', null, null, null, '', 'B02', 'B02', '2017-06-17', '15016700502', '', 'B01', '', null, null, '859941344762658816', '白花医院', '白花医院', '陈惠胜', '25290070', '2', '0', '', 'B01');
INSERT INTO `his_inhospital_mas` VALUES ('875892211672154112', '5', '2017-06-17 09:45:51', '2017-06-17 15:24:41', '0', '441323197910230514', '', '', 'B04', '10002', '1', 'B01', '001床', '骨折', null, null, null, '', 'B02', 'B02', '2017-06-17', '15016700502', '', 'B01', '', null, null, '859941344762658816', '白花医院', '白花医院', '陈惠胜', '25290071', '2', '0', '', 'B01');
INSERT INTO `his_inhospital_mas` VALUES ('875978436777082880', '7', '2017-06-17 15:28:28', '2017-06-18 14:24:06', '0', '441323197910230514', '', '', 'B04', '10003', '1', 'B01', '001床', '骨折', null, null, null, '', 'B02', 'B02', '2017-06-17', '15016700502', '', 'B01', '', null, null, '859941344762658816', '白花医院', '白花医院', '陈惠胜', '25290072', '2', '0', '', 'B01');
INSERT INTO `his_inhospital_mas` VALUES ('882837104860594176', '0', '2017-07-06 13:42:22', '2017-07-06 13:42:22', '0', '441323197910230514', '', '', 'B12', '10005', '1', 'B01', '001床', '骨折', null, null, null, '', 'B02', 'B02', '2017-07-06', '13809831054', '', 'B01', '', null, null, '859941344762658816', '', '白花医院', '陈惠胜', '', '0', '0', '', 'B01');

-- ----------------------------
-- Table structure for his_prescription
-- ----------------------------
DROP TABLE IF EXISTS `his_prescription`;
CREATE TABLE `his_prescription` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mas_id` bigint(20) DEFAULT NULL,
  `akc220` varchar(20) DEFAULT NULL COMMENT '处方号',
  `aab014` varchar(20) DEFAULT NULL COMMENT '医护人员公民身份号码',
  `physician` varchar(20) DEFAULT NULL COMMENT '医护人员名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_prescription
-- ----------------------------

-- ----------------------------
-- Table structure for his_result
-- ----------------------------
DROP TABLE IF EXISTS `his_result`;
CREATE TABLE `his_result` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mas_id` bigint(20) DEFAULT NULL,
  `type` varchar(12) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_result
-- ----------------------------

-- ----------------------------
-- Table structure for his_settle
-- ----------------------------
DROP TABLE IF EXISTS `his_settle`;
CREATE TABLE `his_settle` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mer_id` bigint(20) DEFAULT NULL,
  `mer_name` varchar(40) DEFAULT NULL,
  `his_no` varchar(20) DEFAULT NULL,
  `settle_type` varchar(6) DEFAULT NULL,
  `settle_no` varchar(20) DEFAULT NULL,
  `cn_name` varchar(100) DEFAULT NULL,
  `en_name` varchar(100) DEFAULT NULL,
  `common_name` varchar(100) DEFAULT NULL,
  `preparation` varchar(20) DEFAULT NULL,
  `his_catetory_id` bigint(20) DEFAULT NULL,
  `his_category_name` varchar(40) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `unit_id` bigint(20) DEFAULT NULL,
  `unit_name` varchar(20) DEFAULT NULL,
  `international_code` varchar(40) DEFAULT NULL,
  `mnemonic_code` varchar(20) DEFAULT NULL,
  `effect_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `social_security_project_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_settle
-- ----------------------------
INSERT INTO `his_settle` VALUES ('860394661615763456', '1', '2017-05-05 15:24:07', '2017-05-26 15:05:24', '0', '859941344762658816', '白花医院', '950002', 'B01', '160560', '一般诊疗费', '', '', '', null, '', '1', null, '', '', 'ybzlf', null, '', '110100002');
INSERT INTO `his_settle` VALUES ('860489217094975488', '1', '2017-05-05 21:39:51', '2017-05-26 15:05:19', '0', '859941344762658816', '白花医院', '950002', 'B01', '1602910', '一般医疗费用', '', '', '', null, '', '0', null, '', '', 'ybylfy', null, '', '12345645');
INSERT INTO `his_settle` VALUES ('860489334384492544', '1', '2017-05-05 21:40:19', '2017-05-26 15:05:13', '0', '859941344762658816', '白花医院', '950002', 'B02', '157023', '手术费', '', '', '', null, '', '0', null, '', '', 'ssf', null, '', '24543223');

-- ----------------------------
-- Table structure for his_settle_dtl
-- ----------------------------
DROP TABLE IF EXISTS `his_settle_dtl`;
CREATE TABLE `his_settle_dtl` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `ykc610` varchar(40) DEFAULT NULL,
  `yka111` varchar(6) DEFAULT NULL,
  `yka112` varchar(20) DEFAULT NULL,
  `akc222y` varchar(40) DEFAULT NULL,
  `akc223y` varchar(40) DEFAULT NULL,
  `akc226` float DEFAULT NULL,
  `akc225` float DEFAULT NULL,
  `akc264` float DEFAULT NULL,
  `akc221` varchar(20) DEFAULT NULL,
  `aae011` varchar(40) DEFAULT NULL,
  `mas_id` bigint(20) DEFAULT NULL,
  `mas_no` varchar(40) DEFAULT NULL,
  `aae311` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_settle_dtl
-- ----------------------------
INSERT INTO `his_settle_dtl` VALUES ('860919183838281728', '0', '2017-05-07 02:08:23', '2017-05-07 02:08:23', '0', null, 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, null, '1', '860919183821504512', null, null);
INSERT INTO `his_settle_dtl` VALUES ('860919183855058944', '0', '2017-05-07 02:08:23', '2017-05-07 02:08:23', '0', null, 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, null, '1', '860919183821504512', null, null);
INSERT INTO `his_settle_dtl` VALUES ('860925086054481920', '1', '2017-05-07 02:31:50', '2017-05-08 16:35:03', null, '861499702137323520', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, null, '1', '860925086033510400', null, null);
INSERT INTO `his_settle_dtl` VALUES ('860925086109007872', '1', '2017-05-07 02:31:50', '2017-05-08 16:35:03', null, '861499702506422272', 'B01', '普通门诊', '1602910', '一般医疗费用', '1', '0', null, null, '0', '860925086033510400', null, null);
INSERT INTO `his_settle_dtl` VALUES ('860925086121590784', '1', '2017-05-07 02:31:50', '2017-05-08 16:35:03', null, '861499702816800768', 'B02', '特定门诊', '157023', '手术费', '1', '0', null, null, '0', '860925086033510400', null, null);
INSERT INTO `his_settle_dtl` VALUES ('861125879382671360', '1', '2017-05-07 15:49:43', '2017-05-08 03:24:31', null, '861300730017873920', 'B01', '普通门诊', null, '一般诊疗费', '3', '1', null, null, '1', '861125879349116928', null, null);
INSERT INTO `his_settle_dtl` VALUES ('861125879412031488', '1', '2017-05-07 15:49:43', '2017-05-08 03:24:31', null, '861300734619025408', 'B01', '普通门诊', '160560', '一般诊疗费', '4', '1', null, null, '1', '861125879349116928', null, null);
INSERT INTO `his_settle_dtl` VALUES ('861493632924909569', '0', '2017-05-08 16:10:56', '2017-05-08 16:10:56', '0', '861493632924909568', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, '2017-05-08', '1', '861493632534839296', null, null);
INSERT INTO `his_settle_dtl` VALUES ('861500625546903553', '0', '2017-05-08 16:38:43', '2017-05-08 16:38:43', '0', '861500625546903552', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, '2017-05-08', '1', '861500625123278848', null, null);
INSERT INTO `his_settle_dtl` VALUES ('862224246519103489', '0', '2017-05-10 16:34:07', '2017-05-10 16:34:07', '0', '862224246519103488', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, '2017-05-10', '1', '862224244879130624', null, null);
INSERT INTO `his_settle_dtl` VALUES ('862230211494674433', '0', '2017-05-10 16:57:56', '2017-05-10 16:57:56', '0', '862230211494674432', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, '2017-05-10', '1', '862230211410788352', null, null);
INSERT INTO `his_settle_dtl` VALUES ('862241529102598145', '0', '2017-05-10 17:42:48', '2017-05-10 17:42:48', '0', '862241529102598144', null, null, null, null, null, null, null, '2017-05-10', null, '862241528767053824', null, null);
INSERT INTO `his_settle_dtl` VALUES ('862242179274244097', '1', '2017-05-10 17:45:23', '2017-05-17 00:14:32', null, '864514411845386240', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', null, '2017-05-10', '1', '862242178959671296', null, null);
INSERT INTO `his_settle_dtl` VALUES ('864513503602409473', '0', '2017-05-17 00:10:55', '2017-05-17 00:10:55', '0', '864513503602409472', null, null, null, null, null, null, null, '2017-05-17', null, '864513503547883520', null, null);
INSERT INTO `his_settle_dtl` VALUES ('864514112430800897', '0', '2017-05-17 00:13:20', '2017-05-17 00:13:20', '0', '864514112430800896', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-17', '1', '864514112380469248', null, null);
INSERT INTO `his_settle_dtl` VALUES ('864514112472743937', '0', '2017-05-17 00:13:20', '2017-05-17 00:13:20', '0', '864514112472743936', 'B02', '特定门诊', '157023', '手术费', '1', '0', '1', '2017-05-17', '0', '864514112380469248', null, null);
INSERT INTO `his_settle_dtl` VALUES ('866904902566150145', '0', '2017-05-23 14:33:18', '2017-05-23 14:33:18', '0', '866904902566150144', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-23', '1', '866904902117359616', null, null);
INSERT INTO `his_settle_dtl` VALUES ('867221619775373313', '1', '2017-05-24 11:31:53', '2017-05-24 14:48:40', null, '867271140437917696', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-24', '1', '867221619372720129', null, null);
INSERT INTO `his_settle_dtl` VALUES ('867271378175262721', '6', '2017-05-24 14:49:36', '2017-05-24 15:50:47', '0', '6587264', 'B01', '普通门诊', '1602910', '一般医疗费用', '1', '1', '1', '2017-05-24', '0', '867271377705500673', null, '2017.05.24 15:26:25');
INSERT INTO `his_settle_dtl` VALUES ('867297463331979265', '1', '2017-05-24 16:33:16', '2017-05-24 16:34:11', '0', '31979264', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-05-24', '1', '867297462925131777', null, '2017.05.24 16:32:58');
INSERT INTO `his_settle_dtl` VALUES ('875651650214166529', '5', '2017-06-16 17:49:56', '2017-06-18 14:24:34', '0', '4166528', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-16', '1', '875651650176417793', null, '2017.06.16 17:49:37');
INSERT INTO `his_settle_dtl` VALUES ('875654840368234497', '1', '2017-06-16 18:02:37', '2017-06-20 08:26:31', '0', '875654840368234496', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-16', '1', '875654840322097153', null, '2017.06.16 18:02:17');
INSERT INTO `his_settle_dtl` VALUES ('875656201533128705', '28', '2017-06-16 18:08:02', '2017-06-20 11:15:31', '0', '875656201533128704', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-16', '1', '875656201499574273', null, '2017.06.16 18:07:35');
INSERT INTO `his_settle_dtl` VALUES ('876465674896015361', '1', '2017-06-18 23:44:35', '2017-06-18 23:47:33', '0', '96015360', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-18', '1', '876465674845683712', null, '2017.06.18 23:42:16');
INSERT INTO `his_settle_dtl` VALUES ('876472755455787009', '1', '2017-06-19 00:12:43', '2017-06-19 00:12:56', '0', '55455787008', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-19', '1', '876472755384483841', null, '2017.06.19 00:10:35');
INSERT INTO `his_settle_dtl` VALUES ('877014934657957889', '18', '2017-06-20 12:07:09', '2017-06-20 12:55:45', '0', '34657957888', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877014934628597761', null, '2017.06.20 12:05:57');
INSERT INTO `his_settle_dtl` VALUES ('877028725567258625', '2', '2017-06-20 13:01:57', '2017-06-20 13:02:34', '0', '25567258624', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877028725546287105', null, '2017.06.20 13:01:14');
INSERT INTO `his_settle_dtl` VALUES ('877037694306222081', '1', '2017-06-20 13:37:35', '2017-06-20 13:38:04', '0', '94306222080', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877037694264279041', null, '2017.06.20 13:36:47');
INSERT INTO `his_settle_dtl` VALUES ('877038410794008577', '1', '2017-06-20 13:40:26', '2017-06-20 13:43:01', '0', '10794008576', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877038410760454145', null, '2017.06.20 13:39:34');
INSERT INTO `his_settle_dtl` VALUES ('877039507092799489', '4', '2017-06-20 13:44:47', '2017-06-20 13:48:56', '0', '07092799488', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877039507067633665', null, '2017.06.20 13:44:21');
INSERT INTO `his_settle_dtl` VALUES ('877040910473363457', '1', '2017-06-20 13:50:22', '2017-06-20 13:51:02', '0', '10473363456', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877040910444003329', null, '2017.06.20 13:49:49');
INSERT INTO `his_settle_dtl` VALUES ('877041704614494209', '3', '2017-06-20 13:53:31', '2017-06-20 14:00:15', '0', '04614494208', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877041704589328385', null, '2017.06.20 13:53:10');
INSERT INTO `his_settle_dtl` VALUES ('877043649907523585', '3', '2017-06-20 14:01:15', '2017-06-20 14:03:14', '0', '49907523584', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877043649873969153', null, '2017.06.20 14:00:44');
INSERT INTO `his_settle_dtl` VALUES ('877044848798990337', '3', '2017-06-20 14:06:01', '2017-06-20 14:10:14', '0', '48798990336', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877044848773824513', null, '2017.06.20 14:05:42');
INSERT INTO `his_settle_dtl` VALUES ('877046748529295361', '2', '2017-06-20 14:13:34', '2017-06-20 14:16:35', '0', '48529295360', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877046748478963713', null, '2017.06.20 14:13:14');
INSERT INTO `his_settle_dtl` VALUES ('877047976374042625', '1', '2017-06-20 14:18:26', '2017-06-20 14:18:56', '0', '76374042624', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877047976323710977', null, '2017.06.20 14:17:52');
INSERT INTO `his_settle_dtl` VALUES ('877048505741344769', '0', '2017-06-20 14:20:33', '2017-06-20 14:20:33', '0', '05741344768', null, null, null, null, null, null, null, '2017-06-20', null, '877048505711984641', null, '2017.06.20 14:20:27');
INSERT INTO `his_settle_dtl` VALUES ('877048636070952961', '1', '2017-06-20 14:21:04', '2017-06-20 14:29:47', '0', '36070952960', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877048636037398529', null, '2017.06.20 14:20:38');
INSERT INTO `his_settle_dtl` VALUES ('877051669630681089', '1', '2017-06-20 14:33:07', '2017-06-20 14:33:45', '0', '69630681088', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877051669601320961', null, '2017.06.20 14:32:42');
INSERT INTO `his_settle_dtl` VALUES ('877053479539965953', '2', '2017-06-20 14:40:19', '2017-06-20 14:48:46', '0', '79539965952', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877053479493828609', null, '2017.06.20 14:39:57');
INSERT INTO `his_settle_dtl` VALUES ('877056827886403585', '1', '2017-06-20 14:53:37', '2017-06-20 14:54:12', '0', '27886403584', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877056827852849153', null, '2017.06.20 14:53:13');
INSERT INTO `his_settle_dtl` VALUES ('877057425851547649', '1', '2017-06-20 14:55:59', '2017-06-20 14:56:53', '0', '25851547648', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877057425822187521', null, '2017.06.20 14:55:38');
INSERT INTO `his_settle_dtl` VALUES ('877058823594967041', '1', '2017-06-20 15:01:33', '2017-06-20 15:02:05', '0', '23594967040', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877058823569801217', null, '2017.06.20 15:01:05');
INSERT INTO `his_settle_dtl` VALUES ('877059872401653761', '1', '2017-06-20 15:05:43', '2017-06-20 15:06:00', '0', '72401653760', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877059872376487937', null, '2017.06.20 15:05:23');
INSERT INTO `his_settle_dtl` VALUES ('877064122565394433', '1', '2017-06-20 15:22:36', '2017-06-20 15:22:56', '0', '22565394432', 'B01', '普通门诊', '160560', '一般诊疗费', '1', '1', '1', '2017-06-20', '1', '877064122540228609', null, '2017.06.20 15:22:14');

-- ----------------------------
-- Table structure for his_settle_mas
-- ----------------------------
DROP TABLE IF EXISTS `his_settle_mas`;
CREATE TABLE `his_settle_mas` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `his_bill_state` varchar(1) DEFAULT NULL,
  `aac044` varchar(30) DEFAULT NULL,
  `aac057` varchar(30) DEFAULT NULL,
  `aka130` varchar(6) DEFAULT NULL,
  `akc050` varchar(20) DEFAULT NULL,
  `ckz564` varchar(20) DEFAULT NULL,
  `aaa138` varchar(6) DEFAULT NULL,
  `ckc803` varchar(6) DEFAULT NULL,
  `yzz016` varchar(20) DEFAULT NULL,
  `aac005` varchar(20) DEFAULT NULL,
  `cab053` varchar(20) DEFAULT NULL,
  `ake007` datetime DEFAULT NULL,
  `aae013` varchar(255) DEFAULT NULL,
  `akc090` int(3) DEFAULT NULL,
  `akc220` varchar(20) DEFAULT NULL,
  `aab014` varchar(20) DEFAULT NULL,
  `akc264` float DEFAULT NULL,
  `akc190` varchar(20) DEFAULT NULL,
  `jbrmc` varchar(20) DEFAULT NULL,
  `ckz543` varchar(20) DEFAULT NULL,
  `aae011` varchar(40) DEFAULT NULL,
  `sessionid` varchar(40) DEFAULT NULL,
  `jmc` varchar(80) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  `aaz217` varchar(40) DEFAULT NULL,
  `ykc675` varchar(6) DEFAULT NULL,
  `ykc618` varchar(40) DEFAULT NULL,
  `aac004` varchar(4) DEFAULT NULL,
  `person_name` varchar(20) DEFAULT NULL COMMENT '人员名称',
  `settle_type_flag` varchar(1) DEFAULT NULL COMMENT '付费形式',
  `self_pay` float DEFAULT NULL COMMENT '自费金额',
  `xyb_order_no` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_settle_mas
-- ----------------------------
INSERT INTO `his_settle_mas` VALUES ('860919183821504512', '0', '2017-05-07 02:08:23', '2017-05-07 02:08:23', '0', '3', '441323198807213016', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-08 03:20:16', null, '0', null, null, null, null, '郑腾志', null, null, null, null, '859941344762658816', null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('860925086033510400', '1', '2017-05-07 02:31:50', '2017-05-08 16:35:03', null, '0', 'asa', null, 'B24', null, null, 'B01', '1', null, null, null, '2017-05-08 00:00:00', null, '0', null, null, null, null, '郑腾志', null, null, null, null, '859941344762658816', null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('861125879349116928', '1', '2017-05-07 15:49:43', '2017-05-08 03:24:25', '0', '0', '441323198807213016', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-08 00:00:00', null, '0', null, null, null, null, '郑腾志', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('861493632534839296', '0', '2017-05-08 16:10:56', '2017-05-08 16:10:56', '0', '0', '441323198807213016', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-08 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('861500625123278848', '0', '2017-05-08 16:38:43', '2017-05-08 16:38:43', '0', '0', '441323198807213016', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-08 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('862224244879130624', '0', '2017-05-10 16:34:07', '2017-05-10 16:34:07', '0', '0', '441323200411231015', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-10 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('862230211410788352', '0', '2017-05-10 16:57:56', '2017-05-10 16:57:56', '0', '0', '441323200411231015', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-10 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('862241528767053824', '0', '2017-05-10 17:42:48', '2017-05-10 17:42:48', '0', '0', '441323200411231015', null, 'B24', null, null, 'B01', '0', null, null, null, '2017-05-10 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('862242178959671296', '1', '2017-05-10 17:45:23', '2017-05-17 00:14:32', null, '0', '441323200411231015', null, 'B24', null, null, 'B02', '0', null, null, null, '2017-05-10 00:00:00', null, '0', '2222222', null, null, null, '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('864513503547883520', '0', '2017-05-17 00:10:55', '2017-05-17 00:10:55', '0', '0', '440921198711297496', null, 'B24', null, null, 'B03', '0', null, null, null, '2017-05-17 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('864514112380469248', '0', '2017-05-17 00:13:20', '2017-05-17 00:13:20', '0', '0', '441323198807213016', null, 'B24', null, null, 'B03', '0', null, '13431891156', null, '2017-05-17 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('866904902117359616', '0', '2017-05-23 14:33:18', '2017-05-23 14:33:18', '0', '0', '411123196703156541', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-05-23 00:00:00', null, '0', null, null, null, null, '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('867221619372720129', '1', '2017-05-24 11:31:53', '2017-05-24 14:48:40', '0', '0', '441323201204301337', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-05-24 00:00:00', null, '0', null, null, '1', '1', '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('867271377705500673', '7', '2017-05-24 14:49:36', '2017-05-24 16:16:15', '0', '1', '441323200411231015', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-05-24 00:00:00', null, '0', null, null, '1', '867271377705500672', '白花医院', null, null, null, null, '859941344762658816', '25289637', 'B01', null, 'G01', null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('867297462925131777', '2', '2017-05-24 16:33:16', '2017-05-24 16:35:09', '0', '1', '441323200411231015', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-05-24 00:00:00', null, '0', null, null, '1', '867297462925131776', '白花医院', null, null, null, null, '859941344762658816', '25289638', 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('875651650176417793', '7', '2017-06-16 17:49:56', '2017-06-18 22:41:56', '0', '3', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, null, '2017-06-18 00:00:00', null, '0', null, null, '1', '875651650176417792', '白花医院', null, null, null, null, '859941344762658816', '25290076', 'B01', '', null, '陈惠胜', null, null, null);
INSERT INTO `his_settle_mas` VALUES ('875654840322097153', '2', '2017-06-16 18:02:37', '2017-06-20 08:26:42', '0', '5', '441323199410035017', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-06-16 00:00:00', null, '0', null, null, '1', '875654840322097152', '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, '郭惠德', '0', null, null);
INSERT INTO `his_settle_mas` VALUES ('875656201499574273', '37', '2017-06-16 18:08:02', '2017-06-20 11:15:31', '0', '5', '441322197607130223', null, 'B24', '感冒', null, 'B01', '0', null, '13809831054', null, '2017-06-16 00:00:00', null, '0', null, null, '1', '875656201499574272', '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, '李逸云', '1', '1', 'GDYXXFODR201706201114541497928494121');
INSERT INTO `his_settle_mas` VALUES ('876465674845683712', '4', '2017-06-18 23:44:35', '2017-06-18 23:58:33', '0', '4', '441323197910230514', null, 'B24', '感冒', null, 'B01', '0', null, null, null, '2017-06-18 00:00:00', null, '0', null, null, '1', '876465674841489408', '白花医院', null, null, null, null, '859941344762658816', '25290078', 'B01', 'MZJS21897861', null, '陈惠胜', null, null, null);
INSERT INTO `his_settle_mas` VALUES ('876472755384483841', '4', '2017-06-19 00:12:43', '2017-06-20 13:34:47', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, null, '2017-06-19 00:00:00', null, '0', null, null, '1', '876472755384483840', '白花医院', null, null, null, null, '859941344762658816', '25290079', 'B01', 'MZJS21897862', null, '陈惠胜', null, null, null);
INSERT INTO `his_settle_mas` VALUES ('877014934628597761', '32', '2017-06-20 12:07:09', '2017-06-20 12:55:45', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877014934628597760', '白花医院', null, null, null, null, '859941344762658816', '25290198', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706201222241497932544049');
INSERT INTO `his_settle_mas` VALUES ('877028725546287105', '3', '2017-06-20 13:01:57', '2017-06-20 13:02:34', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877028725546287104', '白花医院', null, null, null, null, '859941344762658816', '25290206', 'B01', null, null, '陈惠胜', '1', null, null);
INSERT INTO `his_settle_mas` VALUES ('877037694264279041', '2', '2017-06-20 13:37:35', '2017-06-20 13:38:04', '1', '0', '441323197910230514', null, 'B24', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877037694264279040', '白花医院', null, null, null, null, '859941344762658816', '25290209', 'B01', null, null, '陈惠胜', null, null, null);
INSERT INTO `his_settle_mas` VALUES ('877038410760454145', '2', '2017-06-20 13:40:26', '2017-06-20 13:43:01', '1', '0', '441323197910230514', null, 'B24', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877038410760454144', '白花医院', null, null, null, null, '859941344762658816', '25290213', 'B01', null, null, '陈惠胜', '1', null, null);
INSERT INTO `his_settle_mas` VALUES ('877039507067633665', '5', '2017-06-20 13:44:47', '2017-06-20 13:48:56', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877039507067633664', '白花医院', null, null, null, null, '859941344762658816', '25290215', 'B01', null, null, '陈惠胜', '1', null, null);
INSERT INTO `his_settle_mas` VALUES ('877040910444003329', '2', '2017-06-20 13:50:22', '2017-06-20 13:51:02', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877040910444003328', '白花医院', null, null, null, null, '859941344762658816', '25290217', 'B01', null, null, '陈惠胜', '1', null, null);
INSERT INTO `his_settle_mas` VALUES ('877041704589328385', '6', '2017-06-20 13:53:31', '2017-06-20 14:00:16', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877041704589328384', '白花医院', null, null, null, null, '859941344762658816', '25290218', 'B01', 'MZJS21897941', null, '陈惠胜', '1', '0.2', 'GDYXXFODR201706200159381497938378514');
INSERT INTO `his_settle_mas` VALUES ('877043649873969153', '6', '2017-06-20 14:01:15', '2017-06-20 14:03:14', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877043649873969152', '白花医院', null, null, null, null, '859941344762658816', '25290220', 'B01', 'MZJS21897942', null, '陈惠胜', '1', '0.2', 'GDYXXFODR201706200202371497938557246');
INSERT INTO `his_settle_mas` VALUES ('877044848773824513', '6', '2017-06-20 14:06:01', '2017-06-20 14:10:14', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877044848773824512', '白花医院', null, null, null, null, '859941344762658816', '25290222', 'B01', 'MZJS21897943', null, '陈惠胜', '1', '0.2', 'GDYXXFODR201706200209371497938977099');
INSERT INTO `his_settle_mas` VALUES ('877046748478963713', '4', '2017-06-20 14:13:34', '2017-06-20 14:16:37', '1', '0', '441323197910230514', null, 'B24', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877046748478963712', '白花医院', null, null, null, null, '859941344762658816', '25290223', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200216001497939360444');
INSERT INTO `his_settle_mas` VALUES ('877047976323710977', '3', '2017-06-20 14:18:26', '2017-06-20 14:19:00', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877047976323710976', '白花医院', null, null, null, null, '859941344762658816', '25290224', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200218211497939501433');
INSERT INTO `his_settle_mas` VALUES ('877048505711984641', '0', '2017-06-20 14:20:33', '2017-06-20 14:20:33', '1', '0', null, null, 'B24', null, null, 'B01', '0', null, null, null, '2017-06-20 00:00:00', null, '0', null, null, '0', '877048505711984640', '白花医院', null, null, null, null, '859941344762658816', null, 'B01', null, null, null, null, null, null);
INSERT INTO `his_settle_mas` VALUES ('877048636037398529', '3', '2017-06-20 14:21:04', '2017-06-20 14:30:05', '1', '0', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877048636037398528', '白花医院', null, null, null, null, '859941344762658816', '25290225', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200229281497940168130');
INSERT INTO `his_settle_mas` VALUES ('877051669601320961', '2', '2017-06-20 14:33:07', '2017-06-20 14:33:45', '1', null, '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877051669601320960', '白花医院', null, null, null, null, '859941344762658816', '25290226', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200233061497940386371');
INSERT INTO `his_settle_mas` VALUES ('877053479493828609', '3', '2017-06-20 14:40:19', '2017-06-20 14:48:46', '1', null, '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877053479493828608', '白花医院', null, null, null, null, '859941344762658816', '25290227', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200248081497941288497');
INSERT INTO `his_settle_mas` VALUES ('877056827852849153', '2', '2017-06-20 14:53:37', '2017-06-20 14:54:12', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877056827852849152', '白花医院', null, null, null, null, '859941344762658816', '25290231', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200253351497941615806');
INSERT INTO `his_settle_mas` VALUES ('877057425822187521', '2', '2017-06-20 14:55:59', '2017-06-20 14:56:53', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877057425822187520', '白花医院', null, null, null, null, '859941344762658816', '25290232', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200256151497941775908');
INSERT INTO `his_settle_mas` VALUES ('877058823569801217', '2', '2017-06-20 15:01:33', '2017-06-20 15:02:05', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877058823569801216', '白花医院', null, null, null, null, '859941344762658816', '25290233', 'B01', null, null, '陈惠胜', '1', null, 'GDYXXFODR201706200301281497942088433');
INSERT INTO `his_settle_mas` VALUES ('877059872376487937', '2', '2017-06-20 15:05:43', '2017-06-20 15:06:00', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877059872376487936', '白花医院', null, null, null, null, '859941344762658816', '25290234', 'B01', 'MZJS21897955', null, '陈惠胜', '1', '0.2', 'GDYXXFODR201706200305221497942322826');
INSERT INTO `his_settle_mas` VALUES ('877064122540228609', '2', '2017-06-20 15:22:36', '2017-06-20 15:22:56', '0', '6', '441323197910230514', null, 'B21', '感冒', null, 'B01', '0', null, null, '13809831054', '2017-06-20 00:00:00', null, '0', null, null, '1', '877064122540228608', '白花医院', null, null, null, null, '859941344762658816', '25290238', 'B01', 'MZJS21897957', null, '陈惠胜', '1', '0.2', 'GDYXXFODR201706200322181497943338879');

-- ----------------------------
-- Table structure for his_ss_log
-- ----------------------------
DROP TABLE IF EXISTS `his_ss_log`;
CREATE TABLE `his_ss_log` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(11) DEFAULT NULL,
  `mas_id` bigint(20) DEFAULT NULL,
  `ss_type` varchar(20) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_ss_log
-- ----------------------------
INSERT INTO `his_ss_log` VALUES ('875978442758160384', '0', '2017-06-17 15:28:30', '2017-06-17 15:28:30', '0', null, null, null);
INSERT INTO `his_ss_log` VALUES ('876449908872183808', '0', '2017-06-18 22:41:56', '2017-06-18 22:41:56', '0', null, null, null);
INSERT INTO `his_ss_log` VALUES ('876466989759987712', '0', '2017-06-18 23:49:48', '2017-06-18 23:49:48', '0', null, null, null);
INSERT INTO `his_ss_log` VALUES ('876472947634601984', '0', '2017-06-19 00:13:29', '2017-06-19 00:13:29', '0', '876472755384483841', 'BDGR05', '{\"ykc618\":\"MZJS21897862\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170619\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877026592822394880', '0', '2017-06-20 12:53:28', '2017-06-20 12:53:28', '0', '877014934628597761', 'BDGR05', '{\"ykc618\":\"MZJS21897918\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877027178737303552', '0', '2017-06-20 12:55:48', '2017-06-20 12:55:48', '0', '877014934628597761', 'BDGR05', '{\"ykc618\":\"MZJS21897922\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877028891745583104', '0', '2017-06-20 13:02:36', '2017-06-20 13:02:36', '0', '877028725546287105', 'BDGR05', '{\"ykc618\":\"MZJS21897930\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877037824669384704', '0', '2017-06-20 13:38:06', '2017-06-20 13:38:06', '0', '877037694264279041', 'BDGR05', '{\"ykc618\":\"MZJS21897933\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877039074685222912', '0', '2017-06-20 13:43:04', '2017-06-20 13:43:04', '0', '877038410760454145', 'BDGR05', '{\"ykc618\":\"MZJS21897937\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877039868776022016', '0', '2017-06-20 13:46:13', '2017-06-20 13:46:13', '0', '877039507067633665', 'BDGR05', '{\"ykc618\":\"MZJS21897939\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877041087414272000', '0', '2017-06-20 13:51:04', '2017-06-20 13:51:04', '0', '877040910444003329', 'BDGR05', '{\"ykc618\":\"MZJS21897940\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877041987419635712', '0', '2017-06-20 13:54:39', '2017-06-20 13:54:39', '0', '877041704589328385', 'BDGR05', '{\"ykc618\":\"MZJS21897941\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877043853469679616', '0', '2017-06-20 14:02:04', '2017-06-20 14:02:04', '0', '877043649873969153', 'BDGR05', '{\"ykc618\":\"MZJS21897942\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877045812876541952', '0', '2017-06-20 14:09:51', '2017-06-20 14:09:51', '0', '877044848773824513', 'BDGR05', '{\"ykc618\":\"MZJS21897943\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877047514824441856', '0', '2017-06-20 14:16:36', '2017-06-20 14:16:36', '0', '877046748478963713', 'BDGR05', '{\"ykc618\":\"MZJS21897944\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877048107043389440', '0', '2017-06-20 14:18:58', '2017-06-20 14:18:58', '0', '877047976323710977', 'BDGR05', '{\"ykc618\":\"MZJS21897945\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877050839527587840', '0', '2017-06-20 14:29:49', '2017-06-20 14:29:49', '0', '877048636037398529', 'BDGR05', '{\"ykc618\":\"MZJS21897946\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877051795652739072', '0', '2017-06-20 14:33:37', '2017-06-20 14:33:37', '0', '877051669601320961', 'BDGR05', '{\"ykc618\":\"MZJS21897947\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877053583453847552', '0', '2017-06-20 14:40:43', '2017-06-20 14:40:43', '0', '877053479493828609', 'BDGR05', '{\"ykc618\":\"MZJS21897948\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877055602327552000', '0', '2017-06-20 14:48:45', '2017-06-20 14:48:45', '0', '877053479493828609', 'BDGR05', '{\"ykc618\":\"MZJS21897948\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"1\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877056933121490944', '0', '2017-06-20 14:54:02', '2017-06-20 14:54:02', '0', '877056827852849153', 'BDGR05', '{\"ykc618\":\"MZJS21897952\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877057583137947648', '0', '2017-06-20 14:56:37', '2017-06-20 14:56:37', '0', '877057425822187521', 'BDGR05', '{\"ykc618\":\"MZJS21897953\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877058906835124224', '0', '2017-06-20 15:01:53', '2017-06-20 15:01:53', '0', '877058823569801217', 'BDGR05', '{\"ykc618\":\"MZJS21897954\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877059928877957120', '0', '2017-06-20 15:05:56', '2017-06-20 15:05:56', '0', '877059872376487937', 'BDGR05', '{\"ykc618\":\"MZJS21897955\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');
INSERT INTO `his_ss_log` VALUES ('877064194992635904', '0', '2017-06-20 15:22:53', '2017-06-20 15:22:53', '0', '877064122540228609', 'BDGR05', '{\"ykc618\":\"MZJS21897957\",\"ykc631\":\"0\",\"ykc666\":\"\",\"ckc939\":\"\",\"ckc938\":\"\",\"ckc504\":\"0\",\"ckc944\":\"\",\"ckc945\":\"\",\"akb068\":\"0.8\",\"ckc942\":\"\",\"ckc943\":\"\",\"akb066\":\"0\",\"ckc940\":\"\",\"ckc941\":\"\",\"akc254\":\"0\",\"akc253\":\"0.0\",\"yka430\":\"0\",\"yka431\":\"0\",\"yka319\":\"1.0\",\"akc630\":\"0\",\"aae040\":\"20170620\",\"aka151\":\"0\",\"ckc688\":\"0\",\"akb063\":\"\",\"ykc627\":\"0.2\",\"ykc629\":\"0\",\"ykc675\":\"B01\",\"ykc624\":\"0.2\",\"yka402\":\"0.2\",\"aae013\":\"\",\"ckeA0N\":\"0\",\"ake039\":\"0.8\",\"akc264\":\"1\"}');

-- ----------------------------
-- Table structure for mer_fault_repair
-- ----------------------------
DROP TABLE IF EXISTS `mer_fault_repair`;
CREATE TABLE `mer_fault_repair` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `mer_name` varchar(40) DEFAULT NULL,
  `mer_no` varchar(40) DEFAULT NULL,
  `device_id` bigint(20) DEFAULT NULL,
  `device_no` varchar(40) DEFAULT NULL,
  `fault_type` varchar(40) DEFAULT NULL,
  `fault_desc` varchar(255) DEFAULT NULL,
  `contact_person` varchar(40) DEFAULT NULL,
  `contact_phone` varchar(40) DEFAULT NULL,
  `contact_addr` varchar(255) DEFAULT NULL,
  `accept_state` varchar(1) DEFAULT NULL,
  `accept_time` datetime DEFAULT NULL,
  `accept_person` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mer_fault_repair
-- ----------------------------
INSERT INTO `mer_fault_repair` VALUES ('860060045801422848', '14', '2017-05-04 17:14:28', '2017-05-12 15:28:37', '0', '白花医院', 'ABCDEFG', '860037393787387904', '00001', '', '', '', '', '', '1', '2017-05-12 15:28:38', '银信管理员');

-- ----------------------------
-- Table structure for mer_mchnt_trade
-- ----------------------------
DROP TABLE IF EXISTS `mer_mchnt_trade`;
CREATE TABLE `mer_mchnt_trade` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `settle_dt` varchar(20) DEFAULT NULL,
  `tid` varchar(10) DEFAULT NULL,
  `ttm` varchar(20) DEFAULT NULL,
  `rcv_ins` varchar(40) DEFAULT NULL,
  `acq_ins` varchar(40) DEFAULT NULL,
  `fwd_ins` varchar(40) DEFAULT NULL,
  `xtck` varchar(40) DEFAULT NULL,
  `jy_ls` varchar(40) DEFAULT NULL,
  `mer_id` varchar(40) DEFAULT NULL,
  `mer_mn` varchar(40) DEFAULT NULL,
  `ter_id` varchar(40) DEFAULT NULL,
  `pno` varchar(40) DEFAULT NULL,
  `trans_at` varchar(40) DEFAULT NULL,
  `disc_at` varchar(40) DEFAULT NULL,
  `eval_at` varchar(40) DEFAULT NULL,
  `reco_at` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mer_mchnt_trade
-- ----------------------------

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `function_name` varchar(40) DEFAULT NULL,
  `function_btn` varchar(40) DEFAULT NULL,
  `function_url` varchar(80) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `enabled` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('859337822107074560', '0', '2017-05-02 17:24:37', '2017-05-02 17:24:37', '0', '新增', 'add', 'create_SysUser', '10', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859337965384499200', '0', '2017-05-02 17:25:11', '2017-05-02 17:25:11', '0', '编辑', 'edit', 'updateBySysUser', '20', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859338085396119552', '0', '2017-05-02 17:25:39', '2017-05-02 17:25:39', '0', '刷新', 'refresh', '#', '30', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859338151884226560', '0', '2017-05-02 17:25:55', '2017-05-02 17:25:55', '0', '查询', 'search', '#', '40', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859338247996702720', '0', '2017-05-02 17:26:18', '2017-05-02 17:26:18', '0', '删除', 'del', 'removeBySysUser', '50', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859338326300164096', '0', '2017-05-02 17:26:37', '2017-05-02 17:26:37', '0', '退出', 'exit', '#', '100', '858149465599508480', '1');
INSERT INTO `sys_function` VALUES ('859445575433584640', '1', '2017-05-03 00:32:47', '2017-05-03 00:33:50', '0', '新增', 'add', 'createBySysMenu', '10', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445575471333376', '1', '2017-05-03 00:32:47', '2017-05-03 00:33:59', '0', '编辑', 'edit', 'editBySysMenu', '20', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445575488110592', '0', '2017-05-03 00:32:47', '2017-05-03 00:32:47', '0', '刷新', 'refresh', '#', '30', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445575504887808', '0', '2017-05-03 00:32:47', '2017-05-03 00:32:47', '0', '查询', 'search', '#', '40', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445575517470720', '1', '2017-05-03 00:32:47', '2017-05-03 00:34:05', '0', '删除', 'del', 'removeBySysMenu', '50', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445575534247936', '0', '2017-05-03 00:32:47', '2017-05-03 00:32:47', '0', '退出', 'exit', '#', '100', '858149513620094976', '1');
INSERT INTO `sys_function` VALUES ('859445698276360192', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '新增', 'add', '#', '10', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859445698293137408', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '编辑', 'edit', '#', '20', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859445698309914624', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '刷新', 'refresh', '#', '30', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859445698322497536', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '查询', 'search', '#', '40', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859445698339274752', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '删除', 'del', '#', '50', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859445698351857664', '0', '2017-05-03 00:33:16', '2017-05-03 00:33:16', '0', '退出', 'exit', '#', '100', '859282365434822656', '1');
INSERT INTO `sys_function` VALUES ('859646330203537408', '1', '2017-05-03 13:50:31', '2017-05-03 13:53:35', '0', '新增', 'add', 'createByBiRegion', '10', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859646330237091840', '1', '2017-05-03 13:50:31', '2017-05-03 13:53:52', '0', '编辑', 'edit', 'updateByBiRegion', '20', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859646330258063360', '0', '2017-05-03 13:50:31', '2017-05-03 13:50:31', '0', '刷新', 'refresh', '#', '30', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859646330279034880', '0', '2017-05-03 13:50:31', '2017-05-03 13:50:31', '1', '查询', 'search', '#', '40', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859646330300006400', '1', '2017-05-03 13:50:31', '2017-05-03 13:54:00', '0', '删除', 'del', 'removeByRegion', '50', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859646330320977920', '0', '2017-05-03 13:50:31', '2017-05-03 13:50:31', '0', '退出', 'exit', '#', '100', '859611118329397248', '1');
INSERT INTO `sys_function` VALUES ('859662432480526336', '1', '2017-05-03 14:54:30', '2017-05-07 15:58:12', '0', '新增', 'add', 'createByBiMerchant', '10', '859662019521937408', '1');
INSERT INTO `sys_function` VALUES ('859662432505692160', '1', '2017-05-03 14:54:30', '2017-05-07 15:58:23', '0', '编辑', 'edit', 'updateByBiMerchant', '20', '859662019521937408', '1');
INSERT INTO `sys_function` VALUES ('859662432526663680', '0', '2017-05-03 14:54:30', '2017-05-03 14:54:30', '0', '刷新', 'refresh', '#', '30', '859662019521937408', '1');
INSERT INTO `sys_function` VALUES ('859662432547635200', '1', '2017-05-03 14:54:30', '2017-05-07 15:58:32', '0', '删除', 'del', 'removeByBiMerchant', '50', '859662019521937408', '1');
INSERT INTO `sys_function` VALUES ('859662432568606720', '0', '2017-05-03 14:54:30', '2017-05-03 14:54:30', '0', '退出', 'exit', '#', '100', '859662019521937408', '1');
INSERT INTO `sys_function` VALUES ('859669123632726016', '2', '2017-05-03 15:21:05', '2017-05-07 15:59:18', '0', '新增', 'add', 'createByBiPartType', '10', '859669084835414016', '1');
INSERT INTO `sys_function` VALUES ('859669123657891840', '2', '2017-05-03 15:21:05', '2017-05-07 15:59:13', '0', '编辑', 'edit', 'updateByBiPartType', '20', '859669084835414016', '1');
INSERT INTO `sys_function` VALUES ('859669123683057664', '0', '2017-05-03 15:21:05', '2017-05-03 15:21:05', '0', '刷新', 'refresh', '#', '30', '859669084835414016', '1');
INSERT INTO `sys_function` VALUES ('859669123708223488', '2', '2017-05-03 15:21:05', '2017-05-07 15:59:08', '0', '删除', 'del', 'removeByBiPartType', '50', '859669084835414016', '1');
INSERT INTO `sys_function` VALUES ('859669123729195008', '0', '2017-05-03 15:21:05', '2017-05-03 15:21:05', '0', '退出', 'exit', '#', '100', '859669084835414016', '1');
INSERT INTO `sys_function` VALUES ('859672001449558016', '1', '2017-05-03 15:32:31', '2017-05-07 16:00:04', '0', '新增', 'add', 'createByBiPart', '10', '859671955752615936', '1');
INSERT INTO `sys_function` VALUES ('859672001470529536', '1', '2017-05-03 15:32:31', '2017-05-07 16:00:08', '0', '编辑', 'edit', 'udpateByBiPart', '20', '859671955752615936', '1');
INSERT INTO `sys_function` VALUES ('859672001495695360', '0', '2017-05-03 15:32:31', '2017-05-03 15:32:31', '0', '刷新', 'refresh', '#', '30', '859671955752615936', '1');
INSERT INTO `sys_function` VALUES ('859672001516666880', '1', '2017-05-03 15:32:31', '2017-05-07 16:00:13', '0', '删除', 'del', 'removeByBiPart', '50', '859671955752615936', '1');
INSERT INTO `sys_function` VALUES ('859672001676050432', '0', '2017-05-03 15:32:31', '2017-05-03 15:32:31', '0', '退出', 'exit', '#', '100', '859671955752615936', '1');
INSERT INTO `sys_function` VALUES ('859675929578831872', '2', '2017-05-03 15:48:08', '2017-05-07 16:02:11', '0', '新增', 'add', 'createByBiOrgType', '10', '859675898276741120', '1');
INSERT INTO `sys_function` VALUES ('859675929595609088', '2', '2017-05-03 15:48:08', '2017-05-07 16:02:16', '0', '编辑', 'edit', 'updateByBiOrgType', '20', '859675898276741120', '1');
INSERT INTO `sys_function` VALUES ('859675929616580608', '0', '2017-05-03 15:48:08', '2017-05-03 15:48:08', '0', '刷新', 'refresh', '#', '30', '859675898276741120', '1');
INSERT INTO `sys_function` VALUES ('859675929637552128', '2', '2017-05-03 15:48:08', '2017-05-07 16:02:20', '0', '删除', 'del', 'removeByBiOrgType', '50', '859675898276741120', '1');
INSERT INTO `sys_function` VALUES ('859675929654329344', '0', '2017-05-03 15:48:08', '2017-05-03 15:48:08', '0', '退出', 'exit', '#', '100', '859675898276741120', '1');
INSERT INTO `sys_function` VALUES ('859679388835250176', '1', '2017-05-03 16:01:53', '2017-05-07 16:02:28', '0', '新增', 'add', 'createByBiOrg', '10', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859679388860416000', '1', '2017-05-03 16:01:53', '2017-05-07 16:02:33', '0', '编辑', 'edit', 'updateByBiOrg', '20', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859679388881387520', '0', '2017-05-03 16:01:53', '2017-05-03 16:01:53', '0', '刷新', 'refresh', '#', '30', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859679388902359040', '0', '2017-05-03 16:01:53', '2017-05-03 16:01:53', '0', '查询', 'search', '#', '40', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859679388923330560', '1', '2017-05-03 16:01:53', '2017-05-07 16:02:37', '0', '删除', 'del', 'removeByBiOrg', '50', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859679388944302080', '0', '2017-05-03 16:01:53', '2017-05-03 16:01:53', '0', '退出', 'exit', '#', '100', '859679295470043136', '1');
INSERT INTO `sys_function` VALUES ('859696715404410880', '1', '2017-05-03 17:10:44', '2017-05-07 16:02:52', '0', '新增', 'add', 'createByBiMerchant', '10', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859696715429576704', '1', '2017-05-03 17:10:44', '2017-05-07 16:02:58', '0', '编辑', 'edit', 'updateByBiMerchant', '20', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859696715446353920', '0', '2017-05-03 17:10:44', '2017-05-03 17:10:44', '0', '刷新', 'refresh', '#', '30', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859696715467325440', '0', '2017-05-03 17:10:44', '2017-05-03 17:10:44', '0', '查询', 'search', '#', '40', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859696715488296960', '1', '2017-05-03 17:10:44', '2017-05-07 16:03:02', '0', '删除', 'del', 'removeByBiMerchant', '50', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859696715509268480', '0', '2017-05-03 17:10:44', '2017-05-03 17:10:44', '0', '退出', 'exit', '#', '100', '859695520673693696', '1');
INSERT INTO `sys_function` VALUES ('859973201214570496', '2', '2017-05-04 11:29:23', '2017-05-07 16:05:14', '0', '新增', 'add', 'createByBiUnion', '10', '859973085455974400', '1');
INSERT INTO `sys_function` VALUES ('859973201235542016', '2', '2017-05-04 11:29:23', '2017-05-07 16:05:19', '0', '编辑', 'edit', 'updateByBiUnion', '20', '859973085455974400', '1');
INSERT INTO `sys_function` VALUES ('859973201256513536', '0', '2017-05-04 11:29:23', '2017-05-04 11:29:23', '0', '刷新', 'refresh', '#', '30', '859973085455974400', '1');
INSERT INTO `sys_function` VALUES ('859973201273290752', '2', '2017-05-04 11:29:23', '2017-05-07 16:05:23', '0', '删除', 'del', 'removeByBiUnion', '50', '859973085455974400', '1');
INSERT INTO `sys_function` VALUES ('859973201294262272', '0', '2017-05-04 11:29:23', '2017-05-04 11:29:23', '0', '退出', 'exit', '#', '100', '859973085455974400', '1');
INSERT INTO `sys_function` VALUES ('860028764225011712', '1', '2017-05-04 15:10:10', '2017-05-07 16:05:05', '0', '新增', 'add', 'createByBiMerchantNo', '10', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860028764254371840', '1', '2017-05-04 15:10:10', '2017-05-07 16:05:31', '0', '编辑', 'edit', 'udpateByBiMerchantNo', '20', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860028764271149056', '0', '2017-05-04 15:10:10', '2017-05-04 15:10:10', '0', '刷新', 'refresh', '#', '30', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860028764287926272', '0', '2017-05-04 15:10:10', '2017-05-04 15:10:10', '0', '查询', 'search', '#', '40', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860028764313092096', '1', '2017-05-04 15:10:10', '2017-05-07 16:05:35', '0', '删除', 'del', 'removeByBiMerchantNo', '50', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860028764334063616', '0', '2017-05-04 15:10:10', '2017-05-04 15:10:10', '0', '退出', 'exit', '#', '100', '860028714602201088', '1');
INSERT INTO `sys_function` VALUES ('860035859817168896', '1', '2017-05-04 15:38:22', '2017-05-07 16:05:46', '0', '新增', 'add', 'createByBiDevice', '10', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860035859846529024', '1', '2017-05-04 15:38:22', '2017-05-07 16:05:50', '0', '编辑', 'edit', 'updateByBiDevice', '20', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860035859867500544', '0', '2017-05-04 15:38:22', '2017-05-04 15:38:22', '0', '刷新', 'refresh', '#', '30', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860035859892666368', '0', '2017-05-04 15:38:22', '2017-05-04 15:38:22', '0', '查询', 'search', '#', '40', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860035859909443584', '1', '2017-05-04 15:38:22', '2017-05-07 16:05:55', '0', '删除', 'del', 'removeByBiDevice', '50', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860035859938803712', '0', '2017-05-04 15:38:22', '2017-05-04 15:38:22', '0', '退出', 'exit', '#', '100', '860035805001809920', '1');
INSERT INTO `sys_function` VALUES ('860040273286135808', '2', '2017-05-04 15:55:54', '2017-05-07 16:06:29', '0', '上报', 'handup', 'sendByMerFaultRepair', '10', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860040273315495936', '0', '2017-05-04 15:55:54', '2017-05-04 15:55:54', '1', '编辑', 'edit', '#', '20', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860040273336467456', '0', '2017-05-04 15:55:54', '2017-05-04 15:55:54', '0', '刷新', 'refresh', '#', '30', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860040273357438976', '0', '2017-05-04 15:55:54', '2017-05-04 15:55:54', '0', '查询', 'search', '#', '40', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860040273378410496', '0', '2017-05-04 15:55:54', '2017-05-04 15:55:54', '1', '删除', 'del', '#', '50', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860040273395187712', '0', '2017-05-04 15:55:54', '2017-05-04 15:55:54', '0', '退出', 'exit', '#', '100', '860040098161360896', '1');
INSERT INTO `sys_function` VALUES ('860390607711895552', '1', '2017-05-05 15:08:00', '2017-05-07 16:06:41', '0', '新增', 'add', 'createByHisSettle', '10', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860390607741255680', '1', '2017-05-05 15:08:00', '2017-05-07 16:06:49', '0', '编辑', 'edit', 'updateByHisSettle', '20', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860390607762227200', '0', '2017-05-05 15:08:00', '2017-05-05 15:08:00', '0', '刷新', 'refresh', '#', '30', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860390607787393024', '0', '2017-05-05 15:08:00', '2017-05-05 15:08:00', '0', '查询', 'search', '#', '40', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860390607812558848', '1', '2017-05-05 15:08:00', '2017-05-07 16:06:54', '0', '删除', 'del', 'removeByHisSettle', '50', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860390607846113280', '0', '2017-05-05 15:08:00', '2017-05-05 15:08:00', '0', '退出', 'exit', '#', '100', '860390562153365504', '1');
INSERT INTO `sys_function` VALUES ('860561910364372992', '2', '2017-05-06 02:28:42', '2017-05-07 16:06:16', '0', '受理', 'seize', 'seizeByMerFaultRepair', '10', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860561910381150208', '2', '2017-05-06 02:28:42', '2017-05-07 16:06:22', '0', '驳回', 'reject', 'rejectByMerFaultRepair', '20', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860561910397927424', '0', '2017-05-06 02:28:42', '2017-05-06 02:28:42', '0', '刷新', 'refresh', '#', '30', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860561910418898944', '0', '2017-05-06 02:28:42', '2017-05-06 02:28:42', '0', '查询', 'search', '#', '40', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860561910435676160', '0', '2017-05-06 02:28:42', '2017-05-06 02:28:42', '1', '删除', 'del', '#', '50', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860561910452453376', '0', '2017-05-06 02:28:42', '2017-05-06 02:28:42', '0', '退出', 'exit', '#', '100', '860559549583589376', '1');
INSERT INTO `sys_function` VALUES ('860915986180603904', '1', '2017-05-07 01:55:40', '2017-05-07 16:07:01', '0', '新增', 'add', 'createByHisSettle', '10', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('860915986197381120', '1', '2017-05-07 01:55:40', '2017-05-07 16:07:06', '0', '编辑', 'edit', 'updateByHisSettle', '20', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('860915986214158336', '0', '2017-05-07 01:55:40', '2017-05-07 01:55:40', '0', '刷新', 'refresh', '#', '30', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('860915986230935552', '0', '2017-05-07 01:55:40', '2017-05-07 01:55:40', '0', '查询', 'search', '#', '40', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('860915986243518464', '1', '2017-05-07 01:55:40', '2017-05-07 16:07:13', '0', '删除', 'del', 'removeByHisSettle', '50', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('860915986260295680', '0', '2017-05-07 01:55:40', '2017-05-07 01:55:40', '0', '退出', 'exit', '#', '100', '860915789484523520', '1');
INSERT INTO `sys_function` VALUES ('861384333426950144', '0', '2017-05-08 08:56:43', '2017-05-08 08:56:43', '1', '上报', 'handup', '#', '10', '861384227910844416', '1');
INSERT INTO `sys_function` VALUES ('861384333456310272', '0', '2017-05-08 08:56:43', '2017-05-08 08:56:43', '0', '刷新', 'refresh', '#', '30', '861384227910844416', '1');
INSERT INTO `sys_function` VALUES ('861384333485670400', '0', '2017-05-08 08:56:43', '2017-05-08 08:56:43', '0', '查询', 'search', '#', '40', '861384227910844416', '1');
INSERT INTO `sys_function` VALUES ('861384333502447616', '0', '2017-05-08 08:56:43', '2017-05-08 08:56:43', '0', '退出', 'exit', '#', '100', '861384227910844416', '1');
INSERT INTO `sys_function` VALUES ('861406095296430080', '0', '2017-05-08 10:23:11', '2017-05-08 10:23:11', '0', '刷新', 'refresh', '#', '30', '861406032587390976', '1');
INSERT INTO `sys_function` VALUES ('861406095329984512', '0', '2017-05-08 10:23:11', '2017-05-08 10:23:11', '0', '查询', 'search', '#', '40', '861406032587390976', '1');
INSERT INTO `sys_function` VALUES ('861406095355150336', '0', '2017-05-08 10:23:11', '2017-05-08 10:23:11', '0', '退出', 'exit', '#', '100', '861406032587390976', '1');
INSERT INTO `sys_function` VALUES ('861439890519228416', '1', '2017-05-08 12:37:23', '2017-05-08 12:37:34', '0', '新增', 'add', 'createByHisConfig', '10', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('861439891123208192', '1', '2017-05-08 12:37:23', '2017-05-08 12:37:40', '0', '编辑', 'edit', 'updateByHisConfig', '20', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('861439891689439232', '0', '2017-05-08 12:37:23', '2017-05-08 12:37:23', '0', '刷新', 'refresh', '#', '30', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('861439892100481024', '1', '2017-05-08 12:37:23', '2017-05-08 12:37:44', '0', '删除', 'del', 'removeByHisConfig', '50', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('861439892528300032', '0', '2017-05-08 12:37:23', '2017-05-08 12:37:23', '0', '退出', 'exit', '#', '100', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('867646883919560704', '1', '2017-05-25 15:41:51', '2017-05-25 15:42:28', '0', '新增', 'add', 'createByHisInhospitalMas', '10', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('867646883948920832', '2', '2017-05-25 15:41:51', '2017-05-25 15:42:33', '0', '编辑', 'edit', 'updateByHisInhospitalMas', '20', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('867646883969892352', '0', '2017-05-25 15:41:51', '2017-05-25 15:41:51', '0', '刷新', 'refresh', '#', '30', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('867646883995058176', '0', '2017-05-25 15:41:51', '2017-05-25 15:41:51', '0', '查询', 'search', '#', '40', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('867646884016029696', '1', '2017-05-25 15:41:51', '2017-05-25 15:42:40', '0', '删除', 'del', 'removeByHisInhospitalMas', '50', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('867646884037001216', '0', '2017-05-25 15:41:51', '2017-05-25 15:41:51', '0', '退出', 'exit', '#', '100', '867646759831076864', '1');
INSERT INTO `sys_function` VALUES ('868170910501175296', '1', '2017-05-27 02:24:09', '2017-05-27 02:24:29', '0', '新增', 'add', 'createByHisBed', '10', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('868170910530535424', '1', '2017-05-27 02:24:09', '2017-05-27 02:24:24', '0', '编辑', 'edit', 'updateByHisBed', '20', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('868170910547312640', '0', '2017-05-27 02:24:09', '2017-05-27 02:24:09', '0', '刷新', 'refresh', '#', '30', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('868170910564089856', '0', '2017-05-27 02:24:09', '2017-05-27 02:24:09', '0', '查询', 'search', '#', '40', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('868170910580867072', '1', '2017-05-27 02:24:09', '2017-05-27 02:24:35', '0', '删除', 'del', 'removeByHisBed', '50', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('868170910601838592', '0', '2017-05-27 02:24:09', '2017-05-27 02:24:09', '0', '退出', 'exit', '#', '100', '868170687343230976', '1');
INSERT INTO `sys_function` VALUES ('882161239722033152', '1', '2017-07-04 16:56:43', '2017-07-04 16:56:52', '0', '登录', 'login', '#', '200', '861439149947748352', '1');
INSERT INTO `sys_function` VALUES ('882847160918343680', '0', '2017-07-06 14:22:20', '2017-07-06 14:22:20', '0', '查询', 'search', '#', '10', '882847057000267776', '1');
INSERT INTO `sys_function` VALUES ('882847255592173568', '0', '2017-07-06 14:22:42', '2017-07-06 14:22:42', '0', '重置', 'reset', '#', '20', '882847057000267776', '1');
INSERT INTO `sys_function` VALUES ('882847305034629120', '0', '2017-07-06 14:22:54', '2017-07-06 14:22:54', '0', '退出', 'exit', '#', '100', '882847057000267776', '1');

-- ----------------------------
-- Table structure for sys_function_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_function_role`;
CREATE TABLE `sys_function_role` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `function_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_function_role
-- ----------------------------
INSERT INTO `sys_function_role` VALUES ('859450572254740480', '0', '2017-05-03 00:52:38', '2017-05-03 00:52:38', '0', '859337822107074560', '859285365540782080');
INSERT INTO `sys_function_role` VALUES ('859450572275712000', '0', '2017-05-03 00:52:38', '2017-05-03 00:52:38', '0', '859337965384499200', '859285365540782080');
INSERT INTO `sys_function_role` VALUES ('859450572288294912', '0', '2017-05-03 00:52:38', '2017-05-03 00:52:38', '0', '859338247996702720', '859285365540782080');
INSERT INTO `sys_function_role` VALUES ('859450572305072128', '0', '2017-05-03 00:52:38', '2017-05-03 00:52:38', '0', '859445575433584640', '859285365540782080');
INSERT INTO `sys_function_role` VALUES ('864049385493757952', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '859337822107074560', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385573449728', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '859337965384499200', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385615392768', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '859338247996702720', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385648947200', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860040273286135808', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385707667456', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860390607711895552', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385745416192', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860390607741255680', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385808330752', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860390607812558848', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385879633920', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860915986180603904', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049385934159872', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860915986197381120', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('864049386039017472', '0', '2017-05-15 17:26:41', '2017-05-15 17:26:41', '0', '860915986243518464', '861438555379990528');
INSERT INTO `sys_function_role` VALUES ('867647242205396992', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859337822107074560', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242222174208', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859337965384499200', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242243145728', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859338247996702720', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242259922944', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859646330203537408', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242276700160', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859646330237091840', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242289283072', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859646330300006400', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242310254592', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859662432480526336', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242327031808', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859662432505692160', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242343809024', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859662432547635200', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242356391936', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859669123632726016', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242368974848', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859669123657891840', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242389946368', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859669123708223488', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242406723584', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859672001449558016', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242423500800', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859672001470529536', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242440278016', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859672001516666880', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242452860928', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859675929578831872', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242469638144', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859675929595609088', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242486415360', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859675929637552128', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242503192576', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859679388835250176', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242524164096', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859679388860416000', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242540941312', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859679388923330560', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242557718528', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859696715404410880', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242570301440', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859696715429576704', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242591272960', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859696715488296960', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242608050176', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859973201214570496', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242629021696', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859973201235542016', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242649993216', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '859973201273290752', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242666770432', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860028764225011712', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242691936256', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860028764254371840', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242708713472', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860028764313092096', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242729684992', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860035859817168896', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242750656512', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860035859846529024', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242767433728', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860035859909443584', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242784210944', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '861439890519228416', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242805182464', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '861439891123208192', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242821959680', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '861439892100481024', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242842931200', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860561910364372992', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242863902720', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860561910381150208', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242880679936', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860390607711895552', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242897457152', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860390607741255680', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242914234368', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860390607812558848', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242931011584', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '860915986243518464', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242947788800', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '867646883919560704', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242964566016', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '867646883948920832', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('867647242981343232', '0', '2017-05-25 15:43:17', '2017-05-25 15:43:17', '0', '867646884016029696', '859463086518566912');
INSERT INTO `sys_function_role` VALUES ('868171194333921280', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '859337822107074560', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194354892800', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '859337965384499200', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194367475712', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '859338247996702720', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194384252928', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860040273286135808', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194401030144', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860390607711895552', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194422001664', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860390607741255680', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194438778880', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860390607812558848', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194451361792', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860915986180603904', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194468139008', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860915986197381120', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194489110528', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '860915986243518464', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194501693440', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '867646883919560704', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194514276352', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '867646883948920832', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194531053568', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '867646884016029696', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194552025088', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '868170910501175296', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194564608000', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '868170910530535424', '860057538396160000');
INSERT INTO `sys_function_role` VALUES ('868171194581385216', '0', '2017-05-27 02:25:17', '2017-05-27 02:25:17', '0', '868170910580867072', '860057538396160000');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `menu_no` varchar(40) DEFAULT NULL,
  `menu_name` varchar(40) DEFAULT NULL,
  `expanded_flag` tinyint(1) DEFAULT NULL,
  `leaf_flag` tinyint(1) DEFAULT NULL,
  `menu_state` varchar(1) DEFAULT NULL,
  `menu_type` varchar(1) DEFAULT NULL,
  `parent_no` varchar(40) DEFAULT NULL,
  `request` varchar(100) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `parent_name` varchar(40) DEFAULT NULL,
  `icon_cls` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '18', null, '2017-05-07 14:09:12', '0', '01', '系统管理', '0', '0', '1', '0', '0', '', '9000', '', '', 'newicon_CgSituation');
INSERT INTO `sys_menu` VALUES ('2', '8', null, '2017-05-07 13:14:17', '0', '0', '', '1', '0', '1', '0', '', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('858149465599508480', '4', '2017-04-29 10:42:30', '2017-05-07 14:23:34', '0', '0103', '用户管理', '0', '1', '1', '', '01', '/sys/mng_SysUser.tz', '20', '', '一级', 'icon_16_20141101_008');
INSERT INTO `sys_menu` VALUES ('858149513620094976', '4', '2017-04-29 10:42:42', '2017-05-07 14:09:46', '0', '0104', '菜单管理', '1', '1', '1', '', '01', '/sys/mng_SysMenu.tz', '900010', '', '一级', 'tableIcon');
INSERT INTO `sys_menu` VALUES ('859282365434822656', '2', '2017-05-02 13:44:15', '2017-05-07 14:09:54', '0', '0105', '角色管理', '1', '1', '1', '', '01', '/sys/mng_SysRole.tz', '900030', '', '系统管理', 's_customer');
INSERT INTO `sys_menu` VALUES ('859302913862795264', '2', '2017-05-02 15:05:54', '2017-05-07 14:10:00', '0', '0106', '角色授权', '1', '1', '1', '', '01', '/sys/mng_SysPerm.tz', '900040', '', '系统管理', 'group_addIcon');
INSERT INTO `sys_menu` VALUES ('859328765514219520', '2', '2017-05-02 16:48:37', '2017-05-07 14:10:19', '0', '0107', '按钮管理', '1', '1', '1', '', '01', '/sys/mng_SysFunction.tz', '900050', '', '系统管理', 's_shenpshezhi');
INSERT INTO `sys_menu` VALUES ('859596207687729152', '13', '2017-05-03 10:31:21', '2017-05-08 12:34:26', '0', '02', '基础信息维护', '0', '0', '1', '0', '0', '', '2000', '', '', 'newicon_system');
INSERT INTO `sys_menu` VALUES ('859611118329397248', '1', '2017-05-03 11:30:36', '2017-05-07 14:11:31', '0', '0201', '区域维护', '1', '1', '1', '', '02', '/bi/mng_BiRegion.tz', '200010', '', '基础信息维护', 'gwtzsq');
INSERT INTO `sys_menu` VALUES ('859662019521937408', '1', '2017-05-03 14:52:51', '2017-05-07 14:12:33', '0', '0202', '商户类型', '1', '1', '1', '', '02', '/bi/mng_BiMerchantType.tz', '200020', '', '基础信息维护', 'icon_16_20141101_010');
INSERT INTO `sys_menu` VALUES ('859669084835414016', '1', '2017-05-03 15:20:56', '2017-05-07 14:12:47', '0', '0203', '配件类型', '1', '1', '1', '', '02', '/bi/mng_BiPartType.tz', '200030', '', '基础信息维护', 'xinwengl');
INSERT INTO `sys_menu` VALUES ('859671955752615936', '2', '2017-05-03 15:32:20', '2017-05-08 11:40:50', '0', '0204', '配件管理', '1', '1', '1', '', '02', '/bi/mng_BiPart.tz', '200040', '', '基础信息维护', 'icon_16_20141101_032');
INSERT INTO `sys_menu` VALUES ('859675898276741120', '2', '2017-05-03 15:48:00', '2017-05-08 11:41:07', '0', '0205', '机构类型', '1', '1', '1', '', '02', '/bi/mng_BiOrgType.tz', '200050', '', '基础信息维护', 'icon_16_20141101_048');
INSERT INTO `sys_menu` VALUES ('859679295470043136', '2', '2017-05-03 16:01:30', '2017-05-08 11:41:24', '0', '0206', '机构管理', '1', '1', '1', '', '02', '/bi/mng_BiOrg.tz', '200060', '', '基础信息维护', 'icon_16_20141101_023');
INSERT INTO `sys_menu` VALUES ('859695520673693696', '1', '2017-05-03 17:05:59', '2017-05-07 14:13:35', '0', '0207', '商家管理', '1', '1', '1', '', '02', '/bi/mng_BiMerchant.tz', '200070', '', '基础信息维护', 'icon_16_20141101_021');
INSERT INTO `sys_menu` VALUES ('859973085455974400', '3', '2017-05-04 11:28:55', '2017-05-08 11:41:36', '0', '0208', '组织管理', '1', '1', '1', '', '02', '/bi/mng_BiUnion.tz', '200080', '', '基础信息维护', 'chart_organisationIcon');
INSERT INTO `sys_menu` VALUES ('860028714602201088', '2', '2017-05-04 15:09:58', '2017-05-08 10:21:15', '0', '0209', '商户管理', '1', '1', '1', '', '02', '/bi/mng_BiMerchantNo.tz', '200090', '', '基础信息维护', 'layout_contentIcon');
INSERT INTO `sys_menu` VALUES ('860035805001809920', '1', '2017-05-04 15:38:09', '2017-05-07 14:14:15', '0', '0210', '终端管理', '1', '1', '1', '', '02', '/bi/mng_BiDevice.tz', '200100', '', '基础信息维护', 'icon_16_20141101_045');
INSERT INTO `sys_menu` VALUES ('860038464131825664', '2', '2017-05-04 15:48:43', '2017-05-07 14:14:23', '0', '03', '业务中心', '0', '0', '1', '', '0', '', '1000', '', '', 'icon_16_20141101_052');
INSERT INTO `sys_menu` VALUES ('860039330121383936', '4', '2017-05-04 15:52:09', '2017-05-08 08:56:18', '0', '04', '商家中心', '0', '0', '1', '', '0', '', '1100', '', '', 'icon_16_20141101_039');
INSERT INTO `sys_menu` VALUES ('860040098161360896', '1', '2017-05-04 15:55:12', '2017-05-07 14:15:09', '0', '0401', '故障报修', '1', '1', '1', '', '04', '/mer/mng_MerFaultRepair.tz', '110010', '', '商家中心', 'icon_16_20141101_066');
INSERT INTO `sys_menu` VALUES ('860390332733325312', '7', '2017-05-05 15:06:55', '2017-07-06 14:21:55', '0', '05', '医保统筹', '1', '0', '1', '', '0', '', '100', '', '', 'icon_16_20141101_029');
INSERT INTO `sys_menu` VALUES ('860390562153365504', '1', '2017-05-05 15:07:49', '2017-05-07 14:22:37', '0', '0501', '收费项目管理', '1', '1', '1', '', '05', '/his/mng_HisSettle.tz', '10010', '', '医保统筹', 'icon_16_20141101_068');
INSERT INTO `sys_menu` VALUES ('860559549583589376', '1', '2017-05-06 02:19:19', '2017-05-07 14:14:34', '0', '0301', '故障受理', '1', '1', '1', '', '03', '/mer/mng_MerFaultRepair.tz', '0', '', '业务中心', 'icon_16_20141101_062');
INSERT INTO `sys_menu` VALUES ('860915789484523520', '2', '2017-05-07 01:54:53', '2017-05-07 14:22:57', '0', '0502', '门诊结算', '1', '1', '1', '', '05', '/his/mng_HisSettleMas.tz', '10020', '', '医保统筹', 'icon_16_20141101_060');
INSERT INTO `sys_menu` VALUES ('861384227910844416', '0', '2017-05-08 08:56:18', '2017-05-08 08:56:18', '0', '0402', '交易查询', '1', '1', '1', '', '04', '/mer/mng_MerMchntTrade.tz', '110001', '', '商家中心', 'icon_16_20141101_040');
INSERT INTO `sys_menu` VALUES ('861406032587390976', '0', '2017-05-08 10:22:56', '2017-05-08 10:22:56', '0', '0503', '统筹查询', '1', '1', '1', '', '05', '/his/mng_HisFeeSettle.tz', '10030', '', '医保统筹', 'icon_16_20141101_017');
INSERT INTO `sys_menu` VALUES ('861439149947748352', '0', '2017-05-08 12:34:26', '2017-05-08 12:34:26', '0', '0211', '社保登录设置', '1', '1', '1', '', '02', '/his/mng_HisConfig.tz', '200110', '', '基础信息维护', 'icon_16_20141101_032');
INSERT INTO `sys_menu` VALUES ('867646759831076864', '0', '2017-05-25 15:41:22', '2017-05-25 15:41:22', '0', '0504', '住院登记', '1', '1', '1', '', '05', '/his/mng_HisInhospitalMas.tz', '10040', '', '医保统筹', 'icon_16_20141101_056');
INSERT INTO `sys_menu` VALUES ('868170687343230976', '2', '2017-05-27 02:23:16', '2017-05-27 02:23:41', '0', '0505', '床位管理', '1', '1', '1', '', '05', '/his/mng_HisBed.tz', '10015', '', '医保统筹', 'icon_16_20141101_063');
INSERT INTO `sys_menu` VALUES ('882847057000267776', '0', '2017-07-06 14:21:55', '2017-07-06 14:21:55', '0', '0506', '结算单查询', '1', '1', '1', '', '05', '/his/mng_HisSettleQuery.tz', '10050', '', '医保统筹', 'icon_16_20141101_003');

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('859457093353078784', '0', '2017-05-03 01:18:33', '2017-05-03 01:18:33', '0', '1', '859285365540782080');
INSERT INTO `sys_menu_role` VALUES ('859457093386633216', '0', '2017-05-03 01:18:33', '2017-05-03 01:18:33', '0', '858149465599508480', '859285365540782080');
INSERT INTO `sys_menu_role` VALUES ('859457093399216128', '0', '2017-05-03 01:18:33', '2017-05-03 01:18:33', '0', '858149513620094976', '859285365540782080');
INSERT INTO `sys_menu_role` VALUES ('868171083667210240', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '1', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083683987456', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '858149465599508480', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083700764672', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859282365434822656', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083717541888', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859302913862795264', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083734319104', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859596207687729152', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083746902016', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859611118329397248', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083767873536', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859662019521937408', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083780456448', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859669084835414016', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083797233664', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859671955752615936', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083814010880', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859675898276741120', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083834982400', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859679295470043136', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083847565312', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859695520673693696', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083864342528', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '859973085455974400', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083881119744', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860028714602201088', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083893702656', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860035805001809920', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083914674176', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '861439149947748352', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083927257088', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860038464131825664', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083944034304', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860559549583589376', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083956617216', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860039330121383936', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083977588736', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860040098161360896', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171083994365952', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '861384227910844416', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084015337472', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860390332733325312', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084036308992', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860390562153365504', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084057280512', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '860915789484523520', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084069863424', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '861406032587390976', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084086640640', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '867646759831076864', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('868171084103417856', '0', '2017-05-27 02:24:50', '2017-05-27 02:24:50', '0', '868170687343230976', '859463086518566912');
INSERT INTO `sys_menu_role` VALUES ('882848693143732224', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '1', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693173092352', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '858149465599508480', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693189869568', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '859282365434822656', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693219229696', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '859302913862795264', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693244395520', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '860039330121383936', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693265367040', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '860040098161360896', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693290532864', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '861384227910844416', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693311504384', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '860390332733325312', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693332475904', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '860390562153365504', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693357641728', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '860915789484523520', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693378613248', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '861406032587390976', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693395390464', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '867646759831076864', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693416361984', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '868170687343230976', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848693433139200', '0', '2017-07-06 14:28:25', '2017-07-06 14:28:25', '0', '882847057000267776', '860057538396160000');
INSERT INTO `sys_menu_role` VALUES ('882848813889355776', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '1', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848813918715904', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '858149465599508480', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848813948076032', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '859282365434822656', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848813969047552', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '859302913862795264', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848813985824768', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '860039330121383936', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814006796288', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '860040098161360896', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814031962112', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '861384227910844416', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814048739328', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '860390332733325312', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814069710848', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '860390562153365504', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814115848192', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '860915789484523520', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814141014016', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '861406032587390976', '861438555379990528');
INSERT INTO `sys_menu_role` VALUES ('882848814161985536', '0', '2017-07-06 14:28:54', '2017-07-06 14:28:54', '0', '882847057000267776', '861438555379990528');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` varchar(1) DEFAULT NULL,
  `role_no` varchar(40) DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  `role_type` varchar(2) DEFAULT NULL,
  `enabled` varchar(1) DEFAULT NULL,
  `union_id` bigint(20) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('859285365540782080', '1', '2017-05-02 13:56:10', '2017-05-04 17:01:35', '0', '001', '银信中心管理员', '0', '0', null, null);
INSERT INTO `sys_role` VALUES ('859463086518566912', '1', '2017-05-03 01:42:22', '2017-05-04 17:01:29', '0', '002', '普通管理员', '1', '0', '860005115052949504', null);
INSERT INTO `sys_role` VALUES ('860057538396160000', '0', '2017-05-04 17:04:30', '2017-05-04 17:04:30', '0', '003', '商家管理员', '1', '1', '860005115052949504', null);
INSERT INTO `sys_role` VALUES ('861438555379990528', '0', '2017-05-08 12:32:04', '2017-05-08 12:32:04', '0', '001', '白花医院管理员', '1', '1', '860005115052949504', '859941344762658816');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `version` int(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fdel_flag` int(1) DEFAULT NULL,
  `account` varchar(40) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `enabled` varchar(1) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  `union_id` bigint(20) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('858211960389369856', '4', '2017-04-29 14:50:50', '2017-05-06 01:45:16', '0', 'tenze', '郑腾志', 'cfcd208495d565ef66e7dff9f98764da', '1', '859285365540782080', '', '银信中心管理员', '860005115052949504', null);
INSERT INTO `sys_user` VALUES ('859223379918454784', '2', '2017-05-02 09:49:52', '2017-05-02 14:23:59', '0', 'tenze01', '郑腾志', 'cfcd208495d565ef66e7dff9f98764da', '1', '859285365540782080', '', '银信中心管理员', null, null);
INSERT INTO `sys_user` VALUES ('859225411773530112', '3', '2017-05-02 09:57:56', '2017-05-03 01:42:37', '0', 'tenze1', '郑腾志', 'cfcd208495d565ef66e7dff9f98764da', '1', '859463086518566912', '', '普通管理员', null, null);
INSERT INTO `sys_user` VALUES ('859291795253624832', '7', '2017-05-02 14:21:43', '2017-05-08 10:57:28', '0', 'yx', '银信管理员', 'cfcd208495d565ef66e7dff9f98764da', '1', '859463086518566912', '', '普通管理员', '860005115052949504', null);
INSERT INTO `sys_user` VALUES ('860058308642340864', '1', '2017-05-04 17:07:34', '2017-05-08 10:57:09', '0', 'bhyy', '白花医院', 'cfcd208495d565ef66e7dff9f98764da', '1', '860057538396160000', '', '商家管理员', '860005115052949504', '859941344762658816');
INSERT INTO `sys_user` VALUES ('861417962941186048', '0', '2017-05-08 11:10:21', '2017-05-08 11:10:21', '0', 'dzyy', '多祝医院', 'cfcd208495d565ef66e7dff9f98764da', '1', '860057538396160000', '', '商家管理员', '860005115052949504', '861417925897093120');
INSERT INTO `sys_user` VALUES ('862921702160465920', '1', '2017-05-12 14:45:40', '2017-05-12 14:51:29', '1', 'wyt', 'wyt', 'cfcd208495d565ef66e7dff9f98764da', '1', '859463086518566912', '', '普通管理员', '860005115052949504', '859941344762658816');

-- ----------------------------
-- Table structure for tbl_base_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_base_user`;
CREATE TABLE `tbl_base_user` (
  `id` bigint(20) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `faccount` varchar(40) DEFAULT NULL,
  `fusername` varchar(40) DEFAULT NULL,
  `fpassword` varchar(40) DEFAULT NULL,
  `flast_login` datetime DEFAULT NULL,
  `fenabled` tinyint(4) DEFAULT NULL,
  `fdel_flag` tinyint(4) DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_base_user
-- ----------------------------
INSERT INTO `tbl_base_user` VALUES ('1', '2', '2016-11-30 13:57:14', 'tenze', 'tenze', '0', null, '1', '0', '2016-12-03 09:52:58');
INSERT INTO `tbl_base_user` VALUES ('2', '3', '2016-11-30 13:58:33', 'tenze002', 'tenze002111234', '0', '2016-12-02 10:50:23', '1', '1', '2016-12-02 16:29:16');
INSERT INTO `tbl_base_user` VALUES ('804492245469233152', '0', '2016-12-02 09:07:53', 'tt', '郑腾志', '0', null, '1', '1', '2016-12-02 16:29:16');
INSERT INTO `tbl_base_user` VALUES ('804578544557490176', '0', null, 'abc', 'abc', '0', '2016-12-02 14:50:48', '1', '1', '2016-12-02 16:29:11');
INSERT INTO `tbl_base_user` VALUES ('804612441466994688', '0', '2016-12-02 17:05:29', 'aaa', 'aa', 'aa', null, '1', '1', '2016-12-02 17:05:38');
INSERT INTO `tbl_base_user` VALUES ('804718334330273792', '0', '2016-12-03 00:06:16', null, null, null, null, '1', '1', '2016-12-03 09:46:25');
INSERT INTO `tbl_base_user` VALUES ('804866066890096640', '0', '2016-12-03 09:53:18', 'tenze001', 'tenze001', '0', null, '1', '0', null);
INSERT INTO `tbl_base_user` VALUES ('853460418142666752', '0', '2017-04-16 12:09:54', null, null, null, null, '1', '0', null);
