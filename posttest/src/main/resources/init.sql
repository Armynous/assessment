-- Create a table for regular users
CREATE TABLE IF NOT EXISTS "user" (
    user_id VARCHAR(10) PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL
);

-- Create a table for administrators
CREATE TABLE IF NOT EXISTS admin (
    admin_id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create a table for lottery tickets
CREATE TABLE IF NOT EXISTS lottery (
    ticket VARCHAR(6) NOT NULL PRIMARY KEY,
    price INT NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE user_lottery (
    user_lottery_id SERIAL PRIMARY KEY NOT NULL,
    user_id VARCHAR(10) REFERENCES "user"(user_id),
    ticket VARCHAR(6) REFERENCES lottery(ticket),
    purchase_date TIMESTAMP NOT NULL
);

-- Insert a sample user
INSERT INTO "user" (user_id, username)
VALUES ('0123456789', 'john_doe');

-- Insert a sample admin
INSERT INTO admin (username, password)
VALUES ('admin_user', 'hashed_password_for_admin');
