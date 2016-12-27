/*==============================================================*/
/*
CREATE DATABASE schoolpal DEFAULT CHARACTER SET UTF8;

#GRANT ALL ON schoolpal.* TO schoolpal@'%' IDENTIFIED BY 'schoolpal';
CREATE USER schoolpal@'%' IDENTIFIED BY 'schoolpal';
*/
#USE schoolpal;
/*==============================================================*/

/*==============================================================*/
/*
    Event: e_update_index
    每日切换序号前缀。提前生成前缀以便于组织序号的时候减少计算量。
*/
/*==============================================================*/
DROP EVENT IF EXISTS e_update_index;
DELIMITER $$
CREATE EVENT e_update_index
ON SCHEDULE EVERY 1 DAY STARTS TIMESTAMP '2016-01-01 00:00:00'
DO
BEGIN
    UPDATE t_index SET c_current = 0, c_prefix = DATE_FORMAT(now(), '%y%m%d');
END $$
DELIMITER ;

/*==============================================================*/
/*
    Function: f_current_id
    获取表的当前序号值。
*/
/*==============================================================*/
DROP FUNCTION if exists f_current_id;
DELIMITER $$
CREATE FUNCTION f_current_id(tableName VARCHAR(50))
    RETURNS VARCHAR(50)
BEGIN
    DECLARE cPrefix VARCHAR(50);
    DECLARE cCurrent INT;
    DECLARE cBits TINYINT;

    SELECT
        c_prefix, c_current, c_bits
        INTO
        cPrefix, cCurrent, cBits
    FROM
        t_index
    WHERE
        c_table = tableName;

    RETURN CONCAT(cPrefix, LPAD(CONCAT(cCurrent, ''), cBits, '0'));
END $$
DELIMITER ;

/*==============================================================*/
/*
    Function: f_next_id
    获取表的下一个序号值。
*/
/*==============================================================*/
DROP FUNCTION if exists f_next_id;
DELIMITER $$
CREATE FUNCTION f_next_id(tableName VARCHAR(50))
    RETURNS VARCHAR(50)
BEGIN
    UPDATE t_index
    SET c_current = c_current + c_step
    WHERE c_table = tableName;

    RETURN f_current_id(tableName);

END $$
DELIMITER ;

/*==============================================================*/
/*
    Table: t_index
    序号表；记录生成序号的要素信息。
*/
/*==============================================================*/
drop table if exists t_index;
create table t_index
(
   c_table              varchar(50),
   c_prefix             varchar(50),
   c_current            bigint,
   c_step               int,
   c_bits               tinyint,
   primary key (c_table)
);

/*==============================================================*/
/*
    Table: t_org
    机构表。
*/
/*==============================================================*/
drop table if exists t_org;
create table t_org
(
   c_id                 varchar(50) not null,
   c_code               varchar(50) not null,
   c_name_cn            varchar(50),
   c_name_cn_abbr       varchar(50),
   c_name_en            varchar(50),
   c_name_en_abbr       varchar(50),
   c_province           varchar(50),
   c_city               varchar(50),
   c_county             varchar(50),
   c_address            varchar(512),
   c_owner              varchar(50),
   c_owner_phone        varchar(50),
   c_parent_id          varchar(50),
   c_root_id            varchar(50),
   c_creator            varchar(50),
   c_create_time        datetime,
   c_modifier           varchar(50),
   c_modify_time        datetime,
   c_available          bool,
   c_order_num          int,
   primary key (c_code)
);

/*==============================================================*/
/*
    Table: t_user
    用户表。
*/
/*==============================================================*/
drop table if exists t_user;
create table t_user
(
   c_id                 varchar(50) not null,
   c_username           varchar(50) not null,
   c_password           varchar(50),
   c_name               varchar(50),
   c_name_en            varchar(50),
   c_phone              varchar(50),
   c_email              varchar(50),
   c_qq                 varchar(50),
   c_available          bool,
   c_org_id             varchar(50),
   c_org_root_id        varchar(50),
   c_creator            varchar(50),
   c_create_time        datetime,
   c_last_visit_time    datetime,
   c_last_visit_ip      varchar(50),
   primary key (c_username)
);

/*==============================================================*/
/*
    Table: t_rank
    职级表。经理/主管/专员/系统管理员。
*/
/*==============================================================*/
drop table if exists t_rank;
create table t_rank
(
   c_id                 int not null auto_increment,
   c_name               varchar(50),
   c_order_num          int,
   primary key (c_id)
);

