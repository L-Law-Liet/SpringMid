CREATE TABLE IF NOT EXISTS jobs (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(200),
    salary int,
    xp int,
    skills longtext,
    description text,
    created_at timestamp default now(),

    sphere_id int,
    INDEX sphere_ind (sphere_id),
    FOREIGN KEY (sphere_id)
    REFERENCES spheres(id)
    ON DELETE CASCADE,

    city_id int,
    INDEX city_ind (city_id),
    FOREIGN KEY (city_id)
        REFERENCES cities(id)
        ON DELETE CASCADE,

    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    type_id int,
    INDEX type_ind (type_id),
    FOREIGN KEY (type_id)
        REFERENCES types(id)
        ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;