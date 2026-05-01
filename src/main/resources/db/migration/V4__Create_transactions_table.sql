CREATE TABLE IF NOT EXISTS transactions (
    id               BIGINT        NOT NULL AUTO_INCREMENT,
    user_id          BIGINT        NOT NULL,
    account_id       BIGINT        NOT NULL,
    category_id      BIGINT,
    amount           DECIMAL(15,2) NOT NULL,
    type             ENUM(
                         'INCOME',
                         'EXPENSE',
                         'TRANSFER'
                     )             NOT NULL,
    description      TEXT,
    transaction_date DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at       TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    INDEX idx_transactions_user_id          (user_id),
    INDEX idx_transactions_account_id       (account_id),
    INDEX idx_transactions_category_id      (category_id),
    INDEX idx_transactions_type             (type),
    INDEX idx_transactions_transaction_date (transaction_date),

    CONSTRAINT fk_transactions_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_transactions_account
        FOREIGN KEY (account_id)
        REFERENCES accounts (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_transactions_category
        FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;