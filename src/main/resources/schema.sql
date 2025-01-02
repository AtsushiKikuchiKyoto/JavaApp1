CREATE TABLE IF NOT EXISTS posts (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    memo VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS issues (
    id      INT    NOT NULL AUTO_INCREMENT,
    title   VARCHAR(256) NOT NULL,
    content VARCHAR(256) NOT NULL,
    period  VARCHAR(256) NOT NULL,
    importance VARCHAR(256) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS groupDemo (
    id     INT    NOT NULL AUTO_INCREMENT,
    name   VARCHAR(256) NOT NULL,
    info   VARCHAR(256) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS finbookDemo (
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(256) NOT NULL,
    fiscal_year YEAR         NOT NULL,
    start_date  DATE         NOT NULL,
    end_date    DATE         NOT NULL,
    group_id    INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (group_id) REFERENCES groupDemo (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);