/*==============================================================*/
/*
    Table: t_role
    角色表。
*/
/*==============================================================*/
drop table if exists t_role;
create table t_role
(
   c_id                 varchar(50) not null,
   c_org_id             varchar(50),
   c_creator            varchar(50),
   c_create_time        datetime,
   c_name               varchar(50),
   c_desc               varchar(1024),
   c_available          bool,
   c_order_num          int,
   c_rank_id            int,
   primary key (c_id)
);

/*==============================================================*/
/*
    Table: t_user_role
    用户角色表。
*/
/*==============================================================*/
drop table if exists t_user_role;
create table t_user_role
(
   c_id                 varchar(50) not null,
   c_org_id             varchar(50),
   c_user_id            varchar(50),
   c_role_id            varchar(50),
   c_available          bool,
   c_creator            varchar(50),
   c_create_time        datetime,
   primary key (c_id)
);

/*==============================================================*/
/*
    Table: t_widget_type
    控件类型。
*/
/*==============================================================*/
drop table if exists t_widget_type;
create table t_widget_type
(
   c_id                 int not null auto_increment,
   c_name               varchar(50),
   primary key (c_id)
);

/*==============================================================*/
/*
    Table: t_function
    职能表。
*/
/*==============================================================*/
drop table if exists t_function;
create table t_function
(
   c_id                 varchar(50) not null,
   c_root_id            varchar(50),
   c_parent_id          varchar(50),
   c_name_short         varchar(50),
   c_name_long          varchar(50),
   c_action             varchar(512),
   c_widget_type_id     int,
   c_order_num          int,
   c_icon               varchar(50),
   primary key (c_id)
);

/*==============================================================*/
/*
    Table: t_role_function
    角色职能。
*/
/*==============================================================*/
drop table if exists t_role_function;
create table t_role_function
(
   c_role_id            varchar(50),
   c_function_root_id        varchar(50),
   c_order_num          int,
   index (c_role_id)
);

/*==============================================================*/
/*
    Table: t_role_function_exclude
    角色禁用职能。
*/
/*==============================================================*/
drop table if exists t_role_function_exclude;
create table t_role_function_exclude
(
   c_role_id            varchar(50),
   c_function_id        varchar(50),
   c_creator            varchar(50),
   c_create_time        varchar(50),
   index (c_role_id)
);

/*==============================================================*/
/*
    Table: t_role_function_exclude
    角色禁用职能。
*/
/*==============================================================*/
drop table if exists t_log;
create table t_log
(
    c_id                 varchar(50),
    c_creator            varchar(50),
    c_create_time        datetime,
    c_type               varchar(50),
    c_title              varchar(50),
    c_desc               varchar(2048),
    c_debug              text,
    c_service_ip         varchar(50),
    c_user_ip            varchar(50),
   primary key (c_id)
);


/*==============================================================*/
/*
    初始化数据索引数据。
*/
/*==============================================================*/

/*
    索引基础数据。
*/
insert into t_index(c_table, c_prefix, c_current, c_step, c_bits)
values('t_org', DATE_FORMAT(now(), '%y%m%d'), 0, 1, 8);
insert into t_index(c_table, c_prefix, c_current, c_step, c_bits)
values('t_user', DATE_FORMAT(now(), '%y%m%d'), 0, 1, 8);
insert into t_index(c_table, c_prefix, c_current, c_step, c_bits)
values('t_role', DATE_FORMAT(now(), '%y%m%d'), 0, 1, 8);
insert into t_index(c_table, c_prefix, c_current, c_step, c_bits)
values('t_user_role', DATE_FORMAT(now(), '%y%m%d'), 0, 1, 8);
insert into t_index(c_table, c_prefix, c_current, c_step, c_bits)
values('t_log', DATE_FORMAT(now(), '%y%m%d'), 0, 1, 15);

/*
    职级基础数据。
*/
insert into t_rank(c_id, c_name, c_order_num) values(1, '经理', 1);
insert into t_rank(c_id, c_name, c_order_num) values(2, '主管', 2);
insert into t_rank(c_id, c_name, c_order_num) values(3, '专员', 3);
insert into t_rank(c_id, c_name, c_order_num) values(4, '系统管理员', 4);

/*
    控件类型基础数据。
*/
insert into t_widget_type(c_id, c_name) values(1, 'Menu');
insert into t_widget_type(c_id, c_name) values(2, 'MenuItem');
insert into t_widget_type(c_id, c_name) values(3, 'LinkButton');
insert into t_widget_type(c_id, c_name) values(4, 'CommandButton');

