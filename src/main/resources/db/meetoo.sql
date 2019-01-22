create table meetoo_user
(
  id            int auto_increment
  comment '主键id'
    primary key,
  openid        varchar(50)     null
  comment 'openid',
  nick          varchar(100)    null
  comment '昵称',
  sex           int default '0' null
  comment '性别(0-保密;1-男;2-女;)',
  avatar        varchar(255)    null
  comment '头像',
  constellation int default '0' null
  comment '星座(0-保密;1-12对应星座)',
  signature     varchar(200)    null
  comment '个性签名',
  status        int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time   varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo用户表'
  engine = InnoDB
  CHARACTER SET utf8mb4;

create table meetoo_group
(
  id          int auto_increment
  comment '主键id'
    primary key,
  user_id     int             null
  comment '创建人',
  group_name  varchar(50)     null
  comment '名称',
  tag         varchar(50)     null
  comment '标签',
  intro       varchar(200)    null
  comment '介绍',
  status      int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo圈子表'
  engine = InnoDB
  CHARACTER SET utf8mb4;

create table meetoo_group_member
(
  id          int auto_increment
  comment '主键id'
    primary key,
  user_id     int             null
  comment '成员',
  status      int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo圈子成员表'
  engine = InnoDB
  CHARACTER SET utf8mb4;

create table meetoo_moment
(
  id          int auto_increment
  comment '主键id'
    primary key,
  user_id     int             null
  comment '用户',
  emotion     varchar(200)    null
  comment '动态',
  address     varchar(50)     null
  comment '位置',
  status      int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo动态表'
  engine = InnoDB
  CHARACTER SET utf8mb4;

create table meetoo_moment_pic
(
  id          int auto_increment
  comment '主键id'
    primary key,
  moment_id   int             null
  comment '动态',
  url         varchar(200)    null
  comment 'url',
  status      int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo动态配图表'
  engine = InnoDB
  CHARACTER SET utf8mb4;

create table meetoo_moment_mark
(
  id          int auto_increment
  comment '主键id'
    primary key,
  moment_id   int             null
  comment '动态',
  user_id     int             null
  comment '用户',
  status      int default '1' null
  comment '状态(1-正常;-1-失效)',
  create_time varchar(50)     null
  comment '创建时间'
)
  comment 'meetoo动态点赞表'
  engine = InnoDB
  CHARACTER SET utf8mb4;