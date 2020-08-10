-- 初始化数据
-- auth_user
insert into web.auth_user (id, username, password, realname, email, status)
values (1, 'xuin23', 'E10ADC3949BA59ABBE56E057F20F883E', '徐礼健', 'xxxx@xxx.com', 'TRUE');
insert into web.auth_user (id, username, password, realname, email, status)
values (2, 'default', 'E10ADC3949BA59ABBE56E057F20F883E', '徐礼健', 'xxxx@xxx.com', 'TRUE');
--auth_role
insert into web.auth_role (id, name, status)
values (1, 'admin', 'TRUE');
insert into web.auth_role (id, name, status)
values (2, 'default', 'TRUE');
-- auth_user_role
insert into web.auth_user_role (id, role_id, user_id)
values (1, 1, 1);
insert into web.auth_user_role (id, role_id, user_id)
values (2, 2, 2);