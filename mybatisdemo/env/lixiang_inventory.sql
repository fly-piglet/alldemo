/*
 Navicat Premium Data Transfer

 Source Server         : 盈通-励响-开发环境
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 47.106.64.126:3306
 Source Schema         : lixiang_inventory

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 21/06/2019 15:29:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for igr_detail_scf
-- ----------------------------
DROP TABLE IF EXISTS `igr_detail_scf`;
CREATE TABLE `igr_detail_scf` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `igr_id` varchar(32) DEFAULT NULL COMMENT '收货单id',
  `igr_no` varchar(32) DEFAULT NULL COMMENT '收货单编号',
  `igr_no_desc` varchar(32) DEFAULT NULL COMMENT '收货单描述',
  `line_number` int(11) DEFAULT NULL COMMENT '明细行项目编号',
  `synergy_workfolw_step_id` varchar(32) DEFAULT NULL COMMENT '协同流程步骤id',
  `up_business_no` varchar(32) DEFAULT NULL COMMENT '上级业务编号',
  `status` varchar(12) DEFAULT NULL COMMENT '业务状态',
  `system_status` tinyint(4) DEFAULT NULL COMMENT '系统状态',
  `coordinate_code` varchar(32) DEFAULT NULL COMMENT '协同编号',
  `coordinate_code_desc` varchar(128) DEFAULT NULL COMMENT '协同描述',
  `service_product_no` varchar(32) DEFAULT NULL COMMENT '服务产品编号',
  `product_code` varchar(50) DEFAULT NULL COMMENT '产品编号',
  `product_specifications` varchar(50) DEFAULT NULL COMMENT '产品规格型号',
  `product_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `ipgi_id` varchar(32) DEFAULT NULL COMMENT '发货单id',
  `ipgi_no` varchar(32) DEFAULT NULL COMMENT '发货单编号',
  `ipgi_no_desc` varchar(128) DEFAULT NULL COMMENT '发货单描述',
  `order_Id` varchar(32) DEFAULT NULL COMMENT '订单id',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `order_no_desc` varchar(128) DEFAULT NULL COMMENT '订单编号描述',
  `purchase_receipt_number` decimal(15,3) DEFAULT NULL COMMENT '采购确认签收数量数量',
  `sales_receipt_number` decimal(15,3) DEFAULT NULL COMMENT '销售确认签收数量数量',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `price` varchar(50) DEFAULT NULL COMMENT '单价',
  `excluding_tax_amount` varchar(50) DEFAULT NULL COMMENT '未含税金额',
  `taxes_amount` varchar(50) DEFAULT NULL COMMENT '税金',
  `tax_all_price` varchar(50) DEFAULT NULL COMMENT '含税总价',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `create_user_name` varchar(30) DEFAULT NULL COMMENT '创建用户名',
  `op_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `op_user` varchar(32) DEFAULT NULL COMMENT '修改用户',
  `op_user_name` varchar(30) DEFAULT NULL COMMENT '修改用户名',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `inv_no` varchar(400) DEFAULT NULL COMMENT '发票编号',
  `inv_no_desc` varchar(128) DEFAULT NULL COMMENT '发票编号描述',
  `inv_detial_id` varchar(32) DEFAULT NULL COMMENT '发票明细编号',
  `delivery_date` date DEFAULT NULL COMMENT '发货日期',
  `attr1` varchar(64) DEFAULT NULL COMMENT '备用字段1',
  `attr2` varchar(64) DEFAULT NULL COMMENT '备用字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '备用字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '备用字段4',
  `sort_index` bigint(13) DEFAULT NULL COMMENT '排序值',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`),
  KEY `index_igr_detail_scf_ft_coordinate_code` (`coordinate_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货明细';

-- ----------------------------
-- Table structure for igr_info_scf
-- ----------------------------
DROP TABLE IF EXISTS `igr_info_scf`;
CREATE TABLE `igr_info_scf` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `igr_no` varchar(32) DEFAULT NULL COMMENT '收货单编号',
  `igr_type` varchar(20) DEFAULT NULL COMMENT '收货单类型',
  `top_desc` varchar(128) DEFAULT NULL COMMENT '收货单描述',
  `service_product_id` varchar(32) DEFAULT NULL COMMENT '服务产品id',
  `service_product_no` varchar(32) DEFAULT NULL COMMENT '服务产品编号',
  `synergy_workfolw_step_id` varchar(32) DEFAULT NULL COMMENT '协同流程步骤id',
  `up_business_no` varchar(32) DEFAULT NULL COMMENT '上级业务编号',
  `coordinate_code` varchar(320) DEFAULT NULL COMMENT '协同编号',
  `coordinate_code_desc` varchar(128) DEFAULT NULL COMMENT '协同描述',
  `status` varchar(12) DEFAULT NULL COMMENT '状态',
  `system_status` tinyint(4) DEFAULT NULL COMMENT '系统状态',
  `move_type` varchar(32) DEFAULT NULL COMMENT '移动类型',
  `ipgi_id` varchar(32) DEFAULT NULL COMMENT '发货单id',
  `ipgi_no` varchar(32) DEFAULT NULL COMMENT '发货单编号',
  `ipgi_no_desc` varchar(128) DEFAULT NULL COMMENT '发货单描述',
  `order_Id` varchar(32) DEFAULT NULL COMMENT '订单id',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `order_no_desc` varchar(128) DEFAULT NULL COMMENT '订单编号描述',
  `receipt_user_no` varchar(32) DEFAULT NULL COMMENT '收货方会员编号',
  `receipt_user_name` varchar(50) DEFAULT NULL COMMENT '收货方会员名称',
  `delivery_user_no` varchar(32) DEFAULT NULL COMMENT '发货方会员编号',
  `delivery_user_name` varchar(50) DEFAULT NULL COMMENT '发货方会员名称',
  `order_company_mem_num` varchar(32) DEFAULT NULL COMMENT '接单公司会员编号',
  `order_company_mem_name` varchar(128) DEFAULT NULL COMMENT '接单公司会员名称',
  `seller_no` varchar(32) DEFAULT NULL COMMENT '销售员编号',
  `seller_name` varchar(32) DEFAULT NULL COMMENT '销售员名称',
  `receipt_person` varchar(32) DEFAULT NULL COMMENT '收货人编号',
  `receipt_person_name` varchar(32) DEFAULT NULL COMMENT '收货人名称',
  `logistics_info` varchar(320) DEFAULT NULL COMMENT '物流信息',
  `goods_receipt_date` date DEFAULT NULL COMMENT '收货日期',
  `inv_no` varchar(32) DEFAULT NULL COMMENT '发票编号',
  `inv_no_desc` varchar(128) DEFAULT NULL COMMENT '发票编号描述',
  `customer_order_no` varchar(32) DEFAULT NULL COMMENT '客户订单编号',
  `customer_order_no_desc` varchar(128) DEFAULT NULL COMMENT '客户订单描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `create_user_name` varchar(30) DEFAULT NULL COMMENT '创建用户名',
  `op_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `op_user` varchar(32) DEFAULT NULL COMMENT '修改用户',
  `op_user_name` varchar(30) DEFAULT NULL COMMENT '修改用户名',
  `remark` varchar(320) DEFAULT NULL COMMENT '备注说明',
  `transport_method` varchar(32) DEFAULT NULL COMMENT '运输方式',
  `transport_company_usre_no` varchar(32) DEFAULT NULL COMMENT '运输公司会员编号',
  `transport_company_usre_no_desc` varchar(128) DEFAULT NULL COMMENT '运输公司会员编号描述',
  `transport_company_usre_name` varchar(32) DEFAULT NULL COMMENT '运输公司会员名',
  `post_date` date DEFAULT NULL COMMENT '过账日期',
  `attr1` varchar(64) DEFAULT NULL COMMENT '备用字段1',
  `attr2` varchar(64) DEFAULT NULL COMMENT '备用字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '备用字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '备用字段4',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`),
  KEY `AK_Unique_inventory_receipt_info_receipt_no` (`igr_no`),
  KEY `index_igr_info_scf_ft_coordinate_code` (`coordinate_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货信息';

SET FOREIGN_KEY_CHECKS = 1;
