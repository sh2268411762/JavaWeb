drop
    database if exists servlet_blog; -- 如果存在先删除数据库

create
    database servlet_blog character set utf8mb4; -- 创建数据库


use servlet_blog;

-- 创建用户表
create table user
(
    id       int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(20),
    sex      bit,
    birthday date,
    head     varchar(50)
);

create table article
(
    id          int primary key auto_increment,
    title       varchar(20) not null,    -- 标题
    content     mediumtext  not null,    -- 内容
    create_time timestamp default now(), -- 创建时间
    view_count  int       default 0,
    user_id     int,                     -- 作者,外键关联
    foreign key (user_id) references user (id)
);


-- 插入数据
insert into user(username, password, birthday)
values ('admin', 'admin', '2000-08-08');

insert into user(username, password, birthday)
values ('abc', '123', '1999-01-01');

insert into user(username, password, birthday)
values ('a', '1', '1999-01-02');

insert into user(username, password, birthday)
values ('b', '2', '1999-01-03');

insert into user(username, password, birthday)
values ('c', '3', '1999-01-04');

-- 插入文章
insert into article(title, content, user_id)
values ('快速排序', '快牌', 1);

insert into article(title, content, user_id)
values ('冒泡排序', 'public ... ', 2);

insert into article(title, content, user_id)
values ('选择排序', 'public ... ', 2);

insert into article(title, content, user_id)
values ('归并排序', 'public ... ', 3);

insert into article(title, content, user_id)
values ('插入排序', 'public ... ', 3);


