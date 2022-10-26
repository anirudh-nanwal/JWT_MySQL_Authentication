drop table if exists `jwt_auth`.`user`, `jwt_auth`.`role`, `jwt_auth`.`user_role`;

drop schema if exists `jwt_auth`;

create schema `jwt_auth`;

create table `jwt_auth`.`role`(
	`role_id` int not null primary key AUTO_INCREMENT,
    `role_name` varchar(25) not null,
    `role_description` varchar(100) not null
);
create table `jwt_auth`.`user`(
	`user_id` int not null primary key AUTO_INCREMENT,
	`user_name` varchar(100) not null,
    `user_first_name` varchar(100),
    `user_last_name` varchar(100),
    `user_password` varchar(100) not null
);

create table `jwt_auth`.`user_role` (
	`user_id` int not null,
    `role_id` int not null,
    foreign key (`user_id`) references `jwt_auth`.`user`(`user_id`),
    foreign key (`role_id`) references `jwt_auth`.`role`(`role_id`)
);