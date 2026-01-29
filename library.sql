
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    book_author VARCHAR(255) NOT NULL
);

CREATE TABLE bookloan (
    loan_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    book_id INTEGER NOT NULL REFERENCES books(book_id),
    loan_status BOOLEAN NOT NULL DEFAULT FALSE
);


-- drop table table_name; Delete table
-- truncate table table_name; Delete data

--INSERT QUERIES
--Users
INSERT INTO users (user_name) VALUES
('Zack'), ('James'), ('Elias');

--Add Books
INSERT INTO books (book_title, book_author) VALUES
('Song of Fire and Dance', 'George RR Martin'),
('Harry Potter', 'JK Rowlings'),
('The Fault in our Stars', 'John Green'),
('Noli Me Tangere', 'Jose Rizal');

--Loan Policy/Borrow Books
insert into bookloan (user_id, book_id, loan_status) values (1,2,TRUE),(1,1,TRUE);

--Update Books
UPDATE books
SET book_title = 'Test Title',
    book_author = 'Test Author'
WHERE book_id = 2

--SELECT QUERIES

--Show all Books
select * from books;

--Select All Books
SELECT 
  b.book_id,
  b.book_title,
  b.book_author,
  CASE WHEN bl.loan_status is NULL THEN 'Available' ELSE 'Borrowed' END AS Status
FROM books b
left join bookloan bl
on bl.book_id = b.book_id 
ORDER BY book_title;

--Borrowed Books
SELECT
  bl.loan_id,
  b.book_title,
  u.user_id,
  u.user_name
FROM bookloan bl
JOIN books b ON b.book_id = bl.book_id
JOIN users u ON u.user_id = bl.user_id
WHERE bl.loan_status = TRUE
ORDER BY b.book_title;

--Available Books
SELECT
  b.book_id,
  b.book_title,
  b.book_author
FROM books b
WHERE NOT EXISTS (
  SELECT 1
  FROM bookloan bl
  WHERE bl.book_id = b.book_id
    AND bl.loan_status = TRUE
)
ORDER BY b.book_title;


--DELETE DATA
truncate table users cascade;

--DELETE TABLE
drop table bookloan;
