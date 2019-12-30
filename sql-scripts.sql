drop schema if exists `e-business`;
create schema `e-business`;

create table `e-business`.`user`(
	`id` integer primary key auto_increment,
    `username` varchar(45) not null unique,
    `password` varchar(45) not null,
    `email` varchar(45) not null,
    `enabled` integer(1) not null
);
create table `e-business`.`item`(
	`id` integer primary key auto_increment,
    `name` varchar(45) not null unique,
    `description` varchar(45) not null,
    `image` varchar(45),
    `price` decimal(10, 2) not null
);
create table `e-business`.`order`(
	`id` integer primary key auto_increment,
    `state` varchar(10) not null,
     `user_id` integer,
     CONSTRAINT foreign key (`user_id`) references `e-business`.`user`(`id`)
     );
create table `e-business`.`order_entry`(
	`id` integer primary key auto_increment,
    `quantity` int,
    `amount` decimal(10, 2),
    `item_id` integer,
    `order_id` integer,
     CONSTRAINT foreign key (`item_id`) references `e-business`.`item`(`id`),
     CONSTRAINT foreign key (`order_id`) references `e-business`.`order`(`id`)
     );



