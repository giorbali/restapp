CREATE TABLE IF NOT EXISTS `patient` (
    `id` BIGINT NOT NULL PRIMARY KEY,
    `first_Name` varchar(50),
    `last_Name` varchar(50),
    `email` varchar(100),
    `phone_Home` varchar(30),
    `phone_Work` varchar(30),
    `gender` varchar(30),
    `birth_date` timestamp
    );

CREATE TABLE IF NOT EXISTS `TREATMENT` (
    `id` BIGINT NOT NULL PRIMARY KEY,
    `patient_id` BIGINT not null,
    `diagnos` varchar(500),
    FOREIGN KEY ( patient_id ) REFERENCES patient (id)
    );

