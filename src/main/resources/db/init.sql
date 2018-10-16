-- we don't know how to generate schema badminton (class Schema) :(
create table activity
(
  id int auto_increment comment '主键id'
    primary key,
  club_id int null comment '俱乐部id',
  activity_date varchar(20) null comment '活动日期',
  start_time varchar(30) null comment '活动开始时间',
  end_time varchar(30) null comment '活动结束时间',
  limit_member int default '0' null comment '活动限报人数',
  activity_address varchar(255) null comment '活动场馆',
  activity_memo varchar(1000) null comment '活动说明',
  status int default '1' null comment '状态'
)
  comment '活动表' engine=InnoDB
;

create table activity_member
(
  id int auto_increment comment '主键id'
    primary key,
  activity_id int null comment '活动id',
  nick varchar(100) null comment '报名人员昵称',
  member_num int null comment '报名人数',
  member_sex int default '1' null comment '性别',
  member_phone bigint null comment '联系电话',
  status int default '1' null comment '状态'
)
  comment '活动成员表' engine=InnoDB
;

create table club
(
  id int auto_increment comment '主键id'
    primary key,
  club_name varchar(255) null comment '名称',
  club_user_id int null comment '拥有者id',
  club_logo varchar(255) null comment '俱乐部logo',
  club_memo varchar(2000) null comment '俱乐部介绍',
  club_address varchar(255) null comment '俱乐部地点',
  club_qq_group varchar(100) null comment '俱乐部QQ群',
  status int default '1' null comment '状态'
)
  comment '俱乐部表' engine=InnoDB
;

create table `match`
(
  match_name varchar(100) null comment '比赛名称',
  club_id int null comment '俱乐部id',
  men_single int default '1' null comment '男单',
  women_single int default '1' null comment '女单',
  men_double int default '1' null comment '男双',
  women_double int default '1' null comment '女双',
  max_double int default '1' null comment '混双',
  limit_member int default '0' null comment '限报人数',
  match_memo varchar(1000) null comment '比赛说明',
  start_time varchar(30) null comment '比赛开始时间',
  end_time varchar(30) null comment '比赛结束时间',
  status int default '1' null comment '状态'
)
  comment '比赛表' engine=InnoDB
;

create table match_member
(
  id int auto_increment comment '主键id'
    primary key,
  match_id int null comment '比赛id',
  match_type int null comment '类型：1-男单；2-女单；3-男双；4-女双；5-混双',
  match_judge varchar(100) null comment '裁判',
  against_member varchar(100) null comment '对阵方',
  against_sort int null comment '比赛排序',
  winner varchar(10) null comment '获胜方',
  match_point1 varchar(50) null comment '第一场',
  match_point2 varchar(50) null comment '第二场',
  match_point3 varchar(50) null comment '第三场',
  status int default '1' null comment '状态'
)
  comment '比赛人员安排表' engine=InnoDB
;

create table user
(
  id int auto_increment comment '主键id'
    primary key,
  account varchar(50) null comment '账号',
  nick varchar(100) null comment '昵称',
  sex int default '0' null comment '性别(0-未知;1-男;2-女)',
  phone bigint null comment '手机号',
  avatar varchar(255) null comment '头像',
  pwd varchar(50) null comment '秘钥',
  role int default '0' null comment '角色(0-用户;1-系统管理员)',
  status int default '1' null comment '状态(1-正常;-1-失效)'
)
  comment '后台用户表' engine=InnoDB
;

