CREATE TABLE `products` (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name TEXT,
                            code VARCHAR(20),
                            description TEXT,
                            banner_img_1 TEXT,
                            status VARCHAR(10),
                            warranty_duration BIGINT NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;