
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    publication_year INT,
    copies_total INT DEFAULT 1
);

CREATE TABLE author (
    author_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE book_author (
    book_id INT,
    author_id INT,

    PRIMARY KEY (book_id, author_id),

    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books(book_id),

    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(author_id)
        
);

CREATE TABLE student (
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE
);

CREATE TABLE library_staff (
    staff_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE reservation_status (
    status_id SERIAL PRIMARY KEY,
    status_value VARCHAR(30)
);

CREATE TABLE reservation (
    reservation_id SERIAL PRIMARY KEY,
    book_id INT,
    student_id INT,
    reservation_date DATE,
    status_id INT,

    CONSTRAINT fk_reservation_book FOREIGN KEY (book_id) REFERENCES books(book_id),

    CONSTRAINT fk_reservation_student FOREIGN KEY (student_id) REFERENCES student(student_id),

    CONSTRAINT fk_reservation_status FOREIGN KEY (status_id) REFERENCES reservation_status(status_id)
);

CREATE TABLE borrow (
    borrow_id SERIAL PRIMARY KEY,
    book_id INT,
    student_id INT,
    borrow_date DATE,
    issued_by_staff_id INT,

    CONSTRAINT fk_borrow_book FOREIGN KEY (book_id) REFERENCES books(book_id),

    CONSTRAINT fk_borrow_student FOREIGN KEY (student_id) REFERENCES student(student_id),

    CONSTRAINT fk_borrow_staff FOREIGN KEY (issued_by_staff_id) REFERENCES library_staff(staff_id)
);

CREATE TABLE return_book (
    return_id SERIAL PRIMARY KEY,
    borrow_id INT UNIQUE NOT NULL,
    return_date DATE NOT NULL,
    received_by_staff_id INT,

    CONSTRAINT fk_return_borrow FOREIGN KEY (borrow_id) REFERENCES borrow(borrow_id),

    CONSTRAINT fk_return_staff FOREIGN KEY (received_by_staff_id) REFERENCES library_staff(staff_id)
);

CREATE TABLE fine (
    fine_id SERIAL PRIMARY KEY,
    student_id INT,
    borrow_id INT,
    fine_date DATE,
    fine_amount NUMERIC(10,2),

    CONSTRAINT fk_fine_student FOREIGN KEY (student_id) REFERENCES student(student_id),

    CONSTRAINT fk_fine_borrow FOREIGN KEY (borrow_id) REFERENCES borrow(borrow_id)
);

CREATE TABLE fine_payment (
    payment_id SERIAL PRIMARY KEY,
    student_id INT,
    payment_date DATE,
    payment_amount NUMERIC(10,2),

    CONSTRAINT fk_payment_student FOREIGN KEY (student_id) REFERENCES student(student_id)
);

--Books DML
INSERT INTO books (title, publication_year, copies_total)
VALUES ('çalıkuşu', 1922, 5);

INSERT INTO books (title, publication_year, copies_total)
VALUES ('kuyucaklı yusuf', 1937, 3);

INSERT INTO books (title, publication_year, copies_total)
VALUES ('Head First Java (3rd Edition)', 2021,2);

SELECT * from books 

UPDATE books SET copies_total = 10
WHERE book_id = 1;

SELECT * FROM books ORDER BY publication_year DESC;

SELECT * FROM books WHERE title LIKE '%çalıkuşu%';

--Author DML

INSERT INTO author (first_name, last_name) VALUES ('Ahmet', 'Ümit');
INSERT INTO author (first_name, last_name) VALUES ('Reşat', 'Güntekin');

DELETE FROM author WHERE author_id = 5;

UPDATE author SET first_name = 'Reşat Nuri' WHERE author_id = 2;

SELECT COUNT(*) FROM author;

SELECT * FROM author WHERE first_name LIKE 'R%';

-- Book_author dml
INSERT INTO book_author (book_id, author_id) VALUES (2, 3);
INSERT INTO book_author (book_id, author_id) VALUES (3, 4);
INSERT INTO book_author (book_id, author_id) VALUES (3, 7);

SELECT * FROM book_author

DELETE FROM book_author WHERE book_id = 2 AND author_id = 3;

SELECT b.title,a.first_name,a.last_name
FROM books b
JOIN book_author ba ON b.book_id = ba.book_id
JOIN author a ON ba.author_id = a.author_id;

-- Student dml 
INSERT INTO student (first_name, last_name, email) VALUES ('Kevser','Kahraman','kevser@gmail.com');
INSERT INTO student (first_name, last_name, email) VALUES ('Ayşe','Ayşe','ayse@gmail.com');

UPDATE student SET email = 'kevser.k@gmail.com' WHERE student_id = 1;

SELECT COUNT(*) AS gmail_kullananlar FROM student WHERE email LIKE '%gmail.com';

SELECT COUNT(*) AS toplam_ogrenci FROM student;

SELECT * FROM student ORDER BY student_id DESC;

--library_staff dml

INSERT INTO library_staff (first_name, last_name) VALUES ('AYŞE', 'Yılmaz');
INSERT INTO library_staff (first_name, last_name) VALUES ('Ali', 'Yılmaz');
INSERT INTO library_staff (first_name, last_name) VALUES ('Oya', 'Yıldız');

SELECT * FROM library_staff WHERE last_name LIKE '%Y%';

SELECT * FROM library_staff ORDER BY first_name ASC;

SELECT * FROM library_staff WHERE last_name LIKE '%ı%' ORDER BY first_name ASC;

UPDATE library_staff SET last_name = 'Yıldız' WHERE staff_id = 1;

--reservation_status dml

INSERT INTO reservation_status (status_value) VALUES ('Beklemede');
INSERT INTO reservation_status (status_value) VALUES ('Approved');
INSERT INTO reservation_status (status_value) VALUES ('Cancelled');
INSERT INTO reservation_status (status_value) VALUES ('Pending');

UPDATE reservation_status SET status_value = 'Rejected' WHERE status_id = 3;

SELECT * FROM reservation_status;

DELETE FROM reservation_status WHERE status_id = 4;

--reservation dml

INSERT INTO reservation (book_id, student_id, reservation_date, status_id) VALUES (2, 2, CURRENT_DATE, 1);
INSERT INTO reservation (book_id, student_id, reservation_date, status_id) VALUES (2, 1, CURRENT_DATE, 1);
INSERT INTO reservation (book_id, student_id, reservation_date, status_id)VALUES (1, 1, CURRENT_DATE, 2);

SELECT * FROM reservation;

UPDATE reservation SET status_id = 2 WHERE reservation_id = 1;

DELETE FROM reservation WHERE reservation_id = 2;

SELECT book_id,COUNT(*) AS rezervasyon_sayisi FROM reservation GROUP BY book_id;

--borrow dml
INSERT INTO borrow (book_id, student_id, borrow_date, issued_by_staff_id)
VALUES (1, 1, CURRENT_DATE, 1);

INSERT INTO borrow (book_id, student_id, borrow_date, issued_by_staff_id)
VALUES (2, 1, CURRENT_DATE, 1);

INSERT INTO borrow (book_id, student_id, borrow_date, issued_by_staff_id)
VALUES (2, 2, CURRENT_DATE, 1);

DELETE FROM borrow WHERE borrow_id = 2

SELECT * FROM borrow ORDER BY borrow_date DESC;

SELECT student_id, COUNT(*) AS toplam_odunc FROM borrow GROUP BY student_id;

--return_book dml
INSERT INTO return_book (borrow_id, return_date, received_by_staff_id) VALUES (1, '2025-05-10', 2);
INSERT INTO return_book (borrow_id, return_date, received_by_staff_id) VALUES (3, '2025-05-11', 2);

SELECT * FROM return_book;
SELECT * FROM return_book WHERE return_date > '2025-01-01';
SELECT borrow_id, return_date FROM return_book ORDER BY return_date DESC;
SELECT COUNT(*) FROM return_book;
SELECT * FROM return_book WHERE received_by_staff_id IS NOT NULL;

UPDATE return_book SET received_by_staff_id = 2 WHERE return_id = 1;

--fine dml
INSERT INTO fine (student_id, borrow_id, fine_date, fine_amount) VALUES (1, 1, '2025-05-12', 50.00);

SELECT * FROM fine;
SELECT * FROM fine WHERE fine_amount > 50;
SELECT student_id, SUM(fine_amount) FROM fine GROUP BY student_id;
SELECT AVG(fine_amount) FROM fine;
SELECT * FROM fine ORDER BY fine_date DESC;

UPDATE fine SET fine_amount = 75.50 WHERE fine_id = 1;

--fine_payment dml

INSERT INTO fine_payment (student_id, payment_date, payment_amount) VALUES (1, '2025-05-15', 20.00);

SELECT * FROM fine_payment;
SELECT * FROM fine_payment WHERE payment_amount > 100;
SELECT student_id, SUM(payment_amount) FROM fine_payment GROUP BY student_id;
SELECT COUNT(*) FROM fine_payment;
SELECT * FROM fine_payment ORDER BY payment_date ASC;

UPDATE fine_payment SET payment_amount = 35.00 WHERE payment_id = 1;