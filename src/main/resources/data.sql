--This file is used to populate the database with some data when the application starts up
-- only for in memory databases like H2

insert into user_details (birth_date, id, name)
values (current_date(), 10001, 'Nico Fernandez');

insert into user_details (birth_date, id, name)
values (current_date(), 10002, 'Javi Fernandez');

insert into user_details (birth_date, id, name)
values (current_date(), 10003, 'Santi Fernandez');

insert into post (id, user_id, description)
values (101, 10001, 'First post from Nico');

insert into post (id, user_id, description)
values (102, 10001, 'Second post from Nico');

insert into post (id, user_id, description)
values (103, 10002, 'First post from Javi');