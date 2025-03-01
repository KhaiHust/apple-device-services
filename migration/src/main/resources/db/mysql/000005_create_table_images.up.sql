CREATE TABLE images
(
    `id`        int PRIMARY KEY AUTO_INCREMENT,
    `entity_id` int          NOT NULL,
    `img`       text         NOT NULL,
    `type`      varchar(255) NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;