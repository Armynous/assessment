-- Create a table for regular users
CREATE TABLE IF NOT EXISTS "user" (
    user_id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create a table for administrators
CREATE TABLE IF NOT EXISTS admin (
    admin_id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create a table for lottery tickets
CREATE TABLE IF NOT EXISTS lottery (
    lottery_id BIGSERIAL PRIMARY KEY,
    ticket VARCHAR(6) NOT NULL,
    price INT NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE user_lottery (
    user_lottery_id SERIAL PRIMARY KEY NOT NULL,
    user_id SERIAL REFERENCES "user"(user_id),
    lottery_id BIGSERIAL REFERENCES lottery(lottery_id),
    purchase_date TIMESTAMP NOT NULL
);

-- Insert a sample user
INSERT INTO "user" (username, email, password)
VALUES ('john_doe', 'john@example.com', 'hashed_password_for_john');

-- Insert a sample admin
INSERT INTO admin (username, email, password)
VALUES ('admin_user', 'admin@example.com', 'hashed_password_for_admin');

-- Insert a sample lottery ticket
INSERT INTO lottery (ticket, price, amount)
VALUES ('212212', 80, 1);

-- Sample user purchases a lottery
INSERT INTO user_lottery (purchase_date)
VALUES (CURRENT_TIMESTAMP);