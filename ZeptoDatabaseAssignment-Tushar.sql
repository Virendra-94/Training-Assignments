
-- Database Design - Zepto (Atomic Version)
-- Name - Tushar Kumawat
-- Employee code - 00134984

-- Create database
CREATE DATABASE zepto_app;
USE zepto_app;

-- Table: User (atomic form)
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50),
    state VARCHAR(50)
);

-- Table: Product
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10, 2)
);

-- Table: Orders
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2),
    delivery_status VARCHAR(30),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Table: OrderItem
CREATE TABLE OrderItem (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

-- Table: DeliveryAgent (atomic form)
CREATE TABLE DeliveryAgent (
    agent_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15)
);

-- Table: DeliveryAssignment
CREATE TABLE DeliveryAssignment (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    agent_id INT,
    assigned_time DATETIME,
    delivery_time DATETIME,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (agent_id) REFERENCES DeliveryAgent(agent_id)
);

-- Insert Users (atomic values)
INSERT INTO User (first_name, last_name, phone_number, email, city, state) VALUES
('Ravi', 'Sharma', '9876543210', 'ravi.sharma@gmail.com', 'Mumbai', 'Maharashtra'),
('Sneha', 'Kapoor', '9898989898', 'sneha.kapoor@gmail.com', 'Delhi', 'Delhi'),
('Vikram', 'Rao', '9123456780', 'vikram.rao@gmail.com', 'Bangalore', 'Karnataka'),
('Pooja', 'Jain', '9999999999', 'pooja.jain@gmail.com', 'Jaipur', 'Rajasthan'),
('Amit', 'Desai', '9871234560', 'amit.desai@gmail.com', 'Ahmedabad', 'Gujarat');

-- Insert Products
INSERT INTO Product (product_name, category, price) VALUES
('Amul Milk 1L', 'Dairy', 60.00),
('Fortune Rice Bran Oil 1L', 'Groceries', 150.00),
('Surf Excel Detergent 1kg', 'Household', 220.00),
('Tata Salt 1kg', 'Groceries', 25.00),
('Parle-G Biscuit 800g', 'Snacks', 50.00);

-- Insert Orders
INSERT INTO Orders (user_id, total_amount, delivery_status) VALUES
(1, 235.00, 'Delivered'),
(2, 275.00, 'Out for delivery'),
(3, 60.00, 'Pending'),
(4, 250.00, 'Delivered'),
(5, 50.00, 'Delivered');

-- Insert Order Items
INSERT INTO OrderItem (order_id, product_id, quantity) VALUES
(1, 1, 2),
(1, 5, 1),
(2, 2, 1),
(2, 4, 2),
(3, 1, 1),
(4, 3, 1),
(5, 5, 1);

-- Insert Delivery Agents (atomic names)
INSERT INTO DeliveryAgent (first_name, last_name, phone_number) VALUES
('Arjun', 'Singh', '8888888888'),
('Neha', 'Rathi', '7777777777'),
('Rohit', 'Mehra', '6666666666');

-- Insert Delivery Assignments
INSERT INTO DeliveryAssignment (order_id, agent_id, assigned_time, delivery_time) VALUES
(1, 1, '2025-07-05 10:00:00', '2025-07-05 10:45:00'),
(2, 2, '2025-07-06 11:00:00', NULL),
(4, 3, '2025-07-05 09:00:00', '2025-07-05 09:30:00'),
(5, 1, '2025-07-04 08:00:00', '2025-07-04 08:40:00');

-- DML OPERATIONS

-- 1. Update delivery status
UPDATE Orders SET delivery_status = 'Delivered' WHERE order_id = 2;

-- 2. Change user's phone number
UPDATE User SET phone_number = '9870001112' WHERE user_id = 3;

-- 3. Delete an order item entry
DELETE FROM OrderItem WHERE order_item_id = 3;

-- 4. Add new product and order it
INSERT INTO Product (product_name, category, price) VALUES ('Red Label Tea 250g', 'Groceries', 80.00);
INSERT INTO Orders (user_id, total_amount, delivery_status) VALUES (1, 80.00, 'Pending');
INSERT INTO OrderItem (order_id, product_id, quantity) VALUES (6, 6, 1);

-- 5. Get all orders with user and agent info
SELECT o.order_id,
       CONCAT(u.first_name, ' ', u.last_name) AS customer,
       CONCAT(da.first_name, ' ', da.last_name) AS agent,
       o.delivery_status, o.total_amount
FROM Orders o
JOIN User u ON o.user_id = u.user_id
LEFT JOIN DeliveryAssignment d ON o.order_id = d.order_id
LEFT JOIN DeliveryAgent da ON d.agent_id = da.agent_id;

-- 6. Count orders per user
SELECT CONCAT(u.first_name, ' ', u.last_name) AS customer_name,
       COUNT(o.order_id) AS total_orders
FROM User u
JOIN Orders o ON u.user_id = o.user_id
GROUP BY customer_name;

-- 7. List products in each order
SELECT o.order_id, p.product_name, oi.quantity
FROM OrderItem oi
JOIN Product p ON oi.product_id = p.product_id
JOIN Orders o ON oi.order_id = o.order_id
ORDER BY o.order_id;
