# MySQL-Front 5.1  (Build 3.20)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 127.0.0.1    Database: iz_coupon
# ------------------------------------------------------
# Server version 5.1.30-community

#
# Source for table iz_admin
#

CREATE TABLE `iz_admin` (
  `USER_ID` varchar(64) NOT NULL COMMENT '用户ID',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(18) DEFAULT NULL COMMENT '密码',
  `NICK_NAME` varchar(20) DEFAULT NULL COMMENT '昵称',
  `SEX` tinyint(1) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机',
  `TEL` varchar(20) DEFAULT NULL COMMENT '电话',
  `ADDRESS_ID` int(10) DEFAULT NULL COMMENT '地址',
  `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `LAST_VISIT` longtext COMMENT '上次访问时间',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  `user_type` varchar(10) DEFAULT 'P' COMMENT '用户类型　会员:P，商户:B,管理人员:M',
  `show_order` int(10) DEFAULT '0' COMMENT '显示顺序',
  `disabled` tinyint(1) DEFAULT '0' COMMENT '是否禁用',
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='网站后台用户表';

#
# Dumping data for table iz_admin
#
LOCK TABLES `iz_admin` WRITE;
/*!40000 ALTER TABLE `iz_admin` DISABLE KEYS */;

INSERT INTO `iz_admin` VALUES ('02ff821b8758405f93fd78a40342706f','7','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:28','2012-01-19 21:06:28',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('2','Teee','6916d323d8461bae','Test',NULL,NULL,NULL,NULL,NULL,NULL,'2012-01-18 22:45:21',NULL,0,'M',1,0);
INSERT INTO `iz_admin` VALUES ('237b09af5b6244509f53c9fdfe755e22','8','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:34','2012-01-19 21:06:34',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('2761cb5cdf71497694ac148de2f1fd79','2','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:05:57','2012-01-19 21:05:57',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('3','superadmin','e6b92e28c43dccd4','管理员ROOT',NULL,NULL,NULL,NULL,NULL,NULL,'2012-01-20 00:53:20','Fri Feb 10 06:32:05 CST 2012',0,'M',0,0);
INSERT INTO `iz_admin` VALUES ('68ed161008cc41f3aed2922d539af6a7','6','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:17','2012-01-19 21:06:17',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('6b5fcb5b49c84ad09c0b8e4eedfb254f','5','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:12','2012-01-19 21:06:12',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('746047d6e91944fd90e362f67c9eb49d','4','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:07','2012-01-19 21:06:07',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('80aa2131722045f0a8f8d92f92215ebf','3','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:01','2012-01-19 21:06:01',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('915baa1cd59b4d3989937e0fd66f2938','9','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:06:42','2012-01-19 21:06:42',NULL,0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('dd0a228f95094ed7a6d24a50d60a8ab2','1','6e8662b6d7f37c27','',NULL,NULL,NULL,NULL,NULL,'2012-01-19 21:05:52','2012-01-19 21:05:52','Thu Jan 19 22:01:51 CST 2012',0,'P',0,0);
INSERT INTO `iz_admin` VALUES ('df78eff3fbe249bfa3ea5133779e292e','admin1','90ea742b47cefb57','管理员1',NULL,NULL,NULL,NULL,NULL,NULL,'2012-01-19 19:55:22',NULL,0,'M',0,0);
INSERT INTO `iz_admin` VALUES ('feb20991150746628b95c4a73296a454','测试','129e65a297d0a368','aaa',NULL,NULL,NULL,NULL,NULL,NULL,'2012-01-18 22:44:36',NULL,0,'P',3,0);
/*!40000 ALTER TABLE `iz_admin` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_bulletin
#

CREATE TABLE `iz_bulletin` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `content` text COMMENT '公告内容',
  `pub_person` int(10) DEFAULT NULL COMMENT '公告发布者',
  `pub_time` bigint(20) DEFAULT NULL COMMENT '公告发布时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公告表';

#
# Dumping data for table iz_bulletin
#
LOCK TABLES `iz_bulletin` WRITE;
/*!40000 ALTER TABLE `iz_bulletin` DISABLE KEYS */;

INSERT INTO `iz_bulletin` VALUES (1,'优惠劵平台全面上线，欢迎广大用户选购！',1,NULL);
INSERT INTO `iz_bulletin` VALUES (2,'春节年夜饭优惠火热进行中，详见相关商户的活动！',1,NULL);
/*!40000 ALTER TABLE `iz_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_busscircl
#

CREATE TABLE `iz_busscircl` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商圈ID',
  `BC_NAME` varchar(32) DEFAULT NULL COMMENT '商圈名',
  `BC_DESCRIPTION` text COMMENT '商圈描述',
  `BELONG_CITY` int(11) NOT NULL DEFAULT '0',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_busscircl
#
LOCK TABLES `iz_busscircl` WRITE;
/*!40000 ALTER TABLE `iz_busscircl` DISABLE KEYS */;

INSERT INTO `iz_busscircl` VALUES (1,'高升桥','高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎',1,0);
INSERT INTO `iz_busscircl` VALUES (2,'春熙路','春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈',1,0);
INSERT INTO `iz_busscircl` VALUES (3,'建设路','诚然成华区着力打造的建设路商圈离成熟商圈的距离还是较远的，几个大的卖场的出现并不能说明此地已经形成了商圈。\r\n\r\n    相比成都其它成熟商圈建设路商圈幅射范围十分有限，不论是向外幅射还是向内幅射，幅射面基本还局限在老东效这一块。如果不解决好这个问题，建设路商圈发展潜力并不大。究其原因，因为建设路本身就是一条断头路，虽然两边分别连接一环和二环，但缺少射状道路。两条辅路建设北路和建设南路向外也是断头路，不能直达外延，不能给建设路商圈有力的支撑。而且建设路T字形态也与其他成熟商圈规划的十字中心形态相左，不利与商圈发展。',1,0);
INSERT INTO `iz_busscircl` VALUES (5,'八宝街','八宝街八宝街八宝街商圈很有名哟',1,0);
INSERT INTO `iz_busscircl` VALUES (6,'磨子桥','磨子桥磨子桥磨子桥磨子桥磨子桥磨子桥',1,0);
/*!40000 ALTER TABLE `iz_busscircl` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_busscircl_busscircl_categor
#

CREATE TABLE `iz_busscircl_busscircl_categor` (
  `busscircl_category_id` int(10) NOT NULL AUTO_INCREMENT,
  `busscircl_id` int(10) DEFAULT NULL,
  `category_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`busscircl_category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='商圈-目录对应表';

#
# Dumping data for table iz_busscircl_busscircl_categor
#
LOCK TABLES `iz_busscircl_busscircl_categor` WRITE;
/*!40000 ALTER TABLE `iz_busscircl_busscircl_categor` DISABLE KEYS */;

INSERT INTO `iz_busscircl_busscircl_categor` VALUES (1,20,92);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (2,66,29);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (3,65,12);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (4,22,2);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (5,95,67);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (6,5,9);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (7,51,6);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (8,60,76);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (9,17,77);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (10,71,55);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (11,69,21);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (12,1,22);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (13,79,51);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (14,37,98);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (15,19,63);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (16,16,65);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (17,64,8);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (18,31,0);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (19,57,23);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (20,68,96);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (21,9,32);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (22,91,3);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (23,36,93);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (24,67,39);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (25,2,80);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (26,0,58);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (27,6,53);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (28,23,17);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (29,12,18);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (30,94,7);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (31,27,68);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (32,73,59);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (33,55,4);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (34,50,60);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (35,98,45);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (36,82,91);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (37,93,84);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (38,15,49);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (39,42,74);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (40,92,61);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (41,45,71);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (42,63,56);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (43,32,44);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (44,81,47);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (45,62,52);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (46,33,50);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (47,53,46);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (48,72,36);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (49,78,64);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (50,89,25);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (51,40,30);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (52,83,31);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (53,59,94);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (54,24,10);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (55,84,90);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (56,86,41);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (57,21,57);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (58,8,42);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (59,99,99);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (60,30,54);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (61,75,86);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (62,54,83);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (63,26,14);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (64,85,5);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (65,56,72);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (66,76,88);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (67,49,87);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (68,41,70);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (69,61,85);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (70,88,24);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (71,47,62);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (72,7,38);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (73,11,16);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (74,70,37);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (75,28,89);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (76,87,81);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (77,44,26);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (78,48,19);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (79,90,95);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (80,77,34);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (81,97,33);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (82,80,73);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (83,39,43);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (84,58,69);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (85,3,66);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (86,29,40);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (87,43,28);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (88,74,75);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (89,35,78);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (90,52,97);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (91,14,13);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (92,25,15);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (93,13,82);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (94,4,20);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (95,34,11);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (96,38,79);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (97,46,35);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (98,18,1);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (99,96,27);
INSERT INTO `iz_busscircl_busscircl_categor` VALUES (100,10,48);
/*!40000 ALTER TABLE `iz_busscircl_busscircl_categor` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_busscircl_categories
#

CREATE TABLE `iz_busscircl_categories` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_category_id` int(10) DEFAULT NULL,
  `category_name` varchar(200) DEFAULT NULL,
  `category_desc` varchar(1000) DEFAULT NULL,
  `sysflag` int(1) DEFAULT NULL,
  `isvisible` int(1) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商圈目录表';

#
# Dumping data for table iz_busscircl_categories
#
LOCK TABLES `iz_busscircl_categories` WRITE;
/*!40000 ALTER TABLE `iz_busscircl_categories` DISABLE KEYS */;

/*!40000 ALTER TABLE `iz_busscircl_categories` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_cart
#

CREATE TABLE `iz_cart` (
  `CART_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '用户ID',
  `GOODS_ID` int(10) DEFAULT NULL COMMENT '商品ID',
  `GOODS_NUM` int(10) DEFAULT NULL COMMENT '商品数量',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '加入时间',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  PRIMARY KEY (`CART_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Dumping data for table iz_cart
#
LOCK TABLES `iz_cart` WRITE;
/*!40000 ALTER TABLE `iz_cart` DISABLE KEYS */;

/*!40000 ALTER TABLE `iz_cart` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_category
#

CREATE TABLE `iz_category` (
  `CAT_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `P_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `CAT_DESC` varchar(1000) DEFAULT NULL COMMENT '类别描述',
  `CAT_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '种类分类，1代表是商户分类，2代表优惠券分类，3代表促销活动分类',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATOR_ID` int(10) DEFAULT NULL COMMENT '创建人ID',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  PRIMARY KEY (`CAT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品类别';

#
# Dumping data for table iz_category
#
LOCK TABLES `iz_category` WRITE;
/*!40000 ALTER TABLE `iz_category` DISABLE KEYS */;

INSERT INTO `iz_category` VALUES (1,NULL,'服装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (2,1,'女装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (3,1,'童装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (4,NULL,'餐饮',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (5,4,'火锅',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (6,NULL,'家电',0,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `iz_category` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_city
#

CREATE TABLE `iz_city` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主ID',
  `COUNTRY` varchar(32) DEFAULT NULL COMMENT '国家',
  `PROVINCE` varchar(32) DEFAULT NULL COMMENT '省份、自治区',
  `CITY` varchar(32) DEFAULT NULL COMMENT '城市',
  `P_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `DISTRICT` varchar(32) DEFAULT NULL COMMENT '行政区',
  `ISOPEN` tinyint(1) DEFAULT NULL COMMENT '是否开放',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='省份和城市字典';

#
# Dumping data for table iz_city
#
LOCK TABLES `iz_city` WRITE;
/*!40000 ALTER TABLE `iz_city` DISABLE KEYS */;

INSERT INTO `iz_city` VALUES (1,'中国','四川','成都',0,'',0);
INSERT INTO `iz_city` VALUES (2,'','','',1,'武侯区',0);
INSERT INTO `iz_city` VALUES (3,NULL,NULL,NULL,1,'金牛区',NULL);
INSERT INTO `iz_city` VALUES (4,NULL,NULL,NULL,1,'成华区',0);
/*!40000 ALTER TABLE `iz_city` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_goods
#

CREATE TABLE `iz_goods` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '商品名',
  `DESCRIPTION` varchar(3000) DEFAULT NULL COMMENT '商品描述',
  `USE_INTRO` varchar(255) DEFAULT NULL,
  `ERCODE` varchar(255) DEFAULT NULL COMMENT '二维码',
  `CAT_TYPE` int(10) DEFAULT NULL COMMENT '所属分类（优惠券，活动，等商品分类）',
  `BELONG_BC` int(11) NOT NULL DEFAULT '0' COMMENT '所属商圈',
  `BELONG_CAT` int(11) NOT NULL DEFAULT '0' COMMENT '属于分类（该分类指美食，美发等分类）',
  `PRICE` varchar(32) DEFAULT NULL COMMENT '商品价格',
  `NUMBER` int(10) DEFAULT NULL COMMENT '商品数量',
  `CREATE_TIME` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `ISVALID` tinyint(1) DEFAULT NULL COMMENT '有效性',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标志',
  `x` double(10,5) DEFAULT '0.00000',
  `y` double(10,5) DEFAULT '0.00000',
  `BEGIN_TIME` bigint(20) DEFAULT '0' COMMENT '优惠券开始时间',
  `END_TIME` bigint(20) DEFAULT '0' COMMENT '优惠券结束时间',
  `HASERWEI` int(11) DEFAULT '0' COMMENT '是否生成二维码',
  `USE_ADDR` varchar(255) DEFAULT NULL COMMENT '使用地址',
  `BELONG_SHOP` int(11) DEFAULT '0' COMMENT '所属商家',
  `DEFAULT_PIC` varchar(255) DEFAULT NULL COMMENT '默认图片',
  `IS_RECOMMEND` smallint(1) DEFAULT NULL,
  `IS_HOT` smallint(1) DEFAULT NULL,
  `discount` double(10,5) DEFAULT '0.00000' COMMENT '商品折扣',
  `code` int(6) DEFAULT '456342' COMMENT '商品编码',
  `isavailable` smallint(1) DEFAULT '0' COMMENT '商品是否可用',
  `ERWEI_ID` bigint(20) DEFAULT '0',
  `ISVERIFIED` tinyint(3) DEFAULT '0' COMMENT '1为审核通过，0为默认，-1为审核未通过',
  `PROMAN` varchar(64) DEFAULT NULL COMMENT '发布人ID',
  `invalid_time` bigint(20) DEFAULT '0' COMMENT '被停止使用功能时间？？',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_goods
#
LOCK TABLES `iz_goods` WRITE;
/*!40000 ALTER TABLE `iz_goods` DISABLE KEYS */;

INSERT INTO `iz_goods` VALUES (3,'[玉林兄弟手提串串]签子优惠','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3','erwei.jpg',1,1,1,'0.0',10,0,1327994579254,0,0,104.07,30.67,1326768619000,1326769619000,0,'噩噩噩噩',2,'1_112031_1327991976127_2965042560418566162.jpg',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (102,'斗牛士 全单95折','出示优惠卡享全单95折消费享3倍积分','出示优惠卡','erwei_1328073673655.jpg',1,0,5,'0.0',1,1328073673639,0,0,0,104.07,30.67,1328073673639,1328592008000,0,'斗牛士门店',99,'1_11211_1328073661811_-353937037378035839.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (103,'十味观 凭券消费每满100元立减30元','十味观 凭券消费每满100元立减30元','出示优惠劵','erwei_1328073898869.jpg',1,0,4,'0.0',1,1328073898854,1328073990008,0,0,104.07,30.67,1328073898000,1329283465000,0,'十味观',99,'1_11211_1328073985711_-4853262497147371296.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (104,'国泰电影院8折优惠券','此券限购正价票低于59元特价票，不能使用各项优惠不可同享\r\n\r\n国泰电影院8折优惠券此券限购正价票低于59元特价票，不能使用各项优惠不可同享','出示优惠劵','erwei_1328074066851.jpg',1,0,3,'0.0',0,1328074066820,1328074218849,0,0,104.07,30.67,1328074066000,1329974855000,0,'国泰电影院',99,'1_11211_1328074064023_-213942394411089715.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (105,'韩林炭烤 凭券满150元立减50元','凭券满150元立减50元','出示优惠劵','erwei_1328074201099.jpg',1,0,2,'0.0',0,1328074201052,0,0,0,104.07,30.67,1328074201052,1330493387000,0,'韩林炭烤',100,'1_11211_1328074197865_9055804336602088009.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (106,'永和大王 麻辣肉酱拌面+海裙菜汤','+卤肉白菜　　　　　11元\r\nW28 麻辣肉酱拌面+海裙菜汤+卤肉白菜　　　　　11元','出示优惠劵','erwei_1328074303801.jpg',1,0,2,'0.0',1,1328074303770,1328074322848,0,0,104.07,30.67,1328074303000,1330407092000,0,'永和大王',100,'1_11211_1328074298114_-3666787271528418942.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (107,'花袭人红楼干锅 凭此券享受宝钗韭香肥牛立减5元','凭此券享受宝钗韭香肥牛立减5元','出示优惠劵','erwei_1328074699015.jpg',1,1,3,'0.0',1,1328074698983,0,0,0,104.07,30.67,1328074698983,1329370684000,0,'花袭人红楼干锅',100,'1_11211_1328074694859_-4864021470077081115.gif',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (108,'[韩坊韩国传统料理]菜品8.8折','所有菜品8.8折优惠（套餐、酒水除外）','凭短信至韩坊韩国传统料理,菜品8.8折,大石西路86号长乐坊,87058586,12年6月29日止',NULL,1,0,3,'0.0',1,0,1328104696486,0,0,104.07,30.67,1328103735000,1329399738000,0,'大石西路86号长乐坊',101,'1_11211_1328104693540_7822424417459891331.jpg',0,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (109,'[老北京涮羊肉东安南路店]自助48元/客','自助原价58元/客（烤鸭10元/份，另外收费），现价48元/客（烤鸭包括在内）酒水除外（冬至前后三天除外）','凭短信至老北京涮羊肉东安南路店,自助48元/客,东安南路30号,13408024295,12年3月6日止','erwei_1328104960123.jpg',1,2,2,'0.0',0,1328104960094,1328104960094,0,0,104.07,30.67,1328104960094,1329919172000,0,'东安南路30号',101,'1_11211_1328104951271_665771781957224250.jpg',1,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (110,'[小尖椒餐饮]9折优惠','王府井店，消费满100元 赠送30元代金券；紫竹店、双楠店，来店可享受9折优惠。','凭短信至小尖椒餐饮,菜品9折优惠（海鲜、酒水、小吃除外），详询商家,6月18日止','erwei_1328105847960.jpg',1,3,3,'0.0',1,1328105847949,1328105847949,0,0,104.07,30.67,1328105847949,1328969074000,0,'详询商家',101,'1_11211_1328105839999_-6488433257983416366.jpg',1,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (111,'[新东方千禧大酒店]自助餐7折','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','erwei_1328106440404.jpg',1,0,2,'0.0',1,1328106440391,1328106440391,0,0,104.07,30.67,1328106440391,1329488803000,0,'新东方千禧大酒店',101,'1_11211_1328106432364_288217139216974351.jpg',1,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (112,'[一鼎乾坤肥牛]菜品8折','菜品8折优惠免包间费送精美果盘一份营业时间10:00-22:00','凭短信至一鼎乾坤肥牛,菜品8折,科华南路1号附27号,85350609,12年7月6日止','erwei_1328106735368.jpg',1,5,5,'0.0',1,1328106735356,1328106735356,0,0,104.07,30.67,1328106735356,1329575508000,0,'科华南路1号附27号',101,'1_11211_1328106720730_-4093510990073103178.jpg',1,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (113,'[啡比寻茶]满30元抵用20元现金','A泰式奶茶+骨肉相连，原价70元，现价36元卡布基诺+芝士蛋糕，原价56元，现价36元风味拿铁+香肠鸡蛋卷饼，原价66元，现价38元抹茶','凭短信至啡比寻茶,7款组合特惠任选,满30元抵用20元现金,一人不可同时参与多项优惠,每桌限一条短信,建设南街15号附21号,61311530,12年6月13日止','erwei_1328107234865.jpg',1,6,2,'0.0',1,1328107234853,1328107234853,0,0,104.07,30.67,1328107234853,1329489614000,0,'建设南街15号附21号',101,'1_11211_1328107226865_7229596918778981918.jpg',1,1,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (114,'[聚德福养生土鸡汤锅]菜品8.8折优惠','详细优惠信息：\r\n凭此券可以享受以下优惠：\r\n菜品8折优惠\r\n免包间费\r\n送精美果盘一份\r\n营业时间10:00-22:00 \r\n\r\n \r\n','[聚德福养生土鸡汤锅]菜品8.8折优惠\r\n','erwei_1328167749843.jpg',1,0,3,'0.0',0,1328167748093,1328170630562,0,0,104.07,30.67,1328167748000,1328167238000,0,'科华南路1号附27号',102,'1_11212_1328167732484_-3447320179341044944.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (115,'[马卡龙糖果屋]特惠套餐23元','详细优惠信息：7天下载:13 累计:71 浏览:2237\r\n\r\n凭此券可以享受以下优惠：\r\n特惠套餐，马卡龙一个+伯爵茶一位或马卡龙一个+咖啡一杯（不含摩卡）\r\n原价30元，现价23元\r\n\r\n','特惠套餐23元,86713606,12年3月2日止','erwei_1328170584000.jpg',1,0,4,'0.0',0,1328170583968,1328170897093,0,0,104.07,30.67,1328170583000,1328168660000,0,'东大街时代华章1楼附12号,',102,'1_11212_1328170893812_8115233484443806404.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (116,'[阿杰发艺]烫染7折','详细优惠信息：7天下载:137 累计:2193 浏览:7296\r\n\r\n凭此券可以享受以下优惠：\r\n\r\n\r\n洗吹10元\r\n洗剪吹20元\r\n（限指定发型师）\r\n烫染7折\r\n','凭短信至阿杰发艺,烫染7折,16家分店,详询商家,2月7日止\r\n','erwei_1328171687671.jpg',1,0,5,'0.0',0,1328171687640,1328171687640,0,0,104.07,30.67,1328171687640,1328171586000,0,'总府路3号5楼',102,'1_11212_1328171595250_-2598787562168557747.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (117,'[蓝贝珍珠]下午茶13元','凭此券可以享受以下优惠：\r\n下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n午市自助，原价58元/位，丁丁价48元/位\r\n晚市自助，原价78元/位，丁丁价58元/位\r\n（下午茶：14:00-17:00   午市：11:00-14:00  晚市：17:30-21:00）\r\n\r\n','下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n电话：028-86672995！','erwei_1328172697562.jpg',1,0,2,'0.0',0,1328172697546,1328173519500,0,0,104.07,30.67,1328172697000,1328171793000,0,'时代百盛-1F',102,'1_11212_1328172685078_-3757268142831091617.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (118,'[爱丽美甲]指甲护理15元','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','erwei_1328173894968.jpg',1,0,0,'0.0',0,1328173894890,1328174876437,0,0,104.07,30.67,1328173894000,1328173834000,0,'爱丽美甲连锁(成都华联店) ',102,'1_11212_1328173856375_7439082160877578834.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (119,'[BOBOe族]套餐优惠','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n','erwei_1328175018593.jpg',1,0,0,'0.0',0,1328175018578,1328175018578,0,0,104.07,30.67,1328175018578,1328174879000,0,'BOBOe族（芳草店） ',102,'1_11212_1328174987625_3355064501085300246.jpg',0,0,0,0,0,0,1,NULL,0);
INSERT INTO `iz_goods` VALUES (120,'优惠券名称优惠ERWEI TEST','去去去我去','呜呜呜呜',NULL,1,0,0,'0.0',121,1328817685525,1328821011428,0,0,11.021,120.011,1328817685000,1328817370000,0,'优惠使用地址',101,'1_112110_1328820090985_-546522661802713719.jpg',0,0,0,0,0,0,0,NULL,0);
INSERT INTO `iz_goods` VALUES (121,'优惠券名称优惠ERWEI TEST哇2','优惠券名称优惠ERWEI TEST哇2优惠券名称优惠ERWEI TEST哇2','优惠券名称优惠ERWEI TEST哇2优惠券名称优惠ERWEI TEST哇2优惠券名称优惠ERWEI TEST哇2','erwei_1328821489666.jpg',1,1,3,'0.0',111,1328821489452,1328821489452,0,0,321,12.02,1328821489452,1328821441000,0,'优惠使用地址',2,'1_112110_1328821478670_6440675835361717133.jpg',0,0,0,0,0,0,0,NULL,0);
INSERT INTO `iz_goods` VALUES (122,'优惠券名称优惠ERWEI TEST3','1111','1111','erwei_1328822273356.jpg',1,0,0,'0.0',12,1328822273281,1328822273281,0,0,0,0,1328822273281,1330636597000,0,'优惠使用地址',0,'1_112110_1328822205116_69737895431758428.jpg',0,0,0,0,0,0,0,NULL,0);
INSERT INTO `iz_goods` VALUES (123,'优惠券名称优惠ERWEI TEST6','优惠券名称优惠ERWEI TEST6优惠券名称优惠ERWEI TEST6','优惠券名称优惠ERWEI TEST6优惠券名称优惠ERWEI TEST6','erwei_1328822607530.jpg',1,0,0,'0.0',0,1328822607373,1328822607373,0,0,0,0,1328822561000,1328822561000,0,'优惠券名称优惠ERWEI TEST6',0,'1_112110_1328822580310_-3508430237177248531.jpg',0,0,0,0,0,0,1,NULL,0);
/*!40000 ALTER TABLE `iz_goods` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_goodsimg
#

CREATE TABLE `iz_goodsimg` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `GOODS_ID` int(10) DEFAULT NULL COMMENT '图片对应的商品ID',
  `URL` varchar(1024) DEFAULT NULL COMMENT '商品图片URL',
  `PUBLISHMAN` int(10) DEFAULT NULL COMMENT '上传人',
  `ISVALID` tinyint(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

#
# Dumping data for table iz_goodsimg
#
LOCK TABLES `iz_goodsimg` WRITE;
/*!40000 ALTER TABLE `iz_goodsimg` DISABLE KEYS */;

INSERT INTO `iz_goodsimg` VALUES (1,3,'1_112031_1327991976127_2965042560418566162.jpg',1,0);
INSERT INTO `iz_goodsimg` VALUES (3,102,'1323681191286.jpg',1,1);
INSERT INTO `iz_goodsimg` VALUES (6,108,'1_11211_1328104229599_6413706791724713378.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (7,109,'1_11211_1328104959935_8775048614816934708.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (8,110,'1_11211_1328105847832_340940473106197866.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (9,111,'1_11211_1328106440276_-1963746271021077951.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (10,112,'1_11211_1328106735087_-2519326355236864774.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (11,113,'1_11211_1328107234741_5916453619006025017.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (12,114,'1_11212_1328167747812_9178997162083086906.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (14,115,'1_11212_1328170727234_-6382712314877470028.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (15,116,'1_11212_1328171687468_-6387245570793818476.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (17,117,'1_11212_1328173516531_1239799865568432635.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (18,118,'1_11212_1328173894500_-1473836813047378052.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (19,119,'1_11212_1328175018375_-5061407866977553522.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (20,120,'1_112110_1328820994109_-8164078941925080288.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (21,123,'1_112110_1328822587334_1589511508466922458.jpg',NULL,0);
/*!40000 ALTER TABLE `iz_goodsimg` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_homepage_push
#

CREATE TABLE `iz_homepage_push` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1为导航，2为FLASH 3为推荐商户，4为推荐优惠券',
  `sysflag` tinyint(3) DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Dumping data for table iz_homepage_push
#
LOCK TABLES `iz_homepage_push` WRITE;
/*!40000 ALTER TABLE `iz_homepage_push` DISABLE KEYS */;

INSERT INTO `iz_homepage_push` VALUES (2,NULL,NULL,'www.sina.com','1_112030_1327912705092_-4152941502067645603.jpg',2,0,'幻灯片推荐');
INSERT INTO `iz_homepage_push` VALUES (3,NULL,NULL,'www.sina.com','1_112030_1327912573664_3241834908711782999.jpg',2,0,'幻灯片推荐');
INSERT INTO `iz_homepage_push` VALUES (4,NULL,NULL,'www.sina.com','1_112030_1327912125840_-260990434327122318.jpg',2,0,'幻灯片推荐');
INSERT INTO `iz_homepage_push` VALUES (5,NULL,NULL,'www.sina.com','1_112030_1327912715264_-1528483208924977193.jpg',2,0,'幻灯片推荐');
INSERT INTO `iz_homepage_push` VALUES (6,NULL,NULL,'www.sina.com','1_112030_1327914158870_-7069568187998252696.jpg',3,0,'推荐商户');
INSERT INTO `iz_homepage_push` VALUES (7,NULL,NULL,'www.sina.com','1_112030_1327914164961_1928038983766995212.jpg',3,0,'推荐商户');
INSERT INTO `iz_homepage_push` VALUES (8,NULL,NULL,'www.sina.com','1_112030_1327914171973_-6828241539235471742.jpg',3,0,'推荐商户');
INSERT INTO `iz_homepage_push` VALUES (9,NULL,NULL,'www.sina.com','1_112030_1327914180067_5129057808877902622.jpg',3,0,'推荐商户');
INSERT INTO `iz_homepage_push` VALUES (11,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','呜呜呜呜','1_112030_1327916031347_1478636421816780093.jpg',4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (12,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (13,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (15,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (18,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (19,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,4,0,'推荐优惠券');
INSERT INTO `iz_homepage_push` VALUES (22,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,6,0,'推荐优惠券LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (23,NULL,'wwww','ww',NULL,6,0,'推荐优惠券LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (24,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,6,0,'推荐优惠券LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (25,NULL,'wwww','ww',NULL,6,0,'推荐优惠券LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (26,NULL,'','e',NULL,5,0,NULL);
INSERT INTO `iz_homepage_push` VALUES (27,NULL,'','ww',NULL,5,0,NULL);
INSERT INTO `iz_homepage_push` VALUES (28,NULL,'','e',NULL,5,0,NULL);
INSERT INTO `iz_homepage_push` VALUES (29,NULL,'','ww',NULL,5,0,NULL);
INSERT INTO `iz_homepage_push` VALUES (30,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,7,0,'推荐活动LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (31,NULL,'wwww1111111111','ww',NULL,7,0,'推荐活动LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (32,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,7,0,'推荐活动LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (33,NULL,'wwww','ww',NULL,7,0,'推荐活动LIST页面顶部');
INSERT INTO `iz_homepage_push` VALUES (34,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,8,0,'精选商户LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (38,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,8,0,'精选商户LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (39,NULL,'wwww1111111111','ww',NULL,8,0,'精选商户LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (40,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,9,0,'精选优惠券LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (43,NULL,'wwww1111111111','ww',NULL,9,0,'精选优惠券LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (44,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,9,0,'精选优惠券LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (45,NULL,'wwww1111111111','ww',NULL,9,0,'精选优惠券LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (46,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,9,0,'精选优惠券LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (47,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,10,0,'精选活动LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (48,NULL,'wwww1111111111','ww',NULL,10,0,'精选活动LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (49,NULL,'wwww1111111111','ww',NULL,10,0,'精选活动IST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (50,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,10,0,'精选活动LIST页面侧边栏');
INSERT INTO `iz_homepage_push` VALUES (51,NULL,'三店通用 仅49元！欢享原价998元尊尚造型美发烫染套餐 ','e',NULL,10,0,'精选活动LIST页面侧边栏');
/*!40000 ALTER TABLE `iz_homepage_push` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_order
#

CREATE TABLE `iz_order` (
  `ORDER_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '用户ID',
  `GOODS_ID` int(10) DEFAULT NULL COMMENT '商品标识',
  `NAME` varchar(100) DEFAULT NULL COMMENT '商品名',
  `BUY_NUM` varchar(32) DEFAULT NULL COMMENT '购买数量',
  `CAT_TYPE` int(10) DEFAULT NULL COMMENT '商品所属分类',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '商品创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '商品修改时间',
  `ORDER_TIME` datetime DEFAULT NULL COMMENT '下订单时间',
  `ORDER_STATUS` tinyint(1) DEFAULT NULL COMMENT '订单状态',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标志',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='订单表';

#
# Dumping data for table iz_order
#
LOCK TABLES `iz_order` WRITE;
/*!40000 ALTER TABLE `iz_order` DISABLE KEYS */;

/*!40000 ALTER TABLE `iz_order` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_promote_info
#

CREATE TABLE `iz_promote_info` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '信息ID',
  `TITLE` varchar(250) DEFAULT NULL COMMENT '信息标题',
  `CONTENT` text,
  `BEGIN_TIME` bigint(20) DEFAULT '0' COMMENT '信息时间',
  `END_TIME` bigint(20) DEFAULT '0',
  `PROMAN` varchar(64) DEFAULT NULL COMMENT '发布人',
  `BELONG_CAT` int(11) DEFAULT '0',
  `BELONG_BC` int(11) DEFAULT '0',
  `CREATE_TIME` bigint(20) DEFAULT '0' COMMENT '发布时间',
  `MODIFY_TIME` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `KEYWORD` varchar(60) DEFAULT NULL COMMENT '关键词',
  `SYSFLAG` tinyint(1) DEFAULT '0' COMMENT '逻辑标识',
  `SHOP_ID` int(10) DEFAULT NULL COMMENT '所属商家',
  `ISVERIFIED` tinyint(1) DEFAULT '0' COMMENT '是否审核通过',
  `PIC_URL` varchar(255) DEFAULT NULL,
  `ACT_ADDRESS` varchar(255) DEFAULT NULL,
  `IS_HOT` smallint(1) DEFAULT NULL COMMENT '是否热门',
  `IS_RECOMMEND` smallint(1) DEFAULT NULL COMMENT '是否推荐',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_promote_info
#
LOCK TABLES `iz_promote_info` WRITE;
/*!40000 ALTER TABLE `iz_promote_info` DISABLE KEYS */;

INSERT INTO `iz_promote_info` VALUES (1,'味好美家常经典菜谱式调料免费派发1','随着工作越来越忙，回家做饭的时间越来越少，想吃家常菜，但又做不出正宗的味道，特别是要配齐那些调料还要花不少功夫。现在有了味好美家常经典调料，帮我轻松做出家常美味，更有7款经典菜谱供我选择，美味每一天。“家常经典菜谱式调料”做菜轻松3步走1：将味好美菜谱式调料加适量清水搅拌均匀，调成调味汁。2：加入适..',0,0,NULL,1,1,0,0,'调料免费派发',0,101,1,'1_112031_1327994645791_8907931555627602504.jpg','成都市春熙路245号',1,1);
INSERT INTO `iz_promote_info` VALUES (2,'李锦记蒜蓉辣椒酱免费派发','活动时间：2012年1月15日至2月14日 派发产品：李锦记蒜蓉辣椒酱（10g×2） 领取方式：您可至维络城线下任意一台服务设备，打印蒜蓉辣椒酱免费兑换券，并持券至指定体验站，即可换取赠品一份。  寒冬来临，冷风飕飕，多穿衣服把自己裹成个球就够温暖了么？那你就out啦！温暖也要由内而外，来点辣味美食，不仅满足嘴巴的需求，更能让胃也暖起来！李锦记现在就送你美味的蒜蓉辣椒酱，让你在寒冷冬季，感受辣味浓浓，暖意融融!快来领取吧！  更多李锦记美味辣酱请至各大卖场或淘宝李锦记旗舰店选购。',1328076361000,1329977164000,NULL,3,1,0,0,'李锦记 免费',0,102,1,'1_11211_1328076383134_4590381683400978321.jpg','李锦记',1,1);
INSERT INTO `iz_promote_info` VALUES (3,'力士新活炫亮洗发水旅行套装免费派发中','派发产品：力士新活炫亮洗发水旅行套装（洗发水、护发素） 兑换方式：您可至维络城线下任意一台标有力士广告推荐位的服务终端打印新活炫亮洗发水旅行套装免费兑换券，并持券至指定体验站，即可换取体验装一份。',1328076711000,1329286313000,NULL,5,3,0,0,'力士',0,100,1,'1_11211_1328076756801_-9209079545814404486.jpg','力士',1,1);
INSERT INTO `iz_promote_info` VALUES (4,'味好美家常经典菜谱式调料免费派发','*活动一：味好美家常经典菜谱式调料（麻婆豆腐/鱼香肉丝/咖喱鸡/蜜汁排骨/香辣鸡翅，随机一款)+泰式甜辣酱（小袋装）免费派发 活动时间：2012年1月1日至1月15日 兑换方式：您可至维络城线下任意一台标有味好美广告推荐位的服务终端打印家常经典菜谱式调料免费兑换券，并持券至指定体验站，即可换取赠品一份。  *活动二：味好美创意厨房 微博互动 活动时间：2012年1月1日至1月31日 参与方式：在活动期间，凡关注“味好美创意厨房”官方微博，并“@味好美创意厨房#味好美家常经典#+轻轻松松美味一包搞定”。就有机会获得由味好美官方微博提供的研磨瓶双瓶礼盒装+家常经典菜谱式调料一份，总共抽取100份！',1328077095000,1329977897000,NULL,3,5,0,1328259184296,'味好美',0,99,1,'1_11211_1328077127218_-5157893409010205187.jpg','各大超市',1,1);
INSERT INTO `iz_promote_info` VALUES (5,'樱之花热力贴冬日给力派发中～','派发产品：樱之花热力贴（1片装） 兑换方式：您可至维络城线下任意一台标有樱之花广告推荐位的服务终端打印热力贴免费兑换券，并持券至指定体验站，即可换取试用装一份。',1328077195000,1330064397000,NULL,5,3,0,1328259190234,'樱之花 热力贴',0,100,1,'1_11211_1328077620696_-9068197681601666341.jpg','成都',1,1);
INSERT INTO `iz_promote_info` VALUES (6,'中粮集团 我买网产品免费领取活动','活动内容：凭券免费领取 　　　　　悦活石榴苹果果汁三联包(瓶装 300ml*3) 　　　　　我买网10元折扣券 注意事项：仅限VELO用户，每日限量打印，悦活石榴苹果果汁三联包(瓶装 300ml*3)（每人可免费领取1份）， 　　　　　我买网10元折扣券5000份每人限打3张，先到先得。',1328077980000,1329373982000,NULL,3,6,0,0,'中粮集团 我买网 免费',0,101,1,'1_11211_1328078009113_-4202757859902490658.jpg','我买网',1,1);
INSERT INTO `iz_promote_info` VALUES (7,'阿华田乐活五谷随身包免费派发中～','派发产品：阿华田乐活五谷随身包（30g,坚果/黑谷 2选1） 兑换方式：您可至维络城线下任意一台标有阿华田广告推荐位的服务终端打印乐活五谷随身包免费兑换券，并持券至指定体验站，即可换取赠饮一份。',1328078066000,1329287668000,NULL,3,1,0,0,'阿华田 免费',0,102,1,'1_11211_1328078090253_-3393410131822877525.jpg','成都',1,1);
INSERT INTO `iz_promote_info` VALUES (8,'可采上品营肌系列面膜免费派发中～','派发产品：可采上品营肌系列面膜（单片装） 兑换方式：您可至维络城线下任意一台标有可采广告推荐位的服务终端打印上品营肌系列面膜免费兑换券，并持券至指定体验站，即可换取单片一份。',1328078132000,1329978935000,NULL,5,2,0,0,'可采 免费',0,101,1,'1_11211_1328078165018_886995156878987129.jpg','成都',1,1);
INSERT INTO `iz_promote_info` VALUES (9,'携程100元度假抵用券火热体验中……','* 100元旅游抵用券在携程旅行网订购度假产品时，可用该券冲抵相应的金额，使用金额的限制规定详见携程各度假线路。',0,0,NULL,2,0,0,1328247329765,'旅游 酒店',0,99,1,'1_11213_1328247327203_-4413309447728270816.jpg','www.ctrip.com',0,0);
INSERT INTO `iz_promote_info` VALUES (10,'想抢鲜尝试小龙虾？快来虾趣试吃','龙虾系列：金牌十三香精品龙虾、特色秘制龙虾、黄焖龙虾、啤酒龙虾',0,0,NULL,3,0,1328258521109,1328258521109,'餐饮',0,100,1,'1_11213_1328258518500_-4110282845536016193.jpg','国济路30号2楼',0,0);
INSERT INTO `iz_promote_info` VALUES (11,'小君厨房免费试吃活动','小君厨房是一家改良型川菜馆，环境很不错，干净、明亮。菜肴是改良过的，适合大多数人的口味。地处中环百联3楼，',0,0,NULL,4,0,1328258655437,1328258655437,'餐饮',0,99,1,'1_11213_1328258652593_-7871996776836875321.jpg','真光路1288号（中环百联3楼）',0,0);
INSERT INTO `iz_promote_info` VALUES (12,'露得清全新WAVE新品洁面器上市啦！','活动期间至露得清专柜购买全新WAVE新品洁面器，可获赠一款超酷化妆盒',1334534400000,1339804800000,NULL,5,0,1328258803906,1328258803906,'化妆品',0,101,1,'1_11213_1328258801125_-141341247318551500.jpg','全市屈臣氏，沃尔玛，家乐福露得清专柜',0,0);
INSERT INTO `iz_promote_info` VALUES (13,'用户专享YesMytea也买茶精选好茶免费领','可使用满39元减5元抵用券，可享受优惠：',1325376000000,1329468503000,NULL,2,0,0,1328259166734,'茶',0,102,1,'1_11213_1328259011671_-2967921254451105948.jpg','www.yesmytea.com/black',0,0);
INSERT INTO `iz_promote_info` VALUES (14,'thatgirl——来自于东瀛的问候','活动期间，18-28岁女性凭券至thatgirl专柜即可免费领取',1325376000000,1328777619000,NULL,3,0,0,1328259516578,'',0,99,1,'1_11213_1328259513765_-4382644702154651086.jpg','万达店：五角场万达广场特力时尚汇1F东门 ',0,0);
INSERT INTO `iz_promote_info` VALUES (17,'汉堡王五周年庆典 真Fun狂','试吃产品：免费畅享汉堡王各款美食',1328259376000,1329382583000,NULL,2,0,1328259492296,1328259492296,'汉堡王五周年庆典 真Fun狂！',0,101,1,'1_11213_1328259489906_2973402644136826320.jpg','中山东二路501号B118-119（十六铺）',0,0);
INSERT INTO `iz_promote_info` VALUES (18,'尽享美食 健康有我——三得利黑乌龙茶！','2010年8月31日前凭券前往指定餐厅，消费每满100元即可获得350ML三得利黑乌龙一瓶，以此类推。 ',1328259610000,1336035612000,NULL,3,0,1328259624953,1328259624953,'',0,99,1,'1_11213_1328259611218_-4077758766179306092.jpg','市区各大本商品卖场',0,0);
INSERT INTO `iz_promote_info` VALUES (19,'VELO独享梦妆夏日特惠礼','凭券购买多效BB矿物修容霜，赠送专业底妆工具一盒；前100名凭券购买的',1328259638000,1328137569000,NULL,4,0,1328259732046,1328259732046,'',0,102,1,'1_11213_1328259727203_-1490268297480653448.jpg','长宁区长宁路1018号龙之梦购物中心龙之梦F2地铁3号线天桥入口处',0,0);
/*!40000 ALTER TABLE `iz_promote_info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_role_function
#

CREATE TABLE `iz_role_function` (
  `ROLE_FUNCTION_ID` varchar(64) DEFAULT NULL COMMENT '角色-功能点对应ID',
  `ROLE_ID` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `FUNCTION_ID` varchar(64) DEFAULT NULL COMMENT '功能点ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色-功能点对应表';

#
# Dumping data for table iz_role_function
#
LOCK TABLES `iz_role_function` WRITE;
/*!40000 ALTER TABLE `iz_role_function` DISABLE KEYS */;

INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','2c2e8bf72e6b405b83b55e0f9ec5beab');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','dfadbfc5f6ab42eaa0f52e77bb9f930f');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','c3aeda3dc4154436b731aed23f087cce');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','25fda8ef8735458b82cdc0625a32b504');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','2c2e8bf72e6b405b83b55e0f9ec5beab');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','dfadbfc5f6ab42eaa0f52e77bb9f930f');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','c3aeda3dc4154436b731aed23f087cce');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','25fda8ef8735458b82cdc0625a32b504');
INSERT INTO `iz_role_function` VALUES (NULL,'206b0ae817664bd3821cd2dfc91aee92','1aedf6a403a84a0eb3e2c68c0585eb46');
INSERT INTO `iz_role_function` VALUES (NULL,'206b0ae817664bd3821cd2dfc91aee92','3cde1e7343ff4804a837e769494d24c7');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','2c2e8bf72e6b405b83b55e0f9ec5beab');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','dfadbfc5f6ab42eaa0f52e77bb9f930f');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','c3aeda3dc4154436b731aed23f087cce');
INSERT INTO `iz_role_function` VALUES (NULL,'b93795aaac2f4029875e6d88b6d21ddd','25fda8ef8735458b82cdc0625a32b504');
INSERT INTO `iz_role_function` VALUES (NULL,'206b0ae817664bd3821cd2dfc91aee92','1aedf6a403a84a0eb3e2c68c0585eb46');
INSERT INTO `iz_role_function` VALUES (NULL,'206b0ae817664bd3821cd2dfc91aee92','3cde1e7343ff4804a837e769494d24c7');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','f26c84ec84f4490fa0ffaddbeb8c5ba9');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','b8aef2a2504e4048995099604fcb1707');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','3cde1e7343ff4804a837e769494d24c7');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','1aedf6a403a84a0eb3e2c68c0585eb46');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','ec0eae40dd2f434691c2225189e56da4');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','31f147aed6ef4e5b889dee91949598f8');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','25fda8ef8735458b82cdc0625a32b504');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','15877675eca2441f85ded00b46b02f20');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','863931a121804f9891eaa89b3ace8bc7');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c3aeda3dc4154436b731aed23f087cce');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4a1e04c17fa34135ac80704f2c36f1d5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','95470a13ad2848d590aab2034d1546b2');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','dfadbfc5f6ab42eaa0f52e77bb9f930f');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4cb8e540721b40ddbdb932397fc1821b');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c66ad7ebb6f4431ba68fe81d35fa9a1e');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','5358a47b012f4635ac877115c2461f67');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','0ccebb0bb2124b668ab1100d305c3737');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','13e9fd6756304c97994f15d550799411');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','cecb279793c64817947e5453ebaf74b5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','b36d978183494f95b8501839242480e9');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','9315ff15e059499c836c1564e0e86d1d');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','002956b9737a4ba592d80318f25e4deb');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4b91b1d974cd46078861aa9cb6405e73');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4da6871d4a3249eca9fb56603027c211');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','7a5065168ed9432f88e873aa33b11bd5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','19b1c37bb60f431d859ce031a9f634c0');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','0d67261073bf4092b4bf1a5f34714c4a');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c74d81b124ef4e059ebeb2bbaaa1fd99');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','aa9bf75feadf4ac5b6a7335d6ec6470f');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','1237dd55c35746598313f8e6d8320a4c');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','2f3b181e1f0e44a8ade4b34a28a01687');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','34ca11066f9547a19dcf24de30a2faec');
/*!40000 ALTER TABLE `iz_role_function` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop
#

CREATE TABLE `iz_shop` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL COMMENT '商户分店名',
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `BELONG_BC` int(11) DEFAULT '0' COMMENT '所属商圈',
  `BELONG_SHOPCAT` varchar(255) NOT NULL DEFAULT '0',
  `ISVALID` tinyint(3) DEFAULT '0',
  `ISREMMEND` tinyint(3) DEFAULT '0',
  `SYSFLAG` tinyint(3) DEFAULT '0',
  `ADDRESS` varchar(255) DEFAULT NULL,
  `DEFAULT_PIC` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `IS_HOT` smallint(1) DEFAULT '0',
  `CREATE_TIME` bigint(20) DEFAULT '0',
  `MODIFY_TIME` bigint(20) DEFAULT '0',
  `ISVERIFIED` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_shop
#
LOCK TABLES `iz_shop` WRITE;
/*!40000 ALTER TABLE `iz_shop` DISABLE KEYS */;

