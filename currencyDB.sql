DROP TABLE IF EXISTS Currency;
USE currencydb;

CREATE TABLE Currency (
    abbreviation VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    rateToUSD DECIMAL(10,4) NOT NULL
);

INSERT INTO Currency (abbreviation, name, rateToUSD) VALUES
    ('USD', 'US Dollar', 1.0000),
    ('EUR', 'Euro', 0.9200),
    ('GBP', 'British Pound', 0.8100),
    ('JPY', 'Japanese Yen', 109.5000),
    ('CAD', 'Canadian Dollar', 1.3200),
    ('AUD', 'Australian Dollar', 1.4500),
    ('CHF', 'Swiss Franc', 0.9100),
    ('CNY', 'Chinese Yuan', 6.7800);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON currencyDB.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;