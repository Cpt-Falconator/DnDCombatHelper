DROP TABLE combat;

create table combat (
id integer generated by default as identity, 
armor_class integer not null, 
health_points integer not null, 
initiative integer not null, 
player boolean not null, 
max_health_points integer not null, 
name varchar(255), 
primary key (id)
);

