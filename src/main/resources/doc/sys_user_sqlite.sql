DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL ,
  `name` varchar(50) DEFAULT NULL ,
  `age` int(3) DEFAULT NULL ,
  `type` tinyint(1) DEFAULT '0',
  `ctime` datetime DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `sys_user` VALUES ('784972358981328902', 'Tom', '24', '2017-06-25 20:53:33', '1');
INSERT INTO `sys_user` VALUES ('784972358981328903', 'Jammy', '21', '2017-06-25 20:53:37', '1');