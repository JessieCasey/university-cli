Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('John', 'Doe', 'ASSISTANT', 10000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Jane', 'Doe', 'ASSOCIATE_PROFESSOR', 20000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Bob', 'Smith', 'PROFESSOR', 30000);

Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Mary', 'Lee', 'ASSOCIATE_PROFESSOR', 25000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('David', 'Kim', 'PROFESSOR', 35000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Emily', 'Chen', 'ASSISTANT', 11000);

Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Samantha', 'Johnson', 'ASSISTANT', 12000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Chris', 'Wilson', 'ASSOCIATE_PROFESSOR', 22000);
Insert into Lector (lector_first_name, lector_last_name, lector_degree, salary_in_usd) values ('Laura', 'Anderson', 'PROFESSOR', 32000);

Insert into Department (department_name, head_of_department_id) values ('Computer Science', 1);
Insert into Department (department_name, head_of_department_id) values ('Mathematics', 2);
Insert into Department (department_name, head_of_department_id) values ('Physics', 3);
Insert into Department (department_name, head_of_department_id) values ('History', 6);

Insert into Lector_Departments (lector_id, department_id) values (1, 1);
Insert into Lector_Departments (lector_id, department_id) values (2, 2);
Insert into Lector_Departments (lector_id, department_id) values (3, 3);
Insert into Lector_Departments (lector_id, department_id) values (4, 1);
Insert into Lector_Departments (lector_id, department_id) values (5, 2);
Insert into Lector_Departments (lector_id, department_id) values (6, 3);
Insert into Lector_Departments (lector_id, department_id) values (7, 4);
Insert into Lector_Departments (lector_id, department_id) values (8, 2);
Insert into Lector_Departments (lector_id, department_id) values (9, 3);