/*
    职能型基础数据。
*/
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('1', '1', '1', '市场', '市场管理', '/market', 1, 1, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('2', '2', '2', '销售', '销售管理', '/sales', 1, 2, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('3', '3', '3', '客服', '客户服务', '/service', 1, 3, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('4', '4', '4', '财务', '财务管理', '/finance', 1, 4, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('5', '5', '5', '教务', '教务管理', '/academy', 1, 5, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('6', '6', '6', '教学', '教学管理', '/education', 1, 6, '');
insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
values('7', '7', '7', '系统', '系统管理', '/config', 1, 7, 'glyphicon glyphicon-cog');
    insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
    values('7-1', '7', '7', '', '组织管理', '/config/org.html', 2, 1, 'glyphicon glyphicon-home');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-1-1', '7', '7-1', '', '新建', '/config/org/new.html', 3, 1, 'glyphicon glyphicon-plus');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-1-2', '7', '7-1', '', '编辑', '/config/org/edit.html', 4, 2, 'glyphicon glyphicon-edit');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-1-3', '7', '7-1', '', '删除', '/config/org/remove.do', 4, 3, 'glyphicon glyphicon-remove');
    insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
    values('7-2', '7', '7', '', '角色管理', '/config/role.html', 2, 2, 'glyphicon glyphicon-education');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-2-1', '7', '7-2', '', '新建', '/config/role/new.html', 4, 1, 'glyphicon glyphicon-plus');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-2-2', '7', '7-2', '', '编辑', '/config/role/edit.html', 4, 2, 'glyphicon glyphicon-edit');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-2-3', '7', '7-2', '', '删除', '/config/role/remove.do', 4, 3, 'glyphicon glyphicon-remove');
    insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
    values('7-3', '7', '7', '', '权限管理', '/config/auth.html', 2, 3, 'glyphicon glyphicon-king');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-3-1', '7', '7-3', '', '授权', '/config/auth/apply.html', 4, 1, 'glyphicon glyphicon-pawn');
    insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
    values('7-4', '7', '7', '', '用户管理', '/config/user.html', 2, 4, 'glyphicon glyphicon-user');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-4-1', '7', '7-4', '', '新建', '/config/user/new.html', 4, 1, 'glyphicon glyphicon-plus');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-4-2', '7', '7-4', '', '编辑', '/config/user/edit.html', 4, 2, 'glyphicon glyphicon-edit');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-4-3', '7', '7-4', '', '删除', '/config/user/remove.html', 4, 3, 'glyphicon glyphicon-remove');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-4-4', '7', '7-4', '', '启用', '/config/user/enable.html', 4, 4, 'glyphicon glyphicon-ok-circle');
        insert into t_function(c_id, c_root_id, c_parent_id, c_name_short, c_name_long, c_action, c_widget_type_id, c_order_num, c_icon)
        values('7-4-5', '7', '7-4', '', '停用', '/config/user/disable.html', 4, 5, 'glyphicon glyphicon-ban-circle');

/*
    初始化超级管理员。
*/
insert into t_org(c_id, c_code, c_name_cn, c_name_cn_abbr, c_name_en, c_name_en_abbr, c_province, c_city, c_county, c_address,
    c_owner, c_owner_phone, c_parent_id, c_root_id, c_creator, c_create_time, c_modifier, c_modify_time, c_available, c_order_num)
values('16010100000001', 'sp', '校客科技', '校客', 'SchoolPal IT', 'SchoolPal', '直辖市', '北京', '海淀区', '上地软件园1号',
    '曹磊', '13666666666', '16010100000001', '16010100000001', '16010100000001', now(), null, null, 1, 1);

insert into t_user(c_id, c_username, c_password, c_name, c_name_en, c_phone, c_email, c_qq,
    c_available, c_org_id, c_org_root_id, c_creator, c_create_time, c_last_visit_time, c_last_visit_ip)
values('16010100000001', 'sp-admin', '14e1b600b1fd579f47433b88e8d85291', '校客管理员', 'SchoolPal Admin', '13600000000', 'sp-admin@schoolpal.com', '6666666',
    1, '16010100000001', '16010100000001', '16010100000001', now(), null, null);

insert into t_role(c_id, c_org_id, c_creator, c_create_time, c_name, c_desc, c_available, c_order_num, c_rank_id)
values('16010100000001', '16010100000001', '16010100000001', now(), '系统管理员', '系统超级管理员', 1, 1, 4);

insert into t_user_role(c_id, c_org_id, c_user_id, c_role_id, c_available, c_creator, c_create_time)
values('16010100000001', '16010100000001', '16010100000001', '16010100000001', 1, '16010100000001', now());

insert into t_role_function(c_role_id, c_function_root_id, c_order_num)
values('16010100000001', '7', 1);
