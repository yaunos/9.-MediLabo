CREATE DATABASE IF NOT EXISTS medilabo;
USE medilabo;

CREATE TABLE patient
(
    id INT PRIMARY KEY NOT NULL auto_increment,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
	date_of_birth DATE NOT NULL,
	gender VARCHAR(30) NOT NULL,
    address VARCHAR(30) NOT NULL,
	phone_number VARCHAR(30) NOT NULL
);


INSERT INTO `patient` (`firstname`, `lastname`, `date_of_birth`, `gender`, `address`, `phone_number`) VALUES ('Test', 'TestNone', '1966-12-31', 'F', '1 Brookside St','100-222-3333');
INSERT INTO `patient` (`firstname`, `lastname`, `date_of_birth`, `gender`, `address`, `phone_number`) VALUES ('Test', 'TestBorderline', '1945-06-24', 'M', '2 High St','200-333-4444');
INSERT INTO `patient` (`firstname`, `lastname`, `date_of_birth`, `gender`, `address`, `phone_number`) VALUES ('Test', 'TestInDanger', '2004-06-18', 'M', '3 Club Road','300-444-5555');
INSERT INTO `patient` (`firstname`, `lastname`, `date_of_birth`, `gender`, `address`, `phone_number`) VALUES ('Test', 'TestEarlyOnSet', '2002-06-28', 'F', '4 Valley Dr','400-555-6666');