INSERT INTO `iz_shop` VALUES (2,'玉林兄弟手提串','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',1,'2',0,0,0,'玉林横街2号','1_112031_1327991547614_-6456830178777474362.jpg','028-65544333',0,0,0,-1);
INSERT INTO `iz_shop` VALUES (99,'万达电影院线串','万达电影院线成立于2005年，隶属于万达集团，是亚洲银幕数排名第一的电影院线，截止2010年底，万达电影院线拥有旗下影城超过70家，银幕超过600块；2010年票房收入超过14亿元，稳居中国第一的市场份额。2010年12月，万达院线荣获第18届亚太电影博览会(CineAsia)“年度放映商”大奖，这是中国内地电影放映商第一次获得这一备受推崇的国际大奖。 ',0,'0',0,1,0,'万达广场','1_11211_1328068573739_3212335554294488748.jpg','028-98765432',1,0,0,1);
INSERT INTO `iz_shop` VALUES (100,'国美电器串','国美电器（英语：GOME）是中国的一家连锁型家电销售企业，也是中国大陆最大的家电零售连锁企业，2009年，国美电器入选中国世界纪录协会中国最大的家电零售连锁企业。成立于1987年1月1日。董事局主席张大中。在北京、太原、天津、上海、广州、深圳、青岛、长沙、香港等城市设立了42个分公司，及1200多家直营店面。',0,'0',0,1,0,'万达广场','1_11211_1328068403088_6264985277506049387.jpg','028-98765432',1,0,0,1);
INSERT INTO `iz_shop` VALUES (101,'碎碟咖啡厅串','　良木缘（又称良木缘咖啡；GOOD WOOD COFFEE）是以提供咖啡、西餐为主，致力于传播咖啡文化的餐饮连锁企业。自 　　 [良木缘咖啡]  1998年在成都创立至今，一直秉承着“铸百年老店，塑领军品牌” 良木缘咖啡西餐有限责任公司是一家经营休闲咖啡，致力于传播咖啡文化的零售连锁企业。“铸百年老店 塑领军品牌”是良木缘公司始终坚持的奋斗目标。 ',0,'0',0,1,0,'成都市科华北路12号','1_11211_1328068498194_3129983718357170552.jpg','028-98765432',1,0,0,1);
INSERT INTO `iz_shop` VALUES (102,'哈根达斯串','哈根达斯（Haagen-Dazs）作为美国冰激凌品牌，1921年由鲁本·马特斯(Reuben Mattus)研制成功，并于1961在美国纽约布朗克斯命名并上市。它亦成立了连锁雪糕专门店，在世界各国销售其品牌雪糕，在54个国家或地区共开设超过700间分店。另外，在市场占有率上：美国6.1%，英国3.5%，法国1%，日本4.6%，新加坡4%，中国香港5%。哈根达斯生产的产品包括雪糕、雪糕条、雪葩及冰冻奶酪等。',0,'0',0,1,0,'成都市锦江区春熙路中山广场','1_11211_1328068529881_-2089021137846030212.jpg','028-98765432',1,0,0,1);
/*!40000 ALTER TABLE `iz_shop` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop_categories
#

CREATE TABLE `iz_shop_categories` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_category_id` int(10) DEFAULT NULL,
  `category_name` varchar(200) DEFAULT NULL,
  `category_desc` varchar(1000) DEFAULT NULL,
  `category_type` int(11) NOT NULL DEFAULT '0' COMMENT '1代表商户分类，2代表优惠券分类，3代表活动分类',
  `sysflag` int(1) DEFAULT NULL,
  `isvisible` int(1) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商户目录表';

#
# Dumping data for table iz_shop_categories
#
LOCK TABLES `iz_shop_categories` WRITE;
/*!40000 ALTER TABLE `iz_shop_categories` DISABLE KEYS */;

