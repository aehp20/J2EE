CREATE SEQUENCE seq_course;
CREATE SEQUENCE seq_student;
CREATE SEQUENCE seq_test;
CREATE SEQUENCE seq_question;
CREATE SEQUENCE seq_alternative;

CREATE TABLE IF NOT EXISTS course
(
  id integer NOT NULL DEFAULT nextval('seq_course'),
  name character varying(50) NOT NULL,
  creation_date timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT pk_course PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS student
(
  id integer NOT NULL DEFAULT nextval('seq_student'),
  name character varying(50) NOT NULL,
  email character varying(50),
  login character varying(50),
  password character varying(256),
  creation_date timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course_student
(
  id_course integer NOT NULL,
  id_student integer NOT NULL,
  CONSTRAINT fk_course_student_1 FOREIGN KEY (id_course) REFERENCES course (id),
  CONSTRAINT fk_course_student_2 FOREIGN KEY (id_student) REFERENCES student (id),
  CONSTRAINT unique_course_student UNIQUE (id_course,id_student)
);

CREATE TABLE IF NOT EXISTS test
(
  id integer NOT NULL DEFAULT nextval('seq_test'),
  name character varying(50) NOT NULL,
  creation_date timestamp without time zone NOT NULL DEFAULT now(),
  status boolean NOT NULL DEFAULT FALSE,
  id_course integer NOT NULL,
  CONSTRAINT pk_test PRIMARY KEY (id),
  CONSTRAINT fk_test FOREIGN KEY (id_course) REFERENCES course (id)
);

CREATE TABLE IF NOT EXISTS question
(
  id integer NOT NULL DEFAULT nextval('seq_question'),
  description character varying(1000) NOT NULL,
  value integer NOT NULL DEFAULT 0,
  CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS alternative
(
  id integer NOT NULL DEFAULT nextval('seq_alternative'),
  description character varying(500) NOT NULL,
  is_answer boolean NOT NULL DEFAULT FALSE,
  id_question integer NOT NULL DEFAULT 0,
  CONSTRAINT pk_alternative PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS test_detail
(
  id_test integer NOT NULL,
  id_question integer NOT NULL,
  CONSTRAINT fk_test_detail_1 FOREIGN KEY (id_test) REFERENCES test (id),
  CONSTRAINT fk_test_detail_2 FOREIGN KEY (id_question) REFERENCES question (id),
  CONSTRAINT unique_test_detail UNIQUE (id_test,id_question)
);

CREATE TABLE IF NOT EXISTS student_response
(
  id_test integer NOT NULL,
  id_student integer NOT NULL,
  id_question integer NOT NULL,
  id_alternative integer NOT NULL,
  time_used integer NOT NULL DEFAULT 0,
  CONSTRAINT fk_student_response_1 FOREIGN KEY (id_test) REFERENCES test (id),
  CONSTRAINT fk_student_response_2 FOREIGN KEY (id_student) REFERENCES student (id),
  CONSTRAINT fk_student_response_3 FOREIGN KEY (id_question) REFERENCES question (id),
  CONSTRAINT fk_student_response_4 FOREIGN KEY (id_alternative) REFERENCES alternative (id),
  CONSTRAINT unique_student_response UNIQUE (id_test,id_student,id_question,id_alternative)
);

CREATE TABLE IF NOT EXISTS test_note
(
  id_test integer NOT NULL,
  id_student integer NOT NULL,
  note numeric NOT NULL DEFAULT 0,
  CONSTRAINT fk_test_note_1 FOREIGN KEY (id_test) REFERENCES test (id),
  CONSTRAINT fk_test_note_2 FOREIGN KEY (id_student) REFERENCES student (id),
  CONSTRAINT unique_test_note UNIQUE (id_test,id_student)
);



