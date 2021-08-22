-- auth_user
insert into auth_user (id, password, username, email)
values ('xuin23', 'E10ADC3949BA59ABBE56E057F20F883E', '徐礼健', 'xuin23@outlook.com');
--auth_role
insert into auth_role (id, name)
values ('admin', '系统管理员');
-- auth_user_role
insert into auth_user_role (fk_role, fk_user)
values (1, 1);