-- Table to store user information
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Store hashed passwords for security
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    role_id INT, -- References the Roles table
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table to define user roles (e.g., admin, customer, etc.)
CREATE TABLE Roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE -- Example: "Admin", "Customer", etc.
);

-- Table to store account information
CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL, -- References Users table
    account_type VARCHAR(50) NOT NULL, -- Example: "Savings", "Checking"
    balance DECIMAL(15, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table to store transaction history
CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL, -- References Accounts table
    transaction_type VARCHAR(50) NOT NULL, -- Example: "Deposit", "Withdrawal", "Transfer"
    amount DECIMAL(15, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description TEXT,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table to store login attempts or authentication logs
CREATE TABLE LoginAttempts (
    login_attempt_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL, -- References Users table
    login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL, -- Example: "Success", "Failure"
    ip_address VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);