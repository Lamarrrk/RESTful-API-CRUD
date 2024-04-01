CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    status ENUM('pending', 'in_progress', 'completed')
);

INSERT INTO tasks (title, description, status) VALUES
('Task 1', 'Description for Task 1', 'pending'),
('Task 2', 'Description for Task 2', 'in_progress'),
('Task 3', 'Description for Task 3', 'pending'),
('Task 4', 'Description for Task 4', 'completed'),
('Task 5', 'Description for Task 5', 'pending');