# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: iz_coupon
# ------------------------------------------------------
# Server version 5.5.17

USE `iz_coupon`;

#
# Source for table iz_activity
#

DROP TABLE IF EXISTS `iz_activity`;
CREATE TABLE `iz_activity` (
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
  `BELONG_SHOPS` varchar(255) DEFAULT NULL COMMENT '所属商家',
  `ISVERIFIED` tinyint(1) DEFAULT '0' COMMENT '是否审核通过',
  `PIC_URL` varchar(255) DEFAULT NULL,
  `ACT_ADDRESS` varchar(255) DEFAULT NULL,
  `IS_HOT` smallint(1) DEFAULT NULL COMMENT '是否热门',
  `IS_RECOMMEND` smallint(1) DEFAULT NULL COMMENT '是否推荐',
  `act_article` longtext COMMENT '文章形式的活动',
  `audit_reason` varchar(100) DEFAULT NULL COMMENT '审核不通过理由',
  `freeze` int(10) DEFAULT '0' COMMENT '是否冻结字段   0-正常状态   1-冻结状态',
  `BELONG_CITYS` varchar(255) DEFAULT NULL COMMENT '活动参与城市，多选',
  `target_group` varchar(255) DEFAULT NULL COMMENT '活动参与人群，多选,例如1翼支付，2爱优惠,3普通会员',
  `activty_status` tinyint(3) DEFAULT '0' COMMENT '状态。1为正常 2为已冻结 -1已下架',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_activity
#

LOCK TABLES `iz_activity` WRITE;
/*!40000 ALTER TABLE `iz_activity` DISABLE KEYS */;
INSERT INTO `iz_activity` VALUES (1,'味好美家常经典菜谱式调料免费派发1','随着工作越来越忙，回家做饭的时间越来越少，想吃家常菜，但又做不出正宗的味道，特别是要配齐那些调料还要花不少功夫。现在有了味好美家常经典调料，帮我轻松做出家常美味，更有7款经典菜谱供我选择，美味每一天。“家常经典菜谱式调料”做菜轻松3步走1：将味好美菜谱式调料加适量清水搅拌均匀，调成调味汁。2：加入适..',0,0,NULL,1,1,0,1329375317281,'调料免费派发',0,'0',1,'1_112031_1327994645791_8907931555627602504.jpg','成都市春熙路245号1',0,0,'<p>&nbsp;</p>\r\n<p>活动时间：2011年12月29日-2012年1月3日</p>\r\n<p>活动商家：汇金百货</p>\r\n<p>活动地址：上海市天山路900号</p>\r\n<p>活动<a class=\"articlelink\" target=\"_blank\">商场</a>：汇金百货虹桥店</p>\r\n<p>活动时间：2011年12月29日-2012年1月3日</p>\r\n<p>活动地点：上海市天山路900号汇金百货虹桥店</p>\r\n<p>活动内容：周年庆满198元减100元，每满1000再赠50元券，贵宾礼遇，双重积分，具体内容，详情请见海报或进店询问</p>\r\n<p style=\"text-align: center;\"><img height=\"339\" width=\"500\" alt=\"\" src=\"/coupon/userfiles/image/1_11211_1328077127218_-5157893409010205187.jpg\" /></p>',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (2,'李锦记蒜蓉辣椒酱免费派发','活动时间：2012年1月15日至2月14日 派发产品：李锦记蒜蓉辣椒酱（10g×2） 领取方式：您可至维络城线下任意一台服务设备，打印蒜蓉辣椒酱免费兑换券，并持券至指定体验站，即可换取赠品一份。  寒冬来临，冷风飕飕，多穿衣服把自己裹成个球就够温暖了么？那你就out啦！温暖也要由内而外，来点辣味美食，不仅满足嘴巴的需求，更能让胃也暖起来！李锦记现在就送你美味的蒜蓉辣椒酱，让你在寒冷冬季，感受辣味浓浓，暖意融融!快来领取吧！  更多李锦记美味辣酱请至各大卖场或淘宝李锦记旗舰店选购。',1331883357000,1331883357000,NULL,1,1,0,1329058953888,'李锦记 免费',0,'0',1,'1_11211_1328076383134_4590381683400978321.jpg','李锦记',0,0,'<div class=\"a_t\">\r\n<h1>李锦记蒜蓉辣椒酱免费派发</h1>\r\n<p><span> 发布商家：</span><span>来源：<a href=\"../../../../activityDetail.html?id=2#\" target=\"_blank\">xxxx</a></span><span>1970-01-01 08:00:00 </span></p>\r\n</div>\r\n<div class=\"zhekou_info\">\r\n<p>关键字：李锦记 免费</p>\r\n<ul>\r\n    <li>品&nbsp;&nbsp;&nbsp;&nbsp;牌：<span>各大品牌</span></li>\r\n    <li>活动时间：<span>2012-02-01 14:06:01  至 2012-02-23 14:06:04 </span></li>\r\n    <li>活动地点：<span>李锦记</span></li>\r\n    <li>免责声明：<span>此信息内容仅供参考，详情请咨询相关商户。</span></li>\r\n</ul>\r\n</div>\r\n<p>活动时间：2012-02-01 14:06:01 -2012-02-23 14:06:04</p>\r\n<p>活动商家：</p>\r\n<p>活动地址：李锦记</p>\r\n<p>活动商场：汇金百货虹桥店</p>\r\n<p>活动内容：活动时间：2012年1月15日至2月14日 派发产品：李锦记蒜蓉辣椒酱（10g&times;2）  领取方式：您可至维络城线下任意一台服务设备，打印蒜蓉辣椒酱免费兑换券，并持券至指定体验站，即可换取赠品一份。   寒冬来临，冷风飕飕，多穿衣服把自己裹成个球就够温暖了么？那你就out啦！温暖也要由内而外，来点辣味美食，不仅满足嘴巴的需求，更能让胃也暖起来！李 锦记现在就送你美味的蒜蓉辣椒酱，让你在寒冷冬季，感受辣味浓浓，暖意融融!快来领取吧！  更多李锦记美味辣酱请至各大卖场或淘宝李锦记旗舰店选购。&nbsp;&nbsp;</p>\r\n<p style=\"text-align: center\"><a target=\"_self\" href=\"../../../../activity.html\">点击图片进入频道首页</a></p>\r\n<p>&nbsp;</p>\r\n<p><img width=\"500\" height=\"212\" alt=\"\" src=\"/coupon/userfiles/image/1_11211_1328076383134_4590381683400978321.jpg\" /></p>',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (3,'力士新活炫亮洗发水旅行套装免费派发中','派发产品：力士新活炫亮洗发水旅行套装（洗发水、护发素） 兑换方式：您可至维络城线下任意一台标有力士广告推荐位的服务终端打印新活炫亮洗发水旅行套装免费兑换券，并持券至指定体验站，即可换取体验装一份。',1331791911000,1366098946000,NULL,5,0,0,1331884702609,'力士',0,NULL,1,'1_11211_1328076756801_-9209079545814404486.jpg','力士',0,0,'<p>111222333</p>',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (4,'味好美家常经典菜谱式调料免费派发','*活动一：味好美家常经典菜谱式调料（麻婆豆腐/鱼香肉丝/咖喱鸡/蜜汁排骨/香辣鸡翅，随机一款)+泰式甜辣酱（小袋装）免费派发 活动时间：2012年1月1日至1月15日 兑换方式：您可至维络城线下任意一台标有味好美广告推荐位的服务终端打印家常经典菜谱式调料免费兑换券，并持券至指定体验站，即可换取赠品一份。  *活动二：味好美创意厨房 微博互动 活动时间：2012年1月1日至1月31日 参与方式：在活动期间，凡关注“味好美创意厨房”官方微博，并“@味好美创意厨房#味好美家常经典#+轻轻松松美味一包搞定”。就有机会获得由味好美官方微博提供的研磨瓶双瓶礼盒装+家常经典菜谱式调料一份，总共抽取100份！',1328077095000,1361600297000,NULL,3,0,0,1331884713187,'味好美',0,NULL,1,'1_11211_1328077127218_-5157893409010205187.jpg','各大超市',0,0,'',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (6,'中粮集团 我买网产品免费领取活动','活动内容：凭券免费领取 　　　　　悦活石榴苹果果汁三联包(瓶装 300ml*3) 　　　　　我买网10元折扣券 注意事项：仅限VELO用户，每日限量打印，悦活石榴苹果果汁三联包(瓶装 300ml*3)（每人可免费领取1份）， 　　　　　我买网10元折扣券5000份每人限打3张，先到先得。',1328077980000,1329373982000,NULL,3,6,0,0,'中粮集团 我买网 免费',0,'4715',1,'1_11211_1328078009113_-4202757859902490658.jpg','我买网',1,1,NULL,NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (7,'阿华田乐活五谷随身包免费派发中～','派发产品：阿华田乐活五谷随身包（30g,坚果/黑谷 2选1） 兑换方式：您可至维络城线下任意一台标有阿华田广告推荐位的服务终端打印乐活五谷随身包免费兑换券，并持券至指定体验站，即可换取赠饮一份。',1328078066000,1360910068000,NULL,3,0,0,1331884723734,'阿华田 免费',0,NULL,-1,'1_11211_1328078090253_-3393410131822877525.jpg','成都',0,0,'',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (8,'可采上品营肌系列面膜免费派发中～','派发产品：可采上品营肌系列面膜（单片装） 兑换方式：您可至维络城线下任意一台标有可采广告推荐位的服务终端打印上品营肌系列面膜免费兑换券，并持券至指定体验站，即可换取单片一份。',1331884250000,1333175735000,NULL,5,0,0,1331884103625,'可采 免费',0,NULL,1,'1_11211_1328078165018_886995156878987129.jpg','成都',0,0,'',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (9,'携程100元度假抵用券火热体验中……','* 100元旅游抵用券在携程旅行网订购度假产品时，可用该券冲抵相应的金额，使用金额的限制规定详见携程各度假线路。',0,0,NULL,2,0,0,1328247329765,'旅游 酒店',0,'99',1,'1_11213_1328247327203_-4413309447728270816.jpg','www.ctrip.com',0,0,NULL,NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (10,'想抢鲜尝试小龙虾？快来虾趣试吃','龙虾系列：金牌十三香精品龙虾、特色秘制龙虾、黄焖龙虾、啤酒龙虾',0,0,NULL,0,0,0,1381631754611,'餐饮',0,NULL,1,'1_11213_1328258518500_-4110282845536016193.jpg','国济路30号2楼',0,0,'<p>&nbsp;324rerfvdsfvewr34r</p>\r\n<p>sdfdsaf</p>\r\n<p>sdf</p>\r\n<p>sd<img src=\"/coupon/userfiles/image/小丹尼.jpg\" width=\"114\" height=\"119\" alt=\"\" />af</p>\r\n<p>dsa</p>\r\n<p>fsd</p>\r\n<p>f</p>',NULL,0,NULL,NULL,1);
INSERT INTO `iz_activity` VALUES (11,'小君厨房免费试吃活动','小君厨房是一家改良型川菜馆，环境很不错，干净、明亮。菜肴是改良过的，适合大多数人的口味。地处中环百联3楼，',1331883921000,1333179923000,NULL,4,0,0,1331883931687,'餐饮',0,NULL,1,'1_11213_1328258652593_-7871996776836875321.jpg','真光路1288号（中环百联3楼）',0,0,'','123',0,NULL,NULL,-2);
INSERT INTO `iz_activity` VALUES (17,'汉堡王五周年庆典1 真Fun狂','试吃产品：免费畅享汉堡王各款美食',1332924976000,1333184183000,NULL,0,0,0,1381631662355,'汉堡王五周年庆典 真Fun狂！',0,'4717-4718-4719-4721-4722',1,'1_11213_1328259489906_2973402644136826320.jpg','中山东二路501号B118-119（十六铺）',0,0,'<p>汉堡王五周年庆典 真Fun狂汉堡王五周年庆典 真Fun狂汉堡王五周年庆典 真Fun狂汉堡王五周年庆典 真Fun狂汉堡王五周年庆典 真Fun狂<img src=\"/coupon/userfiles/image/baiyunshan.JPG\" alt=\"\" /></p>',NULL,0,'1-32','1,3',1);
/*!40000 ALTER TABLE `iz_activity` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_admin
#

DROP TABLE IF EXISTS `iz_admin`;
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
INSERT INTO `iz_admin` VALUES ('3','superadmin','e6b92e28c43dccd4','管理员ROOT',NULL,NULL,NULL,NULL,1,NULL,'2012-01-20 00:53:20','Mon Oct 14 13:29:00 CST 2013',0,'M',0,0);
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

DROP TABLE IF EXISTS `iz_bulletin`;
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

DROP TABLE IF EXISTS `iz_busscircl`;
CREATE TABLE `iz_busscircl` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商圈ID',
  `BC_NAME` varchar(32) DEFAULT NULL COMMENT '商圈名',
  `BC_DESCRIPTION` text COMMENT '商圈描述',
  `BELONG_CITY` int(11) NOT NULL DEFAULT '0',
  `ISVISIBLE` tinyint(3) DEFAULT '0' COMMENT '是否在前台展示 0为展示 -1 为不展示',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_busscircl
#

LOCK TABLES `iz_busscircl` WRITE;
/*!40000 ALTER TABLE `iz_busscircl` DISABLE KEYS */;
INSERT INTO `iz_busscircl` VALUES (1,'高升桥','高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎高升桥商圈是一个很少时诵诗书第十四次琐琐碎碎',1,0,0);
INSERT INTO `iz_busscircl` VALUES (2,'春熙路','春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈春熙路商圈',1,0,0);
INSERT INTO `iz_busscircl` VALUES (3,'建设路','诚然成华区着力打造的建设路商圈离成熟商圈的距离还是较远的，几个大的卖场的出现并不能说明此地已经形成了商圈。\r\n\r\n    相比成都其它成熟商圈建设路商圈幅射范围十分有限，不论是向外幅射还是向内幅射，幅射面基本还局限在老东效这一块。如果不解决好这个问题，建设路商圈发展潜力并不大。究其原因，因为建设路本身就是一条断头路，虽然两边分别连接一环和二环，但缺少射状道路。两条辅路建设北路和建设南路向外也是断头路，不能直达外延，不能给建设路商圈有力的支撑。而且建设路T字形态也与其他成熟商圈规划的十字中心形态相左，不利与商圈发展。',1,0,0);
INSERT INTO `iz_busscircl` VALUES (5,'八宝街','八宝街八宝街八宝街商圈很有名哟',1,0,0);
INSERT INTO `iz_busscircl` VALUES (101,'万年场','万年场万年场万年场万年场万年场万年场万年场万年场',1,-1,0);
INSERT INTO `iz_busscircl` VALUES (103,'浦东新区','测试',7,0,0);
INSERT INTO `iz_busscircl` VALUES (104,'长宁县','测试',6,0,0);
INSERT INTO `iz_busscircl` VALUES (105,'宜宾县','测试',6,0,0);
INSERT INTO `iz_busscircl` VALUES (118,'蜀南竹海','旅游景区',6,0,0);
INSERT INTO `iz_busscircl` VALUES (124,'江安','江安江安',6,0,0);
INSERT INTO `iz_busscircl` VALUES (129,'南头镇','南头镇南头镇',10,0,0);
INSERT INTO `iz_busscircl` VALUES (130,'南头镇','南头镇南头镇南头镇',10,0,0);
/*!40000 ALTER TABLE `iz_busscircl` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_busscircl_busscircl_categor
#

DROP TABLE IF EXISTS `iz_busscircl_busscircl_categor`;
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

DROP TABLE IF EXISTS `iz_busscircl_categories`;
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

DROP TABLE IF EXISTS `iz_cart`;
CREATE TABLE `iz_cart` (
  `CART_ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '用户ID',
  `GOODS_ID` int(10) DEFAULT NULL COMMENT '商品ID',
  `GOODS_NUM` int(10) DEFAULT NULL COMMENT '商品数量',
  `ADD_TIME` bigint(20) DEFAULT NULL COMMENT '加入时间',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  `cart_type` tinyint(3) DEFAULT '0' COMMENT '0搜藏，为一种特殊的购物车',
  `cart_status` tinyint(3) DEFAULT '0' COMMENT '收藏优惠券的状态，收藏优惠券状态0未支付 1已支付 2已锁定(比如正在验证是否可以打印) 3正在打印 4已经打印',
  PRIMARY KEY (`CART_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Dumping data for table iz_cart
#

LOCK TABLES `iz_cart` WRITE;
/*!40000 ALTER TABLE `iz_cart` DISABLE KEYS */;
INSERT INTO `iz_cart` VALUES (9,1,110,1,1332149794500,NULL,0,0);
INSERT INTO `iz_cart` VALUES (10,1,110,1,1332149814187,NULL,0,0);
INSERT INTO `iz_cart` VALUES (11,1,110,1,1332149828328,NULL,0,1);
INSERT INTO `iz_cart` VALUES (12,1,110,1,1332149917468,NULL,0,1);
INSERT INTO `iz_cart` VALUES (13,1,110,1,1332150065515,NULL,0,1);
INSERT INTO `iz_cart` VALUES (14,1,110,1,1332150301640,NULL,0,0);
INSERT INTO `iz_cart` VALUES (15,1,105,1,1332210886515,NULL,0,1);
INSERT INTO `iz_cart` VALUES (19,1,25626,1,1332233498468,0,0,1);
INSERT INTO `iz_cart` VALUES (20,1,116,1,1332234073677,0,0,1);
INSERT INTO `iz_cart` VALUES (21,34,25627,1,1332470189468,0,0,0);
INSERT INTO `iz_cart` VALUES (22,1,109,1,1335248304984,0,0,0);
/*!40000 ALTER TABLE `iz_cart` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_category
#

DROP TABLE IF EXISTS `iz_category`;
CREATE TABLE `iz_category` (
  `CAT_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `P_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `CAT_DESC` varchar(1000) DEFAULT NULL COMMENT '类别描述',
  `CAT_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '种类分类，1代表是商户分类，2代表优惠券分类，3代表促销活动分类',
  `CREATE_TIME` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `CREATOR_ID` int(10) DEFAULT NULL COMMENT '创建人ID',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标识',
  PRIMARY KEY (`CAT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品类别';

#
# Dumping data for table iz_category
#

LOCK TABLES `iz_category` WRITE;
/*!40000 ALTER TABLE `iz_category` DISABLE KEYS */;
INSERT INTO `iz_category` VALUES (1,0,'服装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (2,1,'女装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (3,1,'童装',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (4,0,'餐饮',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (5,4,'火锅',0,NULL,NULL,NULL,0);
INSERT INTO `iz_category` VALUES (6,0,'家电',0,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `iz_category` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_city
#

DROP TABLE IF EXISTS `iz_city`;
CREATE TABLE `iz_city` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主ID',
  `COUNTRY` varchar(32) DEFAULT NULL COMMENT '国家',
  `PROVINCE` varchar(32) DEFAULT NULL COMMENT '省份、自治区',
  `CITY` varchar(32) DEFAULT NULL COMMENT '城市',
  `P_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `DISTRICT` varchar(32) DEFAULT NULL COMMENT '行政区',
  `ISVISIBLE` tinyint(1) DEFAULT '0' COMMENT '是否开放',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='省份和城市字典';

#
# Dumping data for table iz_city
#

LOCK TABLES `iz_city` WRITE;
/*!40000 ALTER TABLE `iz_city` DISABLE KEYS */;
INSERT INTO `iz_city` VALUES (1,'中国','四川省','成都市',0,'武侯区',0);
INSERT INTO `iz_city` VALUES (6,'中国','四川省','宜宾市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (9,'中国','四川省','遂宁市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (11,'中国','四川省','自贡市 ',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (12,'中国','四川省','攀枝花市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (13,'中国','四川省','泸州市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (14,'中国','四川省','德阳市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (15,'中国','四川省','绵阳市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (16,'中国','四川省','广元市 ',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (17,'中国','四川省','内江市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (18,'中国','四川省','乐山市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (19,'中国','四川省','南充市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (20,'中国','四川省','眉山市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (21,'中国','四川省','广安市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (22,'中国','四川省','达州市 ',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (23,'中国','四川省','雅安市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (24,'中国','四川省','巴中市',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (26,'中国','四川省','阿坝州',NULL,NULL,0);
INSERT INTO `iz_city` VALUES (32,'中国','广东','中山市',NULL,NULL,0);
/*!40000 ALTER TABLE `iz_city` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_city_shop_category
#

DROP TABLE IF EXISTS `iz_city_shop_category`;
CREATE TABLE `iz_city_shop_category` (
  `city_sc_id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_category_id` int(10) DEFAULT NULL,
  `city_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`city_sc_id`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_city_shop_category
#

LOCK TABLES `iz_city_shop_category` WRITE;
/*!40000 ALTER TABLE `iz_city_shop_category` DISABLE KEYS */;
INSERT INTO `iz_city_shop_category` VALUES (9,20,1);
INSERT INTO `iz_city_shop_category` VALUES (41,7,32);
INSERT INTO `iz_city_shop_category` VALUES (44,2,1);
INSERT INTO `iz_city_shop_category` VALUES (45,2,6);
INSERT INTO `iz_city_shop_category` VALUES (66,1,1);
INSERT INTO `iz_city_shop_category` VALUES (67,1,6);
INSERT INTO `iz_city_shop_category` VALUES (68,1,32);
INSERT INTO `iz_city_shop_category` VALUES (71,28,1);
INSERT INTO `iz_city_shop_category` VALUES (72,24,1);
/*!40000 ALTER TABLE `iz_city_shop_category` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_class
#

DROP TABLE IF EXISTS `iz_class`;
CREATE TABLE `iz_class` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '种类名：例如优惠券，代金券',
  `type` int(11) DEFAULT '0' COMMENT '种类类别。1为商户 2为优惠券',
  `description` text COMMENT '描述',
  `sysflag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='产品种类表';

#
# Dumping data for table iz_class
#

LOCK TABLES `iz_class` WRITE;
/*!40000 ALTER TABLE `iz_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `iz_class` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_coupon_shop
#

DROP TABLE IF EXISTS `iz_coupon_shop`;
CREATE TABLE `iz_coupon_shop` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_id` int(11) DEFAULT '0' COMMENT '优惠券ID',
  `shop_id` int(11) DEFAULT '0' COMMENT '商户表ID',
  `sysflag` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='优惠券与使用门店映射表';

#
# Dumping data for table iz_coupon_shop
#

LOCK TABLES `iz_coupon_shop` WRITE;
/*!40000 ALTER TABLE `iz_coupon_shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `iz_coupon_shop` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_goods
#

DROP TABLE IF EXISTS `iz_goods`;
CREATE TABLE `iz_goods` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '商品名',
  `DESCRIPTION` varchar(3000) DEFAULT NULL COMMENT '商品描述',
  `USE_INTRO` varchar(255) DEFAULT NULL COMMENT '使用规则',
  `ERCODE` varchar(255) DEFAULT NULL COMMENT '二维码',
  `CAT_TYPE` smallint(1) DEFAULT NULL COMMENT '所属分类（1优惠券，2商品等分类）',
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
  `ERWEI_ID` bigint(20) DEFAULT '0',
  `ISVERIFIED` tinyint(3) DEFAULT '0' COMMENT '1为审核通过，0为默认，-1为审核未通过',
  `PROMAN` varchar(64) DEFAULT NULL COMMENT '发布人ID',
  `invalid_time` bigint(20) DEFAULT NULL COMMENT '失效时间',
  `YQ_IMG` varchar(255) DEFAULT NULL COMMENT '样券图片',
  `audit_reason` varchar(100) DEFAULT NULL COMMENT '审核不通过理由',
  `coupon_type` int(11) DEFAULT '1' COMMENT '0为折扣券 1为代金券',
  `USE_OBJ` varchar(20) DEFAULT NULL COMMENT '使用对象，1为翼支付用户，2 为爱优惠用户',
  `USE_BRANCHSHOP` varchar(255) DEFAULT NULL COMMENT '使用门店',
  `BELONG_CITY` int(11) DEFAULT '1' COMMENT '所属城市',
  `GOODS_STATUS` int(11) DEFAULT '0' COMMENT '优惠券状态。1为正常 2为已冻结 -1已下架',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=25632 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_goods
#

LOCK TABLES `iz_goods` WRITE;
/*!40000 ALTER TABLE `iz_goods` DISABLE KEYS */;
INSERT INTO `iz_goods` VALUES (1,'翼支付充值','此商品专门用户翼支付充值','此商品专门用户翼支付充值',NULL,1,0,0,NULL,1,1328822607373,1329369688469,1,NULL,0,0,0,0,0,NULL,1,NULL,NULL,NULL,0,10,0,0,NULL,NULL,NULL,NULL,1,'1','114',1,0);
INSERT INTO `iz_goods` VALUES (3,'[玉林兄弟手提串串]签子优惠','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3','erwei_1329463784513.jpg',1,1,0,'0.0',1,0,1329463784513,0,0,104.07,30.67,1326768619000,1326769619000,0,'噩噩噩噩',1,'1_112031_1327991976127_2965042560418566162.jpg',0,0,0,0,0,1,NULL,0,'yq_1329463784719.jpg',NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (102,'斗牛士 全单95折','出示优惠卡享全单95折消费享3倍积分','出示优惠卡','erwei_1328073673655.jpg',1,0,5,'0.0',1,1328073673639,0,0,0,104.07,30.67,1328073673639,1328592008000,0,'斗牛士门店',99,'1_11211_1328073661811_-353937037378035839.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (103,'十味观 凭券消费每满100元立减30元','十味观 凭券消费每满100元立减30元','出示优惠劵','erwei_1328073898869.jpg',1,0,4,'0.0',1,1328073898854,1328073990008,0,0,104.07,30.67,1328073898000,1329283465000,0,'十味观',99,'1_11211_1328073985711_-4853262497147371296.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (104,'国泰电影院8折优惠券','此券限购正价票低于59元特价票，不能使用各项优惠不可同享\r\n\r\n国泰电影院8折优惠券此券限购正价票低于59元特价票，不能使用各项优惠不可同享','出示优惠劵','erwei_1329375399619.jpg',1,0,3,'0.0',1,1328074066820,1329375399619,0,0,104.07,30.67,1328074066000,1329974855000,0,'国泰电影院',99,'1_11211_1328074064023_-213942394411089715.gif',0,0,0,0,0,1,NULL,0,'1',NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (105,'韩林炭烤 凭券满150元立减50元','凭券满150元立减50元','出示优惠劵','erwei_1328074201099.jpg',1,0,2,'0.0',1,1328074201052,0,0,0,104.07,30.67,1328074201052,1330493387000,0,'韩林炭烤',110,'1_11211_1328074197865_9055804336602088009.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (106,'永和大王 麻辣肉酱拌面+海裙菜汤','+卤肉白菜　　　　　11元\r\nW28 麻辣肉酱拌面+海裙菜汤+卤肉白菜　　　　　11元','出示优惠劵','erwei_1328074303801.jpg',1,0,2,'0.0',1,1328074303770,1328074322848,0,0,104.07,30.67,1328074303000,1330407092000,0,'永和大王',110,'1_11211_1328074298114_-3666787271528418942.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (107,'花袭人红楼干锅 凭此券享受宝钗韭香肥牛立减5元','凭此券享受宝钗韭香肥牛立减5元','出示优惠劵','erwei_1328074699015.jpg',1,1,3,'0.0',1,1328074698983,0,0,0,104.07,30.67,1328074698983,1329370684000,0,'花袭人红楼干锅',110,'1_11211_1328074694859_-4864021470077081115.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (108,'[韩坊韩国传统料理]菜品8.8折','所有菜品8.8折优惠（套餐、酒水除外）','凭短信至韩坊韩国传统料理,菜品8.8折,大石西路86号长乐坊,87058586,12年6月29日止',NULL,1,0,3,'0.0',1,0,1328104696486,0,0,104.07,30.67,1328103735000,1329399738000,0,'大石西路86号长乐坊',101,'1_11211_1328104693540_7822424417459891331.jpg',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (109,'[老北京涮羊肉东安南路店]自助48元/客','自助原价58元/客（烤鸭10元/份，另外收费），现价48元/客（烤鸭包括在内）酒水除外（冬至前后三天除外）','凭短信至老北京涮羊肉东安南路店,自助48元/客,东安南路30号,13408024295,12年3月6日止','erwei_1328104960123.jpg',1,2,2,'1',1,1328104960094,1328104960094,0,0,104.07,30.67,1328104960094,1329919172000,0,'东安南路30号',101,'1_11211_1328104951271_665771781957224250.jpg',1,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (110,'[小尖椒餐饮]9折优惠','王府井店，消费满100元 赠送30元代金券；紫竹店、双楠店，来店可享受9折优惠。','凭短信至小尖椒餐饮,菜品9折优惠（海鲜、酒水、小吃除外），详询商家,6月18日止','erwei_1328105847960.jpg',1,3,3,'0.0',1,1328105847949,1328105847949,0,0,104.07,30.67,1328105847949,1328969074000,0,'详询商家',101,'1_11211_1328105839999_-6488433257983416366.jpg',1,1,0,0,0,1,NULL,0,NULL,'0',1,'1',NULL,1,1);
INSERT INTO `iz_goods` VALUES (111,'[新东方千禧大酒店]自助餐7折','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','erwei_1334040349736.jpg',1,0,2,'0.0',1,1328106440391,1334040349736,0,0,0,0,1328106440000,1329488803000,0,'新东方千禧大酒店',4718,'1_11211_1328106432364_288217139216974351.jpg',0,0,0,0,0,1,NULL,0,NULL,NULL,1,'1','',0,0);
INSERT INTO `iz_goods` VALUES (112,'[一鼎乾坤肥牛]菜品8折','菜品8折优惠免包间费送精美果盘一份营业时间10:00-22:00','凭短信至一鼎乾坤肥牛,菜品8折,科华南路1号附27号,85350609,12年7月6日止','erwei_1329888093984.jpg',1,5,5,'0.0',1,1328106735356,1329888093984,0,0,104.07,30.67,1328106735000,1329575508000,0,'科华南路1号附27号',101,'1_11211_1328106720730_-4093510990073103178.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877779236.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (113,'[啡比寻茶]满30元抵用20元现金','A泰式奶茶+骨肉相连，原价70元，现价36元卡布基诺+芝士蛋糕，原价56元，现价36元风味拿铁+香肠鸡蛋卷饼，原价66元，现价38元抹茶','凭短信至啡比寻茶,7款组合特惠任选,满30元抵用20元现金,一人不可同时参与多项优惠,每桌限一条短信,建设南街15号附21号,61311530,12年6月13日止','erwei_1329888084586.jpg',1,0,2,'0.0',1,1328107234853,1329888084586,0,0,104.07,30.67,1328107234000,1329489614000,0,'建设南街15号附21号',101,'1_11211_1328107226865_7229596918778981918.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877768392.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (114,'[聚德福养生土鸡汤锅]菜品8.8折优惠','详细优惠信息：\r\n凭此券可以享受以下优惠：\r\n菜品8折优惠\r\n免包间费\r\n送精美果盘一份\r\n营业时间10:00-22:00 \r\n\r\n \r\n','[聚德福养生土鸡汤锅]菜品8.8折优惠\r\n','erwei_1329888198120.jpg',1,0,3,'0.0',1,1328167748093,1329888198120,0,0,104.07,30.67,1328167748000,1328167238000,0,'科华南路1号附27号',102,'1_11212_1328167732484_-3447320179341044944.jpg',0,0,0,0,0,1,NULL,0,'yq_1329888198219.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (115,'[马卡龙糖果屋]特惠套餐23元','详细优惠信息：7天下载:13 累计:71 浏览:2237\r\n\r\n凭此券可以享受以下优惠：\r\n特惠套餐，马卡龙一个+伯爵茶一位或马卡龙一个+咖啡一杯（不含摩卡）\r\n原价30元，现价23元\r\n\r\n','特惠套餐23元,86713606,12年3月2日止','erwei_1329888064079.jpg',1,0,0,'0.0',1,1328170583968,1329888064079,0,0,104.07,30.67,1328170583000,1328168660000,0,'东大街时代华章1楼附12号,',102,'1_11212_1328170893812_8115233484443806404.jpg',0,0,0,0,0,1,NULL,0,'yq_1329888064189.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (116,'[阿杰发艺]烫染7折','详细优惠信息：7天下载:137 累计:2193 浏览:7296\r\n\r\n凭此券可以享受以下优惠：\r\n\r\n\r\n洗吹10元\r\n洗剪吹20元\r\n（限指定发型师）\r\n烫染7折\r\n','凭短信至阿杰发艺,烫染7折,16家分店,详询商家,2月7日止\r\n','erwei_1329888052428.jpg',1,3,5,'0.0',1,1328171687640,1329888052428,0,0,104.07,30.67,1328171687000,1328171586000,0,'总府路3号5楼',102,'1_11212_1328171595250_-2598787562168557747.jpg',0,0,0,0,0,1,NULL,0,'yq_1329887938954.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (117,'[蓝贝珍珠]下午茶13元','凭此券可以享受以下优惠：\r\n下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n午市自助，原价58元/位，丁丁价48元/位\r\n晚市自助，原价78元/位，丁丁价58元/位\r\n（下午茶：14:00-17:00   午市：11:00-14:00  晚市：17:30-21:00）\r\n\r\n','下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n电话：028-86672995！','erwei_1329888026804.jpg',1,0,2,'0.0',1,1328172697546,1329888026804,0,0,104.07,30.67,1328172697000,1328171793000,0,'时代百盛-1F',102,'1_11212_1328172685078_-3757268142831091617.jpg',0,0,0,0,0,1,NULL,0,'yq_1329887926329.jpg',NULL,1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (118,'[爱丽美甲]指甲护理15元','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','erwei_1329888017500.jpg',1,0,0,'0.0',1,1328173894890,1329888017500,0,0,104.07,30.67,1328173894000,1328173834000,0,'爱丽美甲连锁(成都华联店) ',102,'1_11212_1328173856375_7439082160877578834.jpg',0,0,0,0,0,1,NULL,0,'yq_1329465908346.jpg','0',1,'1','',1,1);
INSERT INTO `iz_goods` VALUES (119,'[BOBOe族]套餐优惠','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n',NULL,1,0,0,'0.0',1,1328175018578,1329888004866,0,0,104.07,30.67,1328175018000,1328174879000,0,'BOBOe族（芳草店） ',121,'1_11212_1328174987625_3355064501085300246.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877575502.jpg','0',1,'2','',1,1);
INSERT INTO `iz_goods` VALUES (132,'[JEANS日式人气店]时尚染发+欧莱雅护理218元','凭短信至JEANS日式人气店,特价享时尚剪发,日式SPA热能烫+欧莱雅护理258元;时尚染发+欧莱雅护理218元;日式直发烫+欧莱雅护理218元,三店通用,详询商家,4月10日止.','凭短信至JEANS日式人气店,特价享时尚剪发,日式SPA热能烫+欧莱雅护理258元;时尚染发+欧莱雅护理218元;日式直发烫+欧莱雅护理218元,三店通用,详询商家,4月10日止.',NULL,1,1,20,'0.0',122,1329792246200,1329887870173,0,0,0,0,0,0,0,'宛平南路271号',125,'1_112121_1329792224481_5090677083903251232.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877561611.jpg','0',2,'1','',1,1);
INSERT INTO `iz_goods` VALUES (25622,'凭券6元可享受196元的体验套餐(收藏)',NULL,NULL,NULL,1,0,0,NULL,NULL,0,0,NULL,NULL,0,0,0,1340057142796,0,'1111',4713,'cpnimg-115-4713-20120216-154022960.png',NULL,NULL,0,456342,0,0,NULL,NULL,'cpnimg-115-4713-20120216-154015648.bmp',NULL,1,'1',NULL,1,0);
INSERT INTO `iz_goods` VALUES (25626,'凭券10元可享受305元的体验套餐','','','erwei_1331862900593.jpg',1,2,0,'0.0',0,0,1331862900593,0,0,0,0,0,1340057142000,0,'222',2,'cpnimg-115-4713-20120216-155715259.png',0,0,0,0,0,0,NULL,0,NULL,'123',1,'1,2,4','',1,-2);
INSERT INTO `iz_goods` VALUES (25631,'[可颂坊]饮料买一送一 订蛋糕85折优惠','可颂坊，比较有名气的面包房，主要分布在江浙沪地区，可颂坊里的羊角面包做的特别好吃，味道很香，又不腻，其他面包也不错；各式各样的蛋糕，精致好看，虽然价格不菲，但是也物有所值了，因为可颂坊环境也不错，比较温馨，所以很受食客的欢迎','凭此券可以享受以下优惠：\r\nA.正价购买任意饮料买一送一；\r\nB.提前2天预订任意8寸以上（含8寸）蛋糕享受85折优惠；\r\n注：\r\na.不得同时享受其他优惠\r\nb.可颂坊食品预约券不享受上述优惠\r\n天山店、天山百盛店、控江店、新闸店、武宁店，不提供饮料服务；','erwei_1334124795261.jpg',1,0,1,'0.0',12,1333613035585,1334124795261,0,0,0,0,1333612849000,1335513652000,0,'荷花池火车站',4715,'1_11235_1333612978382_8442002263716371367.jpg',0,0,0,0,0,0,NULL,0,NULL,NULL,1,'4','4718-',0,0);
/*!40000 ALTER TABLE `iz_goods` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_goodsimg
#

DROP TABLE IF EXISTS `iz_goodsimg`;
CREATE TABLE `iz_goodsimg` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `GOODS_ID` int(10) DEFAULT NULL COMMENT '图片对应的商品ID',
  `URL` varchar(1024) DEFAULT NULL COMMENT '商品图片URL',
  `PUBLISHMAN` int(10) DEFAULT NULL COMMENT '上传人',
  `ISVALID` tinyint(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

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
INSERT INTO `iz_goodsimg` VALUES (15,116,'1_11212_1328171687468_-6387245570793818476.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (17,117,'1_11212_1328173516531_1239799865568432635.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (18,118,'1_11212_1328173894500_-1473836813047378052.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (19,119,'1_11212_1328175018375_-5061407866977553522.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (20,120,'1_112110_1328820994109_-8164078941925080288.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (26,123,'1_112116_1329371208721_2214261190357176537.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (34,125,'1_112116_1329371467804_3299626492025821898.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (36,115,'1_112116_1329381933294_-1743648598638160270.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (46,3,'1_112031_1327991976127_2965042560418566162.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (53,131,'1_112120_1329719712853_6582851072405223110.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (54,132,'1_112121_1329792234450_-9135000105850008667.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (55,25629,'1_112221_1332318659429_3179636288575255935.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (56,25630,'1_112221_1332318893932_3376695761163816673.jpg',NULL,0);
INSERT INTO `iz_goodsimg` VALUES (57,25631,'1_11235_1333613002681_5296320493559848809.jpg',NULL,0);
/*!40000 ALTER TABLE `iz_goodsimg` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_homepage_push
#

DROP TABLE IF EXISTS `iz_homepage_push`;
CREATE TABLE `iz_homepage_push` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1为导航，2为FLASH 3为推荐商户，4为推荐优惠券',
  `sysflag` tinyint(3) DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `top` int(10) DEFAULT '0' COMMENT '排序',
  `orderHome` int(10) DEFAULT '0' COMMENT '排序',
  `coupon_title` varchar(50) DEFAULT NULL COMMENT '首页优惠劵主题',
  `coupon_price` varchar(20) DEFAULT NULL COMMENT '优惠劵特价',
  `home_cityId` int(10) DEFAULT '1' COMMENT '城市ID',
  `content_type` varchar(255) DEFAULT NULL COMMENT '推荐内容的类型',
  `ref_id` int(10) DEFAULT NULL COMMENT '参照ID',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Dumping data for table iz_homepage_push
#

LOCK TABLES `iz_homepage_push` WRITE;
/*!40000 ALTER TABLE `iz_homepage_push` DISABLE KEYS */;
INSERT INTO `iz_homepage_push` VALUES (2,NULL,NULL,'/coupon/activityDetail.html?id=1','1_112114_1329183131093_-2955470117424040082.jpg',2,0,NULL,0,0,NULL,NULL,1,'activity',1);
INSERT INTO `iz_homepage_push` VALUES (3,NULL,NULL,'/coupon/activityDetail.html?id=5','1_112114_1329183151359_4443240073910583125.jpg',2,0,NULL,0,0,NULL,NULL,1,'activity',5);
INSERT INTO `iz_homepage_push` VALUES (4,NULL,NULL,'/coupon/activityDetail.html?id=7','1_112114_1329183193796_-148469635917830794.jpg',2,0,NULL,0,0,NULL,NULL,1,'activity',7);
INSERT INTO `iz_homepage_push` VALUES (5,NULL,NULL,'/coupon/activityDetail.html?id=8','1_112114_1329183216843_-4551339323518497358.jpg',2,0,NULL,0,0,NULL,NULL,1,'activity',8);
INSERT INTO `iz_homepage_push` VALUES (11,NULL,'[韩坊韩国传统料理]菜品8.8折！','/coupon/couponDetail.html?id=108','1_112114_1329182378781_-3442579263707684895.jpg',4,0,NULL,0,0,'菜品8.8折','仅要120元！',1,'goods',108);
INSERT INTO `iz_homepage_push` VALUES (12,NULL,'[老北京涮羊肉东安南路店]自助48元/客 ','/coupon/couponDetail.html?id=109','1_112114_1329182392140_-8011046990478964888.jpg',4,0,NULL,0,0,'自助羊肉','近48元！',1,'goods',109);
INSERT INTO `iz_homepage_push` VALUES (13,NULL,'[小尖椒餐饮]9折优惠','/coupon/couponDetail.html?id=110','1_112114_1329182398656_-7572719519213368618.jpg',4,0,NULL,0,0,'9折优惠','仅00元！',1,'goods',110);
INSERT INTO `iz_homepage_push` VALUES (15,NULL,'[新东方千禧大酒店]自助餐7折 ','/coupon/couponDetail.html?id=111','1_112114_1329182419296_-6404094893336888618.jpg',4,0,NULL,0,0,'自助餐','仅28元！',1,'goods',111);
INSERT INTO `iz_homepage_push` VALUES (18,NULL,'[一鼎乾坤肥牛]菜品8折','/coupon/couponDetail.html?id=112','1_112114_1329182403015_-9045616887246978198.jpg',4,0,NULL,0,0,'肥牛','仅40元！',1,'goods',112);
INSERT INTO `iz_homepage_push` VALUES (19,NULL,'[啡比寻茶]满30元抵用20元现金','/coupon/couponDetail.html?id=113','1_112114_1329182411687_-7421404609676357339.jpg',4,0,NULL,0,0,'三店通用','仅30元！',1,'goods',113);
INSERT INTO `iz_homepage_push` VALUES (22,NULL,'[老北京涮羊肉东安南路店]自助48元/客','/coupon/couponDetail.html?id=109','1_112114_1329184433390_1691026488155734756.jpg',6,0,NULL,0,0,NULL,NULL,0,'goods',109);
INSERT INTO `iz_homepage_push` VALUES (23,NULL,'[小尖椒餐饮]9折优惠','/coupon/couponDetail.html?id=110','1_112114_1329184443750_4565850430125424346.jpg',6,0,NULL,0,0,NULL,NULL,0,'goods',110);
INSERT INTO `iz_homepage_push` VALUES (24,NULL,'[新东方千禧大酒店]自助餐7折','/coupon/couponDetail.html?id=111','1_112114_1329184457484_2815927536307802997.jpg',6,0,NULL,0,0,NULL,NULL,0,'goods',111);
INSERT INTO `iz_homepage_push` VALUES (25,NULL,'[一鼎乾坤肥牛]菜品8折 ','/coupon/couponDetail.html?id=112','1_112114_1329184468875_-3383215279754727965.jpg',6,0,NULL,0,0,NULL,NULL,0,'goods',112);
INSERT INTO `iz_homepage_push` VALUES (26,NULL,'','/coupon/shopdetail.html?id=101','1_112114_1329183990515_-2328317889019368783.jpg',5,0,NULL,0,0,NULL,NULL,1,'shop',101);
INSERT INTO `iz_homepage_push` VALUES (27,NULL,'','/coupon/shopdetail.html?id=102','1_112114_1329183997203_6136727198268323163.jpg',5,0,NULL,0,0,NULL,NULL,1,'shop',102);
INSERT INTO `iz_homepage_push` VALUES (28,NULL,'','/coupon/shopdetail.html?id=99','1_112114_1329184003718_2112515426162560939.jpg',5,0,NULL,0,0,NULL,NULL,1,'shop',99);
INSERT INTO `iz_homepage_push` VALUES (29,NULL,'','/coupon/shopdetail.html?id=100','1_112114_1329184013281_6919677482337820910.jpg',5,0,NULL,0,0,NULL,NULL,1,'shop',100);
INSERT INTO `iz_homepage_push` VALUES (30,NULL,'味好美家常经典菜谱式调料免费派发','/coupon/activityDetail.html?id=4','1_112114_1329189193687_-3819001896661802832.jpg',7,0,NULL,0,0,NULL,NULL,1,'activity',4);
INSERT INTO `iz_homepage_push` VALUES (31,NULL,'樱之花热力贴冬日给力派发中～','/coupon/activityDetail.html?id=5','1_112114_1329189199687_-4296032411040215736.jpg',7,0,NULL,0,0,NULL,NULL,1,'activity',5);
INSERT INTO `iz_homepage_push` VALUES (32,NULL,'中粮集团 我买网产品免费领取活动','/coupon/activityDetail.html?id=6','1_112114_1329189221390_3421309390878556587.jpg',7,0,NULL,0,0,NULL,NULL,1,'activity',6);
INSERT INTO `iz_homepage_push` VALUES (33,NULL,'阿华田乐活五谷随身包免费派发中～','/coupon/activityDetail.html?id=7','1_112114_1329189242921_2667181625825379610.jpg',7,0,NULL,0,0,NULL,NULL,1,'activity',7);
INSERT INTO `iz_homepage_push` VALUES (34,NULL,'咖啡','/coupon/shopdetail.html?id=101','1_112114_1329189397843_9091773759916537544.jpg',8,0,NULL,0,0,NULL,NULL,1,'shop',101);
INSERT INTO `iz_homepage_push` VALUES (38,NULL,'哈根达斯','/coupon/shopdetail.html?id=102','1_112114_1329189401000_276761134875585119.jpg',8,0,NULL,0,0,NULL,NULL,1,'shop',102);
INSERT INTO `iz_homepage_push` VALUES (39,NULL,'万达','/coupon/shopdetail.html?id=100','1_112114_1329189404625_-6087533971127218326.jpg',8,0,NULL,0,0,NULL,NULL,1,'shop',100);
INSERT INTO `iz_homepage_push` VALUES (40,NULL,'[老北京涮羊肉东安南路店]自助48元/客','/coupon/couponDetail.html?id=109','1_112114_1329189477484_4164232476943236571.jpg',9,0,NULL,0,0,NULL,NULL,1,'goods',109);
INSERT INTO `iz_homepage_push` VALUES (43,NULL,'[小尖椒餐饮]9折优惠','/coupon/couponDetail.html?id=110','1_112114_1329189539625_-690623699617042063.jpg',9,0,NULL,0,0,NULL,NULL,1,'goods',110);
INSERT INTO `iz_homepage_push` VALUES (44,NULL,'[新东方千禧大酒店]自助餐7折','/coupon/couponDetail.html?id=111','1_112114_1329189561937_-5495551454519522312.jpg',9,0,NULL,0,0,NULL,NULL,1,'goods',111);
INSERT INTO `iz_homepage_push` VALUES (45,NULL,'[一鼎乾坤肥牛]菜品8折','/coupon/couponDetail.html?id=112','1_112114_1329189577750_1968155538802597406.jpg',9,0,NULL,0,0,NULL,NULL,1,'goods',112);
INSERT INTO `iz_homepage_push` VALUES (46,NULL,'[啡比寻茶]满30元抵用20元现金','/coupon/couponDetail.html?id=113','1_112114_1329189591859_-6286457335437550380.jpg',9,0,NULL,0,0,NULL,NULL,1,'goods',113);
INSERT INTO `iz_homepage_push` VALUES (47,NULL,'味好美家常经典菜谱式调料免费派发','/coupon/activityDetail.html?id=4','1_112114_1329189657406_-7945669347077834327.jpg',10,0,NULL,0,0,NULL,NULL,1,'activity',4);
INSERT INTO `iz_homepage_push` VALUES (48,NULL,'樱之花热力贴冬日给力派发中～','/coupon/activityDetail.html?id=5','1_112114_1329189686546_1484171517928975704.jpg',10,0,NULL,0,0,NULL,NULL,1,'activity',5);
INSERT INTO `iz_homepage_push` VALUES (49,NULL,'中粮集团 我买网产品免费领取活动','/coupon/activityDetail.html?id=6','1_112114_1329189712046_1456380245486381321.jpg',10,0,NULL,0,0,NULL,NULL,1,'activity',6);
INSERT INTO `iz_homepage_push` VALUES (50,NULL,'阿华田乐活五谷随身包免费派发中～','/coupon/activityDetail.html?id=7','1_112114_1329189736531_-898635496424056992.jpg',10,0,NULL,0,0,NULL,NULL,1,'activity',7);
INSERT INTO `iz_homepage_push` VALUES (51,NULL,'可采上品营肌系列面膜免费派发中～','/coupon/activityDetail.html?id=8','1_112114_1329189773812_8538858945376852381.jpg',10,0,NULL,0,0,NULL,NULL,1,'activity',8);
INSERT INTO `iz_homepage_push` VALUES (52,'商户活动主题','华贸购物中心精品特卖2折起,寒冷冬季酸辣美食送温暖免费派发中，李记食品大优惠','/coupon/activityDetail.html?id=21','1_11225_1330929520500_1420868114424298483.jpg',13,0,NULL,0,0,NULL,NULL,1,'activity',21);
INSERT INTO `iz_homepage_push` VALUES (53,NULL,NULL,'/coupon/shopdetail.html?id=102','1_112114_1329181439140_5536004391937048783.jpg',3,0,NULL,0,4,NULL,NULL,1,'shop',113);
INSERT INTO `iz_homepage_push` VALUES (54,NULL,NULL,'/coupon/shopdetail.html?id=100','1_112114_1329181370656_8867309061224847516.jpg',3,0,NULL,0,3,NULL,NULL,1,'shop',115);
INSERT INTO `iz_homepage_push` VALUES (55,NULL,NULL,'/coupon/shopdetail.html?id=99','1_112114_1329181403703_-89035428580486571.jpg',3,0,NULL,0,2,NULL,NULL,1,'shop',114);
INSERT INTO `iz_homepage_push` VALUES (56,NULL,NULL,'/coupon/shopdetail.html?id=101','1_112114_1329181479500_8732994808501733428.jpg',3,0,NULL,0,1,NULL,NULL,1,'shop',110);
INSERT INTO `iz_homepage_push` VALUES (57,NULL,NULL,'/coupon/shopdetail.html?id=102','1_112114_1329181439140_5536004391937048783.jpg',3,0,NULL,0,5,NULL,NULL,1,'shop',102);
INSERT INTO `iz_homepage_push` VALUES (58,NULL,NULL,'/coupon/shopdetail.html?id=100','1_112114_1329181370656_8867309061224847516.jpg',3,0,NULL,0,6,NULL,NULL,1,'shop',100);
INSERT INTO `iz_homepage_push` VALUES (59,NULL,NULL,'/coupon/shopdetail.html?id=99','1_112114_1329181403703_-89035428580486571.jpg',3,0,NULL,0,7,NULL,NULL,1,'shop',99);
INSERT INTO `iz_homepage_push` VALUES (60,NULL,NULL,'/coupon/shopdetail.html?id=101','1_112114_1329181479500_8732994808501733428.jpg',3,0,NULL,0,8,NULL,NULL,1,'shop',101);
INSERT INTO `iz_homepage_push` VALUES (61,NULL,NULL,'/coupon/shopdetail.html?id=102','1_112114_1329181439140_5536004391937048783.jpg',3,0,NULL,0,9,NULL,NULL,1,'shop',102);
INSERT INTO `iz_homepage_push` VALUES (62,NULL,NULL,'/coupon/shopdetail.html?id=100','1_112114_1329181370656_8867309061224847516.jpg',3,0,NULL,0,10,NULL,NULL,1,'shop',100);
INSERT INTO `iz_homepage_push` VALUES (63,NULL,NULL,'/coupon/shopdetail.html?id=99','1_112114_1329181403703_-89035428580486571.jpg',3,0,NULL,0,11,NULL,NULL,1,'shop',99);
INSERT INTO `iz_homepage_push` VALUES (64,NULL,NULL,'/coupon/shopdetail.html?id=101','1_112114_1329181479500_8732994808501733428.jpg',3,0,NULL,0,12,NULL,NULL,1,'shop',101);
INSERT INTO `iz_homepage_push` VALUES (65,NULL,'','/coupon/shopdetail.html?id=4715','1_11225_1330930673759_-5003598662441226199.jpg',5,0,NULL,0,0,NULL,NULL,1,'shop',4715);
INSERT INTO `iz_homepage_push` VALUES (66,NULL,'[啡比寻茶]满30元抵用20元现金','/coupon/activityDetail.html?id=4','1_11225_1330932771250_25741765861689597.jpg',14,0,NULL,0,0,NULL,NULL,1,'activity',4);
INSERT INTO `iz_homepage_push` VALUES (67,NULL,'樱之花热力贴冬日给力派发中～','/coupon/activityDetail.html?id=5','1_112114_1329189686546_1484171517928975704.jpg',14,0,NULL,0,0,NULL,NULL,1,'activity',NULL);
INSERT INTO `iz_homepage_push` VALUES (68,NULL,'可采上品营肌系列面膜免费派发中～','/coupon/activityDetail.html?id=8','1_112114_1329189773812_8538858945376852381.jpg',14,0,NULL,0,0,NULL,NULL,1,'activity',NULL);
INSERT INTO `iz_homepage_push` VALUES (69,NULL,'咖啡','/coupon/shopdetail.html?id=101','1_112114_1329189397843_9091773759916537544.jpg',15,0,NULL,0,0,NULL,NULL,1,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (70,NULL,'哈根达斯','/coupon/shopdetail.html?id=102','1_112114_1329189401000_276761134875585119.jpg',15,0,NULL,0,0,NULL,NULL,1,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (71,NULL,'万达','/coupon/shopdetail.html?id=100','1_112114_1329189404625_-6087533971127218326.jpg',15,0,NULL,0,0,NULL,NULL,1,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (72,NULL,'万达','/coupon/shopdetail.html?id=101','1_112114_1329189397843_9091773759916537544.jpg',15,0,NULL,0,0,NULL,NULL,1,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (73,NULL,'咖啡','/coupon/shopdetail.html?id=101','1_112114_1329189397843_9091773759916537544.jpg',15,0,NULL,0,0,NULL,NULL,1,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (74,'万达电影','万达电影','/coupon/shopdetail.html?id=99','1_112114_1329184003718_2112515426162560939.jpg',16,0,NULL,0,0,NULL,NULL,0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (75,'碎蝶咖啡厅','碎蝶咖啡厅','/coupon/shopdetail.html?id=101','1_112114_1329183990515_-2328317889019368783.jpg',16,0,NULL,0,0,NULL,NULL,0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (76,'国美电器','国美电器','/coupon/shopdetail.html?id=100','1_112114_1329184013281_6919677482337820910.jpg',16,0,NULL,0,0,NULL,NULL,0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (77,'哈根达斯','哈根达斯','/coupon/shopdetail.html?id=102','1_112114_1329183997203_6136727198268323163.jpg',16,0,NULL,0,0,NULL,NULL,0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (78,NULL,'首饰','/coupon/couponDetail.html?id=115','1_112213_1331615313859_801915526072347945.jpg',17,0,NULL,0,0,'','',0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (79,NULL,'å½ç¾çµå¨','/coupon/shopdetail.html?id=100','1_112114_1329184013281_6919677482337820910.jpg',17,0,NULL,0,0,'','',0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (80,NULL,'ç¢è¶åå¡å','/coupon/shopdetail.html?id=101','1_112114_1329183990515_-2328317889019368783.jpg',17,0,NULL,0,0,'','',0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (81,NULL,'ä¸è¾¾çµå½±','/coupon/shopdetail.html?id=99','1_112114_1329184003718_2112515426162560939.jpg',17,0,NULL,0,0,'','',0,'shop',NULL);
INSERT INTO `iz_homepage_push` VALUES (82,NULL,'法餐厅','/coupon/shopdetail.html?id=4721','1_112221_1332315852839_-4702448436528415351.gif',18,0,NULL,0,0,NULL,NULL,0,'shop',NULL);
/*!40000 ALTER TABLE `iz_homepage_push` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_msg_template
#

DROP TABLE IF EXISTS `iz_msg_template`;
CREATE TABLE `iz_msg_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `template_code` varchar(200) DEFAULT NULL COMMENT '模板编码',
  `template_content` varchar(2000) DEFAULT NULL COMMENT '模板内容',
  `modify_time` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `modifier` int(10) DEFAULT NULL COMMENT '修改者',
  `sysflag` smallint(4) DEFAULT NULL COMMENT '系统标识',
  `description` varchar(200) DEFAULT NULL COMMENT '简要描述',
  `msg_flag` tinyint(1) DEFAULT '0' COMMENT '0短信 2彩信',
  `title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='信息模板表';

#
# Dumping data for table iz_msg_template
#

LOCK TABLES `iz_msg_template` WRITE;
/*!40000 ALTER TABLE `iz_msg_template` DISABLE KEYS */;
INSERT INTO `iz_msg_template` VALUES (1,'common_coupon_user','您好，${user.name}，优惠劵已经发送到您的手机${user.userNo}，请查收，如果未收到短信，请再次点击发送按钮。如有其它问题，请致电10000咨询。',1332742316000,1,0,'一般用户的优惠劵信息模板3333',2,'');
INSERT INTO `iz_msg_template` VALUES (2,'vip_coupon_user','尊敬的%s，优惠劵已经发送到您的手机%s，请您查收，如果未收到短信，请再次点击发送按钮。如有其它问题，请致电10000咨询。。',0,1,0,'vip用户的优惠劵信息模板',2,NULL);
INSERT INTO `iz_msg_template` VALUES (6,'test_code','<img src=\"/coupon/attached/image/20120224/20120224112836_299.jpg\" alt=\"\" width=\"100\" height=\"100\" />城市管理城市管理城市<img src=\"/coupon/attached/image/20120224/20120224113201_861.png\" alt=\"\" width=\"100\" height=\"100\" />管理城市管理城市管理城市管理城市管理${user.name} ${coupon.name}',0,0,0,'市管理城市管理城市管理城',2,NULL);
INSERT INTO `iz_msg_template` VALUES (7,'ce','活动类<@1@>别管理活动类别管理<@2@>活动类别管理活动类别管理',0,1,0,'动类别管理活动',2,NULL);
INSERT INTO `iz_msg_template` VALUES (16,'短信测试','短信测试短信测试短信测',1332742301000,0,0,'短信测试短信测试',0,NULL);
/*!40000 ALTER TABLE `iz_msg_template` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_order
#

DROP TABLE IF EXISTS `iz_order`;
CREATE TABLE `iz_order` (
  `ORDER_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '用户ID',
  `CREATE_TIME` bigint(20) DEFAULT NULL COMMENT '订单创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT NULL COMMENT '订单修改时间',
  `ORDER_STATUS` tinyint(1) DEFAULT NULL COMMENT '订单状态0未支付 1已支付 2已锁定(比如正在验证是否可以打印) 3正在打印 4已经打印',
  `SYSFLAG` tinyint(1) DEFAULT NULL COMMENT '逻辑标志',
  `ORDER_TYPE` smallint(1) DEFAULT NULL COMMENT '订单类型(1购买2收藏)',
  `ORDER_NO` varchar(50) DEFAULT NULL COMMENT '订单号',
  `order_req_tran_seq` varchar(50) DEFAULT NULL COMMENT '订单交易号',
  `cur_type` varchar(10) DEFAULT NULL COMMENT '订单币种(默认RMB)',
  `bank_id` varchar(10) DEFAULT NULL COMMENT '此参数对应银行编码表',
  `up_tran_seq` varchar(50) DEFAULT NULL COMMENT '支付平台交易流水号(char30),由支付平台提供，SP必须保存该信息，作为对帐依据',
  `tran_date` varchar(8) DEFAULT NULL COMMENT '支付平台交易日期(CHAR(8))，由支付平台提供，SP必须保存该信息，格式：YYYYMMDD, 商户对账、清算报表以此日期为准',
  `retn_code` varchar(4) DEFAULT NULL COMMENT '处理结果码，由支付平台统一定义，SP需保存，作为对帐数据。结果码为“0000” 表示支付成功，其他值则表示支付失败',
  `retn_info` varchar(10) DEFAULT NULL COMMENT '处理结果解释码,由支付平台统一定义，对支付结果的说明码',
  `sign` varchar(256) DEFAULT NULL COMMENT '数字签名，数字签名算法由支付平台统一提供，作为核查依据（为1时有效）',
  `encode_type` varchar(1) DEFAULT NULL COMMENT '加密方式',
  `order_amount` double DEFAULT NULL COMMENT '订单总金额',
  `attach_amount` double DEFAULT NULL COMMENT '订单附加金额',
  `product_amount` double DEFAULT NULL COMMENT '产品金额',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='订单表';

#
# Dumping data for table iz_order
#

LOCK TABLES `iz_order` WRITE;
/*!40000 ALTER TABLE `iz_order` DISABLE KEYS */;
INSERT INTO `iz_order` VALUES (1,1,NULL,NULL,4,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_order` VALUES (5,1,1328771465500,0,4,0,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_order` VALUES (6,1,1328771538890,0,4,0,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_order` VALUES (7,1,1328775359187,0,4,0,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_order` VALUES (8,1,1329442259234,0,0,0,0,'20120217093059qn5Tj3','20120217093059VqNp7h','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,NULL);
INSERT INTO `iz_order` VALUES (9,1,1329699959531,0,0,0,2,'20120220090559y8F7dK','201202200905595hYB1u','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (10,1,1329699966546,0,0,0,2,'20120220090606l90kpW','20120220090606SFneG9','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (11,1,1329699968546,0,0,0,2,'20120220090608GDyO6J','201202200906083bTdlz','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (12,1,1329699970390,0,0,0,2,'201202200906107Ig405','201202200906107m7RCj','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (13,1,1329699972359,0,0,0,2,'20120220090612oOcpj0','20120220090612vdp09E','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (14,1,1329699974281,0,0,0,2,'20120220090614OwueKt','20120220090614zypIp7','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (15,1,1329699976171,0,0,0,2,'201202200906160xPS1p','20120220090616DYFSwo','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (16,1,1329699977984,0,0,0,2,'20120220090617RBhSaZ','20120220090617RRWoEV','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (17,1,1329699979812,0,0,0,2,'20120220090619b4CfLY','20120220090619YINoMU','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (18,1,1329699981796,0,0,0,2,'20120220090621mDT0x2','20120220090621Rc96mG','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (19,1,1329699983562,0,0,0,2,'20120220090623TVu7bp','20120220090623zuvLLb','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (20,1,1329699985234,0,0,0,2,'20120220090625E2ntok','20120220090625Bbm6Nz','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (21,1,1329699987343,0,0,0,2,'20120220090627f1bi8n','20120220090627uumNwa','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (22,1,1329699989312,0,0,0,2,'20120220090629Ni9wdT','2012022009062973Je2B','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (23,2,1329699989312,1330419623843,0,0,2,'20120220090629ai9tdT','20120220090629ai9tdb','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (25,2,1329699989312,1330421526156,0,0,2,'20120220090629ai9sdT','20120220090629ai9seT','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (26,1,1330500128666,0,0,0,1,'20120229152208gnsRo1','20120229152208TDq6zc','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (27,1,1330500271948,0,0,0,1,'20120229152431G0JUcq','20120229152431hZx8kF','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (28,1,1330987325589,0,0,0,1,'20120306064205nSkQjc','20120306064205WMFl3A','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',43,0,43);
INSERT INTO `iz_order` VALUES (29,1,1331016204156,0,0,0,1,'201203061443240weOy9','20120306144324lcMsfR','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (30,1,1330987469907,0,0,0,1,'201203060644298pydCU','20120306064429btKxew','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',43,0,43);
INSERT INTO `iz_order` VALUES (31,1,1331021484468,0,0,0,1,'20120306161124IFBymO','20120306161124hHdwXq','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',98.5,1.5,100);
INSERT INTO `iz_order` VALUES (32,1,1331080196805,0,0,0,1,'20120307082956b77jBj','2012030708295626fOx0','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',109.76,2.24,112);
INSERT INTO `iz_order` VALUES (33,1,1331542380640,0,0,0,1,'20120312165300GfUNWk','20120312165300rBnuWp','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',10,0,10);
INSERT INTO `iz_order` VALUES (34,1,1331608866562,0,0,0,1,'20120313112106p3DPb2','20120313112106u5dCPa','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (35,1,1331616929859,0,0,0,1,'20120313133529spO2e1','20120313133529xqwQKY','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (36,34,1331863438468,0,0,0,1,'20120316100358YkicEM','20120316100358iAr8Pu','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',11,0,11);
INSERT INTO `iz_order` VALUES (37,1,1331878026703,0,0,0,1,'20120316140706pEsLTP','20120316140706p8hlbB','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (38,1,1331878338593,0,0,0,1,'20120316141218BiYVIB','20120316141218WUNacI','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (39,1,1331880388640,0,0,0,1,'20120316144628uUSXen','20120316144628FOsiFd','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',196,4,200);
INSERT INTO `iz_order` VALUES (40,0,1332126071171,0,0,0,2,'20120319110111fmgOcI','20120319110111xJ74Jz','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (41,1,1332135050115,0,0,0,1,'20120319133050Ug5dN4','20120319133050SRNQj9','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (42,1,1332135069515,0,0,0,1,'20120319133109rW3R81','20120319133109Ficg1f','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (43,1,1332135109735,0,0,0,1,'20120319133149BFbSlp','20120319133149u2fr8B','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (44,1,1332135511608,0,0,0,1,'20120319133831AhgcKn','20120319133831O2tigg','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (45,1,1332135567803,0,0,0,1,'20120319133927HRlYSo','20120319133927pmRU4o','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (46,1,1332138616116,0,0,0,1,'20120319143016T37YOp','20120319143016hneg96','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (47,1,1332142102362,0,0,0,1,'20120319152822YKgLEx','20120319152822EZxnaO','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (48,1,1332150305359,0,0,0,1,'20120319174505NqLRC3','2012031917450589VQ7q','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (49,1,1332150417765,0,0,0,1,'20120319174657TKtSOM','201203191746571JEiKL','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (50,1,1332150453484,0,0,0,1,'20120319174733UkFXl8','20120319174733I0lucC','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (51,1,1332150518968,0,0,0,1,'201203191748388LMppu','20120319174838cw22Iy','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (52,1,1332152650830,0,0,0,1,'20120319182410V7PrG7','20120319182410vt3HZr','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (53,1,1332213147140,0,0,0,1,'20120320111227FF2vwa','201203201112274ea6oO','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (54,1,1332284188047,0,0,0,1,'20120321065627OWRE2k','20120321065628NN5Cu3','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (55,1,1332284673955,0,0,0,1,'20120321070433TeNxJG','20120321070433oUFX78','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (56,1,1332284687743,0,0,0,1,'20120321070447T3Rj8n','20120321070447LhPvIP','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (57,1,1332284702792,0,0,0,1,'20120321070502BEn5zN','20120321070502Wvysas','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (58,1,1332286009905,0,0,0,1,'20120321072649TJwz7Z','20120321072649UoyJzo','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (59,1,1332286326302,0,0,0,1,'20120321073206Maw9Zu','20120321073206LvPwrR','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (60,1,1332287080986,0,0,0,1,'20120321074440cfdjri','20120321074440sEmMSJ','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (61,34,1332470198812,0,0,0,1,'20120323103638WQHH1L','20120323103638UGVaGd','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (62,1,1335248201984,0,0,0,1,'20120424141641mWWtpP','20120424141641uTY8Kn','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,10,1);
INSERT INTO `iz_order` VALUES (63,1,1335248315468,0,0,0,1,'20120424141835bq7Gg6','20120424141835k17PiA','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (64,1,1335248567218,0,0,0,1,'20120424142247rulKj3','20120424142247NGoww8','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (65,1,1335248720593,0,0,0,1,'20120424142520613ghj','20120424142520SP9G0R','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (66,1,1335249882359,0,0,0,1,'20120424144442OPQ46x','20120424144442GlykYf','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (67,1,1335257624093,0,0,0,1,'20120424165344qdm7O9','20120424165344kH1G0K','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',0,0,0);
INSERT INTO `iz_order` VALUES (68,1,1335333235437,0,0,0,1,'20120425135355ql0HhA','20120425135355iYGiQC','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (69,1,1335333398640,0,0,0,1,'20120425135638rVETsv','20120425135638iYZSvJ','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (70,1,1335333418281,0,0,0,1,'20120425135658vmctpa','20120425135658DWtRfl','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (71,1,1335335339062,0,0,0,1,'20120425142859jxkoZp','201204251428595wZufW','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (72,1,1335336133750,0,0,0,1,'20120425144213SVuohm','20120425144213y3JCIA','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (73,1,1335336152625,0,0,0,1,'20120425144232twYtDd','20120425144232b8GRWm','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (74,1,1335336416843,0,0,0,1,'201204251446562u3NIW','20120425144656JiEc8z','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (75,1,1335336446484,0,0,0,1,'201204251447269NA370','20120425144726Ean6XU','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (76,1,1335336470703,0,0,0,1,'20120425144750BQsLKe','20120425144750uOeaf5','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (77,1,1335337138031,0,0,0,1,'20120425145858D8SZ4m','20120425145858U9rvk4','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (78,1,1335338485234,0,0,0,1,'20120425152125Yr16Rg','201204251521252y0XOI','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (79,1,1335338516156,0,0,0,1,'20120425152156qb1Hdl','20120425152156agpPdt','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (80,1,1335338574343,0,0,0,1,'20120425152254htpHdz','20120425152254IG3e9I','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (81,1,1335338633828,0,0,0,1,'20120425152353DViYBB','201204251523530veFJA','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (82,1,1335338727734,0,0,0,1,'20120425152527F61JI0','20120425152527NnaKNg','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (83,1,1335338746296,0,0,0,1,'20120425152546KYVXqB','20120425152546brd5kd','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (84,1,1335338792625,0,0,0,1,'20120425152632GMHSLm','20120425152632gvJNI4','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (85,1,1335338834406,0,0,0,1,'20120425152714CttDJT','201204251527146LWl2g','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (86,1,1335338868843,0,0,0,1,'20120425152748WGWYnA','20120425152748cnpANQ','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (87,1,1335339241921,0,0,0,1,'20120425153401DCMSFm','20120425153401ckLGij','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (88,1,1335339298859,0,0,0,1,'20120425153458Othsm4','20120425153458iI4MWE','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (89,1,1335343232625,0,0,0,1,'20120425164032ukpElY','20120425164032vyurgp','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
INSERT INTO `iz_order` VALUES (90,1,1335343232625,0,0,0,1,'20120425164032x4Djvt','20120425164032fUQxSz','RMB',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,0,1);
/*!40000 ALTER TABLE `iz_order` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_orderitem
#

DROP TABLE IF EXISTS `iz_orderitem`;
CREATE TABLE `iz_orderitem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT '0' COMMENT '订单ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '商品名',
  `DESCRIPTION` varchar(3000) DEFAULT NULL COMMENT '商品描述',
  `USE_INTRO` varchar(255) DEFAULT NULL,
  `ERCODE` varchar(255) DEFAULT NULL COMMENT '二维码',
  `CAT_TYPE` smallint(1) DEFAULT NULL COMMENT '所属分类（1优惠券，2商品，4收藏优惠劵 等分类）',
  `BELONG_BC` int(11) NOT NULL DEFAULT '0' COMMENT '所属商圈',
  `BELONG_CAT` int(11) NOT NULL DEFAULT '0' COMMENT '属于分类（该分类指美食，美发等分类）',
  `PRICE` varchar(32) DEFAULT NULL COMMENT '商品价格',
  `NUMBER` int(10) DEFAULT NULL COMMENT '商品数量',
  `CREATE_TIME` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `ISVALID` tinyint(1) DEFAULT NULL COMMENT '有效性',
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
  `ERWEI_ID` bigint(20) DEFAULT '0',
  `ISVERIFIED` tinyint(3) DEFAULT '0' COMMENT '1为审核通过，0为默认，-1为审核未通过',
  `PROMAN` varchar(64) DEFAULT NULL COMMENT '发布人ID',
  `invalid_time` bigint(20) DEFAULT NULL COMMENT '失效时间',
  `YQ_IMG` varchar(255) DEFAULT NULL COMMENT '样券图片',
  `audit_reason` varchar(100) DEFAULT NULL COMMENT '审核不通过理由',
  `coupon_type` int(11) DEFAULT '1' COMMENT '0为折扣券 1为代金券',
  `USE_OBJ` varchar(20) DEFAULT NULL COMMENT '使用对象，1为翼支付用户，2 为爱优惠用户',
  `USE_BRANCHSHOP` varchar(255) DEFAULT NULL COMMENT '使用门店',
  `BELONG_CITY` int(11) DEFAULT '1' COMMENT '所属城市',
  `goods_number` int(11) DEFAULT '0' COMMENT '商品数量',
  `sysflag` tinyint(3) DEFAULT '0',
  `goods_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=25672 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_orderitem
#

LOCK TABLES `iz_orderitem` WRITE;
/*!40000 ALTER TABLE `iz_orderitem` DISABLE KEYS */;
INSERT INTO `iz_orderitem` VALUES (1,24,'翼支付充值','此商品专门用户翼支付充值','此商品专门用户翼支付充值',NULL,2,0,0,NULL,1,1328822607373,1329369688469,1,0,0,0,0,0,NULL,1,NULL,NULL,NULL,0,10,0,0,NULL,NULL,NULL,NULL,1,'1','114',1,0,NULL,1);
INSERT INTO `iz_orderitem` VALUES (3,23,'[玉林兄弟手提串串]签子优惠[玉林兄弟手提串串]签子优惠[玉林兄弟手提串串]签子优惠','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根','凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根，现价0.45元/根特签原价2元/根，现价1.8元/根特签原价3凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以下优惠：短签原价0.15元/根，现价0.13元/根长签原价0.5元/根凭此券可以享受以','erwei_1329463784513.jpg',1,1,0,'0.0',1,0,1329463784513,0,104.07,30.67,1326768619000,1326769619000,0,'宛平南路271号宛平南路271号宛平南路271号宛平南路271号宛平南路271号宛平南路271号宛平南路271号宛平南路271号宛平南路271号',125,'1_112031_1327991976127_2965042560418566162.jpg',0,0,0,0,0,1,NULL,0,'yq_1329463784719.jpg',NULL,1,'1',NULL,1,0,0,3);
INSERT INTO `iz_orderitem` VALUES (55,46,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,55);
INSERT INTO `iz_orderitem` VALUES (102,21,'斗牛士 全单95折','出示优惠卡享全单95折消费享3倍积分','出示优惠卡','erwei_1328073673655.jpg',1,0,5,'0.0',1,1328073673639,0,0,104.07,30.67,1328073673639,1328592008000,0,'斗牛士门店',99,'1_11211_1328073661811_-353937037378035839.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,102);
INSERT INTO `iz_orderitem` VALUES (103,22,'十味观 凭券消费每满100元立减30元','十味观 凭券消费每满100元立减30元','出示优惠劵','erwei_1328073898869.jpg',1,0,4,'0.0',1,1328073898854,1328073990008,0,104.07,30.67,1328073898000,1329283465000,0,'十味观',99,'1_11211_1328073985711_-4853262497147371296.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,103);
INSERT INTO `iz_orderitem` VALUES (104,19,'国泰电影院8折优惠券','此券限购正价票低于59元特价票，不能使用各项优惠不可同享\r\n\r\n国泰电影院8折优惠券此券限购正价票低于59元特价票，不能使用各项优惠不可同享','出示优惠劵','erwei_1329375399619.jpg',1,0,3,'0.0',1,1328074066820,1329375399619,0,104.07,30.67,1328074066000,1329974855000,0,'国泰电影院',99,'1_11211_1328074064023_-213942394411089715.gif',0,0,0,0,0,1,NULL,0,'1',NULL,1,'1',NULL,1,0,0,104);
INSERT INTO `iz_orderitem` VALUES (105,20,'韩林炭烤 凭券满150元立减50元','凭券满150元立减50元','出示优惠劵','erwei_1328074201099.jpg',1,0,2,'0.0',1,1328074201052,0,0,104.07,30.67,1328074201052,1330493387000,0,'韩林炭烤',110,'1_11211_1328074197865_9055804336602088009.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,105);
INSERT INTO `iz_orderitem` VALUES (106,18,'永和大王 麻辣肉酱拌面+海裙菜汤','+卤肉白菜　　　　　11元\r\nW28 麻辣肉酱拌面+海裙菜汤+卤肉白菜　　　　　11元','出示优惠劵','erwei_1328074303801.jpg',1,0,2,'0.0',1,1328074303770,1328074322848,0,104.07,30.67,1328074303000,1330407092000,0,'永和大王',110,'1_11211_1328074298114_-3666787271528418942.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,106);
INSERT INTO `iz_orderitem` VALUES (107,16,'花袭人红楼干锅 凭此券享受宝钗韭香肥牛立减5元','凭此券享受宝钗韭香肥牛立减5元','出示优惠劵','erwei_1328074699015.jpg',1,1,3,'0.0',1,1328074698983,0,0,104.07,30.67,1328074698983,1329370684000,0,'花袭人红楼干锅',110,'1_11211_1328074694859_-4864021470077081115.gif',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,107);
INSERT INTO `iz_orderitem` VALUES (108,17,'[韩坊韩国传统料理]菜品8.8折','所有菜品8.8折优惠（套餐、酒水除外）','凭短信至韩坊韩国传统料理,菜品8.8折,大石西路86号长乐坊,87058586,12年6月29日止',NULL,1,0,3,'0.0',1,0,1328104696486,0,104.07,30.67,1328103735000,1329399738000,0,'大石西路86号长乐坊',101,'1_11211_1328104693540_7822424417459891331.jpg',0,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,108);
INSERT INTO `iz_orderitem` VALUES (109,12,'[老北京涮羊肉东安南路店]自助48元/客','自助原价58元/客（烤鸭10元/份，另外收费），现价48元/客（烤鸭包括在内）酒水除外（冬至前后三天除外）','凭短信至老北京涮羊肉东安南路店,自助48元/客,东安南路30号,13408024295,12年3月6日止','erwei_1328104960123.jpg',1,2,2,'0.0',1,1328104960094,1328104960094,0,104.07,30.67,1328104960094,1329919172000,0,'东安南路30号',101,'1_11211_1328104951271_665771781957224250.jpg',1,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,109);
INSERT INTO `iz_orderitem` VALUES (110,15,'[小尖椒餐饮]9折优惠','王府井店，消费满100元 赠送30元代金券；紫竹店、双楠店，来店可享受9折优惠。','凭短信至小尖椒餐饮,菜品9折优惠（海鲜、酒水、小吃除外），详询商家,6月18日止','erwei_1328105847960.jpg',1,3,3,'0.0',1,1328105847949,1328105847949,0,104.07,30.67,1328105847949,1328969074000,0,'详询商家',101,'1_11211_1328105839999_-6488433257983416366.jpg',1,1,0,0,0,1,NULL,0,NULL,NULL,1,'1',NULL,1,0,0,110);
INSERT INTO `iz_orderitem` VALUES (111,14,'[新东方千禧大酒店]自助餐7折','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','每日自助晚餐 7折周末自助午餐 7折平安夜、圣诞节、除夕、元旦节、情人节不能使用','erwei_1329888101851.jpg',1,0,2,'0.0',1,1328106440391,1329888101851,0,104.07,30.67,1328106440000,1329488803000,0,'新东方千禧大酒店',101,'1_11211_1328106432364_288217139216974351.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877795908.jpg',NULL,1,'1','',1,0,0,111);
INSERT INTO `iz_orderitem` VALUES (112,13,'[一鼎乾坤肥牛]菜品8折','菜品8折优惠免包间费送精美果盘一份营业时间10:00-22:00','凭短信至一鼎乾坤肥牛,菜品8折,科华南路1号附27号,85350609,12年7月6日止','erwei_1329888093984.jpg',1,5,5,'0.0',1,1328106735356,1329888093984,0,104.07,30.67,1328106735000,1329575508000,0,'科华南路1号附27号',101,'1_11211_1328106720730_-4093510990073103178.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877779236.jpg',NULL,1,'1','',1,0,0,112);
INSERT INTO `iz_orderitem` VALUES (113,11,'[啡比寻茶]满30元抵用20元现金','A泰式奶茶+骨肉相连，原价70元，现价36元卡布基诺+芝士蛋糕，原价56元，现价36元风味拿铁+香肠鸡蛋卷饼，原价66元，现价38元抹茶','凭短信至啡比寻茶,7款组合特惠任选,满30元抵用20元现金,一人不可同时参与多项优惠,每桌限一条短信,建设南街15号附21号,61311530,12年6月13日止','erwei_1329888084586.jpg',1,0,2,'0.0',1,1328107234853,1329888084586,0,104.07,30.67,1328107234000,1329489614000,0,'建设南街15号附21号',101,'1_11211_1328107226865_7229596918778981918.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877768392.jpg',NULL,1,'1','',1,0,0,113);
INSERT INTO `iz_orderitem` VALUES (114,10,'[聚德福养生土鸡汤锅]菜品8.8折优惠','详细优惠信息：\r\n凭此券可以享受以下优惠：\r\n菜品8折优惠\r\n免包间费\r\n送精美果盘一份\r\n营业时间10:00-22:00 \r\n\r\n \r\n','[聚德福养生土鸡汤锅]菜品8.8折优惠\r\n','erwei_1329888198120.jpg',1,0,3,'0.0',1,1328167748093,1329888198120,0,104.07,30.67,1328167748000,1328167238000,0,'科华南路1号附27号',102,'1_11212_1328167732484_-3447320179341044944.jpg',0,0,0,0,0,1,NULL,0,'yq_1329888198219.jpg',NULL,1,'1','',1,0,0,114);
INSERT INTO `iz_orderitem` VALUES (115,9,'[马卡龙糖果屋]特惠套餐23元','详细优惠信息：7天下载:13 累计:71 浏览:2237\r\n\r\n凭此券可以享受以下优惠：\r\n特惠套餐，马卡龙一个+伯爵茶一位或马卡龙一个+咖啡一杯（不含摩卡）\r\n原价30元，现价23元\r\n\r\n','特惠套餐23元,86713606,12年3月2日止','erwei_1329888064079.jpg',1,0,0,'0.0',1,1328170583968,1329888064079,0,104.07,30.67,1328170583000,1328168660000,0,'东大街时代华章1楼附12号,',102,'1_11212_1328170893812_8115233484443806404.jpg',0,0,0,0,0,1,NULL,0,'yq_1329888064189.jpg',NULL,1,'1','',1,0,0,115);
INSERT INTO `iz_orderitem` VALUES (116,8,'[阿杰发艺]烫染7折','详细优惠信息：7天下载:137 累计:2193 浏览:7296\r\n\r\n凭此券可以享受以下优惠：\r\n\r\n\r\n洗吹10元\r\n洗剪吹20元\r\n（限指定发型师）\r\n烫染7折\r\n','凭短信至阿杰发艺,烫染7折,16家分店,详询商家,2月7日止\r\n','erwei_1329888052428.jpg',1,0,5,'0.0',1,1328171687640,1329888052428,0,104.07,30.67,1328171687000,1328171586000,0,'总府路3号5楼',102,'1_11212_1328171595250_-2598787562168557747.jpg',0,0,0,0,0,1,NULL,0,'yq_1329887938954.jpg',NULL,1,'1','',1,0,0,116);
INSERT INTO `iz_orderitem` VALUES (117,7,'[蓝贝珍珠]下午茶13元','凭此券可以享受以下优惠：\r\n下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n午市自助，原价58元/位，丁丁价48元/位\r\n晚市自助，原价78元/位，丁丁价58元/位\r\n（下午茶：14:00-17:00   午市：11:00-14:00  晚市：17:30-21:00）\r\n\r\n','下午茶13元（价值18元，包含4款饮品，任选其一畅饮，甜品、水果、各式糕点等）\r\n电话：028-86672995！','erwei_1329888026804.jpg',1,0,2,'0.0',1,1328172697546,1329888026804,0,104.07,30.67,1328172697000,1328171793000,0,'时代百盛-1F',102,'1_11212_1328172685078_-3757268142831091617.jpg',0,0,0,0,0,1,NULL,0,'yq_1329887926329.jpg',NULL,1,'1','',1,0,0,117);
INSERT INTO `iz_orderitem` VALUES (118,6,'[爱丽美甲]指甲护理15元','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','凭此券可以享受以下优惠：\r\n爱丽标准甲护，原价28元，优惠价15元\r\n（每人限两次）\r\n此活动限两个月\r\n','erwei_1329888017500.jpg',1,0,0,'0.0',1,1328173894890,1329888017500,0,104.07,30.67,1328173894000,1328173834000,0,'爱丽美甲连锁(成都华联店) ',102,'1_11212_1328173856375_7439082160877578834.jpg',0,0,0,0,0,1,NULL,0,'yq_1329465908346.jpg','0',1,'1','',1,0,0,118);
INSERT INTO `iz_orderitem` VALUES (119,5,'[BOBOe族]套餐优惠','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n','凭此券可以享受以下优惠：\r\n浴式魔力烫990元+烫后护理88元+洗剪吹60元+送洗发水一套228元\r\n共1366元，现仅189元（1.4折）\r\n\r\n',NULL,1,0,0,'0.0',1,1328175018578,1329888004866,0,104.07,30.67,1328175018000,1328174879000,0,'BOBOe族（芳草店） ',121,'1_11212_1328174987625_3355064501085300246.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877575502.jpg','0',1,'2','',1,0,0,119);
INSERT INTO `iz_orderitem` VALUES (132,25,'[JEANS日式人气店]时尚染发+欧莱雅护理218元','凭短信至JEANS日式人气店,特价享时尚剪发,日式SPA热能烫+欧莱雅护理258元;时尚染发+欧莱雅护理218元;日式直发烫+欧莱雅护理218元,三店通用,详询商家,4月10日止.','凭短信至JEANS日式人气店,特价享时尚剪发,日式SPA热能烫+欧莱雅护理258元;时尚染发+欧莱雅护理218元;日式直发烫+欧莱雅护理218元,三店通用,详询商家,4月10日止.',NULL,1,1,20,'0.0',122,1329792246200,1329887870173,0,0,0,0,0,0,'宛平南路271号',125,'1_112121_1329792224481_5090677083903251232.jpg',0,0,0,0,0,1,NULL,0,'yq_1329877561611.jpg','0',2,'1','',1,0,0,132);
INSERT INTO `iz_orderitem` VALUES (25622,26,'凭券6元可享受196元的体验套餐(收藏)',NULL,NULL,NULL,4,0,0,NULL,NULL,0,0,NULL,0,0,0,1340057142796,0,'1111',4713,'cpnimg-115-4713-20120216-154022960.png',NULL,NULL,0,456342,0,0,NULL,NULL,'cpnimg-115-4713-20120216-154015648.bmp',NULL,1,'1',NULL,1,0,NULL,25622);
INSERT INTO `iz_orderitem` VALUES (25626,27,'凭券10元可享受305元的体验套餐','','','erwei_1331862900593.jpg',1,0,0,'0.0',0,0,1331862900593,0,0,0,0,1340057142000,0,'222',2,'cpnimg-115-4713-20120216-155715259.png',0,0,0,0,0,0,NULL,0,NULL,NULL,1,'1,2,4','',0,0,0,25626);
INSERT INTO `iz_orderitem` VALUES (25627,28,'测试普通优惠劵','测试普通优惠劵','测试普通优惠劵',NULL,1,0,0,'0.0',0,0,1331863335562,0,0,0,0,1340057142000,0,'222',2,'cptt.png',0,0,0,0,0,1,NULL,0,NULL,NULL,1,'1,2,3,4','',0,0,0,25627);
INSERT INTO `iz_orderitem` VALUES (25628,47,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25628);
INSERT INTO `iz_orderitem` VALUES (25629,48,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,25629);
INSERT INTO `iz_orderitem` VALUES (25630,49,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,25630);
INSERT INTO `iz_orderitem` VALUES (25631,50,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,25631);
INSERT INTO `iz_orderitem` VALUES (25632,51,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,25632);
INSERT INTO `iz_orderitem` VALUES (25633,52,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25633);
INSERT INTO `iz_orderitem` VALUES (25634,53,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25634);
INSERT INTO `iz_orderitem` VALUES (25635,54,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25635);
INSERT INTO `iz_orderitem` VALUES (25636,55,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25636);
INSERT INTO `iz_orderitem` VALUES (25637,56,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25637);
INSERT INTO `iz_orderitem` VALUES (25638,57,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25638);
INSERT INTO `iz_orderitem` VALUES (25639,58,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25639);
INSERT INTO `iz_orderitem` VALUES (25640,59,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25640);
INSERT INTO `iz_orderitem` VALUES (25641,60,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,25641);
INSERT INTO `iz_orderitem` VALUES (25642,61,NULL,NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,25627);
INSERT INTO `iz_orderitem` VALUES (25643,62,'翼支付充值',NULL,NULL,NULL,0,0,0,'0.0',0,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,1,0,1);
INSERT INTO `iz_orderitem` VALUES (25644,63,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25645,64,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25646,65,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25647,66,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25648,67,NULL,NULL,NULL,NULL,0,0,0,'0.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25649,68,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25650,69,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25651,70,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25652,71,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25653,72,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25654,73,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25655,74,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25656,75,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25657,76,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25658,77,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25659,78,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25660,79,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25661,80,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25662,81,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25663,82,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25664,83,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25665,84,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25666,85,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25667,86,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25668,87,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25669,88,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25670,90,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
INSERT INTO `iz_orderitem` VALUES (25671,89,NULL,NULL,NULL,NULL,0,0,0,'1.0',1,0,0,0,0,0,0,0,0,NULL,0,NULL,0,0,0,0,0,0,NULL,0,NULL,NULL,0,'0',NULL,0,0,0,109);
/*!40000 ALTER TABLE `iz_orderitem` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_package
#

DROP TABLE IF EXISTS `iz_package`;
CREATE TABLE `iz_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套餐id',
  `code` varchar(50) DEFAULT NULL COMMENT '套餐编码',
  `name` varchar(200) DEFAULT NULL COMMENT '套餐名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '套餐描述',
  `creator` int(10) DEFAULT NULL COMMENT '套餐创建者',
  `create_time` bigint(20) DEFAULT NULL COMMENT '套餐创建时间',
  `modify_time` bigint(20) DEFAULT NULL COMMENT '套餐修改时间',
  `sysflag` smallint(1) DEFAULT NULL COMMENT '系统标识',
  `isverified` smallint(1) DEFAULT NULL COMMENT '是否已通过审核1 通过 0未通过',
  `isavailable` smallint(1) DEFAULT NULL COMMENT '套餐是否可用1可用0不可用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

#
# Dumping data for table iz_package
#

LOCK TABLES `iz_package` WRITE;
/*!40000 ALTER TABLE `iz_package` DISABLE KEYS */;
INSERT INTO `iz_package` VALUES (1,'coupon','中国电信优惠劵套餐','中国电信优惠劵套餐，订购次套餐能够在指定的优惠劵网站上收藏优惠劵并在终端上打印，享受商家的优惠价格',1,NULL,NULL,NULL,1,1);
INSERT INTO `iz_package` VALUES (2,'package2','package2','package2',1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_package` VALUES (3,'package3','package3','package3',1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_package` VALUES (4,'package4','package4','package4',1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `iz_package` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_pos_user
#

DROP TABLE IF EXISTS `iz_pos_user`;
CREATE TABLE `iz_pos_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal_id` varchar(255) NOT NULL DEFAULT '' COMMENT '终端ID',
  `prog_version` varchar(255) NOT NULL DEFAULT '' COMMENT '终端版本',
  `isvalid` tinyint(3) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_pos_user
#

LOCK TABLES `iz_pos_user` WRITE;
/*!40000 ALTER TABLE `iz_pos_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `iz_pos_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_promote_info
#

DROP TABLE IF EXISTS `iz_promote_info`;
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

DROP TABLE IF EXISTS `iz_role_function`;
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
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','e8dc82076aa5434e9c47a4ceba64a937');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','e8dc82076aa5434e9c37a4ceba64a937');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','e8dc82076aa5434e9c3794ceba63a937');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','9590997276f84c058db85ba8f07a7d15');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','382fedeeb2ec44ceb11405f9e9045729');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4a1e04c17fa34135ac80704f3d36cfea');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4a1e04c17fa34135ac80704f3d36fed9');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','01772f22e07e4131a12fdf172da7de8a');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','66d1efd94cf841269f8b27b78a6e25ef');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','ed3769ac619e483aba2b3b8ebf2f0b16');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','109216c964554ad29852102acea85dff');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','81e99dcb04a64ff4895a8b85f60a1975');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','42e36e5d0a8046e7b76b8ef0fa673c81');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','31b848ed10b64d9cb24e504d4ee996f6');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','31b848ed10b64d9cb24e504d4fd8c5e5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','1ec3262310034ecf87ac8c7fd25ab57c');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','f26c84ec84f4490fa0ffaddbeb8c5ba9');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','95470a13ad2848d590aab2034d1546b2');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4a1e04c17fa34135ac80704f2c36f1d5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','dfadbfc5f6ab42eaa0f52e77bb9f930f');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','863931a121804f9891eaa89b3ace8bc7');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','15877675eca2441f85ded00b46b02f20');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c3aeda3dc4154436b731aed23f087cce');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','e8dc82076aa5434e9c37a4ceba63a937');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','66c14efca2df43769aa8b865b20304fd');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','b8aef2a2504e4048995099604fcb1707');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','cecb279793c64817947e5453ebaf74b5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c74d81b124ef4e059ebeb2bbaaa1fd99');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','c66ad7ebb6f4431ba68fe81d35fa9a1e');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','b36d978183494f95b8501839242480e9');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','aa9bf75feadf4ac5b6a7335d6ec6470f');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','9315ff15e059499c836c1564e0e86d1d');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','7a5065168ed9432f88e873aa33b11bd5');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','5358a47b012f4635ac877115c2461f67');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4da6871d4a3249eca9fb56603027c211');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4cb8e540721b40ddbdb932397fc1821b');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','4b91b1d974cd46078861aa9cb6405e73');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','2f3b181e1f0e44a8ade4b34a28a01687');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','19b1c37bb60f431d859ce031a9f634c0');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','13e9fd6756304c97994f15d550799411');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','1237dd55c35746598313f8e6d8320a4c');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','0d67261073bf4092b4bf1a5f34714c4a');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','0ccebb0bb2124b668ab1100d305c3737');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','002956b9737a4ba592d80318f25e4deb');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','34ca11066f9547a19dcf24de30a2faec');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','ec0eae40dd2f434691c2225189e56da4');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','31f147aed6ef4e5b889dee91949598f8');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','25fda8ef8735458b82cdc0625a32b504');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','3cde1e7343ff4804a837e769494d24c7');
INSERT INTO `iz_role_function` VALUES (NULL,'ffbc9413cb65411f8bbb4b541b5bb8bb','1aedf6a403a84a0eb3e2c68c0585eb46');
/*!40000 ALTER TABLE `iz_role_function` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop
#

DROP TABLE IF EXISTS `iz_shop`;
CREATE TABLE `iz_shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `P_ID` int(11) DEFAULT '0' COMMENT '属于P_ID总店所有。0为总店',
  `NAME` varchar(255) DEFAULT NULL COMMENT '商户分店名',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '描述',
  `BELONG_BC` int(11) DEFAULT '0' COMMENT '所属商圈',
  `BELONG_SHOPCAT` varchar(255) NOT NULL DEFAULT '0' COMMENT '所属行业，例如餐饮，娱乐',
  `ISVALID` tinyint(3) DEFAULT '0' COMMENT '是否有效',
  `ISREMMEND` tinyint(3) DEFAULT '0' COMMENT '是否推荐',
  `SYSFLAG` tinyint(3) DEFAULT '0' COMMENT '系统标识',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '商户地址',
  `DEFAULT_PIC` varchar(255) DEFAULT NULL COMMENT '默认图片',
  `SHOP_LOGO` varchar(255) DEFAULT 'noLogo.jpg' COMMENT '商户LOGO',
  `TELEPHONE` varchar(255) DEFAULT NULL COMMENT '商户电话',
  `IS_HOT` smallint(1) DEFAULT '0' COMMENT '是否热门',
  `CREATE_TIME` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `MODIFY_TIME` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `ISVERIFIED` tinyint(3) DEFAULT '0' COMMENT '是否验证通过',
  `audit_reason` varchar(100) DEFAULT NULL COMMENT '审核不通过理由',
  `SHOP_TYPE` tinyint(1) DEFAULT '0' COMMENT '商户类型，1为翼支付商户，2为优惠券商户，3积分商户',
  `legal_person` varchar(11) DEFAULT NULL COMMENT '法人代表',
  `corporation` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `contact` varchar(10) DEFAULT NULL COMMENT '商户联系人',
  `shopProperties` int(11) DEFAULT NULL COMMENT '商户性质 ：1线上，2线下',
  `service` varchar(100) DEFAULT NULL COMMENT '提供服务',
  `belong_city` int(10) DEFAULT NULL COMMENT '所属城市',
  `promote_info` varchar(2000) DEFAULT NULL COMMENT '优惠信息',
  `X` double DEFAULT '0' COMMENT '商户地址精度',
  `Y` double DEFAULT '0' COMMENT '商户地址纬度坐标',
  `shop_detail` varchar(4000) DEFAULT NULL COMMENT '商户详细介绍',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4723 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_shop
#

LOCK TABLES `iz_shop` WRITE;
/*!40000 ALTER TABLE `iz_shop` DISABLE KEYS */;
INSERT INTO `iz_shop` VALUES (2,0,'用户优惠劵收藏夹','用户优惠劵收藏夹，用于存放用户收藏的优惠劵',0,'0',0,0,0,NULL,NULL,'noLogo.jpg',NULL,0,0,0,0,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (110,114,'万达电影院线(春熙路店)','万达电影院线成立于2005年，隶属于万达集团，是亚洲银幕数排名第一的电影院线，截止2010年底，万达电影院线拥有旗下影城超过70家，银幕超过600块；2010年票房收入超过14亿元，稳居中国第一的市场份额。2010年12月，万达院线荣获第18届亚太电影博览会(CineAsia)“年度放映商”大奖，这是中国内地电影放映商第一次获得这一备受推崇的国际大奖。 ',0,'0',0,1,0,'万达广场','1_11211_1328068573739_3212335554294488748.jpg','noLogo.jpg','028-98765432',1,0,0,1,NULL,1,NULL,NULL,NULL,NULL,NULL,1,NULL,104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (113,0,'哈根达斯','哈根达斯（Haagen-Dazs）作为美国冰激凌品牌，1921年由鲁本·马特斯(Reuben Mattus)研制成功，并于1961在美国纽约布朗克斯命名并上市。它亦成立了连锁雪糕专门店，在世界各国销售其品牌雪糕，在54个国家或地区共开设超过700间分店。另外，在市场占有率上：美国6.1%，英国3.5%，法国1%，日本4.6%，新加坡4%，中国香港5%。哈根达斯生产的产品包括雪糕、雪糕条、雪葩及冰冻奶酪等。',1,'0',0,0,0,'成都市锦江区春熙路中山广场','1_11211_1328068529881_-2089021137846030212.jpg','1_112116_1329375454071_401585112904435848.jpg','028',0,0,1330571968515,1,NULL,1,'','','',1,'0',1,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (114,0,'万达电影院线串','万达电影院线成立于2005年，隶属于万达集团，是亚洲银幕数排名第一的电影院线，截止2010年底，万达电影院线拥有旗下影城超过70家，银幕超过600块；2010年票房收入超过14亿元，稳居中国第一的市场份额。2010年12月，万达院线荣获第18届亚太电影博览会(CineAsia)“年度放映商”大奖，这是中国内地电影放映商第一次获得这一备受推崇的国际大奖。 ',0,'0',0,1,0,'万达广场','1_11211_1328068573739_3212335554294488748.jpg','noLogo.jpg','028-98765432',1,0,0,1,NULL,1,NULL,NULL,NULL,NULL,NULL,1,NULL,104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (115,0,'国美电器串','国美电器（英语：GOME）是中国的一家连锁型家电销售企业，也是中国大陆最大的家电零售连锁企业，2009年，国美电器入选中国世界纪录协会中国最大的家电零售连锁企业。成立于1987年1月1日。董事局主席张大中。在北京、太原、天津、上海、广州、深圳、青岛、长沙、香港等城市设立了42个分公司，及1200多家直营店面。',1,'0',0,0,0,'万达广场','1_11211_1328068403088_6264985277506049387.jpg','noLogo.jpg','028-98765432',0,0,1043114220656,1,NULL,1,'','','',1,'0',1,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (116,0,'碎碟咖啡厅串','　良木缘（又称良木缘咖啡；GOOD WOOD COFFEE）是以提供咖啡、西餐为主，致力于传播咖啡文化的餐饮连锁企业。自 　　 [良木缘咖啡]  1998年在成都创立至今，一直秉承着“铸百年老店，塑领军品牌” 良木缘咖啡西餐有限责任公司是一家经营休闲咖啡，致力于传播咖啡文化的零售连锁企业。“铸百年老店 塑领军品牌”是良木缘公司始终坚持的奋斗目标。 ',1,'0',0,0,0,'成都市科华北路12号','1_11211_1328068498194_3129983718357170552.jpg','noLogo.jpg','8',0,0,1043114195750,1,NULL,1,'','','',1,'刷卡,代泊车',1,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (122,114,'万达电影院线(高深桥路店)','万达电影院线(高深桥路店)万达电影院线(高深桥路店)万达电影院线(高深桥路店)万达电影院线(高深桥路店)',2,'2',0,0,0,'高森桥124号','1_112120_1329729549571_-70069095519721674.jpg','1_112120_1329729542870_1551590839431128281.jpg',NULL,0,0,0,0,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (125,0,'京世日韩人气店','上海京世造型美容连锁机构是一家国内一流形象设计连锁企业。\r\n　　自2004年公司成立以来，“京世”一直秉承“顾客至上、技术领先，创造全球华人最信赖的美容美发品牌”的经营理念，并始终努力在朝这个目标奋斗着。',2,'1',0,0,0,'斜土路2310-2312号','1_112121_1329791728560_4372959141417410002.jpg','1_112121_1329791718614_3283976188827894160.jpg','021-34010553',0,0,0,1,'0',1,'王二小','京世日韩人气店有限公司','王二小',1,'刷卡,代泊车',1,'“京世”市场定位为中、高层次的消费人群。高档的服务体验、中档的收费标准。多层次的消费项目和产品结构，可以让白领一族乃至金领阶层的顾客来店消费不失体面，也兼顾工薪阶层的需求，努力使每一位顾客都能在“京世”体验适合他们的服务需求。',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (126,0,'789火锅(新世界店)','柒捌玖，在易经里，这三个文字代表过去、现在、未来。789，在新概念火锅文化中，这三个数字代表怀旧、时尚、创新。\r\n      789新概念火锅一直崇尚饮食的健康和新鲜，精心挑选产地直送的食材；融合餐饮文化的多元发展，讲究运用日式、西式料理的二次加工；简约风尚和传统文化相互结合，营造出优雅别致的用餐环境。更多了解，请登录：www.789huoguo.com。',1,'0',0,0,0,'黄浦区南京西路2-68号新世界城4F','1_112122_1329892543907_-4460659991429556825.gif','1_112122_1329892535907_-327169453481034692.gif','021-63587388',0,0,0,-1,'测试审核不通过',1,'黄浦区南京西路','黄浦区南京西路','黄浦区南京西路',1,'刷卡',1,'黄浦区南京西路2-68号新世界城4F',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4713,0,'维伯教育-雅思(重要测试数据，请勿删除)','维伯教育-雅思(重要测试数据，请勿删除)',1,'1',0,0,0,NULL,NULL,'noLogo.jpg',NULL,0,0,0,0,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4714,0,'辛巴克咖啡店','星巴克标志 全世界咖啡的现象，是星巴克于1971年首次开始时的创始人开放就职商店。现在有超过7500商店在全球各地的品牌星巴克咖啡馆，提供2200多万客人每年。世界著名的标',0,'1',0,0,0,'长宁路1010号龙之梦购物中心8楼','1_11225_1330927157836_-6726669666789518717.jpg','1_11225_1330927148122_643050117794372806.jpg','02898765432',0,0,1330928989527,1,NULL,1,'王大伟','辛巴克咖啡中国有限公司','王大伟',1,'代泊车',0,'全球各地的品牌星巴克咖啡馆优惠打折',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4715,0,'肯德基','通常简称为KFC，是来自美国的著名连锁快餐厅，由哈兰·山德士上校于1952年创建。主要出售炸鸡、汉堡、薯条、汽水等西式快餐食品。2011年7月，肯德基用豆浆粉冲调豆浆一事引发众多网友不满；8月份，肯德基对此事发出一封致歉信。2011年9月，肯德基称成本上涨再提价；10月，肯德基在全国范围内的餐厅实施第二轮涨价，各餐厅价格可能不同。2012年2月，肯德基30年来首次获准在伊朗开分店。',1,'1',0,0,0,'春熙路2783号','1_11225_1330929212089_5407981304425627801.jpg','1_11225_1330929205273_-8276372900927798399.jpg','021-34010553',0,0,1331101948468,1,NULL,1,'王大伟','肯德基中国公司','王二小',1,'刷卡,代泊车',1,'肯德基优惠券3折起',104.089764,30.67459,'肯德基是世界著名的炸鸡快餐连锁企业，在全球拥有10000多家餐厅，到目前为止，肯德基在全国200多个城市已经拥有1000余家餐厅。严格统一的管理，清洁优雅的用餐环境，令肯德基在数以亿计的顾客心里留下了美好的印象。肯德基的到来不仅率先将现代的快餐概念引入中国，使人们在传统的饮食中第一次感受到了从食品风味到就餐方式的根本不同，并给人们的服务观念带来了重大影响。肯德基（KFC）和著名的休闲餐饮品牌必胜客（PIZZA HUT）、墨西哥口味餐厅TACO BELL以及A& W、Long John Silver’s（LJS）同属于全球最大的餐饮连锁企业之一——百胜餐饮集团。');
INSERT INTO `iz_shop` VALUES (4716,0,'豆捞坊','豆捞坊是上海肥得捞餐饮管理有限公司旗下品牌，豆捞坊成立于2004年，是目前国内时尚、高端火锅的创始者及扛鼎之作。豆捞坊遴选鲜活海鲜和精品肉料，经手工上千次反复捶打，渐生粘性，且弹性十足，微锅涮煮后，口感脆、弹、爽、滑，回味不绝于口。',0,'8',0,0,0,'西藏北路166号大悦城','1_11226_1331000779687_-8525261034329840924.gif','1_11226_1331000743093_8575548232391155253.gif','36397577',0,0,0,1,'0',1,'','','',1,NULL,0,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4717,0,'韩林炭烤','韩林炭烤融合了中韩口味韩林炭烤以牛肉为主、牛排、牛舌、精品五花肉、还有海鲜，刺身等，是更适合众多中国人品尝的韩国餐厅。为了让客人品尝到最新鲜爽嫩的牛肉，每天从专门的肉联公司空运屠宰好的新鲜肉质，餐厅的拌料牛排选用上等的牛排，用韩国秘制的酱汁腌制完全入味后放在烤炉上，就会马上散发出“滋滋”肉香，伴着木炭的清香…',2,'1',0,0,0,'青浦区  ','1_11226_1331000982015_455499244198889448.gif','1_11226_1331000961343_-1086626513490415300.gif','',0,0,0,1,'0',1,'','','',1,NULL,1,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4718,4715,'汉庭（东方店）','汉庭（东方店）身处浦东陆家嘴软件园，酒店地理位置优越、各类娱乐场所近在咫尺，为客人的旅途提供一切便利。酒店空间宽敞，商务、休闲服务配置设备完善，装饰风格时尚典雅，让商务人士得到高性价比的旅居体验。客服电话：4008121121 ',1,'2',0,0,0,'浦东新区峨山路91弄38号','1_11226_1331001205687_8166735546432335623.jpg','1_11226_1331001171859_3478282719718318897.jpg','021-58890022',0,0,1334050928115,1,NULL,1,'','','',1,'刷卡',1,'',104.089764,30.67459,'');
INSERT INTO `iz_shop` VALUES (4719,0,'立丰食品(瑞金店)','立丰食品主要产品有牛肉干,香肠系列,腌腊系列,烧烤熟食系列及肉松,肉铺,肉枣,鸭肫、鸭舌等系列休闲，生产经销牛肉干,香肠,腌腊,烧烤等熟食等系列食品！ ',101,'1',0,0,0,'卢湾区瑞金二路181号-21','1_11226_1331001335125_7378161391446284319.jpg','1_11226_1331001329250_5634523205677603268.jpg','021-64155026',0,0,0,0,NULL,1,'','','',1,NULL,1,'',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4720,0,'避风塘(金山店)','98年上海避风塘美食有限公司在上海以“避风塘”为字号,开出第一家门店, 主营港式特色菜肴和港式点心,至今已拥有逾三十家连锁直营餐馆,已成为全国知名 餐饮品牌. 店内装潢格调通过颇具中国风情、渔乡风情的一些元素的运用“中国红”色块的渲染, 避风塘大块玻璃壁画的呈现,渔家女形象标志的点缀,使整个“避风塘”餐馆洋溢在一派 浓浓的香港铜锣湾渔港风情中. 避风塘以讲究原料纯正、注重工艺精到、追求口味地道、呈现精致美味而著称,',0,'1',0,0,0,'上海市金山区卫清西路168弄99号百联金山购物中心内(近松卫南路) ','1_11226_1331001491234_7032426685800943996.gif','1_11226_1331001470671_9017537277717450765.gif','021-53960088',0,0,1334050900124,1,NULL,1,'','','',1,'0',0,'',104.089764,30.67459,'98年上海避风塘美食有限公司在上海以“避风塘”为字号,开出第一家门店, 主营港式特色菜肴和港式点心,至今已拥有逾三十家连锁直营餐馆,已成为全国知名 餐饮品牌. 店内装潢格调通过颇具中国风情、渔乡风情的一些元素的运用“中国红”色块的渲染, 避风塘大块玻璃壁画的呈现,渔家女形象标志的点缀,使整个“避风塘”餐馆洋溢在一派 浓浓的香港铜锣湾渔港风情中. 避风塘以讲究原料纯正、注重工艺精到、追求口味地道、呈现精致美味而著称,');
INSERT INTO `iz_shop` VALUES (4721,0,'滴意','宽窄巷子】成都最地道法式餐厅！仅159元，享原价502元滴意法国餐厅双人套餐：香煎西冷牛排配薯条+黑胡椒牛柳意面+法式蜗牛+法式鸭珍沙拉+奥尔良烤鸡翅+法式忌廉蘑菇汤+南瓜胡萝卜汤+水果冰激凌+红酒！现在放慢速度，聆听来自美食的声音！ ',2,'1',0,0,0,'成都宽窄巷子33号','1_112221_1332317039425_-2304935369831473298.jpg','1_112221_1332317017628_6675542049912610938.jpg','028-86266535',0,0,0,1,'0',1,'','成都古魅法式餐饮有限责任公司','',1,'刷卡,代泊车',1,'宽窄巷子】成都最地道法式餐厅！仅159元，',104.089764,30.67459,NULL);
INSERT INTO `iz_shop` VALUES (4722,0,'春秋','春秋',1,'1',0,0,0,'春秋','1_112310_1334038047593_-3938173138857250170.jpg','1_112310_1334038041484_-5493892832959684817.jpg','028-12345678',0,0,1334039550296,-1,'123',1,'丁春秋','春秋餐饮有限公司','丁春秋',1,'刷卡,代泊车',1,'翼支付用户，可享全场8折',104.089764,30.67459,'春秋');
/*!40000 ALTER TABLE `iz_shop` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop_categories
#

DROP TABLE IF EXISTS `iz_shop_categories`;
CREATE TABLE `iz_shop_categories` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_category_id` int(10) DEFAULT NULL,
  `category_name` varchar(200) DEFAULT NULL,
  `category_desc` varchar(1000) DEFAULT NULL,
  `category_type` smallint(1) DEFAULT '0' COMMENT '1为商户类别，2为优惠券类别 3为活动类别',
  `sysflag` int(3) DEFAULT '0',
  `isvisible` int(3) DEFAULT '0' COMMENT '类别是否前台展示 0 为展示 -1 为不展示',
  `belongCity` varchar(100) DEFAULT NULL COMMENT '多选城市',
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='商户目录表';

#
# Dumping data for table iz_shop_categories
#

LOCK TABLES `iz_shop_categories` WRITE;
/*!40000 ALTER TABLE `iz_shop_categories` DISABLE KEYS */;
INSERT INTO `iz_shop_categories` VALUES (1,0,'餐饮','餐饮餐饮餐饮餐饮',1,0,0,'1-6-32');
INSERT INTO `iz_shop_categories` VALUES (2,0,'娱乐','娱乐',1,0,0,'1-6');
INSERT INTO `iz_shop_categories` VALUES (7,0,'建材','建材',1,0,0,'32');
INSERT INTO `iz_shop_categories` VALUES (8,1,'火锅','火锅火锅',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (9,8,'四川火锅','四川火锅',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (10,0,'电器','电器',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (20,0,'电影','电影',2,0,0,'1');
INSERT INTO `iz_shop_categories` VALUES (22,0,'促销','促销促销',3,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (24,0,'电影','电影',3,0,0,'1');
INSERT INTO `iz_shop_categories` VALUES (25,2,'唱歌','唱歌',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (26,7,'地板','地板',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (27,10,'空调','空调',1,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (28,0,'川菜','川菜川菜',2,0,0,'1');
INSERT INTO `iz_shop_categories` VALUES (29,20,'科幻','科幻',2,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (30,20,'动作','动作',2,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (32,28,'食善小客','食善小客食善小客',2,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (33,20,'得到','鹅鹅鹅那边',2,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (34,24,'动作','',3,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (35,24,'言情','',3,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (36,22,'香水','',3,0,0,NULL);
INSERT INTO `iz_shop_categories` VALUES (37,1,'水吧','水吧水吧水吧水吧',1,0,0,NULL);
/*!40000 ALTER TABLE `iz_shop_categories` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_shop_shop_category
#

DROP TABLE IF EXISTS `iz_shop_shop_category`;
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

DROP TABLE IF EXISTS `iz_shopadmin`;
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

DROP TABLE IF EXISTS `iz_shoppic`;
CREATE TABLE `iz_shoppic` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` int(11) DEFAULT '0' COMMENT '商户分店ID',
  `URL` varchar(255) DEFAULT NULL,
  `ISMAIN` tinyint(3) DEFAULT '0' COMMENT '是否是封面图',
  `SYSFLAG` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='商户分店图片表';

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
INSERT INTO `iz_shoppic` VALUES (61,110,'1_11211_1328067967414_2945962982957614610.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (62,102,'1_11211_1328068089285_8771735552122292292.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (63,103,'1_11211_1328068306982_4207838795755616491.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (64,104,'1_11211_1328068441008_-752230639173463062.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (65,110,'1_11211_1328081591480_4139364234463242066.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (66,110,'1_11211_1328081591621_6554796927053429624.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (67,110,'1_11211_1328081591668_1167297975319909104.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (68,110,'1_11211_1328081591699_-2128647205268850525.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (69,110,'1_11211_1328081591730_-3604899356275022505.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (70,102,'1_11212_1328161292906_4963779445189311056.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (71,102,'1_11212_1328161293515_3217207383605803563.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (72,102,'1_11212_1328161293734_-3400514567029007609.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (73,102,'1_11212_1328161293890_6958100254975595188.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (74,125,'1_112121_1329791801463_8025946829564654758.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (75,125,'1_112121_1329791801949_231624073942015970.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (76,125,'1_112121_1329791802254_4343701655839289359.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (77,4714,'1_11225_1330928981569_6404735781314882897.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (78,4714,'1_11225_1330928982065_-1848958589714955208.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (79,4714,'1_11225_1330928982516_6716209821970215946.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (80,4714,'1_11225_1330928982890_7853715831636840358.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (81,4714,'1_11225_1330928983261_661764012001248224.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (82,4715,'1_11225_1330929309925_5590530647521490103.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (83,4715,'1_11225_1330929310782_-1977117461590795358.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (84,4715,'1_11225_1330929311228_-7760933927339952558.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (85,4715,'1_11225_1330929311685_-7595884997864191930.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (86,4715,'1_11225_1330929312129_1715109763775996987.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (87,4715,'1_11225_1330929312704_8660530308296360588.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (88,4721,'1_112221_1332317047394_-7068814259438739404.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (89,4722,'1_112310_1334038072984_2682550794835274254.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (90,4722,'1_112310_1334038073125_-487332625822303734.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (91,4722,'1_112310_1334038073312_1919184645241888635.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (92,4722,'1_112310_1334038073406_1428148473602141001.jpg',0,0);
INSERT INTO `iz_shoppic` VALUES (93,4722,'1_112310_1334038073546_-7963847470370194859.jpg',0,0);
/*!40000 ALTER TABLE `iz_shoppic` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_sys_functions
#

DROP TABLE IF EXISTS `iz_sys_functions`;
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
INSERT INTO `iz_sys_functions` VALUES ('','权限管理','权限管理　目录',NULL,2,'','FOLDER','SYS_QX','javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('002956b9737a4ba592d80318f25e4deb','角色管理-添加','角色管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_add','/coupon/system/roleAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('01772f22e07e4131a12fdf172da7de8a','精选活动','精选活动',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','PICKED_ACTIVITY','/coupon/admin/homebk.html?type=10');
INSERT INTO `iz_sys_functions` VALUES ('05fa10e436b2456e82088e889e50c0a0','添加分类','添加分类',NULL,0,'2c2e8bf72e6b405b83b55e0f9ec5beab','RESOURCE','SHO_SH_CAT_ADD','/coupon/admin/catAction.html?a=3');
INSERT INTO `iz_sys_functions` VALUES ('0ccebb0bb2124b668ab1100d305c3737','角色功能点管理-添加','角色功能点管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_add','/coupon/system/functionAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('0d67261073bf4092b4bf1a5f34714c4a','用户管理-添加','用户管理-添加',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_add','/coupon/system/userAdd.html');
INSERT INTO `iz_sys_functions` VALUES ('109216c964554ad29852102acea85dff','活动列表推荐','活动列表推荐',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','ACTIVITY_REC_ACTIVITY','/coupon/admin/homebk.html?type=7');
INSERT INTO `iz_sys_functions` VALUES ('1237dd55c35746598313f8e6d8320a4c','角色管理','角色管理 菜单',NULL,0,'e8dc82076aa5434e9c37a4ceba64a937','MENU','SYS_QX_JS','/coupon/system/to_role.html');
INSERT INTO `iz_sys_functions` VALUES ('13e9fd6756304c97994f15d550799411','角色功能点管理-列表','角色功能点管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_lis','/coupon/system/functionLis.html');
INSERT INTO `iz_sys_functions` VALUES ('15877675eca2441f85ded00b46b02f20','优惠券内容管理','',NULL,0,'c3aeda3dc4154436b731aed23f087cce','MENU','COUPON_CP_CONTENT','/coupon/admin/goodsadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('19b1c37bb60f431d859ce031a9f634c0','用户管理-删除','用户管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_del','/coupon/system/userDel.html');
INSERT INTO `iz_sys_functions` VALUES ('1aedf6a403a84a0eb3e2c68c0585eb46','会员管理','',NULL,3,'','FOLDER','USE_HY','javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('1ec3262310034ecf87ac8c7fd25ab57c','首页推荐商户模块','首页推荐商户模块',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','HOME_BK_SHOP','/coupon/admin/homebk.html?type=3');
INSERT INTO `iz_sys_functions` VALUES ('25fda8ef8735458b82cdc0625a32b504','活动管理','',NULL,0,'ROOT','FOLDER','SHO_SH_HD','/coupon/admin/activityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('2f3b181e1f0e44a8ade4b34a28a01687','用户管理','用户管理　菜单',NULL,0,'e8dc82076aa5434e9c37a4ceba64a937','MENU','SYS_QX_YH','/coupon/system/to_user.html');
INSERT INTO `iz_sys_functions` VALUES ('31b848ed10b64d9cb24e504d4ee996f6','首页优惠劵模块','首页优惠劵模块',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','HOME_BK_COUPON','/coupon/admin/homebk.html?type=4');
INSERT INTO `iz_sys_functions` VALUES ('31b848ed10b64d9cb24e504d4fd8c5e5','首页幻灯片模块','首页幻灯片模块',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','HOME_BK_ACTIVITY','/coupon/admin/homebk.html?type=2');
INSERT INTO `iz_sys_functions` VALUES ('31f147aed6ef4e5b889dee91949598f8','活动类别管理','活动类别管理',NULL,0,'','MENU','ACT_HD_CAT','/coupon/admin/catadmin.html?cat_type=3');
INSERT INTO `iz_sys_functions` VALUES ('382fedeeb2ec44ceb11405f9e9045729','短彩信编辑','短彩信编辑',NULL,0,'ROOT','FOLDER','MSG_EDIT_SMS','javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('3cde1e7343ff4804a837e769494d24c7','会员管理','',NULL,0,'e8dc82076aa5434e9c37a4ceba64a937','MENU','USE_HY_HY','/coupon/admin/useradmin.html');
INSERT INTO `iz_sys_functions` VALUES ('42e36e5d0a8046e7b76b8ef0fa673c81','商家列表推荐','商家列表推荐',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','SHOP_REC_SHOP','/coupon/admin/homebk.html?type=5');
INSERT INTO `iz_sys_functions` VALUES ('4a1e04c17fa34135ac80704f2c36f1d5','商户内容管理','商户内容管理',NULL,0,'dfadbfc5f6ab42eaa0f52e77bb9f930f','MENU','SHO_SH_CONTENT','/coupon/admin/shopadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('4a1e04c17fa34135ac80704f3d36cfea','订单管理','订单管理',NULL,0,'4a1e04c17fa34135ac80704f3d36fed9','MENU','SYS_ORDER_ADMIN','/coupon/admin/order_admin.html');
INSERT INTO `iz_sys_functions` VALUES ('4a1e04c17fa34135ac80704f3d36fed9','订单管理','订单管理',NULL,0,'ROOT','FOLDER','SYS_ORDER_ADMIN_P','/coupon/admin/order_admin.html');
INSERT INTO `iz_sys_functions` VALUES ('4b91b1d974cd46078861aa9cb6405e73','角色管理-列表','角色管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_lis','/coupon/system/roleLis.html');
INSERT INTO `iz_sys_functions` VALUES ('4cb8e540721b40ddbdb932397fc1821b','角色功能点管理-父级选择','角色功能点管理-父级选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_parSelect','/coupon/system/findParentMenusTree.html');
INSERT INTO `iz_sys_functions` VALUES ('4da6871d4a3249eca9fb56603027c211','用户管理-角色选择','用户管理-角色选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_roleSelect','/coupon/system/findRoleList.html');
INSERT INTO `iz_sys_functions` VALUES ('5358a47b012f4635ac877115c2461f67','角色功能点管理-删除','角色功能点管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_del','/coupon/system/functionDel.html');
INSERT INTO `iz_sys_functions` VALUES ('66c14efca2df43769aa8b865b20304fd','城市管理','城市管理',NULL,0,'b8aef2a2504e4048995099604fcb1707','MENU','SQ_MANAGE_CITY','/coupon/admin/cityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('66d1efd94cf841269f8b27b78a6e25ef','精选优惠劵','精选优惠劵',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','PICKED_COUPON','/coupon/admin/homebk.html?type=9');
INSERT INTO `iz_sys_functions` VALUES ('7a5065168ed9432f88e873aa33b11bd5','用户管理-编辑','用户管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_edi','/coupon/system/userEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('81e99dcb04a64ff4895a8b85f60a1975','优惠券列表推荐','优惠券列表推荐',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','COUPON_REC_COUPON','/coupon/admin/homebk.html?type=6');
INSERT INTO `iz_sys_functions` VALUES ('863931a121804f9891eaa89b3ace8bc7','优惠券类别管理','',NULL,0,'','MENU','COUPON_CP_CAT','/coupon/admin/catadmin.html?cat_type=2');
INSERT INTO `iz_sys_functions` VALUES ('9315ff15e059499c836c1564e0e86d1d','角色管理-删除','角色管理-删除',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_del','/coupon/system/roleDel.html');
INSERT INTO `iz_sys_functions` VALUES ('95470a13ad2848d590aab2034d1546b2','类别管理','类别管理',NULL,0,'e8dc82076aa5434e9c37a4ceba64a947','MENU','SHO_SH_CAT','/coupon/admin/catadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('9590997276f84c058db85ba8f07a7d15','短信编辑','短信编辑',NULL,0,'382fedeeb2ec44ceb11405f9e9045729','MENU','MSG_EDIT_DX','/coupon/admin/sms.html');
INSERT INTO `iz_sys_functions` VALUES ('aa9bf75feadf4ac5b6a7335d6ec6470f','角色功能点管理','功能点管理　菜单',NULL,0,'e8dc82076aa5434e9c37a4ceba64a937','MENU','SYS_QX_JSGND','/coupon/system/to_function.html');
INSERT INTO `iz_sys_functions` VALUES ('b36d978183494f95b8501839242480e9','角色管理-编辑','角色管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_edi','/coupon/system/roleEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('b8aef2a2504e4048995099604fcb1707','城市商圈管理','城市商圈管理',NULL,0,'ROOT','FOLDER','SHO_SH_BC','/coupon/admin/cityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('c3aeda3dc4154436b731aed23f087cce','优惠劵管理','',NULL,0,'ROOT','FOLDER','SHO_SH_YHQ','/coupon/admin/goodsadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('c66ad7ebb6f4431ba68fe81d35fa9a1e','角色功能点管理-编辑','角色功能点管理-编辑',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JSGND_edi','/coupon/system/functionEdi.html');
INSERT INTO `iz_sys_functions` VALUES ('c74d81b124ef4e059ebeb2bbaaa1fd99','用户管理-列表','用户管理-列表',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_YH_lis','/coupon/system/userLis.html');
INSERT INTO `iz_sys_functions` VALUES ('cecb279793c64817947e5453ebaf74b5','角色管理-功能选择','角色管理-功能选择',NULL,0,'34ca11066f9547a19dcf24de30a2faec','RESOURCE','SYS_QX_JS_funSelect','/coupon/system/findRoleResourceList.html');
INSERT INTO `iz_sys_functions` VALUES ('dfadbfc5f6ab42eaa0f52e77bb9f930f','商户管理','',NULL,0,'ROOT','FOLDER','SHO_SH_ML','/coupon/admin/shopadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('e8dc82076aa5434e9c3794ceba63a937','彩信编辑','彩信编辑',NULL,1,'382fedeeb2ec44ceb11405f9e9045729','MENU','MSG_EDIT_CX','/coupon/admin/mms.html');
INSERT INTO `iz_sys_functions` VALUES ('e8dc82076aa5434e9c37a4ceba64a937','系统管理','系统管理',NULL,0,'ROOT','FOLDER',NULL,'javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('e8dc82076aa5434e9c37a4ceba64a947','类别管理','类别管理',NULL,0,'ROOT','FOLDER',NULL,'javascript:void(0);');
INSERT INTO `iz_sys_functions` VALUES ('e8dc82076aa5434e9c47a4ceba64a937','系统参数配置','系统参数配置',NULL,0,'e8dc82076aa5434e9c37a4ceba64a937','MENU',NULL,'/coupon/admin/systemMsg.html');
INSERT INTO `iz_sys_functions` VALUES ('ec0eae40dd2f434691c2225189e56da4','活动内容管理','',NULL,0,'25fda8ef8735458b82cdc0625a32b504','MENU','ACT_HD_CONTENT','/coupon/admin/activityadmin.html');
INSERT INTO `iz_sys_functions` VALUES ('ed3769ac619e483aba2b3b8ebf2f0b16','精选商户','精选商户',NULL,0,'f26c84ec84f4490fa0ffaddbeb8c5ba9','MENU','PICKED_SHOP','/coupon/admin/homebk.html?type=8');
INSERT INTO `iz_sys_functions` VALUES ('f26c84ec84f4490fa0ffaddbeb8c5ba9','模块管理','',NULL,0,'ROOT','FOLDER','SHO_SH_HOME','/coupon/admin/welcome');
/*!40000 ALTER TABLE `iz_sys_functions` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_sys_param
#

DROP TABLE IF EXISTS `iz_sys_param`;
CREATE TABLE `iz_sys_param` (
  `id` int(11) DEFAULT NULL COMMENT '参数id',
  `code` varchar(50) DEFAULT NULL COMMENT '参数编码',
  `name` varchar(200) DEFAULT NULL COMMENT '参数名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '参数描述',
  `value` varchar(500) DEFAULT NULL COMMENT '参数值',
  `sysflag` smallint(1) DEFAULT '0' COMMENT '系统标识'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_sys_param
#

LOCK TABLES `iz_sys_param` WRITE;
/*!40000 ALTER TABLE `iz_sys_param` DISABLE KEYS */;
INSERT INTO `iz_sys_param` VALUES (1,'clientId','客户端编号','本系统用于udb登录的客户端编号','1234567891011121',0);
INSERT INTO `iz_sys_param` VALUES (2,'scope','作用域','udb生成code的作用域','chinatelcoupon.com',0);
INSERT INTO `iz_sys_param` VALUES (3,'redirectUri','重定向地址','udb重定向到本系统大的地址','http://www.ccp.com',0);
INSERT INTO `iz_sys_param` VALUES (4,'udbCodeUrl','获取udb编码的url地址','获取udb编码的url地址','http://udb/~/authorize.aspx?response_type=code&client_id=%s&scope=%s&redirect_uri=%s',0);
INSERT INTO `iz_sys_param` VALUES (5,'udbTokenUrl','获取udb令牌的url地址','获取udb令牌的url地址','http://udb/~/ token.aspx',0);
INSERT INTO `iz_sys_param` VALUES (6,'udbResourceUrl','获取udb资源的url地址','获取udb资源的url地址','http://udb/~/ resource.aspx',0);
INSERT INTO `iz_sys_param` VALUES (7,'sysAppId','本应用系统标识','本应用系统标识','upcds',0);
INSERT INTO `iz_sys_param` VALUES (8,'sysVersion','本应用系统的版本','本应用系统的版本','0.5',0);
INSERT INTO `iz_sys_param` VALUES (9,'QueryCustomCode','客户查询编码','客户查询编码','100101',0);
INSERT INTO `iz_sys_param` VALUES (10,'appOrgCode','应用机构代码','\r\n应用机构代码(用于翼支付接口) 02代表web\r\n应用机构代码(用于翼支付接口) 02代表web','02',0);
INSERT INTO `iz_sys_param` VALUES (11,'discountPackageId','爱优惠套餐id','爱优惠套餐id','1',0);
INSERT INTO `iz_sys_param` VALUES (12,'MERCHANTID','SP身份标识','SP身份标识 CHAR(30)','5101000009',0);
INSERT INTO `iz_sys_param` VALUES (13,'MERCHANTURL','前台返回地址','前台返回地址 CHAR(255)','http://localhost:8080/coupon/payed',0);
INSERT INTO `iz_sys_param` VALUES (14,'BACKMERCHANTURL','后台返回地址','后台返回地址 CHAR(255)','http://localhost:8080/coupon/paycallback',0);
INSERT INTO `iz_sys_param` VALUES (15,'ChargeGoodsId','充值商品ID','充值商品ID，专门用于翼支付充值业务的商品','1',0);
INSERT INTO `iz_sys_param` VALUES (16,'terminal_heartbeat','终端心跳地址','终端心跳地址','/coupon/cmd/heartbeat.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (17,'terminal_auth','终端用户认证地址','终端用户认证地址','/coupon/cmd/auth.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (18,'terminal_coupon','终端优惠劵地址','终端优惠劵地址','/coupon/cmd/coupon.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (19,'terminal_printlog','终端打印结果地址','终端打印结果地址','/coupon/cmd/printlog.do?method=afterPrint',0);
INSERT INTO `iz_sys_param` VALUES (20,'terminal_param','终端参数查询上传地址','终端参数查询上传地址','/coupon/cmd/param.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (21,'terminal_printconfirm','终端打印确认地址','终端打印确认地址','/coupon/cmd/printconfirm.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (22,'terminal_upload','文件上报地址','文件上报地址','/coupon/cmd/upload.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (23,'terminal_alarm','警告上报地址','警告上报地址','/coupon/cmd/alarm.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (24,'terminal_default','default.xml文件地址','default.xml文件地址','/coupon/cmd/default.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (25,'terminal_logoconfirm','透光彩更换确认地址','透光彩更换确认地址','/coupon/cmd/logoconfirm.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (26,'terminal_param_query','终端参数查询回调地址','终端参数查询回调地址','/coupon/cmd/param_query.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (27,'terminal_param_update','终端参数更新回调地址','终端参数更新回调地址','/coupon/cmd/param_update.do?method=mth',0);
INSERT INTO `iz_sys_param` VALUES (28,'terminal_file_reporturl','终端文件更新结果回调地址','终端文件更新结果回调地址','/coupon/cmd/file_reporturl.do',0);
/*!40000 ALTER TABLE `iz_sys_param` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_terminal
#

DROP TABLE IF EXISTS `iz_terminal`;
CREATE TABLE `iz_terminal` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `TERMINAL_ID` varchar(50) DEFAULT NULL COMMENT '终端ID号 ',
  `TERMINAL_VERSION` varchar(50) DEFAULT NULL COMMENT '终端程序版本',
  `TERMINAL_ADDR_ID` int(10) DEFAULT NULL COMMENT '终端所在地',
  `last_active_time` bigint(20) DEFAULT NULL COMMENT '最后活跃时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '0离线1在线2故障3更新(可人工手动修改)',
  `code` varchar(50) DEFAULT NULL COMMENT '终端条码',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_terminal
#

LOCK TABLES `iz_terminal` WRITE;
/*!40000 ALTER TABLE `iz_terminal` DISABLE KEYS */;
INSERT INTO `iz_terminal` VALUES (1,'00000000001','V0.1.3.456',33,NULL,NULL,NULL);
INSERT INTO `iz_terminal` VALUES (2,'sctct00001','B600M-line-5715M.',1,NULL,NULL,NULL);
INSERT INTO `iz_terminal` VALUES (3,'8792111111','B600M-line-5715M.',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `iz_terminal` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_terminal_user
#

DROP TABLE IF EXISTS `iz_terminal_user`;
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

DROP TABLE IF EXISTS `iz_user`;
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
  `user_no` varchar(100) DEFAULT NULL COMMENT '用户号(来源于翼支付账户)',
  `pay_pass` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `is_wings_pay_user` smallint(1) DEFAULT '0' COMMENT '是否是翼支付用户',
  `is_i_promote_user` smallint(1) DEFAULT '0' COMMENT '是否是爱优惠用户',
  `user_addr` varchar(200) DEFAULT NULL COMMENT '用户地址',
  `last_session_id` varchar(50) DEFAULT NULL COMMENT '上次登录的session_id',
  `puserid` varchar(50) DEFAULT NULL COMMENT '用户puserid(电信用户字段)',
  `provinceid` varchar(50) DEFAULT NULL COMMENT '用户所在省id(电信用户字段)',
  `numflag` varchar(2) DEFAULT NULL COMMENT '用户类型标识(电信用户字段)',
  `id_type` smallint(1) DEFAULT NULL COMMENT '证件类型',
  `cert_num` varchar(200) DEFAULT NULL COMMENT '证件号码',
  `product_no` varchar(50) DEFAULT NULL COMMENT '电信产品号',
  `custom_no` varchar(50) DEFAULT NULL COMMENT '用户号(来自翼支付账户)',
  `card_no` varchar(50) DEFAULT NULL COMMENT '卡片号(有可能会有，来源于终端系统)',
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Dumping data for table iz_user
#

LOCK TABLES `iz_user` WRITE;
/*!40000 ALTER TABLE `iz_user` DISABLE KEYS */;
INSERT INTO `iz_user` VALUES (1,'Tom','4124bc0a9335c27f086f24ba207a4912','Tom',0,'tom123@321.com','123455','111111',1,'0000-00-00 00:00:00','0000-00-00 00:00:00',1381632470428,0,'12345678910','4124bc0a9335c27f086f24ba207a4912',0,0,'成都市','8D95BAA59CC165866BDFFE39860A4AB9',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456789');
INSERT INTO `iz_user` VALUES (2,'Jerry','4124bc0a9335c27f086f24ba207a4912','Jerry',0,'Jerry@123.com','0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1331100580557,0,'12345678910','5f4dcc3b5aa765d61d8327deb882cf99',0,0,'成都市','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B6EEFA9D');
INSERT INTO `iz_user` VALUES (3,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'987654321');
INSERT INTO `iz_user` VALUES (4,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (5,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (6,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (7,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (8,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (9,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (10,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (11,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (12,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (13,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (14,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (15,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (16,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (17,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (18,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (19,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (20,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (21,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (22,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (23,'tom','aaaaaa','tom',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12345678910',NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (30,'aa',NULL,'aa',0,'','0','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1328593517546,0,NULL,NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (31,'bb',NULL,'bb',0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1328582665828,0,NULL,NULL,0,0,'成都市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (32,'cc',NULL,'cc',0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1328865224296,0,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (33,'11',NULL,'11',0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1328866530640,0,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (34,'请输入用户名',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1333950843312,0,NULL,NULL,0,0,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (36,'请输入账号名',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1332136628953,0,NULL,NULL,0,0,NULL,'D86DD12986B836CF1D98821301AB0E91',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (37,'Lily',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1331100607899,0,NULL,NULL,0,0,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (39,'中文',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1331612857406,0,NULL,NULL,0,0,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (40,'è¯·è¾å¥ç¨æ·å',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1331613412067,0,NULL,NULL,0,0,NULL,'C00900E1AB5D316FE9E2911C3A58CF8C',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `iz_user` VALUES (41,'ä¸­æ',NULL,NULL,0,NULL,'0',NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1331612651031,0,NULL,NULL,0,0,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `iz_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user_package
#

DROP TABLE IF EXISTS `iz_user_package`;
CREATE TABLE `iz_user_package` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `package_id` int(10) DEFAULT NULL COMMENT '套餐id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table iz_user_package
#

LOCK TABLES `iz_user_package` WRITE;
/*!40000 ALTER TABLE `iz_user_package` DISABLE KEYS */;
INSERT INTO `iz_user_package` VALUES (1,1,1);
INSERT INTO `iz_user_package` VALUES (2,1,2);
INSERT INTO `iz_user_package` VALUES (3,1,3);
INSERT INTO `iz_user_package` VALUES (4,1,4);
INSERT INTO `iz_user_package` VALUES (5,1,5);
/*!40000 ALTER TABLE `iz_user_package` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table iz_user_promote
#

DROP TABLE IF EXISTS `iz_user_promote`;
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

DROP TABLE IF EXISTS `iz_user_roles`;
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

DROP TABLE IF EXISTS `iz_user_user_role`;
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

DROP TABLE IF EXISTS `iz_useraddress`;
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

#
# Source for table news
#

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `publish_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Dumping data for table news
#

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (2,'涓浗','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (3,'sss','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (4,'涓浗','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (5,'涓浗','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (6,'鏂伴椈','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (7,'sss','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (8,'sss','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (9,'鏂伴椈','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (10,'鏂伴椈','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (11,'sss','ssssas','aaaa','sssss');
INSERT INTO `news` VALUES (12,'鏂伴椈','ssssas','aaaa','sssss');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
