CREATE TABLE IF NOT EXISTS `receipt` (
    `id` BIGINT NOT NULL PRIMARY KEY,
    `patient_id` BIGINT not null,
    `diagnos` varchar(100),
    `insurance` varchar(100),
    `insurance_id` varchar(100),
    `doctor_id` varchar(100),
    `issue_date` timestamp,
    `toll_free` int(1),

    FOREIGN KEY ( patient_id ) REFERENCES patient (id)
    );


