
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(513) NOT NULL

);

INSERT INTO users(name, password) VALUES
  ('transbank', 'R/4tXNKwvOtgKWdeuBQaeI/LxxJQGyCjqakVIQ4itOCCn5mP9AF5lrpzo3P9SKD1f5txQ/5n4shJdkDbYjFjZA==');