create table user
(
  id     int auto_increment
  comment '主键id'
    primary key,
  openid varchar(255)    null
  comment 'openid',
  nick   varchar(100)    null
  comment '昵称',
  sex    int default '1' null
  comment '性别(1-男;2-女)',
  avatar varchar(255)    null
  comment '头像',
  role   int default '1' null
  comment '角色(1-用户;2-俱乐部会长;3-系统管理员)',
  status int default '1' null
  comment '状态(1-正常;-1-失效)'
)
  comment '后台用户表'
  engine = InnoDB
  CHARACTER SET utf8;

create table club
(
  id           int auto_increment
  comment '主键id'
    primary key,
  club_name    varchar(255)    null
  comment '名称',
  user_id      int             null
  comment '会长id',
  club_logo    varchar(255)    null
  comment '俱乐部logo',
  club_memo    varchar(2000)   null
  comment '俱乐部介绍',
  club_address varchar(255)    null
  comment '俱乐部地点',
  club_phone   varchar(20)     null
  comment '联系电话',
  status       int default '1' null
  comment '状态(1-正常;-1-失效)'
)
  comment '俱乐部表'
  engine = InnoDB
  CHARACTER SET utf8;

create table club_member
(
  id           int auto_increment
  comment '主键id'
    primary key,
  club_id      int             null
  comment '俱乐部id',
  user_id      int             null
  comment '成员id',
  member_level int             null
  comment '级别',
  status       int default '1' null
  comment '状态(1-正常;-1-失效)'
)
  comment '俱乐部成员表'
  engine = InnoDB
  CHARACTER SET utf8;

create table activity
(
  id               int auto_increment
  comment '主键id'
    primary key,
  club_id          int             null
  comment '俱乐部id',
  activity_date    varchar(20)     null
  comment '活动日期',
  start_time       varchar(30)     null
  comment '开始时间',
  end_time         varchar(30)     null
  comment '结束时间',
  limit_member     int default '0' null
  comment '限报人数',
  activity_address varchar(255)    null
  comment '活动场馆',
  activity_memo    varchar(1000)   null
  comment '活动说明',
  status           int default '1' null
  comment '状态(1-正常;-1-失效)'
)
  comment '活动表'
  engine = InnoDB
  CHARACTER SET utf8;

create table activity_apply_member
(
  id          int auto_increment
  comment '主键id'
    primary key,
  activity_id int             null
  comment '活动id',
  user_id     int             null
  comment '报名人员id',
  status      int default '1' null
  comment '状态'
)
  comment '活动报名表'
  engine = InnoDB
  CHARACTER SET utf8;