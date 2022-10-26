drop table if exists `jwt_auth`.`user`, `jwt_auth`.`role`, `jwt_auth`.`user_role`;

drop schema if exists `jwt_auth`;

create schema `jwt_auth`;

create table `jwt_auth`.`role`(
    `role_name` varchar(25) not null primary key,
    `role_description` varchar(100) not null
);
create table `jwt_auth`.`user`(
	`user_name` varchar(100) not null primary key,
    `user_first_name` varchar(100),
    `user_last_name` varchar(100),
    `user_password` varchar(100) not null
);

create table `jwt_auth`.`user_role` (
	`user_name` int not null,
    `role_name` int not null,
    foreign key (`user_name`) references `jwt_auth`.`user`(`user_name`),
    foreign key (`role_name`) references `jwt_auth`.`role`(`role_name`)
);