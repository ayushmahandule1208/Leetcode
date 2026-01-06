SELECT employeeuni.unique_id, employees.name 
FROM Employees 
LEFT JOIN EmployeeUNI 
ON employees.id = employeeuni.id;
