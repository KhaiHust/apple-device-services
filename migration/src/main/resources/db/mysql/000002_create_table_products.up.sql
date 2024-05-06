CREATE TABLE `products` (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name TEXT NOT NULL,
                            code VARCHAR(20) NOT NULL,
                            description TEXT,
                            banner_img TEXT NOT NULL,
                            status VARCHAR(10),
                            warranty_duration BIGINT NOT NULL,
                            type VARCHAR(20) NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `images` (
                          `id` int PRIMARY KEY AUTO_INCREMENT,
                          `product_id` int,
                          `img` text,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

ALTER TABLE `images` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);