create table UserConnection (userId varchar(255),providerId varchar(255),providerUserId varchar(255),rank int,displayName varchar(255),profileUrl varchar(512),imageUrl varchar(512),accessToken varchar(512),secret varchar(512),refreshToken varchar(512),expireTime bigint,primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

insert into user(id, name, login, password) values (1,'Roy','roy@spring.com','spring');
insert into user(id, name, login, password) values (2,'Craig','craig@spring.com','spring');
insert into user(id, name, login, password) values (3,'Greg','greg@spring.com','spring');
 
insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');
insert into role(id, name) values (3,'ROLE_GUEST'); 

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);
