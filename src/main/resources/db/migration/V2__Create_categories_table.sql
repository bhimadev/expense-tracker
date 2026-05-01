CREATE TABLE IF NOT EXISTS categories (
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    user_id    BIGINT       NOT NULL,
    name       VARCHAR(100) NOT NULL,
    type       ENUM(
                   'INCOME',
                   'EXPENSE',
                   'TRANSFER'
               )            NOT NULL,
    icon       VARCHAR(100),
    color      VARCHAR(20),
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    INDEX idx_categories_user_id (user_id),
    INDEX idx_categories_type    (type),

    CONSTRAINT fk_categories_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;