INSERT INTO `iz_shop_categories` VALUES (1,0,'餐饮','餐饮餐饮餐饮餐饮',1,0,0);
INSERT INTO `iz_shop_categories` VALUES (2,0,'娱乐','娱乐',1,0,0);
INSERT INTO `iz_shop_categories` VALUES (3,0,'美食','美食',2,0,0);
INSERT INTO `iz_shop_categories` VALUES (5,0,'美容','美容美容美容',3,0,0);
INSERT INTO `iz_shop_categories` VALUES (7,0,'建材','建材',1,0,0);
/*!40000 ALTER TABLE `iz_shop_categories` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop_shop_category
#

CREATE TABLE `iz_shop_shop_category` (
  `SHOP_CATEGORY_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商户-目录对应ID',
  `SHOP_ID` int(10) DEFAULT NULL COMMENT '商户ID',
  `CATEGORY_ID` int(10) DEFAULT NULL COMMENT '目录ID',
  `BELONG_BC` int(11) DEFAULT '0' COMMENT '商户所在商圈',
  PRIMARY KEY (`SHOP_CATEGORY_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_shop_shop_category
#
LOCK TABLES `iz_shop_shop_category` WRITE;
/*!40000 ALTER TABLE `iz_shop_shop_category` DISABLE KEYS */;

