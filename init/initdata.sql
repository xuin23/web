-- auth_user
insert into web.auth_user (username, password, realname, email)
values ('xuin23', 'E10ADC3949BA59ABBE56E057F20F883E', '徐礼健', 'xuin23@outlook.com');
--auth_role
insert into web.auth_role (name, status)
values ('admin', 'TRUE');
-- auth_user_role
insert into web.auth_user_role (role_id, user_id)
values (1, 1);