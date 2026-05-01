CREATE TABLE IF NOT EXISTS attachments (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    transaction_id BIGINT       NOT NULL,
    file_url       VARCHAR(500) NOT NULL,
    uploaded_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    INDEX idx_attachments_transaction_id (transaction_id),

    CONSTRAINT fk_attachments_transaction
        FOREIGN KEY (transaction_id)
        REFERENCES transactions (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;