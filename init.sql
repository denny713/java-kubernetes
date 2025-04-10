\c test;

CREATE TABLE IF NOT EXISTS object_data (
    sequence BIGINT NOT NULL PRIMARY KEY,
    message_desc VARCHAR(50),
    price NUMERIC
);