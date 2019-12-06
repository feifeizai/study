CREATE table t_user(
	user_id int(11) auto_increment comment '主键id',
	user_name VARCHAR(50) not null comment '用户名',
	password varchar(20) not null comment '密码',
	PRIMARY key (user_id)
)ENGINE INNODB auto_increment 1 charset utf8;

CREATE table t_role(
	role_id int(11) auto_increment comment '主键id',
	role_name VARCHAR(50) not null comment '角色名',
	PRIMARY key (role_id)
)ENGINE INNODB auto_increment 1 charset utf8;

CREATE table t_permission(
	permission_id int(11) auto_increment comment '主键id',
	permission_name VARCHAR(50) not null comment '权限名',
	PRIMARY key (permission_id)
)ENGINE INNODB auto_increment 1 charset utf8;

create table user_role(
	user_id int(11) not null comment '用户id',
	role_id int(11) not null comment '角色id'
)charset utf8 ENGINE INNODB;

create table role_permission(
	role_id int(11) not null comment '角色id',
	permission_id int(11) not null comment '权限id'
)charset utf8 ENGINE INNODB;

alter table user_role add FOREIGN key(user_id) REFERENCES t_user(user_id);
alter table user_role add FOREIGN key(role_id) REFERENCES t_role(role_id);
alter table role_permission add FOREIGN key(role_id) REFERENCES t_role(role_id);
alter table role_permission add FOREIGN key(permission_id) REFERENCES t_permission(permission_id);

INSERT INTO `t_user` VALUES (1, '张三', '333');
INSERT INTO `t_user` VALUES (2, '李四', '444');
INSERT INTO `t_user` VALUES (3, '王五', '555');

INSERT INTO `t_role` VALUES (1, '员工');
INSERT INTO `t_role` VALUES (2, '组长');
INSERT INTO `t_role` VALUES (3, '经理');

INSERT INTO `t_permission` VALUES (1, '查询');
INSERT INTO `t_permission` VALUES (2, '新增');
INSERT INTO `t_permission` VALUES (3, '修改');
INSERT INTO `t_permission` VALUES (4, '删除');

INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 3);

INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (2, 1);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (3, 1);
INSERT INTO `role_permission` VALUES (3, 2);
INSERT INTO `role_permission` VALUES (3, 3);
INSERT INTO `role_permission` VALUES (3, 4);

