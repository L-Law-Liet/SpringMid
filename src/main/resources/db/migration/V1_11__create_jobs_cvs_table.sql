CREATE TABLE IF NOT EXISTS jobs_cvs (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_applied int default 0,
    cv_applied int default 0,

    cv_id int,
    INDEX cv_ind (cv_id),
    FOREIGN KEY (cv_id)
    REFERENCES cvs(id)
    ON DELETE CASCADE,

    job_id int,
    INDEX job_ind (job_id),
    FOREIGN KEY (job_id)
        REFERENCES jobs(id)
        ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;