INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES
(1, 'Oleg', DATE '1999-01-01', 'Middle', 4000),
(2, 'Daniel', DATE '1985-01-01', 'Senior', 40000),
(3, 'Tom', DATE '1999-01-01', 'Middle', 4000),
(4, 'Alex', DATE '1990-01-01', 'Senior', 20000),
(5, 'Sasha', DATE '2001-01-01', 'Junior', 900),
(6, 'Danylo', DATE '2004-01-01', 'Trainee', 400),
(7, 'Gaben', DATE '1960-01-01', 'Senior', 99000),
(8, 'John', DATE '1995-01-01', 'Middle', 5000),
(9, 'Raiden', DATE '2003-01-01', 'Junior', 800),
(10, 'Kratos', DATE '2004-05-12', 'Trainee', 500);

INSERT INTO client (ID, NAME) VALUES
(1, 'John'),
(2, 'Amanda'),
(3, 'Vova'),
(4, 'Vlad'),
(5, 'Sarah');

INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, 1, DATE '2021-01-01', DATE '2022-01-01'),
(2, 2, DATE '2021-01-01', DATE '2022-01-01'),
(3, 3, DATE '2021-01-01', DATE '2023-01-01'),
(4, 4, DATE '2021-01-01', DATE '2024-01-01'),
(5, 5, DATE '2022-01-01', DATE '2023-01-01'),
(6, 1, DATE '2022-01-01', DATE '2024-01-01'),
(7, 2, DATE '2020-01-01', DATE '2021-01-01'),
(8, 3, DATE '2020-01-01', DATE '2022-01-01'),
(9, 4, DATE '2020-01-01', DATE '2023-01-01'),
(10, 5, DATE '2020-01-01', DATE '2024-01-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(3, 8),
(4, 9),
(4, 10),
(5, 1),
(5, 2),
(5, 3),
(6, 4),
(6, 5),
(6, 6),
(6, 7),
(7, 8),
(7, 9),
(7, 10),
(8, 1),
(8, 2),
(9, 3),
(9, 6),
(10, 4),
(10, 5);