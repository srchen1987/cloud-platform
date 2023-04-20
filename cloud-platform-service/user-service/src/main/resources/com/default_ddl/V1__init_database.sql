 /*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/18 14:53:54                           */
/*==============================================================*/


drop table if exists shop_user;

drop table if exists shop_user_group;

drop table if exists shop_user_group_permission;

drop table if exists shop_permission;

drop table if exists shop_permission_group;



/*==============================================================*/
/* Table: shop_user                                             */
/*==============================================================*/
create table shop_user
(
   user_id              bigint not null auto_increment comment '用户ID',
   ug_id                bigint comment '用户组id',
   nick_name            varchar(32) comment '昵称',
   mobile               varchar(16) comment '手机号',
   password             varchar(256) comment '密码',
   secure_key           char(64) comment '密钥',
   user_head_path       varchar(64) comment '用户头像地址',
   add_time             bigint comment '创建时间',
   last_login_time      bigint comment '最后登录时间',
   login_time           int comment '登录次数',
   ip_address           varchar(16) comment 'ip地址',
   authentication       varchar(36) comment '身份码，最长期限30天',
   login_source         int comment '登录来源 1为qq,2为微信',
   real_name            varchar(16) comment '真实姓名',
   sex                  int comment '性别',
   birthday             bigint comment '生日',
   is_del               int default 0 comment '删除标志（0未删除，1已删除）',
   primary key (user_id)
)comment '用户表' charset = utf8mb4;

/*==============================================================*/
/* Table: shop_user_group                                        */
/*==============================================================*/
create table shop_user_group
(
   ug_id                bigint not null auto_increment comment '用户组id',
   ug_name              varchar(32) comment '用户组',
   ug_order             int comment '用户组排序',
   primary key (ug_id)
)comment '用户组' charset = utf8mb4;

/*==============================================================*/
/* Table: shop_usergroup_permission_model                       */
/*==============================================================*/
create table shop_user_group_permission
(
   ug_pm_id             bigint not null auto_increment comment '用户组权限模型id',
   perm_group_id        bigint comment '权限组id',
   ug_id                bigint comment '用户组id',
   perm_num             bigint comment '权限存储数字',
   primary key (ug_pm_id)
)comment '用户组权限表' charset = utf8mb4;

/*==============================================================*/
/* Table: shop_permission                                       */
/*==============================================================*/
create table shop_permission
(
   perm_id              bigint not null auto_increment comment '权限id',
   perm_group_id        bigint comment '权限组id',
   perm_name            varchar(32) comment '权限名称',
   perm_digit           int comment '权限位符,同权限组不允许重复',
   perm_desc            varchar(255) comment '权限描述',
   primary key (perm_id)
)comment '权限表' charset = utf8mb4;

/*==============================================================*/
/* Table: shop_permission_group                                 */
/*==============================================================*/
create table shop_permission_group
(
   perm_group_id        bigint not null auto_increment comment '权限组id',
   perm_group_name      varchar(32) comment '权限组名称',
   perm_group_desc      varchar(255) comment '权限组描述',
   primary key (perm_group_id)
)comment '权限组表' charset = utf8mb4;


CREATE UNIQUE INDEX uniq_perm_group_id_digit USING BTREE ON shop_permission (perm_group_id,perm_digit) ;
