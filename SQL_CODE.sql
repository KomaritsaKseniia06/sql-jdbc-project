CREATE TABLE students
(
    student_id bigint PRIMARY KEY not null,
    age        integer,
    firstname  varchar(30)        not null,
    lastname   varchar(30)        not null,
    email      varchar(30)        not null,
    faculty_id bigint             not null REFERENCES faculties
);

CREATE TABLE faculties
(
    faculty_id    bigint PRIMARY KEY not null,
    faculty_title varchar(30)        not null
);

INSERT INTO students (student_id, age, firstname, lastname, email, faculty_id)
VALUES ( 1, 19, 'Mark', 'Brooks', 'markdavis@gmail.com', 2 ),
       (2, 21, 'Leo', 'Duncan', 'leodunkan21@mail.com', 1),
       (3, 20, 'Ciara', 'Ella Harrison', 'harrisonCi@mail.com', 5),
       (4, 18, 'Sophie', 'Ward', 'sophieWard@gmail.com', 6),
       (5, 22, 'Logan', 'Hull', 'logan_hull@mail.com', 4);

INSERT INTO faculties (faculty_id, faculty_title)
VALUES (1, 'Law'),
       (2, 'Computer Since'),
       (3, 'Public Health'),
       (4, 'Education'),
       (5, 'Business'),
       (6, 'Arts & Design');

CREATE TABLE teachers (
                          teacher_id bigint  not null PRIMARY KEY,
                          firstname varchar(30) not null ,
                          lastname varchar(30) not null ,
                          subject_id bigint not null
);

CREATE TABLE subjects (
                          subject_id bigint not null PRIMARY KEY,
                          subject_name varchar(60)
);

ALTER TABLE teachers
    ADD CONSTRAINT fk_subjects FOREIGN KEY (subject_id) REFERENCES subjects (subject_id);

INSERT INTO subjects (subject_id, subject_name)
VALUES (1, 'Math'),
       (2, 'Bioengineering'),
       (3, 'Business Administration and Management'),
       (4, 'Programming'),
       (5,'Art, Film, and Visual Studies');

INSERT INTO teachers (teacher_id, firstname, lastname, subject_id)
VALUES (1, 'Rowan', 'Graham', 2),
       (2, 'Olivia', 'Roberts', 1),
       (3, 'Rachel', 'Dean', 5),
       (4, 'Morgan', 'Eaton', 3),
       (5, 'Joaquin', 'Mayer', 4);