CREATE DATABASE blood_pressure_calculator_db DEFAULT CHARACTER SET utf8;
CREATE USER 'blood-pressure-calculator-user'@'localhost' IDENTIFIED BY 'problemSolvers!@2';
GRANT ALL PRIVILEGES ON blood_pressure_calculator_db.* TO 'blood-pressure-calculator-user'@'localhost';
FLUSH PRIVILEGES;