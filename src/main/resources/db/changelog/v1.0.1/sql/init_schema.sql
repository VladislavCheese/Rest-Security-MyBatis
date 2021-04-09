create sequence if not exists student_id_seq start 1;

CREATE TABLE if not exists students (
                          student_id INTEGER DEFAULT nextval('student_id_seq') PRIMARY KEY NOT NULL,
                          first_name VARCHAR(30),
                          last_name VARCHAR(30) NOT NULL,
                          faculty VARCHAR(50) NOT NULL,
                          year INTEGER NOT NULL check (year BETWEEN 1 AND 4)
);
create sequence if not exists teacher_id_seq start 1;

CREATE TABLE if not exists teachers (
                          teacher_id INTEGER DEFAULT nextval('teacher_id_seq') PRIMARY KEY NOT NULL,
                          first_name VARCHAR(30),
                          last_name VARCHAR(30) NOT NULL,
                          patronymic VARCHAR(30),
                          subject VARCHAR NOT NULL
);

CREATE TABLE if not exists students_teachers (
                                   student_id INTEGER references students(student_id),
                                   teacher_id INTEGER references teachers(teacher_id)
);

create sequence if not exists role_id_seq start 1;

create table if not exists roles (
                       role_id INTEGER default nextval('role_id_seq') not null primary key,
                       role_name VARCHAR(50) NOT NULL UNIQUE
);

create sequence if not exists user_id_seq start 1;

create table if not exists users (
                          user_id INTEGER default nextval('user_id_seq') NOT NULL primary key,
                          username VARCHAR(50) NOT NULL UNIQUE,
                          password VARCHAR(150) NOT NULL
);

create table if not exists users_roles (
                             user_id int not null references users(user_id),
                             role_id int not null references roles(role_id)
);
