CREATE TABLE IF NOT EXISTS budgets (
    id           BIGINT        NOT NULL AUTO_INCREMENT,
    user_id      BIGINT        NOT NULL,
    category_id  BIGINT        NOT NULL,
    amount_limit DECIMAL(15,2) NOT NULL,
    start_date   DATE          NOT NULL,
    end_date     DATE          NOT NULL,

    PRIMARY KEY (id),
    INDEX idx_budgets_user_id     (user_id),
    INDEX idx_budgets_category_id (category_id),
    INDEX idx_budgets_date_range  (start_date, end_date),

    CONSTRAINT chk_budgets_date_range
        CHECK (end_date > start_date),

    CONSTRAINT chk_budgets_amount_limit
        CHECK (amount_limit > 0),

    CONSTRAINT fk_budgets_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_budgets_category
        FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;