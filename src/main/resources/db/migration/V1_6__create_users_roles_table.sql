CREATE TABLE IF NOT EXISTS users_roles (
    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    role_id int,
    INDEX role_ind (role_id),
    FOREIGN KEY (role_id)
        REFERENCES roles(id)
        ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;