CREATE TABLE IF NOT EXISTS users_jobs (
    user_id int,
    INDEX user_ind (user_id),
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE,

    job_id int,
    INDEX job_ind (job_id),
    FOREIGN KEY (job_id)
    REFERENCES jobs(id)
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;