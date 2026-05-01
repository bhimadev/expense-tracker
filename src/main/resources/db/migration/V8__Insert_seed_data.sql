-- ── Users ────────────────────────────────────────────────
INSERT INTO users (name, email, password, currency_code) VALUES
    ('Alice sharma',  'alice@example.com', '$2a$10$dummyhashedpassword1', 'INR'),
    ('Bob Verma',     'bob@example.com',   '$2a$10$dummyhashedpassword2', 'INR'),
    ('Carol Mehta',   'carol@example.com', '$2a$10$dummyhashedpassword3', 'USD');

-- ── Categories (for user 1) ───────────────────────────────
INSERT INTO categories (user_id, name, type, icon, color) VALUES
    (1, 'Salary',       'INCOME',   'wallet',      '#4CAF50'),
    (1, 'Freelance',    'INCOME',   'laptop',      '#8BC34A'),
    (1, 'Groceries',    'EXPENSE',  'cart',        '#F44336'),
    (1, 'Rent',         'EXPENSE',  'home',        '#FF5722'),
    (1, 'Utilities',    'EXPENSE',  'bolt',        '#FF9800'),
    (1, 'Transport',    'EXPENSE',  'car',         '#2196F3'),
    (1, 'Health',       'EXPENSE',  'heart',       '#E91E63'),
    (1, 'Dining Out',   'EXPENSE',  'restaurant',  '#9C27B0'),
    (1, 'Investment',   'TRANSFER', 'trending-up', '#00BCD4'),
    (1, 'Savings',      'TRANSFER', 'piggy-bank',  '#3F51B5');

-- ── Accounts (for user 1) ─────────────────────────────────
INSERT INTO accounts (user_id, account_name, account_type, balance) VALUES
    (1, 'HDFC Savings',     'SAVINGS',     125000.00),
    (1, 'ICICI Checking',   'CHECKING',     45000.00),
    (1, 'SBI Credit Card',  'CREDIT_CARD',  -8500.00),
    (1, 'Cash Wallet',      'CASH',          3200.00),
    (1, 'Zerodha Demat',    'INVESTMENT',  250000.00);

-- ── Transactions (for user 1) ─────────────────────────────
INSERT INTO transactions
    (user_id, account_id, category_id, amount, type, description, transaction_date)
VALUES
    (1, 1, 1,  85000.00, 'INCOME',   'Monthly salary April',       '2025-04-01 09:00:00'),
    (1, 1, 3,   4500.00, 'EXPENSE',  'Big Basket grocery order',   '2025-04-03 11:30:00'),
    (1, 1, 4,  18000.00, 'EXPENSE',  'Monthly rent payment',       '2025-04-05 10:00:00'),
    (1, 1, 5,   2200.00, 'EXPENSE',  'Electricity bill',           '2025-04-07 14:00:00'),
    (1, 2, 6,    850.00, 'EXPENSE',  'Uber rides this week',       '2025-04-10 08:45:00'),
    (1, 3, 8,   1200.00, 'EXPENSE',  'Dinner at Barbeque Nation',  '2025-04-12 20:00:00'),
    (1, 1, 2,  15000.00, 'INCOME',   'Freelance project payment',  '2025-04-15 16:00:00'),
    (1, 1, 7,   3500.00, 'EXPENSE',  'Apollo pharmacy medicines',  '2025-04-18 12:00:00'),
    (1, 5, 9,  20000.00, 'TRANSFER', 'SIP investment this month',  '2025-04-20 09:30:00'),
    (1, 1, 10, 10000.00, 'TRANSFER', 'Transfer to savings pot',    '2025-04-25 17:00:00');

-- ── Budgets (for user 1) ──────────────────────────────────
INSERT INTO budgets (user_id, category_id, amount_limit, start_date, end_date) VALUES
    (1, 3,  6000.00, '2025-04-01', '2025-04-30'),   -- Groceries budget
    (1, 4, 18000.00, '2025-04-01', '2025-04-30'),   -- Rent budget
    (1, 5,  3000.00, '2025-04-01', '2025-04-30'),   -- Utilities budget
    (1, 6,  2000.00, '2025-04-01', '2025-04-30'),   -- Transport budget
    (1, 8,  2500.00, '2025-04-01', '2025-04-30');   -- Dining Out budget

-- ── Recurring Transactions (for user 1) ───────────────────
INSERT INTO recurring_transactions
    (user_id, category_id, account_id, amount, frequency, next_due_date, description)
VALUES
    (1, 4,  1, 18000.00, 'MONTHLY',  '2025-05-05', 'Monthly rent to landlord'),
    (1, 9,  1, 20000.00, 'MONTHLY',  '2025-05-20', 'Zerodha SIP auto-debit'),
    (1, 5,  1,  1500.00, 'MONTHLY',  '2025-05-07', 'Internet bill - JioFiber'),
    (1, 6,  2,   500.00, 'WEEKLY',   '2025-05-05', 'Weekly commute fuel'),
    (1, 1,  1, 85000.00, 'MONTHLY',  '2025-05-01', 'Monthly salary credit');

-- ── Attachments ───────────────────────────────────────────
INSERT INTO attachments (transaction_id, file_url) VALUES
    (3, 'https://storage.example.com/receipts/rent-april-2025.pdf'),
    (5, 'https://storage.example.com/receipts/electricity-april-2025.jpg'),
    (8, 'https://storage.example.com/receipts/apollo-april-2025.png');