INSERT INTO `iz_shop_shop_category` VALUES (1,1,1,0);
INSERT INTO `iz_shop_shop_category` VALUES (2,1,3,0);
INSERT INTO `iz_shop_shop_category` VALUES (3,8,40,0);
INSERT INTO `iz_shop_shop_category` VALUES (4,80,0,0);
INSERT INTO `iz_shop_shop_category` VALUES (5,21,93,0);
INSERT INTO `iz_shop_shop_category` VALUES (6,48,37,0);
INSERT INTO `iz_shop_shop_category` VALUES (7,97,96,0);
INSERT INTO `iz_shop_shop_category` VALUES (8,33,19,0);
INSERT INTO `iz_shop_shop_category` VALUES (9,66,72,0);
INSERT INTO `iz_shop_shop_category` VALUES (10,99,73,0);
INSERT INTO `iz_shop_shop_category` VALUES (11,7,35,0);
INSERT INTO `iz_shop_shop_category` VALUES (12,84,80,0);
INSERT INTO `iz_shop_shop_category` VALUES (13,12,30,0);
INSERT INTO `iz_shop_shop_category` VALUES (14,68,43,0);
INSERT INTO `iz_shop_shop_category` VALUES (15,39,12,0);
INSERT INTO `iz_shop_shop_category` VALUES (16,53,6,0);
INSERT INTO `iz_shop_shop_category` VALUES (17,31,14,0);
INSERT INTO `iz_shop_shop_category` VALUES (18,1,41,0);
INSERT INTO `iz_shop_shop_category` VALUES (19,25,52,0);
INSERT INTO `iz_shop_shop_category` VALUES (20,10,86,0);
INSERT INTO `iz_shop_shop_category` VALUES (21,13,57,0);
INSERT INTO `iz_shop_shop_category` VALUES (22,63,56,0);
INSERT INTO `iz_shop_shop_category` VALUES (23,11,26,0);
INSERT INTO `iz_shop_shop_category` VALUES (24,51,89,0);
INSERT INTO `iz_shop_shop_category` VALUES (25,71,25,0);
INSERT INTO `iz_shop_shop_category` VALUES (26,75,9,0);
INSERT INTO `iz_shop_shop_category` VALUES (27,9,74,0);
INSERT INTO `iz_shop_shop_category` VALUES (28,95,63,0);
INSERT INTO `iz_shop_shop_category` VALUES (29,74,34,0);
INSERT INTO `iz_shop_shop_category` VALUES (30,22,97,0);
INSERT INTO `iz_shop_shop_category` VALUES (31,69,39,0);
INSERT INTO `iz_shop_shop_category` VALUES (32,37,91,0);
INSERT INTO `iz_shop_shop_category` VALUES (33,54,8,0);
INSERT INTO `iz_shop_shop_category` VALUES (34,70,69,0);
INSERT INTO `iz_shop_shop_category` VALUES (35,20,58,0);
INSERT INTO `iz_shop_shop_category` VALUES (36,18,61,0);
INSERT INTO `iz_shop_shop_category` VALUES (37,79,81,0);
INSERT INTO `iz_shop_shop_category` VALUES (38,4,64,0);
INSERT INTO `iz_shop_shop_category` VALUES (39,78,65,0);
INSERT INTO `iz_shop_shop_category` VALUES (40,49,67,0);
INSERT INTO `iz_shop_shop_category` VALUES (41,81,2,0);
INSERT INTO `iz_shop_shop_category` VALUES (42,61,13,0);
INSERT INTO `iz_shop_shop_category` VALUES (43,30,20,0);
INSERT INTO `iz_shop_shop_category` VALUES (44,82,42,0);
INSERT INTO `iz_shop_shop_category` VALUES (45,59,28,0);
INSERT INTO `iz_shop_shop_category` VALUES (46,93,84,0);
INSERT INTO `iz_shop_shop_category` VALUES (47,15,70,0);
INSERT INTO `iz_shop_shop_category` VALUES (48,89,16,0);
INSERT INTO `iz_shop_shop_category` VALUES (49,0,59,0);
INSERT INTO `iz_shop_shop_category` VALUES (50,24,7,0);
INSERT INTO `iz_shop_shop_category` VALUES (51,32,76,0);
INSERT INTO `iz_shop_shop_category` VALUES (52,83,29,0);
INSERT INTO `iz_shop_shop_category` VALUES (53,5,21,0);
INSERT INTO `iz_shop_shop_category` VALUES (54,57,1,0);
INSERT INTO `iz_shop_shop_category` VALUES (55,34,17,0);
INSERT INTO `iz_shop_shop_category` VALUES (56,38,15,0);
INSERT INTO `iz_shop_shop_category` VALUES (57,98,83,0);
INSERT INTO `iz_shop_shop_category` VALUES (58,76,36,0);
INSERT INTO `iz_shop_shop_category` VALUES (59,85,78,0);
INSERT INTO `iz_shop_shop_category` VALUES (60,91,87,0);
INSERT INTO `iz_shop_shop_category` VALUES (61,43,5,0);
INSERT INTO `iz_shop_shop_category` VALUES (62,55,68,0);
INSERT INTO `iz_shop_shop_category` VALUES (63,64,22,0);
INSERT INTO `iz_shop_shop_category` VALUES (64,47,18,0);
INSERT INTO `iz_shop_shop_category` VALUES (65,56,71,0);
INSERT INTO `iz_shop_shop_category` VALUES (66,19,3,0);
INSERT INTO `iz_shop_shop_category` VALUES (67,2,90,0);
INSERT INTO `iz_shop_shop_category` VALUES (68,26,33,0);
INSERT INTO `iz_shop_shop_category` VALUES (69,67,60,0);
INSERT INTO `iz_shop_shop_category` VALUES (70,77,98,0);
INSERT INTO `iz_shop_shop_category` VALUES (71,42,27,0);
INSERT INTO `iz_shop_shop_category` VALUES (72,41,66,0);
INSERT INTO `iz_shop_shop_category` VALUES (73,28,55,0);
INSERT INTO `iz_shop_shop_category` VALUES (74,96,32,0);
INSERT INTO `iz_shop_shop_category` VALUES (75,60,47,0);
INSERT INTO `iz_shop_shop_category` VALUES (76,17,95,0);
INSERT INTO `iz_shop_shop_category` VALUES (77,88,45,0);
INSERT INTO `iz_shop_shop_category` VALUES (78,3,82,0);
INSERT INTO `iz_shop_shop_category` VALUES (79,44,79,0);
INSERT INTO `iz_shop_shop_category` VALUES (80,87,85,0);
INSERT INTO `iz_shop_shop_category` VALUES (81,73,48,0);
INSERT INTO `iz_shop_shop_category` VALUES (82,40,24,0);
INSERT INTO `iz_shop_shop_category` VALUES (83,23,51,0);
INSERT INTO `iz_shop_shop_category` VALUES (84,92,11,0);
INSERT INTO `iz_shop_shop_category` VALUES (85,50,77,0);
INSERT INTO `iz_shop_shop_category` VALUES (86,65,88,0);
INSERT INTO `iz_shop_shop_category` VALUES (87,94,49,0);
INSERT INTO `iz_shop_shop_category` VALUES (88,86,53,0);
INSERT INTO `iz_shop_shop_category` VALUES (89,45,23,0);
INSERT INTO `iz_shop_shop_category` VALUES (90,16,46,0);
INSERT INTO `iz_shop_shop_category` VALUES (91,52,94,0);
INSERT INTO `iz_shop_shop_category` VALUES (92,27,92,0);
INSERT INTO `iz_shop_shop_category` VALUES (93,35,75,0);
INSERT INTO `iz_shop_shop_category` VALUES (94,36,54,0);
INSERT INTO `iz_shop_shop_category` VALUES (95,46,44,0);
INSERT INTO `iz_shop_shop_category` VALUES (96,6,50,0);
INSERT INTO `iz_shop_shop_category` VALUES (97,29,62,0);
INSERT INTO `iz_shop_shop_category` VALUES (98,62,31,0);
INSERT INTO `iz_shop_shop_category` VALUES (99,14,38,0);
/*!40000 ALTER TABLE `iz_shop_shop_category` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shopadmin
#

CREATE TABLE `iz_shopadmin` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商户ID',
  `NAME` varchar(32) DEFAULT NULL COMMENT '商户名',
  `LOGINNAME` varchar(32) DEFAULT NULL COMMENT '商户登录名',
  `PASSWORD` varchar(18) DEFAULT NULL COMMENT '商户密码',
  `PICURL` varchar(1024) DEFAULT NULL COMMENT '商家图片',
  `DESCRIPTION` text COMMENT '商户详细描述',
  `BC_ID` int(10) DEFAULT NULL COMMENT '所属商圈',
  `STATUS` tinyint(1) DEFAULT NULL COMMENT '商户状态0.未审核商户 1.正常 2.已冻结商户 3.已锁商户',
  `ISRECOMED` tinyint(1) DEFAULT NULL COMMENT '推荐标识',
  `SHOP_ADDR_ID` int(10) DEFAULT NULL COMMENT '商户地址ID',
  `PHONE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='商户用户表';

#
# Dumping data for table iz_shopadmin
#
LOCK TABLES `iz_shopadmin` WRITE;
/*!40000 ALTER TABLE `iz_shopadmin` DISABLE KEYS */;

