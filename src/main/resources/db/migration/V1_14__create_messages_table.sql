CREATE TABLE IF NOT EXISTS messages (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    text text,
    created_at timestamp default now(),

    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    job_cv_id int,
    INDEX job_cv_ind (job_cv_id),
    FOREIGN KEY (job_cv_id)
        REFERENCES jobs_cvs(id)
        ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;