INSERT INTO students (first_name, last_name, faculty, year)
VALUES ('Andrey', 'Yakovlev', 'International relations', 1),
       ('Maksim', 'Smirnov', 'Linguistics', 2),
       ('Alisa', 'Tikhonova', 'Psychology', 1),
       ('Mikhail', 'Gavrilov', 'International relations', 1),
       ('Polina', 'Philippova', 'Linguistics', 3),
       ('Anna', 'Sorokina', 'Psychology', 2),
       ('Konstantin', 'Akimov', 'International Relations', 3),
       ('Elizaveta', 'Kravtsova', 'Linguistics', 1);


INSERT INTO teachers (last_name, first_name, patronymic, subject)
VALUES ('Sokolov', 'Daniil', 'Artemovich', 'English Language'),
       ('Kovaleva', 'Vera', 'Nikolaevna', 'General History'),
       ('Petrov', 'Ivan', 'Maksimovich', 'Philosophy'),
       ('Kopylova', 'Arina', 'Daniilovna', 'Physical Education'),
       ('Filimonova', 'Mariya', 'Romanovna', 'Demography'),
       ('Petrov', 'Ivan', 'Maksimovich', 'Phonetics'),
       ('Kuznetsov', 'Timofey', 'Ivanovich', 'Personality Psychology'),
       ('Stepanova', 'Nadezhda', 'Yaroslavovna', 'Statistics');

INSERT INTO students_teachers
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 1),
       (2, 4),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 4),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4),
       (4, 5),
       (5, 1),
       (5, 4),
       (6, 1),
       (6, 4),
       (6, 7),
       (7, 1),
       (7, 4),
       (7, 8),
       (8, 1),
       (8, 2),
       (8, 3),
       (8, 4);

insert into roles VALUES ( nextval('role_id_seq'), 'ROLE_STUDENT'),
                         ( nextval('role_id_seq'), 'ROLE_TEACHER'),
                         ( nextval('role_id_seq'), 'ROLE_ADMIN');

insert into users values
(nextval('user_id_seq'), 'linda', '$2y$12$iyrKDnRJz6nXRg5YRSqMC.CZs7XxdvDk.Ofq1Rj7bRu7MTmIs3vq6'),
(nextval('user_id_seq'), 'dan', '$2y$12$FCRxysNeUY.mWoMGcqn62emH503Yft3hAtJkeN0KeELfNIIajlMQ2'),
(nextval('user_id_seq'), 'mrsblack', '$2y$12$uzwx/8zkFydbhGuWkwjytuH5A3HWBjzrVY5P0tfI35ApNeDhniZmq');

insert into users_roles values
(1, 3),
(2, 1),
(3, 2);