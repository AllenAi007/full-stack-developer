-- basic tables starts
create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
-- basic tables ends

-- for group authorization starts
create table groups (
	id int not null auto_increment primary key,
	group_name varchar(50) not null
);

create table group_authorities (
	group_id int not null,
	authority varchar(50) not null,
	constraint fk_group_authorities_group foreign key(group_id) references groups(id)
);

create table group_members (
	id int not null auto_increment primary key,
	username varchar(50) not null,
	group_id int not null,
	constraint fk_group_members_group foreign key(group_id) references groups(id)
);
-- for group authorization ends

-- persistent login starts
create table persistent_logins (
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
);
-- persistent login ends