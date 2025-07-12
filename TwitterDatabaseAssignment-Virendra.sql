
-- Database Design for Twitter with Atomic Columns
-- Name : Virendra Kumar
-- Employee Code: 00134989
-- Email : Virendra.1.Kumar@coforge.com

-- Create database
CREATE DATABASE twitter_x;
USE twitter_x;

-- Updated User Table with atomic name fields
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    bio TEXT,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Tweet Table
CREATE TABLE Tweet (
    tweet_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    content VARCHAR(280),
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Follow Table (many-to-many: user follows another user)
CREATE TABLE Follow (
    follower_id INT,
    followee_id INT,
    follow_date DATE,
    PRIMARY KEY (follower_id, followee_id),
    FOREIGN KEY (follower_id) REFERENCES User(user_id),
    FOREIGN KEY (followee_id) REFERENCES User(user_id)
);

-- Message Table
CREATE TABLE Message (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    recipient_id INT,
    content TEXT,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES User(user_id),
    FOREIGN KEY (recipient_id) REFERENCES User(user_id)
);

-- Insert Users (Indian names split into first and last name)
INSERT INTO User (first_name, last_name, username, bio, email) VALUES 
('Raj', 'Kumar', 'raj_kumar', 'Food lover and traveler', 'raj.kumar@gmail.com'),
('Ananya', 'Singh', 'ananya_singh', 'Student at DU', 'ananya.singh@gmail.com'),
('Arjun', 'Mehra', 'arjun_mehra', 'Tech enthusiast', 'arjun.mehra@gmail.com'),
('Priya', 'Verma', 'priya_verma', 'Photographer from Jaipur', 'priya.verma@gmail.com'),
('Amit', 'Patel', 'amit_patel', 'Cricket fan and blogger', 'amit.patel@gmail.com');

-- Insert Tweets
INSERT INTO Tweet (user_id, content) VALUES 
(1, 'Visited Goa last week, what an amazing place!'),
(2, 'Exam time! DU students, all the best!'),
(3, 'Learning MySQL with real-world projects.'),
(4, 'Sunsets in Jaipur are unreal. #photography'),
(5, 'India vs Pakistan this Sunday, who will win?');

-- Insert Follow records
INSERT INTO Follow (follower_id, followee_id, follow_date) VALUES 
(1, 2, '2025-06-01'),
(2, 3, '2025-06-05'),
(3, 4, '2025-06-10'),
(4, 5, '2025-06-15'),
(5, 1, '2025-06-20');

-- Insert Messages
INSERT INTO Message (sender_id, recipient_id, content) VALUES 
(1, 2, 'Hey Ananya, how was the exam?'),
(2, 1, 'Pretty good, thanks Raj!'),
(3, 4, 'Loved your sunset shot!'),
(4, 3, 'Thanks a lot, Arjun!'),
(5, 1, 'Game night at my place this Sunday?');

-- DML Operations

-- Update bio of user 3
UPDATE User SET bio = 'Tech enthusiast and blogger' WHERE user_id = 3;

-- Delete a follow relation
DELETE FROM Follow WHERE follower_id = 5 AND followee_id = 1;

-- Select all tweets with usernames
SELECT u.username, t.content, t.timestamp 
FROM Tweet t JOIN User u ON t.user_id = u.user_id;

-- Count followers per user
SELECT followee_id, COUNT(follower_id) AS follower_count 
FROM Follow GROUP BY followee_id;

-- Insert a new user and tweet
INSERT INTO User (first_name, last_name, username, bio, email) VALUES 
('Neha', 'Sharma', 'neha_sharma', 'Journalist from Mumbai', 'neha.sharma@gmail.com');

INSERT INTO Tweet (user_id, content) VALUES (
    (SELECT user_id FROM User WHERE username = 'neha_sharma'),
    'Just attended a press conference on AI regulation.'
);

-- Neha follows Ananya
INSERT INTO Follow (follower_id, followee_id, follow_date) VALUES (
    (SELECT user_id FROM User WHERE username = 'neha_sharma'),
    (SELECT user_id FROM User WHERE username = 'ananya_singh'),
    '2025-07-01'
);

-- Neha sends a message to Arjun
INSERT INTO Message (sender_id, recipient_id, content) VALUES (
    (SELECT user_id FROM User WHERE username = 'neha_sharma'),
    (SELECT user_id FROM User WHERE username = 'arjun_mehra'),
    'Hi Arjun, can you share your blog link?'
);

-- Update a tweet's content
UPDATE Tweet SET content = 'Sunsets in Jaipur are absolutely breathtaking!' 
WHERE content LIKE '%Sunsets in Jaipur%';

-- Delete a message (simulate mistake)
DELETE FROM Message 
WHERE content = 'Pretty good, thanks Raj!';

-- Display all messages between Raj and Ananya
SELECT 
    u1.username AS sender,
    u2.username AS recipient,
    m.content, m.timestamp
FROM Message m
JOIN User u1 ON m.sender_id = u1.user_id
JOIN User u2 ON m.recipient_id = u2.user_id
WHERE (u1.username = 'raj_kumar' AND u2.username = 'ananya_singh')
   OR (u1.username = 'ananya_singh' AND u2.username = 'raj_kumar');

-- Count total tweets per user
SELECT u.username, COUNT(t.tweet_id) AS total_tweets
FROM User u
LEFT JOIN Tweet t ON u.user_id = t.user_id
GROUP BY u.username;

-- Display who follows whom with usernames
SELECT u1.username AS follower, u2.username AS followee, f.follow_date
FROM Follow f
JOIN User u1 ON f.follower_id = u1.user_id
JOIN User u2 ON f.followee_id = u2.user_id;

-- Search tweets containing keyword 'India'
SELECT u.username, t.content, t.timestamp
FROM Tweet t
JOIN User u ON t.user_id = u.user_id
WHERE t.content LIKE '%India%';

-- Change email of Arjun
UPDATE User SET email = 'arjun.tech@gmail.com'
WHERE username = 'arjun_mehra';
