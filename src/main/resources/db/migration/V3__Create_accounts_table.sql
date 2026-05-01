CREATE TABLE IF NOT EXISTS accounts (
    id           BIGINT        NOT NULL AUTO_INCREMENT,
    user_id      BIGINT        NOT NULL,
    account_name VARCHAR(150)  NOT NULL,
    account_type ENUM(
                     'SAVINGS',
                     'CHECKING',
                     'CREDIT_CARD',
                     'CASH',
                     'INVESTMENT',
                     'LOAN',
                     'WALLET'
                 )             NOT NULL,
    balance      DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    created_at   TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    INDEX idx_accounts_user_id      (user_id),
    INDEX idx_accounts_account_type (account_type),

    CONSTRAINT fk_accounts_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;