CREATE TABLE order_lines
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
   `order_id`            int REFERENCES orders(id),
    `code`             varchar(255) NOT NULL,
    `state`            varchar(255) NOT NULL,
    `payment_method`   varchar(255) NOT NULL,
    `total_price`      decimal(10,2) NOT NULL,
    `payment_state`   varchar(255),
    `shipping_info_id` int NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;
