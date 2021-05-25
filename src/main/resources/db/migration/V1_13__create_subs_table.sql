CREATE TABLE IF NOT EXISTS subs (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    count int default 0,
    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE,

    sphere_id int,
    INDEX sphere_ind (sphere_id),
    FOREIGN KEY (sphere_id)
    REFERENCES spheres(id)
    ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;