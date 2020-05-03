create table `china_bank` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user` VARCHAR(50) not null COMMENT '用户名',
    `acount` int(11) not null COMMENT '账户余额',
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

create table `usa_bank` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user` VARCHAR(50) not null COMMENT '用户名',
    `acount` int(11) not null COMMENT '账户余额',
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;