CREATE TABLE IF NOT EXISTS users (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(200) unique,
    password varchar(200),
    name varchar(200) null,
    phone varchar(200) null,
    image text null,
    description text null
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;