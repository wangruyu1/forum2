CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL,
  `menu_name` varchar(45) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(45) DEFAULT NULL COMMENT '菜单图标',
  `rooter` varchar(100) DEFAULT NULL COMMENT '菜单请求路径',
  `includes` varchar(100) DEFAULT NULL COMMENT '子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单id，-1表示根菜单。',
  `status` bigint(20) DEFAULT NULL COMMENT '-1=无效的菜单。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL,
  `menu_name` varchar(45) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(45) DEFAULT NULL COMMENT '菜单图标',
  `rooter` varchar(100) DEFAULT NULL COMMENT '菜单请求路径',
  `includes` varchar(100) DEFAULT NULL COMMENT '子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单id，-1表示根菜单。',
  `status` bigint(20) DEFAULT NULL COMMENT '-1=无效的菜单。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(45) DEFAULT NULL COMMENT '角色code',
  PRIMARY KEY (`id`),
  KEY `index_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_menu_map` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`),
  KEY `index_role_id` (`role_id`) USING BTREE,
  KEY `index_menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topic` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type1` int(11) NOT NULL COMMENT '一个分类,例如:数据库,开发语言.',
  `type2` int(11) DEFAULT NULL COMMENT '一个分类，例如:mysql,java。',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id,表示该帖子是由那个用户发起。',
  `title` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子标题.大小限制为300个字符。',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '帖子具体内容。',
  `score` int(11) DEFAULT NULL COMMENT '热度,表示帖子的受欢迎程度.可用于排序.',
  `hot_type` int(11) DEFAULT NULL COMMENT '表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。',
  `create_time` datetime NOT NULL COMMENT '帖子创建时间',
  `update_time` datetime NOT NULL COMMENT '楼主更新帖子时间。不代表回复更新时间。',
  `reply_count` int(11) DEFAULT NULL COMMENT '回复数量.',
  `status` int(11) NOT NULL COMMENT '1=可用,-1=删除',
  PRIMARY KEY (`id`),
  KEY `index_type1` (`type1`) USING BTREE,
  KEY `index_type2` (`type2`) USING BTREE,
  KEY `index_user_id` (`user_id`) USING BTREE,
  KEY `index_score` (`score`) USING BTREE,
  KEY `index_hot_type` (`hot_type`) USING BTREE,
  KEY `index_create_time` (`create_time`) USING BTREE,
  KEY `index_update_time` (`update_time`) USING BTREE,
  KEY `index_replay_count` (`reply_count`) USING BTREE,
  KEY `index_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topic_reply` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `topic_id` bigint(20) DEFAULT NULL COMMENT '帖子id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `reply_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `status` int(11) DEFAULT NULL COMMENT '-1=删除,1=有效.',
  `agree_count` int(11) DEFAULT NULL COMMENT '赞同人数，可用于排序。',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`) USING BTREE,
  KEY `index_topic_id` (`topic_id`) USING BTREE,
  KEY `index_reply_time` (`reply_time`) USING BTREE,
  KEY `index_status` (`status`) USING BTREE,
  KEY `index_agree_count` (`agree_count`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(20) NOT NULL COMMENT '论坛名字',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实名字',
  `email` varchar(320) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT '1' COMMENT '1=有效,2=无效,3=已删除',
  `qq` varchar(20) DEFAULT NULL COMMENT '绑定的qq号',
  `role` varchar(20) NOT NULL DEFAULT '' COMMENT '用户角色',
  `password` varchar(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_forum_name` (`forum_name`) USING BTREE,
  UNIQUE KEY `index_qq` (`qq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role_map` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
