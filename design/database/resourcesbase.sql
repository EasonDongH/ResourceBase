/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - resourcesbase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`resourcesbase` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `resourcesbase`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT '0',
  `categoryName` varchar(100) DEFAULT NULL,
  `categoryDescription` varchar(255) DEFAULT NULL,
  `categoryIcon` varchar(100) DEFAULT NULL,
  `categoryOrder` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`pid`,`categoryName`,`categoryDescription`,`categoryIcon`,`categoryOrder`) values (1,0,'Java','Java语言','fa fa-coffee',1),(2,1,'Java基础',NULL,NULL,1),(3,1,'Java Core',NULL,NULL,1),(4,1,'多线程并发编程',NULL,NULL,1),(5,1,'Socket和IO',NULL,NULL,1),(6,1,'设计模式和反射',NULL,NULL,1),(7,1,'JVM',NULL,NULL,1),(8,1,'JavaWeb',NULL,NULL,1),(9,1,'Java框架',NULL,NULL,1),(10,0,'计算机科学',NULL,'fa fa-cubes',1),(11,10,'数据结构和算法',NULL,NULL,1),(12,10,'操作系统',NULL,NULL,1),(13,10,'数据库',NULL,NULL,1),(14,10,'计算机网络',NULL,NULL,1),(15,0,'其他技术',NULL,'fa-snowflake-o fa',1),(16,15,'消息服务',NULL,NULL,1),(17,15,'缓存服务',NULL,NULL,1),(18,15,'微服务',NULL,NULL,1),(19,15,'搜索引擎',NULL,NULL,1),(20,15,'权限框架',NULL,NULL,1),(21,15,'开发利器',NULL,NULL,1);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(100) DEFAULT NULL,
  `menuLevel` int(11) DEFAULT NULL,
  `menuUrl` varchar(255) DEFAULT NULL,
  `menuIcon` varchar(100) DEFAULT NULL,
  `menuOrder` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`menuName`,`menuLevel`,`menuUrl`,`menuIcon`,`menuOrder`) values (2,'关于本站',1,'/aboutSite','fa fa-info',1),(3,'文章归档',1,'/articleFile','fa-list-alt fa',2),(4,'申请友链',1,'/applyLink','fa fa-link',3),(5,'留言板',2,'/message','fa fa-comment',1);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeTitle` varchar(255) DEFAULT NULL,
  `noticeContent` text,
  `noticeCreateTime` datetime DEFAULT NULL,
  `noticeUpdateTime` datetime DEFAULT NULL,
  `noticeStatus` int(11) DEFAULT '0',
  `noticeOrder` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`noticeTitle`,`noticeContent`,`noticeCreateTime`,`noticeUpdateTime`,`noticeStatus`,`noticeOrder`) values (1,'本站下载地址','<p>本站后端基于 Spring+SpringMVC+Mybatis+JSP实现，对于初学SSM的小伙伴可以参考。</p><p><span>下载地址：</span><a target=\"_blank\" href=\"https://github.com/saysky/ForestBlog\">https://github.com/saysky/ForestBlog</a></p><p><br></p>','2020-01-01 18:58:27','2020-01-01 18:58:31',1,1),(2,'终于开始更新了','<p>距离上一次更新有一年了</p><p>最近抽时间更新一波</p><p><br></p><p><b>主要内容</b></p><p>1、去除 Custom 包</p><p>2、规范 MyBatis 语句</p><p>3、规范注释</p><p>4、删除不必要的字段</p><p>5、修改分类和标签关联关系</p><p>6、添加Redis，加快访问速度</p><p><br></p><p>下载地址：<a target=\"_blank\" href=\"https://github.com/saysky/ForestBlog\">https://github.com/saysky/ForestBlog</a></p><p>谢谢大家鼓励，帮忙点 star 和 fork 哦</p><p><br></p><p>更新时间：2019年11月25日</p>','2019-11-21 18:58:51','2020-01-01 18:59:02',1,2);

/*Table structure for table `options` */

DROP TABLE IF EXISTS `options`;

CREATE TABLE `options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `optionSiteTitle` varchar(100) DEFAULT NULL,
  `optionSiteDescrption` varchar(255) DEFAULT NULL,
  `optionMetaDescrption` varchar(255) DEFAULT NULL,
  `optionMetaKeyword` varchar(255) DEFAULT NULL,
  `siteAuthorName` varchar(100) DEFAULT NULL,
  `siteAuthorPhotoPath` varchar(255) DEFAULT NULL,
  `siteAuthorWechat` varchar(255) DEFAULT NULL,
  `siteAuthorQQ` varchar(255) DEFAULT NULL,
  `siteAuthorWeibo` varchar(255) DEFAULT NULL,
  `siteAuthorGitHub` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `options` */

insert  into `options`(`id`,`optionSiteTitle`,`optionSiteDescrption`,`optionMetaDescrption`,`optionMetaKeyword`,`siteAuthorName`,`siteAuthorPhotoPath`,`siteAuthorWechat`,`siteAuthorQQ`,`siteAuthorWeibo`,`siteAuthorGitHub`) values (1,'技术博客','在代码中漫步','技术博客,一个简洁的Java博客,程序学习的一个新起点。','技术博客,Java博客,SSM博客,学习博客,资源博客','EasonDongH','C:\\Users\\EasonDongH\\Desktop\\easondongh.png','','1035264115',NULL,'EasonDongH');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