INSERT INTO `iz_shopadmin` VALUES (1,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (2,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (3,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (4,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (5,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (6,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (7,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (8,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (9,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (10,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (11,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (12,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (13,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (14,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (15,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (16,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (17,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (18,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (19,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
INSERT INTO `iz_shopadmin` VALUES (20,'玉林兄弟手提串串','yulin','00000000','1111','玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串玉林兄弟手提串串',NULL,0,0,0,'0');
/*!40000 ALTER TABLE `iz_shopadmin` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shoppic
#

CREATE TABLE `iz_shoppic` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` int(11) DEFAULT '0' COMMENT '商户分店ID',
  `URL` varchar(255) DEFAULT NULL,
  `ISMAIN` tinyint(3) DEFAULT '0' COMMENT '是否是封面图',
  `SYSFLAG` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='商户分店图片表';

#
# Dumping data for table iz_shoppic
#
LOCK TABLES `iz_shoppic` WRITE;
/*!40000 ALTER TABLE `iz_shoppic` DISABLE KEYS */;

INSERT INTO `iz_shoppic` VALUES (56,2,'1_112031_1327991329475_-8977913531472266692.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (57,2,'1_112031_1327991329171_6608321601836227927.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (58,2,'1_112031_1327991329171_6608321601836227927.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (59,2,'1_112031_1327991329171_6608321601836227927.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (60,2,'1_112031_1327991329171_6608321601836227927.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (61,101,'1_11211_1328067967414_2945962982957614610.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (62,102,'1_11211_1328068089285_8771735552122292292.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (63,103,'1_11211_1328068306982_4207838795755616491.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (64,104,'1_11211_1328068441008_-752230639173463062.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (65,101,'1_11211_1328081591480_4139364234463242066.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (66,101,'1_11211_1328081591621_6554796927053429624.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (67,101,'1_11211_1328081591668_1167297975319909104.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (68,101,'1_11211_1328081591699_-2128647205268850525.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (69,101,'1_11211_1328081591730_-3604899356275022505.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (70,102,'1_11212_1328161292906_4963779445189311056.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (71,102,'1_11212_1328161293515_3217207383605803563.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (72,102,'1_11212_1328161293734_-3400514567029007609.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (73,102,'1_11212_1328161293890_6958100254975595188.jpg',0,0);
/*!40000 ALTER TABLE `iz_shoppic` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_sys_functions
#

CREATE TABLE `iz_sys_functions` (
  `FUNCTION_ID` varchar(64) NOT NULL COMMENT '功能点ID',
  `FUNCTION_NAME` varchar(200) DEFAULT NULL COMMENT '功能点名称',
  `FUNCTION_DESC` varchar(1000) DEFAULT NULL COMMENT '功能点描述',
  `SYSFLAG` int(1) DEFAULT NULL COMMENT '逻辑标识',
  `show_order` int(10) DEFAULT '0' COMMENT '显示顺序',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级资源id',
  `function_type` varchar(32) DEFAULT NULL COMMENT '资源类型',
  `function_code` varchar(128) DEFAULT NULL COMMENT '资源编码',
  `url` varchar(1024) DEFAULT '' COMMENT '资源URI',
  PRIMARY KEY (`FUNCTION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='功能点';

#
# Dumping data for table iz_sys_functions
#
LOCK TABLES `iz_sys_functions` WRITE;
/*!40000 ALTER TABLE `iz_sys_functions` DISABLE KEYS */;

INSERT INTO `iz_sys_functions` VALUES ('002956b9737a4ba592d80318f25e4deb','角色管理-添加','角色管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_add','/coupon/system/roleAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('05fa10e436b2456e82088e889e50c0a0','添加分类','添加分类',NULL,0,'2c2e8bf72e6b405b83b55e0f9ec5beab','RESOURCE','SHO_SH_CAT_ADD','/coupon/admin/catAction.html?a=3');
INSERT INTO `iz_sys_functions` VALUES ('0ccebb0bb2124b668ab1100d305c3737','角色功能点管理-添加','角色功能点管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_add','/coupon/system/functionAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('0d67261073bf4092b4bf1a5f34714c4a','用户管理-添加','用户管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_add','/coupon/system/userAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('1237dd55c35746598313f8e6d8320a4c','角色管理','角色管理 菜单',NULL,0,'34ca11066f9547a19dcf24de30a2faec','MENU','SYS_QX_JS','/coupon/system/to_role.html');
INSERT INTO `iz_sys_functions` VALUES ('13e9fd6756304c97994f15d550799411','角色功能点管理-列表','角色功能点管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_lis','/coupon/system/functionLis.html');
INSERT INTO `iz_sys_functions` VALUES ('15877675eca2441f85ded00b46b02f20','优惠券内容管理','',NULL,0,'c3aeda3dc4154436b731aed23f087cce','MENU','COUPON_CP_CONTENT','/coupon/admin/goodsadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('19b1c37bb60f431d859ce031a9f634c0','用户管理-删除','用户管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_del','/coupon/system/userDel.html');
INSERT INTO `iz_sys_functions` VALUES ('1aedf6a403a84a0eb3e2c68c0585eb46','会员管理','',NULL,3,'ROOT','FOLDER','USE_HY','javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('25fda8ef8735458b82cdc0625a32b504','活动管理','',NULL,0,'ROOT','FOLDER','SHO_SH_HD','/coupon/admin/activityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('2f3b181e1f0e44a8ade4b34a28a01687','用户管理','用户管理　菜单',NULL,0,'34ca11066f9547a19dcf24de30a2faec','MENU','SYS_QX_YH','/coupon/system/to_user.html');
INSERT INTO `iz_sys_functions` VALUES ('31f147aed6ef4e5b889dee91949598f8','活动类别管理','活动类别管理',NULL,0,'25fda8ef8735458b82cdc0625a32b504','MENU','ACT_HD_CAT','/coupon/admin/catadmin.html?cat_type=3');
INSERT INTO `iz_sys_functions` VALUES ('34ca11066f9547a19dcf24de30a2faec','权限管理','权限管理　目录',NULL,2,'ROOT','FOLDER','SYS_QX','javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('3cde1e7343ff4804a837e769494d24c7','会员管理','',NULL,0,'1aedf6a403a84a0eb3e2c68c0585eb46','MENU','USE_HY_HY','/coupon/admin/useradmin.html');
INSERT INTO `iz_sys_functions` VALUES ('4a1e04c17fa34135ac80704f2c36f1d5','商户内容管理','商户内容管理',NULL,0,'dfadbfc5f6ab42eaa0f52e77bb9f930f','MENU','SHO_SH_CONTENT','/coupon/admin/shopadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('4b91b1d974cd46078861aa9cb6405e73','角色管理-列表','角色管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_lis','/coupon/system/roleLis.html');
INSERT INTO `iz_sys_functions` VALUES ('4cb8e540721b40ddbdb932397fc1821b','角色功能点管理-父级选择','角色功能点管理-父级选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_parSelect','/coupon/system/findParentMenusTree.html');
INSERT INTO `iz_sys_functions` VALUES ('4da6871d4a3249eca9fb56603027c211','用户管理-角色选择','用户管理-角色选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_roleSelect','/coupon/system/findRoleList.html');
INSERT INTO `iz_sys_functions` VALUES ('5358a47b012f4635ac877115c2461f67','角色功能点管理-删除','角色功能点管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_del','/coupon/system/functionDel.html');
INSERT INTO `iz_sys_functions` VALUES ('7a5065168ed9432f88e873aa33b11bd5','用户管理-编辑','用户管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_edi','/coupon/system/userEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('863931a121804f9891eaa89b3ace8bc7','优惠券类别管理','',NULL,0,'c3aeda3dc4154436b731aed23f087cce','MENU','COUPON_CP_CAT','/coupon/admin/catadmin.html?cat_type=2');
INSERT INTO `iz_sys_functions` VALUES ('9315ff15e059499c836c1564e0e86d1d','角色管理-删除','角色管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_del','/coupon/system/roleDel.html');
INSERT INTO `iz_sys_functions` VALUES ('95470a13ad2848d590aab2034d1546b2','商户类别管理','类别管理',NULL,0,'dfadbfc5f6ab42eaa0f52e77bb9f930f','MENU','SHO_SH_CAT','/coupon/admin/catadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('aa9bf75feadf4ac5b6a7335d6ec6470f','角色功能点管理','功能点管理　菜单',NULL,0,'34ca11066f9547a19dcf24de30a2faec','MENU','SYS_QX_JSGND','/coupon/system/to_function.html');
INSERT INTO `iz_sys_functions` VALUES ('b36d978183494f95b8501839242480e9','角色管理-编辑','角色管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_edi','/coupon/system/roleEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('b8aef2a2504e4048995099604fcb1707','商圈管理','商圈管理',NULL,0,'ROOT','FOLDER','SHO_SH_BC','/coupon/admin/bcadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('c3aeda3dc4154436b731aed23f087cce','优惠劵管理','',NULL,0,'ROOT','FOLDER','SHO_SH_YHQ','/coupon/admin/goodsadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('c66ad7ebb6f4431ba68fe81d35fa9a1e','角色功能点管理-编辑','角色功能点管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_edi','/coupon/system/functionEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('c74d81b124ef4e059ebeb2bbaaa1fd99','用户管理-列表','用户管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_lis','/coupon/system/userLis.html');
INSERT INTO `iz_sys_functions` VALUES ('cecb279793c64817947e5453ebaf74b5','角色管理-功能选择','角色管理-功能选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_funSelect','/coupon/system/findRoleResourceList.html');
INSERT INTO `iz_sys_functions` VALUES ('dfadbfc5f6ab42eaa0f52e77bb9f930f','商户管理','',NULL,0,'ROOT','FOLDER','SHO_SH_ML','/coupon/admin/shopadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('ec0eae40dd2f434691c2225189e56da4','活动内容管理','',NULL,0,'25fda8ef8735458b82cdc0625a32b504','MENU','ACT_HD_CONTENT','/coupon/admin/activityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('f26c84ec84f4490fa0ffaddbeb8c5ba9','模块管理','',NULL,0,'ROOT','FOLDER','SHO_SH_HOME','/coupon/admin/homeadmin.html');
/*!40000 ALTER TABLE `iz_sys_functions` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_terminal
#

CREATE TABLE `iz_terminal` (
  `TERMINAL_ID` varchar(64) DEFAULT '' COMMENT '终端ID',
  `TERMINAL_VERSION` varchar(50) DEFAULT NULL COMMENT '终端程序版本',
  `TERMINAL_ADDR_ID` int(10) DEFAULT NULL COMMENT '终端所在地'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_terminal
#
LOCK TABLES `iz_terminal` WRITE;
/*!40000 ALTER TABLE `iz_terminal` DISABLE KEYS */;

INSERT INTO `iz_terminal` VALUES ('2','V0.1.3.456',33);
/*!40000 ALTER TABLE `iz_terminal` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_terminal_user
#

CREATE TABLE `iz_terminal_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal_id` varchar(255) NOT NULL DEFAULT '' COMMENT '终端ID',
  `prog_version` varchar(255) NOT NULL DEFAULT '' COMMENT '终端版本',
  `isvalid` tinyint(3) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_terminal_user
#
LOCK TABLES `iz_terminal_user` WRITE;
/*!40000 ALTER TABLE `iz_terminal_user` DISABLE KEYS */;

INSERT INTO `iz_terminal_user` VALUES (1,'1','1.0.0',0);
/*!40000 ALTER TABLE `iz_terminal_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user
#

CREATE TABLE `iz_user` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `NICK_NAME` varchar(20) DEFAULT NULL COMMENT '昵称',
  `SEX` tinyint(1) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机',
  `TEL` varchar(20) DEFAULT NULL COMMENT '电话',
  `ADDRESS_ID` int(10) DEFAULT NULL COMMENT '地址',
  `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `LAST_VISIT` bigint(20) DEFAULT NULL COMMENT '上次访问时间',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  `user_no` varchar(100) DEFAULT NULL,
  `pay_pass` varchar(32) DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Dumping data for table iz_user
#
LOCK TABLES `iz_user` WRITE;
/*!40000 ALTER TABLE `iz_user` DISABLE KEYS */;

INSERT INTO `iz_user` VALUES (1,'Tom','4124bc0a9335c27f086f24ba207a4912','11',0,'tom123@321.com','123455','111111',1,'0000-00-00 00:00:00','0000-00-00 00:00:00',1328236515296,0,'12345678910','4124bc0a9335c27f086f24ba207a4912');
INSERT INTO `iz_user` VALUES (2,'Jerry','4124bc0a9335c27f086f24ba207a4912','Jerry',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910','5f4dcc3b5aa765d61d8327deb882cf99');
INSERT INTO `iz_user` VALUES (3,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (4,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (5,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (6,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (7,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (8,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (9,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (10,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (11,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (12,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (13,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (14,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (15,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (16,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (17,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (18,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (19,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (20,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (21,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (22,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
INSERT INTO `iz_user` VALUES (23,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL);
/*!40000 ALTER TABLE `iz_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user_promote
#

CREATE TABLE `iz_user_promote` (
  `use_promote_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `promote_id` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户-活动表';

#
# Dumping data for table iz_user_promote
#
LOCK TABLES `iz_user_promote` WRITE;
/*!40000 ALTER TABLE `iz_user_promote` DISABLE KEYS */;

INSERT INTO `iz_user_promote` VALUES (91,40,21);
INSERT INTO `iz_user_promote` VALUES (33,97,30);
INSERT INTO `iz_user_promote` VALUES (6,9,7);
INSERT INTO `iz_user_promote` VALUES (65,1,9);
INSERT INTO `iz_user_promote` VALUES (60,28,45);
INSERT INTO `iz_user_promote` VALUES (3,35,92);
INSERT INTO `iz_user_promote` VALUES (31,58,32);
INSERT INTO `iz_user_promote` VALUES (63,80,74);
INSERT INTO `iz_user_promote` VALUES (28,3,2);
INSERT INTO `iz_user_promote` VALUES (12,41,54);
INSERT INTO `iz_user_promote` VALUES (2,95,44);
INSERT INTO `iz_user_promote` VALUES (23,56,97);
INSERT INTO `iz_user_promote` VALUES (64,10,80);
INSERT INTO `iz_user_promote` VALUES (55,94,98);
INSERT INTO `iz_user_promote` VALUES (18,70,57);
INSERT INTO `iz_user_promote` VALUES (74,96,49);
INSERT INTO `iz_user_promote` VALUES (49,98,1);
INSERT INTO `iz_user_promote` VALUES (27,67,61);
INSERT INTO `iz_user_promote` VALUES (82,23,99);
INSERT INTO `iz_user_promote` VALUES (81,14,34);
INSERT INTO `iz_user_promote` VALUES (84,25,87);
INSERT INTO `iz_user_promote` VALUES (90,61,78);
INSERT INTO `iz_user_promote` VALUES (13,92,76);
INSERT INTO `iz_user_promote` VALUES (66,27,70);
INSERT INTO `iz_user_promote` VALUES (19,26,90);
INSERT INTO `iz_user_promote` VALUES (0,16,14);
INSERT INTO `iz_user_promote` VALUES (43,86,83);
INSERT INTO `iz_user_promote` VALUES (59,15,55);
INSERT INTO `iz_user_promote` VALUES (78,79,25);
INSERT INTO `iz_user_promote` VALUES (47,66,13);
INSERT INTO `iz_user_promote` VALUES (29,43,43);
INSERT INTO `iz_user_promote` VALUES (9,63,63);
INSERT INTO `iz_user_promote` VALUES (93,45,18);
INSERT INTO `iz_user_promote` VALUES (72,62,19);
INSERT INTO `iz_user_promote` VALUES (21,57,95);
INSERT INTO `iz_user_promote` VALUES (67,88,29);
INSERT INTO `iz_user_promote` VALUES (53,31,64);
INSERT INTO `iz_user_promote` VALUES (37,64,42);
INSERT INTO `iz_user_promote` VALUES (94,12,24);
INSERT INTO `iz_user_promote` VALUES (8,72,27);
INSERT INTO `iz_user_promote` VALUES (26,20,10);
INSERT INTO `iz_user_promote` VALUES (76,5,4);
INSERT INTO `iz_user_promote` VALUES (51,46,85);
INSERT INTO `iz_user_promote` VALUES (34,60,79);
INSERT INTO `iz_user_promote` VALUES (97,38,40);
INSERT INTO `iz_user_promote` VALUES (17,17,56);
INSERT INTO `iz_user_promote` VALUES (99,47,88);
INSERT INTO `iz_user_promote` VALUES (39,87,59);
INSERT INTO `iz_user_promote` VALUES (79,2,33);
INSERT INTO `iz_user_promote` VALUES (83,44,65);
INSERT INTO `iz_user_promote` VALUES (22,50,16);
INSERT INTO `iz_user_promote` VALUES (88,54,6);
INSERT INTO `iz_user_promote` VALUES (68,71,91);
INSERT INTO `iz_user_promote` VALUES (48,52,68);
INSERT INTO `iz_user_promote` VALUES (80,68,75);
INSERT INTO `iz_user_promote` VALUES (73,13,46);
INSERT INTO `iz_user_promote` VALUES (20,6,41);
INSERT INTO `iz_user_promote` VALUES (14,21,82);
INSERT INTO `iz_user_promote` VALUES (32,30,84);
INSERT INTO `iz_user_promote` VALUES (1,18,0);
INSERT INTO `iz_user_promote` VALUES (69,82,12);
INSERT INTO `iz_user_promote` VALUES (38,42,20);
INSERT INTO `iz_user_promote` VALUES (95,77,36);
INSERT INTO `iz_user_promote` VALUES (92,99,37);
INSERT INTO `iz_user_promote` VALUES (10,53,26);
INSERT INTO `iz_user_promote` VALUES (98,74,23);
INSERT INTO `iz_user_promote` VALUES (75,48,38);
INSERT INTO `iz_user_promote` VALUES (87,32,62);
INSERT INTO `iz_user_promote` VALUES (54,69,89);
INSERT INTO `iz_user_promote` VALUES (77,93,31);
INSERT INTO `iz_user_promote` VALUES (56,78,39);
INSERT INTO `iz_user_promote` VALUES (46,29,86);
INSERT INTO `iz_user_promote` VALUES (4,7,60);
INSERT INTO `iz_user_promote` VALUES (71,22,71);
INSERT INTO `iz_user_promote` VALUES (85,91,73);
INSERT INTO `iz_user_promote` VALUES (50,39,77);
INSERT INTO `iz_user_promote` VALUES (62,83,94);
INSERT INTO `iz_user_promote` VALUES (40,19,3);
INSERT INTO `iz_user_promote` VALUES (86,85,58);
INSERT INTO `iz_user_promote` VALUES (5,73,5);
INSERT INTO `iz_user_promote` VALUES (96,0,8);
INSERT INTO `iz_user_promote` VALUES (70,24,66);
INSERT INTO `iz_user_promote` VALUES (58,11,50);
INSERT INTO `iz_user_promote` VALUES (36,76,47);
INSERT INTO `iz_user_promote` VALUES (89,37,48);
INSERT INTO `iz_user_promote` VALUES (44,36,72);
INSERT INTO `iz_user_promote` VALUES (30,51,51);
INSERT INTO `iz_user_promote` VALUES (41,84,15);
INSERT INTO `iz_user_promote` VALUES (35,33,35);
INSERT INTO `iz_user_promote` VALUES (45,49,17);
INSERT INTO `iz_user_promote` VALUES (24,75,96);
INSERT INTO `iz_user_promote` VALUES (57,59,28);
INSERT INTO `iz_user_promote` VALUES (42,81,11);
INSERT INTO `iz_user_promote` VALUES (11,90,53);
INSERT INTO `iz_user_promote` VALUES (16,8,81);
INSERT INTO `iz_user_promote` VALUES (7,34,52);
INSERT INTO `iz_user_promote` VALUES (25,4,69);
INSERT INTO `iz_user_promote` VALUES (52,89,22);
INSERT INTO `iz_user_promote` VALUES (61,55,67);
INSERT INTO `iz_user_promote` VALUES (15,65,93);
/*!40000 ALTER TABLE `iz_user_promote` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user_roles
#

CREATE TABLE `iz_user_roles` (
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `SYSFLAG` int(1) DEFAULT NULL COMMENT '逻辑标识',
  `show_order` int(10) DEFAULT '0' COMMENT '显示顺序',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色表';

#
# Dumping data for table iz_user_roles
#
LOCK TABLES `iz_user_roles` WRITE;
/*!40000 ALTER TABLE `iz_user_roles` DISABLE KEYS */;

INSERT INTO `iz_user_roles` VALUES ('206b0ae817664bd3821cd2dfc91aee92','会员管理员','管理会员用户',NULL,0);
INSERT INTO `iz_user_roles` VALUES ('b93795aaac2f4029875e6d88b6d21ddd','商户管理员','商户管理角色',NULL,0);
INSERT INTO `iz_user_roles` VALUES ('ffbc9413cb65411f8bbb4b541b5bb8bb','超级管理员','包含权限管理　该权限最大',NULL,1);
/*!40000 ALTER TABLE `iz_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user_user_role
#

CREATE TABLE `iz_user_user_role` (
  `USE_USER_ROLE_ID` varchar(64) DEFAULT NULL COMMENT '用户-用户角色对应ID',
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `USER_ROLE_ID` varchar(64) DEFAULT NULL COMMENT '用户角色ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户-用户角色中间表';

#
# Dumping data for table iz_user_user_role
#
LOCK TABLES `iz_user_user_role` WRITE;
/*!40000 ALTER TABLE `iz_user_user_role` DISABLE KEYS */;

INSERT INTO `iz_user_user_role` VALUES (NULL,'feb20991150746628b95c4a73296a454','ffbc9413cb65411f8bbb4b541b5bb8bb');
INSERT INTO `iz_user_user_role` VALUES (NULL,'feb20991150746628b95c4a73296a454','206b0ae817664bd3821cd2dfc91aee92');
INSERT INTO `iz_user_user_role` VALUES (NULL,'df78eff3fbe249bfa3ea5133779e292e','206b0ae817664bd3821cd2dfc91aee92');
INSERT INTO `iz_user_user_role` VALUES (NULL,'3','ffbc9413cb65411f8bbb4b541b5bb8bb');
/*!40000 ALTER TABLE `iz_user_user_role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_useraddress
#

CREATE TABLE `iz_useraddress` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '用户ID',
  `COUNTRY` int(11) DEFAULT NULL COMMENT '国家',
  `PROVINCE` int(11) DEFAULT NULL COMMENT '省份',
  `CITY` int(11) DEFAULT NULL COMMENT '城市、区',
  `ADDR_DETAIL` varchar(30) DEFAULT NULL COMMENT '详细地址',
  `ZIPCODE` int(11) DEFAULT NULL COMMENT '邮编',
  `CREATE_TIME` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `ISDEFAULT` tinyint(1) DEFAULT NULL COMMENT '默认地址',
  `SYSFLAG` int(11) DEFAULT NULL COMMENT '逻辑标志',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

#
# Dumping data for table iz_useraddress
#
LOCK TABLES `iz_useraddress` WRITE;
/*!40000 ALTER TABLE `iz_useraddress` DISABLE KEYS */;

INSERT INTO `iz_useraddress` VALUES (1,0,0,0,0,'2222',610000,0,0,NULL,NULL);
/*!40000 ALTER TABLE `iz_useraddress` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
