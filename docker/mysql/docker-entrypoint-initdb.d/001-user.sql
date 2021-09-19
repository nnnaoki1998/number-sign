use number_sign_db;

create table user
(
  id int unsigned not null auto_increment,
  name varchar(64) not null,
  email varchar(255) not null unique,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
