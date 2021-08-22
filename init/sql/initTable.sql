-- 用户表
create table IF NOT EXISTS AUTH_USER
(
    PK          serial      not null primary key,
    ID          varchar(50) not null unique,
    USERNAME    varchar(50) default null,
    PASSWORD    varchar(50) default null,
    EMAIL       varchar(50) not null unique,
    VERSION     integer     default 0,
    STATUS      boolean     default true,
    UPDATE_TIME timestamp   default now(),
    CREATE_TIME timestamp   default now()
);

comment on table AUTH_USER is '用户表';
comment on column AUTH_USER.PK is '主键';
comment on column AUTH_USER.ID is '用户ID';
comment on column AUTH_USER.USERNAME is '角色名';
comment on column AUTH_USER.PASSWORD is '密码';
comment on column AUTH_USER.EMAIL is '邮箱';
comment on column AUTH_USER.STATUS is '状态';
comment on column AUTH_USER.UPDATE_TIME is '更新日期';
comment on column AUTH_USER.CREATE_TIME is '创建日期';

-- 角色表
CREATE TABLE IF NOT EXISTS AUTH_ROLE
(
    PK          serial      not null primary key,
    ID          varchar(50) not null unique,
    NAME        VARCHAR(50) not null,
    VERSION     integer   default 0,
    STATUS      boolean   default true,
    UPDATE_TIME timestamp default now(),
    CREATE_TIME timestamp default now()
);
comment on table AUTH_ROLE is '角色表';
comment on column AUTH_ROLE.PK is '角色ID';
comment on column AUTH_ROLE.NAME is '角色名';
comment on column AUTH_ROLE.STATUS is '状态';
comment on column AUTH_ROLE.UPDATE_TIME is '更新日期';
comment on column AUTH_ROLE.CREATE_TIME is '创建日期';


-- 用户角色关联表
CREATE TABLE IF NOT EXISTS AUTH_USER_ROLE
(
    PK          serial not null primary key,
    FK_ROLE     bigint NOT NULL,
    FK_USER     bigint NOT NULL,
    VERSION     bigint    default 0,
    STATUS      boolean   default true,
    UPDATE_TIME timestamp DEFAULT NOW(),
    CREATE_TIME timestamp DEFAULT NOW()
);
comment on table AUTH_USER_ROLE is '用户角色关联表';
comment on column AUTH_USER_ROLE.FK_ROLE is '角色ID';
comment on column AUTH_USER_ROLE.FK_USER is '用户ID';
comment on column AUTH_USER_ROLE.CREATE_TIME is '创建日期';

