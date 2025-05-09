-- Restaurant Table
CREATE TABLE restaurant (
                            restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(255) NOT NULL,
                            address VARCHAR(255),
                            phone_number VARCHAR(20),
                            cuisine_type VARCHAR(50),
                            opening_hours TIME,
                            closing_hours TIME,
                            capacity INT,
                            description TEXT,
                            image_url VARCHAR(255)
);

-- Table Table
CREATE TABLE restaurant_table (
                                  table_id INT PRIMARY KEY AUTO_INCREMENT,
                                  restaurant_id INT NOT NULL,
                                  table_number VARCHAR(50) NOT NULL,
                                  capacity INT NOT NULL,
                                  table_type VARCHAR(50),
                                  FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id)
);

-- User Table
CREATE TABLE user (
                      user_id INT PRIMARY KEY AUTO_INCREMENT,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(50) NOT NULL
);

-- Customer Table
CREATE TABLE customer (
                          customer_id INT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          phone_number VARCHAR(20),
                          registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          user_id INT,
                          FOREIGN KEY (user_id) REFERENCES user(user_id)
);

-- Reservation Table
CREATE TABLE reservation (
                             reservation_id INT PRIMARY KEY AUTO_INCREMENT,
                             customer_id INT NOT NULL,
                             restaurant_id INT NOT NULL,
                             table_id INT NOT NULL,
                             reservation_date_time DATETIME NOT NULL,
                             party_size INT NOT NULL,
                             status VARCHAR(50) DEFAULT 'Pending',
                             special_requests TEXT,
                             user_id INT,
                             creation_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             last_modified_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                             FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id),
                             FOREIGN KEY (table_id) REFERENCES restaurant_table(table_id),
                             FOREIGN KEY (user_id) REFERENCES user(user_id)
);

-- Payment Table
CREATE TABLE payment (
                         payment_id INT PRIMARY KEY AUTO_INCREMENT,
                         reservation_id INT NOT NULL,
                         payment_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         payment_amount DECIMAL(10, 2) NOT NULL,
                         payment_method VARCHAR(50) NOT NULL,
                         transaction_id VARCHAR(255),
                         payment_status VARCHAR(50) DEFAULT 'Pending',
                         currency VARCHAR(10) DEFAULT 'USD',
                         FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id)
);