CREATE TABLE IF NOT EXISTS cvs (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(200),
    image text null,
    salary int,
    xp int,
    skills longtext,
    description text,

    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;