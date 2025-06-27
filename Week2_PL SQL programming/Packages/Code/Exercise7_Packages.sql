CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    END;
    PROCEDURE UpdateCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers SET Name = p_name, DOB = p_dob, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
        COMMIT;
    END;
    FUNCTION GetCustomerBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    END;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE);
    PROCEDURE UpdateEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE);
    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hiredate);
        COMMIT;
    END;
    PROCEDURE UpdateEmployee(p_employee_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE) IS
    BEGIN
        UPDATE Employees SET Name = p_name, Position = p_position, Salary = p_salary, Department = p_department, HireDate = p_hiredate
        WHERE EmployeeID = p_employee_id;
        COMMIT;
    END;
    FUNCTION CalculateAnnualSalary(p_employee_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    END;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_account_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_account_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);
        COMMIT;
    END;
    PROCEDURE CloseAccount(p_account_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;
        COMMIT;
    END;
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_total FROM Accounts WHERE CustomerID = p_customer_id;
        RETURN v_total;
    END;
END AccountOperations;
/