--
-- -- 权限操作关联表
-- CREATE TABLE IF NOT EXISTS AUTH_OPERATION_AUTHORITY
-- (
--     PK           serial  not null primary key,
--     OPERATION_ID bigint NOT NULL,
--     AUTHORITY_ID bigint NOT NULL,
--     VERSION      bigint   default 0,
--     STATUS       boolean   default true,
--     UPDATE_TIME  timestamp DEFAULT NOW(),
--     CREATE_TIME  timestamp DEFAULT NOW()
-- );
-- comment on table AUTH_OPERATION_AUTHORITY is '权限操作关联表';
-- comment on column AUTH_OPERATION_AUTHORITY.OPERATION_ID is '功能ID';
-- comment on column AUTH_OPERATION_AUTHORITY.AUTHORITY_ID is '权限ID';
-- comment on column AUTH_OPERATION_AUTHORITY.CREATE_TIME is '创建日期';
--
-- -- 权限菜单关联表
-- CREATE TABLE IF NOT EXISTS AUTH_MENU_AUTHORITY
-- (
--     PK           serial  not null primary key,
--     AUTHORITY_ID bigint NOT NULL,
--     MENU_ID      bigint NOT NULL,
--     VERSION      bigint   default 0,
--     STATUS       boolean   default true,
--     UPDATE_TIME  timestamp DEFAULT NOW(),
--     CREATE_TIME  timestamp DEFAULT NOW()
-- );
-- comment on table AUTH_MENU_AUTHORITY is '权限菜单关联表';
-- comment on column AUTH_MENU_AUTHORITY.AUTHORITY_ID is '权限ID';
-- comment on column AUTH_MENU_AUTHORITY.MENU_ID is '菜单ID';
-- comment on column AUTH_MENU_AUTHORITY.CREATE_TIME is '创建日期';
--
--
--
-- -- 用户组表
-- CREATE TABLE IF NOT EXISTS AUTH_GROUP
-- (
--     PK          serial not null primary key,
--     NAME        VARCHAR(50) default NULL,
--     pid         VARCHAR(50) default NULL,
--     VERSION     bigint     default 0,
--     STATUS      boolean     default true,
--     UPDATE_TIME timestamp   DEFAULT NOW(),
--     CREATE_TIME timestamp   DEFAULT NOW()
-- );
-- comment on table AUTH_GROUP is '用户组表';
-- comment on column AUTH_GROUP.PK is '用户组ID';
-- comment on column AUTH_GROUP.NAME is '用户组名';
-- comment on column AUTH_GROUP.pid is '父用户组ID';
-- comment on column AUTH_GROUP.STATUS is '状态';
-- comment on column AUTH_GROUP.UPDATE_TIME is '更新日期';
-- comment on column AUTH_GROUP.CREATE_TIME is '创建日期';
--
--
-- -- 权限表
-- CREATE TABLE IF NOT EXISTS AUTHORITY
-- (
--     PK          serial not null primary key,
--     NAME        VARCHAR(50) default NULL,
--     VERSION     bigint     default 0,
--     STATUS      bool        default true,
--     UPDATE_TIME timestamp   DEFAULT NOW(),
--     CREATE_TIME timestamp   DEFAULT NOW()
-- );
-- comment on table AUTHORITY is '权限表';
-- comment on column AUTHORITY.PK is '权限ID';
-- comment on column AUTHORITY.NAME is '权限类型';
-- comment on column AUTHORITY.STATUS is '状态';
-- comment on column AUTHORITY.UPDATE_TIME is '更新日期';
-- comment on column AUTHORITY.CREATE_TIME is '创建日期';
--
-- -- 功能操作
-- CREATE TABLE IF NOT EXISTS AUTH_OPERATION
-- (
--     PK          serial not null primary key,
--     NAME        VARCHAR(50) default null,
--     VERSION     bigint     default 0,
--     STATUS      boolean     default true,
--     UPDATE_TIME timestamp   DEFAULT NOW(),
--     CREATE_TIME timestamp   DEFAULT NOW()
-- );
-- comment on table AUTH_OPERATION is '功能操作';
-- comment on column AUTH_OPERATION.PK is '功能ID';
-- comment on column AUTH_OPERATION.NAME is '功能名称';
-- comment on column AUTH_OPERATION.STATUS is '状态';
-- comment on column AUTH_OPERATION.UPDATE_TIME is '更新日期';
-- comment on column AUTH_OPERATION.CREATE_TIME is '创建日期';
--
-- -- 菜单表
-- CREATE TABLE IF NOT EXISTS AUTH_MENU
-- (
--     PK          serial not null primary key,
--     NAME        VARCHAR(50)  default NULL,
--     URL         VARCHAR(100) default NULL,
--     PID         bigint      DEFAULT 0,
--     VERSION     bigint      default 0,
--     STATUS      boolean      default true,
--     UPDATE_TIME timestamp    DEFAULT NOW(),
--     CREATE_TIME timestamp    DEFAULT NOW()
-- );
-- comment on table AUTH_MENU is '菜单表';
-- comment on column AUTH_MENU.PK is '菜单ID';
-- comment on column AUTH_MENU.NAME is '菜单名';
-- comment on column AUTH_MENU.URL is '地址';
-- comment on column AUTH_MENU.PID is '父节点ID';
-- comment on column AUTH_MENU.STATUS is '状态';
-- comment on column AUTH_MENU.UPDATE_TIME is '更新日期';
-- comment on column AUTH_MENU.CREATE_TIME is '创建日期';
--
-- -- 用户组与用户关联表
-- CREATE TABLE IF NOT EXISTS AUTH_USER_GROUP
-- (
--     PK          serial  not null primary key,
--     USER_ID     bigint NOT NULL,
--     GROUP_ID    bigint NOT NULL,
--     VERSION     bigint   default 0,
--     STATUS      boolean   default true,
--     UPDATE_TIME timestamp DEFAULT NOW(),
--     CREATE_TIME timestamp DEFAULT NOW()
-- );
-- comment on table AUTH_USER_GROUP is '用户组与用户关联表';
-- comment on column AUTH_USER_GROUP.USER_ID is '用户ID';
-- comment on column AUTH_USER_GROUP.GROUP_ID is '用户组ID';
-- comment on column AUTH_USER_GROUP.CREATE_TIME is '创建日期';
--
-- -- 用户组与角色关联表
-- CREATE TABLE IF NOT EXISTS AUTH_ROLE_GROUP
-- (
--     PK          serial  not null primary key,
--     ROLE_ID     bigint NOT NULL,
--     GROUP_ID    bigint NOT NULL,
--     VERSION     bigint   default 0,
--     STATUS      boolean   default true,
--     UPDATE_TIME timestamp DEFAULT NOW(),
--     CREATE_TIME timestamp DEFAULT NOW()
-- );
-- comment on table AUTH_ROLE_GROUP is '用户组与角色关联表';
-- comment on column AUTH_ROLE_GROUP.ROLE_ID is '角色ID';
-- comment on column AUTH_ROLE_GROUP.GROUP_ID is '用户组ID';
-- comment on column AUTH_ROLE_GROUP.CREATE_TIME is '创建日期';
--
--
-- -- 角色权限关联表
-- CREATE TABLE IF NOT EXISTS AUTH_ROLE_AUTHORITY
-- (
--     PK           serial  not null primary key,
--     ROLE_ID      bigint NOT NULL,
--     AUTHORITY_ID bigint NOT NULL,
--     VERSION      bigint   default 0,
--     STATUS       boolean   default true,
--     UPDATE_TIME  timestamp DEFAULT NOW(),
--     CREATE_TIME  timestamp DEFAULT NOW()
-- );
-- comment on table AUTH_ROLE_AUTHORITY is '角色权限关联表';
-- comment on column AUTH_ROLE_AUTHORITY.ROLE_ID is '角色ID';
-- comment on column AUTH_ROLE_AUTHORITY.AUTHORITY_ID is '权限ID';
-- comment on column AUTH_ROLE_AUTHORITY.CREATE_TIME is '创建日期';