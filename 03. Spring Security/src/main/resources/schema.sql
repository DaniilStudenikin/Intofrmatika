CREATE TABLE IF NOT EXISTS persistent_logins(
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null ,
    last_used varchar(64) not null ,
    primary key (series)
);