
insert into users(username, password, enabled) VALUES ('Allen', 'password','true');
insert into users(username, password, enabled) VALUES ('Guess', 'password','true');
insert into users(username, password, enabled) VALUES ('User', 'password','true');
insert into users(username, password, enabled) VALUES ('Admin', 'password','true');

-- default proxy should be ROLE_
insert into authorities(username, authority) VALUES ('Allen', 'ROLE_ADMIN');
insert into authorities(username, authority) VALUES ('Guess', 'ROLE_GUESS');
insert into authorities(username, authority) VALUES ('Admin', 'ROLE_ADMIN');
insert into authorities(username, authority) VALUES ('User', 'ROLE_USER');