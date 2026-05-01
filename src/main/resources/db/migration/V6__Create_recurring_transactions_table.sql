CREATE TABLE IF NOT EXISTS recurring_transactions (
    id            BIGINT        NOT NULL AUTO_INCREMENT,
    user_id       BIGINT        NOT NULL,
    category_id   BIGINT,
    account_id    BIGINT        NOT NULL,
    amount        DECIMAL(15,2) NOT NULL,
    frequency     ENUM(
                      'DAILY',
                      'WEEKLY',
                      'BIWEEKLY',
                      'MONTHLY',
                      'QUARTERLY',
                      'YEARLY'
                  )             NOT NULL,
    next_due_date DATE          NOT NULL,
    description   TEXT,

    PRIMARY KEY (id),
    INDEX idx_recurring_user_id       (user_id),
    INDEX idx_recurring_account_id    (account_id),
    INDEX idx_recurring_category_id   (category_id),
    INDEX idx_recurring_next_due_date (next_due_date),

    CONSTRAINT chk_recurring_amount
        CHECK (amount > 0),

    CONSTRAINT fk_recurring_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_recurring_category
        FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_recurring_account
        FOREIGN KEY (account_id)
        REFERENCES accounts (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;