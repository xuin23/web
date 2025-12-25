-- 主表结构定义
create table if not exists workitem
(
    id         SERIAL primary key,
    type       varchar(50),
    name       varchar(255),
    text_value text,
    status     varchar(50),
    priority   varchar(20),
    author     varchar(50),
    deleted    boolean   default false,
    created    timestamp default now(),
    updated    timestamp default now()
);


CREATE TABLE users
(
    id                     SERIAL PRIMARY KEY,
    login_name             VARCHAR(255) NOT NULL,
    name                   VARCHAR(255),
    label                  VARCHAR(255),
    email                  VARCHAR(255),
    description            TEXT,
    initials               VARCHAR(10),
    disabled               BOOLEAN DEFAULT FALSE,
    home_page_content      TEXT
);
